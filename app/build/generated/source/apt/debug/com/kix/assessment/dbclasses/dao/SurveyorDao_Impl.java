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

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  public SurveyorDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Surveyor = new EntityInsertionAdapter<Modal_Surveyor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Surveyor`(`svrCode`,`svrName`,`svrEmail`,`svrMobile`,`svrPassword`,`svrBooklet`,`svrRegistrationDate`,`svrCountry`,`sentFlag`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Surveyor value) {
        if (value.svrCode == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.svrCode);
        }
        if (value.svrName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.svrName);
        }
        if (value.svrEmail == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.svrEmail);
        }
        if (value.svrMobile == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.svrMobile);
        }
        if (value.svrPassword == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.svrPassword);
        }
        if (value.svrBooklet == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.svrBooklet);
        }
        if (value.svrRegistrationDate == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.svrRegistrationDate);
        }
        if (value.svrCountry == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.svrCountry);
        }
        stmt.bindLong(9, value.sentFlag);
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Surveyor set sentFlag=1 where sentFlag=0";
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
  public Modal_Surveyor getSurveyorByEmail(String email) {
    final String _sql = "SELECT * FROM Surveyor WHERE svrEmail=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSvrName = _cursor.getColumnIndexOrThrow("svrName");
      final int _cursorIndexOfSvrEmail = _cursor.getColumnIndexOrThrow("svrEmail");
      final int _cursorIndexOfSvrMobile = _cursor.getColumnIndexOrThrow("svrMobile");
      final int _cursorIndexOfSvrPassword = _cursor.getColumnIndexOrThrow("svrPassword");
      final int _cursorIndexOfSvrBooklet = _cursor.getColumnIndexOrThrow("svrBooklet");
      final int _cursorIndexOfSvrRegistrationDate = _cursor.getColumnIndexOrThrow("svrRegistrationDate");
      final int _cursorIndexOfSvrCountry = _cursor.getColumnIndexOrThrow("svrCountry");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Surveyor _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Surveyor();
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _result.svrName = _cursor.getString(_cursorIndexOfSvrName);
        _result.svrEmail = _cursor.getString(_cursorIndexOfSvrEmail);
        _result.svrMobile = _cursor.getString(_cursorIndexOfSvrMobile);
        _result.svrPassword = _cursor.getString(_cursorIndexOfSvrPassword);
        _result.svrBooklet = _cursor.getString(_cursorIndexOfSvrBooklet);
        _result.svrRegistrationDate = _cursor.getString(_cursorIndexOfSvrRegistrationDate);
        _result.svrCountry = _cursor.getString(_cursorIndexOfSvrCountry);
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
  public Modal_Surveyor getSurveyorByMobile(String mobile) {
    final String _sql = "SELECT * FROM Surveyor WHERE svrMobile=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (mobile == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mobile);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSvrName = _cursor.getColumnIndexOrThrow("svrName");
      final int _cursorIndexOfSvrEmail = _cursor.getColumnIndexOrThrow("svrEmail");
      final int _cursorIndexOfSvrMobile = _cursor.getColumnIndexOrThrow("svrMobile");
      final int _cursorIndexOfSvrPassword = _cursor.getColumnIndexOrThrow("svrPassword");
      final int _cursorIndexOfSvrBooklet = _cursor.getColumnIndexOrThrow("svrBooklet");
      final int _cursorIndexOfSvrRegistrationDate = _cursor.getColumnIndexOrThrow("svrRegistrationDate");
      final int _cursorIndexOfSvrCountry = _cursor.getColumnIndexOrThrow("svrCountry");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Surveyor _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Surveyor();
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _result.svrName = _cursor.getString(_cursorIndexOfSvrName);
        _result.svrEmail = _cursor.getString(_cursorIndexOfSvrEmail);
        _result.svrMobile = _cursor.getString(_cursorIndexOfSvrMobile);
        _result.svrPassword = _cursor.getString(_cursorIndexOfSvrPassword);
        _result.svrBooklet = _cursor.getString(_cursorIndexOfSvrBooklet);
        _result.svrRegistrationDate = _cursor.getString(_cursorIndexOfSvrRegistrationDate);
        _result.svrCountry = _cursor.getString(_cursorIndexOfSvrCountry);
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
  public Modal_Surveyor getSurveyorLogin(String mobile, String password) {
    final String _sql = "SELECT * FROM Surveyor WHERE svrMobile=? and svrPassword=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (mobile == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mobile);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSvrName = _cursor.getColumnIndexOrThrow("svrName");
      final int _cursorIndexOfSvrEmail = _cursor.getColumnIndexOrThrow("svrEmail");
      final int _cursorIndexOfSvrMobile = _cursor.getColumnIndexOrThrow("svrMobile");
      final int _cursorIndexOfSvrPassword = _cursor.getColumnIndexOrThrow("svrPassword");
      final int _cursorIndexOfSvrBooklet = _cursor.getColumnIndexOrThrow("svrBooklet");
      final int _cursorIndexOfSvrRegistrationDate = _cursor.getColumnIndexOrThrow("svrRegistrationDate");
      final int _cursorIndexOfSvrCountry = _cursor.getColumnIndexOrThrow("svrCountry");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final Modal_Surveyor _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Surveyor();
        _result.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _result.svrName = _cursor.getString(_cursorIndexOfSvrName);
        _result.svrEmail = _cursor.getString(_cursorIndexOfSvrEmail);
        _result.svrMobile = _cursor.getString(_cursorIndexOfSvrMobile);
        _result.svrPassword = _cursor.getString(_cursorIndexOfSvrPassword);
        _result.svrBooklet = _cursor.getString(_cursorIndexOfSvrBooklet);
        _result.svrRegistrationDate = _cursor.getString(_cursorIndexOfSvrRegistrationDate);
        _result.svrCountry = _cursor.getString(_cursorIndexOfSvrCountry);
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
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("svrCode");
      final int _cursorIndexOfSvrName = _cursor.getColumnIndexOrThrow("svrName");
      final int _cursorIndexOfSvrEmail = _cursor.getColumnIndexOrThrow("svrEmail");
      final int _cursorIndexOfSvrMobile = _cursor.getColumnIndexOrThrow("svrMobile");
      final int _cursorIndexOfSvrPassword = _cursor.getColumnIndexOrThrow("svrPassword");
      final int _cursorIndexOfSvrBooklet = _cursor.getColumnIndexOrThrow("svrBooklet");
      final int _cursorIndexOfSvrRegistrationDate = _cursor.getColumnIndexOrThrow("svrRegistrationDate");
      final int _cursorIndexOfSvrCountry = _cursor.getColumnIndexOrThrow("svrCountry");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Modal_Surveyor> _result = new ArrayList<Modal_Surveyor>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Surveyor _item;
        _item = new Modal_Surveyor();
        _item.svrCode = _cursor.getString(_cursorIndexOfSvrCode);
        _item.svrName = _cursor.getString(_cursorIndexOfSvrName);
        _item.svrEmail = _cursor.getString(_cursorIndexOfSvrEmail);
        _item.svrMobile = _cursor.getString(_cursorIndexOfSvrMobile);
        _item.svrPassword = _cursor.getString(_cursorIndexOfSvrPassword);
        _item.svrBooklet = _cursor.getString(_cursorIndexOfSvrBooklet);
        _item.svrRegistrationDate = _cursor.getString(_cursorIndexOfSvrRegistrationDate);
        _item.svrCountry = _cursor.getString(_cursorIndexOfSvrCountry);
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
