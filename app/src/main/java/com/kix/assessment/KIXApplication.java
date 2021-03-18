package com.kix.assessment;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.dbclasses.dao.StudentDao;
import com.kix.assessment.dbclasses.dao.SurveyorDao;
import com.kix.assessment.services.shared_preferences.FastSave;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

import okhttp3.OkHttpClient;

public class KIXApplication extends Application {

    public static String contentSDPath="";
    OkHttpClient okHttpClient;
    public static KIXApplication kixApplication;
    private static final DateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
    private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public static StudentDao studentDao;
    public static SurveyorDao surveyorDao;

    @Override
    public void onCreate() {
        super.onCreate();
        FastSave.init(getApplicationContext());
        Fresco.initialize(this);
        if (kixApplication == null) {
            kixApplication = this;
        }
        initializeDatabaseDaos();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static UUID getUniqueID() {
        return UUID.randomUUID();
    }

    public static KIXApplication getInstance() {
        return kixApplication;
    }

    private void initializeDatabaseDaos() {
        KixDatabase kixDatabase = KixDatabase.getDatabaseInstance(this);
        studentDao = kixDatabase.getStudentDao();
        surveyorDao = kixDatabase.getSurveyorDao();
        /*if (!FastSave.getInstance().getBoolean(PD_Constant.BACKUP_DB_COPIED, false))
            new ReadBackupDb().execute();*/
    }

}
