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
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ParentInformationDao_Impl implements ParentInformationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_PIF;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateParent;

  public ParentInformationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_PIF = new EntityInsertionAdapter<Modal_PIF>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ParentInformation`(`pifId`,`parentId`,`PT00`,`PT01a`,`PT01c`,`PT01d`,`PT01e`,`PT01f`,`PT02a`,`PT02c`,`PT02d`,`PT02e`,`PT02f`,`householdId`,`info_createdOn`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_PIF value) {
        stmt.bindLong(1, value.pifId);
        if (value.parentId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.parentId);
        }
        stmt.bindLong(3, value.PT00);
        if (value.PT01a == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.PT01a);
        }
        if (value.PT01c == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.PT01c);
        }
        if (value.PT01d == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.PT01d);
        }
        if (value.PT01e == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.PT01e);
        }
        if (value.PT01f == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.PT01f);
        }
        if (value.PT02a == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.PT02a);
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
        if (value.householdId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.householdId);
        }
        if (value.info_createdOn == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.info_createdOn);
        }
        stmt.bindLong(16, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update ParentInformation set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateParent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update ParentInformation set PT00=?, PT01a=?, PT01c=?, PT01d=?, PT01e=?, PT01f=?,PT02a=?, PT02c=?, PT02d=?, PT02e=?, PT02f=?, sentFlag=0 where parentId=?";
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
  public void updateParent(int PT00, String PT01a, String PT01c, String PT01d, String PT01e,
      String PT01f, String PT02a, String PT02c, String PT02d, String PT02e, String PT02f,
      String parentId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateParent.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, PT00);
      _argIndex = 2;
      if (PT01a == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT01a);
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
      if (PT02c == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02c);
      }
      _argIndex = 9;
      if (PT02d == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02d);
      }
      _argIndex = 10;
      if (PT02e == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02e);
      }
      _argIndex = 11;
      if (PT02f == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PT02f);
      }
      _argIndex = 12;
      if (parentId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, parentId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateParent.release(_stmt);
    }
  }

  @Override
  public Modal_PIF getPIFbyParentId(String parentId) {
    final String _sql = "Select * from ParentInformation where parentId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfPifId = _cursor.getColumnIndexOrThrow("pifId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfPT00 = _cursor.getColumnIndexOrThrow("PT00");
      final int _cursorIndexOfPT01a = _cursor.getColumnIndexOrThrow("PT01a");
      final int _cursorIndexOfPT01c = _cursor.getColumnIndexOrThrow("PT01c");
      final int _cursorIndexOfPT01d = _cursor.getColumnIndexOrThrow("PT01d");
      final int _cursorIndexOfPT01e = _cursor.getColumnIndexOrThrow("PT01e");
      final int _cursorIndexOfPT01f = _cursor.getColumnIndexOrThrow("PT01f");
      final int _cursorIndexOfPT02a = _cursor.getColumnIndexOrThrow("PT02a");
      final int _cursorIndexOfPT02c = _cursor.getColumnIndexOrThrow("PT02c");
      final int _cursorIndexOfPT02d = _cursor.getColumnIndexOrThrow("PT02d");
      final int _cursorIndexOfPT02e = _cursor.getColumnIndexOrThrow("PT02e");
      final int _cursorIndexOfPT02f = _cursor.getColumnIndexOrThrow("PT02f");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfInfoCreatedOn = _cursor.getColumnIndexOrThrow("info_createdOn");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_PIF _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_PIF();
        _result.pifId = _cursor.getInt(_cursorIndexOfPifId);
        _result.parentId = _cursor.getString(_cursorIndexOfParentId);
        _result.PT00 = _cursor.getInt(_cursorIndexOfPT00);
        _result.PT01a = _cursor.getString(_cursorIndexOfPT01a);
        _result.PT01c = _cursor.getString(_cursorIndexOfPT01c);
        _result.PT01d = _cursor.getString(_cursorIndexOfPT01d);
        _result.PT01e = _cursor.getString(_cursorIndexOfPT01e);
        _result.PT01f = _cursor.getString(_cursorIndexOfPT01f);
        _result.PT02a = _cursor.getString(_cursorIndexOfPT02a);
        _result.PT02c = _cursor.getString(_cursorIndexOfPT02c);
        _result.PT02d = _cursor.getString(_cursorIndexOfPT02d);
        _result.PT02e = _cursor.getString(_cursorIndexOfPT02e);
        _result.PT02f = _cursor.getString(_cursorIndexOfPT02f);
        _result.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _result.info_createdOn = _cursor.getString(_cursorIndexOfInfoCreatedOn);
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
  public List<Modal_PIF> getAllPIF() {
    final String _sql = "Select * from ParentInformation where sentFlag = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfPifId = _cursor.getColumnIndexOrThrow("pifId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfPT00 = _cursor.getColumnIndexOrThrow("PT00");
      final int _cursorIndexOfPT01a = _cursor.getColumnIndexOrThrow("PT01a");
      final int _cursorIndexOfPT01c = _cursor.getColumnIndexOrThrow("PT01c");
      final int _cursorIndexOfPT01d = _cursor.getColumnIndexOrThrow("PT01d");
      final int _cursorIndexOfPT01e = _cursor.getColumnIndexOrThrow("PT01e");
      final int _cursorIndexOfPT01f = _cursor.getColumnIndexOrThrow("PT01f");
      final int _cursorIndexOfPT02a = _cursor.getColumnIndexOrThrow("PT02a");
      final int _cursorIndexOfPT02c = _cursor.getColumnIndexOrThrow("PT02c");
      final int _cursorIndexOfPT02d = _cursor.getColumnIndexOrThrow("PT02d");
      final int _cursorIndexOfPT02e = _cursor.getColumnIndexOrThrow("PT02e");
      final int _cursorIndexOfPT02f = _cursor.getColumnIndexOrThrow("PT02f");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfInfoCreatedOn = _cursor.getColumnIndexOrThrow("info_createdOn");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_PIF> _result = new ArrayList<Modal_PIF>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_PIF _item;
        _item = new Modal_PIF();
        _item.pifId = _cursor.getInt(_cursorIndexOfPifId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.PT00 = _cursor.getInt(_cursorIndexOfPT00);
        _item.PT01a = _cursor.getString(_cursorIndexOfPT01a);
        _item.PT01c = _cursor.getString(_cursorIndexOfPT01c);
        _item.PT01d = _cursor.getString(_cursorIndexOfPT01d);
        _item.PT01e = _cursor.getString(_cursorIndexOfPT01e);
        _item.PT01f = _cursor.getString(_cursorIndexOfPT01f);
        _item.PT02a = _cursor.getString(_cursorIndexOfPT02a);
        _item.PT02c = _cursor.getString(_cursorIndexOfPT02c);
        _item.PT02d = _cursor.getString(_cursorIndexOfPT02d);
        _item.PT02e = _cursor.getString(_cursorIndexOfPT02e);
        _item.PT02f = _cursor.getString(_cursorIndexOfPT02f);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.info_createdOn = _cursor.getString(_cursorIndexOfInfoCreatedOn);
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
  public boolean getPIF(String parentId) {
    final String _sql = "select COUNT(*) from ParentInformation where parentId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_PIF> getParentFromHousehold(String hId) {
    final String _sql = "SELECT * FROM ParentInformation WHERE (PT01a!='NA' or PT02a!='NA') AND householdId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (hId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, hId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfPifId = _cursor.getColumnIndexOrThrow("pifId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfPT00 = _cursor.getColumnIndexOrThrow("PT00");
      final int _cursorIndexOfPT01a = _cursor.getColumnIndexOrThrow("PT01a");
      final int _cursorIndexOfPT01c = _cursor.getColumnIndexOrThrow("PT01c");
      final int _cursorIndexOfPT01d = _cursor.getColumnIndexOrThrow("PT01d");
      final int _cursorIndexOfPT01e = _cursor.getColumnIndexOrThrow("PT01e");
      final int _cursorIndexOfPT01f = _cursor.getColumnIndexOrThrow("PT01f");
      final int _cursorIndexOfPT02a = _cursor.getColumnIndexOrThrow("PT02a");
      final int _cursorIndexOfPT02c = _cursor.getColumnIndexOrThrow("PT02c");
      final int _cursorIndexOfPT02d = _cursor.getColumnIndexOrThrow("PT02d");
      final int _cursorIndexOfPT02e = _cursor.getColumnIndexOrThrow("PT02e");
      final int _cursorIndexOfPT02f = _cursor.getColumnIndexOrThrow("PT02f");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfInfoCreatedOn = _cursor.getColumnIndexOrThrow("info_createdOn");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_PIF> _result = new ArrayList<Modal_PIF>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_PIF _item;
        _item = new Modal_PIF();
        _item.pifId = _cursor.getInt(_cursorIndexOfPifId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.PT00 = _cursor.getInt(_cursorIndexOfPT00);
        _item.PT01a = _cursor.getString(_cursorIndexOfPT01a);
        _item.PT01c = _cursor.getString(_cursorIndexOfPT01c);
        _item.PT01d = _cursor.getString(_cursorIndexOfPT01d);
        _item.PT01e = _cursor.getString(_cursorIndexOfPT01e);
        _item.PT01f = _cursor.getString(_cursorIndexOfPT01f);
        _item.PT02a = _cursor.getString(_cursorIndexOfPT02a);
        _item.PT02c = _cursor.getString(_cursorIndexOfPT02c);
        _item.PT02d = _cursor.getString(_cursorIndexOfPT02d);
        _item.PT02e = _cursor.getString(_cursorIndexOfPT02e);
        _item.PT02f = _cursor.getString(_cursorIndexOfPT02f);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.info_createdOn = _cursor.getString(_cursorIndexOfInfoCreatedOn);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
