package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.modalclasses.Model_CourseEnrollment;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class CourseDao_Impl implements CourseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModel_CourseEnrollment;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfModel_CourseEnrollment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCourse;

  private final SharedSQLiteStatement __preparedStmtOfCoachVerifiedTheCourse;

  private final SharedSQLiteStatement __preparedStmtOfAddExperienceToCourse;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlag;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  public CourseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModel_CourseEnrollment = new EntityInsertionAdapter<Model_CourseEnrollment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `CourseEnrolled`(`c_autoID`,`courseId`,`groupId`,`planFromDate`,`planToDate`,`coachVerified`,`coachVerificationDate`,`courseExperience`,`courseCompleted`,`coachImage`,`language`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Model_CourseEnrollment value) {
        stmt.bindLong(1, value.getC_autoID());
        if (value.getCourseId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCourseId());
        }
        if (value.getGroupId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGroupId());
        }
        if (value.getPlanFromDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPlanFromDate());
        }
        if (value.getPlanToDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPlanToDate());
        }
        stmt.bindLong(6, value.getCoachVerified());
        if (value.getCoachVerificationDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCoachVerificationDate());
        }
        if (value.getCourseExperience() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCourseExperience());
        }
        final int _tmp;
        _tmp = value.isCourseCompleted() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        if (value.getCoachImage() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCoachImage());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getLanguage());
        }
        stmt.bindLong(12, value.getSentFlag());
      }
    };
    this.__updateAdapterOfModel_CourseEnrollment = new EntityDeletionOrUpdateAdapter<Model_CourseEnrollment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `CourseEnrolled` SET `c_autoID` = ?,`courseId` = ?,`groupId` = ?,`planFromDate` = ?,`planToDate` = ?,`coachVerified` = ?,`coachVerificationDate` = ?,`courseExperience` = ?,`courseCompleted` = ?,`coachImage` = ?,`language` = ?,`sentFlag` = ? WHERE `c_autoID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Model_CourseEnrollment value) {
        stmt.bindLong(1, value.getC_autoID());
        if (value.getCourseId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCourseId());
        }
        if (value.getGroupId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGroupId());
        }
        if (value.getPlanFromDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPlanFromDate());
        }
        if (value.getPlanToDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPlanToDate());
        }
        stmt.bindLong(6, value.getCoachVerified());
        if (value.getCoachVerificationDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCoachVerificationDate());
        }
        if (value.getCourseExperience() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCourseExperience());
        }
        final int _tmp;
        _tmp = value.isCourseCompleted() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        if (value.getCoachImage() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCoachImage());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getLanguage());
        }
        stmt.bindLong(12, value.getSentFlag());
        stmt.bindLong(13, value.getC_autoID());
      }
    };
    this.__preparedStmtOfDeleteCourse = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from CourseEnrolled WHERE  courseId=? and groupId=? and planFromDate LIKE '%' || ? || '%' and language=?";
        return _query;
      }
    };
    this.__preparedStmtOfCoachVerifiedTheCourse = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update CourseEnrolled SET coachVerified=1 and coachImage=? and coachVerificationDate=? WHERE courseId=? and groupId=? and planFromDate LIKE '%' || ? || '%' and coachVerified=1 and language=?";
        return _query;
      }
    };
    this.__preparedStmtOfAddExperienceToCourse = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update CourseEnrolled SET courseCompleted=1 and courseExperience=? and sentFlag=0  WHERE courseId=? and groupId=? and planFromDate LIKE '%' || ? || '%' and coachVerified=1 and language=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE CourseEnrolled SET sentFlag = 1 where courseId=? and groupId=? and language=?";
        return _query;
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update COURSEENROLLED set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
  }

  @Override
  public void insertCourse(Model_CourseEnrollment courseEnrolled) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModel_CourseEnrollment.insert(courseEnrolled);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertListCourse(List<Model_CourseEnrollment> enrollmentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModel_CourseEnrollment.insert(enrollmentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCourse(Model_CourseEnrollment enrollment) {
    __db.beginTransaction();
    try {
      __updateAdapterOfModel_CourseEnrollment.handle(enrollment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCourse(String nodeId, String grpId, String week, String lang) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCourse.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (nodeId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, nodeId);
      }
      _argIndex = 2;
      if (grpId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, grpId);
      }
      _argIndex = 3;
      if (week == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, week);
      }
      _argIndex = 4;
      if (lang == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, lang);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCourse.release(_stmt);
    }
  }

  @Override
  public void coachVerifiedTheCourse(String imagePath, String verificationDate, String courseId,
      String grpId, String week, String language) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfCoachVerifiedTheCourse.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (imagePath == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, imagePath);
      }
      _argIndex = 2;
      if (verificationDate == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, verificationDate);
      }
      _argIndex = 3;
      if (courseId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, courseId);
      }
      _argIndex = 4;
      if (grpId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, grpId);
      }
      _argIndex = 5;
      if (week == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, week);
      }
      _argIndex = 6;
      if (language == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, language);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfCoachVerifiedTheCourse.release(_stmt);
    }
  }

  @Override
  public void addExperienceToCourse(String courseExp, String courseId, String grpId, String week,
      String language) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfAddExperienceToCourse.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (courseExp == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, courseExp);
      }
      _argIndex = 2;
      if (courseId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, courseId);
      }
      _argIndex = 3;
      if (grpId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, grpId);
      }
      _argIndex = 4;
      if (week == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, week);
      }
      _argIndex = 5;
      if (language == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, language);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfAddExperienceToCourse.release(_stmt);
    }
  }

  @Override
  public int updateFlag(String courseId, String grpId, String language) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFlag.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (courseId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, courseId);
      }
      _argIndex = 2;
      if (grpId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, grpId);
      }
      _argIndex = 3;
      if (language == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, language);
      }
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFlag.release(_stmt);
    }
  }

  @Override
  public void setSentFlag() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetSentFlag.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetSentFlag.release(_stmt);
    }
  }

  @Override
  public List<Model_CourseEnrollment> fetchUnpushedCourses() {
    final String _sql = "Select * from COURSEENROLLED where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCAutoID = _cursor.getColumnIndexOrThrow("c_autoID");
      final int _cursorIndexOfCourseId = _cursor.getColumnIndexOrThrow("courseId");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("groupId");
      final int _cursorIndexOfPlanFromDate = _cursor.getColumnIndexOrThrow("planFromDate");
      final int _cursorIndexOfPlanToDate = _cursor.getColumnIndexOrThrow("planToDate");
      final int _cursorIndexOfCoachVerified = _cursor.getColumnIndexOrThrow("coachVerified");
      final int _cursorIndexOfCoachVerificationDate = _cursor.getColumnIndexOrThrow("coachVerificationDate");
      final int _cursorIndexOfCourseExperience = _cursor.getColumnIndexOrThrow("courseExperience");
      final int _cursorIndexOfCourseCompleted = _cursor.getColumnIndexOrThrow("courseCompleted");
      final int _cursorIndexOfCoachImage = _cursor.getColumnIndexOrThrow("coachImage");
      final int _cursorIndexOfLanguage = _cursor.getColumnIndexOrThrow("language");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Model_CourseEnrollment> _result = new ArrayList<Model_CourseEnrollment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Model_CourseEnrollment _item;
        _item = new Model_CourseEnrollment();
        final int _tmpC_autoID;
        _tmpC_autoID = _cursor.getInt(_cursorIndexOfCAutoID);
        _item.setC_autoID(_tmpC_autoID);
        final String _tmpCourseId;
        _tmpCourseId = _cursor.getString(_cursorIndexOfCourseId);
        _item.setCourseId(_tmpCourseId);
        final String _tmpGroupId;
        _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.setGroupId(_tmpGroupId);
        final String _tmpPlanFromDate;
        _tmpPlanFromDate = _cursor.getString(_cursorIndexOfPlanFromDate);
        _item.setPlanFromDate(_tmpPlanFromDate);
        final String _tmpPlanToDate;
        _tmpPlanToDate = _cursor.getString(_cursorIndexOfPlanToDate);
        _item.setPlanToDate(_tmpPlanToDate);
        final int _tmpCoachVerified;
        _tmpCoachVerified = _cursor.getInt(_cursorIndexOfCoachVerified);
        _item.setCoachVerified(_tmpCoachVerified);
        final String _tmpCoachVerificationDate;
        _tmpCoachVerificationDate = _cursor.getString(_cursorIndexOfCoachVerificationDate);
        _item.setCoachVerificationDate(_tmpCoachVerificationDate);
        final String _tmpCourseExperience;
        _tmpCourseExperience = _cursor.getString(_cursorIndexOfCourseExperience);
        _item.setCourseExperience(_tmpCourseExperience);
        final boolean _tmpCourseCompleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfCourseCompleted);
        _tmpCourseCompleted = _tmp != 0;
        _item.setCourseCompleted(_tmpCourseCompleted);
        final String _tmpCoachImage;
        _tmpCoachImage = _cursor.getString(_cursorIndexOfCoachImage);
        _item.setCoachImage(_tmpCoachImage);
        final String _tmpLanguage;
        _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        _item.setLanguage(_tmpLanguage);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Model_CourseEnrollment> fetchEnrolledCourses(String grp_id, String week,
      String language) {
    final String _sql = "Select * from COURSEENROLLED where groupId=? and planFromDate LIKE '%' || ? || '%' and language=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (grp_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, grp_id);
    }
    _argIndex = 2;
    if (week == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, week);
    }
    _argIndex = 3;
    if (language == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, language);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCAutoID = _cursor.getColumnIndexOrThrow("c_autoID");
      final int _cursorIndexOfCourseId = _cursor.getColumnIndexOrThrow("courseId");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("groupId");
      final int _cursorIndexOfPlanFromDate = _cursor.getColumnIndexOrThrow("planFromDate");
      final int _cursorIndexOfPlanToDate = _cursor.getColumnIndexOrThrow("planToDate");
      final int _cursorIndexOfCoachVerified = _cursor.getColumnIndexOrThrow("coachVerified");
      final int _cursorIndexOfCoachVerificationDate = _cursor.getColumnIndexOrThrow("coachVerificationDate");
      final int _cursorIndexOfCourseExperience = _cursor.getColumnIndexOrThrow("courseExperience");
      final int _cursorIndexOfCourseCompleted = _cursor.getColumnIndexOrThrow("courseCompleted");
      final int _cursorIndexOfCoachImage = _cursor.getColumnIndexOrThrow("coachImage");
      final int _cursorIndexOfLanguage = _cursor.getColumnIndexOrThrow("language");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Model_CourseEnrollment> _result = new ArrayList<Model_CourseEnrollment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Model_CourseEnrollment _item;
        _item = new Model_CourseEnrollment();
        final int _tmpC_autoID;
        _tmpC_autoID = _cursor.getInt(_cursorIndexOfCAutoID);
        _item.setC_autoID(_tmpC_autoID);
        final String _tmpCourseId;
        _tmpCourseId = _cursor.getString(_cursorIndexOfCourseId);
        _item.setCourseId(_tmpCourseId);
        final String _tmpGroupId;
        _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.setGroupId(_tmpGroupId);
        final String _tmpPlanFromDate;
        _tmpPlanFromDate = _cursor.getString(_cursorIndexOfPlanFromDate);
        _item.setPlanFromDate(_tmpPlanFromDate);
        final String _tmpPlanToDate;
        _tmpPlanToDate = _cursor.getString(_cursorIndexOfPlanToDate);
        _item.setPlanToDate(_tmpPlanToDate);
        final int _tmpCoachVerified;
        _tmpCoachVerified = _cursor.getInt(_cursorIndexOfCoachVerified);
        _item.setCoachVerified(_tmpCoachVerified);
        final String _tmpCoachVerificationDate;
        _tmpCoachVerificationDate = _cursor.getString(_cursorIndexOfCoachVerificationDate);
        _item.setCoachVerificationDate(_tmpCoachVerificationDate);
        final String _tmpCourseExperience;
        _tmpCourseExperience = _cursor.getString(_cursorIndexOfCourseExperience);
        _item.setCourseExperience(_tmpCourseExperience);
        final boolean _tmpCourseCompleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfCourseCompleted);
        _tmpCourseCompleted = _tmp != 0;
        _item.setCourseCompleted(_tmpCourseCompleted);
        final String _tmpCoachImage;
        _tmpCoachImage = _cursor.getString(_cursorIndexOfCoachImage);
        _item.setCoachImage(_tmpCoachImage);
        final String _tmpLanguage;
        _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        _item.setLanguage(_tmpLanguage);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Model_CourseEnrollment> fetchEnrolledCoursesNew(String grp_id, String language) {
    final String _sql = "Select * from COURSEENROLLED where groupId=? and language=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (grp_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, grp_id);
    }
    _argIndex = 2;
    if (language == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, language);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCAutoID = _cursor.getColumnIndexOrThrow("c_autoID");
      final int _cursorIndexOfCourseId = _cursor.getColumnIndexOrThrow("courseId");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("groupId");
      final int _cursorIndexOfPlanFromDate = _cursor.getColumnIndexOrThrow("planFromDate");
      final int _cursorIndexOfPlanToDate = _cursor.getColumnIndexOrThrow("planToDate");
      final int _cursorIndexOfCoachVerified = _cursor.getColumnIndexOrThrow("coachVerified");
      final int _cursorIndexOfCoachVerificationDate = _cursor.getColumnIndexOrThrow("coachVerificationDate");
      final int _cursorIndexOfCourseExperience = _cursor.getColumnIndexOrThrow("courseExperience");
      final int _cursorIndexOfCourseCompleted = _cursor.getColumnIndexOrThrow("courseCompleted");
      final int _cursorIndexOfCoachImage = _cursor.getColumnIndexOrThrow("coachImage");
      final int _cursorIndexOfLanguage = _cursor.getColumnIndexOrThrow("language");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Model_CourseEnrollment> _result = new ArrayList<Model_CourseEnrollment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Model_CourseEnrollment _item;
        _item = new Model_CourseEnrollment();
        final int _tmpC_autoID;
        _tmpC_autoID = _cursor.getInt(_cursorIndexOfCAutoID);
        _item.setC_autoID(_tmpC_autoID);
        final String _tmpCourseId;
        _tmpCourseId = _cursor.getString(_cursorIndexOfCourseId);
        _item.setCourseId(_tmpCourseId);
        final String _tmpGroupId;
        _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.setGroupId(_tmpGroupId);
        final String _tmpPlanFromDate;
        _tmpPlanFromDate = _cursor.getString(_cursorIndexOfPlanFromDate);
        _item.setPlanFromDate(_tmpPlanFromDate);
        final String _tmpPlanToDate;
        _tmpPlanToDate = _cursor.getString(_cursorIndexOfPlanToDate);
        _item.setPlanToDate(_tmpPlanToDate);
        final int _tmpCoachVerified;
        _tmpCoachVerified = _cursor.getInt(_cursorIndexOfCoachVerified);
        _item.setCoachVerified(_tmpCoachVerified);
        final String _tmpCoachVerificationDate;
        _tmpCoachVerificationDate = _cursor.getString(_cursorIndexOfCoachVerificationDate);
        _item.setCoachVerificationDate(_tmpCoachVerificationDate);
        final String _tmpCourseExperience;
        _tmpCourseExperience = _cursor.getString(_cursorIndexOfCourseExperience);
        _item.setCourseExperience(_tmpCourseExperience);
        final boolean _tmpCourseCompleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfCourseCompleted);
        _tmpCourseCompleted = _tmp != 0;
        _item.setCourseCompleted(_tmpCourseCompleted);
        final String _tmpCoachImage;
        _tmpCoachImage = _cursor.getString(_cursorIndexOfCoachImage);
        _item.setCoachImage(_tmpCoachImage);
        final String _tmpLanguage;
        _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        _item.setLanguage(_tmpLanguage);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Model_CourseEnrollment> getAllData() {
    final String _sql = "select * from COURSEENROLLED where sentFlag = 0 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCAutoID = _cursor.getColumnIndexOrThrow("c_autoID");
      final int _cursorIndexOfCourseId = _cursor.getColumnIndexOrThrow("courseId");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("groupId");
      final int _cursorIndexOfPlanFromDate = _cursor.getColumnIndexOrThrow("planFromDate");
      final int _cursorIndexOfPlanToDate = _cursor.getColumnIndexOrThrow("planToDate");
      final int _cursorIndexOfCoachVerified = _cursor.getColumnIndexOrThrow("coachVerified");
      final int _cursorIndexOfCoachVerificationDate = _cursor.getColumnIndexOrThrow("coachVerificationDate");
      final int _cursorIndexOfCourseExperience = _cursor.getColumnIndexOrThrow("courseExperience");
      final int _cursorIndexOfCourseCompleted = _cursor.getColumnIndexOrThrow("courseCompleted");
      final int _cursorIndexOfCoachImage = _cursor.getColumnIndexOrThrow("coachImage");
      final int _cursorIndexOfLanguage = _cursor.getColumnIndexOrThrow("language");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Model_CourseEnrollment> _result = new ArrayList<Model_CourseEnrollment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Model_CourseEnrollment _item;
        _item = new Model_CourseEnrollment();
        final int _tmpC_autoID;
        _tmpC_autoID = _cursor.getInt(_cursorIndexOfCAutoID);
        _item.setC_autoID(_tmpC_autoID);
        final String _tmpCourseId;
        _tmpCourseId = _cursor.getString(_cursorIndexOfCourseId);
        _item.setCourseId(_tmpCourseId);
        final String _tmpGroupId;
        _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.setGroupId(_tmpGroupId);
        final String _tmpPlanFromDate;
        _tmpPlanFromDate = _cursor.getString(_cursorIndexOfPlanFromDate);
        _item.setPlanFromDate(_tmpPlanFromDate);
        final String _tmpPlanToDate;
        _tmpPlanToDate = _cursor.getString(_cursorIndexOfPlanToDate);
        _item.setPlanToDate(_tmpPlanToDate);
        final int _tmpCoachVerified;
        _tmpCoachVerified = _cursor.getInt(_cursorIndexOfCoachVerified);
        _item.setCoachVerified(_tmpCoachVerified);
        final String _tmpCoachVerificationDate;
        _tmpCoachVerificationDate = _cursor.getString(_cursorIndexOfCoachVerificationDate);
        _item.setCoachVerificationDate(_tmpCoachVerificationDate);
        final String _tmpCourseExperience;
        _tmpCourseExperience = _cursor.getString(_cursorIndexOfCourseExperience);
        _item.setCourseExperience(_tmpCourseExperience);
        final boolean _tmpCourseCompleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfCourseCompleted);
        _tmpCourseCompleted = _tmp != 0;
        _item.setCourseCompleted(_tmpCourseCompleted);
        final String _tmpCoachImage;
        _tmpCoachImage = _cursor.getString(_cursorIndexOfCoachImage);
        _item.setCoachImage(_tmpCoachImage);
        final String _tmpLanguage;
        _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        _item.setLanguage(_tmpLanguage);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
