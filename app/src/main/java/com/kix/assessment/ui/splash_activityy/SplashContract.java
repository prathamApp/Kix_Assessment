package com.kix.assessment.ui.splash_activityy;

public interface SplashContract {

    interface SplashView{

    }

    interface SplashPresenter {

        void setView(SplashContract.SplashView splashView);
        void populateDefaultDB();

    }

}
