package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Student;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Student;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStudent;

  public StudentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Student = new EntityInsertionAdapter<Modal_Student>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Student`(`sId`,`studentId`,`studName`,`studAge`,`studGender`,`studClass`,`studEnrollmentStatus`,`studSchoolType`,`studDropoutYear`,`studentRegistrationDate`,`svrCode`,`householdId`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Student value) {
        stmt.bindLong(1, value.sId);
        if (value.studentId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.studentId);
        }
        if (value.studName == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.studName);
        }
        if (value.studAge == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.studAge);
        }
        if (value.studGender == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.studGender);
        }
        if (value.studClass == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.studClass);
        }
        if (value.studEnrollmentStatus == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.studEnrollmentStatus);
        }
        if (value.studSchoolType == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.studSchoolType);
        }
        if (value.studDropoutYear == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.studDropoutYear);
        }
        if (value.studentRegistrationDate == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.studentRegistrationDate);
        }
        if (value.svrCode == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.svrCode);
        }
        if (value.householdId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.householdId);
        }
        stmt.bindLong(13, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Student set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStudent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Student set studName=?, studAge=?, studGender=?,studClass=?, studEnrollmentStatus=?, studSchoolType=?,studDropOutYear=?, sentFlag=0 where studentId=?";
        return _query;
      }
    };
  }

  @Override
  public void insertStudent(Modal_Student studentsList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Student.insert(studentsList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSentFlag() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentFlag.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentFlag.release(_stmt);
    }
  }

  @Override
  public void updateStudent(String studName, String studAge, String studGender, String studClass,
      String studEnrollment, String studSchoolType, String studDropoutYear, String sId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStudent.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (studName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studName);
      }
      _argIndex = 2;
      if (studAge == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studAge);
      }
      _argIndex = 3;
      if (studGender == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studGender);
      }
      _argIndex = 4;
      if (studClass == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studClass);
      }
      _argIndex = 5;
      if (studEnrollment == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studEnrollment);
      }
      _argIndex = 6;
      if (studSchoolType == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studSchoolType);
      }
      _argIndex = 7;
      if (studDropoutYear == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studDropoutYear);
      }
      _argIndex = 8;
      if (sId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, sId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateStudent.release(_stmt);
    }
  }

  @Override
  public Modal_Student getStudentBySurveyorCode(String svrCode, String householdId) {
    final String _sql = "SELECT * FROM Student WHERE svrCode=? and householdId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    _argIndex = 2;
    if (householdId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, householdId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("studName");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("studAge");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("studGender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("studClass");
      final int _cursorIndexOfStudEnrollmentStatus = _cursor.getColumnIndexOrThrow("studEnrollmentStatus");
      final int _cursorIndexOfStudSchoolType = _cursor.getColumnIndexOrThrow("studSchoolType");
      final int _cursorIndexOfStudDropoutYear = _cursor.getColumnIndexOrThrow("studDropoutYear");
      final int _cursorIndexOfStudentRegistrationDate = _cursor.getColumnIndexOrThrow("studentRegistrationDate");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Student _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Student();
        _result.sId = _cursor.getInt(_cursorIndexOfSId);
        _result.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _result.studName = _cursor.getString(_cursorIndexOfStudName);
        _result.studAge = _cursor.getString(_cursorIndexOfStudAge);
        _result.studGender = _cursor.getString(_cursorIndexOfStudGender);
        _result.studClass = _cursor.getString(_cursorIndexOfStudClass);
        _result.studEnrollmentStatus = _cursor.getString(_cursorIndexOfStudEnrollmentStatus);
        _result.studSchoolType = _cursor.getString(_cursorIndexOfStudSchoolType);
        _result.studDropoutYear = _cursor.getString(_cursorIndexOfStudDropoutYear);
        _result.studentRegistrationDate = _cursor.getString(_cursorIndexOfStudentRegistrationDate);
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _result.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _result.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_Student> getAllStudentsBySurveyorCode(String svrCode, String householdId) {
    final String _sql = "SELECT * FROM Student WHERE svrCode=? and householdId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    _argIndex = 2;
    if (householdId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, householdId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("studName");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("studAge");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("studGender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("studClass");
      final int _cursorIndexOfStudEnrollmentStatus = _cursor.getColumnIndexOrThrow("studEnrollmentStatus");
      final int _cursorIndexOfStudSchoolType = _cursor.getColumnIndexOrThrow("studSchoolType");
      final int _cursorIndexOfStudDropoutYear = _cursor.getColumnIndexOrThrow("studDropoutYear");
      final int _cursorIndexOfStudentRegistrationDate = _cursor.getColumnIndexOrThrow("studentRegistrationDate");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.studName = _cursor.getString(_cursorIndexOfStudName);
        _item.studAge = _cursor.getString(_cursorIndexOfStudAge);
        _item.studGender = _cursor.getString(_cursorIndexOfStudGender);
        _item.studClass = _cursor.getString(_cursorIndexOfStudClass);
        _item.studEnrollmentStatus = _cursor.getString(_cursorIndexOfStudEnrollmentStatus);
        _item.studSchoolType = _cursor.getString(_cursorIndexOfStudSchoolType);
        _item.studDropoutYear = _cursor.getString(_cursorIndexOfStudDropoutYear);
        _item.studentRegistrationDate = _cursor.getString(_cursorIndexOfStudentRegistrationDate);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_Student> getAllStudentsBySurveyorCodeDescending(String svrCode,
      String householdId) {
    final String _sql = "SELECT * FROM Student WHERE svrCode=? and householdId=? ORDER BY sId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    _argIndex = 2;
    if (householdId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, householdId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("studName");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("studAge");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("studGender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("studClass");
      final int _cursorIndexOfStudEnrollmentStatus = _cursor.getColumnIndexOrThrow("studEnrollmentStatus");
      final int _cursorIndexOfStudSchoolType = _cursor.getColumnIndexOrThrow("studSchoolType");
      final int _cursorIndexOfStudDropoutYear = _cursor.getColumnIndexOrThrow("studDropoutYear");
      final int _cursorIndexOfStudentRegistrationDate = _cursor.getColumnIndexOrThrow("studentRegistrationDate");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.studName = _cursor.getString(_cursorIndexOfStudName);
        _item.studAge = _cursor.getString(_cursorIndexOfStudAge);
        _item.studGender = _cursor.getString(_cursorIndexOfStudGender);
        _item.studClass = _cursor.getString(_cursorIndexOfStudClass);
        _item.studEnrollmentStatus = _cursor.getString(_cursorIndexOfStudEnrollmentStatus);
        _item.studSchoolType = _cursor.getString(_cursorIndexOfStudSchoolType);
        _item.studDropoutYear = _cursor.getString(_cursorIndexOfStudDropoutYear);
        _item.studentRegistrationDate = _cursor.getString(_cursorIndexOfStudentRegistrationDate);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_Student> getAllStudentsBySurveyor(String svrCode) {
    final String _sql = "SELECT * FROM Student WHERE svrCode=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("studName");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("studAge");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("studGender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("studClass");
      final int _cursorIndexOfStudEnrollmentStatus = _cursor.getColumnIndexOrThrow("studEnrollmentStatus");
      final int _cursorIndexOfStudSchoolType = _cursor.getColumnIndexOrThrow("studSchoolType");
      final int _cursorIndexOfStudDropoutYear = _cursor.getColumnIndexOrThrow("studDropoutYear");
      final int _cursorIndexOfStudentRegistrationDate = _cursor.getColumnIndexOrThrow("studentRegistrationDate");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.studName = _cursor.getString(_cursorIndexOfStudName);
        _item.studAge = _cursor.getString(_cursorIndexOfStudAge);
        _item.studGender = _cursor.getString(_cursorIndexOfStudGender);
        _item.studClass = _cursor.getString(_cursorIndexOfStudClass);
        _item.studEnrollmentStatus = _cursor.getString(_cursorIndexOfStudEnrollmentStatus);
        _item.studSchoolType = _cursor.getString(_cursorIndexOfStudSchoolType);
        _item.studDropoutYear = _cursor.getString(_cursorIndexOfStudDropoutYear);
        _item.studentRegistrationDate = _cursor.getString(_cursorIndexOfStudentRegistrationDate);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_Student> getAllNewStudents() {
    final String _sql = "select * from Student where sentFlag = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("studName");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("studAge");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("studGender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("studClass");
      final int _cursorIndexOfStudEnrollmentStatus = _cursor.getColumnIndexOrThrow("studEnrollmentStatus");
      final int _cursorIndexOfStudSchoolType = _cursor.getColumnIndexOrThrow("studSchoolType");
      final int _cursorIndexOfStudDropoutYear = _cursor.getColumnIndexOrThrow("studDropoutYear");
      final int _cursorIndexOfStudentRegistrationDate = _cursor.getColumnIndexOrThrow("studentRegistrationDate");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.studName = _cursor.getString(_cursorIndexOfStudName);
        _item.studAge = _cursor.getString(_cursorIndexOfStudAge);
        _item.studGender = _cursor.getString(_cursorIndexOfStudGender);
        _item.studClass = _cursor.getString(_cursorIndexOfStudClass);
        _item.studEnrollmentStatus = _cursor.getString(_cursorIndexOfStudEnrollmentStatus);
        _item.studSchoolType = _cursor.getString(_cursorIndexOfStudSchoolType);
        _item.studDropoutYear = _cursor.getString(_cursorIndexOfStudDropoutYear);
        _item.studentRegistrationDate = _cursor.getString(_cursorIndexOfStudentRegistrationDate);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Modal_Student getStudentByStudId(String studId) {
    final String _sql = "SELECT * FROM Student WHERE studentId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("studName");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("studAge");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("studGender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("studClass");
      final int _cursorIndexOfStudEnrollmentStatus = _cursor.getColumnIndexOrThrow("studEnrollmentStatus");
      final int _cursorIndexOfStudSchoolType = _cursor.getColumnIndexOrThrow("studSchoolType");
      final int _cursorIndexOfStudDropoutYear = _cursor.getColumnIndexOrThrow("studDropoutYear");
      final int _cursorIndexOfStudentRegistrationDate = _cursor.getColumnIndexOrThrow("studentRegistrationDate");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Student _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Student();
        _result.sId = _cursor.getInt(_cursorIndexOfSId);
        _result.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _result.studName = _cursor.getString(_cursorIndexOfStudName);
        _result.studAge = _cursor.getString(_cursorIndexOfStudAge);
        _result.studGender = _cursor.getString(_cursorIndexOfStudGender);
        _result.studClass = _cursor.getString(_cursorIndexOfStudClass);
        _result.studEnrollmentStatus = _cursor.getString(_cursorIndexOfStudEnrollmentStatus);
        _result.studSchoolType = _cursor.getString(_cursorIndexOfStudSchoolType);
        _result.studDropoutYear = _cursor.getString(_cursorIndexOfStudDropoutYear);
        _result.studentRegistrationDate = _cursor.getString(_cursorIndexOfStudentRegistrationDate);
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _result.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _result.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
