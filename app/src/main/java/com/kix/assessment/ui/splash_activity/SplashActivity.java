package com.kix.assessment.ui.splash_activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;

import com.kix.assessment.R;
import com.kix.assessment.interfaces.PermissionResult;
import com.kix.assessment.kix_utils.PermissionUtils;
import com.kix.assessment.ui.main_test.MainTestActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;


@EActivity(R.layout.activity_splash)
public class SplashActivity extends SplashSupportActivity implements SplashContract.SplashView, PermissionResult {

    @Bean(SplashPresenter.class)
    SplashPresenter splashPresenter;

    @AfterViews
    public void init() {
        String[] permissionArray = new String[]{PermissionUtils.Manifest_CAMERA,
                PermissionUtils.Manifest_WRITE_EXTERNAL_STORAGE,
                PermissionUtils.Manifest_RECORD_AUDIO,
                PermissionUtils.Manifest_ACCESS_COARSE_LOCATION,
                PermissionUtils.Manifest_ACCESS_FINE_LOCATION
        };

        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
            if (!isPermissionsGranted(SplashActivity.this, permissionArray))
                askCompactPermissions(permissionArray, SplashActivity.this);
            else
                new Handler().postDelayed(this::gotoNext, 3000);
        } else
            new Handler().postDelayed(this::gotoNext, 3000);

//        new Handler().postDelayed(this::gotoNext, 3000);
    }

    @UiThread
    public void gotoNext() {
        Toast.makeText(this, "GOTO Next", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainTestActivity_.class));
    }

    @Override
    public void permissionGranted() {
        new Handler().postDelayed(this::gotoNext, 3000);
    }

    @Override
    public void permissionDenied() {

    }

    @Override
    public void permissionForeverDenied() {

    }
}