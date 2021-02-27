package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Score;
import com.pratham.foundation.modalclasses.Modal_ResourcePlayedByGroups;
import com.pratham.foundation.modalclasses.Modal_TotalDaysGroupsPlayed;
import com.pratham.foundation.modalclasses.Modal_TotalDaysStudentsPlayed;
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

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfSetImgSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfDeletePushedScore;

  public ScoreDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScore = new EntityInsertionAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Score`(`ScoreId`,`SessionID`,`StudentID`,`DeviceID`,`ResourceID`,`QuestionId`,`ScoredMarks`,`TotalMarks`,`StartDateTime`,`EndDateTime`,`Level`,`Label`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
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
        stmt.bindLong(6, value.getQuestionId());
        stmt.bindLong(7, value.getScoredMarks());
        stmt.bindLong(8, value.getTotalMarks());
        if (value.getStartDateTime() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDateTime());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndDateTime());
        }
        stmt.bindLong(11, value.getLevel());
        if (value.getLabel() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLabel());
        }
        stmt.bindLong(13, value.getSentFlag());
      }
    };
    this.__insertionAdapterOfScore_1 = new EntityInsertionAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Score`(`ScoreId`,`SessionID`,`StudentID`,`DeviceID`,`ResourceID`,`QuestionId`,`ScoredMarks`,`TotalMarks`,`StartDateTime`,`EndDateTime`,`Level`,`Label`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
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
        stmt.bindLong(6, value.getQuestionId());
        stmt.bindLong(7, value.getScoredMarks());
        stmt.bindLong(8, value.getTotalMarks());
        if (value.getStartDateTime() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDateTime());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndDateTime());
        }
        stmt.bindLong(11, value.getLevel());
        if (value.getLabel() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLabel());
        }
        stmt.bindLong(13, value.getSentFlag());
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
        return "UPDATE OR ABORT `Score` SET `ScoreId` = ?,`SessionID` = ?,`StudentID` = ?,`DeviceID` = ?,`ResourceID` = ?,`QuestionId` = ?,`ScoredMarks` = ?,`TotalMarks` = ?,`StartDateTime` = ?,`EndDateTime` = ?,`Level` = ?,`Label` = ?,`sentFlag` = ? WHERE `ScoreId` = ?";
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
        stmt.bindLong(6, value.getQuestionId());
        stmt.bindLong(7, value.getScoredMarks());
        stmt.bindLong(8, value.getTotalMarks());
        if (value.getStartDateTime() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDateTime());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndDateTime());
        }
        stmt.bindLong(11, value.getLevel());
        if (value.getLabel() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLabel());
        }
        stmt.bindLong(13, value.getSentFlag());
        stmt.bindLong(14, value.getScoreId());
      }
    };
    this.__preparedStmtOfDeleteAllScores = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Score";
        return _query;
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Score set sentFlag=1 where sentFlag=0 AND Label!='img_push_lbl'";
        return _query;
      }
    };
    this.__preparedStmtOfSetImgSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Score set sentFlag=1 where StartDateTime=? AND Label='img_push_lbl'";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePushedScore = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from Score where sentFlag = 1";
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
  public void setImgSentFlag(String imgName) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetImgSentFlag.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (imgName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, imgName);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetImgSentFlag.release(_stmt);
    }
  }

  @Override
  public void deletePushedScore() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePushedScore.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePushedScore.release(_stmt);
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
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
  public List<Score> getAllPushScores() {
    final String _sql = "select * from Score where sentFlag=0  AND Label!='img_push_lbl'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
  public int getSentFlag(String imgName) {
    final String _sql = "Select sentFlag from Score where StartDateTime=? AND Label='img_push_lbl'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (imgName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, imgName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getUnpushedImageCount() {
    final String _sql = "Select COUNT(sentFlag) from Score where sentFlag=0 AND Label='img_push_lbl'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getRCHighScore(String stdID) {
    final String _sql = "Select MAX(ScoredMarks) from Score where StudentID=? AND Label='RC-sessionTotalScore '";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Score> getScoreByStdID(String stdID) {
    final String _sql = "select * from Score where StudentID=? AND Label='RC-sessionTotalScore '";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
  public List<Score> getScoreOfRCsessionTotalScore() {
    final String _sql = "select * from Score where Label='RC-sessionTotalScore '";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
  public List<Score> getImageQuesGroups(String currentGroup, String ImageQuesLbl) {
    final String _sql = "select * from Score WHERE StudentID=? AND Label LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (currentGroup == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentGroup);
    }
    _argIndex = 2;
    if (ImageQuesLbl == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ImageQuesLbl);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
  public List<Score> getImageQues(String stdID, String COS_Lbl) {
    final String _sql = "select * from Score WHERE StudentID=? AND Label LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (COS_Lbl == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, COS_Lbl);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("ScoreId");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDeviceID = _cursor.getColumnIndexOrThrow("DeviceID");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfQuestionId = _cursor.getColumnIndexOrThrow("QuestionId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("ScoredMarks");
      final int _cursorIndexOfTotalMarks = _cursor.getColumnIndexOrThrow("TotalMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("StartDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTime");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Level");
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
        final int _tmpQuestionId;
        _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
        _item.setQuestionId(_tmpQuestionId);
        final int _tmpScoredMarks;
        _tmpScoredMarks = _cursor.getInt(_cursorIndexOfScoredMarks);
        _item.setScoredMarks(_tmpScoredMarks);
        final int _tmpTotalMarks;
        _tmpTotalMarks = _cursor.getInt(_cursorIndexOfTotalMarks);
        _item.setTotalMarks(_tmpTotalMarks);
        final String _tmpStartDateTime;
        _tmpStartDateTime = _cursor.getString(_cursorIndexOfStartDateTime);
        _item.setStartDateTime(_tmpStartDateTime);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevel;
        _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
        _item.setLevel(_tmpLevel);
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
  public int getTotalActiveDeviceDays() {
    final String _sql = "Select count(distinct REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(substr(startdatetime,1,instr(startdatetime,' ')),'01','1'),'02','2'),'03','3'),'04','4'),'05','5'),'06','6'),'07','7'),'08','8'),'09','9')) as dates from Score sc where length(startdatetime)>5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_TotalDaysGroupsPlayed> getTotalDaysGroupsPlayed() {
    final String _sql = "Select count(distinct REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(substr(startdatetime,1,instr(startdatetime,' ')),'01','1'),'02','2'),'03','3'),'04','4'),'05','5'),'06','6'),'07','7'),'08','8'),'09','9')) as dates,at.groupid,g.groupname from Score sc inner join Attendance at on sc.sessionid=at.sessionid inner join Groups g on at.groupid=g.groupid where length(startdatetime)>5 group by at.groupid,g.groupname";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfDates = _cursor.getColumnIndexOrThrow("dates");
      final int _cursorIndexOfGroupID = _cursor.getColumnIndexOrThrow("GroupID");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final List<Modal_TotalDaysGroupsPlayed> _result = new ArrayList<Modal_TotalDaysGroupsPlayed>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_TotalDaysGroupsPlayed _item;
        _item = new Modal_TotalDaysGroupsPlayed();
        _item.dates = _cursor.getString(_cursorIndexOfDates);
        _item.GroupID = _cursor.getString(_cursorIndexOfGroupID);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_TotalDaysStudentsPlayed> getTotalDaysStudentPlayed(String stdid) {
    final String _sql = "Select count(distinct REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(substr(startdatetime,1,instr(startdatetime,' ')),'01','1'),'02','2'),'03','3'),'04','4'),'05','5'),'06','6'),'07','7'),'08','8'),'09','9')) as dates,at.studentid,st.fullname from Score sc inner join Attendance at on sc.sessionid=at.sessionid inner join Student st on at.studentid=st.studentid where length(startdatetime)>5 and at.studentid=? group by at.studentid,st.fullname";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stdid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdid);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfDates = _cursor.getColumnIndexOrThrow("dates");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final List<Modal_TotalDaysStudentsPlayed> _result = new ArrayList<Modal_TotalDaysStudentsPlayed>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_TotalDaysStudentsPlayed _item;
        _item = new Modal_TotalDaysStudentsPlayed();
        _item.dates = _cursor.getString(_cursorIndexOfDates);
        _item.StudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.FullName = _cursor.getString(_cursorIndexOfFullName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_TotalDaysStudentsPlayed> getTotalDaysByStudentID(String stdId) {
    final String _sql = "Select distinct REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(substr(startdatetime,1,instr(startdatetime,' ')),'01','1'),'02','2'),'03','3'),'04','4'),'05','5'),'06','6'),'07','7'),'08','8'),'09','9') as dates,sc.resourceid,tc.nodeTitle, at.studentid,st.fullname from Score sc inner join ContentTable tc on tc.resourceid=sc.resourceid inner join Attendance at on sc.sessionid=at.sessionid inner join Student st on at.studentid=st.studentid where length(startdatetime)>5 and at.studentid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stdId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfDates = _cursor.getColumnIndexOrThrow("dates");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final List<Modal_TotalDaysStudentsPlayed> _result = new ArrayList<Modal_TotalDaysStudentsPlayed>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_TotalDaysStudentsPlayed _item;
        _item = new Modal_TotalDaysStudentsPlayed();
        _item.dates = _cursor.getString(_cursorIndexOfDates);
        _item.StudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.FullName = _cursor.getString(_cursorIndexOfFullName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_ResourcePlayedByGroups> getRecourcesPlayedByGroups(String grpId) {
    final String _sql = "Select distinct REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(substr(startdatetime,1,instr(startdatetime,' ')),'01','1'),'02','2'),'03','3'),'04','4'),'05','5'),'06','6'),'07','7'),'08','8'),'09','9') as dates,sc.resourceid,tc.nodeTitle, at.groupid,g.groupname from Score sc inner join ContentTable tc on tc.resourceid=sc.resourceid inner join Attendance at on sc.sessionid=at.sessionid inner join Groups g on at.groupid=g.groupid where length(startdatetime)>5 and at.groupid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (grpId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, grpId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfDates = _cursor.getColumnIndexOrThrow("dates");
      final int _cursorIndexOfResourceID = _cursor.getColumnIndexOrThrow("ResourceID");
      final int _cursorIndexOfGroupID = _cursor.getColumnIndexOrThrow("GroupID");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final List<Modal_ResourcePlayedByGroups> _result = new ArrayList<Modal_ResourcePlayedByGroups>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_ResourcePlayedByGroups _item;
        _item = new Modal_ResourcePlayedByGroups();
        _item.dates = _cursor.getString(_cursorIndexOfDates);
        _item.ResourceID = _cursor.getString(_cursorIndexOfResourceID);
        _item.GroupID = _cursor.getString(_cursorIndexOfGroupID);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
