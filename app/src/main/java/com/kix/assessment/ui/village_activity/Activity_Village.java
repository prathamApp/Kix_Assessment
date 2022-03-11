package com.kix.assessment.ui.village_activity;

import static com.kix.assessment.KIXApplication.villageDao;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;

import com.kix.assessment.BaseActivity;
import com.kix.assessment.R;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.ui.village_activity.FragmentSelectVillage.Fragment_SelectVillage;
import com.kix.assessment.ui.village_activity.FragmentSelectVillage.Fragment_SelectVillage_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

@EActivity(R.layout.activity_village)
public class Activity_Village extends BaseActivity {

    String surveyorCode;

    private BlurPopupWindow exitDialog;

    @AfterViews
    public void initialize() {
        this.surveyorCode = this.getIntent().getStringExtra(Kix_Constant.SURVEYOR_CODE);
        final Bundle bundle = new Bundle();
        final ArrayList<Modal_Village> villages = (ArrayList<Modal_Village>) villageDao.getAllVillageBySurveyorCode(this.surveyorCode);
        bundle.putString(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        bundle.putParcelableArrayList(Kix_Constant.VILLAGE_LIST, villages);
        KIX_Utility.addFragment(this, new Fragment_SelectVillage_(), R.id.frag_frame,
                bundle, Fragment_SelectVillage.class.getSimpleName());
    }

    @Override
    public void onBackPressed() {
        Log.e("KIX : ", String.valueOf(this.getSupportFragmentManager().getBackStackEntryCount()));
        if (this.getSupportFragmentManager().getBackStackEntryCount() == 1) {
            this.exitDialog = new BlurPopupWindow.Builder(this)
                    .setContentView(R.layout.app_exit_dialog)
                    .bindClickListener(v -> {
                        this.exitDialog.dismiss();
                        new Handler().postDelayed(this::finishAffinity, 200);
                    }, R.id.dia_exit)
                    .bindClickListener(v -> this.exitDialog.dismiss(), R.id.dia_cancel)
                    .setGravity(Gravity.CENTER)
                    .setDismissOnTouchBackground(true)
                    .setDismissOnClickBack(true)
                    .setScaleRatio(0.2f)
                    .setBlurRadius(10)
                    .setTintColor(0x30000000)
                    .build();
            this.exitDialog.show();
        } else {
            this.getSupportFragmentManager().popBackStackImmediate();
        }
    }
}
