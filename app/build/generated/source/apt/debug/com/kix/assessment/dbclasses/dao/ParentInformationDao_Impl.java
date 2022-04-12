package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_PIF;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class ParentInformationDao_Impl implements ParentInformationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_PIF;

  private final SharedSQLiteStatement __preparedStmtOfUpdateParent;

  public ParentInformationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_PIF = new EntityInsertionAdapter<Modal_PIF>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ParentInformation`(`pifId`,`PT01a`,`PT01b`,`PT01c`,`PT01d`,`PT01e`,`PT01f`,`PT02a`,`PT02b`,`PT02c`,`PT02d`,`PT02e`,`PT02f`,`studentId`,`householdId`,`createdOn`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_PIF value) {
        stmt.bindLong(1, value.pifId);
        if (value.PT01a == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.PT01a);
        }
        if (value.PT01b == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.PT01b);
        }
        if (value.PT01c == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.PT01c);
        }
        if (value.PT01d == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.PT01d);
        }
        if (value.PT01e == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.PT01e);
        }
        if (value.PT01f == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.PT01f);
        }
        if (value.PT02a == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.PT02a);
        }
        if (value.PT02b == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.PT02b);
        }
        if (value.PT02c == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.PT02c);
        }
        if (value.PT02d == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.PT02d);
        }
        if (value.PT02e == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.PT02e);
        }
        if (value.PT02f == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.PT02f);
        }
        if (value.studentId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.studentId);
        }
        if (value.householdId == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.householdId);
        }
        if (value.createdOn == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.createdOn);
        }
        stmt.bindLong(17, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateParent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update ParentInformation set PT01a=?, PT01b=?, PT01c=?, PT01d=?, PT01e=?, PT01f=?,PT02a=?, PT02b=?, PT02c=?, PT02d=?, PT02e=?, PT02f=?, sentFlag=0 where studentId=?";
        return _query;
      }
    };
  }

  @Override
  public void insertParentInfo(Modal_PIF modal_pif) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_PIF.insert(modal_pif);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateParent(String PT01a, String PT01b, String PT01c, String PT01d, String PT01e,
      String PT01f, String PT02a, String PT02b, String PT02c, String PT02d, String PT02e,
      String PT02f, String studentId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateParent.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (PT01a == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT01a);
      }
      _argIndex = 2;
      if (PT01b == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT01b);
      }
      _argIndex = 3;
      if (PT01c == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT01c);
      }
      _argIndex = 4;
      if (PT01d == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT01d);
      }
      _argIndex = 5;
      if (PT01e == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT01e);
      }
      _argIndex = 6;
      if (PT01f == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT01f);
      }
      _argIndex = 7;
      if (PT02a == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02a);
      }
      _argIndex = 8;
      if (PT02b == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02b);
      }
      _argIndex = 9;
      if (PT02c == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02c);
      }
      _argIndex = 10;
      if (PT02d == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02d);
      }
      _argIndex = 11;
      if (PT02e == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02e);
      }
      _argIndex = 12;
      if (PT02f == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02f);
      }
      _argIndex = 13;
      if (studentId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studentId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateParent.release(_stmt);
    }
  }

  @Override
  public Modal_PIF getPIFbyStudentId(String studentId) {
    final String _sql = "Select * from ParentInformation where studentId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfPifId = _cursor.getColumnIndexOrThrow("pifId");
      final int _cursorIndexOfPT01a = _cursor.getColumnIndexOrThrow("PT01a");
      final int _cursorIndexOfPT01b = _cursor.getColumnIndexOrThrow("PT01b");
      final int _cursorIndexOfPT01c = _cursor.getColumnIndexOrThrow("PT01c");
      final int _cursorIndexOfPT01d = _cursor.getColumnIndexOrThrow("PT01d");
      final int _cursorIndexOfPT01e = _cursor.getColumnIndexOrThrow("PT01e");
      final int _cursorIndexOfPT01f = _cursor.getColumnIndexOrThrow("PT01f");
      final int _cursorIndexOfPT02a = _cursor.getColumnIndexOrThrow("PT02a");
      final int _cursorIndexOfPT02b = _cursor.getColumnIndexOrThrow("PT02b");
      final int _cursorIndexOfPT02c = _cursor.getColumnIndexOrThrow("PT02c");
      final int _cursorIndexOfPT02d = _cursor.getColumnIndexOrThrow("PT02d");
      final int _cursorIndexOfPT02e = _cursor.getColumnIndexOrThrow("PT02e");
      final int _cursorIndexOfPT02f = _cursor.getColumnIndexOrThrow("PT02f");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_PIF _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_PIF();
        _result.pifId = _cursor.getInt(_cursorIndexOfPifId);
        _result.PT01a = _cursor.getString(_cursorIndexOfPT01a);
        _result.PT01b = _cursor.getString(_cursorIndexOfPT01b);
        _result.PT01c = _cursor.getString(_cursorIndexOfPT01c);
        _result.PT01d = _cursor.getString(_cursorIndexOfPT01d);
        _result.PT01e = _cursor.getString(_cursorIndexOfPT01e);
        _result.PT01f = _cursor.getString(_cursorIndexOfPT01f);
        _result.PT02a = _cursor.getString(_cursorIndexOfPT02a);
        _result.PT02b = _cursor.getString(_cursorIndexOfPT02b);
        _result.PT02c = _cursor.getString(_cursorIndexOfPT02c);
        _result.PT02d = _cursor.getString(_cursorIndexOfPT02d);
        _result.PT02e = _cursor.getString(_cursorIndexOfPT02e);
        _result.PT02f = _cursor.getString(_cursorIndexOfPT02f);
        _result.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _result.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
