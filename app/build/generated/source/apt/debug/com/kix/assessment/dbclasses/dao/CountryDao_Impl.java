package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Country;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class CountryDao_Impl implements CountryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Country;

  public CountryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Country = new EntityInsertionAdapter<Modal_Country>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Country`(`countryId`,`countryName`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Country value) {
        stmt.bindLong(1, value.getCountryId());
        if (value.getCountryName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCountryName());
        }
      }
    };
  }

  @Override
  public void insertCountry(Modal_Country country) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Country.insert(country);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Modal_Country> getAllCountry() {
    final String _sql = "SELECT * FROM Country";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCountryId = _cursor.getColumnIndexOrThrow("countryId");
      final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
      final List<Modal_Country> _result = new ArrayList<Modal_Country>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Country _item;
        _item = new Modal_Country();
        final long _tmpCountryId;
        _tmpCountryId = _cursor.getLong(_cursorIndexOfCountryId);
        _item.setCountryId(_tmpCountryId);
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
  public List<String> getCountryList() {
    final String _sql = "SELECT countryName FROM Country";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
