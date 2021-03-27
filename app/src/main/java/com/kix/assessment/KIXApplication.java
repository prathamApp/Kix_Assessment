package com.kix.assessment;

import android.app.Application;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.dbclasses.dao.AttendanceDao;
import com.kix.assessment.dbclasses.dao.ContentDao;
import com.kix.assessment.dbclasses.dao.HouseholdDao;
import com.kix.assessment.dbclasses.dao.LogDao;
import com.kix.assessment.dbclasses.dao.ScoreDao;
import com.kix.assessment.dbclasses.dao.SessionDao;
import com.kix.assessment.dbclasses.dao.StatusDao;
import com.kix.assessment.dbclasses.dao.StudentDao;
import com.kix.assessment.dbclasses.dao.SurveyorDao;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.services.shared_preferences.FastSave;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class KIXApplication extends Application {

    public static String contentSDPath="";
    public static String kixPath="";
    OkHttpClient okHttpClient;
    public static KIXApplication kixApplication;
    private static final DateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
    private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public static StudentDao studentDao;
    public static SurveyorDao surveyorDao;
    public static HouseholdDao householdDao;
    public static ContentDao contentDao;
    public static LogDao logDao;
    public static AttendanceDao attendanceDao;
    public static SessionDao sessionDao;
    public static ScoreDao scoreDao;
    public static StatusDao statusDao;

    @Override
    public void onCreate() {
        super.onCreate();
        FastSave.init(getApplicationContext());
        Fresco.initialize(this);
        if (kixApplication == null) {
            kixApplication = this;
        }
        initializeDatabaseDaos();
        setKixPath();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);
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
        householdDao = kixDatabase.getHouseholdDao();
        contentDao = kixDatabase.getContentDao();
        logDao = kixDatabase.getLogDao();
        attendanceDao = kixDatabase.getAttendanceDao();
        sessionDao = kixDatabase.getSessionDao();
        scoreDao = kixDatabase.getScoreDao();
        statusDao = kixDatabase.getStatusDao();
        /*if (!FastSave.getInstance().getBoolean(PD_Constant.BACKUP_DB_COPIED, false))
            new ReadBackupDb().execute();*/
    }

    public void setKixPath() {
        try {
            kixPath = KIX_Utility.getInternalPath(this);
            File f = new File(kixPath);
            if (!f.exists()) f.mkdirs();
            File nmFile = new File(kixPath, ".nomedia");
            if (!nmFile.exists()) nmFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
