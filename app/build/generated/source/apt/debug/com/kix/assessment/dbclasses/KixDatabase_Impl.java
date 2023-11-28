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
import com.kix.assessment.dbclasses.dao.HouseholdInformationDao;
import com.kix.assessment.dbclasses.dao.HouseholdInformationDao_Impl;
import com.kix.assessment.dbclasses.dao.LogDao;
import com.kix.assessment.dbclasses.dao.LogDao_Impl;
import com.kix.assessment.dbclasses.dao.ParentInformationDao;
import com.kix.assessment.dbclasses.dao.ParentInformationDao_Impl;
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

  private volatile HouseholdInformationDao _householdInformationDao;

  private volatile ParentInformationDao _parentInformationDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Student` (`sId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `studentId` TEXT, `CH01` TEXT, `CH02` TEXT, `CH03` TEXT, `CH04a` TEXT, `CH04b` TEXT, `CH05` TEXT, `CH06a` TEXT, `CH06b` TEXT, `CH06c` TEXT, `CH06f` TEXT, `CH06g` TEXT, `CH07a` TEXT, `CH07b` TEXT, `CH07c` TEXT, `CH07d` TEXT, `CH08a` TEXT, `CH08b` TEXT, `CH09a` TEXT, `CH09b` TEXT, `CH09c` TEXT, `createdOn` TEXT, `parentId` TEXT, `svrCode` TEXT, `householdId` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Surveyor` (`svrCode` TEXT NOT NULL, `svrName` TEXT, `svrEmail` TEXT, `svrMobile` TEXT, `svrPassword` TEXT, `svrRegistrationDate` TEXT, `svrCountry` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`svrCode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Score` (`scoreId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` TEXT, `studentId` TEXT, `deviceId` TEXT, `startDateTime` TEXT, `resourceId` TEXT, `gameType` TEXT, `scoredMarks` TEXT, `label` TEXT, `bookletNo` TEXT, `level` TEXT, `stage` INTEGER NOT NULL, `endDateTime` TEXT, `svrCode` TEXT, `countryName` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Content` (`contentId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contentCode` TEXT, `contentFolderName` TEXT, `contentBooklet` TEXT, `contentCountry` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Household` (`hhId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `householdId` TEXT, `HH01` TEXT, `HH02` TEXT, `HH03` TEXT, `HH04a` TEXT, `HH04b` TEXT, `HH05` TEXT, `createdOn` TEXT, `villageId` TEXT, `svrCode` TEXT, `sentFlag` INTEGER NOT NULL, `HH00` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Logs` (`logId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `currentDateTime` TEXT, `exceptionMessage` TEXT, `exceptionStackTrace` TEXT, `methodName` TEXT, `errorType` TEXT, `sessionId` TEXT, `deviceId` TEXT, `logDetail` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Attendance` (`attendanceId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` TEXT, `studentId` TEXT, `attendanceDate` TEXT, `present` INTEGER NOT NULL, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Session` (`sessionId` TEXT NOT NULL, `fromDate` TEXT, `toDate` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`sessionId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Status` (`statusKey` TEXT NOT NULL, `value` TEXT NOT NULL, `description` TEXT, PRIMARY KEY(`statusKey`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AbandonedScore` (`scoreId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` TEXT, `studentId` TEXT, `deviceId` TEXT, `resourceId` TEXT, `gameType` TEXT, `scoredMarks` TEXT, `startDateTime` TEXT, `endDateTime` TEXT, `label` TEXT, `svrCode` TEXT, `bookletNo` TEXT, `reason` TEXT, `countryName` TEXT, `level` TEXT, `stage` INTEGER NOT NULL, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Village` (`villageId` TEXT NOT NULL, `villageName` TEXT, `villageDistrict` TEXT, `villageState` TEXT, `countryName` TEXT, `createdOn` TEXT, `svrCode` TEXT, `sentFlag` INTEGER NOT NULL, `villageBooklet` TEXT, PRIMARY KEY(`villageId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `VillageInformartion` (`vif_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `V01` TEXT, `V02` TEXT, `V03` TEXT, `V04` TEXT, `V05` TEXT, `V06a` TEXT, `V06b` TEXT, `V07a` TEXT, `V07b` TEXT, `villageId` TEXT, `svrCode` TEXT, `sentFlag` INTEGER NOT NULL, `info_createdOn` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `HouseholdInformation` (`hif_Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `HH06a` TEXT, `HH06b` TEXT, `HH06c` TEXT, `HH06d` TEXT, `HH07a` TEXT, `HH07b` TEXT, `HH07c` TEXT, `HH07cOther` TEXT, `HH07d1` TEXT, `HH07d2` TEXT, `HH07f` TEXT, `HH07g` TEXT, `HH07h` TEXT, `HH07i` TEXT, `HH07j` TEXT, `HH07k` TEXT, `HH07m` TEXT, `HH07n` TEXT, `HH07o` TEXT, `HH07p` TEXT, `HH07q` TEXT, `householdId` TEXT, `villageId` TEXT, `info_createdOn` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ParentInformation` (`pifId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `parentId` TEXT, `PT00` INTEGER NOT NULL, `PT01a` TEXT, `PT01c` TEXT, `PT01d` TEXT, `PT01e` TEXT, `PT01f` TEXT, `PT02a` TEXT, `PT02c` TEXT, `PT02d` TEXT, `PT02e` TEXT, `PT02f` TEXT, `householdId` TEXT, `info_createdOn` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"5a3a0c9887f8fa4468bb527904710fb2\")");
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
        _db.execSQL("DROP TABLE IF EXISTS `HouseholdInformation`");
        _db.execSQL("DROP TABLE IF EXISTS `ParentInformation`");
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
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(27);
        _columnsStudent.put("sId", new TableInfo.Column("sId", "INTEGER", true, 1));
        _columnsStudent.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsStudent.put("CH01", new TableInfo.Column("CH01", "TEXT", false, 0));
        _columnsStudent.put("CH02", new TableInfo.Column("CH02", "TEXT", false, 0));
        _columnsStudent.put("CH03", new TableInfo.Column("CH03", "TEXT", false, 0));
        _columnsStudent.put("CH04a", new TableInfo.Column("CH04a", "TEXT", false, 0));
        _columnsStudent.put("CH04b", new TableInfo.Column("CH04b", "TEXT", false, 0));
        _columnsStudent.put("CH05", new TableInfo.Column("CH05", "TEXT", false, 0));
        _columnsStudent.put("CH06a", new TableInfo.Column("CH06a", "TEXT", false, 0));
        _columnsStudent.put("CH06b", new TableInfo.Column("CH06b", "TEXT", false, 0));
        _columnsStudent.put("CH06c", new TableInfo.Column("CH06c", "TEXT", false, 0));
        _columnsStudent.put("CH06f", new TableInfo.Column("CH06f", "TEXT", false, 0));
        _columnsStudent.put("CH06g", new TableInfo.Column("CH06g", "TEXT", false, 0));
        _columnsStudent.put("CH07a", new TableInfo.Column("CH07a", "TEXT", false, 0));
        _columnsStudent.put("CH07b", new TableInfo.Column("CH07b", "TEXT", false, 0));
        _columnsStudent.put("CH07c", new TableInfo.Column("CH07c", "TEXT", false, 0));
        _columnsStudent.put("CH07d", new TableInfo.Column("CH07d", "TEXT", false, 0));
        _columnsStudent.put("CH08a", new TableInfo.Column("CH08a", "TEXT", false, 0));
        _columnsStudent.put("CH08b", new TableInfo.Column("CH08b", "TEXT", false, 0));
        _columnsStudent.put("CH09a", new TableInfo.Column("CH09a", "TEXT", false, 0));
        _columnsStudent.put("CH09b", new TableInfo.Column("CH09b", "TEXT", false, 0));
        _columnsStudent.put("CH09c", new TableInfo.Column("CH09c", "TEXT", false, 0));
        _columnsStudent.put("createdOn", new TableInfo.Column("createdOn", "TEXT", false, 0));
        _columnsStudent.put("parentId", new TableInfo.Column("parentId", "TEXT", false, 0));
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
        final HashMap<String, TableInfo.Column> _columnsSurveyor = new HashMap<String, TableInfo.Column>(8);
        _columnsSurveyor.put("svrCode", new TableInfo.Column("svrCode", "TEXT", true, 1));
        _columnsSurveyor.put("svrName", new TableInfo.Column("svrName", "TEXT", false, 0));
        _columnsSurveyor.put("svrEmail", new TableInfo.Column("svrEmail", "TEXT", false, 0));
        _columnsSurveyor.put("svrMobile", new TableInfo.Column("svrMobile", "TEXT", false, 0));
        _columnsSurveyor.put("svrPassword", new TableInfo.Column("svrPassword", "TEXT", false, 0));
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
        final HashMap<String, TableInfo.Column> _columnsScore = new HashMap<String, TableInfo.Column>(16);
        _columnsScore.put("scoreId", new TableInfo.Column("scoreId", "INTEGER", true, 1));
        _columnsScore.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        _columnsScore.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsScore.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0));
        _columnsScore.put("startDateTime", new TableInfo.Column("startDateTime", "TEXT", false, 0));
        _columnsScore.put("resourceId", new TableInfo.Column("resourceId", "TEXT", false, 0));
        _columnsScore.put("gameType", new TableInfo.Column("gameType", "TEXT", false, 0));
        _columnsScore.put("scoredMarks", new TableInfo.Column("scoredMarks", "TEXT", false, 0));
        _columnsScore.put("label", new TableInfo.Column("label", "TEXT", false, 0));
        _columnsScore.put("bookletNo", new TableInfo.Column("bookletNo", "TEXT", false, 0));
        _columnsScore.put("level", new TableInfo.Column("level", "TEXT", false, 0));
        _columnsScore.put("stage", new TableInfo.Column("stage", "INTEGER", true, 0));
        _columnsScore.put("endDateTime", new TableInfo.Column("endDateTime", "TEXT", false, 0));
        _columnsScore.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
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
        final HashMap<String, TableInfo.Column> _columnsHousehold = new HashMap<String, TableInfo.Column>(13);
        _columnsHousehold.put("hhId", new TableInfo.Column("hhId", "INTEGER", true, 1));
        _columnsHousehold.put("householdId", new TableInfo.Column("householdId", "TEXT", false, 0));
        _columnsHousehold.put("HH01", new TableInfo.Column("HH01", "TEXT", false, 0));
        _columnsHousehold.put("HH02", new TableInfo.Column("HH02", "TEXT", false, 0));
        _columnsHousehold.put("HH03", new TableInfo.Column("HH03", "TEXT", false, 0));
        _columnsHousehold.put("HH04a", new TableInfo.Column("HH04a", "TEXT", false, 0));
        _columnsHousehold.put("HH04b", new TableInfo.Column("HH04b", "TEXT", false, 0));
        _columnsHousehold.put("HH05", new TableInfo.Column("HH05", "TEXT", false, 0));
        _columnsHousehold.put("createdOn", new TableInfo.Column("createdOn", "TEXT", false, 0));
        _columnsHousehold.put("villageId", new TableInfo.Column("villageId", "TEXT", false, 0));
        _columnsHousehold.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsHousehold.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        _columnsHousehold.put("HH00", new TableInfo.Column("HH00", "TEXT", false, 0));
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
        final HashMap<String, TableInfo.Column> _columnsAbandonedScore = new HashMap<String, TableInfo.Column>(17);
        _columnsAbandonedScore.put("scoreId", new TableInfo.Column("scoreId", "INTEGER", true, 1));
        _columnsAbandonedScore.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        _columnsAbandonedScore.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsAbandonedScore.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0));
        _columnsAbandonedScore.put("resourceId", new TableInfo.Column("resourceId", "TEXT", false, 0));
        _columnsAbandonedScore.put("gameType", new TableInfo.Column("gameType", "TEXT", false, 0));
        _columnsAbandonedScore.put("scoredMarks", new TableInfo.Column("scoredMarks", "TEXT", false, 0));
        _columnsAbandonedScore.put("startDateTime", new TableInfo.Column("startDateTime", "TEXT", false, 0));
        _columnsAbandonedScore.put("endDateTime", new TableInfo.Column("endDateTime", "TEXT", false, 0));
        _columnsAbandonedScore.put("label", new TableInfo.Column("label", "TEXT", false, 0));
        _columnsAbandonedScore.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsAbandonedScore.put("bookletNo", new TableInfo.Column("bookletNo", "TEXT", false, 0));
        _columnsAbandonedScore.put("reason", new TableInfo.Column("reason", "TEXT", false, 0));
        _columnsAbandonedScore.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0));
        _columnsAbandonedScore.put("level", new TableInfo.Column("level", "TEXT", false, 0));
        _columnsAbandonedScore.put("stage", new TableInfo.Column("stage", "INTEGER", true, 0));
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
        final HashMap<String, TableInfo.Column> _columnsVillage = new HashMap<String, TableInfo.Column>(9);
        _columnsVillage.put("villageId", new TableInfo.Column("villageId", "TEXT", true, 1));
        _columnsVillage.put("villageName", new TableInfo.Column("villageName", "TEXT", false, 0));
        _columnsVillage.put("villageDistrict", new TableInfo.Column("villageDistrict", "TEXT", false, 0));
        _columnsVillage.put("villageState", new TableInfo.Column("villageState", "TEXT", false, 0));
        _columnsVillage.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0));
        _columnsVillage.put("createdOn", new TableInfo.Column("createdOn", "TEXT", false, 0));
        _columnsVillage.put("svrCode", new TableInfo.Column("svrCode", "TEXT", false, 0));
        _columnsVillage.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        _columnsVillage.put("villageBooklet", new TableInfo.Column("villageBooklet", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVillage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVillage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVillage = new TableInfo("Village", _columnsVillage, _foreignKeysVillage, _indicesVillage);
        final TableInfo _existingVillage = TableInfo.read(_db, "Village");
        if (! _infoVillage.equals(_existingVillage)) {
          throw new IllegalStateException("Migration didn't properly handle Village(com.kix.assessment.modal_classes.Modal_Village).\n"
                  + " Expected:\n" + _infoVillage + "\n"
                  + " Found:\n" + _existingVillage);
        }
        final HashMap<String, TableInfo.Column> _columnsVillageInformartion = new HashMap<String, TableInfo.Column>(14);
        _columnsVillageInformartion.put("vif_Id", new TableInfo.Column("vif_Id", "INTEGER", true, 1));
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
        _columnsVillageInformartion.put("info_createdOn", new TableInfo.Column("info_createdOn", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVillageInformartion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVillageInformartion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVillageInformartion = new TableInfo("VillageInformartion", _columnsVillageInformartion, _foreignKeysVillageInformartion, _indicesVillageInformartion);
        final TableInfo _existingVillageInformartion = TableInfo.read(_db, "VillageInformartion");
        if (! _infoVillageInformartion.equals(_existingVillageInformartion)) {
          throw new IllegalStateException("Migration didn't properly handle VillageInformartion(com.kix.assessment.modal_classes.Modal_VIF).\n"
                  + " Expected:\n" + _infoVillageInformartion + "\n"
                  + " Found:\n" + _existingVillageInformartion);
        }
        final HashMap<String, TableInfo.Column> _columnsHouseholdInformation = new HashMap<String, TableInfo.Column>(26);
        _columnsHouseholdInformation.put("hif_Id", new TableInfo.Column("hif_Id", "INTEGER", true, 1));
        _columnsHouseholdInformation.put("HH06a", new TableInfo.Column("HH06a", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH06b", new TableInfo.Column("HH06b", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH06c", new TableInfo.Column("HH06c", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH06d", new TableInfo.Column("HH06d", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07a", new TableInfo.Column("HH07a", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07b", new TableInfo.Column("HH07b", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07c", new TableInfo.Column("HH07c", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07cOther", new TableInfo.Column("HH07cOther", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07d1", new TableInfo.Column("HH07d1", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07d2", new TableInfo.Column("HH07d2", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07f", new TableInfo.Column("HH07f", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07g", new TableInfo.Column("HH07g", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07h", new TableInfo.Column("HH07h", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07i", new TableInfo.Column("HH07i", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07j", new TableInfo.Column("HH07j", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07k", new TableInfo.Column("HH07k", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07m", new TableInfo.Column("HH07m", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07n", new TableInfo.Column("HH07n", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07o", new TableInfo.Column("HH07o", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07p", new TableInfo.Column("HH07p", "TEXT", false, 0));
        _columnsHouseholdInformation.put("HH07q", new TableInfo.Column("HH07q", "TEXT", false, 0));
        _columnsHouseholdInformation.put("householdId", new TableInfo.Column("householdId", "TEXT", false, 0));
        _columnsHouseholdInformation.put("villageId", new TableInfo.Column("villageId", "TEXT", false, 0));
        _columnsHouseholdInformation.put("info_createdOn", new TableInfo.Column("info_createdOn", "TEXT", false, 0));
        _columnsHouseholdInformation.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHouseholdInformation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHouseholdInformation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHouseholdInformation = new TableInfo("HouseholdInformation", _columnsHouseholdInformation, _foreignKeysHouseholdInformation, _indicesHouseholdInformation);
        final TableInfo _existingHouseholdInformation = TableInfo.read(_db, "HouseholdInformation");
        if (! _infoHouseholdInformation.equals(_existingHouseholdInformation)) {
          throw new IllegalStateException("Migration didn't properly handle HouseholdInformation(com.kix.assessment.modal_classes.Modal_HIF).\n"
                  + " Expected:\n" + _infoHouseholdInformation + "\n"
                  + " Found:\n" + _existingHouseholdInformation);
        }
        final HashMap<String, TableInfo.Column> _columnsParentInformation = new HashMap<String, TableInfo.Column>(16);
        _columnsParentInformation.put("pifId", new TableInfo.Column("pifId", "INTEGER", true, 1));
        _columnsParentInformation.put("parentId", new TableInfo.Column("parentId", "TEXT", false, 0));
        _columnsParentInformation.put("PT00", new TableInfo.Column("PT00", "INTEGER", true, 0));
        _columnsParentInformation.put("PT01a", new TableInfo.Column("PT01a", "TEXT", false, 0));
        _columnsParentInformation.put("PT01c", new TableInfo.Column("PT01c", "TEXT", false, 0));
        _columnsParentInformation.put("PT01d", new TableInfo.Column("PT01d", "TEXT", false, 0));
        _columnsParentInformation.put("PT01e", new TableInfo.Column("PT01e", "TEXT", false, 0));
        _columnsParentInformation.put("PT01f", new TableInfo.Column("PT01f", "TEXT", false, 0));
        _columnsParentInformation.put("PT02a", new TableInfo.Column("PT02a", "TEXT", false, 0));
        _columnsParentInformation.put("PT02c", new TableInfo.Column("PT02c", "TEXT", false, 0));
        _columnsParentInformation.put("PT02d", new TableInfo.Column("PT02d", "TEXT", false, 0));
        _columnsParentInformation.put("PT02e", new TableInfo.Column("PT02e", "TEXT", false, 0));
        _columnsParentInformation.put("PT02f", new TableInfo.Column("PT02f", "TEXT", false, 0));
        _columnsParentInformation.put("householdId", new TableInfo.Column("householdId", "TEXT", false, 0));
        _columnsParentInformation.put("info_createdOn", new TableInfo.Column("info_createdOn", "TEXT", false, 0));
        _columnsParentInformation.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysParentInformation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesParentInformation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoParentInformation = new TableInfo("ParentInformation", _columnsParentInformation, _foreignKeysParentInformation, _indicesParentInformation);
        final TableInfo _existingParentInformation = TableInfo.read(_db, "ParentInformation");
        if (! _infoParentInformation.equals(_existingParentInformation)) {
          throw new IllegalStateException("Migration didn't properly handle ParentInformation(com.kix.assessment.modal_classes.Modal_PIF).\n"
                  + " Expected:\n" + _infoParentInformation + "\n"
                  + " Found:\n" + _existingParentInformation);
        }
      }
    }, "5a3a0c9887f8fa4468bb527904710fb2", "d7b399680dd8163b7ba0cd36a48fda05");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Student","Surveyor","Score","Content","Household","Logs","Attendance","Session","Status","AbandonedScore","Village","VillageInformartion","HouseholdInformation","ParentInformation");
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
      _db.execSQL("DELETE FROM `HouseholdInformation`");
      _db.execSQL("DELETE FROM `ParentInformation`");
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

  @Override
  public HouseholdInformationDao getHouseholdInformationDao() {
    if (_householdInformationDao != null) {
      return _householdInformationDao;
    } else {
      synchronized(this) {
        if(_householdInformationDao == null) {
          _householdInformationDao = new HouseholdInformationDao_Impl(this);
        }
        return _householdInformationDao;
      }
    }
  }

  @Override
  public ParentInformationDao getParentInformationDao() {
    if (_parentInformationDao != null) {
      return _parentInformationDao;
    } else {
      synchronized(this) {
        if(_parentInformationDao == null) {
          _parentInformationDao = new ParentInformationDao_Impl(this);
        }
        return _parentInformationDao;
      }
    }
  }
}
