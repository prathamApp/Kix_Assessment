package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.JSONArrayToString;
import com.pratham.foundation.database.domain.WordEnglish;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class EnglishWordDao_Impl implements EnglishWordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfWordEnglish;

  private final EntityInsertionAdapter __insertionAdapterOfWordEnglish_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfWordEnglish;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfWordEnglish;

  public EnglishWordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWordEnglish = new EntityInsertionAdapter<WordEnglish>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `WordEnglish`(`wordId`,`word`,`size`,`start`,`type`,`meaning`,`label`,`vowelTogether`,`blends`,`vowels`,`blendCnt`,`vowelCnt`,`uuid`,`synid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordEnglish value) {
        stmt.bindLong(1, value.getWordId());
        if (value.getWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWord());
        }
        stmt.bindLong(3, value.getSize());
        if (value.getStart() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStart());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getMeaning() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMeaning());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLabel());
        }
        final String _tmp;
        _tmp = JSONArrayToString.StringArrayToString(value.getVowelTogether());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = JSONArrayToString.StringArrayToString(value.getBlends());
        if (_tmp_1 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = JSONArrayToString.StringArrayToString(value.getVowels());
        if (_tmp_2 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_2);
        }
        stmt.bindLong(11, value.getBlendCnt());
        stmt.bindLong(12, value.getVowelCnt());
        if (value.getUuid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuid());
        }
        if (value.getSynid() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSynid());
        }
      }
    };
    this.__insertionAdapterOfWordEnglish_1 = new EntityInsertionAdapter<WordEnglish>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `WordEnglish`(`wordId`,`word`,`size`,`start`,`type`,`meaning`,`label`,`vowelTogether`,`blends`,`vowels`,`blendCnt`,`vowelCnt`,`uuid`,`synid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordEnglish value) {
        stmt.bindLong(1, value.getWordId());
        if (value.getWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWord());
        }
        stmt.bindLong(3, value.getSize());
        if (value.getStart() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStart());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getMeaning() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMeaning());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLabel());
        }
        final String _tmp;
        _tmp = JSONArrayToString.StringArrayToString(value.getVowelTogether());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = JSONArrayToString.StringArrayToString(value.getBlends());
        if (_tmp_1 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = JSONArrayToString.StringArrayToString(value.getVowels());
        if (_tmp_2 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_2);
        }
        stmt.bindLong(11, value.getBlendCnt());
        stmt.bindLong(12, value.getVowelCnt());
        if (value.getUuid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuid());
        }
        if (value.getSynid() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSynid());
        }
      }
    };
    this.__deletionAdapterOfWordEnglish = new EntityDeletionOrUpdateAdapter<WordEnglish>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `WordEnglish` WHERE `wordId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordEnglish value) {
        stmt.bindLong(1, value.getWordId());
      }
    };
    this.__updateAdapterOfWordEnglish = new EntityDeletionOrUpdateAdapter<WordEnglish>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `WordEnglish` SET `wordId` = ?,`word` = ?,`size` = ?,`start` = ?,`type` = ?,`meaning` = ?,`label` = ?,`vowelTogether` = ?,`blends` = ?,`vowels` = ?,`blendCnt` = ?,`vowelCnt` = ?,`uuid` = ?,`synid` = ? WHERE `wordId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordEnglish value) {
        stmt.bindLong(1, value.getWordId());
        if (value.getWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWord());
        }
        stmt.bindLong(3, value.getSize());
        if (value.getStart() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStart());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getMeaning() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMeaning());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLabel());
        }
        final String _tmp;
        _tmp = JSONArrayToString.StringArrayToString(value.getVowelTogether());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = JSONArrayToString.StringArrayToString(value.getBlends());
        if (_tmp_1 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = JSONArrayToString.StringArrayToString(value.getVowels());
        if (_tmp_2 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_2);
        }
        stmt.bindLong(11, value.getBlendCnt());
        stmt.bindLong(12, value.getVowelCnt());
        if (value.getUuid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuid());
        }
        if (value.getSynid() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSynid());
        }
        stmt.bindLong(15, value.getWordId());
      }
    };
  }

  @Override
  public long insert(WordEnglish word) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfWordEnglish.insertAndReturnId(word);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(WordEnglish... words) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfWordEnglish.insertAndReturnIdsArray(words);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWordList(List<WordEnglish> wordList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfWordEnglish_1.insert(wordList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertEnglishWordList(List<WordEnglish> wordList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfWordEnglish_1.insert(wordList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(WordEnglish word) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfWordEnglish.handle(word);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(WordEnglish... words) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfWordEnglish.handleMultiple(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(WordEnglish word) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfWordEnglish.handle(word);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public WordEnglish getWord(String uuid) {
    final String _sql = "select * from WordEnglish where uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfWordId = _cursor.getColumnIndexOrThrow("wordId");
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfSize = _cursor.getColumnIndexOrThrow("size");
      final int _cursorIndexOfStart = _cursor.getColumnIndexOrThrow("start");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfMeaning = _cursor.getColumnIndexOrThrow("meaning");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfVowelTogether = _cursor.getColumnIndexOrThrow("vowelTogether");
      final int _cursorIndexOfBlends = _cursor.getColumnIndexOrThrow("blends");
      final int _cursorIndexOfVowels = _cursor.getColumnIndexOrThrow("vowels");
      final int _cursorIndexOfBlendCnt = _cursor.getColumnIndexOrThrow("blendCnt");
      final int _cursorIndexOfVowelCnt = _cursor.getColumnIndexOrThrow("vowelCnt");
      final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("uuid");
      final int _cursorIndexOfSynid = _cursor.getColumnIndexOrThrow("synid");
      final WordEnglish _result;
      if(_cursor.moveToFirst()) {
        _result = new WordEnglish();
        final int _tmpWordId;
        _tmpWordId = _cursor.getInt(_cursorIndexOfWordId);
        _result.setWordId(_tmpWordId);
        final String _tmpWord;
        _tmpWord = _cursor.getString(_cursorIndexOfWord);
        _result.setWord(_tmpWord);
        final int _tmpSize;
        _tmpSize = _cursor.getInt(_cursorIndexOfSize);
        _result.setSize(_tmpSize);
        final String _tmpStart;
        _tmpStart = _cursor.getString(_cursorIndexOfStart);
        _result.setStart(_tmpStart);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _result.setType(_tmpType);
        final String _tmpMeaning;
        _tmpMeaning = _cursor.getString(_cursorIndexOfMeaning);
        _result.setMeaning(_tmpMeaning);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _result.setLabel(_tmpLabel);
        final String[] _tmpVowelTogether;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfVowelTogether);
        _tmpVowelTogether = JSONArrayToString.stringToStringArray(_tmp);
        _result.setVowelTogether(_tmpVowelTogether);
        final String[] _tmpBlends;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfBlends);
        _tmpBlends = JSONArrayToString.stringToStringArray(_tmp_1);
        _result.setBlends(_tmpBlends);
        final String[] _tmpVowels;
        final String _tmp_2;
        _tmp_2 = _cursor.getString(_cursorIndexOfVowels);
        _tmpVowels = JSONArrayToString.stringToStringArray(_tmp_2);
        _result.setVowels(_tmpVowels);
        final int _tmpBlendCnt;
        _tmpBlendCnt = _cursor.getInt(_cursorIndexOfBlendCnt);
        _result.setBlendCnt(_tmpBlendCnt);
        final int _tmpVowelCnt;
        _tmpVowelCnt = _cursor.getInt(_cursorIndexOfVowelCnt);
        _result.setVowelCnt(_tmpVowelCnt);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpSynid;
        _tmpSynid = _cursor.getString(_cursorIndexOfSynid);
        _result.setSynid(_tmpSynid);
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
  public List<WordEnglish> getAllWords() {
    final String _sql = "select * from WordEnglish";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfWordId = _cursor.getColumnIndexOrThrow("wordId");
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfSize = _cursor.getColumnIndexOrThrow("size");
      final int _cursorIndexOfStart = _cursor.getColumnIndexOrThrow("start");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfMeaning = _cursor.getColumnIndexOrThrow("meaning");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfVowelTogether = _cursor.getColumnIndexOrThrow("vowelTogether");
      final int _cursorIndexOfBlends = _cursor.getColumnIndexOrThrow("blends");
      final int _cursorIndexOfVowels = _cursor.getColumnIndexOrThrow("vowels");
      final int _cursorIndexOfBlendCnt = _cursor.getColumnIndexOrThrow("blendCnt");
      final int _cursorIndexOfVowelCnt = _cursor.getColumnIndexOrThrow("vowelCnt");
      final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("uuid");
      final int _cursorIndexOfSynid = _cursor.getColumnIndexOrThrow("synid");
      final List<WordEnglish> _result = new ArrayList<WordEnglish>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WordEnglish _item;
        _item = new WordEnglish();
        final int _tmpWordId;
        _tmpWordId = _cursor.getInt(_cursorIndexOfWordId);
        _item.setWordId(_tmpWordId);
        final String _tmpWord;
        _tmpWord = _cursor.getString(_cursorIndexOfWord);
        _item.setWord(_tmpWord);
        final int _tmpSize;
        _tmpSize = _cursor.getInt(_cursorIndexOfSize);
        _item.setSize(_tmpSize);
        final String _tmpStart;
        _tmpStart = _cursor.getString(_cursorIndexOfStart);
        _item.setStart(_tmpStart);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        final String _tmpMeaning;
        _tmpMeaning = _cursor.getString(_cursorIndexOfMeaning);
        _item.setMeaning(_tmpMeaning);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
        final String[] _tmpVowelTogether;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfVowelTogether);
        _tmpVowelTogether = JSONArrayToString.stringToStringArray(_tmp);
        _item.setVowelTogether(_tmpVowelTogether);
        final String[] _tmpBlends;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfBlends);
        _tmpBlends = JSONArrayToString.stringToStringArray(_tmp_1);
        _item.setBlends(_tmpBlends);
        final String[] _tmpVowels;
        final String _tmp_2;
        _tmp_2 = _cursor.getString(_cursorIndexOfVowels);
        _tmpVowels = JSONArrayToString.stringToStringArray(_tmp_2);
        _item.setVowels(_tmpVowels);
        final int _tmpBlendCnt;
        _tmpBlendCnt = _cursor.getInt(_cursorIndexOfBlendCnt);
        _item.setBlendCnt(_tmpBlendCnt);
        final int _tmpVowelCnt;
        _tmpVowelCnt = _cursor.getInt(_cursorIndexOfVowelCnt);
        _item.setVowelCnt(_tmpVowelCnt);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpSynid;
        _tmpSynid = _cursor.getString(_cursorIndexOfSynid);
        _item.setSynid(_tmpSynid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getWordCount() {
    final String _sql = "select count(*) from WordEnglish";
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
  public List<WordEnglish> getRandomWords() {
    final String _sql = "select * from WordEnglish where (size=2 or size=3)  and vowelCnt=1  ORDER BY RANDOM() ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfWordId = _cursor.getColumnIndexOrThrow("wordId");
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfSize = _cursor.getColumnIndexOrThrow("size");
      final int _cursorIndexOfStart = _cursor.getColumnIndexOrThrow("start");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfMeaning = _cursor.getColumnIndexOrThrow("meaning");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfVowelTogether = _cursor.getColumnIndexOrThrow("vowelTogether");
      final int _cursorIndexOfBlends = _cursor.getColumnIndexOrThrow("blends");
      final int _cursorIndexOfVowels = _cursor.getColumnIndexOrThrow("vowels");
      final int _cursorIndexOfBlendCnt = _cursor.getColumnIndexOrThrow("blendCnt");
      final int _cursorIndexOfVowelCnt = _cursor.getColumnIndexOrThrow("vowelCnt");
      final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("uuid");
      final int _cursorIndexOfSynid = _cursor.getColumnIndexOrThrow("synid");
      final List<WordEnglish> _result = new ArrayList<WordEnglish>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WordEnglish _item;
        _item = new WordEnglish();
        final int _tmpWordId;
        _tmpWordId = _cursor.getInt(_cursorIndexOfWordId);
        _item.setWordId(_tmpWordId);
        final String _tmpWord;
        _tmpWord = _cursor.getString(_cursorIndexOfWord);
        _item.setWord(_tmpWord);
        final int _tmpSize;
        _tmpSize = _cursor.getInt(_cursorIndexOfSize);
        _item.setSize(_tmpSize);
        final String _tmpStart;
        _tmpStart = _cursor.getString(_cursorIndexOfStart);
        _item.setStart(_tmpStart);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        final String _tmpMeaning;
        _tmpMeaning = _cursor.getString(_cursorIndexOfMeaning);
        _item.setMeaning(_tmpMeaning);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
        final String[] _tmpVowelTogether;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfVowelTogether);
        _tmpVowelTogether = JSONArrayToString.stringToStringArray(_tmp);
        _item.setVowelTogether(_tmpVowelTogether);
        final String[] _tmpBlends;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfBlends);
        _tmpBlends = JSONArrayToString.stringToStringArray(_tmp_1);
        _item.setBlends(_tmpBlends);
        final String[] _tmpVowels;
        final String _tmp_2;
        _tmp_2 = _cursor.getString(_cursorIndexOfVowels);
        _tmpVowels = JSONArrayToString.stringToStringArray(_tmp_2);
        _item.setVowels(_tmpVowels);
        final int _tmpBlendCnt;
        _tmpBlendCnt = _cursor.getInt(_cursorIndexOfBlendCnt);
        _item.setBlendCnt(_tmpBlendCnt);
        final int _tmpVowelCnt;
        _tmpVowelCnt = _cursor.getInt(_cursorIndexOfVowelCnt);
        _item.setVowelCnt(_tmpVowelCnt);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpSynid;
        _tmpSynid = _cursor.getString(_cursorIndexOfSynid);
        _item.setSynid(_tmpSynid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WordEnglish> getEnglishLevelOneWords(String label) {
    final String _sql = "select * from WordEnglish where label=?  ORDER BY RANDOM() LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (label == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, label);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfWordId = _cursor.getColumnIndexOrThrow("wordId");
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfSize = _cursor.getColumnIndexOrThrow("size");
      final int _cursorIndexOfStart = _cursor.getColumnIndexOrThrow("start");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfMeaning = _cursor.getColumnIndexOrThrow("meaning");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfVowelTogether = _cursor.getColumnIndexOrThrow("vowelTogether");
      final int _cursorIndexOfBlends = _cursor.getColumnIndexOrThrow("blends");
      final int _cursorIndexOfVowels = _cursor.getColumnIndexOrThrow("vowels");
      final int _cursorIndexOfBlendCnt = _cursor.getColumnIndexOrThrow("blendCnt");
      final int _cursorIndexOfVowelCnt = _cursor.getColumnIndexOrThrow("vowelCnt");
      final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("uuid");
      final int _cursorIndexOfSynid = _cursor.getColumnIndexOrThrow("synid");
      final List<WordEnglish> _result = new ArrayList<WordEnglish>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WordEnglish _item;
        _item = new WordEnglish();
        final int _tmpWordId;
        _tmpWordId = _cursor.getInt(_cursorIndexOfWordId);
        _item.setWordId(_tmpWordId);
        final String _tmpWord;
        _tmpWord = _cursor.getString(_cursorIndexOfWord);
        _item.setWord(_tmpWord);
        final int _tmpSize;
        _tmpSize = _cursor.getInt(_cursorIndexOfSize);
        _item.setSize(_tmpSize);
        final String _tmpStart;
        _tmpStart = _cursor.getString(_cursorIndexOfStart);
        _item.setStart(_tmpStart);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        final String _tmpMeaning;
        _tmpMeaning = _cursor.getString(_cursorIndexOfMeaning);
        _item.setMeaning(_tmpMeaning);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
        final String[] _tmpVowelTogether;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfVowelTogether);
        _tmpVowelTogether = JSONArrayToString.stringToStringArray(_tmp);
        _item.setVowelTogether(_tmpVowelTogether);
        final String[] _tmpBlends;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfBlends);
        _tmpBlends = JSONArrayToString.stringToStringArray(_tmp_1);
        _item.setBlends(_tmpBlends);
        final String[] _tmpVowels;
        final String _tmp_2;
        _tmp_2 = _cursor.getString(_cursorIndexOfVowels);
        _tmpVowels = JSONArrayToString.stringToStringArray(_tmp_2);
        _item.setVowels(_tmpVowels);
        final int _tmpBlendCnt;
        _tmpBlendCnt = _cursor.getInt(_cursorIndexOfBlendCnt);
        _item.setBlendCnt(_tmpBlendCnt);
        final int _tmpVowelCnt;
        _tmpVowelCnt = _cursor.getInt(_cursorIndexOfVowelCnt);
        _item.setVowelCnt(_tmpVowelCnt);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpSynid;
        _tmpSynid = _cursor.getString(_cursorIndexOfSynid);
        _item.setSynid(_tmpSynid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WordEnglish> getSentencesBetweenSizes(int size1, int size2) {
    final String _sql = "select * from WordEnglish where size between ? and ? and type='sentence' ORDER BY RANDOM() LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, size1);
    _argIndex = 2;
    _statement.bindLong(_argIndex, size2);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfWordId = _cursor.getColumnIndexOrThrow("wordId");
      final int _cursorIndexOfWord = _cursor.getColumnIndexOrThrow("word");
      final int _cursorIndexOfSize = _cursor.getColumnIndexOrThrow("size");
      final int _cursorIndexOfStart = _cursor.getColumnIndexOrThrow("start");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfMeaning = _cursor.getColumnIndexOrThrow("meaning");
      final int _cursorIndexOfLabel = _cursor.getColumnIndexOrThrow("label");
      final int _cursorIndexOfVowelTogether = _cursor.getColumnIndexOrThrow("vowelTogether");
      final int _cursorIndexOfBlends = _cursor.getColumnIndexOrThrow("blends");
      final int _cursorIndexOfVowels = _cursor.getColumnIndexOrThrow("vowels");
      final int _cursorIndexOfBlendCnt = _cursor.getColumnIndexOrThrow("blendCnt");
      final int _cursorIndexOfVowelCnt = _cursor.getColumnIndexOrThrow("vowelCnt");
      final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("uuid");
      final int _cursorIndexOfSynid = _cursor.getColumnIndexOrThrow("synid");
      final List<WordEnglish> _result = new ArrayList<WordEnglish>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WordEnglish _item;
        _item = new WordEnglish();
        final int _tmpWordId;
        _tmpWordId = _cursor.getInt(_cursorIndexOfWordId);
        _item.setWordId(_tmpWordId);
        final String _tmpWord;
        _tmpWord = _cursor.getString(_cursorIndexOfWord);
        _item.setWord(_tmpWord);
        final int _tmpSize;
        _tmpSize = _cursor.getInt(_cursorIndexOfSize);
        _item.setSize(_tmpSize);
        final String _tmpStart;
        _tmpStart = _cursor.getString(_cursorIndexOfStart);
        _item.setStart(_tmpStart);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        final String _tmpMeaning;
        _tmpMeaning = _cursor.getString(_cursorIndexOfMeaning);
        _item.setMeaning(_tmpMeaning);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
        final String[] _tmpVowelTogether;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfVowelTogether);
        _tmpVowelTogether = JSONArrayToString.stringToStringArray(_tmp);
        _item.setVowelTogether(_tmpVowelTogether);
        final String[] _tmpBlends;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfBlends);
        _tmpBlends = JSONArrayToString.stringToStringArray(_tmp_1);
        _item.setBlends(_tmpBlends);
        final String[] _tmpVowels;
        final String _tmp_2;
        _tmp_2 = _cursor.getString(_cursorIndexOfVowels);
        _tmpVowels = JSONArrayToString.stringToStringArray(_tmp_2);
        _item.setVowels(_tmpVowels);
        final int _tmpBlendCnt;
        _tmpBlendCnt = _cursor.getInt(_cursorIndexOfBlendCnt);
        _item.setBlendCnt(_tmpBlendCnt);
        final int _tmpVowelCnt;
        _tmpVowelCnt = _cursor.getInt(_cursorIndexOfVowelCnt);
        _item.setVowelCnt(_tmpVowelCnt);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpSynid;
        _tmpSynid = _cursor.getString(_cursorIndexOfSynid);
        _item.setSynid(_tmpSynid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getTotalEntries() {
    final String _sql = "select count(*) from WordEnglish";
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
  public int getSentenceCount() {
    final String _sql = "select count(*) from WordEnglish WHERE type='sentence'";
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
}
