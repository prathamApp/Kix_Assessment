package com.kix.assessment.dbclasses;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kix.assessment.modal_classes.Modal_Student;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModal_Student;

  public StudentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModal_Student = new EntityInsertionAdapter<Modal_Student>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Student`(`Stud_Id`,`Stud_Name`,`Stud_Age`,`Stud_Gender`,`Stud_Class`,`Svr_Code`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modal_Student value) {
        stmt.bindLong(1, value.Stud_Id);
        if (value.Stud_Name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.Stud_Name);
        }
        if (value.Stud_Age == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.Stud_Age);
        }
        if (value.Stud_Gender == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.Stud_Gender);
        }
        if (value.Stud_Class == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.Stud_Class);
        }
        if (value.Svr_Code == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.Svr_Code);
        }
      }
    };
  }

  @Override
  public void insertStudent(Modal_Student studentsList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModal_Student.insert(studentsList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Modal_Student getStudentBySurveyorCode(String svrCode) {
    final String _sql = "SELECT * FROM Student WHERE Svr_Code=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudId = _cursor.getColumnIndexOrThrow("Stud_Id");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("Stud_Name");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("Stud_Age");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("Stud_Gender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final Modal_Student _result;
      if(_cursor.moveToFirst()) {
        _result = new Modal_Student();
        _result.Stud_Id = _cursor.getInt(_cursorIndexOfStudId);
        _result.Stud_Name = _cursor.getString(_cursorIndexOfStudName);
        _result.Stud_Age = _cursor.getString(_cursorIndexOfStudAge);
        _result.Stud_Gender = _cursor.getString(_cursorIndexOfStudGender);
        _result.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _result.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
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
  public List<Modal_Student> getAllStudentsBySurveyorCode(String svrCode) {
    final String _sql = "SELECT * FROM Student WHERE Svr_Code=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (svrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, svrCode);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudId = _cursor.getColumnIndexOrThrow("Stud_Id");
      final int _cursorIndexOfStudName = _cursor.getColumnIndexOrThrow("Stud_Name");
      final int _cursorIndexOfStudAge = _cursor.getColumnIndexOrThrow("Stud_Age");
      final int _cursorIndexOfStudGender = _cursor.getColumnIndexOrThrow("Stud_Gender");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfSvrCode = _cursor.getColumnIndexOrThrow("Svr_Code");
      final List<Modal_Student> _result = new ArrayList<Modal_Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Modal_Student _item;
        _item = new Modal_Student();
        _item.Stud_Id = _cursor.getInt(_cursorIndexOfStudId);
        _item.Stud_Name = _cursor.getString(_cursorIndexOfStudName);
        _item.Stud_Age = _cursor.getString(_cursorIndexOfStudAge);
        _item.Stud_Gender = _cursor.getString(_cursorIndexOfStudGender);
        _item.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _item.Svr_Code = _cursor.getString(_cursorIndexOfSvrCode);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
