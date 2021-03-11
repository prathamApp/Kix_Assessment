package com.kix.assessment.ui.splash_activityy;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kix.assessment.BaseActivity;
import com.kix.assessment.R;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn_;
import com.kix.assessment.ui.surveyor_SignUP.Fragment_Svr_SignUp;
import com.kix.assessment.ui.surveyor_SignUP.Fragment_Svr_SignUp_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements SplashContract.SplashView {

    @ViewById(R.id.tv_surveyouSignIn)
    TextView tv_surveyorSignIn;

    @ViewById(R.id.btn_signUp)
    Button btn_signUp;

    @Bean(SplashPresenter.class)
    SplashPresenter splashPresenter;

    private BlurPopupWindow dialog_permission;
    KIX_Utility kix_utility;

    @AfterViews
    public void init() {
        kix_utility = new KIX_Utility(this);
        new Handler().postDelayed(this::gotoNext, 2000);
    }

    @UiThread
    public void gotoNext() {
        tv_surveyorSignIn.setVisibility(View.VISIBLE);
        btn_signUp.setVisibility(View.VISIBLE);
        checkPermissionss();
//        startActivity(new Intent(this, MainTestActivity_.class));
    }

    @Click(R.id.btn_signUp)
    public void surveyorSignUp(){
        KIX_Utility.showFragment(this, new Fragment_Svr_SignUp_(), R.id.splash_frame,
                null,Fragment_Svr_SignUp.class.getSimpleName());
    }

    @Click(R.id.tv_surveyouSignIn)
    public void surveyorSignIn(){
        KIX_Utility.showFragment(this, new Fragment_Svr_SignIn_(), R.id.splash_frame,
                null, Fragment_Svr_SignIn.class.getSimpleName());
    }

    public void checkPermissionss() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            dialog_permission = new BlurPopupWindow.Builder(SplashActivity.this)
                    .setContentView(R.layout.permission_detail_dialog)
                    .bindClickListener(v -> {
                        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.RECORD_AUDIO}, 100);
                        dialog_permission.dismiss();
                    }, R.id.btn_perm_okay)
                    .setGravity(Gravity.CENTER)
                    .setDismissOnClickBack(false)
                    .setDismissOnTouchBackground(false)
                    .setScaleRatio(0.2f)
                    .setBlurRadius(8)
                    .setTintColor(0x30000000)
                    .build();
            dialog_permission.show();
        }
    }
}