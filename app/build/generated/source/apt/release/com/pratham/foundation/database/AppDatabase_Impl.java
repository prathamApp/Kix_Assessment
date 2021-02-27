package com.pratham.foundation.database;

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
import com.pratham.foundation.database.dao.AssessmentDao;
import com.pratham.foundation.database.dao.AssessmentDao_Impl;
import com.pratham.foundation.database.dao.AttendanceDao;
import com.pratham.foundation.database.dao.AttendanceDao_Impl;
import com.pratham.foundation.database.dao.ContentProgressDao;
import com.pratham.foundation.database.dao.ContentProgressDao_Impl;
import com.pratham.foundation.database.dao.ContentTableDao;
import com.pratham.foundation.database.dao.ContentTableDao_Impl;
import com.pratham.foundation.database.dao.CourseDao;
import com.pratham.foundation.database.dao.CourseDao_Impl;
import com.pratham.foundation.database.dao.CrlDao;
import com.pratham.foundation.database.dao.CrlDao_Impl;
import com.pratham.foundation.database.dao.EnglishWordDao;
import com.pratham.foundation.database.dao.EnglishWordDao_Impl;
import com.pratham.foundation.database.dao.GroupDao;
import com.pratham.foundation.database.dao.GroupDao_Impl;
import com.pratham.foundation.database.dao.KeyWordDao;
import com.pratham.foundation.database.dao.KeyWordDao_Impl;
import com.pratham.foundation.database.dao.LogDao;
import com.pratham.foundation.database.dao.LogDao_Impl;
import com.pratham.foundation.database.dao.MatchThePairDao;
import com.pratham.foundation.database.dao.MatchThePairDao_Impl;
import com.pratham.foundation.database.dao.ScoreDao;
import com.pratham.foundation.database.dao.ScoreDao_Impl;
import com.pratham.foundation.database.dao.SessionDao;
import com.pratham.foundation.database.dao.SessionDao_Impl;
import com.pratham.foundation.database.dao.StatusDao;
import com.pratham.foundation.database.dao.StatusDao_Impl;
import com.pratham.foundation.database.dao.StudentDao;
import com.pratham.foundation.database.dao.StudentDao_Impl;
import com.pratham.foundation.database.dao.SupervisorDataDao;
import com.pratham.foundation.database.dao.SupervisorDataDao_Impl;
import com.pratham.foundation.database.dao.VillageDao;
import com.pratham.foundation.database.dao.VillageDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CrlDao _crlDao;

  private volatile StudentDao _studentDao;

  private volatile ScoreDao _scoreDao;

  private volatile AssessmentDao _assessmentDao;

  private volatile SessionDao _sessionDao;

  private volatile AttendanceDao _attendanceDao;

  private volatile VillageDao _villageDao;

  private volatile GroupDao _groupDao;

  private volatile SupervisorDataDao _supervisorDataDao;

  private volatile LogDao _logDao;

  private volatile ContentTableDao _contentTableDao;

  private volatile StatusDao _statusDao;

  private volatile ContentProgressDao _contentProgressDao;

  private volatile KeyWordDao _keyWordDao;

  private volatile EnglishWordDao _englishWordDao;

  private volatile MatchThePairDao _matchThePairDao;

  private volatile CourseDao _courseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Crl` (`CrlTableId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `CRLId` TEXT, `FirstName` TEXT, `LastName` TEXT, `UserName` TEXT, `Password` TEXT, `ProgramId` INTEGER NOT NULL, `ProgramName` TEXT, `Mobile` TEXT, `State` TEXT, `Email` TEXT, `CreatedBy` TEXT, `newCrl` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Student` (`StudentID` TEXT NOT NULL, `FullName` TEXT, `Gender` TEXT, `Age` INTEGER NOT NULL, `Stud_Class` TEXT, `GroupId` TEXT, `GroupName` TEXT, `sentFlag` INTEGER NOT NULL, `DeviceId` TEXT, `StudentUID` TEXT, `FirstName` TEXT, `MiddleName` TEXT, `LastName` TEXT, `regDate` TEXT, `villageName` TEXT, `newFlag` INTEGER NOT NULL, `avatarName` TEXT, PRIMARY KEY(`StudentID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Score` (`ScoreId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `SessionID` TEXT, `StudentID` TEXT, `DeviceID` TEXT, `ResourceID` TEXT, `QuestionId` INTEGER NOT NULL, `ScoredMarks` INTEGER NOT NULL, `TotalMarks` INTEGER NOT NULL, `StartDateTime` TEXT, `EndDateTime` TEXT, `Level` INTEGER NOT NULL, `Label` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Session` (`SessionID` TEXT NOT NULL, `fromDate` TEXT, `toDate` TEXT, `sentFlag` INTEGER NOT NULL, PRIMARY KEY(`SessionID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Attendance` (`attendanceID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `SessionID` TEXT, `StudentID` TEXT, `Date` TEXT, `GroupID` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Status` (`statusID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `statusKey` TEXT, `value` TEXT NOT NULL, `description` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Village` (`VillageId` INTEGER NOT NULL, `VillageCode` TEXT, `VillageName` TEXT, `Block` TEXT, `District` TEXT, `State` TEXT, `CRLId` TEXT, PRIMARY KEY(`VillageId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Groups` (`GroupId` TEXT NOT NULL, `GroupName` TEXT, `VillageId` TEXT, `ProgramId` INTEGER NOT NULL, `GroupCode` TEXT, `SchoolName` TEXT, `VIllageName` TEXT, `DeviceId` TEXT, PRIMARY KEY(`GroupId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SupervisorData` (`sId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `supervisorId` TEXT, `assessmentSessionId` TEXT, `supervisorName` TEXT, `supervisorPhoto` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Assessment` (`ScoreIda` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `SessionIDm` TEXT, `SessionIDa` TEXT, `StudentIDa` TEXT, `DeviceIDa` TEXT, `ResourceIDa` TEXT, `QuestionIda` INTEGER NOT NULL, `ScoredMarksa` INTEGER NOT NULL, `TotalMarksa` INTEGER NOT NULL, `StartDateTimea` TEXT, `EndDateTimea` TEXT, `Levela` INTEGER NOT NULL, `Labela` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Logs` (`logId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `currentDateTime` TEXT, `exceptionMessage` TEXT, `exceptionStackTrace` TEXT, `methodName` TEXT, `errorType` TEXT, `groupId` TEXT, `deviceId` TEXT, `LogDetail` TEXT, `sentFlag` INTEGER NOT NULL, `sessionId` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ContentTable` (`nodeId` TEXT NOT NULL, `level` TEXT, `resourceId` TEXT, `parentId` TEXT, `nodeDesc` TEXT, `nodeType` TEXT, `nodeEnglishTitle` TEXT, `nodeTitle` TEXT, `resourcePath` TEXT, `resourceType` TEXT, `nodeServerImage` TEXT, `nodeImage` TEXT, `nodeAge` TEXT, `contentLanguage` TEXT, `version` TEXT, `origNodeVersion` TEXT, `subject` TEXT, `seq_no` INTEGER NOT NULL, `studentId` TEXT, `nodeKeywords` TEXT, `isDownloaded` TEXT, `contentType` TEXT, `onSDCard` INTEGER NOT NULL, PRIMARY KEY(`nodeId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ContentProgress` (`progressId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sessionId` TEXT, `studentId` TEXT, `resourceId` TEXT, `updatedDateTime` TEXT, `progressPercentage` TEXT, `label` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `KeyWords` (`keyWordId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `studentId` TEXT, `resourceId` TEXT, `keyWord` TEXT, `wordType` TEXT, `sentFlag` INTEGER NOT NULL, `topic` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `WordEnglish` (`wordId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `word` TEXT, `size` INTEGER NOT NULL, `start` TEXT, `type` TEXT, `meaning` TEXT, `label` TEXT, `vowelTogether` TEXT, `blends` TEXT, `vowels` TEXT, `blendCnt` INTEGER NOT NULL, `vowelCnt` INTEGER NOT NULL, `uuid` TEXT, `synid` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MatchThePair` (`paraTitle` TEXT, `langText` TEXT, `paraText` TEXT, `paraLang` TEXT, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CourseEnrolled` (`c_autoID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `courseId` TEXT, `groupId` TEXT, `planFromDate` TEXT, `planToDate` TEXT, `coachVerified` INTEGER NOT NULL, `coachVerificationDate` TEXT, `courseExperience` TEXT, `courseCompleted` INTEGER NOT NULL, `coachImage` TEXT, `language` TEXT, `sentFlag` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"45ae8ced541ac6f7f04c3baa0c943a14\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Crl`");
        _db.execSQL("DROP TABLE IF EXISTS `Student`");
        _db.execSQL("DROP TABLE IF EXISTS `Score`");
        _db.execSQL("DROP TABLE IF EXISTS `Session`");
        _db.execSQL("DROP TABLE IF EXISTS `Attendance`");
        _db.execSQL("DROP TABLE IF EXISTS `Status`");
        _db.execSQL("DROP TABLE IF EXISTS `Village`");
        _db.execSQL("DROP TABLE IF EXISTS `Groups`");
        _db.execSQL("DROP TABLE IF EXISTS `SupervisorData`");
        _db.execSQL("DROP TABLE IF EXISTS `Assessment`");
        _db.execSQL("DROP TABLE IF EXISTS `Logs`");
        _db.execSQL("DROP TABLE IF EXISTS `ContentTable`");
        _db.execSQL("DROP TABLE IF EXISTS `ContentProgress`");
        _db.execSQL("DROP TABLE IF EXISTS `KeyWords`");
        _db.execSQL("DROP TABLE IF EXISTS `WordEnglish`");
        _db.execSQL("DROP TABLE IF EXISTS `MatchThePair`");
        _db.execSQL("DROP TABLE IF EXISTS `CourseEnrolled`");
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
        final HashMap<String, TableInfo.Column> _columnsCrl = new HashMap<String, TableInfo.Column>(13);
        _columnsCrl.put("CrlTableId", new TableInfo.Column("CrlTableId", "INTEGER", true, 1));
        _columnsCrl.put("CRLId", new TableInfo.Column("CRLId", "TEXT", false, 0));
        _columnsCrl.put("FirstName", new TableInfo.Column("FirstName", "TEXT", false, 0));
        _columnsCrl.put("LastName", new TableInfo.Column("LastName", "TEXT", false, 0));
        _columnsCrl.put("UserName", new TableInfo.Column("UserName", "TEXT", false, 0));
        _columnsCrl.put("Password", new TableInfo.Column("Password", "TEXT", false, 0));
        _columnsCrl.put("ProgramId", new TableInfo.Column("ProgramId", "INTEGER", true, 0));
        _columnsCrl.put("ProgramName", new TableInfo.Column("ProgramName", "TEXT", false, 0));
        _columnsCrl.put("Mobile", new TableInfo.Column("Mobile", "TEXT", false, 0));
        _columnsCrl.put("State", new TableInfo.Column("State", "TEXT", false, 0));
        _columnsCrl.put("Email", new TableInfo.Column("Email", "TEXT", false, 0));
        _columnsCrl.put("CreatedBy", new TableInfo.Column("CreatedBy", "TEXT", false, 0));
        _columnsCrl.put("newCrl", new TableInfo.Column("newCrl", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCrl = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCrl = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCrl = new TableInfo("Crl", _columnsCrl, _foreignKeysCrl, _indicesCrl);
        final TableInfo _existingCrl = TableInfo.read(_db, "Crl");
        if (! _infoCrl.equals(_existingCrl)) {
          throw new IllegalStateException("Migration didn't properly handle Crl(com.pratham.foundation.database.domain.Crl).\n"
                  + " Expected:\n" + _infoCrl + "\n"
                  + " Found:\n" + _existingCrl);
        }
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(17);
        _columnsStudent.put("StudentID", new TableInfo.Column("StudentID", "TEXT", true, 1));
        _columnsStudent.put("FullName", new TableInfo.Column("FullName", "TEXT", false, 0));
        _columnsStudent.put("Gender", new TableInfo.Column("Gender", "TEXT", false, 0));
        _columnsStudent.put("Age", new TableInfo.Column("Age", "INTEGER", true, 0));
        _columnsStudent.put("Stud_Class", new TableInfo.Column("Stud_Class", "TEXT", false, 0));
        _columnsStudent.put("GroupId", new TableInfo.Column("GroupId", "TEXT", false, 0));
        _columnsStudent.put("GroupName", new TableInfo.Column("GroupName", "TEXT", false, 0));
        _columnsStudent.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        _columnsStudent.put("DeviceId", new TableInfo.Column("DeviceId", "TEXT", false, 0));
        _columnsStudent.put("StudentUID", new TableInfo.Column("StudentUID", "TEXT", false, 0));
        _columnsStudent.put("FirstName", new TableInfo.Column("FirstName", "TEXT", false, 0));
        _columnsStudent.put("MiddleName", new TableInfo.Column("MiddleName", "TEXT", false, 0));
        _columnsStudent.put("LastName", new TableInfo.Column("LastName", "TEXT", false, 0));
        _columnsStudent.put("regDate", new TableInfo.Column("regDate", "TEXT", false, 0));
        _columnsStudent.put("villageName", new TableInfo.Column("villageName", "TEXT", false, 0));
        _columnsStudent.put("newFlag", new TableInfo.Column("newFlag", "INTEGER", true, 0));
        _columnsStudent.put("avatarName", new TableInfo.Column("avatarName", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudent = new TableInfo("Student", _columnsStudent, _foreignKeysStudent, _indicesStudent);
        final TableInfo _existingStudent = TableInfo.read(_db, "Student");
        if (! _infoStudent.equals(_existingStudent)) {
          throw new IllegalStateException("Migration didn't properly handle Student(com.pratham.foundation.database.domain.Student).\n"
                  + " Expected:\n" + _infoStudent + "\n"
                  + " Found:\n" + _existingStudent);
        }
        final HashMap<String, TableInfo.Column> _columnsScore = new HashMap<String, TableInfo.Column>(13);
        _columnsScore.put("ScoreId", new TableInfo.Column("ScoreId", "INTEGER", true, 1));
        _columnsScore.put("SessionID", new TableInfo.Column("SessionID", "TEXT", false, 0));
        _columnsScore.put("StudentID", new TableInfo.Column("StudentID", "TEXT", false, 0));
        _columnsScore.put("DeviceID", new TableInfo.Column("DeviceID", "TEXT", false, 0));
        _columnsScore.put("ResourceID", new TableInfo.Column("ResourceID", "TEXT", false, 0));
        _columnsScore.put("QuestionId", new TableInfo.Column("QuestionId", "INTEGER", true, 0));
        _columnsScore.put("ScoredMarks", new TableInfo.Column("ScoredMarks", "INTEGER", true, 0));
        _columnsScore.put("TotalMarks", new TableInfo.Column("TotalMarks", "INTEGER", true, 0));
        _columnsScore.put("StartDateTime", new TableInfo.Column("StartDateTime", "TEXT", false, 0));
        _columnsScore.put("EndDateTime", new TableInfo.Column("EndDateTime", "TEXT", false, 0));
        _columnsScore.put("Level", new TableInfo.Column("Level", "INTEGER", true, 0));
        _columnsScore.put("Label", new TableInfo.Column("Label", "TEXT", false, 0));
        _columnsScore.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScore = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScore = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScore = new TableInfo("Score", _columnsScore, _foreignKeysScore, _indicesScore);
        final TableInfo _existingScore = TableInfo.read(_db, "Score");
        if (! _infoScore.equals(_existingScore)) {
          throw new IllegalStateException("Migration didn't properly handle Score(com.pratham.foundation.database.domain.Score).\n"
                  + " Expected:\n" + _infoScore + "\n"
                  + " Found:\n" + _existingScore);
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
          throw new IllegalStateException("Migration didn't properly handle Session(com.pratham.foundation.database.domain.Session).\n"
                  + " Expected:\n" + _infoSession + "\n"
                  + " Found:\n" + _existingSession);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendance = new HashMap<String, TableInfo.Column>(6);
        _columnsAttendance.put("attendanceID", new TableInfo.Column("attendanceID", "INTEGER", true, 1));
        _columnsAttendance.put("SessionID", new TableInfo.Column("SessionID", "TEXT", false, 0));
        _columnsAttendance.put("StudentID", new TableInfo.Column("StudentID", "TEXT", false, 0));
        _columnsAttendance.put("Date", new TableInfo.Column("Date", "TEXT", false, 0));
        _columnsAttendance.put("GroupID", new TableInfo.Column("GroupID", "TEXT", false, 0));
        _columnsAttendance.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttendance = new TableInfo("Attendance", _columnsAttendance, _foreignKeysAttendance, _indicesAttendance);
        final TableInfo _existingAttendance = TableInfo.read(_db, "Attendance");
        if (! _infoAttendance.equals(_existingAttendance)) {
          throw new IllegalStateException("Migration didn't properly handle Attendance(com.pratham.foundation.database.domain.Attendance).\n"
                  + " Expected:\n" + _infoAttendance + "\n"
                  + " Found:\n" + _existingAttendance);
        }
        final HashMap<String, TableInfo.Column> _columnsStatus = new HashMap<String, TableInfo.Column>(4);
        _columnsStatus.put("statusID", new TableInfo.Column("statusID", "INTEGER", true, 1));
        _columnsStatus.put("statusKey", new TableInfo.Column("statusKey", "TEXT", false, 0));
        _columnsStatus.put("value", new TableInfo.Column("value", "TEXT", true, 0));
        _columnsStatus.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStatus = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStatus = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStatus = new TableInfo("Status", _columnsStatus, _foreignKeysStatus, _indicesStatus);
        final TableInfo _existingStatus = TableInfo.read(_db, "Status");
        if (! _infoStatus.equals(_existingStatus)) {
          throw new IllegalStateException("Migration didn't properly handle Status(com.pratham.foundation.database.domain.Status).\n"
                  + " Expected:\n" + _infoStatus + "\n"
                  + " Found:\n" + _existingStatus);
        }
        final HashMap<String, TableInfo.Column> _columnsVillage = new HashMap<String, TableInfo.Column>(7);
        _columnsVillage.put("VillageId", new TableInfo.Column("VillageId", "INTEGER", true, 1));
        _columnsVillage.put("VillageCode", new TableInfo.Column("VillageCode", "TEXT", false, 0));
        _columnsVillage.put("VillageName", new TableInfo.Column("VillageName", "TEXT", false, 0));
        _columnsVillage.put("Block", new TableInfo.Column("Block", "TEXT", false, 0));
        _columnsVillage.put("District", new TableInfo.Column("District", "TEXT", false, 0));
        _columnsVillage.put("State", new TableInfo.Column("State", "TEXT", false, 0));
        _columnsVillage.put("CRLId", new TableInfo.Column("CRLId", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVillage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVillage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVillage = new TableInfo("Village", _columnsVillage, _foreignKeysVillage, _indicesVillage);
        final TableInfo _existingVillage = TableInfo.read(_db, "Village");
        if (! _infoVillage.equals(_existingVillage)) {
          throw new IllegalStateException("Migration didn't properly handle Village(com.pratham.foundation.database.domain.Village).\n"
                  + " Expected:\n" + _infoVillage + "\n"
                  + " Found:\n" + _existingVillage);
        }
        final HashMap<String, TableInfo.Column> _columnsGroups = new HashMap<String, TableInfo.Column>(8);
        _columnsGroups.put("GroupId", new TableInfo.Column("GroupId", "TEXT", true, 1));
        _columnsGroups.put("GroupName", new TableInfo.Column("GroupName", "TEXT", false, 0));
        _columnsGroups.put("VillageId", new TableInfo.Column("VillageId", "TEXT", false, 0));
        _columnsGroups.put("ProgramId", new TableInfo.Column("ProgramId", "INTEGER", true, 0));
        _columnsGroups.put("GroupCode", new TableInfo.Column("GroupCode", "TEXT", false, 0));
        _columnsGroups.put("SchoolName", new TableInfo.Column("SchoolName", "TEXT", false, 0));
        _columnsGroups.put("VIllageName", new TableInfo.Column("VIllageName", "TEXT", false, 0));
        _columnsGroups.put("DeviceId", new TableInfo.Column("DeviceId", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGroups = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGroups = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGroups = new TableInfo("Groups", _columnsGroups, _foreignKeysGroups, _indicesGroups);
        final TableInfo _existingGroups = TableInfo.read(_db, "Groups");
        if (! _infoGroups.equals(_existingGroups)) {
          throw new IllegalStateException("Migration didn't properly handle Groups(com.pratham.foundation.database.domain.Groups).\n"
                  + " Expected:\n" + _infoGroups + "\n"
                  + " Found:\n" + _existingGroups);
        }
        final HashMap<String, TableInfo.Column> _columnsSupervisorData = new HashMap<String, TableInfo.Column>(6);
        _columnsSupervisorData.put("sId", new TableInfo.Column("sId", "INTEGER", true, 1));
        _columnsSupervisorData.put("supervisorId", new TableInfo.Column("supervisorId", "TEXT", false, 0));
        _columnsSupervisorData.put("assessmentSessionId", new TableInfo.Column("assessmentSessionId", "TEXT", false, 0));
        _columnsSupervisorData.put("supervisorName", new TableInfo.Column("supervisorName", "TEXT", false, 0));
        _columnsSupervisorData.put("supervisorPhoto", new TableInfo.Column("supervisorPhoto", "TEXT", false, 0));
        _columnsSupervisorData.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSupervisorData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSupervisorData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSupervisorData = new TableInfo("SupervisorData", _columnsSupervisorData, _foreignKeysSupervisorData, _indicesSupervisorData);
        final TableInfo _existingSupervisorData = TableInfo.read(_db, "SupervisorData");
        if (! _infoSupervisorData.equals(_existingSupervisorData)) {
          throw new IllegalStateException("Migration didn't properly handle SupervisorData(com.pratham.foundation.database.domain.SupervisorData).\n"
                  + " Expected:\n" + _infoSupervisorData + "\n"
                  + " Found:\n" + _existingSupervisorData);
        }
        final HashMap<String, TableInfo.Column> _columnsAssessment = new HashMap<String, TableInfo.Column>(14);
        _columnsAssessment.put("ScoreIda", new TableInfo.Column("ScoreIda", "INTEGER", true, 1));
        _columnsAssessment.put("SessionIDm", new TableInfo.Column("SessionIDm", "TEXT", false, 0));
        _columnsAssessment.put("SessionIDa", new TableInfo.Column("SessionIDa", "TEXT", false, 0));
        _columnsAssessment.put("StudentIDa", new TableInfo.Column("StudentIDa", "TEXT", false, 0));
        _columnsAssessment.put("DeviceIDa", new TableInfo.Column("DeviceIDa", "TEXT", false, 0));
        _columnsAssessment.put("ResourceIDa", new TableInfo.Column("ResourceIDa", "TEXT", false, 0));
        _columnsAssessment.put("QuestionIda", new TableInfo.Column("QuestionIda", "INTEGER", true, 0));
        _columnsAssessment.put("ScoredMarksa", new TableInfo.Column("ScoredMarksa", "INTEGER", true, 0));
        _columnsAssessment.put("TotalMarksa", new TableInfo.Column("TotalMarksa", "INTEGER", true, 0));
        _columnsAssessment.put("StartDateTimea", new TableInfo.Column("StartDateTimea", "TEXT", false, 0));
        _columnsAssessment.put("EndDateTimea", new TableInfo.Column("EndDateTimea", "TEXT", false, 0));
        _columnsAssessment.put("Levela", new TableInfo.Column("Levela", "INTEGER", true, 0));
        _columnsAssessment.put("Labela", new TableInfo.Column("Labela", "TEXT", false, 0));
        _columnsAssessment.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssessment = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAssessment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssessment = new TableInfo("Assessment", _columnsAssessment, _foreignKeysAssessment, _indicesAssessment);
        final TableInfo _existingAssessment = TableInfo.read(_db, "Assessment");
        if (! _infoAssessment.equals(_existingAssessment)) {
          throw new IllegalStateException("Migration didn't properly handle Assessment(com.pratham.foundation.database.domain.Assessment).\n"
                  + " Expected:\n" + _infoAssessment + "\n"
                  + " Found:\n" + _existingAssessment);
        }
        final HashMap<String, TableInfo.Column> _columnsLogs = new HashMap<String, TableInfo.Column>(11);
        _columnsLogs.put("logId", new TableInfo.Column("logId", "INTEGER", true, 1));
        _columnsLogs.put("currentDateTime", new TableInfo.Column("currentDateTime", "TEXT", false, 0));
        _columnsLogs.put("exceptionMessage", new TableInfo.Column("exceptionMessage", "TEXT", false, 0));
        _columnsLogs.put("exceptionStackTrace", new TableInfo.Column("exceptionStackTrace", "TEXT", false, 0));
        _columnsLogs.put("methodName", new TableInfo.Column("methodName", "TEXT", false, 0));
        _columnsLogs.put("errorType", new TableInfo.Column("errorType", "TEXT", false, 0));
        _columnsLogs.put("groupId", new TableInfo.Column("groupId", "TEXT", false, 0));
        _columnsLogs.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0));
        _columnsLogs.put("LogDetail", new TableInfo.Column("LogDetail", "TEXT", false, 0));
        _columnsLogs.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        _columnsLogs.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLogs = new TableInfo("Logs", _columnsLogs, _foreignKeysLogs, _indicesLogs);
        final TableInfo _existingLogs = TableInfo.read(_db, "Logs");
        if (! _infoLogs.equals(_existingLogs)) {
          throw new IllegalStateException("Migration didn't properly handle Logs(com.pratham.foundation.database.domain.Modal_Log).\n"
                  + " Expected:\n" + _infoLogs + "\n"
                  + " Found:\n" + _existingLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsContentTable = new HashMap<String, TableInfo.Column>(23);
        _columnsContentTable.put("nodeId", new TableInfo.Column("nodeId", "TEXT", true, 1));
        _columnsContentTable.put("level", new TableInfo.Column("level", "TEXT", false, 0));
        _columnsContentTable.put("resourceId", new TableInfo.Column("resourceId", "TEXT", false, 0));
        _columnsContentTable.put("parentId", new TableInfo.Column("parentId", "TEXT", false, 0));
        _columnsContentTable.put("nodeDesc", new TableInfo.Column("nodeDesc", "TEXT", false, 0));
        _columnsContentTable.put("nodeType", new TableInfo.Column("nodeType", "TEXT", false, 0));
        _columnsContentTable.put("nodeEnglishTitle", new TableInfo.Column("nodeEnglishTitle", "TEXT", false, 0));
        _columnsContentTable.put("nodeTitle", new TableInfo.Column("nodeTitle", "TEXT", false, 0));
        _columnsContentTable.put("resourcePath", new TableInfo.Column("resourcePath", "TEXT", false, 0));
        _columnsContentTable.put("resourceType", new TableInfo.Column("resourceType", "TEXT", false, 0));
        _columnsContentTable.put("nodeServerImage", new TableInfo.Column("nodeServerImage", "TEXT", false, 0));
        _columnsContentTable.put("nodeImage", new TableInfo.Column("nodeImage", "TEXT", false, 0));
        _columnsContentTable.put("nodeAge", new TableInfo.Column("nodeAge", "TEXT", false, 0));
        _columnsContentTable.put("contentLanguage", new TableInfo.Column("contentLanguage", "TEXT", false, 0));
        _columnsContentTable.put("version", new TableInfo.Column("version", "TEXT", false, 0));
        _columnsContentTable.put("origNodeVersion", new TableInfo.Column("origNodeVersion", "TEXT", false, 0));
        _columnsContentTable.put("subject", new TableInfo.Column("subject", "TEXT", false, 0));
        _columnsContentTable.put("seq_no", new TableInfo.Column("seq_no", "INTEGER", true, 0));
        _columnsContentTable.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsContentTable.put("nodeKeywords", new TableInfo.Column("nodeKeywords", "TEXT", false, 0));
        _columnsContentTable.put("isDownloaded", new TableInfo.Column("isDownloaded", "TEXT", false, 0));
        _columnsContentTable.put("contentType", new TableInfo.Column("contentType", "TEXT", false, 0));
        _columnsContentTable.put("onSDCard", new TableInfo.Column("onSDCard", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContentTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContentTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContentTable = new TableInfo("ContentTable", _columnsContentTable, _foreignKeysContentTable, _indicesContentTable);
        final TableInfo _existingContentTable = TableInfo.read(_db, "ContentTable");
        if (! _infoContentTable.equals(_existingContentTable)) {
          throw new IllegalStateException("Migration didn't properly handle ContentTable(com.pratham.foundation.database.domain.ContentTable).\n"
                  + " Expected:\n" + _infoContentTable + "\n"
                  + " Found:\n" + _existingContentTable);
        }
        final HashMap<String, TableInfo.Column> _columnsContentProgress = new HashMap<String, TableInfo.Column>(8);
        _columnsContentProgress.put("progressId", new TableInfo.Column("progressId", "INTEGER", true, 1));
        _columnsContentProgress.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0));
        _columnsContentProgress.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsContentProgress.put("resourceId", new TableInfo.Column("resourceId", "TEXT", false, 0));
        _columnsContentProgress.put("updatedDateTime", new TableInfo.Column("updatedDateTime", "TEXT", false, 0));
        _columnsContentProgress.put("progressPercentage", new TableInfo.Column("progressPercentage", "TEXT", false, 0));
        _columnsContentProgress.put("label", new TableInfo.Column("label", "TEXT", false, 0));
        _columnsContentProgress.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContentProgress = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContentProgress = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContentProgress = new TableInfo("ContentProgress", _columnsContentProgress, _foreignKeysContentProgress, _indicesContentProgress);
        final TableInfo _existingContentProgress = TableInfo.read(_db, "ContentProgress");
        if (! _infoContentProgress.equals(_existingContentProgress)) {
          throw new IllegalStateException("Migration didn't properly handle ContentProgress(com.pratham.foundation.database.domain.ContentProgress).\n"
                  + " Expected:\n" + _infoContentProgress + "\n"
                  + " Found:\n" + _existingContentProgress);
        }
        final HashMap<String, TableInfo.Column> _columnsKeyWords = new HashMap<String, TableInfo.Column>(7);
        _columnsKeyWords.put("keyWordId", new TableInfo.Column("keyWordId", "INTEGER", true, 1));
        _columnsKeyWords.put("studentId", new TableInfo.Column("studentId", "TEXT", false, 0));
        _columnsKeyWords.put("resourceId", new TableInfo.Column("resourceId", "TEXT", false, 0));
        _columnsKeyWords.put("keyWord", new TableInfo.Column("keyWord", "TEXT", false, 0));
        _columnsKeyWords.put("wordType", new TableInfo.Column("wordType", "TEXT", false, 0));
        _columnsKeyWords.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        _columnsKeyWords.put("topic", new TableInfo.Column("topic", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKeyWords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKeyWords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKeyWords = new TableInfo("KeyWords", _columnsKeyWords, _foreignKeysKeyWords, _indicesKeyWords);
        final TableInfo _existingKeyWords = TableInfo.read(_db, "KeyWords");
        if (! _infoKeyWords.equals(_existingKeyWords)) {
          throw new IllegalStateException("Migration didn't properly handle KeyWords(com.pratham.foundation.database.domain.KeyWords).\n"
                  + " Expected:\n" + _infoKeyWords + "\n"
                  + " Found:\n" + _existingKeyWords);
        }
        final HashMap<String, TableInfo.Column> _columnsWordEnglish = new HashMap<String, TableInfo.Column>(14);
        _columnsWordEnglish.put("wordId", new TableInfo.Column("wordId", "INTEGER", true, 1));
        _columnsWordEnglish.put("word", new TableInfo.Column("word", "TEXT", false, 0));
        _columnsWordEnglish.put("size", new TableInfo.Column("size", "INTEGER", true, 0));
        _columnsWordEnglish.put("start", new TableInfo.Column("start", "TEXT", false, 0));
        _columnsWordEnglish.put("type", new TableInfo.Column("type", "TEXT", false, 0));
        _columnsWordEnglish.put("meaning", new TableInfo.Column("meaning", "TEXT", false, 0));
        _columnsWordEnglish.put("label", new TableInfo.Column("label", "TEXT", false, 0));
        _columnsWordEnglish.put("vowelTogether", new TableInfo.Column("vowelTogether", "TEXT", false, 0));
        _columnsWordEnglish.put("blends", new TableInfo.Column("blends", "TEXT", false, 0));
        _columnsWordEnglish.put("vowels", new TableInfo.Column("vowels", "TEXT", false, 0));
        _columnsWordEnglish.put("blendCnt", new TableInfo.Column("blendCnt", "INTEGER", true, 0));
        _columnsWordEnglish.put("vowelCnt", new TableInfo.Column("vowelCnt", "INTEGER", true, 0));
        _columnsWordEnglish.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0));
        _columnsWordEnglish.put("synid", new TableInfo.Column("synid", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWordEnglish = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWordEnglish = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWordEnglish = new TableInfo("WordEnglish", _columnsWordEnglish, _foreignKeysWordEnglish, _indicesWordEnglish);
        final TableInfo _existingWordEnglish = TableInfo.read(_db, "WordEnglish");
        if (! _infoWordEnglish.equals(_existingWordEnglish)) {
          throw new IllegalStateException("Migration didn't properly handle WordEnglish(com.pratham.foundation.database.domain.WordEnglish).\n"
                  + " Expected:\n" + _infoWordEnglish + "\n"
                  + " Found:\n" + _existingWordEnglish);
        }
        final HashMap<String, TableInfo.Column> _columnsMatchThePair = new HashMap<String, TableInfo.Column>(5);
        _columnsMatchThePair.put("paraTitle", new TableInfo.Column("paraTitle", "TEXT", false, 0));
        _columnsMatchThePair.put("langText", new TableInfo.Column("langText", "TEXT", false, 0));
        _columnsMatchThePair.put("paraText", new TableInfo.Column("paraText", "TEXT", false, 0));
        _columnsMatchThePair.put("paraLang", new TableInfo.Column("paraLang", "TEXT", false, 0));
        _columnsMatchThePair.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMatchThePair = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMatchThePair = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMatchThePair = new TableInfo("MatchThePair", _columnsMatchThePair, _foreignKeysMatchThePair, _indicesMatchThePair);
        final TableInfo _existingMatchThePair = TableInfo.read(_db, "MatchThePair");
        if (! _infoMatchThePair.equals(_existingMatchThePair)) {
          throw new IllegalStateException("Migration didn't properly handle MatchThePair(com.pratham.foundation.modalclasses.MatchThePair).\n"
                  + " Expected:\n" + _infoMatchThePair + "\n"
                  + " Found:\n" + _existingMatchThePair);
        }
        final HashMap<String, TableInfo.Column> _columnsCourseEnrolled = new HashMap<String, TableInfo.Column>(12);
        _columnsCourseEnrolled.put("c_autoID", new TableInfo.Column("c_autoID", "INTEGER", true, 1));
        _columnsCourseEnrolled.put("courseId", new TableInfo.Column("courseId", "TEXT", false, 0));
        _columnsCourseEnrolled.put("groupId", new TableInfo.Column("groupId", "TEXT", false, 0));
        _columnsCourseEnrolled.put("planFromDate", new TableInfo.Column("planFromDate", "TEXT", false, 0));
        _columnsCourseEnrolled.put("planToDate", new TableInfo.Column("planToDate", "TEXT", false, 0));
        _columnsCourseEnrolled.put("coachVerified", new TableInfo.Column("coachVerified", "INTEGER", true, 0));
        _columnsCourseEnrolled.put("coachVerificationDate", new TableInfo.Column("coachVerificationDate", "TEXT", false, 0));
        _columnsCourseEnrolled.put("courseExperience", new TableInfo.Column("courseExperience", "TEXT", false, 0));
        _columnsCourseEnrolled.put("courseCompleted", new TableInfo.Column("courseCompleted", "INTEGER", true, 0));
        _columnsCourseEnrolled.put("coachImage", new TableInfo.Column("coachImage", "TEXT", false, 0));
        _columnsCourseEnrolled.put("language", new TableInfo.Column("language", "TEXT", false, 0));
        _columnsCourseEnrolled.put("sentFlag", new TableInfo.Column("sentFlag", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCourseEnrolled = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCourseEnrolled = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCourseEnrolled = new TableInfo("CourseEnrolled", _columnsCourseEnrolled, _foreignKeysCourseEnrolled, _indicesCourseEnrolled);
        final TableInfo _existingCourseEnrolled = TableInfo.read(_db, "CourseEnrolled");
        if (! _infoCourseEnrolled.equals(_existingCourseEnrolled)) {
          throw new IllegalStateException("Migration didn't properly handle CourseEnrolled(com.pratham.foundation.modalclasses.Model_CourseEnrollment).\n"
                  + " Expected:\n" + _infoCourseEnrolled + "\n"
                  + " Found:\n" + _existingCourseEnrolled);
        }
      }
    }, "45ae8ced541ac6f7f04c3baa0c943a14", "8ecd70cf329571e55d279a742d2ca3bb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Crl","Student","Score","Session","Attendance","Status","Village","Groups","SupervisorData","Assessment","Logs","ContentTable","ContentProgress","KeyWords","WordEnglish","MatchThePair","CourseEnrolled");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Crl`");
      _db.execSQL("DELETE FROM `Student`");
      _db.execSQL("DELETE FROM `Score`");
      _db.execSQL("DELETE FROM `Session`");
      _db.execSQL("DELETE FROM `Attendance`");
      _db.execSQL("DELETE FROM `Status`");
      _db.execSQL("DELETE FROM `Village`");
      _db.execSQL("DELETE FROM `Groups`");
      _db.execSQL("DELETE FROM `SupervisorData`");
      _db.execSQL("DELETE FROM `Assessment`");
      _db.execSQL("DELETE FROM `Logs`");
      _db.execSQL("DELETE FROM `ContentTable`");
      _db.execSQL("DELETE FROM `ContentProgress`");
      _db.execSQL("DELETE FROM `KeyWords`");
      _db.execSQL("DELETE FROM `WordEnglish`");
      _db.execSQL("DELETE FROM `MatchThePair`");
      _db.execSQL("DELETE FROM `CourseEnrolled`");
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
  public CrlDao getCrlDao() {
    if (_crlDao != null) {
      return _crlDao;
    } else {
      synchronized(this) {
        if(_crlDao == null) {
          _crlDao = new CrlDao_Impl(this);
        }
        return _crlDao;
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
  public AssessmentDao getAssessmentDao() {
    if (_assessmentDao != null) {
      return _assessmentDao;
    } else {
      synchronized(this) {
        if(_assessmentDao == null) {
          _assessmentDao = new AssessmentDao_Impl(this);
        }
        return _assessmentDao;
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
  public GroupDao getGroupsDao() {
    if (_groupDao != null) {
      return _groupDao;
    } else {
      synchronized(this) {
        if(_groupDao == null) {
          _groupDao = new GroupDao_Impl(this);
        }
        return _groupDao;
      }
    }
  }

  @Override
  public SupervisorDataDao getSupervisorDataDao() {
    if (_supervisorDataDao != null) {
      return _supervisorDataDao;
    } else {
      synchronized(this) {
        if(_supervisorDataDao == null) {
          _supervisorDataDao = new SupervisorDataDao_Impl(this);
        }
        return _supervisorDataDao;
      }
    }
  }

  @Override
  public LogDao getLogsDao() {
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
  public ContentTableDao getContentTableDao() {
    if (_contentTableDao != null) {
      return _contentTableDao;
    } else {
      synchronized(this) {
        if(_contentTableDao == null) {
          _contentTableDao = new ContentTableDao_Impl(this);
        }
        return _contentTableDao;
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
  public ContentProgressDao getContentProgressDao() {
    if (_contentProgressDao != null) {
      return _contentProgressDao;
    } else {
      synchronized(this) {
        if(_contentProgressDao == null) {
          _contentProgressDao = new ContentProgressDao_Impl(this);
        }
        return _contentProgressDao;
      }
    }
  }

  @Override
  public KeyWordDao getKeyWordDao() {
    if (_keyWordDao != null) {
      return _keyWordDao;
    } else {
      synchronized(this) {
        if(_keyWordDao == null) {
          _keyWordDao = new KeyWordDao_Impl(this);
        }
        return _keyWordDao;
      }
    }
  }

  @Override
  public EnglishWordDao getEnglishWordDao() {
    if (_englishWordDao != null) {
      return _englishWordDao;
    } else {
      synchronized(this) {
        if(_englishWordDao == null) {
          _englishWordDao = new EnglishWordDao_Impl(this);
        }
        return _englishWordDao;
      }
    }
  }

  @Override
  public MatchThePairDao getMatchThePairDao() {
    if (_matchThePairDao != null) {
      return _matchThePairDao;
    } else {
      synchronized(this) {
        if(_matchThePairDao == null) {
          _matchThePairDao = new MatchThePairDao_Impl(this);
        }
        return _matchThePairDao;
      }
    }
  }

  @Override
  public CourseDao getCourseDao() {
    if (_courseDao != null) {
      return _courseDao;
    } else {
      synchronized(this) {
        if(_courseDao == null) {
          _courseDao = new CourseDao_Impl(this);
        }
        return _courseDao;
      }
    }
  }
}
