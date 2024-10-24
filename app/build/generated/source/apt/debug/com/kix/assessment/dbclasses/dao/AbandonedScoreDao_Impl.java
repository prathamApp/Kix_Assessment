package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.Modal_ProfileDetails;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class AbandonedScoreDao_Impl implements AbandonedScoreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAbandonedScore;

  private final EntityInsertionAdapter __insertionAdapterOfAbandonedScore_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAbandonedScore;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfAbandonedScore;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllAbandonedScores;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlag;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  public AbandonedScoreDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAbandonedScore = new EntityInsertionAdapter<AbandonedScore>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `AbandonedScore`(`scoreId`,`sessionId`,`studentId`,`deviceId`,`resourceId`,`scoredMarks`,`startDateTime`,`endDateTime`,`label`,`svrCode`,`bookletNo`,`reason`,`countryName`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AbandonedScore value) {
        stmt.bindLong(1, value.getScoreId());
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
        if (value.getDeviceId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDeviceId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getResourceId());
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
        if (value.getSvrCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSvrCode());
        }
        if (value.getBookletNo() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBookletNo());
        }
        if (value.getReason() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReason());
        }
        if (value.getCountryName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCountryName());
        }
        stmt.bindLong(14, value.getSentFlag());
      }
    };
    this.__insertionAdapterOfAbandonedScore_1 = new EntityInsertionAdapter<AbandonedScore>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AbandonedScore`(`scoreId`,`sessionId`,`studentId`,`deviceId`,`resourceId`,`scoredMarks`,`startDateTime`,`endDateTime`,`label`,`svrCode`,`bookletNo`,`reason`,`countryName`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AbandonedScore value) {
        stmt.bindLong(1, value.getScoreId());
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
        if (value.getDeviceId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDeviceId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getResourceId());
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
        if (value.getSvrCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSvrCode());
        }
        if (value.getBookletNo() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBookletNo());
        }
        if (value.getReason() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReason());
        }
        if (value.getCountryName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCountryName());
        }
        stmt.bindLong(14, value.getSentFlag());
      }
    };
    this.__deletionAdapterOfAbandonedScore = new EntityDeletionOrUpdateAdapter<AbandonedScore>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AbandonedScore` WHERE `scoreId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AbandonedScore value) {
        stmt.bindLong(1, value.getScoreId());
      }
    };
    this.__updateAdapterOfAbandonedScore = new EntityDeletionOrUpdateAdapter<AbandonedScore>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `AbandonedScore` SET `scoreId` = ?,`sessionId` = ?,`studentId` = ?,`deviceId` = ?,`resourceId` = ?,`scoredMarks` = ?,`startDateTime` = ?,`endDateTime` = ?,`label` = ?,`svrCode` = ?,`bookletNo` = ?,`reason` = ?,`countryName` = ?,`sentFlag` = ? WHERE `scoreId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AbandonedScore value) {
        stmt.bindLong(1, value.getScoreId());
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
        if (value.getDeviceId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDeviceId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getResourceId());
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
        if (value.getSvrCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSvrCode());
        }
        if (value.getBookletNo() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBookletNo());
        }
        if (value.getReason() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReason());
        }
        if (value.getCountryName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCountryName());
        }
        stmt.bindLong(14, value.getSentFlag());
        stmt.bindLong(15, value.getScoreId());
      }
    };
    this.__preparedStmtOfDeleteAllAbandonedScores = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM AbandonedScore";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE AbandonedScore SET sentFlag = 1 where sessionId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update AbandonedScore set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
  }

  @Override
  public long insert(AbandonedScore AbandonedScore) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAbandonedScore.insertAndReturnId(AbandonedScore);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<AbandonedScore> AbandonedScore) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAbandonedScore_1.insert(AbandonedScore);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addAbandonedScoreList(List<AbandonedScore> contentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAbandonedScore_1.insert(contentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(AbandonedScore AbandonedScore) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAbandonedScore.handle(AbandonedScore);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(AbandonedScore... AbandonedScores) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAbandonedScore.handleMultiple(AbandonedScores);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(AbandonedScore AbandonedScore) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfAbandonedScore.handle(AbandonedScore);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllAbandonedScores() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllAbandonedScores.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllAbandonedScores.release(_stmt);
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
  public List<AbandonedScore> getAllAbandonedScores() {
    final String _sql = "select * from AbandonedScore";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("scoreId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("deviceId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("scoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("startDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("endDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfBookletNo = _cursor.getColumnIndexOrThrow("bookletNo");
      final int _cursorIndexOfReason = _cursor.getColumnIndexOrThrow("reason");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<AbandonedScore> _result = new ArrayList<AbandonedScore>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AbandonedScore _item;
        _item = new AbandonedScore();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.setSessionId(_tmpSessionId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
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
        final String _tmpSvrCode;
        _tmpSvrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.setSvrCode(_tmpSvrCode);
        final String _tmpBookletNo;
        _tmpBookletNo = _cursor.getString(_cursorIndexOfBookletNo);
        _item.setBookletNo(_tmpBookletNo);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        _item.setReason(_tmpReason);
        final String _tmpCountryName;
        _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.setCountryName(_tmpCountryName);
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
  public List<AbandonedScore> getAbandonedScoreByStudIDAndResID(String currentStudentID,
      String resourceId, String label) {
    final String _sql = "select * from AbandonedScore where studentId=? AND resourceId=? AND label=?";
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
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("scoreId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("deviceId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("scoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("startDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("endDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfBookletNo = _cursor.getColumnIndexOrThrow("bookletNo");
      final int _cursorIndexOfReason = _cursor.getColumnIndexOrThrow("reason");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<AbandonedScore> _result = new ArrayList<AbandonedScore>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AbandonedScore _item;
        _item = new AbandonedScore();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.setSessionId(_tmpSessionId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
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
        final String _tmpSvrCode;
        _tmpSvrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.setSvrCode(_tmpSvrCode);
        final String _tmpBookletNo;
        _tmpBookletNo = _cursor.getString(_cursorIndexOfBookletNo);
        _item.setBookletNo(_tmpBookletNo);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        _item.setReason(_tmpReason);
        final String _tmpCountryName;
        _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.setCountryName(_tmpCountryName);
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
  public List<AbandonedScore> getAllNotSentAbandonedScores() {
    final String _sql = "select * from AbandonedScore where sentFlag = 0 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("scoreId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("deviceId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("scoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("startDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("endDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfBookletNo = _cursor.getColumnIndexOrThrow("bookletNo");
      final int _cursorIndexOfReason = _cursor.getColumnIndexOrThrow("reason");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<AbandonedScore> _result = new ArrayList<AbandonedScore>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AbandonedScore _item;
        _item = new AbandonedScore();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.setSessionId(_tmpSessionId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
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
        final String _tmpSvrCode;
        _tmpSvrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.setSvrCode(_tmpSvrCode);
        final String _tmpBookletNo;
        _tmpBookletNo = _cursor.getString(_cursorIndexOfBookletNo);
        _item.setBookletNo(_tmpBookletNo);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        _item.setReason(_tmpReason);
        final String _tmpCountryName;
        _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.setCountryName(_tmpCountryName);
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
  public List<AbandonedScore> getAllNewAbandonedScores(String s_id) {
    final String _sql = "select * from AbandonedScore where sentFlag = 0 AND sessionId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (s_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s_id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreId = _cursor.getColumnIndexOrThrow("scoreId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("deviceId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfScoredMarks = _cursor.getColumnIndexOrThrow("scoredMarks");
      final int _cursorIndexOfStartDateTime = _cursor.getColumnIndexOrThrow("startDateTime");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("endDateTime");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfBookletNo = _cursor.getColumnIndexOrThrow("bookletNo");
      final int _cursorIndexOfReason = _cursor.getColumnIndexOrThrow("reason");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<AbandonedScore> _result = new ArrayList<AbandonedScore>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AbandonedScore _item;
        _item = new AbandonedScore();
        final int _tmpScoreId;
        _tmpScoreId = _cursor.getInt(_cursorIndexOfScoreId);
        _item.setScoreId(_tmpScoreId);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.setSessionId(_tmpSessionId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
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
        final String _tmpSvrCode;
        _tmpSvrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.setSvrCode(_tmpSvrCode);
        final String _tmpBookletNo;
        _tmpBookletNo = _cursor.getString(_cursorIndexOfBookletNo);
        _item.setBookletNo(_tmpBookletNo);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        _item.setReason(_tmpReason);
        final String _tmpCountryName;
        _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.setCountryName(_tmpCountryName);
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
  public List<Modal_ProfileDetails> getProfileData(String svrCode) {
    final String _sql = "select Student.CH01 as StudentName, Student.CH03 as StudentAge, Household.householdName as HouseholdName, count(DISTINCT(AbandonedScore.sessionId)) as ExamsGiven from AbandonedScore\n"
            + "INNER JOIN Student on AbandonedScore.studentId = Student.studentId\n"
            + "INNER JOIN Household on Household.householdId = Student.householdId\n"
            + "INNER JOIN Surveyor on Surveyor.svrCode= Household.svrCode\n"
            + "WHERE Surveyor.svrCode=? GROUP by Student.studentId, Surveyor.svrName";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudentName = _cursor.getColumnIndexOrThrow("StudentName");
      final int _cursorIndexOfStudentAge = _cursor.getColumnIndexOrThrow("StudentAge");
      final int _cursorIndexOfHouseholdName = _cursor.getColumnIndexOrThrow("HouseholdName");
      final int _cursorIndexOfExamsGiven = _cursor.getColumnIndexOrThrow("ExamsGiven");
      final List<Modal_ProfileDetails> _result = new ArrayList<Modal_ProfileDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_ProfileDetails _item;
        _item = new Modal_ProfileDetails();
        final String _tmpStudentName;
        _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
        _item.setStudentName(_tmpStudentName);
        final String _tmpStudentAge;
        _tmpStudentAge = _cursor.getString(_cursorIndexOfStudentAge);
        _item.setStudentAge(_tmpStudentAge);
        final String _tmpHouseholdName;
        _tmpHouseholdName = _cursor.getString(_cursorIndexOfHouseholdName);
        _item.setHouseholdName(_tmpHouseholdName);
        final String _tmpExamsGiven;
        _tmpExamsGiven = _cursor.getString(_cursorIndexOfExamsGiven);
        _item.setExamsGiven(_tmpExamsGiven);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getStudentId(String studId) {
    final String _sql = "select studentId from AbandonedScore where studentId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studId);
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
  public boolean getAllPushedAbandonedScoresCount() {
    final String _sql = "select COUNT(*) from AbandonedScore where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
