package com.kix.assessment.ui.fragment_profile;

import android.annotation.SuppressLint;
import android.widget.TextView;
import android.widget.Toast;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.services.KixSmartSync;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
