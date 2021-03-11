package com.kix.assessment.ui.main_test;


import org.androidannotations.annotations.EBean;

@EBean
public class MainTestPresenter implements MainTestContract.MainTestPresenter {

    MainTestContract.MainTestView mainTestView;

    //Sets View(UI)
    @Override
    public void setView(MainTestContract.MainTestView mainTestView) {
        this.mainTestView = mainTestView;
    }

}

