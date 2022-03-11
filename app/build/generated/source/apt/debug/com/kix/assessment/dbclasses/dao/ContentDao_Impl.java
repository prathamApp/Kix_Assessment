package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Content;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ContentDao_Impl implements ContentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Content;

  public ContentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Content = new EntityInsertionAdapter<Modal_Content>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Content`(`contentId`,`contentCode`,`contentFolderName`,`contentBooklet`,`contentCountry`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Content value) {
        stmt.bindLong(1, value.contentId);
        if (value.contentCode == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.contentCode);
        }
        if (value.contentFolderName == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.contentFolderName);
        }
        if (value.contentBooklet == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.contentBooklet);
        }
        if (value.contentCountry == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.contentCountry);
        }
      }
    };
  }

  @Override
  public long[] insertAll(List<Modal_Content> contentTableList) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfModal_Content.insertAndReturnIdsArray(contentTableList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Modal_Content> getContentByBooklet(String booklet) {
    final String _sql = "select * from Content where contentBooklet like?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (booklet == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, booklet);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfContentId = _cursor.getColumnIndexOrThrow("contentId");
      final int _cursorIndexOfContentCode = _cursor.getColumnIndexOrThrow("contentCode");
      final int _cursorIndexOfContentFolderName = _cursor.getColumnIndexOrThrow("contentFolderName");
      final int _cursorIndexOfContentBooklet = _cursor.getColumnIndexOrThrow("contentBooklet");
      final int _cursorIndexOfContentCountry = _cursor.getColumnIndexOrThrow("contentCountry");
      final List<Modal_Content> _result = new ArrayList<Modal_Content>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Content _item;
        _item = new Modal_Content();
        _item.contentId = _cursor.getLong(_cursorIndexOfContentId);
        _item.contentCode = _cursor.getString(_cursorIndexOfContentCode);
        _item.contentFolderName = _cursor.getString(_cursorIndexOfContentFolderName);
        _item.contentBooklet = _cursor.getString(_cursorIndexOfContentBooklet);
        _item.contentCountry = _cursor.getString(_cursorIndexOfContentCountry);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Modal_Content> getContentByBookletCountry(String booklet, String country) {
    final String _sql = "select * from Content where contentBooklet like? AND contentCountry=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (booklet == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, booklet);
    }
    _argIndex = 2;
    if (country == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, country);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfContentId = _cursor.getColumnIndexOrThrow("contentId");
      final int _cursorIndexOfContentCode = _cursor.getColumnIndexOrThrow("contentCode");
      final int _cursorIndexOfContentFolderName = _cursor.getColumnIndexOrThrow("contentFolderName");
      final int _cursorIndexOfContentBooklet = _cursor.getColumnIndexOrThrow("contentBooklet");
      final int _cursorIndexOfContentCountry = _cursor.getColumnIndexOrThrow("contentCountry");
      final List<Modal_Content> _result = new ArrayList<Modal_Content>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Content _item;
        _item = new Modal_Content();
        _item.contentId = _cursor.getLong(_cursorIndexOfContentId);
        _item.contentCode = _cursor.getString(_cursorIndexOfContentCode);
        _item.contentFolderName = _cursor.getString(_cursorIndexOfContentFolderName);
        _item.contentBooklet = _cursor.getString(_cursorIndexOfContentBooklet);
        _item.contentCountry = _cursor.getString(_cursorIndexOfContentCountry);
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
    final String _sql = "select DISTINCT contentCountry from Content";
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

  @Override
  public List<String> getBooklets(String country) {
    final String _sql = "WITH split(contentCountry,contentCode,contentBooklet,str) AS (SELECT contentCountry,contentCode,'',contentBooklet||',' FROM Content UNION ALL SELECT contentCountry, contentCode, substr(str,0,instr(str,',')), substr(str,instr(str,',')+1) FROM split where str!='' ) SELECT DISTINCT(contentBooklet) FROM split WHERE contentBooklet!='' and contentCountry=? ORDER by contentBooklet ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (country == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, country);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        final String _tmp;
        _tmp = _cursor.getString(0);
        _item = _tmp;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
