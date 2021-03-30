package com.kix.assessment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kix.assessment.async.CopyDbToOTG;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Attendance;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_PushData;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.modal_classes.Score;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.kix.assessment.KIXApplication.attendanceDao;
import static com.kix.assessment.KIXApplication.householdDao;
import static com.kix.assessment.KIXApplication.scoreDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.KIXApplication.studentDao;
import static com.kix.assessment.KIXApplication.surveyorDao;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();
    private static final int HIDE_SYSTEM_UI = 2;
    private static final int SHOW_OTG_TRANSFER_DIALOG = 9;
    private static final int SDCARD_LOCATION_CHOOSER = 10;
    private static final int SHOW_OTG_SELECT_DIALOG = 11;
    private static final int HIDE_OTG_TRANSFER_DIALOG_SUCCESS = 12;
    private static final int HIDE_OTG_TRANSFER_DIALOG_FAILED = 13;

    TextView txt_push_dialog_msg;
    TextView txt_push_error;
    BlurPopupWindow pushDialog;
    BlurPopupWindow sd_builder;

    @SuppressLint("HandlerLeak")
    private final Handler mHandler = new Handler() {
        @SuppressLint({"MissingPermission", "SetTextI18n"})
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SHOW_OTG_TRANSFER_DIALOG:
                    sd_builder = new BlurPopupWindow.Builder(BaseActivity.this)
                            .setContentView(R.layout.dialog_alert_sd_card)
                            .setGravity(Gravity.CENTER)
                            .setScaleRatio(0.2f)
                            .bindClickListener(v -> {
                                new Handler().postDelayed(() -> {
                                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                                    startActivityForResult(intent, SDCARD_LOCATION_CHOOSER);
                                }, 1200);
                                sd_builder.dismiss();
                            }, R.id.txt_choose_sd_card)
                            .setDismissOnClickBack(true)
                            .setDismissOnTouchBackground(false)
                            .setScaleRatio(0.2f)
                            .setBlurRadius(8)
                            .setTintColor(0x30000000)
                            .build();
                    ((TextView) sd_builder.findViewById(R.id.txt_choose_sd_card)).setText("Select OTG");
                    sd_builder.show();
                    break;
                case SHOW_OTG_SELECT_DIALOG:
                    pushDialog = new BlurPopupWindow.Builder(BaseActivity.this)
                            .setContentView(R.layout.app_success_dialog)
                            .setGravity(Gravity.CENTER)
                            .setScaleRatio(0.2f)
                            .setDismissOnClickBack(true)
                            .setDismissOnTouchBackground(true)
                            .setBlurRadius(10)
                            .setTintColor(0x30000000)
                            .build();
                    //push_lottie = pushDialog.findViewById(R.id.push_lottie);
                    txt_push_dialog_msg = pushDialog.findViewById(R.id.txt_push_dialog_msg);
                    txt_push_error = pushDialog.findViewById(R.id.txt_push_error);
                    pushDialog.show();
                    break;
                case HIDE_OTG_TRANSFER_DIALOG_SUCCESS:
                    //push_lottie.setAnimation("success.json");
                    //push_lottie.playAnimation();
                    txt_push_dialog_msg.setText("Data Copied Successfully!!");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pushDialog.dismiss();
                        }
                    }, 1500);
                    break;
                case HIDE_OTG_TRANSFER_DIALOG_FAILED:
                    //push_lottie.setAnimation("error_cross.json");
                    //push_lottie.playAnimation();
                    txt_push_dialog_msg.setText("Data Copying Failed!! Please re-insert the OTG");
                    txt_push_error.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pushDialog.dismiss();
                        }
                    }, 1500);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        hideSystemUI();
        super.onCreate(savedInstanceState);
/*        Catcho.Builder(this)
                .activity(CatchoTransparentActivity.class)
//                .recipients("abc@gm.com")
                .build();*/
    }

    private void hideSystemUI() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//                    requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
        BackupDatabase.backup(this);
    }

    @Override
    protected void onPause() {
        BackupDatabase.backup(this);
        super.onPause();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        mHandler.sendEmptyMessage(HIDE_SYSTEM_UI);
    }

    @Subscribe
    public void updateFlagsWhenPushed(EventMessage message) {
        if (message != null) {
            if (message.getMessage().equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
                Gson gson = new Gson();
                Modal_PushData pushedData = gson.fromJson(message.getPushData(), Modal_PushData.class);
                for (Modal_PushData.Modal_PushSessionData pushed : pushedData.getPushSession()) {
                    sessionDao.updateFlag(pushed.getSessionId());
                    for (Score score : pushed.getScores())
                        scoreDao.updateFlag(pushed.getSessionId());
                    for (Attendance att : pushed.getAttendances())
                        attendanceDao.updateSentFlag(pushed.getSessionId());
                }
                if (pushedData.getStudents() != null)
                    for (Modal_Student student : pushedData.getStudents())
                        studentDao.updateSentStudentFlags(student.getStud_Id());
                if (pushedData.getSurveyors() != null)
                    for (Modal_Surveyor surveyor : pushedData.getSurveyors())
                        surveyorDao.updateSentSurveyorFlags(surveyor.getSvr_Code());
                if (pushedData.getHouseholds() != null)
                    for (Modal_Household household : pushedData.getHouseholds())
                        householdDao.updateSentHouseholdFlags(household.getHouseHold_ID());

                BackupDatabase.backup(KIXApplication.getInstance());
            } else
            if (message.getMessage().equalsIgnoreCase(Kix_Constant.OTG_INSERTED)) {
                mHandler.sendEmptyMessage(SHOW_OTG_TRANSFER_DIALOG);
            } else if (message.getMessage().equalsIgnoreCase(Kix_Constant.BACKUP_DB_COPIED)) {
                mHandler.sendEmptyMessage(HIDE_OTG_TRANSFER_DIALOG_SUCCESS);
            } else if (message.getMessage().equalsIgnoreCase(Kix_Constant.BACKUP_DB_NOT_COPIED)) {
                mHandler.sendEmptyMessage(HIDE_OTG_TRANSFER_DIALOG_FAILED);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SDCARD_LOCATION_CHOOSER) {
            if (data != null && data.getData() != null) {
                Uri treeUri = data.getData();
                final int takeFlags = data.getFlags()
                        & (Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                KIXApplication.getInstance().getContentResolver().takePersistableUriPermission(treeUri, takeFlags);
                mHandler.sendEmptyMessage(SHOW_OTG_SELECT_DIALOG);
                new CopyDbToOTG().execute(treeUri);
            }
        }
    }

}
