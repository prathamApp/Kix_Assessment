package com.kix.assessment.ui.fragment_profile;

import com.kix.assessment.modal_classes.Modal_ProfileDetails;

import java.util.List;

public interface ProfileContract {

    interface ProfileView{
        void showProfileData(List<Modal_ProfileDetails> profileDetails);
    }

    interface ProfilePresenter {
        void setView(ProfileContract.ProfileView profileView);
        void loadProfileData();
    }
}
