package com.kix.assessment.ui.attendance_activity;

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
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.Fragment_SelectStudent;
import com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.Fragment_SelectStudent_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

import static com.kix.assessment.KIXApplication.studentDao;

@EActivity(R.layout.activity_attendance)
public class Activity_Attendance extends BaseActivity {

    String surveyorCode;
    private ArrayList<Modal_Student> students = new ArrayList<>();

    private BlurPopupWindow exitDialog;

    @AfterViews
    public void initialize() {
        surveyorCode = getIntent().getStringExtra(Kix_Constant.SURVEYOR_CODE);
        Modal_Student student = KixDatabase.getDatabaseInstance(this).getStudentDao().getStudentBySurveyorCode(surveyorCode);
        Bundle bundle = new Bundle();
        if (student == null) {
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            KIX_Utility.addFragment(this, new Fragment_AddStudent_(), R.id.attendance_frame,
                    bundle, Fragment_AddStudent.class.getSimpleName());
        } else {
            ArrayList<Modal_Student> students = (ArrayList<Modal_Student>) studentDao.getAllStudentsBySurveyorCode(surveyorCode);
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            bundle.putParcelableArrayList(Kix_Constant.STUDENT_LIST, students);
            KIX_Utility.addFragment(this, new Fragment_SelectStudent_(), R.id.attendance_frame,
                    bundle, Fragment_SelectStudent.class.getSimpleName());
        }
    }

    @Override
    public void onBackPressed() {
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.attendance_frame);
        Log.e("KIX : ", String.valueOf(getSupportFragmentManager().getBackStackEntryCount()));
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            exitDialog = new BlurPopupWindow.Builder(this)
                    .setContentView(R.layout.app_exit_dialog)
                    .bindClickListener(v -> {
                        exitDialog.dismiss();
                        new Handler().postDelayed(this::finishAffinity, 200);
                    }, R.id.dialog_btn_exit)
                    .bindClickListener(v -> exitDialog.dismiss(), R.id.btn_cancel)
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
