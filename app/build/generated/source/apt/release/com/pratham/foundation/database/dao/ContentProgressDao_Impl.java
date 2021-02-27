package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.ContentProgress;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ContentProgressDao_Impl implements ContentProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfContentProgress;

  private final EntityInsertionAdapter __insertionAdapterOfContentProgress_1;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  public ContentProgressDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContentProgress = new EntityInsertionAdapter<ContentProgress>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ContentProgress`(`progressId`,`sessionId`,`studentId`,`resourceId`,`updatedDateTime`,`progressPercentage`,`label`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContentProgress value) {
        stmt.bindLong(1, value.getProgressId());
        if (value.getSessionId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionId());
        }
        if (value.getStudentId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getResourceId());
        }
        if (value.getUpdatedDateTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUpdatedDateTime());
        }
        if (value.getProgressPercentage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProgressPercentage());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLabel());
        }
        stmt.bindLong(8, value.getSentFlag());
      }
    };
    this.__insertionAdapterOfContentProgress_1 = new EntityInsertionAdapter<ContentProgress>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ContentProgress`(`progressId`,`sessionId`,`studentId`,`resourceId`,`updatedDateTime`,`progressPercentage`,`label`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContentProgress value) {
        stmt.bindLong(1, value.getProgressId());
        if (value.getSessionId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionId());
        }
        if (value.getStudentId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getResourceId());
        }
        if (value.getUpdatedDateTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUpdatedDateTime());
        }
        if (value.getProgressPercentage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProgressPercentage());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLabel());
        }
        stmt.bindLong(8, value.getSentFlag());
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update ContentProgress set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
  }

  @Override
  public long insert(ContentProgress contentProgress) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfContentProgress.insertAndReturnId(contentProgress);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addContentProgressList(List<ContentProgress> contentProgressList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfContentProgress_1.insert(contentProgressList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
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
  public List<ContentProgress> getContentNodeProgress(String currentStudentID, String resourceId,
      String label) {
    final String _sql = "select * from ContentProgress where studentId=? AND resourceId=? AND label=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (currentStudentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentStudentID);
    }
    _argIndex = 2;
    if (resourceId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resourceId);
    }
    _argIndex = 3;
    if (label == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, label);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfProgressId = _cursor.getColumnIndexOrThrow("progressId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfUpdatedDateTime = _cursor.getColumnIndexOrThrow("updatedDateTime");
      final int _cursorIndexOfProgressPercentage = _cursor.getColumnIndexOrThrow("progressPercentage");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<ContentProgress> _result = new ArrayList<ContentProgress>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentProgress _item;
        _item = new ContentProgress();
        final int _tmpProgressId;
        _tmpProgressId = _cursor.getInt(_cursorIndexOfProgressId);
        _item.setProgressId(_tmpProgressId);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.setSessionId(_tmpSessionId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
        final String _tmpUpdatedDateTime;
        _tmpUpdatedDateTime = _cursor.getString(_cursorIndexOfUpdatedDateTime);
        _item.setUpdatedDateTime(_tmpUpdatedDateTime);
        final String _tmpProgressPercentage;
        _tmpProgressPercentage = _cursor.getString(_cursorIndexOfProgressPercentage);
        _item.setProgressPercentage(_tmpProgressPercentage);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
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
  public List<ContentProgress> getAllContentNodeProgress() {
    final String _sql = "select * from ContentProgress where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfProgressId = _cursor.getColumnIndexOrThrow("progressId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfUpdatedDateTime = _cursor.getColumnIndexOrThrow("updatedDateTime");
      final int _cursorIndexOfProgressPercentage = _cursor.getColumnIndexOrThrow("progressPercentage");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<ContentProgress> _result = new ArrayList<ContentProgress>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentProgress _item;
        _item = new ContentProgress();
        final int _tmpProgressId;
        _tmpProgressId = _cursor.getInt(_cursorIndexOfProgressId);
        _item.setProgressId(_tmpProgressId);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.setSessionId(_tmpSessionId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
        final String _tmpUpdatedDateTime;
        _tmpUpdatedDateTime = _cursor.getString(_cursorIndexOfUpdatedDateTime);
        _item.setUpdatedDateTime(_tmpUpdatedDateTime);
        final String _tmpProgressPercentage;
        _tmpProgressPercentage = _cursor.getString(_cursorIndexOfProgressPercentage);
        _item.setProgressPercentage(_tmpProgressPercentage);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
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
  public List<ContentProgress> getProgressByStudIDAndResID(String currentStudentID,
      String resourceId, String resourceProgress) {
    final String _sql = "select * from ContentProgress where studentId=? AND resourceId=? AND label=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (currentStudentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentStudentID);
    }
    _argIndex = 2;
    if (resourceId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resourceId);
    }
    _argIndex = 3;
    if (resourceProgress == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resourceProgress);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfProgressId = _cursor.getColumnIndexOrThrow("progressId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfUpdatedDateTime = _cursor.getColumnIndexOrThrow("updatedDateTime");
      final int _cursorIndexOfProgressPercentage = _cursor.getColumnIndexOrThrow("progressPercentage");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<ContentProgress> _result = new ArrayList<ContentProgress>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentProgress _item;
        _item = new ContentProgress();
        final int _tmpProgressId;
        _tmpProgressId = _cursor.getInt(_cursorIndexOfProgressId);
        _item.setProgressId(_tmpProgressId);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.setSessionId(_tmpSessionId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
        final String _tmpUpdatedDateTime;
        _tmpUpdatedDateTime = _cursor.getString(_cursorIndexOfUpdatedDateTime);
        _item.setUpdatedDateTime(_tmpUpdatedDateTime);
        final String _tmpProgressPercentage;
        _tmpProgressPercentage = _cursor.getString(_cursorIndexOfProgressPercentage);
        _item.setProgressPercentage(_tmpProgressPercentage);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
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
