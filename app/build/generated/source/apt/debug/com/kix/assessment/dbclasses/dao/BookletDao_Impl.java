package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Booklet;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class BookletDao_Impl implements BookletDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Booklet;

  public BookletDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Booklet = new EntityInsertionAdapter<Modal_Booklet>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Booklet`(`bookletId`,`bookletName`,`languageName`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Booklet value) {
        if (value.getBookletId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getBookletId());
        }
        if (value.getBookletName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBookletName());
        }
        if (value.getLanguageName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLanguageName());
        }
      }
    };
  }

  @Override
  public void insertBooklet(Modal_Booklet booklet) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Booklet.insert(booklet);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Modal_Booklet> getAllBooklet() {
    final String _sql = "SELECT * FROM Booklet";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfBookletId = _cursor.getColumnIndexOrThrow("bookletId");
      final int _cursorIndexOfBookletName = _cursor.getColumnIndexOrThrow("bookletName");
      final int _cursorIndexOfLanguageName = _cursor.getColumnIndexOrThrow("languageName");
      final List<Modal_Booklet> _result = new ArrayList<Modal_Booklet>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Booklet _item;
        _item = new Modal_Booklet();
        final Integer _tmpBookletId;
        if (_cursor.isNull(_cursorIndexOfBookletId)) {
          _tmpBookletId = null;
        } else {
          _tmpBookletId = _cursor.getInt(_cursorIndexOfBookletId);
        }
        _item.setBookletId(_tmpBookletId);
        final String _tmpBookletName;
        _tmpBookletName = _cursor.getString(_cursorIndexOfBookletName);
        _item.setBookletName(_tmpBookletName);
        final String _tmpLanguageName;
        _tmpLanguageName = _cursor.getString(_cursorIndexOfLanguageName);
        _item.setLanguageName(_tmpLanguageName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> bookletList(String languageName) {
    final String _sql = "SELECT bookletName FROM Booklet where languageName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (languageName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, languageName);
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
