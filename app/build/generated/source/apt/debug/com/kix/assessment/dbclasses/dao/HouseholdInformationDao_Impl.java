package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_HIF;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class HouseholdInformationDao_Impl implements HouseholdInformationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_HIF;

  private final SharedSQLiteStatement __preparedStmtOfUpdateHousehold;

  public HouseholdInformationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_HIF = new EntityInsertionAdapter<Modal_HIF>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `HouseholdInformation`(`hif_Id`,`HH07a`,`HH07b`,`HH07c`,`HH07cOther`,`HH07d`,`HH07dOther`,`HH07e`,`HH07f`,`HH07g`,`HH07h`,`HH07i`,`HH07j`,`HH07k`,`HH07l`,`HH07m`,`HH07n`,`HH07o`,`HH07p`,`householdId`,`villageId`,`createdOn`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_HIF value) {
        stmt.bindLong(1, value.hif_Id);
        if (value.HH07a == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.HH07a);
        }
        if (value.HH07b == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.HH07b);
        }
        if (value.HH07c == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.HH07c);
        }
        if (value.HH07cOther == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.HH07cOther);
        }
        if (value.HH07d == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.HH07d);
        }
        if (value.HH07dOther == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.HH07dOther);
        }
        if (value.HH07e == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.HH07e);
        }
        if (value.HH07f == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.HH07f);
        }
        if (value.HH07g == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.HH07g);
        }
        if (value.HH07h == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.HH07h);
        }
        if (value.HH07i == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.HH07i);
        }
        if (value.HH07j == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.HH07j);
        }
        if (value.HH07k == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.HH07k);
        }
        if (value.HH07l == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.HH07l);
        }
        if (value.HH07m == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.HH07m);
        }
        if (value.HH07n == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.HH07n);
        }
        if (value.HH07o == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.HH07o);
        }
        if (value.HH07p == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.HH07p);
        }
        if (value.householdId == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.householdId);
        }
        if (value.villageId == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.villageId);
        }
        if (value.createdOn == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.createdOn);
        }
        stmt.bindLong(23, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateHousehold = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update HouseholdInformation set HH07a=?, HH07b=?, HH07c=?, HH07cOther=?, HH07d=?, HH07dOther=?, HH07e=?, HH07f=?, HH07g=?, HH07h=?, HH07i=?, HH07j=?, HH07k=?, HH07l=?, HH07m=?, HH07n=?, HH07o=?, HH07p=?, sentFlag=0 where householdId=?";
        return _query;
      }
    };
  }

  @Override
  public void insertHouseholdInfo(Modal_HIF modal_hif) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_HIF.insert(modal_hif);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateHousehold(String HH07a, String HH07b, String HH07c, String HH07cOther,
      String HH07d, String HH07dOther, String HH07e, String HH07f, String HH07g, String HH07h,
      String HH07i, String HH07j, String HH07k, String HH07l, String HH07m, String HH07n,
      String HH07o, String HH07p, String householdId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateHousehold.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (HH07a == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07a);
      }
      _argIndex = 2;
      if (HH07b == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07b);
      }
      _argIndex = 3;
      if (HH07c == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07c);
      }
      _argIndex = 4;
      if (HH07cOther == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07cOther);
      }
      _argIndex = 5;
      if (HH07d == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07d);
      }
      _argIndex = 6;
      if (HH07dOther == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07dOther);
      }
      _argIndex = 7;
      if (HH07e == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07e);
      }
      _argIndex = 8;
      if (HH07f == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07f);
      }
      _argIndex = 9;
      if (HH07g == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07g);
      }
      _argIndex = 10;
      if (HH07h == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07h);
      }
      _argIndex = 11;
      if (HH07i == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07i);
      }
      _argIndex = 12;
      if (HH07j == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07j);
      }
      _argIndex = 13;
      if (HH07k == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07k);
      }
      _argIndex = 14;
      if (HH07l == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07l);
      }
      _argIndex = 15;
      if (HH07m == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07m);
      }
      _argIndex = 16;
      if (HH07n == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07n);
      }
      _argIndex = 17;
      if (HH07o == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07o);
      }
      _argIndex = 18;
      if (HH07p == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, HH07p);
      }
      _argIndex = 19;
      if (householdId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, householdId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateHousehold.release(_stmt);
    }
  }

  @Override
  public List<Modal_HIF> getAllNewHIF() {
    final String _sql = "select * from HouseholdInformation where sentFlag = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHifId = _cursor.getColumnIndexOrThrow("hif_Id");
      final int _cursorIndexOfHH07a = _cursor.getColumnIndexOrThrow("HH07a");
      final int _cursorIndexOfHH07b = _cursor.getColumnIndexOrThrow("HH07b");
      final int _cursorIndexOfHH07c = _cursor.getColumnIndexOrThrow("HH07c");
      final int _cursorIndexOfHH07cOther = _cursor.getColumnIndexOrThrow("HH07cOther");
      final int _cursorIndexOfHH07d = _cursor.getColumnIndexOrThrow("HH07d");
      final int _cursorIndexOfHH07dOther = _cursor.getColumnIndexOrThrow("HH07dOther");
      final int _cursorIndexOfHH07e = _cursor.getColumnIndexOrThrow("HH07e");
      final int _cursorIndexOfHH07f = _cursor.getColumnIndexOrThrow("HH07f");
      final int _cursorIndexOfHH07g = _cursor.getColumnIndexOrThrow("HH07g");
      final int _cursorIndexOfHH07h = _cursor.getColumnIndexOrThrow("HH07h");
      final int _cursorIndexOfHH07i = _cursor.getColumnIndexOrThrow("HH07i");
      final int _cursorIndexOfHH07j = _cursor.getColumnIndexOrThrow("HH07j");
      final int _cursorIndexOfHH07k = _cursor.getColumnIndexOrThrow("HH07k");
      final int _cursorIndexOfHH07l = _cursor.getColumnIndexOrThrow("HH07l");
      final int _cursorIndexOfHH07m = _cursor.getColumnIndexOrThrow("HH07m");
      final int _cursorIndexOfHH07n = _cursor.getColumnIndexOrThrow("HH07n");
      final int _cursorIndexOfHH07o = _cursor.getColumnIndexOrThrow("HH07o");
      final int _cursorIndexOfHH07p = _cursor.getColumnIndexOrThrow("HH07p");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_HIF> _result = new ArrayList<Modal_HIF>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_HIF _item;
        _item = new Modal_HIF();
        _item.hif_Id = _cursor.getInt(_cursorIndexOfHifId);
        _item.HH07a = _cursor.getString(_cursorIndexOfHH07a);
        _item.HH07b = _cursor.getString(_cursorIndexOfHH07b);
        _item.HH07c = _cursor.getString(_cursorIndexOfHH07c);
        _item.HH07cOther = _cursor.getString(_cursorIndexOfHH07cOther);
        _item.HH07d = _cursor.getString(_cursorIndexOfHH07d);
        _item.HH07dOther = _cursor.getString(_cursorIndexOfHH07dOther);
        _item.HH07e = _cursor.getString(_cursorIndexOfHH07e);
        _item.HH07f = _cursor.getString(_cursorIndexOfHH07f);
        _item.HH07g = _cursor.getString(_cursorIndexOfHH07g);
        _item.HH07h = _cursor.getString(_cursorIndexOfHH07h);
        _item.HH07i = _cursor.getString(_cursorIndexOfHH07i);
        _item.HH07j = _cursor.getString(_cursorIndexOfHH07j);
        _item.HH07k = _cursor.getString(_cursorIndexOfHH07k);
        _item.HH07l = _cursor.getString(_cursorIndexOfHH07l);
        _item.HH07m = _cursor.getString(_cursorIndexOfHH07m);
        _item.HH07n = _cursor.getString(_cursorIndexOfHH07n);
        _item.HH07o = _cursor.getString(_cursorIndexOfHH07o);
        _item.HH07p = _cursor.getString(_cursorIndexOfHH07p);
        _item.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _item.villageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.createdOn = _cursor.getString(_cursorIndexOfCreatedOn);
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
  public Modal_HIF getHIFbyHouseholdId(String householdId) {
    final String _sql = "Select * from HouseholdInformation where householdId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (householdId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, householdId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfHifId = _cursor.getColumnIndexOrThrow("hif_Id");
      final int _cursorIndexOfHH07a = _cursor.getColumnIndexOrThrow("HH07a");
      final int _cursorIndexOfHH07b = _cursor.getColumnIndexOrThrow("HH07b");
      final int _cursorIndexOfHH07c = _cursor.getColumnIndexOrThrow("HH07c");
      final int _cursorIndexOfHH07cOther = _cursor.getColumnIndexOrThrow("HH07cOther");
      final int _cursorIndexOfHH07d = _cursor.getColumnIndexOrThrow("HH07d");
      final int _cursorIndexOfHH07dOther = _cursor.getColumnIndexOrThrow("HH07dOther");
      final int _cursorIndexOfHH07e = _cursor.getColumnIndexOrThrow("HH07e");
      final int _cursorIndexOfHH07f = _cursor.getColumnIndexOrThrow("HH07f");
      final int _cursorIndexOfHH07g = _cursor.getColumnIndexOrThrow("HH07g");
      final int _cursorIndexOfHH07h = _cursor.getColumnIndexOrThrow("HH07h");
      final int _cursorIndexOfHH07i = _cursor.getColumnIndexOrThrow("HH07i");
      final int _cursorIndexOfHH07j = _cursor.getColumnIndexOrThrow("HH07j");
      final int _cursorIndexOfHH07k = _cursor.getColumnIndexOrThrow("HH07k");
      final int _cursorIndexOfHH07l = _cursor.getColumnIndexOrThrow("HH07l");
      final int _cursorIndexOfHH07m = _cursor.getColumnIndexOrThrow("HH07m");
      final int _cursorIndexOfHH07n = _cursor.getColumnIndexOrThrow("HH07n");
      final int _cursorIndexOfHH07o = _cursor.getColumnIndexOrThrow("HH07o");
      final int _cursorIndexOfHH07p = _cursor.getColumnIndexOrThrow("HH07p");
      final int _cursorIndexOfHouseholdId = _cursor.getColumnIndexOrThrow("householdId");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("villageId");
      final int _cursorIndexOfCreatedOn = _cursor.getColumnIndexOrThrow("createdOn");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_HIF _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_HIF();
        _result.hif_Id = _cursor.getInt(_cursorIndexOfHifId);
        _result.HH07a = _cursor.getString(_cursorIndexOfHH07a);
        _result.HH07b = _cursor.getString(_cursorIndexOfHH07b);
        _result.HH07c = _cursor.getString(_cursorIndexOfHH07c);
        _result.HH07cOther = _cursor.getString(_cursorIndexOfHH07cOther);
        _result.HH07d = _cursor.getString(_cursorIndexOfHH07d);
        _result.HH07dOther = _cursor.getString(_cursorIndexOfHH07dOther);
        _result.HH07e = _cursor.getString(_cursorIndexOfHH07e);
        _result.HH07f = _cursor.getString(_cursorIndexOfHH07f);
        _result.HH07g = _cursor.getString(_cursorIndexOfHH07g);
        _result.HH07h = _cursor.getString(_cursorIndexOfHH07h);
        _result.HH07i = _cursor.getString(_cursorIndexOfHH07i);
        _result.HH07j = _cursor.getString(_cursorIndexOfHH07j);
        _result.HH07k = _cursor.getString(_cursorIndexOfHH07k);
        _result.HH07l = _cursor.getString(_cursorIndexOfHH07l);
        _result.HH07m = _cursor.getString(_cursorIndexOfHH07m);
        _result.HH07n = _cursor.getString(_cursorIndexOfHH07n);
        _result.HH07o = _cursor.getString(_cursorIndexOfHH07o);
        _result.HH07p = _cursor.getString(_cursorIndexOfHH07p);
        _result.householdId = _cursor.getString(_cursorIndexOfHouseholdId);
        _result.villageId = _cursor.getString(_cursorIndexOfVillageId);
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
