package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Session;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class SessionDao_Impl implements SessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSession;

  private final EntityInsertionAdapter __insertionAdapterOfSession_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfSession;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfSession;

  private final SharedSQLiteStatement __preparedStmtOfUpdateToDate;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  public SessionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSession = new EntityInsertionAdapter<Session>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Session`(`SessionID`,`fromDate`,`toDate`,`sentFlag`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Session value) {
        if (value.getSessionID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSessionID());
        }
        if (value.getFromDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFromDate());
        }
        if (value.getToDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getToDate());
        }
        stmt.bindLong(4, value.getSentFlag());
      }
    };
    this.__insertionAdapterOfSession_1 = new EntityInsertionAdapter<Session>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Session`(`SessionID`,`fromDate`,`toDate`,`sentFlag`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Session value) {
        if (value.getSessionID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSessionID());
        }
        if (value.getFromDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFromDate());
        }
        if (value.getToDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getToDate());
        }
        stmt.bindLong(4, value.getSentFlag());
      }
    };
    this.__deletionAdapterOfSession = new EntityDeletionOrUpdateAdapter<Session>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Session` WHERE `SessionID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Session value) {
        if (value.getSessionID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSessionID());
        }
      }
    };
    this.__updateAdapterOfSession = new EntityDeletionOrUpdateAdapter<Session>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Session` SET `SessionID` = ?,`fromDate` = ?,`toDate` = ?,`sentFlag` = ? WHERE `SessionID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Session value) {
        if (value.getSessionID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSessionID());
        }
        if (value.getFromDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFromDate());
        }
        if (value.getToDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getToDate());
        }
        stmt.bindLong(4, value.getSentFlag());
        if (value.getSessionID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSessionID());
        }
      }
    };
    this.__preparedStmtOfUpdateToDate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Session SET toDate = ? where SessionID = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Session SET sentFlag = ? where sentFlag=?";
        return _query;
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Session set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
  }

  @Override
  public long insert(Session session) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSession.insertAndReturnId(session);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<Session> sessions) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSession_1.insert(sessions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addSessionList(List<Session> contentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSession_1.insert(contentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Session session) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfSession.handle(session);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(Session... sessions) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfSession.handleMultiple(sessions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Session session) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfSession.handle(session);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateToDate(String SessionID, String toDate) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateToDate.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (toDate == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, toDate);
      }
      _argIndex = 2;
      if (SessionID == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, SessionID);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateToDate.release(_stmt);
    }
  }

  @Override
  public void UpdateSentFlag(String sentFlagOld, String sentFlagNew) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentFlag.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (sentFlagNew == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, sentFlagNew);
      }
      _argIndex = 2;
      if (sentFlagOld == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, sentFlagOld);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentFlag.release(_stmt);
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
  public List<Session> getAllSessions() {
    final String _sql = "select * from Session";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfFromDate = _cursor.getColumnIndexOrThrow("fromDate");
      final int _cursorIndexOfToDate = _cursor.getColumnIndexOrThrow("toDate");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Session> _result = new ArrayList<Session>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Session _item;
        _item = new Session();
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpFromDate;
        _tmpFromDate = _cursor.getString(_cursorIndexOfFromDate);
        _item.setFromDate(_tmpFromDate);
        final String _tmpToDate;
        _tmpToDate = _cursor.getString(_cursorIndexOfToDate);
        _item.setToDate(_tmpToDate);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Session> getAllNewSessions() {
    final String _sql = "select * from Session where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfFromDate = _cursor.getColumnIndexOrThrow("fromDate");
      final int _cursorIndexOfToDate = _cursor.getColumnIndexOrThrow("toDate");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Session> _result = new ArrayList<Session>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Session _item;
        _item = new Session();
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpFromDate;
        _tmpFromDate = _cursor.getString(_cursorIndexOfFromDate);
        _item.setFromDate(_tmpFromDate);
        final String _tmpToDate;
        _tmpToDate = _cursor.getString(_cursorIndexOfToDate);
        _item.setToDate(_tmpToDate);
        final int _tmpSentFlag;
        _tmpSentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _item.setSentFlag(_tmpSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getToDate(String SessionID) {
    final String _sql = "select toDate from Session where SessionID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (SessionID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, SessionID);
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
  public Cursor getStudentUsageData() {
    final String _sql = "select Firstname, result from Student x inner join (select distinct studentid , sum (seconds) as result from (select distinct a.studentid, a.Firstname, (strftime('%s',(substr(c.toDate, 7, 4)||'-'||substr(c.toDate, 4,2)||'-'||substr(c.toDate, 1,2)||' '||substr(c.toDate,11) )) - strftime('%s',(substr(c.fromDate, 7, 4)||'-'||substr(c.fromDate, 4,2)||'-'||substr(c.fromDate, 1,2)||' '||substr(c.fromDate,11)))) as seconds from Session c, Student a Inner join Attendance b on a.studentid = b.studentid and b.sessionid = c.sessionid) group by Studentid order by result desc) z on x.studentid = z.studentid";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }
}
