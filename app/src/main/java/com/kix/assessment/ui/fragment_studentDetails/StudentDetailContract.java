package com.kix.assessment.ui.fragment_studentDetails;

import com.kix.assessment.modal_classes.Modal_StudentDetails;

import java.util.List;

public interface StudentDetailContract {

    interface ProfileView{
        void showProfileData(List<Modal_StudentDetails> profileDetails);
    }

    interface ProfilePresenter {
        void setView(StudentDetailContract.ProfileView profileView);
        void loadProfileData();
    }
}
