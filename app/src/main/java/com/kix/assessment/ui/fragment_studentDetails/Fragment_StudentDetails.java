package com.kix.assessment.ui.fragment_studentDetails;

import android.annotation.SuppressLint;
import android.widget.TextView;
import android.widget.Toast;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_StudentDetails;
import com.kix.assessment.services.KixSmartSync;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@EFragment(R.layout.fragment_student_detail)
public class Fragment_StudentDetails extends Fragment implements StudentDetailContract.ProfileView{

    private List<Modal_StudentDetails> detailsList = new ArrayList<>();

    @ViewById(R.id.tv_profileName)
    TextView tv_profileName;
    @ViewById(R.id.tv_studCount)
    TextView tv_studCount;
    @ViewById(R.id.tv_householdCount)
    TextView tv_householdCount;

    @ViewById(R.id.rv_examDetail)
    RecyclerView rv_examDetail;

    @Bean(StudentDetailPresenter.class)
    StudentDetailPresenter studentDetailPresenter;
    private StudentDetailAdapter studentDetailAdapter;

    String surveyorCode, householdId;
    public Fragment_StudentDetails() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        studentDetailPresenter.setView(this);
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        List<Modal_Student> stud = KIXApplication.studentDao.getAllStudentsBySurveyor(surveyorCode);
        List<Modal_Household> households = KIXApplication.householdDao.getAllHouseholdBySurveyorCode(surveyorCode);
        tv_profileName.setText("Hi "+ FastSave.getInstance().getString(Kix_Constant.SURVEYOR_NAME,""));
        tv_studCount.setText("No. of Students : "+stud.size());
        tv_householdCount.setText("No. of Villages : "+households.size());
        if(stud.size()==0)
            Toast.makeText(getActivity(), "No Student Found!", Toast.LENGTH_SHORT).show();
        else
            studentDetailPresenter.loadProfileData();
        //temp();
        initializeAdapter();
    }

    @Override
    public void showProfileData(List<Modal_StudentDetails> profileDetails) {
        Modal_StudentDetails details = new Modal_StudentDetails("Student Name", "Household", "Exams Given", "Exam Synced");
        detailsList.add(details);
        if(profileDetails.size()==0){
            Toast.makeText(getActivity(), "Exam Not Given By Student", Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < profileDetails.size(); i++)
        {
            details = new Modal_StudentDetails(profileDetails.get(i).getStudentName(),
                    profileDetails.get(i).getHouseholdName(), profileDetails.get(i).getExamsGiven(), "0");
            detailsList.add(details);
        }
    }

    @UiThread
    public void initializeAdapter() {
        if (studentDetailAdapter == null) {
            studentDetailAdapter = new StudentDetailAdapter(getActivity(), detailsList);
            rv_examDetail.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv_examDetail.setHasFixedSize(true);
            rv_examDetail.setItemViewCacheSize(10);
            rv_examDetail.setItemAnimator(new DefaultItemAnimator());
            rv_examDetail.setAdapter(studentDetailAdapter);
        }
        else {
            studentDetailAdapter.notifyDataSetChanged();
        }
    }

    @Click(R.id.iv_sync)
    public void sync(){
        if (KIXApplication.wiseF.isDeviceConnectedToWifiNetwork() || KIXApplication.wiseF.isDeviceConnectedToMobileNetwork()) {
            KixSmartSync.pushUsageToServer(true);
        } else {
            Toast.makeText(getActivity(), "Please Check Internet Connection!", Toast.LENGTH_SHORT).show();
        }
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
