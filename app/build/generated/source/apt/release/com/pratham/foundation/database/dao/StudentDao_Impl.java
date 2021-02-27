package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Student;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfStudent;

  private final EntityInsertionAdapter __insertionAdapterOfStudent_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfStudent;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfStudent;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfSetNewStudentsToOld;

  private final SharedSQLiteStatement __preparedStmtOfSetFlagFalse;

  private final SharedSQLiteStatement __preparedStmtOfDeleteDeletedGrpsStdRecords;

  private final SharedSQLiteStatement __preparedStmtOfDeleteDeletedStdRecords;

  private final SharedSQLiteStatement __preparedStmtOfSetSentFlag;

  private final SharedSQLiteStatement __preparedStmtOfDeletePrathamAll;

  public StudentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStudent = new EntityInsertionAdapter<Student>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Student`(`StudentID`,`FullName`,`Gender`,`Age`,`Stud_Class`,`GroupId`,`GroupName`,`sentFlag`,`DeviceId`,`StudentUID`,`FirstName`,`MiddleName`,`LastName`,`regDate`,`villageName`,`newFlag`,`avatarName`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Student value) {
        if (value.getStudentID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getStudentID());
        }
        if (value.FullName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.FullName);
        }
        if (value.getGender() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGender());
        }
        stmt.bindLong(4, value.getAge());
        if (value.Stud_Class == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.Stud_Class);
        }
        if (value.GroupId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.GroupId);
        }
        if (value.GroupName == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.GroupName);
        }
        stmt.bindLong(8, value.sentFlag);
        if (value.getDeviceId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDeviceId());
        }
        if (value.getStudentUID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStudentUID());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFirstName());
        }
        if (value.getMiddleName() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMiddleName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLastName());
        }
        if (value.getRegDate() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRegDate());
        }
        if (value.getVillageName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getVillageName());
        }
        stmt.bindLong(16, value.getNewFlag());
        if (value.avatarName == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.avatarName);
        }
      }
    };
    this.__insertionAdapterOfStudent_1 = new EntityInsertionAdapter<Student>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Student`(`StudentID`,`FullName`,`Gender`,`Age`,`Stud_Class`,`GroupId`,`GroupName`,`sentFlag`,`DeviceId`,`StudentUID`,`FirstName`,`MiddleName`,`LastName`,`regDate`,`villageName`,`newFlag`,`avatarName`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Student value) {
        if (value.getStudentID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getStudentID());
        }
        if (value.FullName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.FullName);
        }
        if (value.getGender() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGender());
        }
        stmt.bindLong(4, value.getAge());
        if (value.Stud_Class == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.Stud_Class);
        }
        if (value.GroupId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.GroupId);
        }
        if (value.GroupName == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.GroupName);
        }
        stmt.bindLong(8, value.sentFlag);
        if (value.getDeviceId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDeviceId());
        }
        if (value.getStudentUID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStudentUID());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFirstName());
        }
        if (value.getMiddleName() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMiddleName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLastName());
        }
        if (value.getRegDate() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRegDate());
        }
        if (value.getVillageName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getVillageName());
        }
        stmt.bindLong(16, value.getNewFlag());
        if (value.avatarName == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.avatarName);
        }
      }
    };
    this.__deletionAdapterOfStudent = new EntityDeletionOrUpdateAdapter<Student>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Student` WHERE `StudentID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Student value) {
        if (value.getStudentID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getStudentID());
        }
      }
    };
    this.__updateAdapterOfStudent = new EntityDeletionOrUpdateAdapter<Student>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Student` SET `StudentID` = ?,`FullName` = ?,`Gender` = ?,`Age` = ?,`Stud_Class` = ?,`GroupId` = ?,`GroupName` = ?,`sentFlag` = ?,`DeviceId` = ?,`StudentUID` = ?,`FirstName` = ?,`MiddleName` = ?,`LastName` = ?,`regDate` = ?,`villageName` = ?,`newFlag` = ?,`avatarName` = ? WHERE `StudentID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Student value) {
        if (value.getStudentID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getStudentID());
        }
        if (value.FullName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.FullName);
        }
        if (value.getGender() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGender());
        }
        stmt.bindLong(4, value.getAge());
        if (value.Stud_Class == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.Stud_Class);
        }
        if (value.GroupId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.GroupId);
        }
        if (value.GroupName == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.GroupName);
        }
        stmt.bindLong(8, value.sentFlag);
        if (value.getDeviceId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDeviceId());
        }
        if (value.getStudentUID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStudentUID());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFirstName());
        }
        if (value.getMiddleName() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMiddleName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLastName());
        }
        if (value.getRegDate() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRegDate());
        }
        if (value.getVillageName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getVillageName());
        }
        stmt.bindLong(16, value.getNewFlag());
        if (value.avatarName == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.avatarName);
        }
        if (value.getStudentID() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getStudentID());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Student";
        return _query;
      }
    };
    this.__preparedStmtOfSetNewStudentsToOld = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Student set newFlag=0 where newFlag = 1";
        return _query;
      }
    };
    this.__preparedStmtOfSetFlagFalse = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Student set newFlag=0 where StudentID = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteDeletedGrpsStdRecords = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Student WHERE GroupID=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteDeletedStdRecords = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Student WHERE Gender='Deleted'";
        return _query;
      }
    };
    this.__preparedStmtOfSetSentFlag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update Student set newFlag=1 where newFlag=0";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePrathamAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Student WHERE GroupID != 'PS'";
        return _query;
      }
    };
  }

  @Override
  public long insert(Student student) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfStudent.insertAndReturnId(student);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertAll(List<Student> studentList) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfStudent_1.insertAndReturnIdsArray(studentList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Student student) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfStudent.handle(student);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Student student) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfStudent.handle(student);
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
  public void setNewStudentsToOld() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetNewStudentsToOld.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetNewStudentsToOld.release(_stmt);
    }
  }

  @Override
  public void setFlagFalse(String studentID) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetFlagFalse.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (studentID == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, studentID);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetFlagFalse.release(_stmt);
    }
  }

  @Override
  public void deleteDeletedGrpsStdRecords(String grpID) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteDeletedGrpsStdRecords.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (grpID == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, grpID);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteDeletedGrpsStdRecords.release(_stmt);
    }
  }

  @Override
  public void deleteDeletedStdRecords() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteDeletedStdRecords.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteDeletedStdRecords.release(_stmt);
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
  public void deletePrathamAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePrathamAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePrathamAll.release(_stmt);
    }
  }

  @Override
  public Student getStudent(String studentID) {
    final String _sql = "select * from Student where StudentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("Gender");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("Age");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final int _cursorIndexOfStudentUID = _cursor.getColumnIndexOrThrow("StudentUID");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfMiddleName = _cursor.getColumnIndexOrThrow("MiddleName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfRegDate = _cursor.getColumnIndexOrThrow("regDate");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfNewFlag = _cursor.getColumnIndexOrThrow("newFlag");
      final int _cursorIndexOfAvatarName = _cursor.getColumnIndexOrThrow("avatarName");
      final Student _result;
      if(_cursor.moveToFirst()) {
        _result = new Student();
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _result.setStudentID(_tmpStudentID);
        _result.FullName = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _result.setGender(_tmpGender);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        _result.setAge(_tmpAge);
        _result.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _result.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _result.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _result.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _result.setDeviceId(_tmpDeviceId);
        final String _tmpStudentUID;
        _tmpStudentUID = _cursor.getString(_cursorIndexOfStudentUID);
        _result.setStudentUID(_tmpStudentUID);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _result.setFirstName(_tmpFirstName);
        final String _tmpMiddleName;
        _tmpMiddleName = _cursor.getString(_cursorIndexOfMiddleName);
        _result.setMiddleName(_tmpMiddleName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _result.setLastName(_tmpLastName);
        final String _tmpRegDate;
        _tmpRegDate = _cursor.getString(_cursorIndexOfRegDate);
        _result.setRegDate(_tmpRegDate);
        final String _tmpVillageName;
        _tmpVillageName = _cursor.getString(_cursorIndexOfVillageName);
        _result.setVillageName(_tmpVillageName);
        final int _tmpNewFlag;
        _tmpNewFlag = _cursor.getInt(_cursorIndexOfNewFlag);
        _result.setNewFlag(_tmpNewFlag);
        _result.avatarName = _cursor.getString(_cursorIndexOfAvatarName);
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
  public Student addStudent(String studentID) {
    final String _sql = "select * from Student where StudentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("Gender");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("Age");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final int _cursorIndexOfStudentUID = _cursor.getColumnIndexOrThrow("StudentUID");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfMiddleName = _cursor.getColumnIndexOrThrow("MiddleName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfRegDate = _cursor.getColumnIndexOrThrow("regDate");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfNewFlag = _cursor.getColumnIndexOrThrow("newFlag");
      final int _cursorIndexOfAvatarName = _cursor.getColumnIndexOrThrow("avatarName");
      final Student _result;
      if(_cursor.moveToFirst()) {
        _result = new Student();
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _result.setStudentID(_tmpStudentID);
        _result.FullName = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _result.setGender(_tmpGender);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        _result.setAge(_tmpAge);
        _result.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _result.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _result.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _result.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _result.setDeviceId(_tmpDeviceId);
        final String _tmpStudentUID;
        _tmpStudentUID = _cursor.getString(_cursorIndexOfStudentUID);
        _result.setStudentUID(_tmpStudentUID);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _result.setFirstName(_tmpFirstName);
        final String _tmpMiddleName;
        _tmpMiddleName = _cursor.getString(_cursorIndexOfMiddleName);
        _result.setMiddleName(_tmpMiddleName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _result.setLastName(_tmpLastName);
        final String _tmpRegDate;
        _tmpRegDate = _cursor.getString(_cursorIndexOfRegDate);
        _result.setRegDate(_tmpRegDate);
        final String _tmpVillageName;
        _tmpVillageName = _cursor.getString(_cursorIndexOfVillageName);
        _result.setVillageName(_tmpVillageName);
        final int _tmpNewFlag;
        _tmpNewFlag = _cursor.getInt(_cursorIndexOfNewFlag);
        _result.setNewFlag(_tmpNewFlag);
        _result.avatarName = _cursor.getString(_cursorIndexOfAvatarName);
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
  public List<Student> getAllStudents() {
    final String _sql = "select * from Student";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("Gender");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("Age");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final int _cursorIndexOfStudentUID = _cursor.getColumnIndexOrThrow("StudentUID");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfMiddleName = _cursor.getColumnIndexOrThrow("MiddleName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfRegDate = _cursor.getColumnIndexOrThrow("regDate");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfNewFlag = _cursor.getColumnIndexOrThrow("newFlag");
      final int _cursorIndexOfAvatarName = _cursor.getColumnIndexOrThrow("avatarName");
      final List<Student> _result = new ArrayList<Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Student _item;
        _item = new Student();
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.FullName = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        _item.setAge(_tmpAge);
        _item.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpStudentUID;
        _tmpStudentUID = _cursor.getString(_cursorIndexOfStudentUID);
        _item.setStudentUID(_tmpStudentUID);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpMiddleName;
        _tmpMiddleName = _cursor.getString(_cursorIndexOfMiddleName);
        _item.setMiddleName(_tmpMiddleName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        final String _tmpRegDate;
        _tmpRegDate = _cursor.getString(_cursorIndexOfRegDate);
        _item.setRegDate(_tmpRegDate);
        final String _tmpVillageName;
        _tmpVillageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.setVillageName(_tmpVillageName);
        final int _tmpNewFlag;
        _tmpNewFlag = _cursor.getInt(_cursorIndexOfNewFlag);
        _item.setNewFlag(_tmpNewFlag);
        _item.avatarName = _cursor.getString(_cursorIndexOfAvatarName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Student> getAllPSStudents() {
    final String _sql = "select * from Student where GroupId='PS' OR StudentUID='PS' OR MiddleName='PS'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("Gender");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("Age");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final int _cursorIndexOfStudentUID = _cursor.getColumnIndexOrThrow("StudentUID");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfMiddleName = _cursor.getColumnIndexOrThrow("MiddleName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfRegDate = _cursor.getColumnIndexOrThrow("regDate");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfNewFlag = _cursor.getColumnIndexOrThrow("newFlag");
      final int _cursorIndexOfAvatarName = _cursor.getColumnIndexOrThrow("avatarName");
      final List<Student> _result = new ArrayList<Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Student _item;
        _item = new Student();
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.FullName = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        _item.setAge(_tmpAge);
        _item.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpStudentUID;
        _tmpStudentUID = _cursor.getString(_cursorIndexOfStudentUID);
        _item.setStudentUID(_tmpStudentUID);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpMiddleName;
        _tmpMiddleName = _cursor.getString(_cursorIndexOfMiddleName);
        _item.setMiddleName(_tmpMiddleName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        final String _tmpRegDate;
        _tmpRegDate = _cursor.getString(_cursorIndexOfRegDate);
        _item.setRegDate(_tmpRegDate);
        final String _tmpVillageName;
        _tmpVillageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.setVillageName(_tmpVillageName);
        final int _tmpNewFlag;
        _tmpNewFlag = _cursor.getInt(_cursorIndexOfNewFlag);
        _item.setNewFlag(_tmpNewFlag);
        _item.avatarName = _cursor.getString(_cursorIndexOfAvatarName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Student> getGroupwiseStudents(String gID) {
    final String _sql = "SELECT * FROM Student WHERE GroupId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (gID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, gID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("Gender");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("Age");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final int _cursorIndexOfStudentUID = _cursor.getColumnIndexOrThrow("StudentUID");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfMiddleName = _cursor.getColumnIndexOrThrow("MiddleName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfRegDate = _cursor.getColumnIndexOrThrow("regDate");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfNewFlag = _cursor.getColumnIndexOrThrow("newFlag");
      final int _cursorIndexOfAvatarName = _cursor.getColumnIndexOrThrow("avatarName");
      final List<Student> _result = new ArrayList<Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Student _item;
        _item = new Student();
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.FullName = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        _item.setAge(_tmpAge);
        _item.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpStudentUID;
        _tmpStudentUID = _cursor.getString(_cursorIndexOfStudentUID);
        _item.setStudentUID(_tmpStudentUID);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpMiddleName;
        _tmpMiddleName = _cursor.getString(_cursorIndexOfMiddleName);
        _item.setMiddleName(_tmpMiddleName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        final String _tmpRegDate;
        _tmpRegDate = _cursor.getString(_cursorIndexOfRegDate);
        _item.setRegDate(_tmpRegDate);
        final String _tmpVillageName;
        _tmpVillageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.setVillageName(_tmpVillageName);
        final int _tmpNewFlag;
        _tmpNewFlag = _cursor.getInt(_cursorIndexOfNewFlag);
        _item.setNewFlag(_tmpNewFlag);
        _item.avatarName = _cursor.getString(_cursorIndexOfAvatarName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Student> getAllNewStudents() {
    final String _sql = "select * from Student where newFlag = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfStudentID = _cursor.getColumnIndexOrThrow("StudentID");
      final int _cursorIndexOfFullName = _cursor.getColumnIndexOrThrow("FullName");
      final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("Gender");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("Age");
      final int _cursorIndexOfStudClass = _cursor.getColumnIndexOrThrow("Stud_Class");
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfSentFlag = _cursor.getColumnIndexOrThrow("sentFlag");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final int _cursorIndexOfStudentUID = _cursor.getColumnIndexOrThrow("StudentUID");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("FirstName");
      final int _cursorIndexOfMiddleName = _cursor.getColumnIndexOrThrow("MiddleName");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("LastName");
      final int _cursorIndexOfRegDate = _cursor.getColumnIndexOrThrow("regDate");
      final int _cursorIndexOfVillageName = _cursor.getColumnIndexOrThrow("villageName");
      final int _cursorIndexOfNewFlag = _cursor.getColumnIndexOrThrow("newFlag");
      final int _cursorIndexOfAvatarName = _cursor.getColumnIndexOrThrow("avatarName");
      final List<Student> _result = new ArrayList<Student>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Student _item;
        _item = new Student();
        final String _tmpStudentID;
        _tmpStudentID = _cursor.getString(_cursorIndexOfStudentID);
        _item.setStudentID(_tmpStudentID);
        _item.FullName = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        _item.setAge(_tmpAge);
        _item.Stud_Class = _cursor.getString(_cursorIndexOfStudClass);
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.sentFlag = _cursor.getInt(_cursorIndexOfSentFlag);
        final String _tmpDeviceId;
        _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _item.setDeviceId(_tmpDeviceId);
        final String _tmpStudentUID;
        _tmpStudentUID = _cursor.getString(_cursorIndexOfStudentUID);
        _item.setStudentUID(_tmpStudentUID);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpMiddleName;
        _tmpMiddleName = _cursor.getString(_cursorIndexOfMiddleName);
        _item.setMiddleName(_tmpMiddleName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        final String _tmpRegDate;
        _tmpRegDate = _cursor.getString(_cursorIndexOfRegDate);
        _item.setRegDate(_tmpRegDate);
        final String _tmpVillageName;
        _tmpVillageName = _cursor.getString(_cursorIndexOfVillageName);
        _item.setVillageName(_tmpVillageName);
        final int _tmpNewFlag;
        _tmpNewFlag = _cursor.getInt(_cursorIndexOfNewFlag);
        _item.setNewFlag(_tmpNewFlag);
        _item.avatarName = _cursor.getString(_cursorIndexOfAvatarName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getStudentName(String studentID) {
    final String _sql = "select FirstName from Student where StudentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentID);
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
  public String getFullName(String studentID) {
    final String _sql = "select FullName from Student where StudentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentID);
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
  public String getGroupName(String groupID) {
    final String _sql = "select GroupName  from Student where GroupId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, groupID);
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
  public String checkStudent(String studentID) {
    final String _sql = "select FirstName from Student where StudentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentID);
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
  public String getStudentAvatar(String studentID) {
    final String _sql = "select avatarName from Student where StudentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentID);
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
  public String getStudentGender(String studentID) {
    final String _sql = "select Gender from Student where StudentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentID);
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
}
