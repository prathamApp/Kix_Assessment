package com.kix.assessment.dbclasses;

import android.content.Context;

import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Surveyor;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Modal_Student.class, Modal_Surveyor.class}, version = 1, exportSchema = false)

public abstract class KixDatabase extends RoomDatabase {

    private static KixDatabase INSTANCE;
    public static final String DB_NAME = "kix_db";

    public abstract StudentDao getStudentDao();

    public abstract SurveyorDao getSurveyorDao();

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
