package com.kix.assessment.ui.profile.fragment_studentDetails;

import android.content.Context;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_StudentDetails;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class StudentDetailPresenter implements StudentDetailContract.ProfilePresenter {

    Context context;
    StudentDetailContract.ProfileView profileView;

    public StudentDetailPresenter(Context context){
        this.context=context;
    }

    @Override
    public void setView(StudentDetailContract.ProfileView profileView) {
        this.profileView=profileView;
    }

    @Background
    @Override
    public void loadProfileData() {
        String svrCode = FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE,"");
        List<Modal_StudentDetails> profileDetails;
        profileDetails = KIXApplication.scoreDao.getProfileData(svrCode);
        profileView.showProfileData(profileDetails);
    }

}
