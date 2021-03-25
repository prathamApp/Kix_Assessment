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
import com.kix.assessment.dbclasses.dao.ContentDao;
import com.kix.assessment.dbclasses.dao.ContentDao_Impl;
import com.kix.assessment.dbclasses.dao.HouseholdDao;
import com.kix.assessment.dbclasses.dao.HouseholdDao_Impl;
import com.kix.assessment.dbclasses.dao.ScoreDao;
import com.kix.assessment.dbclasses.dao.ScoreDao_Impl;
import com.kix.assessment.dbclasses.dao.StudentDao;
import com.kix.assessment.dbclasses.dao.StudentDao_Impl;
import com.kix.assessment.dbclasses.dao.SurveyorDao;
import com.kix.assessment.dbclasses.dao.SurveyorDao_Impl;
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

  private volatile ScoreDao _scoreDao;

  private volatile ContentDao _contentDao;

  private volatile HouseholdDao _householdDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Student` (`S_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Stud_Id` TEXT, `Stud_Name` TEXT, `Stud_Age` TEXT, `Stud_Gender` TEXT, `Stud_Class` TEXT, `Svr_Code` TEXT, `Household_ID` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Surveyor` (`Svr_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Svr_Name` TEXT, `Svr_Email` TEXT, `Svr_Mobile` TEXT, `Svr_Password` TEXT, `Svr_Code` TEXT, `Svr_Booklet` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Score` (`ScoreId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `SessionID` TEXT, `StudentID` TEXT, `DeviceID` TEXT, `ResourceID` TEXT, `ScoredMarks` TEXT, `StartDateTime` TEXT, `EndDateTime` TEXT, `Label` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Content` (`contentId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contentCode` TEXT, `contentFolderName` TEXT, `contentBooklet` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Household` (`hh_ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `houseHold_ID` TEXT, `houseHold_Name` TEXT, `houseHold_Address` TEXT, `Svr_Code` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"a7e9a81613f73df8f2b18a17e9176443\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Student`");
        _db.execSQL("DROP TABLE IF EXISTS `Surveyor`");
        _db.execSQL("DROP TABLE IF EXISTS `Score`");
        _db.execSQL("DROP TABLE IF EXISTS `Content`");
        _db.execSQL("DROP TABLE IF EXISTS `Household`");
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
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(8);
        _columnsStudent.put("S_Id", new TableInfo.Column("S_Id", "INTEGER", true, 1));
        _columnsStudent.put("Stud_Id", new TableInfo.Column("Stud_Id", "TEXT", false, 0));
        _columnsStudent.put("Stud_Name", new TableInfo.Column("Stud_Name", "TEXT", false, 0));
        _columnsStudent.put("Stud_Age", new TableInfo.Column("Stud_Age", "TEXT", false, 0));
        _columnsStudent.put("Stud_Gender", new TableInfo.Column("Stud_Gender", "TEXT", false, 0));
        _columnsStudent.put("Stud_Class", new TableInfo.Column("Stud_Class", "TEXT", false, 0));
        _columnsStudent.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        _columnsStudent.put("Household_ID", new TableInfo.Column("Household_ID", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudent = new TableInfo("Student", _columnsStudent, _foreignKeysStudent, _indicesStudent);
        final TableInfo _existingStudent = TableInfo.read(_db, "Student");
        if (! _infoStudent.equals(_existingStudent)) {
          throw new IllegalStateException("Migration didn't properly handle Student(com.kix.assessment.modal_classes.Modal_Student).\n"
                  + " Expected:\n" + _infoStudent + "\n"
                  + " Found:\n" + _existingStudent);
        }
        final HashMap<String, TableInfo.Column> _columnsSurveyor = new HashMap<String, TableInfo.Column>(7);
        _columnsSurveyor.put("Svr_Id", new TableInfo.Column("Svr_Id", "INTEGER", true, 1));
        _columnsSurveyor.put("Svr_Name", new TableInfo.Column("Svr_Name", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Email", new TableInfo.Column("Svr_Email", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Mobile", new TableInfo.Column("Svr_Mobile", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Password", new TableInfo.Column("Svr_Password", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Booklet", new TableInfo.Column("Svr_Booklet", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSurveyor = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSurveyor = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSurveyor = new TableInfo("Surveyor", _columnsSurveyor, _foreignKeysSurveyor, _indicesSurveyor);
        final TableInfo _existingSurveyor = TableInfo.read(_db, "Surveyor");
        if (! _infoSurveyor.equals(_existingSurveyor)) {
          throw new IllegalStateException("Migration didn't properly handle Surveyor(com.kix.assessment.modal_classes.Modal_Surveyor).\n"
                  + " Expected:\n" + _infoSurveyor + "\n"
                  + " Found:\n" + _existingSurveyor);
        }
        final HashMap<String, TableInfo.Column> _columnsScore = new HashMap<String, TableInfo.Column>(10);
        _columnsScore.put("ScoreId", new TableInfo.Column("ScoreId", "INTEGER", true, 1));
        _columnsScore.put("SessionID", new TableInfo.Column("SessionID", "TEXT", false, 0));
        _columnsScore.put("StudentID", new TableInfo.Column("StudentID", "TEXT", false, 0));
        _columnsScore.put("DeviceID", new TableInfo.Column("DeviceID", "TEXT", false, 0));
        _columnsScore.put("ResourceID", new TableInfo.Column("ResourceID", "TEXT", false, 0));
        _columnsScore.put("ScoredMarks", new TableInfo.Column("ScoredMarks", "TEXT", false, 0));
        _columnsScore.put("StartDateTime", new TableInfo.Column("StartDateTime", "TEXT", false, 0));
        _columnsScore.put("EndDateTime", new TableInfo.Column("EndDateTime", "TEXT", false, 0));
        _columnsScore.put("Label", new TableInfo.Column("Label", "TEXT", false, 0));
        _columnsScore.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScore = new TableInfo("Score", _columnsScore, _foreignKeysScore, _indicesScore);
        final TableInfo _existingScore = TableInfo.read(_db, "Score");
        if (! _infoScore.equals(_existingScore)) {
          throw new IllegalStateException("Migration didn't properly handle Score(com.kix.assessment.modal_classes.Score).\n"
                  + " Expected:\n" + _infoScore + "\n"
                  + " Found:\n" + _existingScore);
        }
        final HashMap<String, TableInfo.Column> _columnsContent = new HashMap<String, TableInfo.Column>(4);
        _columnsContent.put("contentId", new TableInfo.Column("contentId", "INTEGER", true, 1));
        _columnsContent.put("contentCode", new TableInfo.Column("contentCode", "TEXT", false, 0));
        _columnsContent.put("contentFolderName", new TableInfo.Column("contentFolderName", "TEXT", false, 0));
        _columnsContent.put("contentBooklet", new TableInfo.Column("contentBooklet", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContent = new TableInfo("Content", _columnsContent, _foreignKeysContent, _indicesContent);
        final TableInfo _existingContent = TableInfo.read(_db, "Content");
        if (! _infoContent.equals(_existingContent)) {
          throw new IllegalStateException("Migration didn't properly handle Content(com.kix.assessment.modal_classes.Modal_Content).\n"
                  + " Expected:\n" + _infoContent + "\n"
                  + " Found:\n" + _existingContent);
        }
        final HashMap<String, TableInfo.Column> _columnsHousehold = new HashMap<String, TableInfo.Column>(5);
        _columnsHousehold.put("hh_ID", new TableInfo.Column("hh_ID", "INTEGER", true, 1));
        _columnsHousehold.put("houseHold_ID", new TableInfo.Column("houseHold_ID", "TEXT", false, 0));
        _columnsHousehold.put("houseHold_Name", new TableInfo.Column("houseHold_Name", "TEXT", false, 0));
        _columnsHousehold.put("houseHold_Address", new TableInfo.Column("houseHold_Address", "TEXT", false, 0));
        _columnsHousehold.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHousehold = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHousehold = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHousehold = new TableInfo("Household", _columnsHousehold, _foreignKeysHousehold, _indicesHousehold);
        final TableInfo _existingHousehold = TableInfo.read(_db, "Household");
        if (! _infoHousehold.equals(_existingHousehold)) {
          throw new IllegalStateException("Migration didn't properly handle Household(com.kix.assessment.modal_classes.Modal_Household).\n"
                  + " Expected:\n" + _infoHousehold + "\n"
                  + " Found:\n" + _existingHousehold);
        }
      }
    }, "a7e9a81613f73df8f2b18a17e9176443", "21c3fae87226f3fe5dce6e22110bfdb6");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Student","Surveyor","Score","Content","Household");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Student`");
      _db.execSQL("DELETE FROM `Surveyor`");
      _db.execSQL("DELETE FROM `Score`");
      _db.execSQL("DELETE FROM `Content`");
      _db.execSQL("DELETE FROM `Household`");
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

  @Override
  public ScoreDao getScoreDao() {
    if (_scoreDao != null) {
      return _scoreDao;
    } else {
      synchronized(this) {
        if(_scoreDao == null) {
          _scoreDao = new ScoreDao_Impl(this);
        }
        return _scoreDao;
      }
    }
  }

  @Override
  public ContentDao getContentDao() {
    if (_contentDao != null) {
      return _contentDao;
    } else {
      synchronized(this) {
        if(_contentDao == null) {
          _contentDao = new ContentDao_Impl(this);
        }
        return _contentDao;
      }
    }
  }

  @Override
  public HouseholdDao getHouseholdDao() {
    if (_householdDao != null) {
      return _householdDao;
    } else {
      synchronized(this) {
        if(_householdDao == null) {
          _householdDao = new HouseholdDao_Impl(this);
        }
        return _householdDao;
      }
    }
  }
}
