package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Attendance;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class AttendanceDao_Impl implements AttendanceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAttendance;

  private final EntityInsertionAdapter __insertionAdapterOfAttendance_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAttendance;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfAttendance;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  public AttendanceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAttendance = new EntityInsertionAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Attendance`(`attendanceID`,`SessionID`,`StudentID`,`Date`,`GroupID`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.getAttendanceID());
        if (value.getSessionID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionID());
        }
        if (value.getStudentID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentID());
        }
        if (value.Date == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.Date);
        }
        if (value.GroupID == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.GroupID);
        }
        stmt.bindLong(6, value.sentFlag);
      }
    };
    this.__insertionAdapterOfAttendance_1 = new EntityInsertionAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Attendance`(`attendanceID`,`SessionID`,`StudentID`,`Date`,`GroupID`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.getAttendanceID());
        if (value.getSessionID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionID());
        }
        if (value.getStudentID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentID());
        }
        if (value.Date == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.Date);
        }
        if (value.GroupID == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.GroupID);
        }
        stmt.bindLong(6, value.sentFlag);
      }
    };
    this.__deletionAdapterOfAttendance = new EntityDeletionOrUpdateAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Attendance` WHERE `attendanceID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.getAttendanceID());
      }
    };
    this.__updateAdapterOfAttendance = new EntityDeletionOrUpdateAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Attendance` SET `attendanceID` = ?,`SessionID` = ?,`StudentID` = ?,`Date` = ?,`GroupID` = ?,`sentFlag` = ? WHERE `attendanceID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.getAttendanceID());
        if (value.getSessionID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionID());
        }
        if (value.getStudentID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStudentID());
        }
        if (value.Date == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.Date);
        }
        if (value.GroupID == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.GroupID);
        }
        stmt.bindLong(6, value.sentFlag);
        stmt.bindLong(7, value.getAttendanceID());
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Attendance set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
  }

  @Override
  public long insert(Attendance attendance) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAttendance.insertAndReturnId(attendance);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(Attendance... attendances) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfAttendance.insertAndReturnIdsArray(attendances);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(List<Attendance> attendances) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfAttendance.insertAndReturnIdsArray(attendances);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addAttendanceList(List<Attendance> contentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAttendance_1.insert(contentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Attendance attendance) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAttendance.handle(attendance);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(Attendance... attendances) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAttendance.handleMultiple(attendances);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Attendance attendance) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfAttendance.handle(attendance);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
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
  public List<Attendance> getAllAttendanceEntries() {
    final String _sql = "select * from Attendance";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAttendanceID = _cursor.getColumnIndexOrThrow("attendanceID");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfGroupID = _cursor.getColumnIndexOrThrow("GroupID");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Attendance _item;
        _item = new Attendance();
        final int _tmpAttendanceID;
        _tmpAttendanceID = _cursor.getInt(_cursorIndexOfAttendanceID);
        _item.setAttendanceID(_tmpAttendanceID);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.Date = _cursor.getString(_cursorIndexOfDate);
        _item.GroupID = _cursor.getString(_cursorIndexOfGroupID);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Attendance> getAllPushAttendanceEntries() {
    final String _sql = "select * from Attendance where sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAttendanceID = _cursor.getColumnIndexOrThrow("attendanceID");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfGroupID = _cursor.getColumnIndexOrThrow("GroupID");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Attendance _item;
        _item = new Attendance();
        final int _tmpAttendanceID;
        _tmpAttendanceID = _cursor.getInt(_cursorIndexOfAttendanceID);
        _item.setAttendanceID(_tmpAttendanceID);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.Date = _cursor.getString(_cursorIndexOfDate);
        _item.GroupID = _cursor.getString(_cursorIndexOfGroupID);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getStudentBySession(String sessionId) {
    final String _sql = "select StudentID from Attendance where SessionID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sessionId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sessionId);
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
  public List<Attendance> getNewAttendances(String s_id) {
    final String _sql = "SELECT * FROM Attendance WHERE sentFlag=0 AND SessionID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (s_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s_id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAttendanceID = _cursor.getColumnIndexOrThrow("attendanceID");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfGroupID = _cursor.getColumnIndexOrThrow("GroupID");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Attendance _item;
        _item = new Attendance();
        final int _tmpAttendanceID;
        _tmpAttendanceID = _cursor.getInt(_cursorIndexOfAttendanceID);
        _item.setAttendanceID(_tmpAttendanceID);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.Date = _cursor.getString(_cursorIndexOfDate);
        _item.GroupID = _cursor.getString(_cursorIndexOfGroupID);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Attendance> getAllUnSentAttendances() {
    final String _sql = "SELECT * FROM Attendance WHERE sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAttendanceID = _cursor.getColumnIndexOrThrow("attendanceID");
      final int _cursorIndexOfSessionID = _cursor.getColumnIndexOrThrow("SessionID");
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfGroupID = _cursor.getColumnIndexOrThrow("GroupID");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Attendance _item;
        _item = new Attendance();
        final int _tmpAttendanceID;
        _tmpAttendanceID = _cursor.getInt(_cursorIndexOfAttendanceID);
        _item.setAttendanceID(_tmpAttendanceID);
        final String _tmpSessionID;
        _tmpSessionID = _cursor.getString(_cursorIndexOfSessionID);
        _item.setSessionID(_tmpSessionID);
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.Date = _cursor.getString(_cursorIndexOfDate);
        _item.GroupID = _cursor.getString(_cursorIndexOfGroupID);
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
