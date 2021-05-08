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
import com.kix.assessment.dbclasses.dao.AttendanceDao;
import com.kix.assessment.dbclasses.dao.AttendanceDao_Impl;
import com.kix.assessment.dbclasses.dao.ContentDao;
import com.kix.assessment.dbclasses.dao.ContentDao_Impl;
import com.kix.assessment.dbclasses.dao.HouseholdDao;
import com.kix.assessment.dbclasses.dao.HouseholdDao_Impl;
import com.kix.assessment.dbclasses.dao.LogDao;
import com.kix.assessment.dbclasses.dao.LogDao_Impl;
import com.kix.assessment.dbclasses.dao.ScoreDao;
import com.kix.assessment.dbclasses.dao.ScoreDao_Impl;
import com.kix.assessment.dbclasses.dao.SessionDao;
import com.kix.assessment.dbclasses.dao.SessionDao_Impl;
import com.kix.assessment.dbclasses.dao.StatusDao;
import com.kix.assessment.dbclasses.dao.StatusDao_Impl;
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

  private volatile LogDao _logDao;

  private volatile AttendanceDao _attendanceDao;

  private volatile SessionDao _sessionDao;

  private volatile StatusDao _statusDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Student` (`S_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `StudentID` TEXT, `Stud_Name` TEXT, `Stud_Age` TEXT, `Stud_Gender` TEXT, `Stud_Class` TEXT, `Stud_EnrollmentStatus` TEXT, `Stud_SchoolType` TEXT, `Stud_DropoutYear` TEXT, `Svr_Code` TEXT, `HouseHold_ID` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Surveyor` (`Svr_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Svr_Name` TEXT, `Svr_Email` TEXT, `Svr_Mobile` TEXT, `Svr_Password` TEXT, `Svr_Code` TEXT, `Svr_Booklet` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Score` (`ScoreId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `SessionID` TEXT, `StudentID` TEXT, `DeviceID` TEXT, `ResourceID` TEXT, `ScoredMarks` TEXT, `StartDateTime` TEXT, `EndDateTime` TEXT, `Label` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Content` (`contentId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contentCode` TEXT, `contentFolderName` TEXT, `contentBooklet` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Household` (`hh_ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `HouseHold_ID` TEXT, `HouseHold_Name` TEXT, `HouseHold_District` TEXT, `HouseHold_State` TEXT, `HouseHold_Address` TEXT, `Svr_Code` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Logs` (`logId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `currentDateTime` TEXT, `exceptionMessage` TEXT, `exceptionStackTrace` TEXT, `methodName` TEXT, `errorType` TEXT, `sessionId` TEXT, `deviceId` TEXT, `LogDetail` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Attendance` (`AttendanceID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `SessionID` TEXT, `StudentID` TEXT, `Date` TEXT, `Present` INTEGER NOT NULL, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Session` (`SessionID` TEXT NOT NULL, `fromDate` TEXT, `toDate` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`SessionID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Status` (`statusKey` TEXT NOT NULL, `value` TEXT NOT NULL, `description` TEXT, PRIMARY KEY(`statusKey`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"c5964ae7758a8aef133eb1e84e8e0047\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Student`");
        _db.execSQL("DROP TABLE IF EXISTS `Surveyor`");
        _db.execSQL("DROP TABLE IF EXISTS `Score`");
        _db.execSQL("DROP TABLE IF EXISTS `Content`");
        _db.execSQL("DROP TABLE IF EXISTS `Household`");
        _db.execSQL("DROP TABLE IF EXISTS `Logs`");
        _db.execSQL("DROP TABLE IF EXISTS `Attendance`");
        _db.execSQL("DROP TABLE IF EXISTS `Session`");
        _db.execSQL("DROP TABLE IF EXISTS `Status`");
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
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(12);
        _columnsStudent.put("S_Id", new TableInfo.Column("S_Id", "INTEGER", true, 1));
        _columnsStudent.put("StudentID", new TableInfo.Column("StudentID", "TEXT", false, 0));
        _columnsStudent.put("Stud_Name", new TableInfo.Column("Stud_Name", "TEXT", false, 0));
        _columnsStudent.put("Stud_Age", new TableInfo.Column("Stud_Age", "TEXT", false, 0));
        _columnsStudent.put("Stud_Gender", new TableInfo.Column("Stud_Gender", "TEXT", false, 0));
        _columnsStudent.put("Stud_Class", new TableInfo.Column("Stud_Class", "TEXT", false, 0));
        _columnsStudent.put("Stud_EnrollmentStatus", new TableInfo.Column("Stud_EnrollmentStatus", "TEXT", false, 0));
        _columnsStudent.put("Stud_SchoolType", new TableInfo.Column("Stud_SchoolType", "TEXT", false, 0));
        _columnsStudent.put("Stud_DropoutYear", new TableInfo.Column("Stud_DropoutYear", "TEXT", false, 0));
        _columnsStudent.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        _columnsStudent.put("HouseHold_ID", new TableInfo.Column("HouseHold_ID", "TEXT", false, 0));
        _columnsStudent.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudent = new TableInfo("Student", _columnsStudent, _foreignKeysStudent, _indicesStudent);
        final TableInfo _existingStudent = TableInfo.read(_db, "Student");
        if (! _infoStudent.equals(_existingStudent)) {
          throw new IllegalStateException("Migration didn't properly handle Student(com.kix.assessment.modal_classes.Modal_Student).\n"
                  + " Expected:\n" + _infoStudent + "\n"
                  + " Found:\n" + _existingStudent);
        }
        final HashMap<String, TableInfo.Column> _columnsSurveyor = new HashMap<String, TableInfo.Column>(8);
        _columnsSurveyor.put("Svr_Id", new TableInfo.Column("Svr_Id", "INTEGER", true, 1));
        _columnsSurveyor.put("Svr_Name", new TableInfo.Column("Svr_Name", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Email", new TableInfo.Column("Svr_Email", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Mobile", new TableInfo.Column("Svr_Mobile", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Password", new TableInfo.Column("Svr_Password", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        _columnsSurveyor.put("Svr_Booklet", new TableInfo.Column("Svr_Booklet", "TEXT", false, 0));
        _columnsSurveyor.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
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
        final HashMap<String, TableInfo.Column> _columnsHousehold = new HashMap<String, TableInfo.Column>(8);
        _columnsHousehold.put("hh_ID", new TableInfo.Column("hh_ID", "INTEGER", true, 1));
        _columnsHousehold.put("HouseHold_ID", new TableInfo.Column("HouseHold_ID", "TEXT", false, 0));
        _columnsHousehold.put("HouseHold_Name", new TableInfo.Column("HouseHold_Name", "TEXT", false, 0));
        _columnsHousehold.put("HouseHold_District", new TableInfo.Column("HouseHold_District", "TEXT", false, 0));
        _columnsHousehold.put("HouseHold_State", new TableInfo.Column("HouseHold_State", "TEXT", false, 0));
        _columnsHousehold.put("HouseHold_Address", new TableInfo.Column("HouseHold_Address", "TEXT", false, 0));
        _columnsHousehold.put("Svr_Code", new TableInfo.Column("Svr_Code", "TEXT", false, 0));
        _columnsHousehold.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHousehold = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHousehold = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHousehold = new TableInfo("Household", _columnsHousehold, _foreignKeysHousehold, _indicesHousehold);
        final TableInfo _existingHousehold = TableInfo.read(_db, "Household");
        if (! _infoHousehold.equals(_existingHousehold)) {
          throw new IllegalStateException("Migration didn't properly handle Household(com.kix.assessment.modal_classes.Modal_Household).\n"
                  + " Expected:\n" + _infoHousehold + "\n"
                  + " Found:\n" + _existingHousehold);
        }
        final HashMap<String, TableInfo.Column> _columnsLogs = new HashMap<String, TableInfo.Column>(10);
        _columnsLogs.put("logId", new TableInfo.Column("logId", "INTEGER", true, 1));
        _columnsLogs.put("currentDateTime", new TableInfo.Column("currentDateTime", "TEXT", false, 0));
        _columnsLogs.put("exceptionMessage", new TableInfo.Column("exceptionMessage", "TEXT", false, 0));
        _columnsLogs.put("exceptionStackTrace", new TableInfo.Column("exceptionStackTrace", "TEXT", false, 0));
        _columnsLogs.put("methodName", new TableInfo.Column("methodName", "TEXT", false, 0));
        _columnsLogs.put("errorType", new TableInfo.Column("errorType", "TEXT", false, 0));
        _columnsLogs.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        _columnsLogs.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0));
        _columnsLogs.put("LogDetail", new TableInfo.Column("LogDetail", "TEXT", false, 0));
        _columnsLogs.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLogs = new TableInfo("Logs", _columnsLogs, _foreignKeysLogs, _indicesLogs);
        final TableInfo _existingLogs = TableInfo.read(_db, "Logs");
        if (! _infoLogs.equals(_existingLogs)) {
          throw new IllegalStateException("Migration didn't properly handle Logs(com.kix.assessment.modal_classes.Modal_Log).\n"
                  + " Expected:\n" + _infoLogs + "\n"
                  + " Found:\n" + _existingLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendance = new HashMap<String, TableInfo.Column>(6);
        _columnsAttendance.put("AttendanceID", new TableInfo.Column("AttendanceID", "INTEGER", true, 1));
        _columnsAttendance.put("SessionID", new TableInfo.Column("SessionID", "TEXT", false, 0));
        _columnsAttendance.put("StudentID", new TableInfo.Column("StudentID", "TEXT", false, 0));
        _columnsAttendance.put("Date", new TableInfo.Column("Date", "TEXT", false, 0));
        _columnsAttendance.put("Present", new TableInfo.Column("Present", "INTEGER", true, 0));
        _columnsAttendance.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttendance = new TableInfo("Attendance", _columnsAttendance, _foreignKeysAttendance, _indicesAttendance);
        final TableInfo _existingAttendance = TableInfo.read(_db, "Attendance");
        if (! _infoAttendance.equals(_existingAttendance)) {
          throw new IllegalStateException("Migration didn't properly handle Attendance(com.kix.assessment.modal_classes.Attendance).\n"
                  + " Expected:\n" + _infoAttendance + "\n"
                  + " Found:\n" + _existingAttendance);
        }
        final HashMap<String, TableInfo.Column> _columnsSession = new HashMap<String, TableInfo.Column>(4);
        _columnsSession.put("SessionID", new TableInfo.Column("SessionID", "TEXT", true, 1));
        _columnsSession.put("fromDate", new TableInfo.Column("fromDate", "TEXT", false, 0));
        _columnsSession.put("toDate", new TableInfo.Column("toDate", "TEXT", false, 0));
        _columnsSession.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSession = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSession = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSession = new TableInfo("Session", _columnsSession, _foreignKeysSession, _indicesSession);
        final TableInfo _existingSession = TableInfo.read(_db, "Session");
        if (! _infoSession.equals(_existingSession)) {
          throw new IllegalStateException("Migration didn't properly handle Session(com.kix.assessment.modal_classes.Modal_Session).\n"
                  + " Expected:\n" + _infoSession + "\n"
                  + " Found:\n" + _existingSession);
        }
        final HashMap<String, TableInfo.Column> _columnsStatus = new HashMap<String, TableInfo.Column>(3);
        _columnsStatus.put("statusKey", new TableInfo.Column("statusKey", "TEXT", true, 1));
        _columnsStatus.put("value", new TableInfo.Column("value", "TEXT", true, 0));
        _columnsStatus.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStatus = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStatus = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStatus = new TableInfo("Status", _columnsStatus, _foreignKeysStatus, _indicesStatus);
        final TableInfo _existingStatus = TableInfo.read(_db, "Status");
        if (! _infoStatus.equals(_existingStatus)) {
          throw new IllegalStateException("Migration didn't properly handle Status(com.kix.assessment.modal_classes.Modal_Status).\n"
                  + " Expected:\n" + _infoStatus + "\n"
                  + " Found:\n" + _existingStatus);
        }
      }
    }, "c5964ae7758a8aef133eb1e84e8e0047", "5e563304428a6e57097372c6893a0ba8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Student","Surveyor","Score","Content","Household","Logs","Attendance","Session","Status");
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
      _db.execSQL("DELETE FROM `Logs`");
      _db.execSQL("DELETE FROM `Attendance`");
      _db.execSQL("DELETE FROM `Session`");
      _db.execSQL("DELETE FROM `Status`");
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

  @Override
  public LogDao getLogDao() {
    if (_logDao != null) {
      return _logDao;
    } else {
      synchronized(this) {
        if(_logDao == null) {
          _logDao = new LogDao_Impl(this);
        }
        return _logDao;
      }
    }
  }

  @Override
  public AttendanceDao getAttendanceDao() {
    if (_attendanceDao != null) {
      return _attendanceDao;
    } else {
      synchronized(this) {
        if(_attendanceDao == null) {
          _attendanceDao = new AttendanceDao_Impl(this);
        }
        return _attendanceDao;
      }
    }
  }

  @Override
  public SessionDao getSessionDao() {
    if (_sessionDao != null) {
      return _sessionDao;
    } else {
      synchronized(this) {
        if(_sessionDao == null) {
          _sessionDao = new SessionDao_Impl(this);
        }
        return _sessionDao;
      }
    }
  }

  @Override
  public StatusDao getStatusDao() {
    if (_statusDao != null) {
      return _statusDao;
    } else {
      synchronized(this) {
        if(_statusDao == null) {
          _statusDao = new StatusDao_Impl(this);
        }
        return _statusDao;
      }
    }
  }
}
