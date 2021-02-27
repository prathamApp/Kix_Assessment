package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Modal_Log;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class LogDao_Impl implements LogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Log;

  private final SharedSQLiteStatement __preparedStmtOfDeleteLogs;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfDeletePushedLogs;

  public LogDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Log = new EntityInsertionAdapter<Modal_Log>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Logs`(`logId`,`currentDateTime`,`exceptionMessage`,`exceptionStackTrace`,`methodName`,`errorType`,`groupId`,`deviceId`,`LogDetail`,`sentFlag`,`sessionId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Log value) {
        stmt.bindLong(1, value.logId);
        if (value.currentDateTime == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.currentDateTime);
        }
        if (value.exceptionMessage == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.exceptionMessage);
        }
        if (value.exceptionStackTrace == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.exceptionStackTrace);
        }
        if (value.methodName == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.methodName);
        }
        if (value.errorType == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.errorType);
        }
        if (value.groupId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.groupId);
        }
        if (value.deviceId == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.deviceId);
        }
        if (value.LogDetail == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.LogDetail);
        }
        stmt.bindLong(10, value.sentFlag);
        if (value.sessionId == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.sessionId);
        }
      }
    };
    this.__preparedStmtOfDeleteLogs = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Logs";
        return _query;
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Logs set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePushedLogs = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from Logs where sentFlag = 1";
        return _query;
      }
    };
  }

  @Override
  public void insertLog(Modal_Log log) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Log.insert(log);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAllLogs(List<Modal_Log> log) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Log.insert(log);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteLogs() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteLogs.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteLogs.release(_stmt);
    }
  }

  @Override
  public void setSentFlag() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetSentFlag.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetSentFlag.release(_stmt);
    }
  }

  @Override
  public void deletePushedLogs() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePushedLogs.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePushedLogs.release(_stmt);
    }
  }

  @Override
  public List<Modal_Log> getAllLogs() {
    final String _sql = "select * from Logs";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfLogId = _cursor.getColumnIndexOrThrow("logId");
      final int _cursorIndexOfCurrentDateTime = _cursor.getColumnIndexOrThrow("currentDateTime");
      final int _cursorIndexOfExceptionMessage = _cursor.getColumnIndexOrThrow("exceptionMessage");
      final int _cursorIndexOfExceptionStackTrace = _cursor.getColumnIndexOrThrow("exceptionStackTrace");
      final int _cursorIndexOfMethodName = _cursor.getColumnIndexOrThrow("methodName");
      final int _cursorIndexOfErrorType = _cursor.getColumnIndexOrThrow("errorType");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("groupId");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("deviceId");
      final int _cursorIndexOfLogDetail = _cursor.getColumnIndexOrThrow("LogDetail");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final List<Modal_Log> _result = new ArrayList<Modal_Log>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Log _item;
        _item = new Modal_Log();
        _item.logId = _cursor.getInt(_cursorIndexOfLogId);
        _item.currentDateTime = _cursor.getString(_cursorIndexOfCurrentDateTime);
        _item.exceptionMessage = _cursor.getString(_cursorIndexOfExceptionMessage);
        _item.exceptionStackTrace = _cursor.getString(_cursorIndexOfExceptionStackTrace);
        _item.methodName = _cursor.getString(_cursorIndexOfMethodName);
        _item.errorType = _cursor.getString(_cursorIndexOfErrorType);
        _item.groupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.deviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.LogDetail = _cursor.getString(_cursorIndexOfLogDetail);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_Log> getPushAllLogs() {
    final String _sql = "select * from Logs where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfLogId = _cursor.getColumnIndexOrThrow("logId");
      final int _cursorIndexOfCurrentDateTime = _cursor.getColumnIndexOrThrow("currentDateTime");
      final int _cursorIndexOfExceptionMessage = _cursor.getColumnIndexOrThrow("exceptionMessage");
      final int _cursorIndexOfExceptionStackTrace = _cursor.getColumnIndexOrThrow("exceptionStackTrace");
      final int _cursorIndexOfMethodName = _cursor.getColumnIndexOrThrow("methodName");
      final int _cursorIndexOfErrorType = _cursor.getColumnIndexOrThrow("errorType");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("groupId");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("deviceId");
      final int _cursorIndexOfLogDetail = _cursor.getColumnIndexOrThrow("LogDetail");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final List<Modal_Log> _result = new ArrayList<Modal_Log>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Log _item;
        _item = new Modal_Log();
        _item.logId = _cursor.getInt(_cursorIndexOfLogId);
        _item.currentDateTime = _cursor.getString(_cursorIndexOfCurrentDateTime);
        _item.exceptionMessage = _cursor.getString(_cursorIndexOfExceptionMessage);
        _item.exceptionStackTrace = _cursor.getString(_cursorIndexOfExceptionStackTrace);
        _item.methodName = _cursor.getString(_cursorIndexOfMethodName);
        _item.errorType = _cursor.getString(_cursorIndexOfErrorType);
        _item.groupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.deviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.LogDetail = _cursor.getString(_cursorIndexOfLogDetail);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_Log> getAllLogs(String s_id) {
    final String _sql = "select * from Logs where sentFlag=0 AND sessionId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (s_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s_id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfLogId = _cursor.getColumnIndexOrThrow("logId");
      final int _cursorIndexOfCurrentDateTime = _cursor.getColumnIndexOrThrow("currentDateTime");
      final int _cursorIndexOfExceptionMessage = _cursor.getColumnIndexOrThrow("exceptionMessage");
      final int _cursorIndexOfExceptionStackTrace = _cursor.getColumnIndexOrThrow("exceptionStackTrace");
      final int _cursorIndexOfMethodName = _cursor.getColumnIndexOrThrow("methodName");
      final int _cursorIndexOfErrorType = _cursor.getColumnIndexOrThrow("errorType");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("groupId");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("deviceId");
      final int _cursorIndexOfLogDetail = _cursor.getColumnIndexOrThrow("LogDetail");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final List<Modal_Log> _result = new ArrayList<Modal_Log>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Log _item;
        _item = new Modal_Log();
        _item.logId = _cursor.getInt(_cursorIndexOfLogId);
        _item.currentDateTime = _cursor.getString(_cursorIndexOfCurrentDateTime);
        _item.exceptionMessage = _cursor.getString(_cursorIndexOfExceptionMessage);
        _item.exceptionStackTrace = _cursor.getString(_cursorIndexOfExceptionStackTrace);
        _item.methodName = _cursor.getString(_cursorIndexOfMethodName);
        _item.errorType = _cursor.getString(_cursorIndexOfErrorType);
        _item.groupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.deviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.LogDetail = _cursor.getString(_cursorIndexOfLogDetail);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
