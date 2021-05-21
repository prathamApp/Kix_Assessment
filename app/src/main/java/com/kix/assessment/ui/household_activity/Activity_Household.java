package com.kix.assessment.ui.household_activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;

import com.kix.assessment.BaseActivity;
import com.kix.assessment.R;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.ui.household_activity.FragmentSelectHousehold.Fragment_SelectHousehold;
import com.kix.assessment.ui.household_activity.FragmentSelectHousehold.Fragment_SelectHousehold_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

import static com.kix.assessment.KIXApplication.householdDao;

@EActivity(R.layout.activity_household)
public class Activity_Household extends BaseActivity {

    String surveyorCode;

    private BlurPopupWindow exitDialog;

    @AfterViews
    public void initialize() {
        surveyorCode = getIntent().getStringExtra(Kix_Constant.SURVEYOR_CODE);
        Modal_Household household = KixDatabase.getDatabaseInstance(this).getHouseholdDao().getHouseholdBySurveyorCode(surveyorCode);
        Bundle bundle = new Bundle();
        if (household == null) {
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            KIX_Utility.addFragment(this, new Fragment_AddHousehold_(), R.id.household_frame,
                    bundle, Fragment_AddHousehold.class.getSimpleName());
        } else {
            ArrayList<Modal_Household> households = (ArrayList<Modal_Household>) householdDao.getAllHouseholdBySurveyorCode(surveyorCode);
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            bundle.putParcelableArrayList(Kix_Constant.HOUSEHOLD_LIST, households);
            KIX_Utility.addFragment(this, new Fragment_SelectHousehold_(), R.id.household_frame,
                    bundle, Fragment_SelectHousehold.class.getSimpleName());
        }
    }

    @Override
    public void onBackPressed() {
        Log.e("KIX : ", String.valueOf(getSupportFragmentManager().getBackStackEntryCount()));
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            exitDialog = new BlurPopupWindow.Builder(this)
                    .setContentView(R.layout.app_exit_dialog)
                    .bindClickListener(v -> {
                        exitDialog.dismiss();
                        new Handler().postDelayed(this::finishAffinity, 200);
                    }, R.id.dia_exit)
                    .bindClickListener(v -> exitDialog.dismiss(), R.id.dia_cancel)
                    .setGravity(Gravity.CENTER)
                    .setDismissOnTouchBackground(true)
                    .setDismissOnClickBack(true)
                    .setScaleRatio(0.2f)
                    .setBlurRadius(10)
                    .setTintColor(0x30000000)
                    .build();
            exitDialog.show();
        } else {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }
}
