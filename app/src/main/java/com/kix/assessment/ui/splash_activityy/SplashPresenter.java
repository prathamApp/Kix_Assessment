package com.kix.assessment.ui.splash_activityy;


import org.androidannotations.annotations.EBean;

@EBean
public class SplashPresenter implements SplashContract.SplashPresenter {

    SplashContract.SplashView splashView;

    //Sets View(UI)
    @Override
    public void setView(SplashContract.SplashView splashView) {
        this.splashView = splashView;
    }

}

