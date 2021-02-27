package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.modalclasses.MatchThePair;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class MatchThePairDao_Impl implements MatchThePairDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMatchThePair;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllQuestions;

  public MatchThePairDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMatchThePair = new EntityInsertionAdapter<MatchThePair>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MatchThePair`(`paraTitle`,`langText`,`paraText`,`paraLang`,`id`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MatchThePair value) {
        if (value.getParaTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getParaTitle());
        }
        if (value.getLangText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLangText());
        }
        if (value.getParaText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getParaText());
        }
        if (value.getParaLang() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getParaLang());
        }
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllQuestions = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MatchThePair";
        return _query;
      }
    };
  }

  @Override
  public void insertAllParas(List<MatchThePair> modalClasses) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMatchThePair.insert(modalClasses);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllQuestions() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllQuestions.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllQuestions.release(_stmt);
    }
  }

  @Override
  public List<MatchThePair> getQuestions(String lang) {
    final String _sql = "SELECT * FROM MatchThePair where paraLang=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (lang == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, lang);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfParaTitle = _cursor.getColumnIndexOrThrow("paraTitle");
      final int _cursorIndexOfLangText = _cursor.getColumnIndexOrThrow("langText");
      final int _cursorIndexOfParaText = _cursor.getColumnIndexOrThrow("paraText");
      final int _cursorIndexOfParaLang = _cursor.getColumnIndexOrThrow("paraLang");
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final List<MatchThePair> _result = new ArrayList<MatchThePair>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MatchThePair _item;
        _item = new MatchThePair();
        final String _tmpParaTitle;
        _tmpParaTitle = _cursor.getString(_cursorIndexOfParaTitle);
        _item.setParaTitle(_tmpParaTitle);
        final String _tmpLangText;
        _tmpLangText = _cursor.getString(_cursorIndexOfLangText);
        _item.setLangText(_tmpLangText);
        final String _tmpParaText;
        _tmpParaText = _cursor.getString(_cursorIndexOfParaText);
        _item.setParaText(_tmpParaText);
        final String _tmpParaLang;
        _tmpParaLang = _cursor.getString(_cursorIndexOfParaLang);
        _item.setParaLang(_tmpParaLang);
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MatchThePair> getRandomQuestions(String lang) {
    final String _sql = "SELECT * FROM MatchThePair where paraLang=? order by random() limit 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (lang == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, lang);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfParaTitle = _cursor.getColumnIndexOrThrow("paraTitle");
      final int _cursorIndexOfLangText = _cursor.getColumnIndexOrThrow("langText");
      final int _cursorIndexOfParaText = _cursor.getColumnIndexOrThrow("paraText");
      final int _cursorIndexOfParaLang = _cursor.getColumnIndexOrThrow("paraLang");
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final List<MatchThePair> _result = new ArrayList<MatchThePair>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MatchThePair _item;
        _item = new MatchThePair();
        final String _tmpParaTitle;
        _tmpParaTitle = _cursor.getString(_cursorIndexOfParaTitle);
        _item.setParaTitle(_tmpParaTitle);
        final String _tmpLangText;
        _tmpLangText = _cursor.getString(_cursorIndexOfLangText);
        _item.setLangText(_tmpLangText);
        final String _tmpParaText;
        _tmpParaText = _cursor.getString(_cursorIndexOfParaText);
        _item.setParaText(_tmpParaText);
        final String _tmpParaLang;
        _tmpParaLang = _cursor.getString(_cursorIndexOfParaLang);
        _item.setParaLang(_tmpParaLang);
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MatchThePair> GetQuestionById(String id, String lang) {
    final String _sql = "select * from MatchThePair where id=? and paraLang=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    _argIndex = 2;
    if (lang == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, lang);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfParaTitle = _cursor.getColumnIndexOrThrow("paraTitle");
      final int _cursorIndexOfLangText = _cursor.getColumnIndexOrThrow("langText");
      final int _cursorIndexOfParaText = _cursor.getColumnIndexOrThrow("paraText");
      final int _cursorIndexOfParaLang = _cursor.getColumnIndexOrThrow("paraLang");
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final List<MatchThePair> _result = new ArrayList<MatchThePair>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MatchThePair _item;
        _item = new MatchThePair();
        final String _tmpParaTitle;
        _tmpParaTitle = _cursor.getString(_cursorIndexOfParaTitle);
        _item.setParaTitle(_tmpParaTitle);
        final String _tmpLangText;
        _tmpLangText = _cursor.getString(_cursorIndexOfLangText);
        _item.setLangText(_tmpLangText);
        final String _tmpParaText;
        _tmpParaText = _cursor.getString(_cursorIndexOfParaText);
        _item.setParaText(_tmpParaText);
        final String _tmpParaLang;
        _tmpParaLang = _cursor.getString(_cursorIndexOfParaLang);
        _item.setParaLang(_tmpParaLang);
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
