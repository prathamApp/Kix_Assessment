package com.kix.assessment.dbclasses.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_VIF;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class VillageInformationDao_Impl implements VillageInformationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_VIF;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  public VillageInformationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_VIF = new EntityInsertionAdapter<Modal_VIF>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `VillageInformartion`(`vif_Id`,`V01`,`V02`,`V03`,`V04`,`V05`,`V06a`,`V06b`,`V07a`,`V07b`,`villageId`,`svrCode`,`sentFlag`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_VIF value) {
        if (value.vif_Id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.vif_Id);
        }
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
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update VillageInformartion set sentFlag=1 where sentFlag=0";
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
}
