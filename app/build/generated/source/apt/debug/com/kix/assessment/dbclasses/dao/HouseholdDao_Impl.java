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

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentHouseholdFlags;

  public HouseholdDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Household = new EntityInsertionAdapter<Modal_Household>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Household`(`hh_ID`,`houseHold_ID`,`houseHold_Name`,`houseHold_Address`,`Svr_Code`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Household value) {
        stmt.bindLong(1, value.hh_ID);
        if (value.houseHold_ID == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.houseHold_ID);
        }
        if (value.houseHold_Name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.houseHold_Name);
        }
        if (value.houseHold_Address == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.houseHold_Address);
        }
        if (value.Svr_Code == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.Svr_Code);
        }
        stmt.bindLong(6, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateSentHouseholdFlags = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Household set sentFlag=1 where houseHold_ID=?";
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
  public void updateSentHouseholdFlags(String householdId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentHouseholdFlags.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (householdId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, householdId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentHouseholdFlags.release(_stmt);
    }
  }

  @Override
  public Modal_Household getHouseholdBySurveyorCode(String svrCode) {
    final String _sql = "SELECT * FROM Household WHERE Svr_Code=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHhID = _cursor.getColumnIndexOrThrow("hh_ID");
      final int _cursorIndexOfHouseHoldID = _cursor.getColumnIndexOrThrow("houseHold_ID");
      final int _cursorIndexOfHouseHoldName = _cursor.getColumnIndexOrThrow("houseHold_Name");
      final int _cursorIndexOfHouseHoldAddress = _cursor.getColumnIndexOrThrow("houseHold_Address");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Household _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Household();
        _result.hh_ID = _cursor.getInt(_cursorIndexOfHhID);
        _result.houseHold_ID = _cursor.getString(_cursorIndexOfHouseHoldID);
        _result.houseHold_Name = _cursor.getString(_cursorIndexOfHouseHoldName);
        _result.houseHold_Address = _cursor.getString(_cursorIndexOfHouseHoldAddress);
        _result.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
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
  public List<Modal_Household> getAllHouseholdBySurveyorCode(String svrCode) {
    final String _sql = "SELECT * FROM Household WHERE Svr_Code=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHhID = _cursor.getColumnIndexOrThrow("hh_ID");
      final int _cursorIndexOfHouseHoldID = _cursor.getColumnIndexOrThrow("houseHold_ID");
      final int _cursorIndexOfHouseHoldName = _cursor.getColumnIndexOrThrow("houseHold_Name");
      final int _cursorIndexOfHouseHoldAddress = _cursor.getColumnIndexOrThrow("houseHold_Address");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Household> _result = new ArrayList<Modal_Household>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Household _item;
        _item = new Modal_Household();
        _item.hh_ID = _cursor.getInt(_cursorIndexOfHhID);
        _item.houseHold_ID = _cursor.getString(_cursorIndexOfHouseHoldID);
        _item.houseHold_Name = _cursor.getString(_cursorIndexOfHouseHoldName);
        _item.houseHold_Address = _cursor.getString(_cursorIndexOfHouseHoldAddress);
        _item.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
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
      final int _cursorIndexOfHhID = _cursor.getColumnIndexOrThrow("hh_ID");
      final int _cursorIndexOfHouseHoldID = _cursor.getColumnIndexOrThrow("houseHold_ID");
      final int _cursorIndexOfHouseHoldName = _cursor.getColumnIndexOrThrow("houseHold_Name");
      final int _cursorIndexOfHouseHoldAddress = _cursor.getColumnIndexOrThrow("houseHold_Address");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Household> _result = new ArrayList<Modal_Household>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Household _item;
        _item = new Modal_Household();
        _item.hh_ID = _cursor.getInt(_cursorIndexOfHhID);
        _item.houseHold_ID = _cursor.getString(_cursorIndexOfHouseHoldID);
        _item.houseHold_Name = _cursor.getString(_cursorIndexOfHouseHoldName);
        _item.houseHold_Address = _cursor.getString(_cursorIndexOfHouseHoldAddress);
        _item.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
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
