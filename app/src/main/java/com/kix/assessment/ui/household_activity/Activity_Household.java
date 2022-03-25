package com.kix.assessment.ui.household_activity;

import static com.kix.assessment.KIXApplication.householdDao;

import android.os.Bundle;
import android.util.Log;

import com.kix.assessment.BaseActivity;
import com.kix.assessment.R;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.household_activity.FragmentSelectHousehold.Fragment_SelectHousehold;
import com.kix.assessment.ui.household_activity.FragmentSelectHousehold.Fragment_SelectHousehold_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

@EActivity(R.layout.activity_household)
public class Activity_Household extends BaseActivity {

    String surveyorCode, villageId;

    private BlurPopupWindow exitDialog;

    @AfterViews
    public void initialize() {
        this.surveyorCode = FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, "NA");
        villageId = getIntent().getStringExtra(Kix_Constant.VILLAGE_ID);
        if(!this.surveyorCode.equalsIgnoreCase("NA")) {
            final Bundle bundle = new Bundle();
            final ArrayList<Modal_Household> households = (ArrayList<Modal_Household>) householdDao.getAllHouseholdBySurveyorCode(surveyorCode, villageId);
            bundle.putString(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
            bundle.putString(Kix_Constant.VILLAGE_ID,villageId);
            bundle.putParcelableArrayList(Kix_Constant.HOUSEHOLD_LIST, households);
            KIX_Utility.addFragment(this, new Fragment_SelectHousehold_(), R.id.household_frame,
                    bundle, Fragment_SelectHousehold.class.getSimpleName());
        }
        /*        Modal_Household household = KixDatabase.getDatabaseInstance(this).getHouseholdDao().getHouseholdBySurveyorCode(surveyorCode);
        Bundle bundle = new Bundle();
        if (household == null) {
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            KIX_Utility.addFragment(this, new Fragment_AddVillage_(), R.id.household_frame,
                    bundle, Fragment_AddVillage.class.getSimpleName());
        } else {
            ArrayList<Modal_Household> households = (ArrayList<Modal_Household>) householdDao.getAllHouseholdBySurveyorCode(surveyorCode);
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            bundle.putParcelableArrayList(Kix_Constant.HOUSEHOLD_LIST, households);
            KIX_Utility.addFragment(this, new Fragment_SelectHousehold_(), R.id.household_frame,
                    bundle, Fragment_SelectHousehold.class.getSimpleName());
        }*/
    }

    @Override
    public void onBackPressed() {
        Log.e("KIX H: ", String.valueOf(this.getSupportFragmentManager().getBackStackEntryCount()));
        if (this.getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
/*            exitDialog = new BlurPopupWindow.Builder(this)
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
            exitDialog.show();*/
        } else {
            this.getSupportFragmentManager().popBackStackImmediate();
        }
    }
}
