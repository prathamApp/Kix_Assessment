package com.kix.assessment.ui.profile.fragment_studentDetails;

import android.widget.TextView;
import android.widget.Toast;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_StudentDetails;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

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
}
