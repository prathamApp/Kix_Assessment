package com.kix.assessment;

import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;
import static com.kix.assessment.ui.main_test.WebViewActivity.scoresList;
import static com.kix.assessment.ui.main_test.WebViewActivity.testOnFlg;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kix.assessment.custom.ProcessPhoenix;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.services.shared_preferences.FastSave;

import net.alhazmy13.catcho.library.Catcho;
import net.alhazmy13.catcho.library.error.CatchoError;

import java.util.ArrayList;
import java.util.List;


@SuppressLint("Registered")
public class CatchoTransparentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (scoresList.size()>0 && testOnFlg) {
                testOnFlg = false;
                List<AbandonedScore>abandonedScoreList = new ArrayList<>();
                for (int i =0; i<scoresList.size(); i++) {
                    AbandonedScore abandonedScore = new AbandonedScore();
                    abandonedScore.setDeviceId(scoresList.get(i).getDeviceId());
                    abandonedScore.setResourceId(scoresList.get(i).getResourceId());
                    abandonedScore.setGameType(scoresList.get(i).getGameType());
                    abandonedScore.setScoredMarks(scoresList.get(i).getScoredMarks());
                    abandonedScore.setSessionId(scoresList.get(i).getSessionId());
                    abandonedScore.setStudentId(scoresList.get(i).getStudentId());
                    abandonedScore.setStartDateTime(scoresList.get(i).getStartDateTime());
                    abandonedScore.setEndDateTime(scoresList.get(i).getEndDateTime());
                    abandonedScore.setLabel(scoresList.get(i).getLabel());
                    abandonedScore.setSvrCode(scoresList.get(i).getSvrCode());
                    abandonedScore.setSentFlag(scoresList.get(i).getSentFlag());
                    abandonedScore.setBookletNo(scoresList.get(i).getBookletNo());
                    abandonedScore.setStage(scoresList.get(i).getStage());
                    abandonedScore.setLevel(scoresList.get(i).getLevel());
                    abandonedScore.setCountryName(scoresList.get(i).getCountryName());
                    abandonedScore.setReason("App Crash");
                    abandonedScoreList.add(abandonedScore);
                }
                KixDatabase.getDatabaseInstance(this).getAbandonedScoreDao().addAbandonedScoreList(abandonedScoreList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
        setContentView(R.layout.activity_crash_report);
        CatchoError error = (CatchoError) getIntent().getSerializableExtra(Catcho.ERROR);
        Modal_Log log = new Modal_Log();
        log.setCurrentDateTime(KIX_Utility.getCurrentDateTime());
        log.setErrorType("ERROR");
        log.setExceptionMessage(error.toString());
        log.setExceptionStackTrace(error.getError());
        log.setMethodName("NO_METHOD");
        log.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, "no_session"));
        log.setDeviceId(KIX_Utility.getDeviceID());
        logDao.insertLog(log);
        FastSave.getInstance().saveString(STUDENT_ID, "NA");
        FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
        BackupDatabase.backup(this);
        Log.d("ERROR", "onCreate: \n\n\n"+error.getError());
        findViewById(R.id.btn_restart).setOnClickListener(v -> ProcessPhoenix.triggerRebirth(CatchoTransparentActivity.this));
    }
}
