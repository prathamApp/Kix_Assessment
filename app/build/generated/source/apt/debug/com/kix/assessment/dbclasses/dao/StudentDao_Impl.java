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
        return "INSERT OR REPLACE INTO `Student`(`sId`,`studentId`,`CH01`,`CH02`,`CH03`,`CH04`,`CH05a`,`CH05b`,`CH05c`,`CH05d`,`CH05e`,`CH05f`,`CH06a`,`CH06b1`,`CH06b2`,`CH06b3`,`CH07`,`CH08`,`createdOn`,`svrCode`,`householdId`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Student value) {
        stmt.bindLong(1, value.sId);
        if (value.studentId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.studentId);
        }
        if (value.CH01 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.CH01);
        }
        if (value.CH02 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.CH02);
        }
        if (value.CH03 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.CH03);
        }
        if (value.CH04 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.CH04);
        }
        if (value.CH05a == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.CH05a);
        }
        if (value.CH05b == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.CH05b);
        }
        if (value.CH05c == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.CH05c);
        }
        if (value.CH05d == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.CH05d);
        }
        if (value.CH05e == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.CH05e);
        }
        if (value.CH05f == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.CH05f);
        }
        if (value.CH06a == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.CH06a);
        }
        if (value.CH06b1 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.CH06b1);
        }
        if (value.CH06b2 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.CH06b2);
        }
        if (value.CH06b3 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.CH06b3);
        }
        if (value.CH07 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.CH07);
        }
        if (value.CH08 == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.CH08);
        }
        if (value.createdOn == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.createdOn);
        }
        if (value.svrCode == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.svrCode);
        }
        if (value.householdId == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.householdId);
        }
        stmt.bindLong(22, value.sentFlag);
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
        final String _query = "update Student set CH01=?, CH02=?, CH03=?, CH04=?, CH05a=?, CH05b=?,CH05c=?, CH05d=?, CH05e=?, CH05f=?, CH06a=?,CH06b1=?, CH06b2=?, CH06b3=?, CH07=?, CH08=?, sentFlag=0 where studentId=?";
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
  public void updateStudent(String studName, String studAge, String studGender,
      String studEnrollment, String studClass, String studSchoolType, String instructionLang,
      String schoolStatus, String schoolActivities, String haveTextBooks,
      String isStudentEverEnrolled, String studDropoutYear, String studDropoutGrade,
      String dropoutReason, String everEnrolledInNursary, String paidTution, String sId) {
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
      if (studEnrollment == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studEnrollment);
      }
      _argIndex = 5;
      if (studClass == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studClass);
      }
      _argIndex = 6;
      if (studSchoolType == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studSchoolType);
      }
      _argIndex = 7;
      if (instructionLang == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, instructionLang);
      }
      _argIndex = 8;
      if (schoolStatus == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, schoolStatus);
      }
      _argIndex = 9;
      if (schoolActivities == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, schoolActivities);
      }
      _argIndex = 10;
      if (haveTextBooks == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, haveTextBooks);
      }
      _argIndex = 11;
      if (isStudentEverEnrolled == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, isStudentEverEnrolled);
      }
      _argIndex = 12;
      if (studDropoutYear == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studDropoutYear);
      }
      _argIndex = 13;
      if (studDropoutGrade == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studDropoutGrade);
      }
      _argIndex = 14;
      if (dropoutReason == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, dropoutReason);
      }
      _argIndex = 15;
      if (everEnrolledInNursary == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, everEnrolledInNursary);
      }
      _argIndex = 16;
      if (paidTution == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, paidTution);
      }
      _argIndex = 17;
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
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04 = _cursor.getColumnIndexOrThrow("CH04");
      final int _cursorIndexOfCH05a = _cursor.getColumnIndexOrThrow("CH05a");
      final int _cursorIndexOfCH05b = _cursor.getColumnIndexOrThrow("CH05b");
      final int _cursorIndexOfCH05c = _cursor.getColumnIndexOrThrow("CH05c");
      final int _cursorIndexOfCH05d = _cursor.getColumnIndexOrThrow("CH05d");
      final int _cursorIndexOfCH05e = _cursor.getColumnIndexOrThrow("CH05e");
      final int _cursorIndexOfCH05f = _cursor.getColumnIndexOrThrow("CH05f");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b1 = _cursor.getColumnIndexOrThrow("CH06b1");
      final int _cursorIndexOfCH06b2 = _cursor.getColumnIndexOrThrow("CH06b2");
      final int _cursorIndexOfCH06b3 = _cursor.getColumnIndexOrThrow("CH06b3");
      final int _cursorIndexOfCH07 = _cursor.getColumnIndexOrThrow("CH07");
      final int _cursorIndexOfCH08 = _cursor.getColumnIndexOrThrow("CH08");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Student _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Student();
        _result.sId = _cursor.getInt(_cursorIndexOfSId);
        _result.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _result.CH01 = _cursor.getString(_cursorIndexOfCH01);
        _result.CH02 = _cursor.getString(_cursorIndexOfCH02);
        _result.CH03 = _cursor.getString(_cursorIndexOfCH03);
        _result.CH04 = _cursor.getString(_cursorIndexOfCH04);
        _result.CH05a = _cursor.getString(_cursorIndexOfCH05a);
        _result.CH05b = _cursor.getString(_cursorIndexOfCH05b);
        _result.CH05c = _cursor.getString(_cursorIndexOfCH05c);
        _result.CH05d = _cursor.getString(_cursorIndexOfCH05d);
        _result.CH05e = _cursor.getString(_cursorIndexOfCH05e);
        _result.CH05f = _cursor.getString(_cursorIndexOfCH05f);
        _result.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _result.CH06b1 = _cursor.getString(_cursorIndexOfCH06b1);
        _result.CH06b2 = _cursor.getString(_cursorIndexOfCH06b2);
        _result.CH06b3 = _cursor.getString(_cursorIndexOfCH06b3);
        _result.CH07 = _cursor.getString(_cursorIndexOfCH07);
        _result.CH08 = _cursor.getString(_cursorIndexOfCH08);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04 = _cursor.getColumnIndexOrThrow("CH04");
      final int _cursorIndexOfCH05a = _cursor.getColumnIndexOrThrow("CH05a");
      final int _cursorIndexOfCH05b = _cursor.getColumnIndexOrThrow("CH05b");
      final int _cursorIndexOfCH05c = _cursor.getColumnIndexOrThrow("CH05c");
      final int _cursorIndexOfCH05d = _cursor.getColumnIndexOrThrow("CH05d");
      final int _cursorIndexOfCH05e = _cursor.getColumnIndexOrThrow("CH05e");
      final int _cursorIndexOfCH05f = _cursor.getColumnIndexOrThrow("CH05f");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b1 = _cursor.getColumnIndexOrThrow("CH06b1");
      final int _cursorIndexOfCH06b2 = _cursor.getColumnIndexOrThrow("CH06b2");
      final int _cursorIndexOfCH06b3 = _cursor.getColumnIndexOrThrow("CH06b3");
      final int _cursorIndexOfCH07 = _cursor.getColumnIndexOrThrow("CH07");
      final int _cursorIndexOfCH08 = _cursor.getColumnIndexOrThrow("CH08");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.CH01 = _cursor.getString(_cursorIndexOfCH01);
        _item.CH02 = _cursor.getString(_cursorIndexOfCH02);
        _item.CH03 = _cursor.getString(_cursorIndexOfCH03);
        _item.CH04 = _cursor.getString(_cursorIndexOfCH04);
        _item.CH05a = _cursor.getString(_cursorIndexOfCH05a);
        _item.CH05b = _cursor.getString(_cursorIndexOfCH05b);
        _item.CH05c = _cursor.getString(_cursorIndexOfCH05c);
        _item.CH05d = _cursor.getString(_cursorIndexOfCH05d);
        _item.CH05e = _cursor.getString(_cursorIndexOfCH05e);
        _item.CH05f = _cursor.getString(_cursorIndexOfCH05f);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b1 = _cursor.getString(_cursorIndexOfCH06b1);
        _item.CH06b2 = _cursor.getString(_cursorIndexOfCH06b2);
        _item.CH06b3 = _cursor.getString(_cursorIndexOfCH06b3);
        _item.CH07 = _cursor.getString(_cursorIndexOfCH07);
        _item.CH08 = _cursor.getString(_cursorIndexOfCH08);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04 = _cursor.getColumnIndexOrThrow("CH04");
      final int _cursorIndexOfCH05a = _cursor.getColumnIndexOrThrow("CH05a");
      final int _cursorIndexOfCH05b = _cursor.getColumnIndexOrThrow("CH05b");
      final int _cursorIndexOfCH05c = _cursor.getColumnIndexOrThrow("CH05c");
      final int _cursorIndexOfCH05d = _cursor.getColumnIndexOrThrow("CH05d");
      final int _cursorIndexOfCH05e = _cursor.getColumnIndexOrThrow("CH05e");
      final int _cursorIndexOfCH05f = _cursor.getColumnIndexOrThrow("CH05f");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b1 = _cursor.getColumnIndexOrThrow("CH06b1");
      final int _cursorIndexOfCH06b2 = _cursor.getColumnIndexOrThrow("CH06b2");
      final int _cursorIndexOfCH06b3 = _cursor.getColumnIndexOrThrow("CH06b3");
      final int _cursorIndexOfCH07 = _cursor.getColumnIndexOrThrow("CH07");
      final int _cursorIndexOfCH08 = _cursor.getColumnIndexOrThrow("CH08");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.CH01 = _cursor.getString(_cursorIndexOfCH01);
        _item.CH02 = _cursor.getString(_cursorIndexOfCH02);
        _item.CH03 = _cursor.getString(_cursorIndexOfCH03);
        _item.CH04 = _cursor.getString(_cursorIndexOfCH04);
        _item.CH05a = _cursor.getString(_cursorIndexOfCH05a);
        _item.CH05b = _cursor.getString(_cursorIndexOfCH05b);
        _item.CH05c = _cursor.getString(_cursorIndexOfCH05c);
        _item.CH05d = _cursor.getString(_cursorIndexOfCH05d);
        _item.CH05e = _cursor.getString(_cursorIndexOfCH05e);
        _item.CH05f = _cursor.getString(_cursorIndexOfCH05f);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b1 = _cursor.getString(_cursorIndexOfCH06b1);
        _item.CH06b2 = _cursor.getString(_cursorIndexOfCH06b2);
        _item.CH06b3 = _cursor.getString(_cursorIndexOfCH06b3);
        _item.CH07 = _cursor.getString(_cursorIndexOfCH07);
        _item.CH08 = _cursor.getString(_cursorIndexOfCH08);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04 = _cursor.getColumnIndexOrThrow("CH04");
      final int _cursorIndexOfCH05a = _cursor.getColumnIndexOrThrow("CH05a");
      final int _cursorIndexOfCH05b = _cursor.getColumnIndexOrThrow("CH05b");
      final int _cursorIndexOfCH05c = _cursor.getColumnIndexOrThrow("CH05c");
      final int _cursorIndexOfCH05d = _cursor.getColumnIndexOrThrow("CH05d");
      final int _cursorIndexOfCH05e = _cursor.getColumnIndexOrThrow("CH05e");
      final int _cursorIndexOfCH05f = _cursor.getColumnIndexOrThrow("CH05f");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b1 = _cursor.getColumnIndexOrThrow("CH06b1");
      final int _cursorIndexOfCH06b2 = _cursor.getColumnIndexOrThrow("CH06b2");
      final int _cursorIndexOfCH06b3 = _cursor.getColumnIndexOrThrow("CH06b3");
      final int _cursorIndexOfCH07 = _cursor.getColumnIndexOrThrow("CH07");
      final int _cursorIndexOfCH08 = _cursor.getColumnIndexOrThrow("CH08");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.CH01 = _cursor.getString(_cursorIndexOfCH01);
        _item.CH02 = _cursor.getString(_cursorIndexOfCH02);
        _item.CH03 = _cursor.getString(_cursorIndexOfCH03);
        _item.CH04 = _cursor.getString(_cursorIndexOfCH04);
        _item.CH05a = _cursor.getString(_cursorIndexOfCH05a);
        _item.CH05b = _cursor.getString(_cursorIndexOfCH05b);
        _item.CH05c = _cursor.getString(_cursorIndexOfCH05c);
        _item.CH05d = _cursor.getString(_cursorIndexOfCH05d);
        _item.CH05e = _cursor.getString(_cursorIndexOfCH05e);
        _item.CH05f = _cursor.getString(_cursorIndexOfCH05f);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b1 = _cursor.getString(_cursorIndexOfCH06b1);
        _item.CH06b2 = _cursor.getString(_cursorIndexOfCH06b2);
        _item.CH06b3 = _cursor.getString(_cursorIndexOfCH06b3);
        _item.CH07 = _cursor.getString(_cursorIndexOfCH07);
        _item.CH08 = _cursor.getString(_cursorIndexOfCH08);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04 = _cursor.getColumnIndexOrThrow("CH04");
      final int _cursorIndexOfCH05a = _cursor.getColumnIndexOrThrow("CH05a");
      final int _cursorIndexOfCH05b = _cursor.getColumnIndexOrThrow("CH05b");
      final int _cursorIndexOfCH05c = _cursor.getColumnIndexOrThrow("CH05c");
      final int _cursorIndexOfCH05d = _cursor.getColumnIndexOrThrow("CH05d");
      final int _cursorIndexOfCH05e = _cursor.getColumnIndexOrThrow("CH05e");
      final int _cursorIndexOfCH05f = _cursor.getColumnIndexOrThrow("CH05f");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b1 = _cursor.getColumnIndexOrThrow("CH06b1");
      final int _cursorIndexOfCH06b2 = _cursor.getColumnIndexOrThrow("CH06b2");
      final int _cursorIndexOfCH06b3 = _cursor.getColumnIndexOrThrow("CH06b3");
      final int _cursorIndexOfCH07 = _cursor.getColumnIndexOrThrow("CH07");
      final int _cursorIndexOfCH08 = _cursor.getColumnIndexOrThrow("CH08");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.CH01 = _cursor.getString(_cursorIndexOfCH01);
        _item.CH02 = _cursor.getString(_cursorIndexOfCH02);
        _item.CH03 = _cursor.getString(_cursorIndexOfCH03);
        _item.CH04 = _cursor.getString(_cursorIndexOfCH04);
        _item.CH05a = _cursor.getString(_cursorIndexOfCH05a);
        _item.CH05b = _cursor.getString(_cursorIndexOfCH05b);
        _item.CH05c = _cursor.getString(_cursorIndexOfCH05c);
        _item.CH05d = _cursor.getString(_cursorIndexOfCH05d);
        _item.CH05e = _cursor.getString(_cursorIndexOfCH05e);
        _item.CH05f = _cursor.getString(_cursorIndexOfCH05f);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b1 = _cursor.getString(_cursorIndexOfCH06b1);
        _item.CH06b2 = _cursor.getString(_cursorIndexOfCH06b2);
        _item.CH06b3 = _cursor.getString(_cursorIndexOfCH06b3);
        _item.CH07 = _cursor.getString(_cursorIndexOfCH07);
        _item.CH08 = _cursor.getString(_cursorIndexOfCH08);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04 = _cursor.getColumnIndexOrThrow("CH04");
      final int _cursorIndexOfCH05a = _cursor.getColumnIndexOrThrow("CH05a");
      final int _cursorIndexOfCH05b = _cursor.getColumnIndexOrThrow("CH05b");
      final int _cursorIndexOfCH05c = _cursor.getColumnIndexOrThrow("CH05c");
      final int _cursorIndexOfCH05d = _cursor.getColumnIndexOrThrow("CH05d");
      final int _cursorIndexOfCH05e = _cursor.getColumnIndexOrThrow("CH05e");
      final int _cursorIndexOfCH05f = _cursor.getColumnIndexOrThrow("CH05f");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b1 = _cursor.getColumnIndexOrThrow("CH06b1");
      final int _cursorIndexOfCH06b2 = _cursor.getColumnIndexOrThrow("CH06b2");
      final int _cursorIndexOfCH06b3 = _cursor.getColumnIndexOrThrow("CH06b3");
      final int _cursorIndexOfCH07 = _cursor.getColumnIndexOrThrow("CH07");
      final int _cursorIndexOfCH08 = _cursor.getColumnIndexOrThrow("CH08");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Student _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Student();
        _result.sId = _cursor.getInt(_cursorIndexOfSId);
        _result.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _result.CH01 = _cursor.getString(_cursorIndexOfCH01);
        _result.CH02 = _cursor.getString(_cursorIndexOfCH02);
        _result.CH03 = _cursor.getString(_cursorIndexOfCH03);
        _result.CH04 = _cursor.getString(_cursorIndexOfCH04);
        _result.CH05a = _cursor.getString(_cursorIndexOfCH05a);
        _result.CH05b = _cursor.getString(_cursorIndexOfCH05b);
        _result.CH05c = _cursor.getString(_cursorIndexOfCH05c);
        _result.CH05d = _cursor.getString(_cursorIndexOfCH05d);
        _result.CH05e = _cursor.getString(_cursorIndexOfCH05e);
        _result.CH05f = _cursor.getString(_cursorIndexOfCH05f);
        _result.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _result.CH06b1 = _cursor.getString(_cursorIndexOfCH06b1);
        _result.CH06b2 = _cursor.getString(_cursorIndexOfCH06b2);
        _result.CH06b3 = _cursor.getString(_cursorIndexOfCH06b3);
        _result.CH07 = _cursor.getString(_cursorIndexOfCH07);
        _result.CH08 = _cursor.getString(_cursorIndexOfCH08);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
