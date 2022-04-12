package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Household;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class HouseholdDao_Impl implements HouseholdDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Household;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateHousehold;

  public HouseholdDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Household = new EntityInsertionAdapter<Modal_Household>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Household`(`hhId`,`householdId`,`householdName`,`HH01`,`HH02`,`HH03`,`HH04`,`HH05a`,`HH05b`,`HH06`,`createdOn`,`villageId`,`svrCode`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Household value) {
        stmt.bindLong(1, value.hhId);
        if (value.householdId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.householdId);
        }
        if (value.householdName == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.householdName);
        }
        if (value.HH01 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.HH01);
        }
        if (value.HH02 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.HH02);
        }
        if (value.HH03 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.HH03);
        }
        if (value.HH04 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.HH04);
        }
        if (value.HH05a == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.HH05a);
        }
        if (value.HH05b == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.HH05b);
        }
        if (value.HH06 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.HH06);
        }
        if (value.createdOn == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.createdOn);
        }
        if (value.villageId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.villageId);
        }
        if (value.svrCode == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.svrCode);
        }
        stmt.bindLong(14, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Household set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateHousehold = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Household set householdName=?, HH01=?, HH02=?, HH03=?,HH04=?, HH05a=?, HH05b=?, HH06=?, sentFlag=0 where householdId=? AND villageId=?";
        return _query;
      }
    };
  }

  @Override
  public void insertHousehold(Modal_Household modal_household) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Household.insert(modal_household);
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
  public void updateHousehold(String househldName, String respondentName, String householdHead,
      String memberCount, String telephoneNum, String haveChildren, String noOfChildren,
      String speakLang, String hId, String villageId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateHousehold.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (househldName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, househldName);
      }
      _argIndex = 2;
      if (respondentName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, respondentName);
      }
      _argIndex = 3;
      if (householdHead == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, householdHead);
      }
      _argIndex = 4;
      if (memberCount == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, memberCount);
      }
      _argIndex = 5;
      if (telephoneNum == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, telephoneNum);
      }
      _argIndex = 6;
      if (haveChildren == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, haveChildren);
      }
      _argIndex = 7;
      if (noOfChildren == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, noOfChildren);
      }
      _argIndex = 8;
      if (speakLang == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, speakLang);
      }
      _argIndex = 9;
      if (hId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, hId);
      }
      _argIndex = 10;
      if (villageId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, villageId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateHousehold.release(_stmt);
    }
  }

  @Override
  public Modal_Household getHouseholdBySurveyorCode(String householdId, String villageId) {
    final String _sql = "SELECT * FROM Household WHERE householdId=? AND villageId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (householdId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, householdId);
    }
    _argIndex = 2;
    if (villageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, villageId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHhId = _cursor.getColumnIndexOrThrow("hhId");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfHouseholdName = _cursor.getColumnIndexOrThrow("householdName");
      final int _cursorIndexOfHH01 = _cursor.getColumnIndexOrThrow("HH01");
      final int _cursorIndexOfHH02 = _cursor.getColumnIndexOrThrow("HH02");
      final int _cursorIndexOfHH03 = _cursor.getColumnIndexOrThrow("HH03");
      final int _cursorIndexOfHH04 = _cursor.getColumnIndexOrThrow("HH04");
      final int _cursorIndexOfHH05a = _cursor.getColumnIndexOrThrow("HH05a");
      final int _cursorIndexOfHH05b = _cursor.getColumnIndexOrThrow("HH05b");
      final int _cursorIndexOfHH06 = _cursor.getColumnIndexOrThrow("HH06");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Household _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Household();
        _result.hhId = _cursor.getInt(_cursorIndexOfHhId);
        _result.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _result.householdName = _cursor.getString(_cursorIndexOfHouseholdName);
        _result.HH01 = _cursor.getString(_cursorIndexOfHH01);
        _result.HH02 = _cursor.getString(_cursorIndexOfHH02);
        _result.HH03 = _cursor.getString(_cursorIndexOfHH03);
        _result.HH04 = _cursor.getString(_cursorIndexOfHH04);
        _result.HH05a = _cursor.getString(_cursorIndexOfHH05a);
        _result.HH05b = _cursor.getString(_cursorIndexOfHH05b);
        _result.HH06 = _cursor.getString(_cursorIndexOfHH06);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _result.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
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
  public List<Modal_Household> getAllHouseholdBySurveyorCode(String svrCode, String villageId) {
    final String _sql = "SELECT * FROM Household WHERE svrCode=? AND villageId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    _argIndex = 2;
    if (villageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, villageId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHhId = _cursor.getColumnIndexOrThrow("hhId");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfHouseholdName = _cursor.getColumnIndexOrThrow("householdName");
      final int _cursorIndexOfHH01 = _cursor.getColumnIndexOrThrow("HH01");
      final int _cursorIndexOfHH02 = _cursor.getColumnIndexOrThrow("HH02");
      final int _cursorIndexOfHH03 = _cursor.getColumnIndexOrThrow("HH03");
      final int _cursorIndexOfHH04 = _cursor.getColumnIndexOrThrow("HH04");
      final int _cursorIndexOfHH05a = _cursor.getColumnIndexOrThrow("HH05a");
      final int _cursorIndexOfHH05b = _cursor.getColumnIndexOrThrow("HH05b");
      final int _cursorIndexOfHH06 = _cursor.getColumnIndexOrThrow("HH06");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Household> _result = new ArrayList<Modal_Household>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Household _item;
        _item = new Modal_Household();
        _item.hhId = _cursor.getInt(_cursorIndexOfHhId);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.householdName = _cursor.getString(_cursorIndexOfHouseholdName);
        _item.HH01 = _cursor.getString(_cursorIndexOfHH01);
        _item.HH02 = _cursor.getString(_cursorIndexOfHH02);
        _item.HH03 = _cursor.getString(_cursorIndexOfHH03);
        _item.HH04 = _cursor.getString(_cursorIndexOfHH04);
        _item.HH05a = _cursor.getString(_cursorIndexOfHH05a);
        _item.HH05b = _cursor.getString(_cursorIndexOfHH05b);
        _item.HH06 = _cursor.getString(_cursorIndexOfHH06);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
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
  public List<Modal_Household> getAllHouseholdBySurveyorCodeDescending(String svrCode,
      String villageId) {
    final String _sql = "SELECT * FROM Household WHERE svrCode=? AND villageId =? ORDER BY householdId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    _argIndex = 2;
    if (villageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, villageId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHhId = _cursor.getColumnIndexOrThrow("hhId");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfHouseholdName = _cursor.getColumnIndexOrThrow("householdName");
      final int _cursorIndexOfHH01 = _cursor.getColumnIndexOrThrow("HH01");
      final int _cursorIndexOfHH02 = _cursor.getColumnIndexOrThrow("HH02");
      final int _cursorIndexOfHH03 = _cursor.getColumnIndexOrThrow("HH03");
      final int _cursorIndexOfHH04 = _cursor.getColumnIndexOrThrow("HH04");
      final int _cursorIndexOfHH05a = _cursor.getColumnIndexOrThrow("HH05a");
      final int _cursorIndexOfHH05b = _cursor.getColumnIndexOrThrow("HH05b");
      final int _cursorIndexOfHH06 = _cursor.getColumnIndexOrThrow("HH06");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Household> _result = new ArrayList<Modal_Household>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Household _item;
        _item = new Modal_Household();
        _item.hhId = _cursor.getInt(_cursorIndexOfHhId);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.householdName = _cursor.getString(_cursorIndexOfHouseholdName);
        _item.HH01 = _cursor.getString(_cursorIndexOfHH01);
        _item.HH02 = _cursor.getString(_cursorIndexOfHH02);
        _item.HH03 = _cursor.getString(_cursorIndexOfHH03);
        _item.HH04 = _cursor.getString(_cursorIndexOfHH04);
        _item.HH05a = _cursor.getString(_cursorIndexOfHH05a);
        _item.HH05b = _cursor.getString(_cursorIndexOfHH05b);
        _item.HH06 = _cursor.getString(_cursorIndexOfHH06);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
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
  public List<Modal_Household> getAllNewHouseholds() {
    final String _sql = "select * from Household where sentFlag = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHhId = _cursor.getColumnIndexOrThrow("hhId");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfHouseholdName = _cursor.getColumnIndexOrThrow("householdName");
      final int _cursorIndexOfHH01 = _cursor.getColumnIndexOrThrow("HH01");
      final int _cursorIndexOfHH02 = _cursor.getColumnIndexOrThrow("HH02");
      final int _cursorIndexOfHH03 = _cursor.getColumnIndexOrThrow("HH03");
      final int _cursorIndexOfHH04 = _cursor.getColumnIndexOrThrow("HH04");
      final int _cursorIndexOfHH05a = _cursor.getColumnIndexOrThrow("HH05a");
      final int _cursorIndexOfHH05b = _cursor.getColumnIndexOrThrow("HH05b");
      final int _cursorIndexOfHH06 = _cursor.getColumnIndexOrThrow("HH06");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Household> _result = new ArrayList<Modal_Household>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Household _item;
        _item = new Modal_Household();
        _item.hhId = _cursor.getInt(_cursorIndexOfHhId);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.householdName = _cursor.getString(_cursorIndexOfHouseholdName);
        _item.HH01 = _cursor.getString(_cursorIndexOfHH01);
        _item.HH02 = _cursor.getString(_cursorIndexOfHH02);
        _item.HH03 = _cursor.getString(_cursorIndexOfHH03);
        _item.HH04 = _cursor.getString(_cursorIndexOfHH04);
        _item.HH05a = _cursor.getString(_cursorIndexOfHH05a);
        _item.HH05b = _cursor.getString(_cursorIndexOfHH05b);
        _item.HH06 = _cursor.getString(_cursorIndexOfHH06);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
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
  public List<String> getAllHouseholdNameBySurveyorCode(String svrCode) {
    final String _sql = "SELECT householdName FROM Household WHERE svrCode=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Modal_Household getHouseholdByHouseholdId(String householdId) {
    final String _sql = "SELECT * FROM Household WHERE householdId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (householdId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, householdId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHhId = _cursor.getColumnIndexOrThrow("hhId");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfHouseholdName = _cursor.getColumnIndexOrThrow("householdName");
      final int _cursorIndexOfHH01 = _cursor.getColumnIndexOrThrow("HH01");
      final int _cursorIndexOfHH02 = _cursor.getColumnIndexOrThrow("HH02");
      final int _cursorIndexOfHH03 = _cursor.getColumnIndexOrThrow("HH03");
      final int _cursorIndexOfHH04 = _cursor.getColumnIndexOrThrow("HH04");
      final int _cursorIndexOfHH05a = _cursor.getColumnIndexOrThrow("HH05a");
      final int _cursorIndexOfHH05b = _cursor.getColumnIndexOrThrow("HH05b");
      final int _cursorIndexOfHH06 = _cursor.getColumnIndexOrThrow("HH06");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Household _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Household();
        _result.hhId = _cursor.getInt(_cursorIndexOfHhId);
        _result.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _result.householdName = _cursor.getString(_cursorIndexOfHouseholdName);
        _result.HH01 = _cursor.getString(_cursorIndexOfHH01);
        _result.HH02 = _cursor.getString(_cursorIndexOfHH02);
        _result.HH03 = _cursor.getString(_cursorIndexOfHH03);
        _result.HH04 = _cursor.getString(_cursorIndexOfHH04);
        _result.HH05a = _cursor.getString(_cursorIndexOfHH05a);
        _result.HH05b = _cursor.getString(_cursorIndexOfHH05b);
        _result.HH06 = _cursor.getString(_cursorIndexOfHH06);
        _result.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
        _result.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
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
