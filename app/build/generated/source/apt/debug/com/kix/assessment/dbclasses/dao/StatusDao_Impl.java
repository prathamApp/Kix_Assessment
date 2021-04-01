package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Status;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class StatusDao_Impl implements StatusDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Status;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfModal_Status;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfModal_Status;

  private final SharedSQLiteStatement __preparedStmtOfUpdateValue;

  public StatusDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Status = new EntityInsertionAdapter<Modal_Status>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Status`(`statusKey`,`value`,`description`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Status value) {
        if (value.statusKey == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.statusKey);
        }
        if (value.value == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.value);
        }
        if (value.description == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.description);
        }
      }
    };
    this.__deletionAdapterOfModal_Status = new EntityDeletionOrUpdateAdapter<Modal_Status>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Status` WHERE `statusKey` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Status value) {
        if (value.statusKey == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.statusKey);
        }
      }
    };
    this.__updateAdapterOfModal_Status = new EntityDeletionOrUpdateAdapter<Modal_Status>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Status` SET `statusKey` = ?,`value` = ?,`description` = ? WHERE `statusKey` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Status value) {
        if (value.statusKey == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.statusKey);
        }
        if (value.value == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.value);
        }
        if (value.description == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.description);
        }
        if (value.statusKey == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.statusKey);
        }
      }
    };
    this.__preparedStmtOfUpdateValue = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Status set value =? where statusKey =?";
        return _query;
      }
    };
  }

  @Override
  public long insert(Modal_Status status) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfModal_Status.insertAndReturnId(status);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(List<Modal_Status> statuses) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfModal_Status.insertAndReturnIdsArray(statuses);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Modal_Status status) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfModal_Status.handle(status);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(Modal_Status... statuses) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfModal_Status.handleMultiple(statuses);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Modal_Status status) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfModal_Status.handle(status);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateValue(String key, String value) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateValue.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (value == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, value);
      }
      _argIndex = 2;
      if (key == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, key);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateValue.release(_stmt);
    }
  }

  @Override
  public List<Modal_Status> getAllStatuses() {
    final String _sql = "select * from Status";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStatusKey = _cursor.getColumnIndexOrThrow("statusKey");
      final int _cursorIndexOfValue = _cursor.getColumnIndexOrThrow("value");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final List<Modal_Status> _result = new ArrayList<Modal_Status>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Status _item;
        _item = new Modal_Status();
        _item.statusKey = _cursor.getString(_cursorIndexOfStatusKey);
        _item.value = _cursor.getString(_cursorIndexOfValue);
        _item.description = _cursor.getString(_cursorIndexOfDescription);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getKey(String key) {
    final String _sql = "Select statusKey from Status where statusKey = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
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
  public String getValue(String key) {
    final String _sql = "Select value from Status where statusKey = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
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
