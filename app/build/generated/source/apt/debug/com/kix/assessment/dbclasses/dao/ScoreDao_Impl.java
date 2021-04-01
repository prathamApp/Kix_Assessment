package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Score;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ScoreDao_Impl implements ScoreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfScore;

  private final EntityInsertionAdapter __insertionAdapterOfScore_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfScore;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfScore;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllScores;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlag;

  public ScoreDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScore = new EntityInsertionAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Score`(`ScoreId`,`SessionID`,`StudentID`,`DeviceID`,`ResourceID`,`ScoredMarks`,`StartDateTime`,`EndDateTime`,`Label`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getScoreId());
        if (value.getSessionID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionID());
        }
        if (value.getStudentID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentID());
        }
        if (value.getDeviceID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDeviceID());
        }
        if (value.getResourceID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getResourceID());
        }
        if (value.getScoredMarks() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getScoredMarks());
        }
        if (value.getStartDateTime() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStartDateTime());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEndDateTime());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLabel());
        }
        stmt.bindLong(10, value.getSentFlag());
      }
    };
    this.__insertionAdapterOfScore_1 = new EntityInsertionAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Score`(`ScoreId`,`SessionID`,`StudentID`,`DeviceID`,`ResourceID`,`ScoredMarks`,`StartDateTime`,`EndDateTime`,`Label`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getScoreId());
        if (value.getSessionID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionID());
        }
        if (value.getStudentID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentID());
        }
        if (value.getDeviceID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDeviceID());
        }
        if (value.getResourceID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getResourceID());
        }
        if (value.getScoredMarks() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getScoredMarks());
        }
        if (value.getStartDateTime() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStartDateTime());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEndDateTime());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLabel());
        }
        stmt.bindLong(10, value.getSentFlag());
      }
    };
    this.__deletionAdapterOfScore = new EntityDeletionOrUpdateAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Score` WHERE `ScoreId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getScoreId());
      }
    };
    this.__updateAdapterOfScore = new EntityDeletionOrUpdateAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Score` SET `ScoreId` = ?,`SessionID` = ?,`StudentID` = ?,`DeviceID` = ?,`ResourceID` = ?,`ScoredMarks` = ?,`StartDateTime` = ?,`EndDateTime` = ?,`Label` = ?,`sentFlag` = ? WHERE `ScoreId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getScoreId());
        if (value.getSessionID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionID());
        }
        if (value.getStudentID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentID());
        }
        if (value.getDeviceID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDeviceID());
        }
        if (value.getResourceID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getResourceID());
        }
        if (value.getScoredMarks() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getScoredMarks());
        }
        if (value.getStartDateTime() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStartDateTime());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEndDateTime());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLabel());
        }
        stmt.bindLong(10, value.getSentFlag());
        stmt.bindLong(11, value.getScoreId());
      }
    };
    this.__preparedStmtOfDeleteAllScores = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Score";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Score SET sentFlag = 1 where SessionID = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(Score score) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfScore.insertAndReturnId(score);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<Score> score) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfScore_1.insert(score);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addScoreList(List<Score> contentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfScore_1.insert(contentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Score score) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfScore.handle(score);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(Score... scores) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfScore.handleMultiple(scores);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Score score) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfScore.handle(score);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllScores() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllScores.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllScores.release(_stmt);
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
  public List<Score> getAllScores() {
    final String _sql = "select * from Score";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("Label");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Score> _result = new ArrayList<Score>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Score _item;
        _item = new Score();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        final String _tmpDeviceID;
        _tmpDeviceID = _cursor.getString(_cursorIndexOfDeviceID);
        _item.setDeviceID(_tmpDeviceID);
        final String _tmpResourceID;
        _tmpResourceID = _cursor.getString(_cursorIndexOfResourceID);
        _item.setResourceID(_tmpResourceID);
        final String _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getString(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
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
  public List<Score> getScoreByStudIDAndResID(String currentStudentID, String resourceId,
      String label) {
    final String _sql = "select * from Score where StudentID=? AND ResourceID=? AND Label=?";
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
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("Label");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Score> _result = new ArrayList<Score>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Score _item;
        _item = new Score();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        final String _tmpDeviceID;
        _tmpDeviceID = _cursor.getString(_cursorIndexOfDeviceID);
        _item.setDeviceID(_tmpDeviceID);
        final String _tmpResourceID;
        _tmpResourceID = _cursor.getString(_cursorIndexOfResourceID);
        _item.setResourceID(_tmpResourceID);
        final String _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getString(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
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
  public List<Score> getAllNotSentScores() {
    final String _sql = "select * from Score where sentFlag = 0 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("Label");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Score> _result = new ArrayList<Score>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Score _item;
        _item = new Score();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        final String _tmpDeviceID;
        _tmpDeviceID = _cursor.getString(_cursorIndexOfDeviceID);
        _item.setDeviceID(_tmpDeviceID);
        final String _tmpResourceID;
        _tmpResourceID = _cursor.getString(_cursorIndexOfResourceID);
        _item.setResourceID(_tmpResourceID);
        final String _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getString(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
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
  public List<Score> getAllNewScores(String s_id) {
    final String _sql = "select * from Score where sentFlag = 0 AND SessionID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (s_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s_id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("Label");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Score> _result = new ArrayList<Score>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Score _item;
        _item = new Score();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        final String _tmpDeviceID;
        _tmpDeviceID = _cursor.getString(_cursorIndexOfDeviceID);
        _item.setDeviceID(_tmpDeviceID);
        final String _tmpResourceID;
        _tmpResourceID = _cursor.getString(_cursorIndexOfResourceID);
        _item.setResourceID(_tmpResourceID);
        final String _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getString(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
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
