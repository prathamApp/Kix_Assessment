package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_VIF;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class VillageInformationDao_Impl implements VillageInformationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_VIF;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateVillage;

  public VillageInformationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_VIF = new EntityInsertionAdapter<Modal_VIF>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `VillageInformartion`(`vif_Id`,`V01`,`V02`,`V03`,`V04`,`V05`,`V06a`,`V06b`,`V07a`,`V07b`,`villageId`,`svrCode`,`sentFlag`,`info_createdOn`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_VIF value) {
        stmt.bindLong(1, value.vif_Id);
        if (value.V01 == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.V01);
        }
        if (value.V02 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.V02);
        }
        if (value.V03 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.V03);
        }
        if (value.V04 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.V04);
        }
        if (value.V05 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.V05);
        }
        if (value.V06a == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.V06a);
        }
        if (value.V06b == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.V06b);
        }
        if (value.V07a == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.V07a);
        }
        if (value.V07b == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.V07b);
        }
        if (value.villageId == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.villageId);
        }
        if (value.svrCode == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.svrCode);
        }
        stmt.bindLong(13, value.sentFlag);
        if (value.info_createdOn == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.info_createdOn);
        }
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update VillageInformartion set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateVillage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update VillageInformartion set V01=?, V02=?, V03=?, V04=?, V05=?, V06a=?, V06b=?, V07a=?, V07b=?, sentFlag=0 where villageId=?";
        return _query;
      }
    };
  }

  @Override
  public void insertVillageInfo(Modal_VIF modal_vif) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_VIF.insert(modal_vif);
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
  public void updateVillage(String v01, String v02, String v03, String v04, String v05, String v06a,
      String v06b, String v07a, String v07b, String villageId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateVillage.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (v01 == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v01);
      }
      _argIndex = 2;
      if (v02 == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v02);
      }
      _argIndex = 3;
      if (v03 == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v03);
      }
      _argIndex = 4;
      if (v04 == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v04);
      }
      _argIndex = 5;
      if (v05 == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v05);
      }
      _argIndex = 6;
      if (v06a == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v06a);
      }
      _argIndex = 7;
      if (v06b == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v06b);
      }
      _argIndex = 8;
      if (v07a == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v07a);
      }
      _argIndex = 9;
      if (v07b == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, v07b);
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
      __preparedStmtOfUpdateVillage.release(_stmt);
    }
  }

  @Override
  public List<Modal_VIF> getAllNewVIF() {
    final String _sql = "Select * from VillageInformartion where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVifId = _cursor.getColumnIndexOrThrow("vif_Id");
      final int _cursorIndexOfV01 = _cursor.getColumnIndexOrThrow("V01");
      final int _cursorIndexOfV02 = _cursor.getColumnIndexOrThrow("V02");
      final int _cursorIndexOfV03 = _cursor.getColumnIndexOrThrow("V03");
      final int _cursorIndexOfV04 = _cursor.getColumnIndexOrThrow("V04");
      final int _cursorIndexOfV05 = _cursor.getColumnIndexOrThrow("V05");
      final int _cursorIndexOfV06a = _cursor.getColumnIndexOrThrow("V06a");
      final int _cursorIndexOfV06b = _cursor.getColumnIndexOrThrow("V06b");
      final int _cursorIndexOfV07a = _cursor.getColumnIndexOrThrow("V07a");
      final int _cursorIndexOfV07b = _cursor.getColumnIndexOrThrow("V07b");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfInfoCreatedOn = _cursor.getColumnIndexOrThrow("info_createdOn");
      final List<Modal_VIF> _result = new ArrayList<Modal_VIF>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_VIF _item;
        _item = new Modal_VIF();
        _item.vif_Id = _cursor.getInt(_cursorIndexOfVifId);
        _item.V01 = _cursor.getString(_cursorIndexOfV01);
        _item.V02 = _cursor.getString(_cursorIndexOfV02);
        _item.V03 = _cursor.getString(_cursorIndexOfV03);
        _item.V04 = _cursor.getString(_cursorIndexOfV04);
        _item.V05 = _cursor.getString(_cursorIndexOfV05);
        _item.V06a = _cursor.getString(_cursorIndexOfV06a);
        _item.V06b = _cursor.getString(_cursorIndexOfV06b);
        _item.V07a = _cursor.getString(_cursorIndexOfV07a);
        _item.V07b = _cursor.getString(_cursorIndexOfV07b);
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.info_createdOn = _cursor.getString(_cursorIndexOfInfoCreatedOn);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Modal_VIF getVIFbyVillageId(String villageId) {
    final String _sql = "Select * from VillageInformartion where villageId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (villageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, villageId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfVifId = _cursor.getColumnIndexOrThrow("vif_Id");
      final int _cursorIndexOfV01 = _cursor.getColumnIndexOrThrow("V01");
      final int _cursorIndexOfV02 = _cursor.getColumnIndexOrThrow("V02");
      final int _cursorIndexOfV03 = _cursor.getColumnIndexOrThrow("V03");
      final int _cursorIndexOfV04 = _cursor.getColumnIndexOrThrow("V04");
      final int _cursorIndexOfV05 = _cursor.getColumnIndexOrThrow("V05");
      final int _cursorIndexOfV06a = _cursor.getColumnIndexOrThrow("V06a");
      final int _cursorIndexOfV06b = _cursor.getColumnIndexOrThrow("V06b");
      final int _cursorIndexOfV07a = _cursor.getColumnIndexOrThrow("V07a");
      final int _cursorIndexOfV07b = _cursor.getColumnIndexOrThrow("V07b");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfInfoCreatedOn = _cursor.getColumnIndexOrThrow("info_createdOn");
      final Modal_VIF _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_VIF();
        _result.vif_Id = _cursor.getInt(_cursorIndexOfVifId);
        _result.V01 = _cursor.getString(_cursorIndexOfV01);
        _result.V02 = _cursor.getString(_cursorIndexOfV02);
        _result.V03 = _cursor.getString(_cursorIndexOfV03);
        _result.V04 = _cursor.getString(_cursorIndexOfV04);
        _result.V05 = _cursor.getString(_cursorIndexOfV05);
        _result.V06a = _cursor.getString(_cursorIndexOfV06a);
        _result.V06b = _cursor.getString(_cursorIndexOfV06b);
        _result.V07a = _cursor.getString(_cursorIndexOfV07a);
        _result.V07b = _cursor.getString(_cursorIndexOfV07b);
        _result.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _result.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.info_createdOn = _cursor.getString(_cursorIndexOfInfoCreatedOn);
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
  public boolean getVIF(String villId) {
    final String _sql = "select COUNT(*) from VillageInformartion where villageId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (villId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, villId);
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
}
