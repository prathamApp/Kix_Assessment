package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.SupervisorData;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class SupervisorDataDao_Impl implements SupervisorDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSupervisorData;

  private final EntityInsertionAdapter __insertionAdapterOfSupervisorData_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSupervisorData;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfDeletePushedSupervisorData;

  public SupervisorDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSupervisorData = new EntityInsertionAdapter<SupervisorData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `SupervisorData`(`sId`,`supervisorId`,`assessmentSessionId`,`supervisorName`,`supervisorPhoto`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SupervisorData value) {
        stmt.bindLong(1, value.sId);
        if (value.supervisorId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.supervisorId);
        }
        if (value.assessmentSessionId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.assessmentSessionId);
        }
        if (value.supervisorName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.supervisorName);
        }
        if (value.supervisorPhoto == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.supervisorPhoto);
        }
        stmt.bindLong(6, value.getSentFlag());
      }
    };
    this.__insertionAdapterOfSupervisorData_1 = new EntityInsertionAdapter<SupervisorData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `SupervisorData`(`sId`,`supervisorId`,`assessmentSessionId`,`supervisorName`,`supervisorPhoto`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SupervisorData value) {
        stmt.bindLong(1, value.sId);
        if (value.supervisorId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.supervisorId);
        }
        if (value.assessmentSessionId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.assessmentSessionId);
        }
        if (value.supervisorName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.supervisorName);
        }
        if (value.supervisorPhoto == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.supervisorPhoto);
        }
        stmt.bindLong(6, value.getSentFlag());
      }
    };
    this.__preparedStmtOfDeleteAllSupervisorData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM SupervisorData";
        return _query;
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update SupervisorData set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePushedSupervisorData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from SupervisorData where sentFlag = 1";
        return _query;
      }
    };
  }

  @Override
  public long insert(SupervisorData supervisorData) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSupervisorData.insertAndReturnId(supervisorData);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<SupervisorData> supervisorDataList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSupervisorData_1.insert(supervisorDataList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllSupervisorData() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSupervisorData.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllSupervisorData.release(_stmt);
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
  public void deletePushedSupervisorData() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePushedSupervisorData.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePushedSupervisorData.release(_stmt);
    }
  }

  @Override
  public List<SupervisorData> getAllSupervisorData() {
    final String _sql = "SELECT * FROM SupervisorData where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfSupervisorId = _cursor.getColumnIndexOrThrow("supervisorId");
      final int _cursorIndexOfAssessmentSessionId = _cursor.getColumnIndexOrThrow("assessmentSessionId");
      final int _cursorIndexOfSupervisorName = _cursor.getColumnIndexOrThrow("supervisorName");
      final int _cursorIndexOfSupervisorPhoto = _cursor.getColumnIndexOrThrow("supervisorPhoto");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<SupervisorData> _result = new ArrayList<SupervisorData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SupervisorData _item;
        _item = new SupervisorData();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.supervisorId = _cursor.getString(_cursorIndexOfSupervisorId);
        _item.assessmentSessionId = _cursor.getString(_cursorIndexOfAssessmentSessionId);
        _item.supervisorName = _cursor.getString(_cursorIndexOfSupervisorName);
        _item.supervisorPhoto = _cursor.getString(_cursorIndexOfSupervisorPhoto);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SupervisorData getSupervisorById(String supervisorId) {
    final String _sql = "SELECT * FROM SupervisorData where supervisorId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (supervisorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, supervisorId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfSupervisorId = _cursor.getColumnIndexOrThrow("supervisorId");
      final int _cursorIndexOfAssessmentSessionId = _cursor.getColumnIndexOrThrow("assessmentSessionId");
      final int _cursorIndexOfSupervisorName = _cursor.getColumnIndexOrThrow("supervisorName");
      final int _cursorIndexOfSupervisorPhoto = _cursor.getColumnIndexOrThrow("supervisorPhoto");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final SupervisorData _result;
      if(_cursor.moveToFirst()) {
        _result = new SupervisorData();
        _result.sId = _cursor.getInt(_cursorIndexOfSId);
        _result.supervisorId = _cursor.getString(_cursorIndexOfSupervisorId);
        _result.assessmentSessionId = _cursor.getString(_cursorIndexOfAssessmentSessionId);
        _result.supervisorName = _cursor.getString(_cursorIndexOfSupervisorName);
        _result.supervisorPhoto = _cursor.getString(_cursorIndexOfSupervisorPhoto);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.setSentFlag(_tmpSentFlag);
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
  public List<SupervisorData> getSupervisorBySession(String assessmentSessionId) {
    final String _sql = "SELECT * FROM SupervisorData where assessmentSessionId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (assessmentSessionId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assessmentSessionId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSId = _cursor.getColumnIndexOrThrow("sId");
      final int _cursorIndexOfSupervisorId = _cursor.getColumnIndexOrThrow("supervisorId");
      final int _cursorIndexOfAssessmentSessionId = _cursor.getColumnIndexOrThrow("assessmentSessionId");
      final int _cursorIndexOfSupervisorName = _cursor.getColumnIndexOrThrow("supervisorName");
      final int _cursorIndexOfSupervisorPhoto = _cursor.getColumnIndexOrThrow("supervisorPhoto");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<SupervisorData> _result = new ArrayList<SupervisorData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SupervisorData _item;
        _item = new SupervisorData();
        _item.sId = _cursor.getInt(_cursorIndexOfSId);
        _item.supervisorId = _cursor.getString(_cursorIndexOfSupervisorId);
        _item.assessmentSessionId = _cursor.getString(_cursorIndexOfAssessmentSessionId);
        _item.supervisorName = _cursor.getString(_cursorIndexOfSupervisorName);
        _item.supervisorPhoto = _cursor.getString(_cursorIndexOfSupervisorPhoto);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
