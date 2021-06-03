package com.kix.assessment.ui.fragment_profile;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_ProfileDetails;
import com.kix.assessment.modal_classes.Modal_Student;
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
import java.util.List;
import java.util.Objects;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.kix.assessment.KIXApplication.householdDao;

@EFragment(R.layout.fragment_profile)
public class Fragment_Profile extends Fragment implements ProfileContract.ProfileView {

    private List<Modal_ProfileDetails> detailsList = new ArrayList<>();

    @ViewById(R.id.tv_profileName)
    TextView tv_profileName;
    @ViewById(R.id.tv_studCount)
    TextView tv_studCount;
    @ViewById(R.id.tv_householdCount)
    TextView tv_householdCount;

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

    String selectedAge;

    String ageSelected, villageSelected;

    String surveyorCode, householdId;

    //list for villageFilter
    ArrayList<String> villagesList = new ArrayList<>();

    public Fragment_Profile() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        profilePresenter.setView(this);
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        //get total no. of student
        List<Modal_Student> stud = KIXApplication.studentDao.getAllStudentsBySurveyor(surveyorCode);
        //get total no. of household
        List<Modal_Household> households = KIXApplication.householdDao.getAllHouseholdBySurveyorCode(surveyorCode);
        tv_profileName.setText("Hi, " + FastSave.getInstance().getString(Kix_Constant.SURVEYOR_NAME, ""));
        tv_studCount.setText("Total Students : " + stud.size());
        tv_householdCount.setText("Total Villages : " + households.size());
        if (stud.size() == 0)
            Toast.makeText(getActivity(), "No Student Found!", Toast.LENGTH_SHORT).show();
        else
            profilePresenter.loadProfileData();
        //temp();
        initializeAdapter();

        ArrayAdapter adapterAge = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.ageFilter, R.layout.support_simple_spinner_dropdown_item);
        spinner_ageFilter.setAdapter(adapterAge);
        villagesList = (ArrayList<String>) householdDao.getAllHouseholdNameBySurveyorCode(surveyorCode);
        villagesList.add(0, Kix_Constant.ALL_VILLAGE);
        ArrayAdapter<String> adapterVillage = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, villagesList);
        spinner_villageFilter.setAdapter(adapterVillage);
        ageSelected = spinner_ageFilter.getSelectedItem().toString();
        villageSelected = spinner_villageFilter.getSelectedItem().toString();
    }

    @UiThread
    @Override
    public void showProfileData(List<Modal_ProfileDetails> profileDetails) {
        //recycler header values
        Modal_ProfileDetails details = new Modal_ProfileDetails("Student Name",
                "Village", "Assessments Given", "Assessment Synced", "");
        detailsList.add(details);
        if (profileDetails.size() == 0) {
            Toast.makeText(getActivity(), "Assessment Not Given By Student", Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < profileDetails.size(); i++) {
            details = new Modal_ProfileDetails(profileDetails.get(i).getStudentName(),
                    profileDetails.get(i).getHouseholdName(), profileDetails.get(i).getExamsGiven(), "0",
                    profileDetails.get(i).getStudentAge());
            detailsList.add(details);
        }
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

    @Click(R.id.fab_sync)
    public void sync() {
        if (KIXApplication.wiseF.isDeviceConnectedToWifiNetwork() || KIXApplication.wiseF.isDeviceConnectedToMobileNetwork()) {
            KixSmartSync.pushUsageToServer(true);
        } else {
            Toast.makeText(getActivity(), "Please Check Internet Connection!", Toast.LENGTH_SHORT).show();
        }
    }

    @ItemSelect(R.id.spinner_ageFilter)
    public void ageFilter(boolean sel) {
        if (!(spinner_ageFilter.getSelectedItemPosition() == 0)) {
            getSelectedAge();
            //filter(ageSelected,villageSelected);
            filter(ageSelected, villageSelected);
        }
        else {
            ageSelected = spinner_ageFilter.getSelectedItem().toString();
            filter(ageSelected,villageSelected);
        }

    }

    @ItemSelect(R.id.spinner_villageFilter)
    public void villageFilter(boolean sel) {
            //filter(ageSelected, spinner_villageFilter.getSelectedItem().toString());
        villageSelected = spinner_villageFilter.getSelectedItem().toString();
        filter(ageSelected,villageSelected);
    }

    @SuppressLint("SetTextI18n")
    private void filter(String ageFilter, String villageFilter) {
        ArrayList<Modal_ProfileDetails> filteredList = new ArrayList();
        if(ageSelected.equalsIgnoreCase(Kix_Constant.ALL_AGE) && villageSelected.equalsIgnoreCase(Kix_Constant.ALL_VILLAGE)){
            filteredList.addAll(detailsList);
        }
        else {
            Modal_ProfileDetails details = new Modal_ProfileDetails("Student Name",
                    "Village", "Assessments Given", "Assessment Synced", "");
            filteredList.add(details);
            for (Modal_ProfileDetails d : detailsList) {
                if(ageFilter.equalsIgnoreCase(Kix_Constant.ALL_AGE) && !villageFilter.isEmpty()) {
                    if (d.getHouseholdName().contains(villageFilter)) {
                        filteredList.add(d);
                    }
                }
                else if(villageFilter.equalsIgnoreCase(Kix_Constant.ALL_VILLAGE) && !ageFilter.isEmpty()){
                    if(d.getStudentAge().contains(ageFilter)){
                        filteredList.add(d);
                    }
                }
                else {
                    if(d.getStudentAge().contains(ageFilter) && d.getHouseholdName().contains(villageFilter))
                        filteredList.add(d);
                }
            }
        }
        //update recyclerview
        profileAdapter.updateList(filteredList);
        int studCount = filteredList.size()-1;
        tv_studCount.setText("Total Students : " + studCount);
        if (filteredList.size() == 1)
            Toast.makeText(getActivity(), "No Match Found!!", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DataPushedSuccessfully(EventMessage msg) {
        if (msg != null) {
            if (msg.getMessage().equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
                Toast.makeText(getActivity(), "Data Pushed Successfully!", Toast.LENGTH_SHORT).show();
            } else if (msg.getMessage().equalsIgnoreCase(Kix_Constant.PUSHFAILED)) {
                Toast.makeText(getActivity(), "Data Push Failed.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getSelectedAge() {
        String age1 = spinner_ageFilter.getSelectedItem().toString();
        String[] split_age = age1.split(" ");
        if (split_age.length > 1)
            ageSelected = String.valueOf(Integer.parseInt(split_age[1]));
        else
            ageSelected = "0";
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
