package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Crl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class CrlDao_Impl implements CrlDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCrl;

  private final EntityInsertionAdapter __insertionAdapterOfCrl_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCrl;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCrl;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfSetNewCrlToOld;

  public CrlDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCrl = new EntityInsertionAdapter<Crl>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Crl`(`CrlTableId`,`CRLId`,`FirstName`,`LastName`,`UserName`,`Password`,`ProgramId`,`ProgramName`,`Mobile`,`State`,`Email`,`CreatedBy`,`newCrl`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Crl value) {
        stmt.bindLong(1, value.getCrlTableId());
        if (value.getCRLId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCRLId());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastName());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserName());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        stmt.bindLong(7, value.getProgramId());
        if (value.getProgramName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProgramName());
        }
        if (value.getMobile() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMobile());
        }
        if (value.getState() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getState());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEmail());
        }
        if (value.getCreatedBy() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatedBy());
        }
        final int _tmp;
        _tmp = value.isNewCrl() ? 1 : 0;
        stmt.bindLong(13, _tmp);
      }
    };
    this.__insertionAdapterOfCrl_1 = new EntityInsertionAdapter<Crl>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Crl`(`CrlTableId`,`CRLId`,`FirstName`,`LastName`,`UserName`,`Password`,`ProgramId`,`ProgramName`,`Mobile`,`State`,`Email`,`CreatedBy`,`newCrl`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Crl value) {
        stmt.bindLong(1, value.getCrlTableId());
        if (value.getCRLId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCRLId());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastName());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserName());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        stmt.bindLong(7, value.getProgramId());
        if (value.getProgramName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProgramName());
        }
        if (value.getMobile() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMobile());
        }
        if (value.getState() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getState());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEmail());
        }
        if (value.getCreatedBy() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatedBy());
        }
        final int _tmp;
        _tmp = value.isNewCrl() ? 1 : 0;
        stmt.bindLong(13, _tmp);
      }
    };
    this.__deletionAdapterOfCrl = new EntityDeletionOrUpdateAdapter<Crl>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Crl` WHERE `CrlTableId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Crl value) {
        stmt.bindLong(1, value.getCrlTableId());
      }
    };
    this.__updateAdapterOfCrl = new EntityDeletionOrUpdateAdapter<Crl>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Crl` SET `CrlTableId` = ?,`CRLId` = ?,`FirstName` = ?,`LastName` = ?,`UserName` = ?,`Password` = ?,`ProgramId` = ?,`ProgramName` = ?,`Mobile` = ?,`State` = ?,`Email` = ?,`CreatedBy` = ?,`newCrl` = ? WHERE `CrlTableId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Crl value) {
        stmt.bindLong(1, value.getCrlTableId());
        if (value.getCRLId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCRLId());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastName());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserName());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        stmt.bindLong(7, value.getProgramId());
        if (value.getProgramName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProgramName());
        }
        if (value.getMobile() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMobile());
        }
        if (value.getState() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getState());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEmail());
        }
        if (value.getCreatedBy() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatedBy());
        }
        final int _tmp;
        _tmp = value.isNewCrl() ? 1 : 0;
        stmt.bindLong(13, _tmp);
        stmt.bindLong(14, value.getCrlTableId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Crl";
        return _query;
      }
    };
    this.__preparedStmtOfSetNewCrlToOld = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Crl set newCrl = 0 where newCrl = 1";
        return _query;
      }
    };
  }

  @Override
  public long insert(Crl crl) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCrl.insertAndReturnId(crl);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(Crl... crls) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfCrl.insertAndReturnIdsArray(crls);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(List<Crl> crls) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfCrl_1.insertAndReturnIdsArray(crls);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Crl crl) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCrl.handle(crl);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Crl crl) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfCrl.handle(crl);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public void setNewCrlToOld() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetNewCrlToOld.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetNewCrlToOld.release(_stmt);
    }
  }

  @Override
  public Crl getCrl(String crlID) {
    final String _sql = "select * from Crl where CRLId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (crlID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, crlID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCrlTableId = _cursor.getColumnIndexOrThrow("CrlTableId");
      final int _cursorIndexOfCRLId = _cursor.getColumnIndexOrThrow("CRLId");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("UserName");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfProgramName = _cursor.getColumnIndexOrThrow("ProgramName");
      final int _cursorIndexOfMobile = _cursor.getColumnIndexOrThrow("Mobile");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfCreatedBy = _cursor.getColumnIndexOrThrow("CreatedBy");
      final int _cursorIndexOfNewCrl = _cursor.getColumnIndexOrThrow("newCrl");
      final Crl _result;
      if(_cursor.moveToFirst()) {
        _result = new Crl();
        final int _tmpCrlTableId;
        _tmpCrlTableId = _cursor.getInt(_cursorIndexOfCrlTableId);
        _result.setCrlTableId(_tmpCrlTableId);
        final String _tmpCRLId;
        _tmpCRLId = _cursor.getString(_cursorIndexOfCRLId);
        _result.setCRLId(_tmpCRLId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _result.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _result.setLastName(_tmpLastName);
        final String _tmpUserName;
        _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        _result.setUserName(_tmpUserName);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final int _tmpProgramId;
        _tmpProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _result.setProgramId(_tmpProgramId);
        final String _tmpProgramName;
        _tmpProgramName = _cursor.getString(_cursorIndexOfProgramName);
        _result.setProgramName(_tmpProgramName);
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        _result.setMobile(_tmpMobile);
        final String _tmpState;
        _tmpState = _cursor.getString(_cursorIndexOfState);
        _result.setState(_tmpState);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
        _result.setCreatedBy(_tmpCreatedBy);
        final boolean _tmpNewCrl;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfNewCrl);
        _tmpNewCrl = _tmp != 0;
        _result.setNewCrl(_tmpNewCrl);
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
  public List<Crl> getAllCrls() {
    final String _sql = "select * from Crl";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCrlTableId = _cursor.getColumnIndexOrThrow("CrlTableId");
      final int _cursorIndexOfCRLId = _cursor.getColumnIndexOrThrow("CRLId");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("UserName");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfProgramName = _cursor.getColumnIndexOrThrow("ProgramName");
      final int _cursorIndexOfMobile = _cursor.getColumnIndexOrThrow("Mobile");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfCreatedBy = _cursor.getColumnIndexOrThrow("CreatedBy");
      final int _cursorIndexOfNewCrl = _cursor.getColumnIndexOrThrow("newCrl");
      final List<Crl> _result = new ArrayList<Crl>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Crl _item;
        _item = new Crl();
        final int _tmpCrlTableId;
        _tmpCrlTableId = _cursor.getInt(_cursorIndexOfCrlTableId);
        _item.setCrlTableId(_tmpCrlTableId);
        final String _tmpCRLId;
        _tmpCRLId = _cursor.getString(_cursorIndexOfCRLId);
        _item.setCRLId(_tmpCRLId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        final String _tmpUserName;
        _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        _item.setUserName(_tmpUserName);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        final int _tmpProgramId;
        _tmpProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _item.setProgramId(_tmpProgramId);
        final String _tmpProgramName;
        _tmpProgramName = _cursor.getString(_cursorIndexOfProgramName);
        _item.setProgramName(_tmpProgramName);
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        _item.setMobile(_tmpMobile);
        final String _tmpState;
        _tmpState = _cursor.getString(_cursorIndexOfState);
        _item.setState(_tmpState);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
        _item.setCreatedBy(_tmpCreatedBy);
        final boolean _tmpNewCrl;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfNewCrl);
        _tmpNewCrl = _tmp != 0;
        _item.setNewCrl(_tmpNewCrl);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Crl> getAllNewCrls() {
    final String _sql = "select * from Crl where newCrl = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCrlTableId = _cursor.getColumnIndexOrThrow("CrlTableId");
      final int _cursorIndexOfCRLId = _cursor.getColumnIndexOrThrow("CRLId");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("UserName");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfProgramName = _cursor.getColumnIndexOrThrow("ProgramName");
      final int _cursorIndexOfMobile = _cursor.getColumnIndexOrThrow("Mobile");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfCreatedBy = _cursor.getColumnIndexOrThrow("CreatedBy");
      final int _cursorIndexOfNewCrl = _cursor.getColumnIndexOrThrow("newCrl");
      final List<Crl> _result = new ArrayList<Crl>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Crl _item;
        _item = new Crl();
        final int _tmpCrlTableId;
        _tmpCrlTableId = _cursor.getInt(_cursorIndexOfCrlTableId);
        _item.setCrlTableId(_tmpCrlTableId);
        final String _tmpCRLId;
        _tmpCRLId = _cursor.getString(_cursorIndexOfCRLId);
        _item.setCRLId(_tmpCRLId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        final String _tmpUserName;
        _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        _item.setUserName(_tmpUserName);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        final int _tmpProgramId;
        _tmpProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _item.setProgramId(_tmpProgramId);
        final String _tmpProgramName;
        _tmpProgramName = _cursor.getString(_cursorIndexOfProgramName);
        _item.setProgramName(_tmpProgramName);
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        _item.setMobile(_tmpMobile);
        final String _tmpState;
        _tmpState = _cursor.getString(_cursorIndexOfState);
        _item.setState(_tmpState);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
        _item.setCreatedBy(_tmpCreatedBy);
        final boolean _tmpNewCrl;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfNewCrl);
        _tmpNewCrl = _tmp != 0;
        _item.setNewCrl(_tmpNewCrl);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String checkCrls(String uName, String uPass) {
    final String _sql = "select FirstName from Crl where UserName = ? and Password = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uName);
    }
    _argIndex = 2;
    if (uPass == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uPass);
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
  public Crl checkUserValidation(String user, String pass) {
    final String _sql = "SELECT * FROM CRL WHERE UserName=? AND Password=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (user == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, user);
    }
    _argIndex = 2;
    if (pass == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pass);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCrlTableId = _cursor.getColumnIndexOrThrow("CrlTableId");
      final int _cursorIndexOfCRLId = _cursor.getColumnIndexOrThrow("CRLId");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("UserName");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfProgramName = _cursor.getColumnIndexOrThrow("ProgramName");
      final int _cursorIndexOfMobile = _cursor.getColumnIndexOrThrow("Mobile");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfCreatedBy = _cursor.getColumnIndexOrThrow("CreatedBy");
      final int _cursorIndexOfNewCrl = _cursor.getColumnIndexOrThrow("newCrl");
      final Crl _result;
      if(_cursor.moveToFirst()) {
        _result = new Crl();
        final int _tmpCrlTableId;
        _tmpCrlTableId = _cursor.getInt(_cursorIndexOfCrlTableId);
        _result.setCrlTableId(_tmpCrlTableId);
        final String _tmpCRLId;
        _tmpCRLId = _cursor.getString(_cursorIndexOfCRLId);
        _result.setCRLId(_tmpCRLId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _result.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _result.setLastName(_tmpLastName);
        final String _tmpUserName;
        _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        _result.setUserName(_tmpUserName);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final int _tmpProgramId;
        _tmpProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _result.setProgramId(_tmpProgramId);
        final String _tmpProgramName;
        _tmpProgramName = _cursor.getString(_cursorIndexOfProgramName);
        _result.setProgramName(_tmpProgramName);
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        _result.setMobile(_tmpMobile);
        final String _tmpState;
        _tmpState = _cursor.getString(_cursorIndexOfState);
        _result.setState(_tmpState);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
        _result.setCreatedBy(_tmpCreatedBy);
        final boolean _tmpNewCrl;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfNewCrl);
        _tmpNewCrl = _tmp != 0;
        _result.setNewCrl(_tmpNewCrl);
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
  public List<Crl> getAllCRLs() {
    final String _sql = "SELECT * FROM CRL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCrlTableId = _cursor.getColumnIndexOrThrow("CrlTableId");
      final int _cursorIndexOfCRLId = _cursor.getColumnIndexOrThrow("CRLId");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("UserName");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfProgramName = _cursor.getColumnIndexOrThrow("ProgramName");
      final int _cursorIndexOfMobile = _cursor.getColumnIndexOrThrow("Mobile");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfCreatedBy = _cursor.getColumnIndexOrThrow("CreatedBy");
      final int _cursorIndexOfNewCrl = _cursor.getColumnIndexOrThrow("newCrl");
      final List<Crl> _result = new ArrayList<Crl>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Crl _item;
        _item = new Crl();
        final int _tmpCrlTableId;
        _tmpCrlTableId = _cursor.getInt(_cursorIndexOfCrlTableId);
        _item.setCrlTableId(_tmpCrlTableId);
        final String _tmpCRLId;
        _tmpCRLId = _cursor.getString(_cursorIndexOfCRLId);
        _item.setCRLId(_tmpCRLId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        final String _tmpUserName;
        _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        _item.setUserName(_tmpUserName);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        final int _tmpProgramId;
        _tmpProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _item.setProgramId(_tmpProgramId);
        final String _tmpProgramName;
        _tmpProgramName = _cursor.getString(_cursorIndexOfProgramName);
        _item.setProgramName(_tmpProgramName);
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        _item.setMobile(_tmpMobile);
        final String _tmpState;
        _tmpState = _cursor.getString(_cursorIndexOfState);
        _item.setState(_tmpState);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpCreatedBy;
        _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
        _item.setCreatedBy(_tmpCreatedBy);
        final boolean _tmpNewCrl;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfNewCrl);
        _tmpNewCrl = _tmp != 0;
        _item.setNewCrl(_tmpNewCrl);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
