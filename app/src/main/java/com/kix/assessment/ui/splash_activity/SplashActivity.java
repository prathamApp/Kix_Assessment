package com.kix.assessment.ui.splash_activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kix.assessment.R;
import com.kix.assessment.ui.main_test.MainTestActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;


@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView {

    @Bean(SplashPresenter.class)
    SplashPresenter splashPresenter;

    @AfterViews
    public void init() {
        new Handler().postDelayed(this::gotoNext, 3000);
    }

    @UiThread
    public void gotoNext() {
        Toast.makeText(this, "GOTO Next", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainTestActivity_.class));
    }

}