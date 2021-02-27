package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.KeyWords;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class KeyWordDao_Impl implements KeyWordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfKeyWords;

  private final EntityInsertionAdapter __insertionAdapterOfKeyWords_1;

  private final EntityInsertionAdapter __insertionAdapterOfKeyWords_2;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfKeyWords;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfKeyWords;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  public KeyWordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKeyWords = new EntityInsertionAdapter<KeyWords>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `KeyWords`(`keyWordId`,`studentId`,`resourceId`,`keyWord`,`wordType`,`sentFlag`,`topic`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyWords value) {
        stmt.bindLong(1, value.getKeyWordId());
        if (value.getStudentId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStudentId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getResourceId());
        }
        if (value.getKeyWord() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKeyWord());
        }
        if (value.getWordType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWordType());
        }
        stmt.bindLong(6, value.getSentFlag());
        if (value.getTopic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTopic());
        }
      }
    };
    this.__insertionAdapterOfKeyWords_1 = new EntityInsertionAdapter<KeyWords>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `KeyWords`(`keyWordId`,`studentId`,`resourceId`,`keyWord`,`wordType`,`sentFlag`,`topic`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyWords value) {
        stmt.bindLong(1, value.getKeyWordId());
        if (value.getStudentId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStudentId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getResourceId());
        }
        if (value.getKeyWord() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKeyWord());
        }
        if (value.getWordType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWordType());
        }
        stmt.bindLong(6, value.getSentFlag());
        if (value.getTopic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTopic());
        }
      }
    };
    this.__insertionAdapterOfKeyWords_2 = new EntityInsertionAdapter<KeyWords>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `KeyWords`(`keyWordId`,`studentId`,`resourceId`,`keyWord`,`wordType`,`sentFlag`,`topic`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyWords value) {
        stmt.bindLong(1, value.getKeyWordId());
        if (value.getStudentId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStudentId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getResourceId());
        }
        if (value.getKeyWord() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKeyWord());
        }
        if (value.getWordType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWordType());
        }
        stmt.bindLong(6, value.getSentFlag());
        if (value.getTopic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTopic());
        }
      }
    };
    this.__deletionAdapterOfKeyWords = new EntityDeletionOrUpdateAdapter<KeyWords>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `KeyWords` WHERE `keyWordId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyWords value) {
        stmt.bindLong(1, value.getKeyWordId());
      }
    };
    this.__updateAdapterOfKeyWords = new EntityDeletionOrUpdateAdapter<KeyWords>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `KeyWords` SET `keyWordId` = ?,`studentId` = ?,`resourceId` = ?,`keyWord` = ?,`wordType` = ?,`sentFlag` = ?,`topic` = ? WHERE `keyWordId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyWords value) {
        stmt.bindLong(1, value.getKeyWordId());
        if (value.getStudentId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStudentId());
        }
        if (value.getResourceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getResourceId());
        }
        if (value.getKeyWord() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKeyWord());
        }
        if (value.getWordType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWordType());
        }
        stmt.bindLong(6, value.getSentFlag());
        if (value.getTopic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTopic());
        }
        stmt.bindLong(8, value.getKeyWordId());
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update KeyWords set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
  }

  @Override
  public long insert(KeyWords learntWord) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfKeyWords.insertAndReturnId(learntWord);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(KeyWords... LearntWord) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfKeyWords_1.insertAndReturnIdsArray(LearntWord);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWord(List<KeyWords> wordList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfKeyWords_2.insert(wordList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAllWord(List<KeyWords> wordList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfKeyWords_1.insert(wordList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(KeyWords word) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfKeyWords.handle(word);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(KeyWords... words) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfKeyWords.handleMultiple(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(KeyWords word) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfKeyWords.handle(word);
      __db.setTransactionSuccessful();
      return _total;
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
  public KeyWords getWordOfStudent(String studentId) {
    final String _sql = "select * from KeyWords where studentId= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfKeyWordId = _cursor.getColumnIndexOrThrow("keyWordId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfKeyWord = _cursor.getColumnIndexOrThrow("keyWord");
      final int _cursorIndexOfWordType = _cursor.getColumnIndexOrThrow("wordType");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
      final KeyWords _result;
      if(_cursor.moveToFirst()) {
        _result = new KeyWords();
        final int _tmpKeyWordId;
        _tmpKeyWordId = _cursor.getInt(_cursorIndexOfKeyWordId);
        _result.setKeyWordId(_tmpKeyWordId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _result.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _result.setResourceId(_tmpResourceId);
        final String _tmpKeyWord;
        _tmpKeyWord = _cursor.getString(_cursorIndexOfKeyWord);
        _result.setKeyWord(_tmpKeyWord);
        final String _tmpWordType;
        _tmpWordType = _cursor.getString(_cursorIndexOfWordType);
        _result.setWordType(_tmpWordType);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.setSentFlag(_tmpSentFlag);
        final String _tmpTopic;
        _tmpTopic = _cursor.getString(_cursorIndexOfTopic);
        _result.setTopic(_tmpTopic);
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
  public List<KeyWords> getAllData() {
    final String _sql = "select * from KeyWords where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfKeyWordId = _cursor.getColumnIndexOrThrow("keyWordId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfKeyWord = _cursor.getColumnIndexOrThrow("keyWord");
      final int _cursorIndexOfWordType = _cursor.getColumnIndexOrThrow("wordType");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
      final List<KeyWords> _result = new ArrayList<KeyWords>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KeyWords _item;
        _item = new KeyWords();
        final int _tmpKeyWordId;
        _tmpKeyWordId = _cursor.getInt(_cursorIndexOfKeyWordId);
        _item.setKeyWordId(_tmpKeyWordId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
        final String _tmpKeyWord;
        _tmpKeyWord = _cursor.getString(_cursorIndexOfKeyWord);
        _item.setKeyWord(_tmpKeyWord);
        final String _tmpWordType;
        _tmpWordType = _cursor.getString(_cursorIndexOfWordType);
        _item.setWordType(_tmpWordType);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        final String _tmpTopic;
        _tmpTopic = _cursor.getString(_cursorIndexOfTopic);
        _item.setTopic(_tmpTopic);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<KeyWords> getAllDataShare() {
    final String _sql = "select * from KeyWords where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfKeyWordId = _cursor.getColumnIndexOrThrow("keyWordId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfKeyWord = _cursor.getColumnIndexOrThrow("keyWord");
      final int _cursorIndexOfWordType = _cursor.getColumnIndexOrThrow("wordType");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
      final List<KeyWords> _result = new ArrayList<KeyWords>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KeyWords _item;
        _item = new KeyWords();
        final int _tmpKeyWordId;
        _tmpKeyWordId = _cursor.getInt(_cursorIndexOfKeyWordId);
        _item.setKeyWordId(_tmpKeyWordId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
        final String _tmpKeyWord;
        _tmpKeyWord = _cursor.getString(_cursorIndexOfKeyWord);
        _item.setKeyWord(_tmpKeyWord);
        final String _tmpWordType;
        _tmpWordType = _cursor.getString(_cursorIndexOfWordType);
        _item.setWordType(_tmpWordType);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        final String _tmpTopic;
        _tmpTopic = _cursor.getString(_cursorIndexOfTopic);
        _item.setTopic(_tmpTopic);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<KeyWords> getKeyWords(String stdID) {
    final String _sql = "select * from KeyWords WHERE studentId=? AND wordType='word'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfKeyWordId = _cursor.getColumnIndexOrThrow("keyWordId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfKeyWord = _cursor.getColumnIndexOrThrow("keyWord");
      final int _cursorIndexOfWordType = _cursor.getColumnIndexOrThrow("wordType");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
      final List<KeyWords> _result = new ArrayList<KeyWords>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KeyWords _item;
        _item = new KeyWords();
        final int _tmpKeyWordId;
        _tmpKeyWordId = _cursor.getInt(_cursorIndexOfKeyWordId);
        _item.setKeyWordId(_tmpKeyWordId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
        final String _tmpKeyWord;
        _tmpKeyWord = _cursor.getString(_cursorIndexOfKeyWord);
        _item.setKeyWord(_tmpKeyWord);
        final String _tmpWordType;
        _tmpWordType = _cursor.getString(_cursorIndexOfWordType);
        _item.setWordType(_tmpWordType);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        final String _tmpTopic;
        _tmpTopic = _cursor.getString(_cursorIndexOfTopic);
        _item.setTopic(_tmpTopic);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String checkWord(String stdID, String resId, String checkWord) {
    final String _sql = "select keyWord from KeyWords WHERE studentId=? AND wordType='word' AND resourceId=? AND keyWord=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
    }
    _argIndex = 3;
    if (checkWord == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkWord);
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
  public String checkEntry(String stdID, String resId, String checkWord, String type) {
    final String _sql = "select keyWord from KeyWords WHERE studentId=? AND wordType=? AND resourceId=? AND keyWord=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    _argIndex = 3;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
    }
    _argIndex = 4;
    if (checkWord == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkWord);
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
  public String checkLearntData(String stdID, String resId, String checkWord, String wordType) {
    final String _sql = "select keyWord from KeyWords WHERE studentId=? AND wordType=? AND resourceId=? AND keyWord=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (wordType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, wordType);
    }
    _argIndex = 3;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
    }
    _argIndex = 4;
    if (checkWord == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkWord);
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
  public int checkWordCount(String stdID, String resId) {
    final String _sql = "select count() from KeyWords WHERE studentId=? AND wordType='word' AND resourceId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
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
  public int checkUniqueWordCount(String stdID, String resId) {
    final String _sql = "select count(DISTINCT keyWord ) from KeyWords WHERE studentId=? AND wordType='word' AND resourceId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
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
  public int checkWordCountWithSession(String stdID, String resId) {
    final String _sql = "select count() from KeyWords WHERE studentId=? AND wordType='word' AND resourceId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
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
  public int checkWebWordCount(String stdID, String resId) {
    final String _sql = "select count() from KeyWords WHERE studentId=? AND resourceId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    _argIndex = 2;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
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
  public List<KeyWords> getLearntSentences(String stdID) {
    final String _sql = "select * from KeyWords WHERE studentId=? AND wordType='sentence'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stdID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stdID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfKeyWordId = _cursor.getColumnIndexOrThrow("keyWordId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfKeyWord = _cursor.getColumnIndexOrThrow("keyWord");
      final int _cursorIndexOfWordType = _cursor.getColumnIndexOrThrow("wordType");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
      final List<KeyWords> _result = new ArrayList<KeyWords>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KeyWords _item;
        _item = new KeyWords();
        final int _tmpKeyWordId;
        _tmpKeyWordId = _cursor.getInt(_cursorIndexOfKeyWordId);
        _item.setKeyWordId(_tmpKeyWordId);
        final String _tmpStudentId;
        _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.setStudentId(_tmpStudentId);
        final String _tmpResourceId;
        _tmpResourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.setResourceId(_tmpResourceId);
        final String _tmpKeyWord;
        _tmpKeyWord = _cursor.getString(_cursorIndexOfKeyWord);
        _item.setKeyWord(_tmpKeyWord);
        final String _tmpWordType;
        _tmpWordType = _cursor.getString(_cursorIndexOfWordType);
        _item.setWordType(_tmpWordType);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        final String _tmpTopic;
        _tmpTopic = _cursor.getString(_cursorIndexOfTopic);
        _item.setTopic(_tmpTopic);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getLearntSentenceCount(String stdID) {
    final String _sql = "select count(*) from KeyWords WHERE studentId=? AND wordType='sentence'";
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
  public int getLearntWordCount(String stdID) {
    final String _sql = "select count(*) from KeyWords WHERE studentId=? AND wordType='word'";
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
}
