package com.kix.assessment.ui.splash_activity;

public interface SplashContract {

    interface SplashView{

    }

    interface SplashPresenter {

        void setView(SplashContract.SplashView splashView);

    }

}
