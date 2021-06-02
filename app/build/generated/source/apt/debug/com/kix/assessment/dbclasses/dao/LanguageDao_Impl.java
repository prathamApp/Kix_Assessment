package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Language;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class LanguageDao_Impl implements LanguageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Language;

  public LanguageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Language = new EntityInsertionAdapter<Modal_Language>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Language`(`languageId`,`languageCode`,`languageName`,`countryName`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Language value) {
        if (value.getLanguageId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getLanguageId());
        }
        if (value.getLanguageCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLanguageCode());
        }
        if (value.getLanguageName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLanguageName());
        }
        if (value.getCountryName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCountryName());
        }
      }
    };
  }

  @Override
  public void insertLanguage(Modal_Language language) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Language.insert(language);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Modal_Language> getAllLanguage() {
    final String _sql = "SELECT * FROM Language";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfLanguageId = _cursor.getColumnIndexOrThrow("languageId");
      final int _cursorIndexOfLanguageCode = _cursor.getColumnIndexOrThrow("languageCode");
      final int _cursorIndexOfLanguageName = _cursor.getColumnIndexOrThrow("languageName");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final List<Modal_Language> _result = new ArrayList<Modal_Language>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Language _item;
        _item = new Modal_Language();
        final Integer _tmpLanguageId;
        if (_cursor.isNull(_cursorIndexOfLanguageId)) {
          _tmpLanguageId = null;
        } else {
          _tmpLanguageId = _cursor.getInt(_cursorIndexOfLanguageId);
        }
        _item.setLanguageId(_tmpLanguageId);
        final String _tmpLanguageCode;
        _tmpLanguageCode = _cursor.getString(_cursorIndexOfLanguageCode);
        _item.setLanguageCode(_tmpLanguageCode);
        final String _tmpLanguageName;
        _tmpLanguageName = _cursor.getString(_cursorIndexOfLanguageName);
        _item.setLanguageName(_tmpLanguageName);
        final String _tmpCountryName;
        _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
        _item.setCountryName(_tmpCountryName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getLanguageList(String countryName) {
    final String _sql = "SELECT languageName FROM Language where countryName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (countryName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, countryName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
