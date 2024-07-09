package com.kix.assessment.ui.village_activity.FragmentSelectVillage;

import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.villageDao;
import static com.kix.assessment.KIXApplication.villageInformationDao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.custom.flexbox.AlignItems;
import com.kix.assessment.custom.flexbox.FlexDirection;
import com.kix.assessment.custom.flexbox.FlexboxLayoutManager;
import com.kix.assessment.custom.flexbox.JustifyContent;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_VIF;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.services.KixSmartSync;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.fragment_profile.Fragment_Profile;
import com.kix.assessment.ui.fragment_profile.Fragment_Profile_;
import com.kix.assessment.ui.household_activity.Activity_Household_;
import com.kix.assessment.ui.village_activity.Fragment_AddVillage;
import com.kix.assessment.ui.village_activity.Fragment_AddVillage_;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation_;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_VillageInformation;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_VillageInformation_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Objects;

@EFragment(R.layout.fragment_select_village)
public class Fragment_SelectVillage extends Fragment implements ContractVillageList {

    @ViewById(R.id.rv_village)
    RecyclerView rv_village;

    @ViewById(R.id.fab_addVillage)
    FloatingActionButton fab_addVillage;

    private ArrayList<Modal_Village> villageArrayList = new ArrayList<>();
    private boolean itemSelected;
    String surveyorCode, villageID;
    Modal_Village village = new Modal_Village();

    private VillageListAdapter villageListAdapter;

    boolean loaderFlg;
    private BlurPopupWindow pushDialog, pushStatusDialogue;
    private TextView tv_dia_vil;
    private TextView tv_dia_survey;
    private TextView tv_dia_stud;
    private TextView tv_dia_score;
    private TextView tv_dialTitle;
    private TextView tv_dia_hhld;
    private TextView tv_dia_vif;
    private TextView tv_dia_hif;
    private TextView tv_dia_pif;
    private CustomLodingDialog myLoadingDialog;


    public Fragment_SelectVillage() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        Log.e("KIX : ", "selectstud");
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        villageArrayList = (ArrayList<Modal_Village>) villageDao.getAllVillageBySurveyorCode(surveyorCode);
        if (villageArrayList.size() == 0) {
            Toast.makeText(getActivity(), getString(R.string.no_village_found), Toast.LENGTH_SHORT).show();
            Animation anim = android.view.animation.AnimationUtils.loadAnimation(fab_addVillage.getContext(), R.anim.shake);
            anim.setDuration(200L);
            fab_addVillage.startAnimation(anim);
        }
        initializeAdapter();
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @UiThread
    public void initializeAdapter() {
        FastSave.getInstance().saveString(Kix_Constant.COUNTRY, "NA");
        if (villageListAdapter == null) {
            villageListAdapter = new VillageListAdapter(villageArrayList, getActivity(), this);
            rv_village.setHasFixedSize(true);
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getActivity(), FlexDirection.ROW);
            flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
            flexboxLayoutManager.setAlignItems(AlignItems.CENTER);
            rv_village.setLayoutManager(flexboxLayoutManager);
            rv_village.setAdapter(villageListAdapter);
        } else {
            villageListAdapter.notifyDataSetChanged();
        }
    }

    @Click(R.id.fab_addVillage)
    public void addVillage() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        KIX_Utility.showFragment(getActivity(), new Fragment_AddVillage_(), R.id.frag_frame,
                bundle, Fragment_AddVillage.class.getSimpleName());
    }

    @Override
    public void itemSelected(int position) {
        final Modal_Village modal_village = this.villageListAdapter.getitem(position);
        FastSave.getInstance().saveString(Kix_Constant.BOOKLET,modal_village.getVillageBooklet());
//        Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
//        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
//        intent.putExtra(Kix_Constant.VILLAGE_ID, modal_village.villageId);
//        FastSave.getInstance().saveString(Kix_Constant.COUNTRY, modal_village.getCountryName());
//        if (!FastSave.getInstance().getString(Kix_Constant.COUNTRY, "NA").equalsIgnoreCase("NA"))
//            startActivity(intent);
        Intent intent = new Intent(this.getActivity(), Activity_Household_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        intent.putExtra(Kix_Constant.VILLAGE_ID,modal_village.villageId);
        FastSave.getInstance().saveString(Kix_Constant.COUNTRY, modal_village.getCountryName());
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        this.startActivity(intent);
    }

    @Override
    public void addVIF(int position){
        Modal_Village modal_village = villageListAdapter.getitem(position);
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.VILLAGE_ID, modal_village.getVillageId());

        final Modal_VIF modal_vif = villageInformationDao.getVIFbyVillageId(modal_village.getVillageId());
        if(modal_vif!=null){
            KIX_Utility.showFragment(getActivity(), new Fragment_VillageInformation_(), R.id.frag_frame,
                    bundle, Fragment_VillageInformation.class.getSimpleName());
        } else {
            KIX_Utility.showFragment(getActivity(), new Fragment_AddVillageInformation_(), R.id.frag_frame,
                    bundle, Fragment_AddVillageInformation.class.getSimpleName());
        }
    }

    @Override
    public void editVillage(int position) {
        Modal_Village modal_village = villageListAdapter.getitem(position);
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.EDIT_VILLAGE, Kix_Constant.EDIT_VILLAGE);
        bundle.putString(Kix_Constant.VILLAGE_ID, modal_village.getVillageId());
        KIX_Utility.showFragment(getActivity(), new Fragment_AddVillage_(), R.id.frag_frame,
                bundle, Fragment_AddVillage.class.getSimpleName());
    }

    @Click(R.id.fab_profile)
    public void profile() {
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
//        bundle.putString(Kix_Constant.VILLAGE_ID, this.villageId);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_Profile_(), R.id.frag_frame,
                bundle, Fragment_Profile.class.getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_village.setAdapter(null);
        villageListAdapter = null;
        rv_village = null;
    }


    @Click(R.id.fab_sync)
    public void sync() {
        if (KIXApplication.wiseF.isDeviceConnectedToWifiNetwork() || KIXApplication.wiseF.isDeviceConnectedToMobileNetwork()) {
            this.showLoadingDialog();
            final Modal_Log log = new Modal_Log();
            log.setCurrentDateTime(KIX_Utility.getCurrentDateTime());
            log.setErrorType("Sync Data");
            log.setExceptionMessage("");
            log.setExceptionStackTrace("");
            log.setMethodName("Add Student");
            log.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, "no_session"));
            log.setDeviceId(KIX_Utility.getDeviceID());
            logDao.insertLog(log);
            KixSmartSync.pushUsageToServer(true);
        } else {
            Toast.makeText(this.getActivity(), getString(R.string.check_internet), Toast.LENGTH_SHORT).show();
        }
    }

    @UiThread
    public void showLoadingDialog() {
        this.loaderFlg = true;
        this.myLoadingDialog = new CustomLodingDialog(Objects.requireNonNull(this.getActivity()));
        this.myLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.myLoadingDialog.setContentView(R.layout.dialog_loader);
        Objects.requireNonNull(this.myLoadingDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.myLoadingDialog.setCancelable(false);
        this.myLoadingDialog.setCanceledOnTouchOutside(false);
        this.myLoadingDialog.show();
    }

    public void pushDialog(final String message, final String pushType) {
        this.pushDialog = new BlurPopupWindow.Builder(this.getActivity())
                .setContentView(R.layout.dialog_push_result)
                .bindClickListener(v -> {
                    this.pushDialog.dismiss();
                    this.pushStatsDialog();
                }, R.id.dia_btnOk)
                .setGravity(Gravity.CENTER)
                .setDismissOnTouchBackground(false)
                .setDismissOnClickBack(true)
                .setScaleRatio(0.2f)
                .setBlurRadius(10)
                .setTintColor(0x30000000)
                .build();
        this.tv_dialTitle = this.pushDialog.findViewById(R.id.dia_title);
        this.tv_dialTitle.setText(""+message);
        if (pushType.equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
            this.tv_dialTitle.setTextColor(this.getResources().getColor(R.color.colorBtnGreenDark));
        }else {
            this.tv_dialTitle.setTextColor(this.getResources().getColor(R.color.colorRedDark));
        }
        this.pushDialog.show();
    }

    public void pushStatsDialog() {
        this.pushStatusDialogue = new BlurPopupWindow.Builder(this.getActivity())
                .setContentView(R.layout.dialog_push_stats)
                .bindClickListener(v -> {
                    this.pushStatusDialogue.dismiss();
                }, R.id.dia_btnOk)
                .setGravity(Gravity.CENTER)
                .setDismissOnTouchBackground(false)
                .setDismissOnClickBack(true)
                .setScaleRatio(0.2f)
                .setBlurRadius(10)
                .setTintColor(0x30000000)
                .build();
        this.tv_dia_vil = this.pushStatusDialogue.findViewById(R.id.dia_vil);
        this.tv_dia_survey = this.pushStatusDialogue.findViewById(R.id.dia_survey);
        this.tv_dia_stud = this.pushStatusDialogue.findViewById(R.id.dia_stud);
        this.tv_dia_score = this.pushStatusDialogue.findViewById(R.id.dia_score);
        this.tv_dia_hhld = this.pushStatusDialogue.findViewById(R.id.dia_hhld);
        this.tv_dia_vif = this.pushStatusDialogue.findViewById(R.id.dia_vif);
        this.tv_dia_hif = this.pushStatusDialogue.findViewById(R.id.dia_hif);
        this.tv_dia_pif = this.pushStatusDialogue.findViewById(R.id.dia_pif);

        this.tv_dia_score.setText(this.getResources().getString(R.string.score_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.SCORE_COUNT, "0"));
        this.tv_dia_stud.setText(this.getResources().getString(R.string.student_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.STUDENT_COUNT, "0"));
        this.tv_dia_vil.setText(this.getResources().getString(R.string.village_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.VILLAGE_COUNT, "0"));
        this.tv_dia_survey.setText(this.getResources().getString(R.string.surveyor_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.SURVEYOR_COUNT, "0"));
        this.tv_dia_hhld.setText(this.getResources().getString(R.string.household_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.HOUSEHOLD_COUNT, "0"));
        this.tv_dia_vif.setText(this.getResources().getString(R.string.vif_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.VIF_COUNT, "0"));
        this.tv_dia_hif.setText(this.getResources().getString(R.string.hif_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.HIF_COUNT, "0"));
        this.tv_dia_pif.setText(this.getResources().getString(R.string.pif_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.PIF_COUNT, "0"));

        this.pushStatusDialogue.show();
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DataPushedSuccessfully(final EventMessage msg) {
        if (msg != null) {
            if (msg.getMessage().equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
                if (this.loaderFlg) {
                    this.myLoadingDialog.dismiss();
                    this.loaderFlg = false;
                }
                this.pushDialog(this.getResources().getString(R.string.push_success), Kix_Constant.SUCCESSFULLYPUSHED);
                BackupDatabase.backup(this.getActivity());
            } else if (msg.getMessage().equalsIgnoreCase(Kix_Constant.PUSHFAILED)) {
                if (this.loaderFlg) {
                    this.myLoadingDialog.dismiss();
                    this.loaderFlg = false;
                }
                this.pushDialog(this.getResources().getString(R.string.push_fail),Kix_Constant.PUSHFAILED);
            }
        }
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
