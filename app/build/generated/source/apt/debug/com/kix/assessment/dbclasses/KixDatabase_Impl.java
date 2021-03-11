package com.kix.assessment.dbclasses;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class KixDatabase_Impl extends KixDatabase {
  private volatile StudentDao _studentDao;

  private volatile SurveyorDao _surveyorDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Student` (`Stud_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Stud_Name` TEXT, `Stud_Age` TEXT, `Stud_Gender` TEXT, `Stud_Class` TEXT, `Svr_Code` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Surveyor` (`Svr_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Svr_Name` TEXT, `Svr_Email` TEXT, `Svr_Mobile` TEXT, `Svr_Password` TEXT, `Svr_Code` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"cf99459fd021ede55a2891bb5afc0c7a\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Student`");
        _db.execSQL("DROP TABLE IF EXISTS `Surveyor`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(6);
        _columnsStudent.put("Stud_Id", new TableInfo.Column("Stud_Id", "INTEGER", true, 1));
        _columnsStudent.put("Stud_Name", new TableInfo.Column("Stud_Name", "TEXT", false, 0));
        _columnsStudent.put("Stud_Age", new TableInfo.Column("Stud_Age", "TEXT", false, 0));
        _columnsStudent.put("Stud_Gender", new TableInfo.Column("Stud_Gender", "TEXT", false, 0));
        _columnsStudent.put("Stud_Class", new TableInfo.Column("Stud_Class", "TEXT", false, 0));
        _columnsStudent.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudent = new TableInfo("Student", _columnsStudent, _foreignKeysStudent, _indicesStudent);
        final TableInfo _existingStudent = TableInfo.read(_db, "Student");
        if (! _infoStudent.equals(_existingStudent)) {
          throw new IllegalStateException("Migration didn't properly handle Student(com.kix.assessment.modal_classes.Modal_Student).\n"
                  + " Expected:\n" + _infoStudent + "\n"
                  + " Found:\n" + _existingStudent);
        }
        final HashMap<String, TableInfo.Column> _columnsSurveyor = new HashMap<String, TableInfo.Column>(6);
        _columnsSurveyor.put("Svr_Id", new TableInfo.Column("Svr_Id", "INTEGER", true, 1));
        _columnsSurveyor.put("Svr_Name", new TableInfo.Column("Svr_Name", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Email", new TableInfo.Column("Svr_Email", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Mobile", new TableInfo.Column("Svr_Mobile", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Password", new TableInfo.Column("Svr_Password", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSurveyor = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSurveyor = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSurveyor = new TableInfo("Surveyor", _columnsSurveyor, _foreignKeysSurveyor, _indicesSurveyor);
        final TableInfo _existingSurveyor = TableInfo.read(_db, "Surveyor");
        if (! _infoSurveyor.equals(_existingSurveyor)) {
          throw new IllegalStateException("Migration didn't properly handle Surveyor(com.kix.assessment.modal_classes.Modal_Surveyor).\n"
                  + " Expected:\n" + _infoSurveyor + "\n"
                  + " Found:\n" + _existingSurveyor);
        }
      }
    }, "cf99459fd021ede55a2891bb5afc0c7a", "140ba87989a24fb713fcadc8b6677146");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Student","Surveyor");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Student`");
      _db.execSQL("DELETE FROM `Surveyor`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public StudentDao getStudentDao() {
    if (_studentDao != null) {
      return _studentDao;
    } else {
      synchronized(this) {
        if(_studentDao == null) {
          _studentDao = new StudentDao_Impl(this);
        }
        return _studentDao;
      }
    }
  }

  @Override
  public SurveyorDao getSurveyorDao() {
    if (_surveyorDao != null) {
      return _surveyorDao;
    } else {
      synchronized(this) {
        if(_surveyorDao == null) {
          _surveyorDao = new SurveyorDao_Impl(this);
        }
        return _surveyorDao;
      }
    }
  }
}
