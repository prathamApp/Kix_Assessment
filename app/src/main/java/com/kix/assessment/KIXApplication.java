package com.kix.assessment;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import com.androidnetworking.AndroidNetworking;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.isupatches.wisefy.WiseFy;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.dbclasses.dao.AbandonedScoreDao;
import com.kix.assessment.dbclasses.dao.AttendanceDao;
import com.kix.assessment.dbclasses.dao.ContentDao;
import com.kix.assessment.dbclasses.dao.HouseholdDao;
import com.kix.assessment.dbclasses.dao.HouseholdInformationDao;
import com.kix.assessment.dbclasses.dao.LogDao;
import com.kix.assessment.dbclasses.dao.ParentInformationDao;
import com.kix.assessment.dbclasses.dao.ScoreDao;
import com.kix.assessment.dbclasses.dao.SessionDao;
import com.kix.assessment.dbclasses.dao.StatusDao;
import com.kix.assessment.dbclasses.dao.StudentDao;
import com.kix.assessment.dbclasses.dao.SurveyorDao;
import com.kix.assessment.dbclasses.dao.VillageDao;
import com.kix.assessment.dbclasses.dao.VillageInformationDao;
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

    public static final String appBuildDate = "17-July-2024";
    public static final String app_version = "v2.0.1";
    public static final String app_country = "Pakistan";
    public static String contentSDPath="";
    public static String kixPath="";
    OkHttpClient okHttpClient;
    public static WiseFy wiseF;
    public static boolean isDomainWise;
    public static boolean isSDCard;
    public static KIXApplication kixApplication;
    private static final DateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
    private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public static StudentDao studentDao;
    public static ParentInformationDao parentInformationDao;
    public static SurveyorDao surveyorDao;
    public static HouseholdDao householdDao;
    public static HouseholdInformationDao householdInformationDao;
    public static VillageDao villageDao;
    public static VillageInformationDao villageInformationDao;
    public static ContentDao contentDao;
    public static LogDao logDao;
    public static AttendanceDao attendanceDao;
    public static SessionDao sessionDao;
    public static ScoreDao scoreDao;
    public static AbandonedScoreDao abandonedScoreDao;
    public static StatusDao statusDao;

    public static KIXApplication getInstance() {
        return kixApplication;
    }

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
        wiseF = new WiseFy.Brains(getApplicationContext()).logging(true).getSmarts();
        okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);
    }

    public static UUID getUniqueID() {
        return UUID.randomUUID();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private void initializeDatabaseDaos() {
        KixDatabase kixDatabase = KixDatabase.getDatabaseInstance(this);
        studentDao = kixDatabase.getStudentDao();
        parentInformationDao = kixDatabase.getParentInformationDao();
        surveyorDao = kixDatabase.getSurveyorDao();
        householdDao = kixDatabase.getHouseholdDao();
        householdInformationDao = kixDatabase.getHouseholdInformationDao();
        villageDao = kixDatabase.getVillageDao();
        villageInformationDao = kixDatabase.getVillageInformationDao();
        contentDao = kixDatabase.getContentDao();
        logDao = kixDatabase.getLogDao();
        attendanceDao = kixDatabase.getAttendanceDao();
        sessionDao = kixDatabase.getSessionDao();
        scoreDao = kixDatabase.getScoreDao();
        abandonedScoreDao = kixDatabase.getAbandonedScoreDao();
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

    public static File getStoragePath() {
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.R)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        } else {
            return Environment.getExternalStorageDirectory();
        }
    }

}
