package com.kix.assessment.ui.splash_activityy;

import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.kix.assessment.BaseActivity;
import com.kix.assessment.R;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.services.shared_preferences.FastSave;
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


@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements SplashContract.SplashView {

    @ViewById(R.id.btn_surveyouSignIn)
    Button tv_surveyorSignIn;

    @ViewById(R.id.btn_signUp)
    Button btn_signUp;

    @Bean(SplashPresenter.class)
    SplashPresenter splashPresenter;

    private BlurPopupWindow dialog_permission;
    KIX_Utility kix_utility;

    @AfterViews
    public void init() {
        this.kix_utility = new KIX_Utility(this);
        this.splashPresenter.setView(this);
        Log.d("TAG", "init: SPLASH LANGUAGE CODE "+FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"));
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        this.gotoNext();
        FastSave.getInstance().saveString(STUDENT_ID, "NA");
        this.splashPresenter.populateDefaultDB();
    }

    @UiThread
    public void gotoNext() {
        this.tv_surveyorSignIn.setVisibility(View.VISIBLE);
        this.btn_signUp.setVisibility(View.VISIBLE);
        this.tv_surveyorSignIn.setText(R.string.have_account_sign_in);
        this.btn_signUp.setText(R.string.sign_up);
        this.checkPermissionss();
    }

    @Click(R.id.btn_signUp)
    public void surveyorSignUp() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            KIX_Utility.getSdCardPath(this);
/*
            if (!FastSave.getInstance().getBoolean(Kix_Constant.DATA_COPIED, false))
                this.splashPresenter.addDataToDB();
            else
*/
                KIX_Utility.showFragment(this, new Fragment_Svr_SignUp_(), R.id.splash_frame,
                    null, Fragment_Svr_SignUp.class.getSimpleName());
        } else {
            Toast.makeText(this, getString(R.string.mandatory_permisson), Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }

    @UiThread
    @Override
    public void openSignupFragment(){
        KIX_Utility.showFragment(this, new Fragment_Svr_SignUp_(), R.id.splash_frame,
                null, Fragment_Svr_SignUp.class.getSimpleName());
    }

    @Click(R.id.btn_surveyouSignIn)
    public void surveyorSignIn() {
        KIX_Utility.getSdCardPath(this);
        KIX_Utility.showFragment(this, new Fragment_Svr_SignIn_(), R.id.splash_frame,
                null, Fragment_Svr_SignIn.class.getSimpleName());
    }

    public void checkPermissionss() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.RECORD_AUDIO}, 100);
/*            dialog_permission = new BlurPopupWindow.Builder(SplashActivity.this)
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
            dialog_permission.show();*/
        }
    }
}