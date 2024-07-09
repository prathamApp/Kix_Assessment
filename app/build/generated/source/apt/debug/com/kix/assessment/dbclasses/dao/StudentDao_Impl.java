package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Student;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Student;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStudent;

  private final SharedSQLiteStatement __preparedStmtOfAddParentId;

  public StudentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Student = new EntityInsertionAdapter<Modal_Student>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Student`(`sId`,`studentId`,`CH01`,`CH02`,`CH03`,`CH04a`,`CH04b`,`CH05`,`CH06a`,`CH06b`,`CH06c`,`CH06f`,`CH06g`,`CH07a`,`CH07b`,`CH07c`,`CH07d`,`CH08a`,`CH08b`,`CH09a`,`CH09b`,`CH09c`,`createdOn`,`parentId`,`svrCode`,`householdId`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
        if (value.CH04a == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.CH04a);
        }
        if (value.CH04b == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.CH04b);
        }
        if (value.CH05 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.CH05);
        }
        if (value.CH06a == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.CH06a);
        }
        if (value.CH06b == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.CH06b);
        }
        if (value.CH06c == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.CH06c);
        }
        if (value.CH06f == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.CH06f);
        }
        if (value.CH06g == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.CH06g);
        }
        if (value.CH07a == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.CH07a);
        }
        if (value.CH07b == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.CH07b);
        }
        if (value.CH07c == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.CH07c);
        }
        if (value.CH07d == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.CH07d);
        }
        if (value.CH08a == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.CH08a);
        }
        if (value.CH08b == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.CH08b);
        }
        if (value.CH09a == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.CH09a);
        }
        if (value.CH09b == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.CH09b);
        }
        if (value.CH09c == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.CH09c);
        }
        if (value.createdOn == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.createdOn);
        }
        if (value.parentId == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.parentId);
        }
        if (value.svrCode == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.svrCode);
        }
        if (value.householdId == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.householdId);
        }
        stmt.bindLong(27, value.sentFlag);
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
        final String _query = "update Student set CH01=?, CH02=?, CH03=?, CH04a=?, CH04b=?, CH05=?, CH06a=?, CH06b=?, CH06c=?, CH06f=?, CH06g=?,CH07a=?, CH07b=?, CH07c=?, CH07d=?, CH09a=?, CH09b=?, CH08a=?, CH08b=?, CH09c=?, sentFlag=0 where studentId=?";
        return _query;
      }
    };
    this.__preparedStmtOfAddParentId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Student set parentId=?, sentFlag=0 where studentId=?";
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
  public void updateStudent(String studName, String studGender, String studAge,
      String anyDisability, String whichDisability, String studEnrollment, String studClass,
      String studSchoolType, String instructionLang, String haveTextBooks, String repeatGrade,
      String isStudentEverEnrolled, String studDropoutYear, String studDropoutGrade,
      String dropoutReason, String paidTution, String readMaterial, String helpChild,
      String mostOften, String oftenRead, String sId) {
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
      if (studGender == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studGender);
      }
      _argIndex = 3;
      if (studAge == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studAge);
      }
      _argIndex = 4;
      if (anyDisability == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, anyDisability);
      }
      _argIndex = 5;
      if (whichDisability == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, whichDisability);
      }
      _argIndex = 6;
      if (studEnrollment == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studEnrollment);
      }
      _argIndex = 7;
      if (studClass == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studClass);
      }
      _argIndex = 8;
      if (studSchoolType == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studSchoolType);
      }
      _argIndex = 9;
      if (instructionLang == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, instructionLang);
      }
      _argIndex = 10;
      if (haveTextBooks == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, haveTextBooks);
      }
      _argIndex = 11;
      if (repeatGrade == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, repeatGrade);
      }
      _argIndex = 12;
      if (isStudentEverEnrolled == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, isStudentEverEnrolled);
      }
      _argIndex = 13;
      if (studDropoutYear == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studDropoutYear);
      }
      _argIndex = 14;
      if (studDropoutGrade == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studDropoutGrade);
      }
      _argIndex = 15;
      if (dropoutReason == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, dropoutReason);
      }
      _argIndex = 16;
      if (paidTution == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, paidTution);
      }
      _argIndex = 17;
      if (readMaterial == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, readMaterial);
      }
      _argIndex = 18;
      if (helpChild == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, helpChild);
      }
      _argIndex = 19;
      if (mostOften == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, mostOften);
      }
      _argIndex = 20;
      if (oftenRead == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, oftenRead);
      }
      _argIndex = 21;
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
  public void addParentId(String parentId, String sId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfAddParentId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (parentId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, parentId);
      }
      _argIndex = 2;
      if (sId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, sId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfAddParentId.release(_stmt);
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
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
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
        _result.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _result.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _result.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _result.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _result.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _result.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _result.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _result.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _result.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _result.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _result.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _result.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _result.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _result.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _result.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _result.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _result.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _result.parentId = _cursor.getString(_cursorIndexOfParentId);
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
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
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
        _item.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _item.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _item.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _item.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _item.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _item.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _item.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _item.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _item.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _item.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _item.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _item.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _item.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _item.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _item.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
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
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
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
        _item.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _item.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _item.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _item.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _item.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _item.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _item.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _item.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _item.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _item.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _item.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _item.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _item.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _item.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _item.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
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
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
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
        _item.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _item.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _item.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _item.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _item.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _item.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _item.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _item.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _item.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _item.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _item.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _item.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _item.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _item.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _item.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
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
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
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
        _item.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _item.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _item.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _item.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _item.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _item.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _item.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _item.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _item.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _item.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _item.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _item.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _item.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _item.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _item.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _item.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
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
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
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
        _result.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _result.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _result.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _result.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _result.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _result.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _result.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _result.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _result.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _result.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _result.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _result.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _result.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _result.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _result.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _result.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _result.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _result.parentId = _cursor.getString(_cursorIndexOfParentId);
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
  public Modal_Student getStudentByParentId(String parId) {
    final String _sql = "SELECT * FROM Student WHERE parentId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (parId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
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
        _result.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _result.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _result.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _result.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _result.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _result.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _result.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _result.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _result.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _result.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _result.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _result.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _result.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _result.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _result.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _result.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _result.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _result.parentId = _cursor.getString(_cursorIndexOfParentId);
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
  public List<Modal_Student> getStudentByHouseHold(List<String> houseHoldList) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Student WHERE householdId IN (");
    final int _inputSize = houseHoldList.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : houseHoldList) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfCH01 = _cursor.getColumnIndexOrThrow("CH01");
      final int _cursorIndexOfCH02 = _cursor.getColumnIndexOrThrow("CH02");
      final int _cursorIndexOfCH03 = _cursor.getColumnIndexOrThrow("CH03");
      final int _cursorIndexOfCH04a = _cursor.getColumnIndexOrThrow("CH04a");
      final int _cursorIndexOfCH04b = _cursor.getColumnIndexOrThrow("CH04b");
      final int _cursorIndexOfCH05 = _cursor.getColumnIndexOrThrow("CH05");
      final int _cursorIndexOfCH06a = _cursor.getColumnIndexOrThrow("CH06a");
      final int _cursorIndexOfCH06b = _cursor.getColumnIndexOrThrow("CH06b");
      final int _cursorIndexOfCH06c = _cursor.getColumnIndexOrThrow("CH06c");
      final int _cursorIndexOfCH06f = _cursor.getColumnIndexOrThrow("CH06f");
      final int _cursorIndexOfCH06g = _cursor.getColumnIndexOrThrow("CH06g");
      final int _cursorIndexOfCH07a = _cursor.getColumnIndexOrThrow("CH07a");
      final int _cursorIndexOfCH07b = _cursor.getColumnIndexOrThrow("CH07b");
      final int _cursorIndexOfCH07c = _cursor.getColumnIndexOrThrow("CH07c");
      final int _cursorIndexOfCH07d = _cursor.getColumnIndexOrThrow("CH07d");
      final int _cursorIndexOfCH08a = _cursor.getColumnIndexOrThrow("CH08a");
      final int _cursorIndexOfCH08b = _cursor.getColumnIndexOrThrow("CH08b");
      final int _cursorIndexOfCH09a = _cursor.getColumnIndexOrThrow("CH09a");
      final int _cursorIndexOfCH09b = _cursor.getColumnIndexOrThrow("CH09b");
      final int _cursorIndexOfCH09c = _cursor.getColumnIndexOrThrow("CH09c");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item_1;
        _item_1 = new Modal_Student();
        _item_1.sId = _cursor.getInt(_cursorIndexOfSId);
        _item_1.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item_1.CH01 = _cursor.getString(_cursorIndexOfCH01);
        _item_1.CH02 = _cursor.getString(_cursorIndexOfCH02);
        _item_1.CH03 = _cursor.getString(_cursorIndexOfCH03);
        _item_1.CH04a = _cursor.getString(_cursorIndexOfCH04a);
        _item_1.CH04b = _cursor.getString(_cursorIndexOfCH04b);
        _item_1.CH05 = _cursor.getString(_cursorIndexOfCH05);
        _item_1.CH06a = _cursor.getString(_cursorIndexOfCH06a);
        _item_1.CH06b = _cursor.getString(_cursorIndexOfCH06b);
        _item_1.CH06c = _cursor.getString(_cursorIndexOfCH06c);
        _item_1.CH06f = _cursor.getString(_cursorIndexOfCH06f);
        _item_1.CH06g = _cursor.getString(_cursorIndexOfCH06g);
        _item_1.CH07a = _cursor.getString(_cursorIndexOfCH07a);
        _item_1.CH07b = _cursor.getString(_cursorIndexOfCH07b);
        _item_1.CH07c = _cursor.getString(_cursorIndexOfCH07c);
        _item_1.CH07d = _cursor.getString(_cursorIndexOfCH07d);
        _item_1.CH08a = _cursor.getString(_cursorIndexOfCH08a);
        _item_1.CH08b = _cursor.getString(_cursorIndexOfCH08b);
        _item_1.CH09a = _cursor.getString(_cursorIndexOfCH09a);
        _item_1.CH09b = _cursor.getString(_cursorIndexOfCH09b);
        _item_1.CH09c = _cursor.getString(_cursorIndexOfCH09c);
        _item_1.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item_1.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item_1.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item_1.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item_1.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
