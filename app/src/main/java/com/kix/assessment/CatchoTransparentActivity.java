package com.kix.assessment;

import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.custom.ProcessPhoenix;
import com.kix.assessment.custom.catcho.Catcho;
import com.kix.assessment.custom.catcho.error.CatchoError;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Score;
import com.kix.assessment.services.shared_preferences.FastSave;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@SuppressLint("Registered")
public class CatchoTransparentActivity extends AppCompatActivity {

    public List<Score> scoresList;
    boolean testFlag;
    String scoreJson;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.testFlag = FastSave.getInstance().getBoolean(Kix_Constant.TEST_FLAG,false);
            this.scoreJson = FastSave.getInstance().getString(Kix_Constant.SCORE_LIST,"");
            Log.e("ScoreJson :", this.scoreJson);
            final Type listType = new TypeToken<List<Score>>() {}.getType();
            this.scoresList = new Gson().fromJson(this.scoreJson, listType);

            Log.e("ScoreList :", this.scoresList.toString());

            if (this.scoresList.size()>0 && this.testFlag) {
                FastSave.getInstance().saveBoolean(Kix_Constant.TEST_FLAG, false);
                final List<AbandonedScore>abandonedScoreList = new ArrayList<>();
                for (int i = 0; i< this.scoresList.size(); i++) {
                    final AbandonedScore abandonedScore = new AbandonedScore();
                    abandonedScore.setDeviceId(this.scoresList.get(i).getDeviceId());
                    abandonedScore.setResourceId(this.scoresList.get(i).getResourceId());
                    abandonedScore.setGameType(this.scoresList.get(i).getGameType());
                    abandonedScore.setScoredMarks(this.scoresList.get(i).getScoredMarks());
                    abandonedScore.setSessionId(this.scoresList.get(i).getSessionId());
                    abandonedScore.setStudentId(this.scoresList.get(i).getStudentId());
                    abandonedScore.setStartDateTime(this.scoresList.get(i).getStartDateTime());
                    abandonedScore.setEndDateTime(this.scoresList.get(i).getEndDateTime());
                    abandonedScore.setLabel(this.scoresList.get(i).getLabel());
                    abandonedScore.setSvrCode(this.scoresList.get(i).getSvrCode());
                    abandonedScore.setSentFlag(this.scoresList.get(i).getSentFlag());
                    abandonedScore.setBookletNo(this.scoresList.get(i).getBookletNo());
                    abandonedScore.setStage(this.scoresList.get(i).getStage());
                    abandonedScore.setLevel(this.scoresList.get(i).getLevel());
                    abandonedScore.setCountryName(this.scoresList.get(i).getCountryName());
                    abandonedScore.setReason("App Crash");
                    abandonedScoreList.add(abandonedScore);
                }
                KixDatabase.getDatabaseInstance(this).getAbandonedScoreDao().addAbandonedScoreList(abandonedScoreList);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
        this.setContentView(R.layout.activity_crash_report);
        final CatchoError error = (CatchoError) this.getIntent().getSerializableExtra(Catcho.ERROR);
        final Modal_Log log = new Modal_Log();
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
        this.findViewById(R.id.btn_restart).setOnClickListener(v -> ProcessPhoenix.triggerRebirth(this));
    }
}
