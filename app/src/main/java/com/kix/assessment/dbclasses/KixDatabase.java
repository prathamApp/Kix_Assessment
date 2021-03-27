package com.kix.assessment.dbclasses;

import android.content.Context;

import com.kix.assessment.dbclasses.dao.AttendanceDao;
import com.kix.assessment.dbclasses.dao.ContentDao;
import com.kix.assessment.dbclasses.dao.HouseholdDao;
import com.kix.assessment.dbclasses.dao.LogDao;
import com.kix.assessment.dbclasses.dao.ScoreDao;
import com.kix.assessment.dbclasses.dao.SessionDao;
import com.kix.assessment.dbclasses.dao.StatusDao;
import com.kix.assessment.dbclasses.dao.StudentDao;
import com.kix.assessment.dbclasses.dao.SurveyorDao;
import com.kix.assessment.modal_classes.Attendance;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_Session;
import com.kix.assessment.modal_classes.Modal_Status;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.modal_classes.Score;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Modal_Student.class, Modal_Surveyor.class, Score.class,
        Modal_Content.class, Modal_Household.class, Modal_Log.class, Attendance.class,
        Modal_Session.class, Modal_Status.class}, version = 1, exportSchema = false)

public abstract class KixDatabase extends RoomDatabase {

    private static KixDatabase INSTANCE;
    public static final String DB_NAME = "kix_db";

    public abstract StudentDao getStudentDao();

    public abstract SurveyorDao getSurveyorDao();

    public abstract ScoreDao getScoreDao();

    public abstract ContentDao getContentDao();

    public abstract HouseholdDao getHouseholdDao();

    public abstract LogDao getLogDao();

    public abstract AttendanceDao getAttendanceDao();

    public abstract SessionDao getSessionDao();

    public abstract StatusDao getStatusDao();

    public static KixDatabase getDatabaseInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    KixDatabase.class, DB_NAME)
//                    .addMigrations()
                    .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

}
