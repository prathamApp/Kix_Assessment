package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class SurveyorDao_Impl implements SurveyorDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Surveyor;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentSurveyorFlags;

  public SurveyorDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Surveyor = new EntityInsertionAdapter<Modal_Surveyor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Surveyor`(`Svr_Id`,`Svr_Name`,`Svr_Email`,`Svr_Mobile`,`Svr_Password`,`Svr_Code`,`Svr_Booklet`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Surveyor value) {
        stmt.bindLong(1, value.Svr_Id);
        if (value.Svr_Name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.Svr_Name);
        }
        if (value.Svr_Email == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.Svr_Email);
        }
        if (value.Svr_Mobile == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.Svr_Mobile);
        }
        if (value.Svr_Password == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.Svr_Password);
        }
        if (value.Svr_Code == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.Svr_Code);
        }
        if (value.Svr_Booklet == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.Svr_Booklet);
        }
        stmt.bindLong(8, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateSentSurveyorFlags = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Surveyor set sentFlag=1 where Svr_Code=?";
        return _query;
      }
    };
  }

  @Override
  public void insertSurveyor(Modal_Surveyor modal_surveyor) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Surveyor.insert(modal_surveyor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSentSurveyorFlags(String svrCode) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentSurveyorFlags.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (svrCode == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, svrCode);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentSurveyorFlags.release(_stmt);
    }
  }

  @Override
  public Modal_Surveyor getSurveyorByEmail(String email) {
    final String _sql = "SELECT * FROM Surveyor WHERE Svr_Email=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSvrId = _cursor.getColumnIndexOrThrow("Svr_Id");
      final int _cursorIndexOfSvrName = _cursor.getColumnIndexOrThrow("Svr_Name");
      final int _cursorIndexOfSvrEmail = _cursor.getColumnIndexOrThrow("Svr_Email");
      final int _cursorIndexOfSvrMobile = _cursor.getColumnIndexOrThrow("Svr_Mobile");
      final int _cursorIndexOfSvrPassword = _cursor.getColumnIndexOrThrow("Svr_Password");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final int _cursorIndexOfSvrBooklet = _cursor.getColumnIndexOrThrow("Svr_Booklet");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Surveyor _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Surveyor();
        _result.Svr_Id = _cursor.getInt(_cursorIndexOfSvrId);
        _result.Svr_Name = _cursor.getString(_cursorIndexOfSvrName);
        _result.Svr_Email = _cursor.getString(_cursorIndexOfSvrEmail);
        _result.Svr_Mobile = _cursor.getString(_cursorIndexOfSvrMobile);
        _result.Svr_Password = _cursor.getString(_cursorIndexOfSvrPassword);
        _result.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
        _result.Svr_Booklet = _cursor.getString(_cursorIndexOfSvrBooklet);
        _result.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
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
  public Modal_Surveyor getSurveyorLogin(String email, String password) {
    final String _sql = "SELECT * FROM Surveyor WHERE Svr_Email=? and Svr_Password=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSvrId = _cursor.getColumnIndexOrThrow("Svr_Id");
      final int _cursorIndexOfSvrName = _cursor.getColumnIndexOrThrow("Svr_Name");
      final int _cursorIndexOfSvrEmail = _cursor.getColumnIndexOrThrow("Svr_Email");
      final int _cursorIndexOfSvrMobile = _cursor.getColumnIndexOrThrow("Svr_Mobile");
      final int _cursorIndexOfSvrPassword = _cursor.getColumnIndexOrThrow("Svr_Password");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final int _cursorIndexOfSvrBooklet = _cursor.getColumnIndexOrThrow("Svr_Booklet");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Surveyor _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Surveyor();
        _result.Svr_Id = _cursor.getInt(_cursorIndexOfSvrId);
        _result.Svr_Name = _cursor.getString(_cursorIndexOfSvrName);
        _result.Svr_Email = _cursor.getString(_cursorIndexOfSvrEmail);
        _result.Svr_Mobile = _cursor.getString(_cursorIndexOfSvrMobile);
        _result.Svr_Password = _cursor.getString(_cursorIndexOfSvrPassword);
        _result.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
        _result.Svr_Booklet = _cursor.getString(_cursorIndexOfSvrBooklet);
        _result.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
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
  public List<Modal_Surveyor> getAllNewSurveyor() {
    final String _sql = "select * from Surveyor where sentFlag = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSvrId = _cursor.getColumnIndexOrThrow("Svr_Id");
      final int _cursorIndexOfSvrName = _cursor.getColumnIndexOrThrow("Svr_Name");
      final int _cursorIndexOfSvrEmail = _cursor.getColumnIndexOrThrow("Svr_Email");
      final int _cursorIndexOfSvrMobile = _cursor.getColumnIndexOrThrow("Svr_Mobile");
      final int _cursorIndexOfSvrPassword = _cursor.getColumnIndexOrThrow("Svr_Password");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final int _cursorIndexOfSvrBooklet = _cursor.getColumnIndexOrThrow("Svr_Booklet");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Surveyor> _result = new ArrayList<Modal_Surveyor>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Surveyor _item;
        _item = new Modal_Surveyor();
        _item.Svr_Id = _cursor.getInt(_cursorIndexOfSvrId);
        _item.Svr_Name = _cursor.getString(_cursorIndexOfSvrName);
        _item.Svr_Email = _cursor.getString(_cursorIndexOfSvrEmail);
        _item.Svr_Mobile = _cursor.getString(_cursorIndexOfSvrMobile);
        _item.Svr_Password = _cursor.getString(_cursorIndexOfSvrPassword);
        _item.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
        _item.Svr_Booklet = _cursor.getString(_cursorIndexOfSvrBooklet);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
