package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Assessment;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class AssessmentDao_Impl implements AssessmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAssessment;

  private final EntityInsertionAdapter __insertionAdapterOfAssessment_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAssessment;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfAssessment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllAssessment;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfDeletePushedAssessment;

  public AssessmentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAssessment = new EntityInsertionAdapter<Assessment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Assessment`(`ScoreIda`,`SessionIDm`,`SessionIDa`,`StudentIDa`,`DeviceIDa`,`ResourceIDa`,`QuestionIda`,`ScoredMarksa`,`TotalMarksa`,`StartDateTimea`,`EndDateTimea`,`Levela`,`Labela`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Assessment value) {
        stmt.bindLong(1, value.getScoreIda());
        if (value.getSessionIDm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionIDm());
        }
        if (value.getSessionIDa() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSessionIDa());
        }
        if (value.getStudentIDa() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStudentIDa());
        }
        if (value.getDeviceIDa() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDeviceIDa());
        }
        if (value.getResourceIDa() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResourceIDa());
        }
        stmt.bindLong(7, value.getQuestionIda());
        stmt.bindLong(8, value.getScoredMarksa());
        stmt.bindLong(9, value.getTotalMarksa());
        if (value.getStartDateTimea() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStartDateTimea());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEndDateTime());
        }
        stmt.bindLong(12, value.getLevela());
        if (value.getLabel() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLabel());
        }
        stmt.bindLong(14, value.getSentFlag());
      }
    };
    this.__insertionAdapterOfAssessment_1 = new EntityInsertionAdapter<Assessment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Assessment`(`ScoreIda`,`SessionIDm`,`SessionIDa`,`StudentIDa`,`DeviceIDa`,`ResourceIDa`,`QuestionIda`,`ScoredMarksa`,`TotalMarksa`,`StartDateTimea`,`EndDateTimea`,`Levela`,`Labela`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Assessment value) {
        stmt.bindLong(1, value.getScoreIda());
        if (value.getSessionIDm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionIDm());
        }
        if (value.getSessionIDa() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSessionIDa());
        }
        if (value.getStudentIDa() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStudentIDa());
        }
        if (value.getDeviceIDa() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDeviceIDa());
        }
        if (value.getResourceIDa() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResourceIDa());
        }
        stmt.bindLong(7, value.getQuestionIda());
        stmt.bindLong(8, value.getScoredMarksa());
        stmt.bindLong(9, value.getTotalMarksa());
        if (value.getStartDateTimea() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStartDateTimea());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEndDateTime());
        }
        stmt.bindLong(12, value.getLevela());
        if (value.getLabel() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLabel());
        }
        stmt.bindLong(14, value.getSentFlag());
      }
    };
    this.__deletionAdapterOfAssessment = new EntityDeletionOrUpdateAdapter<Assessment>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Assessment` WHERE `ScoreIda` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Assessment value) {
        stmt.bindLong(1, value.getScoreIda());
      }
    };
    this.__updateAdapterOfAssessment = new EntityDeletionOrUpdateAdapter<Assessment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Assessment` SET `ScoreIda` = ?,`SessionIDm` = ?,`SessionIDa` = ?,`StudentIDa` = ?,`DeviceIDa` = ?,`ResourceIDa` = ?,`QuestionIda` = ?,`ScoredMarksa` = ?,`TotalMarksa` = ?,`StartDateTimea` = ?,`EndDateTimea` = ?,`Levela` = ?,`Labela` = ?,`sentFlag` = ? WHERE `ScoreIda` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Assessment value) {
        stmt.bindLong(1, value.getScoreIda());
        if (value.getSessionIDm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionIDm());
        }
        if (value.getSessionIDa() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSessionIDa());
        }
        if (value.getStudentIDa() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStudentIDa());
        }
        if (value.getDeviceIDa() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDeviceIDa());
        }
        if (value.getResourceIDa() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResourceIDa());
        }
        stmt.bindLong(7, value.getQuestionIda());
        stmt.bindLong(8, value.getScoredMarksa());
        stmt.bindLong(9, value.getTotalMarksa());
        if (value.getStartDateTimea() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStartDateTimea());
        }
        if (value.getEndDateTime() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEndDateTime());
        }
        stmt.bindLong(12, value.getLevela());
        if (value.getLabel() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLabel());
        }
        stmt.bindLong(14, value.getSentFlag());
        stmt.bindLong(15, value.getScoreIda());
      }
    };
    this.__preparedStmtOfDeleteAllAssessment = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Assessment";
        return _query;
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Assessment set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePushedAssessment = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from Assessment where sentFlag = 1";
        return _query;
      }
    };
  }

  @Override
  public long insert(Assessment assessment) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssessment.insertAndReturnId(assessment);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(Assessment... assessments) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfAssessment.insertAndReturnIdsArray(assessments);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addAssessmentList(List<Assessment> contentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssessment_1.insert(contentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Assessment assessment) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAssessment.handle(assessment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(Assessment... assessments) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAssessment.handleMultiple(assessments);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Assessment assessment) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfAssessment.handle(assessment);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllAssessment() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllAssessment.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllAssessment.release(_stmt);
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
  public void deletePushedAssessment() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePushedAssessment.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePushedAssessment.release(_stmt);
    }
  }

  @Override
  public List<Assessment> getAllAssessment() {
    final String _sql = "select * from Assessment where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreIda = _cursor.getColumnIndexOrThrow("ScoreIda");
      final int _cursorIndexOfSessionIDm = _cursor.getColumnIndexOrThrow("SessionIDm");
      final int _cursorIndexOfSessionIDa = _cursor.getColumnIndexOrThrow("SessionIDa");
      final int _cursorIndexOfStudentIDa = _cursor.getColumnIndexOrThrow("StudentIDa");
      final int _cursorIndexOfDeviceIDa = _cursor.getColumnIndexOrThrow("DeviceIDa");
      final int _cursorIndexOfResourceIDa = _cursor.getColumnIndexOrThrow("ResourceIDa");
      final int _cursorIndexOfQuestionIda = _cursor.getColumnIndexOrThrow("QuestionIda");
      final int _cursorIndexOfScoredMarksa = _cursor.getColumnIndexOrThrow("ScoredMarksa");
      final int _cursorIndexOfTotalMarksa = _cursor.getColumnIndexOrThrow("TotalMarksa");
      final int _cursorIndexOfStartDateTimea = _cursor.getColumnIndexOrThrow("StartDateTimea");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTimea");
      final int _cursorIndexOfLevela = _cursor.getColumnIndexOrThrow("Levela");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("Labela");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Assessment> _result = new ArrayList<Assessment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Assessment _item;
        _item = new Assessment();
        final int _tmpScoreIda;
        _tmpScoreIda = _cursor.getInt(_cursorIndexOfScoreIda);
        _item.setScoreIda(_tmpScoreIda);
        final String _tmpSessionIDm;
        _tmpSessionIDm = _cursor.getString(_cursorIndexOfSessionIDm);
        _item.setSessionIDm(_tmpSessionIDm);
        final String _tmpSessionIDa;
        _tmpSessionIDa = _cursor.getString(_cursorIndexOfSessionIDa);
        _item.setSessionIDa(_tmpSessionIDa);
        final String _tmpStudentIDa;
        _tmpStudentIDa = _cursor.getString(_cursorIndexOfStudentIDa);
        _item.setStudentIDa(_tmpStudentIDa);
        final String _tmpDeviceIDa;
        _tmpDeviceIDa = _cursor.getString(_cursorIndexOfDeviceIDa);
        _item.setDeviceIDa(_tmpDeviceIDa);
        final String _tmpResourceIDa;
        _tmpResourceIDa = _cursor.getString(_cursorIndexOfResourceIDa);
        _item.setResourceIDa(_tmpResourceIDa);
        final int _tmpQuestionIda;
        _tmpQuestionIda = _cursor.getInt(_cursorIndexOfQuestionIda);
        _item.setQuestionIda(_tmpQuestionIda);
        final int _tmpScoredMarksa;
        _tmpScoredMarksa = _cursor.getInt(_cursorIndexOfScoredMarksa);
        _item.setScoredMarksa(_tmpScoredMarksa);
        final int _tmpTotalMarksa;
        _tmpTotalMarksa = _cursor.getInt(_cursorIndexOfTotalMarksa);
        _item.setTotalMarksa(_tmpTotalMarksa);
        final String _tmpStartDateTimea;
        _tmpStartDateTimea = _cursor.getString(_cursorIndexOfStartDateTimea);
        _item.setStartDateTimea(_tmpStartDateTimea);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevela;
        _tmpLevela = _cursor.getInt(_cursorIndexOfLevela);
        _item.setLevela(_tmpLevela);
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
  public List<Assessment> getCertificates(String stdID, String COS_Lbl) {
    final String _sql = "select * from Assessment WHERE StartDateTimea=? AND Labela=? ORDER BY EndDateTimea DESC";
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
      final int _cursorIndexOfScoreIda = _cursor.getColumnIndexOrThrow("ScoreIda");
      final int _cursorIndexOfSessionIDm = _cursor.getColumnIndexOrThrow("SessionIDm");
      final int _cursorIndexOfSessionIDa = _cursor.getColumnIndexOrThrow("SessionIDa");
      final int _cursorIndexOfStudentIDa = _cursor.getColumnIndexOrThrow("StudentIDa");
      final int _cursorIndexOfDeviceIDa = _cursor.getColumnIndexOrThrow("DeviceIDa");
      final int _cursorIndexOfResourceIDa = _cursor.getColumnIndexOrThrow("ResourceIDa");
      final int _cursorIndexOfQuestionIda = _cursor.getColumnIndexOrThrow("QuestionIda");
      final int _cursorIndexOfScoredMarksa = _cursor.getColumnIndexOrThrow("ScoredMarksa");
      final int _cursorIndexOfTotalMarksa = _cursor.getColumnIndexOrThrow("TotalMarksa");
      final int _cursorIndexOfStartDateTimea = _cursor.getColumnIndexOrThrow("StartDateTimea");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTimea");
      final int _cursorIndexOfLevela = _cursor.getColumnIndexOrThrow("Levela");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("Labela");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Assessment> _result = new ArrayList<Assessment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Assessment _item;
        _item = new Assessment();
        final int _tmpScoreIda;
        _tmpScoreIda = _cursor.getInt(_cursorIndexOfScoreIda);
        _item.setScoreIda(_tmpScoreIda);
        final String _tmpSessionIDm;
        _tmpSessionIDm = _cursor.getString(_cursorIndexOfSessionIDm);
        _item.setSessionIDm(_tmpSessionIDm);
        final String _tmpSessionIDa;
        _tmpSessionIDa = _cursor.getString(_cursorIndexOfSessionIDa);
        _item.setSessionIDa(_tmpSessionIDa);
        final String _tmpStudentIDa;
        _tmpStudentIDa = _cursor.getString(_cursorIndexOfStudentIDa);
        _item.setStudentIDa(_tmpStudentIDa);
        final String _tmpDeviceIDa;
        _tmpDeviceIDa = _cursor.getString(_cursorIndexOfDeviceIDa);
        _item.setDeviceIDa(_tmpDeviceIDa);
        final String _tmpResourceIDa;
        _tmpResourceIDa = _cursor.getString(_cursorIndexOfResourceIDa);
        _item.setResourceIDa(_tmpResourceIDa);
        final int _tmpQuestionIda;
        _tmpQuestionIda = _cursor.getInt(_cursorIndexOfQuestionIda);
        _item.setQuestionIda(_tmpQuestionIda);
        final int _tmpScoredMarksa;
        _tmpScoredMarksa = _cursor.getInt(_cursorIndexOfScoredMarksa);
        _item.setScoredMarksa(_tmpScoredMarksa);
        final int _tmpTotalMarksa;
        _tmpTotalMarksa = _cursor.getInt(_cursorIndexOfTotalMarksa);
        _item.setTotalMarksa(_tmpTotalMarksa);
        final String _tmpStartDateTimea;
        _tmpStartDateTimea = _cursor.getString(_cursorIndexOfStartDateTimea);
        _item.setStartDateTimea(_tmpStartDateTimea);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevela;
        _tmpLevela = _cursor.getInt(_cursorIndexOfLevela);
        _item.setLevela(_tmpLevela);
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
  public int getAssessmentCount(String stdID) {
    final String _sql = "select count(*) from Assessment WHERE StudentIDa=?";
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
  public List<Assessment> getCertificatesGroups(String currentGroup, String certificateLbl) {
    final String _sql = "select * from Assessment WHERE StartDateTimea=? AND Labela=? ORDER BY EndDateTimea DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (currentGroup == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentGroup);
    }
    _argIndex = 2;
    if (certificateLbl == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, certificateLbl);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfScoreIda = _cursor.getColumnIndexOrThrow("ScoreIda");
      final int _cursorIndexOfSessionIDm = _cursor.getColumnIndexOrThrow("SessionIDm");
      final int _cursorIndexOfSessionIDa = _cursor.getColumnIndexOrThrow("SessionIDa");
      final int _cursorIndexOfStudentIDa = _cursor.getColumnIndexOrThrow("StudentIDa");
      final int _cursorIndexOfDeviceIDa = _cursor.getColumnIndexOrThrow("DeviceIDa");
      final int _cursorIndexOfResourceIDa = _cursor.getColumnIndexOrThrow("ResourceIDa");
      final int _cursorIndexOfQuestionIda = _cursor.getColumnIndexOrThrow("QuestionIda");
      final int _cursorIndexOfScoredMarksa = _cursor.getColumnIndexOrThrow("ScoredMarksa");
      final int _cursorIndexOfTotalMarksa = _cursor.getColumnIndexOrThrow("TotalMarksa");
      final int _cursorIndexOfStartDateTimea = _cursor.getColumnIndexOrThrow("StartDateTimea");
      final int _cursorIndexOfEndDateTime = _cursor.getColumnIndexOrThrow("EndDateTimea");
      final int _cursorIndexOfLevela = _cursor.getColumnIndexOrThrow("Levela");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("Labela");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Assessment> _result = new ArrayList<Assessment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Assessment _item;
        _item = new Assessment();
        final int _tmpScoreIda;
        _tmpScoreIda = _cursor.getInt(_cursorIndexOfScoreIda);
        _item.setScoreIda(_tmpScoreIda);
        final String _tmpSessionIDm;
        _tmpSessionIDm = _cursor.getString(_cursorIndexOfSessionIDm);
        _item.setSessionIDm(_tmpSessionIDm);
        final String _tmpSessionIDa;
        _tmpSessionIDa = _cursor.getString(_cursorIndexOfSessionIDa);
        _item.setSessionIDa(_tmpSessionIDa);
        final String _tmpStudentIDa;
        _tmpStudentIDa = _cursor.getString(_cursorIndexOfStudentIDa);
        _item.setStudentIDa(_tmpStudentIDa);
        final String _tmpDeviceIDa;
        _tmpDeviceIDa = _cursor.getString(_cursorIndexOfDeviceIDa);
        _item.setDeviceIDa(_tmpDeviceIDa);
        final String _tmpResourceIDa;
        _tmpResourceIDa = _cursor.getString(_cursorIndexOfResourceIDa);
        _item.setResourceIDa(_tmpResourceIDa);
        final int _tmpQuestionIda;
        _tmpQuestionIda = _cursor.getInt(_cursorIndexOfQuestionIda);
        _item.setQuestionIda(_tmpQuestionIda);
        final int _tmpScoredMarksa;
        _tmpScoredMarksa = _cursor.getInt(_cursorIndexOfScoredMarksa);
        _item.setScoredMarksa(_tmpScoredMarksa);
        final int _tmpTotalMarksa;
        _tmpTotalMarksa = _cursor.getInt(_cursorIndexOfTotalMarksa);
        _item.setTotalMarksa(_tmpTotalMarksa);
        final String _tmpStartDateTimea;
        _tmpStartDateTimea = _cursor.getString(_cursorIndexOfStartDateTimea);
        _item.setStartDateTimea(_tmpStartDateTimea);
        final String _tmpEndDateTime;
        _tmpEndDateTime = _cursor.getString(_cursorIndexOfEndDateTime);
        _item.setEndDateTime(_tmpEndDateTime);
        final int _tmpLevela;
        _tmpLevela = _cursor.getInt(_cursorIndexOfLevela);
        _item.setLevela(_tmpLevela);
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
  public int getUnpushedCertiCount(String CERTIFICATE_LBL) {
    final String _sql = "select count(*) from Assessment WHERE Labela=? AND sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (CERTIFICATE_LBL == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, CERTIFICATE_LBL);
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
}
