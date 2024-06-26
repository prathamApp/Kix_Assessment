package com.kix.assessment.ui.fragment_profile;

import static com.kix.assessment.KIXApplication.householdDao;
import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.studentDao;
import static com.kix.assessment.KIXApplication.villageDao;
import static com.kix.assessment.kix_utils.KIX_Utility.context;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.async.PushDataBaseZipToServer;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_ProfileDetails;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.services.KixSmartSync;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@EFragment(R.layout.fragment_profile)
public class Fragment_Profile extends Fragment implements ProfileContract.ProfileView {

    private final List<Modal_ProfileDetails> detailsList = new ArrayList<>();

    @ViewById(R.id.tv_profileName)
    TextView tv_profileName;
/*    @ViewById(R.id.tv_studCount)
    TextView tv_studCount;

    @ViewById(R.id.tv_householdCount)
    TextView tv_householdCount;*/

    @ViewById(R.id.tv_childTotalCount)
    TextView tv_TotStudCount;

    @ViewById(R.id.tv_childAssessedTotalCount)
    TextView tv_AssessmentGivenCount;

    @ViewById(R.id.tv_villTotalCount)
    TextView tv_totVillageCount;
    @ViewById(R.id.tv_hhTotalCount)
    TextView tv_totHHCount;
    @ViewById(R.id.rv_examDetail)
    RecyclerView rv_examDetail;

    @ViewById(R.id.ll_ageFilterSpinner)
    LinearLayout ll_ageFilterSpinner;

    @ViewById(R.id.ll_villageFilterSpinner)
    LinearLayout ll_villageFilterSpinner;

    @ViewById(R.id.spinner_ageFilter)
    Spinner spinner_ageFilter;

    @ViewById(R.id.spinner_villageFilter)
    Spinner spinner_villageFilter;

    @Bean(ProfilePresenter.class)
    ProfilePresenter profilePresenter;
    private ProfileAdapter profileAdapter;

    String selectedAge, ageSelected, villageSelected, surveyorCode, householdId, villageID;

    //list for villageFilter
    private ArrayList<Modal_Village> villagesList;
    @Bean(PushDataBaseZipToServer.class)
    PushDataBaseZipToServer pushDataBaseZipToServer;
    private TextView tv_dialTitle;
    boolean loaderFlg = false;
    private BlurPopupWindow pushDialog, pushStatusDialogue;
    private TextView tv_dia_vil;
    private TextView tv_dia_survey;
    private TextView tv_dia_stud;
    private TextView tv_dia_vif;
    private TextView tv_dia_hif;
    private TextView tv_dia_pif;
    private TextView tv_dia_score, tv_dia_hhld;
    private CustomLodingDialog myLoadingDialog;


    public Fragment_Profile() {
        // Required empty public constructor
    }

    int assGiven = 0;

    @UiThread
    @Override
    public void showProfileData(List<Modal_ProfileDetails> profileDetails) {
        initializeVillageSpinner(profileDetails);
        //recycler header values
        Modal_ProfileDetails details = new Modal_ProfileDetails(getString(R.string.child_name),
                getString(R.string.str_household), getString(R.string.assessment_given), "Assessment Synced", "", "", "");
        detailsList.add(details);
        if (profileDetails.size() == 0) {
            Toast.makeText(getActivity(), getString(R.string.asmt_not_given), Toast.LENGTH_SHORT).show();
        }
        assGiven = 0;
        for (int i = 0; i < profileDetails.size(); i++) {
            if (Integer.parseInt(profileDetails.get(i).getExamsGiven()) > 0)
                assGiven++;
            details = new Modal_ProfileDetails(profileDetails.get(i).getStudentName(),
                    profileDetails.get(i).getRespondantName(), profileDetails.get(i).getExamsGiven(), "0",
                    profileDetails.get(i).getStudentAge(), profileDetails.get(i).getVillageId(), profileDetails.get(i).getRespondantName());
            detailsList.add(details);
        }
        tv_AssessmentGivenCount.setText(String.valueOf(assGiven));
    }


    @UiThread
    public void initializeAdapter() {
        if (profileAdapter == null) {
            profileAdapter = new ProfileAdapter(getActivity(), detailsList);
            rv_examDetail.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv_examDetail.setHasFixedSize(true);
            rv_examDetail.setItemViewCacheSize(10);
            rv_examDetail.setItemAnimator(new DefaultItemAnimator());
            rv_examDetail.setAdapter(profileAdapter);
        } else {
            profileAdapter.notifyDataSetChanged();
        }
    }

    @SuppressLint("SetTextI18n")
    @AfterViews
    public void initialize() {
        profilePresenter.setView(this);
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
//        villageID = getArguments().getString(Kix_Constant.VILLAGE_ID);
        //get total no. of student
        List<Modal_Student> stud = studentDao.getAllStudentsBySurveyor(surveyorCode);
        List<Modal_Village> villages = villageDao.getAllVillageBySurveyorCode(surveyorCode);
        //get total no. of household
        List<Modal_Household> households = KIXApplication.householdDao.getAllHHBySurveyorCode(surveyorCode);
        tv_profileName.setText(getString(R.string.hi) + " " + FastSave.getInstance().getString(Kix_Constant.SURVEYOR_NAME, ""));
        tv_TotStudCount.setText(String.valueOf(stud.size()));
        tv_totVillageCount.setText(String.valueOf(villages.size()));
        tv_totHHCount.setText(String.valueOf(households.size()));
/*        tv_studCount.setText("No. of Children : " + stud.size());
        tv_householdCount.setText("Total Villages : " + households.size());*/
        if (stud.size() == 0) {
            spinner_villageFilter.setVisibility(View.INVISIBLE);
            ll_villageFilterSpinner.setVisibility(View.INVISIBLE);
            Toast.makeText(getActivity(), getString(R.string.no_student_found), Toast.LENGTH_SHORT).show();
        } else {
            spinner_villageFilter.setVisibility(View.VISIBLE);
            ll_villageFilterSpinner.setVisibility(View.VISIBLE);

            profilePresenter.loadProfileData();
        }
        //temp();
        initializeAdapter();

        ArrayAdapter adapterAge = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.ageFilter, R.layout.support_simple_spinner_dropdown_item);
        spinner_ageFilter.setAdapter(adapterAge);
        int ageNo = spinner_ageFilter.getSelectedItemPosition() + 3;
        ageSelected = "" + ageNo;
//        ageSelected = spinner_ageFilter.getSelectedItem().toString();

    }

    private void initializeVillageSpinner(final List<Modal_ProfileDetails> profileDetails) {
        villagesList = new ArrayList<>();
        Modal_Village modal_village = new Modal_Village();
        modal_village.setVillageId("-1");
        modal_village.setVillageName(getResources().getString(R.string.all_village));
        villagesList.add(0, modal_village);
        if (profileDetails != null) {
            for (Modal_ProfileDetails profileDetails1 : profileDetails) {
                if (!villagesList.contains(profileDetails1)) {
                    modal_village = new Modal_Village();
                    modal_village.setVillageId(profileDetails1.getVillageId());
                    modal_village.setVillageName(profileDetails1.getVillageName());
                    villagesList.add(modal_village);
                }
            }
        }
        removeDuplicates(villagesList);
        ArrayAdapter<Modal_Village> adapterVillage = new ArrayAdapter<Modal_Village>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, villagesList);
        spinner_villageFilter.setAdapter(adapterVillage);
        villageSelected = spinner_villageFilter.getSelectedItem().toString();

    }

    public void removeDuplicates(ArrayList<Modal_Village> l) {
        Set<Modal_Village> s = new TreeSet<Modal_Village>(new Comparator<Modal_Village>() {

            @Override
            public int compare(Modal_Village o1, Modal_Village o2) {
                if (o1.villageId.equalsIgnoreCase(o2.getVillageId())) {
                    return 0;
                }
                return 1;
            }
        });
        s.addAll(l);
        villagesList.clear();
        villagesList.addAll(s);
        //return s;
    }

    @Click(R.id.fab_sync)
    public void sync() {
        if (KIXApplication.wiseF.isDeviceConnectedToWifiNetwork() || KIXApplication.wiseF.isDeviceConnectedToMobileNetwork()) {
            showLoadingDialog();
            Modal_Log log = new Modal_Log();
            log.setCurrentDateTime(KIX_Utility.getCurrentDateTime());
            log.setErrorType("Sync Data");
            log.setExceptionMessage("");
            log.setExceptionStackTrace("");
            log.setMethodName("Profile");
            log.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, "no_session"));
            log.setDeviceId(KIX_Utility.getDeviceID());
            logDao.insertLog(log);
            KixSmartSync.pushUsageToServer(true);
        } else {
            Toast.makeText(getActivity(), getString(R.string.check_internet), Toast.LENGTH_SHORT).show();
        }
    }

    @androidx.annotation.UiThread
    public void showLoadingDialog() {
        loaderFlg = true;
        myLoadingDialog = new CustomLodingDialog(Objects.requireNonNull(getActivity()));
        myLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myLoadingDialog.setContentView(R.layout.dialog_loader);
        Objects.requireNonNull(myLoadingDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myLoadingDialog.setCancelable(false);
        myLoadingDialog.setCanceledOnTouchOutside(false);
        myLoadingDialog.show();
    }

    @Click(R.id.fab_db_sync)
    public void syncDB() {
        if (KIXApplication.wiseF.isDeviceConnectedToWifiNetwork() || KIXApplication.wiseF.isDeviceConnectedToMobileNetwork()) {
            showLoadingDialog();
            Modal_Log log = new Modal_Log();
            log.setCurrentDateTime(KIX_Utility.getCurrentDateTime());
            log.setErrorType("Sync DB");
            log.setExceptionMessage("");
            log.setExceptionStackTrace("");
            log.setMethodName("Profile");
            log.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, "no_session"));
            log.setDeviceId(KIX_Utility.getDeviceID());
            logDao.insertLog(log);
            BackupDatabase.backup(getActivity());
            pushDataBaseZipToServer.startDataBasePush(context, true);
        } else {
            Toast.makeText(getActivity(), getString(R.string.check_internet), Toast.LENGTH_SHORT).show();
        }
    }

    @ItemSelect(R.id.spinner_ageFilter)
    public void ageFilter(boolean sel) {
        if (!(spinner_ageFilter.getSelectedItemPosition() == 0)) {
            getSelectedAge();
            //filter(ageSelected,villageSelected);
            filter(ageSelected, villageSelected);
        } else {
            int ageNo = spinner_ageFilter.getSelectedItemPosition() + 3;
            ageSelected = "" + ageNo;
            filter(ageSelected, villageSelected);
        }

    }

    @ItemSelect(R.id.spinner_villageFilter)
    public void villageFilter(boolean sel) {
        //filter(ageSelected, spinner_villageFilter.getSelectedItem().toString());
        Modal_Village modal_village = (Modal_Village) spinner_villageFilter.getSelectedItem();
        filter(ageSelected, modal_village.villageId);
    }

    @SuppressLint("SetTextI18n")
    private void filter(String ageFilter, String villageID) {
        ArrayList<Modal_ProfileDetails> filteredList = new ArrayList();
        List<String> houseHoldList = householdDao.getHouseholdNameByVillageId(villageID);
        List<Modal_Student> modalStudents = studentDao.getStudentByHouseHold(houseHoldList);

        if (villageID.equalsIgnoreCase("-1")) {
            filteredList.addAll(detailsList);
        } else {
            Modal_ProfileDetails details = new Modal_ProfileDetails(getString(R.string.child_name),
                    getString(R.string.str_household), getString(R.string.assessment_given), "Assessment Synced", "", "", "");
            filteredList.add(details);
            for (Modal_ProfileDetails student_profile : detailsList) {
                if (villageID.equalsIgnoreCase(student_profile.getVillageId())) {
                    filteredList.add(student_profile);
                }
            }
        }



        /*if (Integer.parseInt(ageSelected) < 4 && villageSelected.equalsIgnoreCase(getResources().getString(R.string.all_houeholds))) {
            filteredList.addAll(detailsList);
        } else {
            Modal_ProfileDetails details = new Modal_ProfileDetails(getString(R.string.child_name),
                    getString(R.string.str_household), getString(R.string.assessment_given), "Assessment Synced", "");
            filteredList.add(details);
            for (Modal_ProfileDetails d : detailsList) {
                if (Integer.parseInt(ageSelected) < 4 && !villageFilter.isEmpty()) {
                    if (d.getRespondantName().contains(villageFilter)) {
                        filteredList.add(d);
                    }
                } else if (villageFilter.equalsIgnoreCase(getResources().getString(R.string.all_houeholds)) && !ageFilter.isEmpty()) {
                    if (d.getStudentAge().contains(ageFilter)) {
                        filteredList.add(d);
                    }
                } else {
                    if (d.getStudentAge().contains(ageFilter) && d.getRespondantName().contains(villageFilter))
                        filteredList.add(d);
                }
            }
        }*/
        //update recyclerview
        profileAdapter.updateList(filteredList);
        int studCount = filteredList.size() - 1;
/*        if (!(studCount < 0))
            tv_studCount.setText("No. of Children : " + studCount);*/
        if (filteredList.size() == 1)
            Toast.makeText(getActivity(), getString(R.string.no_match_found), Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DataPushedSuccessfully(EventMessage msg) {
        if (msg != null) {
            if (msg.getMessage().equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
                if (loaderFlg) {
                    myLoadingDialog.dismiss();
                    loaderFlg = false;
                }
                pushDialog(getString(R.string.data_sync_success), Kix_Constant.SUCCESSFULLYPUSHED);
                BackupDatabase.backup(getActivity());
            } else if (msg.getMessage().equalsIgnoreCase(Kix_Constant.DBSUCCESSFULLYPUSHED)) {
                if (loaderFlg) {
                    myLoadingDialog.dismiss();
                    loaderFlg = false;
                }
                pushDialog(getString(R.string.db_sync_success), Kix_Constant.DBSUCCESSFULLYPUSHED);
                BackupDatabase.backup(getActivity());
            } else if (msg.getMessage().equalsIgnoreCase(Kix_Constant.PUSHFAILED)) {
                if (loaderFlg) {
                    myLoadingDialog.dismiss();
                    loaderFlg = false;
                }
                pushDialog(getString(R.string.sync_fail), Kix_Constant.PUSHFAILED);
            }
        }
    }

    private void getSelectedAge() {
        int ageNo = spinner_ageFilter.getSelectedItemPosition() + 3;
        ageSelected = "" + ageNo;
/*        String age1 = spinner_ageFilter.getSelectedItem().toString();
        String[] split_age = age1.split(" ");
        if (split_age.length > 1)
            ageSelected = String.valueOf(Integer.parseInt(split_age[1]));
        else
            ageSelected = "0";*/
    }

    public void pushDialog(String message, String pushType) {
        pushDialog = new BlurPopupWindow.Builder(getActivity())
                .setContentView(R.layout.dialog_push_result)
                .bindClickListener(v -> {
                    if (pushType.equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED))
                        pushStatsDialog();
                    pushDialog.dismiss();
                }, R.id.dia_btnOk)
                .setGravity(Gravity.CENTER)
                .setDismissOnTouchBackground(false)
                .setDismissOnClickBack(true)
                .setScaleRatio(0.2f)
                .setBlurRadius(10)
                .setTintColor(0x30000000)
                .build();
        tv_dialTitle = pushDialog.findViewById(R.id.dia_title);
        tv_dialTitle.setText("" + message);
        if (pushType.equalsIgnoreCase(Kix_Constant.DBSUCCESSFULLYPUSHED) ||
                pushType.equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED))
            tv_dialTitle.setTextColor(getResources().getColor(R.color.colorBtnGreenDark));
        else
            tv_dialTitle.setTextColor(getResources().getColor(R.color.colorRedDark));
        pushDialog.show();
    }

    public void pushStatsDialog() {
        pushStatusDialogue = new BlurPopupWindow.Builder(getActivity())
                .setContentView(R.layout.dialog_push_stats)
                .bindClickListener(v -> {
                    pushStatusDialogue.dismiss();
                }, R.id.dia_btnOk)
                .setGravity(Gravity.CENTER)
                .setDismissOnTouchBackground(false)
                .setDismissOnClickBack(true)
                .setScaleRatio(0.2f)
                .setBlurRadius(10)
                .setTintColor(0x30000000)
                .build();

        tv_dia_vil = pushStatusDialogue.findViewById(R.id.dia_vil);
        tv_dia_survey = pushStatusDialogue.findViewById(R.id.dia_survey);
        tv_dia_stud = pushStatusDialogue.findViewById(R.id.dia_stud);
        tv_dia_score = pushStatusDialogue.findViewById(R.id.dia_score);
        this.tv_dia_hhld = this.pushStatusDialogue.findViewById(R.id.dia_hhld);
        this.tv_dia_vif = this.pushStatusDialogue.findViewById(R.id.dia_vif);
        this.tv_dia_hif = this.pushStatusDialogue.findViewById(R.id.dia_hif);
        this.tv_dia_pif = this.pushStatusDialogue.findViewById(R.id.dia_pif);

        this.tv_dia_score.setText(this.getResources().getString(R.string.score_count)
                + " " + FastSave.getInstance().getString(Kix_Constant.SCORE_COUNT, "0"));
        this.tv_dia_stud.setText(this.getResources().getString(R.string.student_count)
                + " " + FastSave.getInstance().getString(Kix_Constant.STUDENT_COUNT, "0"));
        this.tv_dia_vil.setText(this.getResources().getString(R.string.village_count)
                + " " + FastSave.getInstance().getString(Kix_Constant.VILLAGE_COUNT, "0"));
        this.tv_dia_survey.setText(this.getResources().getString(R.string.surveyor_count)
                + " " + FastSave.getInstance().getString(Kix_Constant.SURVEYOR_COUNT, "0"));
        this.tv_dia_hhld.setText(this.getResources().getString(R.string.household_count)
                + " " + FastSave.getInstance().getString(Kix_Constant.HOUSEHOLD_COUNT, "0"));
        this.tv_dia_vif.setText(this.getResources().getString(R.string.vif_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.VIF_COUNT, "0"));
        this.tv_dia_hif.setText(this.getResources().getString(R.string.hif_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.HIF_COUNT, "0"));
        this.tv_dia_pif.setText(this.getResources().getString(R.string.pif_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.PIF_COUNT, "0"));

        pushStatusDialogue.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
