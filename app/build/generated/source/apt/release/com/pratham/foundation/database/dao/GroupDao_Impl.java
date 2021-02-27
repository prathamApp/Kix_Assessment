package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.Groups;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class GroupDao_Impl implements GroupDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfGroups;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllGroups;

  private final SharedSQLiteStatement __preparedStmtOfDeleteGroupByGrpID;

  public GroupDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGroups = new EntityInsertionAdapter<Groups>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Groups`(`GroupId`,`GroupName`,`VillageId`,`ProgramId`,`GroupCode`,`SchoolName`,`VIllageName`,`DeviceId`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Groups value) {
        if (value.GroupId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.GroupId);
        }
        if (value.GroupName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.GroupName);
        }
        if (value.VillageId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.VillageId);
        }
        stmt.bindLong(4, value.ProgramId);
        if (value.GroupCode == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.GroupCode);
        }
        if (value.SchoolName == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.SchoolName);
        }
        if (value.VIllageName == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.VIllageName);
        }
        if (value.DeviceId == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.DeviceId);
        }
      }
    };
    this.__preparedStmtOfDeleteAllGroups = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Groups";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteGroupByGrpID = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Groups WHERE GroupID=?";
        return _query;
      }
    };
  }

  @Override
  public void insertAllGroups(List<Groups> groupsList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroups.insert(groupsList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Groups groups) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroups.insert(groups);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllGroups() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllGroups.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllGroups.release(_stmt);
    }
  }

  @Override
  public void deleteGroupByGrpID(String grpID) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteGroupByGrpID.acquire();
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
      __preparedStmtOfDeleteGroupByGrpID.release(_stmt);
    }
  }

  @Override
  public List<Groups> getAllGroups() {
    final String _sql = "SELECT * FROM Groups ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("VillageId");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfGroupCode = _cursor.getColumnIndexOrThrow("GroupCode");
      final int _cursorIndexOfSchoolName = _cursor.getColumnIndexOrThrow("SchoolName");
      final int _cursorIndexOfVIllageName = _cursor.getColumnIndexOrThrow("VIllageName");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final List<Groups> _result = new ArrayList<Groups>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Groups _item;
        _item = new Groups();
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.VillageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.ProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _item.GroupCode = _cursor.getString(_cursorIndexOfGroupCode);
        _item.SchoolName = _cursor.getString(_cursorIndexOfSchoolName);
        _item.VIllageName = _cursor.getString(_cursorIndexOfVIllageName);
        _item.DeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Groups> GetGroups(int vID) {
    final String _sql = "SELECT * FROM Groups WHERE VillageID=? ORDER BY GroupName ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, vID);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("VillageId");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfGroupCode = _cursor.getColumnIndexOrThrow("GroupCode");
      final int _cursorIndexOfSchoolName = _cursor.getColumnIndexOrThrow("SchoolName");
      final int _cursorIndexOfVIllageName = _cursor.getColumnIndexOrThrow("VIllageName");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final List<Groups> _result = new ArrayList<Groups>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Groups _item;
        _item = new Groups();
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.VillageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.ProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _item.GroupCode = _cursor.getString(_cursorIndexOfGroupCode);
        _item.SchoolName = _cursor.getString(_cursorIndexOfSchoolName);
        _item.VIllageName = _cursor.getString(_cursorIndexOfVIllageName);
        _item.DeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Groups> GetStudentsByGroupId(String gID) {
    final String _sql = "SELECT * FROM Groups WHERE GroupId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (gID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, gID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("VillageId");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfGroupCode = _cursor.getColumnIndexOrThrow("GroupCode");
      final int _cursorIndexOfSchoolName = _cursor.getColumnIndexOrThrow("SchoolName");
      final int _cursorIndexOfVIllageName = _cursor.getColumnIndexOrThrow("VIllageName");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final List<Groups> _result = new ArrayList<Groups>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Groups _item;
        _item = new Groups();
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.VillageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.ProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _item.GroupCode = _cursor.getString(_cursorIndexOfGroupCode);
        _item.SchoolName = _cursor.getString(_cursorIndexOfSchoolName);
        _item.VIllageName = _cursor.getString(_cursorIndexOfVIllageName);
        _item.DeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Groups getGroupByGrpID(String grpID) {
    final String _sql = "SELECT * FROM Groups WHERE GroupID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (grpID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, grpID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("VillageId");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfGroupCode = _cursor.getColumnIndexOrThrow("GroupCode");
      final int _cursorIndexOfSchoolName = _cursor.getColumnIndexOrThrow("SchoolName");
      final int _cursorIndexOfVIllageName = _cursor.getColumnIndexOrThrow("VIllageName");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final Groups _result;
      if(_cursor.moveToFirst()) {
        _result = new Groups();
        _result.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _result.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _result.VillageId = _cursor.getString(_cursorIndexOfVillageId);
        _result.ProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _result.GroupCode = _cursor.getString(_cursorIndexOfGroupCode);
        _result.SchoolName = _cursor.getString(_cursorIndexOfSchoolName);
        _result.VIllageName = _cursor.getString(_cursorIndexOfVIllageName);
        _result.DeviceId = _cursor.getString(_cursorIndexOfDeviceId);
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
  public String getGroupNameByGrpID(String grpID) {
    final String _sql = "SELECT GroupName FROM Groups WHERE GroupID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (grpID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, grpID);
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
  public List<Groups> GetAllDeletedGroups() {
    final String _sql = "select * from Groups WHERE DeviceID = 'deleted'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfGroupId = _cursor.getColumnIndexOrThrow("GroupId");
      final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("GroupName");
      final int _cursorIndexOfVillageId = _cursor.getColumnIndexOrThrow("VillageId");
      final int _cursorIndexOfProgramId = _cursor.getColumnIndexOrThrow("ProgramId");
      final int _cursorIndexOfGroupCode = _cursor.getColumnIndexOrThrow("GroupCode");
      final int _cursorIndexOfSchoolName = _cursor.getColumnIndexOrThrow("SchoolName");
      final int _cursorIndexOfVIllageName = _cursor.getColumnIndexOrThrow("VIllageName");
      final int _cursorIndexOfDeviceId = _cursor.getColumnIndexOrThrow("DeviceId");
      final List<Groups> _result = new ArrayList<Groups>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Groups _item;
        _item = new Groups();
        _item.GroupId = _cursor.getString(_cursorIndexOfGroupId);
        _item.GroupName = _cursor.getString(_cursorIndexOfGroupName);
        _item.VillageId = _cursor.getString(_cursorIndexOfVillageId);
        _item.ProgramId = _cursor.getInt(_cursorIndexOfProgramId);
        _item.GroupCode = _cursor.getString(_cursorIndexOfGroupCode);
        _item.SchoolName = _cursor.getString(_cursorIndexOfSchoolName);
        _item.VIllageName = _cursor.getString(_cursorIndexOfVIllageName);
        _item.DeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
