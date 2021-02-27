package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Village;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class VillageDao_Impl implements VillageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfVillage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllVillages;

  public VillageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVillage = new EntityInsertionAdapter<Village>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Village`(`VillageId`,`VillageCode`,`VillageName`,`Block`,`District`,`State`,`CRLId`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Village value) {
        stmt.bindLong(1, value.VillageId);
        if (value.VillageCode == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.VillageCode);
        }
        if (value.VillageName == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.VillageName);
        }
        if (value.Block == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.Block);
        }
        if (value.District == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.District);
        }
        if (value.State == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.State);
        }
        if (value.CRLId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.CRLId);
        }
      }
    };
    this.__preparedStmtOfDeleteAllVillages = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Village";
        return _query;
      }
    };
  }

  @Override
  public void insertAllVillages(List<Village> villagesList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfVillage.insert(villagesList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertVillage(Village modal_village) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfVillage.insert(modal_village);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllVillages() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllVillages.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllVillages.release(_stmt);
    }
  }

  @Override
  public List<Village> getAllVillages() {
    final String _sql = "SELECT * FROM Village";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("VillageId");
      final int _cursorIndexOfVillageCode = _cursor.getColumnIndexOrThrow("VillageCode");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("VillageName");
      final int _cursorIndexOfBlock = _cursor.getColumnIndexOrThrow("Block");
      final int _cursorIndexOfDistrict = _cursor.getColumnIndexOrThrow("District");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfCRLId = _cursor.getColumnIndexOrThrow("CRLId");
      final List<Village> _result = new ArrayList<Village>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Village _item;
        _item = new Village();
        _item.VillageId = _cursor.getInt(_cursorIndexOfVillageId);
        _item.VillageCode = _cursor.getString(_cursorIndexOfVillageCode);
        _item.VillageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.Block = _cursor.getString(_cursorIndexOfBlock);
        _item.District = _cursor.getString(_cursorIndexOfDistrict);
        _item.State = _cursor.getString(_cursorIndexOfState);
        _item.CRLId = _cursor.getString(_cursorIndexOfCRLId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getAllStates() {
    final String _sql = "SELECT DISTINCT State FROM Village ORDER BY State ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public List<String> GetStatewiseBlock(String st) {
    final String _sql = "SELECT DISTINCT Block FROM Village WHERE State=? ORDER BY Block ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (st == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, st);
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
  public List<Village> GetVillages(String block) {
    final String _sql = "SELECT * FROM Village WHERE Block=?  ORDER BY VillageName ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (block == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, block);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("VillageId");
      final int _cursorIndexOfVillageCode = _cursor.getColumnIndexOrThrow("VillageCode");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("VillageName");
      final int _cursorIndexOfBlock = _cursor.getColumnIndexOrThrow("Block");
      final int _cursorIndexOfDistrict = _cursor.getColumnIndexOrThrow("District");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfCRLId = _cursor.getColumnIndexOrThrow("CRLId");
      final List<Village> _result = new ArrayList<Village>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Village _item;
        _item = new Village();
        _item.VillageId = _cursor.getInt(_cursorIndexOfVillageId);
        _item.VillageCode = _cursor.getString(_cursorIndexOfVillageCode);
        _item.VillageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.Block = _cursor.getString(_cursorIndexOfBlock);
        _item.District = _cursor.getString(_cursorIndexOfDistrict);
        _item.State = _cursor.getString(_cursorIndexOfState);
        _item.CRLId = _cursor.getString(_cursorIndexOfCRLId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int GetVillageIDByBlock(String block) {
    final String _sql = "select VillageID from Village where Block=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (block == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, block);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
