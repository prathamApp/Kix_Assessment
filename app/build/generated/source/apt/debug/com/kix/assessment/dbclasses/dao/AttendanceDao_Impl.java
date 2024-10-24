package com.kix.assessment.dbclasses.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Attendance;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class AttendanceDao_Impl implements AttendanceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAttendance;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllAttendances;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentFlag;

  public AttendanceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAttendance = new EntityInsertionAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Attendance`(`attendanceId`,`sessionId`,`studentId`,`attendanceDate`,`present`,`sentFlag`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.attendanceId);
        if (value.sessionId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.sessionId);
        }
        if (value.studentId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.studentId);
        }
        if (value.attendanceDate == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.attendanceDate);
        }
        stmt.bindLong(5, value.present);
        stmt.bindLong(6, value.sentFlag);
      }
    };
    this.__preparedStmtOfDeleteAllAttendances = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Attendance";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Attendance set sentFlag=1 where sentFlag=0";
        return _query;
      }
    };
  }

  @Override
  public void insertAttendance(List<Attendance> attendancesList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAttendance.insert(attendancesList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllAttendances() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllAttendances.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllAttendances.release(_stmt);
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
  public List<Attendance> getAllAttendances() {
    final String _sql = "SELECT * FROM Attendance";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAttendanceId = _cursor.getColumnIndexOrThrow("attendanceId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfAttendanceDate = _cursor.getColumnIndexOrThrow("attendanceDate");
      final int _cursorIndexOfPresent = _cursor.getColumnIndexOrThrow("present");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Attendance _item;
        _item = new Attendance();
        _item.attendanceId = _cursor.getInt(_cursorIndexOfAttendanceId);
        _item.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.attendanceDate = _cursor.getString(_cursorIndexOfAttendanceDate);
        _item.present = _cursor.getInt(_cursorIndexOfPresent);
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
  public List<Attendance> getNewAttendances(String s_id) {
    final String _sql = "SELECT * FROM Attendance WHERE sentFlag=0 AND sessionId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (s_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s_id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAttendanceId = _cursor.getColumnIndexOrThrow("attendanceId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfAttendanceDate = _cursor.getColumnIndexOrThrow("attendanceDate");
      final int _cursorIndexOfPresent = _cursor.getColumnIndexOrThrow("present");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Attendance _item;
        _item = new Attendance();
        _item.attendanceId = _cursor.getInt(_cursorIndexOfAttendanceId);
        _item.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.attendanceDate = _cursor.getString(_cursorIndexOfAttendanceDate);
        _item.present = _cursor.getInt(_cursorIndexOfPresent);
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
  public List<Attendance> getNewAttendances() {
    final String _sql = "SELECT * FROM Attendance WHERE sentFlag=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAttendanceId = _cursor.getColumnIndexOrThrow("attendanceId");
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfAttendanceDate = _cursor.getColumnIndexOrThrow("attendanceDate");
      final int _cursorIndexOfPresent = _cursor.getColumnIndexOrThrow("present");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Attendance _item;
        _item = new Attendance();
        _item.attendanceId = _cursor.getInt(_cursorIndexOfAttendanceId);
        _item.sessionId = _cursor.getString(_cursorIndexOfSessionId);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.attendanceDate = _cursor.getString(_cursorIndexOfAttendanceDate);
        _item.present = _cursor.getInt(_cursorIndexOfPresent);
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
