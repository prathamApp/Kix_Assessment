package com.kix.assessment;

import android.app.Application;
import android.content.Context;

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

    public static String contentSDPath="";
    public static String kixPath="";
    OkHttpClient okHttpClient;
    public static WiseFy wiseF;
//    public static String returnLang = "Spanish-Mexico";
    public static final String appBuildDate = "18-June-22";
//    public static String returnLang = "urdu";
//    public static String returnLang = "kiswahili";
//    public static String returnLang = "Hindi-India";
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

    @Override
    public void onCreate() {
        super.onCreate();
        FastSave.init(this.getApplicationContext());
        Fresco.initialize(this);
        if (KIXApplication.kixApplication == null) {
            KIXApplication.kixApplication = this;
        }
        this.initializeDatabaseDaos();
        this.setKixPath();
        KIXApplication.wiseF = new WiseFy.Brains(this.getApplicationContext()).logging(true).getSmarts();
        this.okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.initialize(this.getApplicationContext(), this.okHttpClient);
    }

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(base);
    }

    public static UUID getUniqueID() {
        return UUID.randomUUID();
    }

    public static KIXApplication getInstance() {
        return KIXApplication.kixApplication;
    }

    private void initializeDatabaseDaos() {
        final KixDatabase kixDatabase = KixDatabase.getDatabaseInstance(this);
        KIXApplication.studentDao = kixDatabase.getStudentDao();
        KIXApplication.parentInformationDao = kixDatabase.getParentInformationDao();
        KIXApplication.surveyorDao = kixDatabase.getSurveyorDao();
        KIXApplication.householdDao = kixDatabase.getHouseholdDao();
        KIXApplication.householdInformationDao = kixDatabase.getHouseholdInformationDao();
        KIXApplication.villageDao = kixDatabase.getVillageDao();
        KIXApplication.villageInformationDao = kixDatabase.getVillageInformationDao();
        KIXApplication.contentDao = kixDatabase.getContentDao();
        KIXApplication.logDao = kixDatabase.getLogDao();
        KIXApplication.attendanceDao = kixDatabase.getAttendanceDao();
        KIXApplication.sessionDao = kixDatabase.getSessionDao();
        KIXApplication.scoreDao = kixDatabase.getScoreDao();
        KIXApplication.abandonedScoreDao = kixDatabase.getAbandonedScoreDao();
        KIXApplication.statusDao = kixDatabase.getStatusDao();
        /*if (!FastSave.getInstance().getBoolean(PD_Constant.BACKUP_DB_COPIED, false))
            new ReadBackupDb().execute();*/
    }

    public void setKixPath() {
        try {
            KIXApplication.kixPath = KIX_Utility.getInternalPath(this);
            final File f = new File(KIXApplication.kixPath);
            if (!f.exists()) f.mkdirs();
            final File nmFile = new File(KIXApplication.kixPath, ".nomedia");
            if (!nmFile.exists()) nmFile.createNewFile();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
