package com.kix.assessment.dbclasses;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.kix.assessment.dbclasses.dao.AbandonedScoreDao;
import com.kix.assessment.dbclasses.dao.AttendanceDao;
import com.kix.assessment.dbclasses.dao.ContentDao;
import com.kix.assessment.dbclasses.dao.HouseholdDao;
import com.kix.assessment.dbclasses.dao.LogDao;
import com.kix.assessment.dbclasses.dao.ScoreDao;
import com.kix.assessment.dbclasses.dao.SessionDao;
import com.kix.assessment.dbclasses.dao.StatusDao;
import com.kix.assessment.dbclasses.dao.StudentDao;
import com.kix.assessment.dbclasses.dao.SurveyorDao;
import com.kix.assessment.dbclasses.dao.VillageDao;
import com.kix.assessment.dbclasses.dao.VillageInformationDao;
import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.Attendance;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_Session;
import com.kix.assessment.modal_classes.Modal_Status;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.modal_classes.Modal_VIF;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.modal_classes.Score;

@Database(entities = {Modal_Student.class, Modal_Surveyor.class, Score.class,
        Modal_Content.class, Modal_Household.class, Modal_Log.class, Attendance.class,
        Modal_Session.class, Modal_Status.class, AbandonedScore.class, Modal_Village.class,
        Modal_VIF.class},
        version = 2, exportSchema = false)

public abstract class KixDatabase extends RoomDatabase {

    private static KixDatabase INSTANCE;
    public static final String DB_NAME = "kix_db";

    public abstract StudentDao getStudentDao();

    public abstract SurveyorDao getSurveyorDao();

    public abstract ScoreDao getScoreDao();

    public abstract AbandonedScoreDao getAbandonedScoreDao();

    public abstract ContentDao getContentDao();

    public abstract HouseholdDao getHouseholdDao();

    public abstract LogDao getLogDao();

    public abstract AttendanceDao getAttendanceDao();

    public abstract SessionDao getSessionDao();

    public abstract StatusDao getStatusDao();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            Log.d("AppDatabase", "MIGRATION_1_2:                                  1");
            database.execSQL("CREATE TABLE IF NOT EXISTS Village" +
                    "('villageId' TEXT PRIMARY KEY NOT NULL," +
                    "'villageName' TEXT ,'villageDistrict' TEXT ,'villageState' TEXT ," +
                    "'villageDate' TEXT ,'countryName' TEXT ,'svrCode' TEXT," +
                    "'sentFlag' INTEGER NOT NULL DEFAULT 0)");
            database.execSQL("CREATE TABLE IF NOT EXISTS VillageInformartion" +
                    "('vif_Id' TEXT PRIMARY KEY NOT NULL," +
                    "'V01' TEXT ,'V02' TEXT , 'V03' TEXT , 'V04' TEXT ," +
                    "'V05' TEXT , 'V06a' TEXT , 'V06b' TEXT , 'V07a' TEXT , 'V07b' TEXT ," +
                    "'villageId' TEXT, 'svrCode' TEXT," +
                    "'sentFlag' INTEGER NOT NULL DEFAULT 0)");
        }
    };

    public static KixDatabase getDatabaseInstance(Context context) {
        if (KixDatabase.INSTANCE == null) {
            KixDatabase.INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    KixDatabase.class, KixDatabase.DB_NAME)
                    .allowMainThreadQueries()
                    .addMigrations(KixDatabase.MIGRATION_1_2)
                    .build();
        }
        return KixDatabase.INSTANCE;
    }

    public static void destroyInstance() {
        KixDatabase.INSTANCE = null;
    }

    public abstract VillageDao getVillageDao();

    public abstract VillageInformationDao getVillageInformationDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

}
