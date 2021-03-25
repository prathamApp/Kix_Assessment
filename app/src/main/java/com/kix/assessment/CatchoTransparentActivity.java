package com.kix.assessment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.kix.assessment.custom.ProcessPhoenix;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.services.shared_preferences.FastSave;

import net.alhazmy13.catcho.library.Catcho;
import net.alhazmy13.catcho.library.error.CatchoError;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.kix.assessment.KIXApplication.logDao;


@SuppressLint("Registered")
public class CatchoTransparentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_report);
        CatchoError error = (CatchoError) getIntent().getSerializableExtra(Catcho.ERROR);
        Modal_Log log = new Modal_Log();
        log.setCurrentDateTime(KIX_Utility.getCurrentDateTime());
        log.setErrorType("ERROR");
        log.setExceptionMessage(error.toString());
        log.setExceptionStackTrace(error.getError());
        log.setMethodName("NO_METHOD");
        log.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, "no_session"));
        log.setDeviceId(KIX_Utility.getDeviceSerialID());
        logDao.insertLog(log);
        findViewById(R.id.btn_report).setOnClickListener(v -> ProcessPhoenix.triggerRebirth(CatchoTransparentActivity.this));
    }
}
