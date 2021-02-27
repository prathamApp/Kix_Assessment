package com.kix.assessment.ui.splash_activity;

import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.kix.assessment.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView {

    @Bean(SplashPresenter.class)
    SplashPresenter splashPresenter;

    @AfterViews
    public void init() {
        new Handler().postDelayed(this::gotoNext, 500);
    }

    private void gotoNext() {
        Toast.makeText(this, "GOTO Next act", Toast.LENGTH_SHORT).show();
    }

}