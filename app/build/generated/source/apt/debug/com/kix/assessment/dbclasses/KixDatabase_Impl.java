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
import com.kix.assessment.dbclasses.dao.AbandonedScoreDao;
import com.kix.assessment.dbclasses.dao.AbandonedScoreDao_Impl;
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
import com.kix.assessment.dbclasses.dao.VillageDao;
import com.kix.assessment.dbclasses.dao.VillageDao_Impl;
import com.kix.assessment.dbclasses.dao.VillageInformationDao;
import com.kix.assessment.dbclasses.dao.VillageInformationDao_Impl;
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

  private volatile AbandonedScoreDao _abandonedScoreDao;

  private volatile ContentDao _contentDao;

  private volatile HouseholdDao _householdDao;

  private volatile LogDao _logDao;

  private volatile AttendanceDao _attendanceDao;

  private volatile SessionDao _sessionDao;

  private volatile StatusDao _statusDao;

  private volatile VillageDao _villageDao;

  private volatile VillageInformationDao _villageInformationDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Student` (`sId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `studentId` TEXT, `CH01` TEXT, `CH02` TEXT, `CH03` TEXT, `CH04` TEXT, `CH05a` TEXT, `CH05b` TEXT, `CH05c` TEXT, `CH05d` TEXT, `CH05e` TEXT, `CH05f` TEXT, `CH06a` TEXT, `CH06b1` TEXT, `CH06b2` TEXT, `CH06b3` TEXT, `CH07` TEXT, `CH08` TEXT, `createdOn` TEXT, `svrCode` TEXT, `householdId` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Surveyor` (`svrCode` TEXT NOT NULL, `svrName` TEXT, `svrEmail` TEXT, `svrMobile` TEXT, `svrPassword` TEXT, `svrBooklet` TEXT, `svrRegistrationDate` TEXT, `svrCountry` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`svrCode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Score` (`scoreId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` TEXT, `studentId` TEXT, `deviceId` TEXT, `resourceId` TEXT, `scoredMarks` TEXT, `startDateTime` TEXT, `endDateTime` TEXT, `label` TEXT, `svrCode` TEXT, `bookletNo` TEXT, `countryName` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Content` (`contentId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contentCode` TEXT, `contentFolderName` TEXT, `contentBooklet` TEXT, `contentCountry` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Household` (`hhId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `householdId` TEXT, `householdName` TEXT, `HH01` TEXT, `HH02` TEXT, `HH03` TEXT, `HH04` TEXT, `HH05a` TEXT, `HH05b` TEXT, `HH06` TEXT, `createdOn` TEXT, `villageId` TEXT, `svrCode` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Logs` (`logId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `currentDateTime` TEXT, `exceptionMessage` TEXT, `exceptionStackTrace` TEXT, `methodName` TEXT, `errorType` TEXT, `sessionId` TEXT, `deviceId` TEXT, `logDetail` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Attendance` (`attendanceId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` TEXT, `studentId` TEXT, `attendanceDate` TEXT, `present` INTEGER NOT NULL, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Session` (`sessionId` TEXT NOT NULL, `fromDate` TEXT, `toDate` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`sessionId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Status` (`statusKey` TEXT NOT NULL, `value` TEXT NOT NULL, `description` TEXT, PRIMARY KEY(`statusKey`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AbandonedScore` (`scoreId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` TEXT, `studentId` TEXT, `deviceId` TEXT, `resourceId` TEXT, `scoredMarks` TEXT, `startDateTime` TEXT, `endDateTime` TEXT, `label` TEXT, `svrCode` TEXT, `bookletNo` TEXT, `reason` TEXT, `countryName` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Village` (`villageId` TEXT NOT NULL, `villageName` TEXT, `villageDistrict` TEXT, `villageState` TEXT, `villageDate` TEXT, `countryName` TEXT, `svrCode` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`villageId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `VillageInformartion` (`vif_Id` TEXT NOT NULL, `V01` TEXT, `V02` TEXT, `V03` TEXT, `V04` TEXT, `V05` TEXT, `V06a` TEXT, `V06b` TEXT, `V07a` TEXT, `V07b` TEXT, `villageId` TEXT, `svrCode` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`vif_Id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"68b77614b44f3aa9c39fa322712bd2ad\")");
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
        _db.execSQL("DROP TABLE IF EXISTS `AbandonedScore`");
        _db.execSQL("DROP TABLE IF EXISTS `Village`");
        _db.execSQL("DROP TABLE IF EXISTS `VillageInformartion`");
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
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(22);
        _columnsStudent.put("sId", new TableInfo.Column("sId", "INTEGER", true, 1));
        _columnsStudent.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsStudent.put("CH01", new TableInfo.Column("CH01", "TEXT", false, 0));
        _columnsStudent.put("CH02", new TableInfo.Column("CH02", "TEXT", false, 0));
        _columnsStudent.put("CH03", new TableInfo.Column("CH03", "TEXT", false, 0));
        _columnsStudent.put("CH04", new TableInfo.Column("CH04", "TEXT", false, 0));
        _columnsStudent.put("CH05a", new TableInfo.Column("CH05a", "TEXT", false, 0));
        _columnsStudent.put("CH05b", new TableInfo.Column("CH05b", "TEXT", false, 0));
        _columnsStudent.put("CH05c", new TableInfo.Column("CH05c", "TEXT", false, 0));
        _columnsStudent.put("CH05d", new TableInfo.Column("CH05d", "TEXT", false, 0));
        _columnsStudent.put("CH05e", new TableInfo.Column("CH05e", "TEXT", false, 0));
        _columnsStudent.put("CH05f", new TableInfo.Column("CH05f", "TEXT", false, 0));
        _columnsStudent.put("CH06a", new TableInfo.Column("CH06a", "TEXT", false, 0));
        _columnsStudent.put("CH06b1", new TableInfo.Column("CH06b1", "TEXT", false, 0));
        _columnsStudent.put("CH06b2", new TableInfo.Column("CH06b2", "TEXT", false, 0));
        _columnsStudent.put("CH06b3", new TableInfo.Column("CH06b3", "TEXT", false, 0));
        _columnsStudent.put("CH07", new TableInfo.Column("CH07", "TEXT", false, 0));
        _columnsStudent.put("CH08", new TableInfo.Column("CH08", "TEXT", false, 0));
        _columnsStudent.put("createdOn", new TableInfo.Column("createdOn", "TEXT", false, 0));
        _columnsStudent.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsStudent.put("householdId", new TableInfo.Column("householdId", "TEXT", false, 0));
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
        final HashMap<String, TableInfo.Column> _columnsSurveyor = new HashMap<String, TableInfo.Column>(9);
        _columnsSurveyor.put("svrCode", new TableInfo.Column("svrCode", "TEXT", true, 1));
        _columnsSurveyor.put("svrName", new TableInfo.Column("svrName", "TEXT", false, 0));
        _columnsSurveyor.put("svrEmail", new TableInfo.Column("svrEmail", "TEXT", false, 0));
        _columnsSurveyor.put("svrMobile", new TableInfo.Column("svrMobile", "TEXT", false, 0));
        _columnsSurveyor.put("svrPassword", new TableInfo.Column("svrPassword", "TEXT", false, 0));
        _columnsSurveyor.put("svrBooklet", new TableInfo.Column("svrBooklet", "TEXT", false, 0));
        _columnsSurveyor.put("svrRegistrationDate", new TableInfo.Column("svrRegistrationDate", "TEXT", false, 0));
        _columnsSurveyor.put("svrCountry", new TableInfo.Column("svrCountry", "TEXT", false, 0));
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
        final HashMap<String, TableInfo.Column> _columnsScore = new HashMap<String, TableInfo.Column>(13);
        _columnsScore.put("scoreId", new TableInfo.Column("scoreId", "INTEGER", true, 1));
        _columnsScore.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        _columnsScore.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsScore.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0));
        _columnsScore.put("resourceId", new TableInfo.Column("resourceId", "TEXT", false, 0));
        _columnsScore.put("scoredMarks", new TableInfo.Column("scoredMarks", "TEXT", false, 0));
        _columnsScore.put("startDateTime", new TableInfo.Column("startDateTime", "TEXT", false, 0));
        _columnsScore.put("endDateTime", new TableInfo.Column("endDateTime", "TEXT", false, 0));
        _columnsScore.put("label", new TableInfo.Column("label", "TEXT", false, 0));
        _columnsScore.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsScore.put("bookletNo", new TableInfo.Column("bookletNo", "TEXT", false, 0));
        _columnsScore.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0));
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
        final HashMap<String, TableInfo.Column> _columnsContent = new HashMap<String, TableInfo.Column>(5);
        _columnsContent.put("contentId", new TableInfo.Column("contentId", "INTEGER", true, 1));
        _columnsContent.put("contentCode", new TableInfo.Column("contentCode", "TEXT", false, 0));
        _columnsContent.put("contentFolderName", new TableInfo.Column("contentFolderName", "TEXT", false, 0));
        _columnsContent.put("contentBooklet", new TableInfo.Column("contentBooklet", "TEXT", false, 0));
        _columnsContent.put("contentCountry", new TableInfo.Column("contentCountry", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContent = new TableInfo("Content", _columnsContent, _foreignKeysContent, _indicesContent);
        final TableInfo _existingContent = TableInfo.read(_db, "Content");
        if (! _infoContent.equals(_existingContent)) {
          throw new IllegalStateException("Migration didn't properly handle Content(com.kix.assessment.modal_classes.Modal_Content).\n"
                  + " Expected:\n" + _infoContent + "\n"
                  + " Found:\n" + _existingContent);
        }
        final HashMap<String, TableInfo.Column> _columnsHousehold = new HashMap<String, TableInfo.Column>(14);
        _columnsHousehold.put("hhId", new TableInfo.Column("hhId", "INTEGER", true, 1));
        _columnsHousehold.put("householdId", new TableInfo.Column("householdId", "TEXT", false, 0));
        _columnsHousehold.put("householdName", new TableInfo.Column("householdName", "TEXT", false, 0));
        _columnsHousehold.put("HH01", new TableInfo.Column("HH01", "TEXT", false, 0));
        _columnsHousehold.put("HH02", new TableInfo.Column("HH02", "TEXT", false, 0));
        _columnsHousehold.put("HH03", new TableInfo.Column("HH03", "TEXT", false, 0));
        _columnsHousehold.put("HH04", new TableInfo.Column("HH04", "TEXT", false, 0));
        _columnsHousehold.put("HH05a", new TableInfo.Column("HH05a", "TEXT", false, 0));
        _columnsHousehold.put("HH05b", new TableInfo.Column("HH05b", "TEXT", false, 0));
        _columnsHousehold.put("HH06", new TableInfo.Column("HH06", "TEXT", false, 0));
        _columnsHousehold.put("createdOn", new TableInfo.Column("createdOn", "TEXT", false, 0));
        _columnsHousehold.put("villageId", new TableInfo.Column("villageId", "TEXT", false, 0));
        _columnsHousehold.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
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
        _columnsLogs.put("logDetail", new TableInfo.Column("logDetail", "TEXT", false, 0));
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
        _columnsAttendance.put("attendanceId", new TableInfo.Column("attendanceId", "INTEGER", true, 1));
        _columnsAttendance.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        _columnsAttendance.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsAttendance.put("attendanceDate", new TableInfo.Column("attendanceDate", "TEXT", false, 0));
        _columnsAttendance.put("present", new TableInfo.Column("present", "INTEGER", true, 0));
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
        _columnsSession.put("sessionId", new TableInfo.Column("sessionId", "TEXT", true, 1));
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
        final HashMap<String, TableInfo.Column> _columnsAbandonedScore = new HashMap<String, TableInfo.Column>(14);
        _columnsAbandonedScore.put("scoreId", new TableInfo.Column("scoreId", "INTEGER", true, 1));
        _columnsAbandonedScore.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        _columnsAbandonedScore.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsAbandonedScore.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0));
        _columnsAbandonedScore.put("resourceId", new TableInfo.Column("resourceId", "TEXT", false, 0));
        _columnsAbandonedScore.put("scoredMarks", new TableInfo.Column("scoredMarks", "TEXT", false, 0));
        _columnsAbandonedScore.put("startDateTime", new TableInfo.Column("startDateTime", "TEXT", false, 0));
        _columnsAbandonedScore.put("endDateTime", new TableInfo.Column("endDateTime", "TEXT", false, 0));
        _columnsAbandonedScore.put("label", new TableInfo.Column("label", "TEXT", false, 0));
        _columnsAbandonedScore.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsAbandonedScore.put("bookletNo", new TableInfo.Column("bookletNo", "TEXT", false, 0));
        _columnsAbandonedScore.put("reason", new TableInfo.Column("reason", "TEXT", false, 0));
        _columnsAbandonedScore.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0));
        _columnsAbandonedScore.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAbandonedScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAbandonedScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAbandonedScore = new TableInfo("AbandonedScore", _columnsAbandonedScore, _foreignKeysAbandonedScore, _indicesAbandonedScore);
        final TableInfo _existingAbandonedScore = TableInfo.read(_db, "AbandonedScore");
        if (! _infoAbandonedScore.equals(_existingAbandonedScore)) {
          throw new IllegalStateException("Migration didn't properly handle AbandonedScore(com.kix.assessment.modal_classes.AbandonedScore).\n"
                  + " Expected:\n" + _infoAbandonedScore + "\n"
                  + " Found:\n" + _existingAbandonedScore);
        }
        final HashMap<String, TableInfo.Column> _columnsVillage = new HashMap<String, TableInfo.Column>(8);
        _columnsVillage.put("villageId", new TableInfo.Column("villageId", "TEXT", true, 1));
        _columnsVillage.put("villageName", new TableInfo.Column("villageName", "TEXT", false, 0));
        _columnsVillage.put("villageDistrict", new TableInfo.Column("villageDistrict", "TEXT", false, 0));
        _columnsVillage.put("villageState", new TableInfo.Column("villageState", "TEXT", false, 0));
        _columnsVillage.put("villageDate", new TableInfo.Column("villageDate", "TEXT", false, 0));
        _columnsVillage.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0));
        _columnsVillage.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsVillage.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVillage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVillage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVillage = new TableInfo("Village", _columnsVillage, _foreignKeysVillage, _indicesVillage);
        final TableInfo _existingVillage = TableInfo.read(_db, "Village");
        if (! _infoVillage.equals(_existingVillage)) {
          throw new IllegalStateException("Migration didn't properly handle Village(com.kix.assessment.modal_classes.Modal_Village).\n"
                  + " Expected:\n" + _infoVillage + "\n"
                  + " Found:\n" + _existingVillage);
        }
        final HashMap<String, TableInfo.Column> _columnsVillageInformartion = new HashMap<String, TableInfo.Column>(13);
        _columnsVillageInformartion.put("vif_Id", new TableInfo.Column("vif_Id", "TEXT", true, 1));
        _columnsVillageInformartion.put("V01", new TableInfo.Column("V01", "TEXT", false, 0));
        _columnsVillageInformartion.put("V02", new TableInfo.Column("V02", "TEXT", false, 0));
        _columnsVillageInformartion.put("V03", new TableInfo.Column("V03", "TEXT", false, 0));
        _columnsVillageInformartion.put("V04", new TableInfo.Column("V04", "TEXT", false, 0));
        _columnsVillageInformartion.put("V05", new TableInfo.Column("V05", "TEXT", false, 0));
        _columnsVillageInformartion.put("V06a", new TableInfo.Column("V06a", "TEXT", false, 0));
        _columnsVillageInformartion.put("V06b", new TableInfo.Column("V06b", "TEXT", false, 0));
        _columnsVillageInformartion.put("V07a", new TableInfo.Column("V07a", "TEXT", false, 0));
        _columnsVillageInformartion.put("V07b", new TableInfo.Column("V07b", "TEXT", false, 0));
        _columnsVillageInformartion.put("villageId", new TableInfo.Column("villageId", "TEXT", false, 0));
        _columnsVillageInformartion.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsVillageInformartion.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVillageInformartion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVillageInformartion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVillageInformartion = new TableInfo("VillageInformartion", _columnsVillageInformartion, _foreignKeysVillageInformartion, _indicesVillageInformartion);
        final TableInfo _existingVillageInformartion = TableInfo.read(_db, "VillageInformartion");
        if (! _infoVillageInformartion.equals(_existingVillageInformartion)) {
          throw new IllegalStateException("Migration didn't properly handle VillageInformartion(com.kix.assessment.modal_classes.Modal_VIF).\n"
                  + " Expected:\n" + _infoVillageInformartion + "\n"
                  + " Found:\n" + _existingVillageInformartion);
        }
      }
    }, "68b77614b44f3aa9c39fa322712bd2ad", "925e24afe654bf54e6f2ad0fb4546e6d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Student","Surveyor","Score","Content","Household","Logs","Attendance","Session","Status","AbandonedScore","Village","VillageInformartion");
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
      _db.execSQL("DELETE FROM `AbandonedScore`");
      _db.execSQL("DELETE FROM `Village`");
      _db.execSQL("DELETE FROM `VillageInformartion`");
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
  public AbandonedScoreDao getAbandonedScoreDao() {
    if (_abandonedScoreDao != null) {
      return _abandonedScoreDao;
    } else {
      synchronized(this) {
        if(_abandonedScoreDao == null) {
          _abandonedScoreDao = new AbandonedScoreDao_Impl(this);
        }
        return _abandonedScoreDao;
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

  @Override
  public VillageDao getVillageDao() {
    if (_villageDao != null) {
      return _villageDao;
    } else {
      synchronized(this) {
        if(_villageDao == null) {
          _villageDao = new VillageDao_Impl(this);
        }
        return _villageDao;
      }
    }
  }

  @Override
  public VillageInformationDao getVillageInformationDao() {
    if (_villageInformationDao != null) {
      return _villageInformationDao;
    } else {
      synchronized(this) {
        if(_villageInformationDao == null) {
          _villageInformationDao = new VillageInformationDao_Impl(this);
        }
        return _villageInformationDao;
      }
    }
  }
}
