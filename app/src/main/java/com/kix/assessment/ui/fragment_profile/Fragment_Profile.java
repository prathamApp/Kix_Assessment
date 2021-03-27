package com.kix.assessment.ui.fragment_profile;

import android.widget.TextView;
import android.widget.Toast;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.services.KixSmartSync;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import androidx.fragment.app.Fragment;

@EFragment(R.layout.fragment_profile)
public class Fragment_Profile extends Fragment {

    @ViewById(R.id.tv_studCount)
    TextView tv_studCount;
    @ViewById(R.id.tv_householdCount)
    TextView tv_householdCount;

    String surveyorCode, householdId;
    public Fragment_Profile() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        List<Modal_Student> stud = KIXApplication.studentDao.getAllStudentsBySurveyor(surveyorCode);
        List<Modal_Household> households = KIXApplication.householdDao.getAllHouseholdBySurveyorCode(surveyorCode);
        tv_studCount.setText("Studnent Count : "+stud.size());
        tv_householdCount.setText("Household Count : "+households.size());
    }

    @Click(R.id.iv_sync)
    public void sync(){
        KixSmartSync.pushUsageToServer(true);
        Toast.makeText(getActivity(), "Data Pushed.", Toast.LENGTH_SHORT).show();
    }
}
