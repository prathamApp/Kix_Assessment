package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Session;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class SessionDao_Impl implements SessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Session;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfModal_Session;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAllFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateToDate;

  public SessionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Session = new EntityInsertionAdapter<Modal_Session>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Session`(`sessionId`,`fromDate`,`toDate`,`sentFlag`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Session value) {
        if (value.sessionId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.sessionId);
        }
        if (value.fromDate == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.fromDate);
        }
        if (value.toDate == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.toDate);
        }
        stmt.bindLong(4, value.sentFlag);
      }
    };
    this.__deletionAdapterOfModal_Session = new EntityDeletionOrUpdateAdapter<Modal_Session>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Session` WHERE `sessionId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Session value) {
        if (value.sessionId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.sessionId);
        }
      }
    };
    this.__preparedStmtOfUpdateFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Session SET sentFlag = 1 where sessionId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAllFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Session SET sentFlag = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateToDate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Session SET toDate = ? where sessionId = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(Modal_Session session) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfModal_Session.insertAndReturnId(session);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<Modal_Session> sessions) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Session.insert(sessions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Modal_Session session) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfModal_Session.handle(session);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(Modal_Session... sessions) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfModal_Session.handleMultiple(sessions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateFlag(String s_id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFlag.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (s_id == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, s_id);
      }
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFlag.release(_stmt);
    }
  }

  @Override
  public int updateAllFlag() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAllFlag.acquire();
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAllFlag.release(_stmt);
    }
  }

  @Override
  public void UpdateToDate(String SessionID, String toDate) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateToDate.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (toDate == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, toDate);
      }
      _argIndex = 2;
      if (SessionID == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, SessionID);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateToDate.release(_stmt);
    }
  }

  @Override
  public List<Modal_Session> getAllNewSessions() {
    final String _sql = "select * from Session where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfFromDate = _cursor.getColumnIndexOrThrow("fromDate");
      final int _cursorIndexOfToDate = _cursor.getColumnIndexOrThrow("toDate");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Session> _result = new ArrayList<Modal_Session>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Session _item;
        _item = new Modal_Session();
        _item.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.fromDate = _cursor.getString(_cursorIndexOfFromDate);
        _item.toDate = _cursor.getString(_cursorIndexOfToDate);
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
  public Modal_Session getSession(String SessionID) {
    final String _sql = "select * from Session where sessionId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (SessionID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, SessionID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfFromDate = _cursor.getColumnIndexOrThrow("fromDate");
      final int _cursorIndexOfToDate = _cursor.getColumnIndexOrThrow("toDate");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Session _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Session();
        _result.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _result.fromDate = _cursor.getString(_cursorIndexOfFromDate);
        _result.toDate = _cursor.getString(_cursorIndexOfToDate);
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
