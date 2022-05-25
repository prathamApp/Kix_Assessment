package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Village;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class VillageDao_Impl implements VillageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Village;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateVillage;

  public VillageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Village = new EntityInsertionAdapter<Modal_Village>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Village`(`villageId`,`villageName`,`villageDistrict`,`villageState`,`villageDate`,`countryName`,`villageBooklet`,`svrCode`,`sentFlag`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Village value) {
        if (value.villageId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.villageId);
        }
        if (value.villageName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.villageName);
        }
        if (value.villageDistrict == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.villageDistrict);
        }
        if (value.villageState == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.villageState);
        }
        if (value.villageDate == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.villageDate);
        }
        if (value.countryName == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.countryName);
        }
        if (value.villageBooklet == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.villageBooklet);
        }
        if (value.svrCode == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.svrCode);
        }
        stmt.bindLong(9, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Village set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateVillage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Village set villageName=?, villageDistrict=?, villageState=?, sentFlag=0, countryName=?, villageBooklet=? where villageId=?";
        return _query;
      }
    };
  }

  @Override
  public void insertVillage(Modal_Village modal_village) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Village.insert(modal_village);
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
  public void updateVillage(String vName, String vDistrict, String vState, String vId,
      String countryName, String booklet) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateVillage.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (vName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, vName);
      }
      _argIndex = 2;
      if (vDistrict == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, vDistrict);
      }
      _argIndex = 3;
      if (vState == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, vState);
      }
      _argIndex = 4;
      if (countryName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, countryName);
      }
      _argIndex = 5;
      if (booklet == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, booklet);
      }
      _argIndex = 6;
      if (vId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, vId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateVillage.release(_stmt);
    }
  }

  @Override
  public Modal_Village getVillageBySurveyorCode(String svrCode) {
    final String _sql = "SELECT * FROM Village WHERE svrCode=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfVillageDistrict = _cursor.getColumnIndexOrThrow("villageDistrict");
      final int _cursorIndexOfVillageState = _cursor.getColumnIndexOrThrow("villageState");
      final int _cursorIndexOfVillageDate = _cursor.getColumnIndexOrThrow("villageDate");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfVillageBooklet = _cursor.getColumnIndexOrThrow("villageBooklet");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Village _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Village();
        _result.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _result.villageName = _cursor.getString(_cursorIndexOfVillageName);
        _result.villageDistrict = _cursor.getString(_cursorIndexOfVillageDistrict);
        _result.villageState = _cursor.getString(_cursorIndexOfVillageState);
        _result.villageDate = _cursor.getString(_cursorIndexOfVillageDate);
        _result.countryName = _cursor.getString(_cursorIndexOfCountryName);
        _result.villageBooklet = _cursor.getString(_cursorIndexOfVillageBooklet);
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
  public List<Modal_Village> getAllVillageBySurveyorCode(String svrCode) {
    final String _sql = "SELECT * FROM Village WHERE svrCode=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfVillageDistrict = _cursor.getColumnIndexOrThrow("villageDistrict");
      final int _cursorIndexOfVillageState = _cursor.getColumnIndexOrThrow("villageState");
      final int _cursorIndexOfVillageDate = _cursor.getColumnIndexOrThrow("villageDate");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfVillageBooklet = _cursor.getColumnIndexOrThrow("villageBooklet");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Village> _result = new ArrayList<Modal_Village>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Village _item;
        _item = new Modal_Village();
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.villageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.villageDistrict = _cursor.getString(_cursorIndexOfVillageDistrict);
        _item.villageState = _cursor.getString(_cursorIndexOfVillageState);
        _item.villageDate = _cursor.getString(_cursorIndexOfVillageDate);
        _item.countryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.villageBooklet = _cursor.getString(_cursorIndexOfVillageBooklet);
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
  public List<Modal_Village> getAllVillageBySurveyorCodeDescending(String svrCode) {
    final String _sql = "SELECT * FROM Village WHERE svrCode=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfVillageDistrict = _cursor.getColumnIndexOrThrow("villageDistrict");
      final int _cursorIndexOfVillageState = _cursor.getColumnIndexOrThrow("villageState");
      final int _cursorIndexOfVillageDate = _cursor.getColumnIndexOrThrow("villageDate");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfVillageBooklet = _cursor.getColumnIndexOrThrow("villageBooklet");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Village> _result = new ArrayList<Modal_Village>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Village _item;
        _item = new Modal_Village();
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.villageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.villageDistrict = _cursor.getString(_cursorIndexOfVillageDistrict);
        _item.villageState = _cursor.getString(_cursorIndexOfVillageState);
        _item.villageDate = _cursor.getString(_cursorIndexOfVillageDate);
        _item.countryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.villageBooklet = _cursor.getString(_cursorIndexOfVillageBooklet);
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
  public List<Modal_Village> getAllNewVillages() {
    final String _sql = "select * from Village where sentFlag = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfVillageDistrict = _cursor.getColumnIndexOrThrow("villageDistrict");
      final int _cursorIndexOfVillageState = _cursor.getColumnIndexOrThrow("villageState");
      final int _cursorIndexOfVillageDate = _cursor.getColumnIndexOrThrow("villageDate");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfVillageBooklet = _cursor.getColumnIndexOrThrow("villageBooklet");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Village> _result = new ArrayList<Modal_Village>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Village _item;
        _item = new Modal_Village();
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.villageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.villageDistrict = _cursor.getString(_cursorIndexOfVillageDistrict);
        _item.villageState = _cursor.getString(_cursorIndexOfVillageState);
        _item.villageDate = _cursor.getString(_cursorIndexOfVillageDate);
        _item.countryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.villageBooklet = _cursor.getString(_cursorIndexOfVillageBooklet);
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
  public List<String> getAllVillageNameBySurveyorCode(String svrCode) {
    final String _sql = "SELECT VillageName FROM Village WHERE svrCode=?";
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
  public Modal_Village getVillageByVillId(String villageId) {
    final String _sql = "SELECT * FROM Village WHERE villageId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (villageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, villageId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfVillageDistrict = _cursor.getColumnIndexOrThrow("villageDistrict");
      final int _cursorIndexOfVillageState = _cursor.getColumnIndexOrThrow("villageState");
      final int _cursorIndexOfVillageDate = _cursor.getColumnIndexOrThrow("villageDate");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfVillageBooklet = _cursor.getColumnIndexOrThrow("villageBooklet");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Village _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Village();
        _result.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _result.villageName = _cursor.getString(_cursorIndexOfVillageName);
        _result.villageDistrict = _cursor.getString(_cursorIndexOfVillageDistrict);
        _result.villageState = _cursor.getString(_cursorIndexOfVillageState);
        _result.villageDate = _cursor.getString(_cursorIndexOfVillageDate);
        _result.countryName = _cursor.getString(_cursorIndexOfCountryName);
        _result.villageBooklet = _cursor.getString(_cursorIndexOfVillageBooklet);
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
