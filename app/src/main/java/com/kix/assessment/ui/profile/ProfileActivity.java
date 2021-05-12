package com.kix.assessment.ui.profile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.kix.assessment.BaseActivity;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.async.ContentDownloadingTask;
import com.kix.assessment.async.KixSmartSync;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.ui.profile.fragment_chooseBooklet.Fragment_DownloadBooklet;
import com.kix.assessment.ui.profile.fragment_chooseBooklet.Fragment_DownloadBooklet_;
import com.kix.assessment.ui.profile.fragment_setBooklet.Fragment_SetBooklet;
import com.kix.assessment.ui.profile.fragment_setBooklet.Fragment_SetBooklet_;
import com.kix.assessment.ui.profile.fragment_studentDetails.Fragment_StudentDetails;
import com.kix.assessment.ui.profile.fragment_studentDetails.Fragment_StudentDetails_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@EActivity(R.layout.activity_profile)
public class ProfileActivity extends BaseActivity {

    @Bean(ContentDownloadingTask.class)
    public static ContentDownloadingTask contentDownloadingTask;

    String surveyorCode, householdID;
    @AfterViews
    public void initialize(){
        surveyorCode = getIntent().getStringExtra(Kix_Constant.SURVEYOR_CODE);
    }

    @Click(R.id.tv_studDetail)
    public void studentDetail(){
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
        KIX_Utility.showFragment(this, new Fragment_StudentDetails_(), R.id.profile_frame,
                bundle, Fragment_StudentDetails.class.getSimpleName());
    }

    @Click(R.id.tv_syncData)
    public void sync(){
        if (KIXApplication.wiseF.isDeviceConnectedToWifiNetwork() || KIXApplication.wiseF.isDeviceConnectedToMobileNetwork()) {
            KixSmartSync.pushUsageToServer(true);
        } else {
            Toast.makeText(this, "Please Check Internet Connection!", Toast.LENGTH_SHORT).show();
        }
    }

    @Click(R.id.tv_chooseBooklet)
    public void chooseBooklet(){
        KIX_Utility.showFragment(this, new Fragment_DownloadBooklet_(), R.id.profile_frame,
                null, Fragment_DownloadBooklet.class.getSimpleName());
    }

    @Click(R.id.tv_setBooklet)
    public void setBooklet(){
        KIX_Utility.showFragment(this, new Fragment_SetBooklet_(), R.id.profile_frame,
                null, Fragment_SetBooklet.class.getSimpleName());
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DataPushedSuccessfully(EventMessage msg) {
        if (msg != null) {
            if (msg.getMessage().equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
                Toast.makeText(this, "Data Pushed Successfully!", Toast.LENGTH_SHORT).show();
            } else if (msg.getMessage().equalsIgnoreCase(Kix_Constant.PUSHFAILED)) {
                Toast.makeText(this, "Data Push Failed.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
