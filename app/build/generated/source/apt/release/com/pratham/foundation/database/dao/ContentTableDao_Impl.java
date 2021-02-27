package com.pratham.foundation.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pratham.foundation.database.domain.ContentTable;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ContentTableDao_Impl implements ContentTableDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfContentTable;

  private final EntityInsertionAdapter __insertionAdapterOfContentTable_1;

  private final EntityInsertionAdapter __insertionAdapterOfContentTable_2;

  private final SharedSQLiteStatement __preparedStmtOfDeleteContent;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ContentTableDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContentTable = new EntityInsertionAdapter<ContentTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ContentTable`(`nodeId`,`level`,`resourceId`,`parentId`,`nodeDesc`,`nodeType`,`nodeEnglishTitle`,`nodeTitle`,`resourcePath`,`resourceType`,`nodeServerImage`,`nodeImage`,`nodeAge`,`contentLanguage`,`version`,`origNodeVersion`,`subject`,`seq_no`,`studentId`,`nodeKeywords`,`isDownloaded`,`contentType`,`onSDCard`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContentTable value) {
        if (value.nodeId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.nodeId);
        }
        if (value.level == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.level);
        }
        if (value.resourceId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.resourceId);
        }
        if (value.parentId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.parentId);
        }
        if (value.nodeDesc == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.nodeDesc);
        }
        if (value.nodeType == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.nodeType);
        }
        if (value.nodeEnglishTitle == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.nodeEnglishTitle);
        }
        if (value.nodeTitle == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.nodeTitle);
        }
        if (value.resourcePath == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.resourcePath);
        }
        if (value.resourceType == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.resourceType);
        }
        if (value.nodeServerImage == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.nodeServerImage);
        }
        if (value.nodeImage == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.nodeImage);
        }
        if (value.nodeAge == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.nodeAge);
        }
        if (value.contentLanguage == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.contentLanguage);
        }
        if (value.version == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.version);
        }
        if (value.origNodeVersion == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.origNodeVersion);
        }
        if (value.subject == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.subject);
        }
        stmt.bindLong(18, value.seq_no);
        if (value.studentId == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.studentId);
        }
        if (value.nodeKeywords == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.nodeKeywords);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.isDownloaded);
        }
        if (value.contentType == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.contentType);
        }
        final int _tmp;
        _tmp = value.isOnSDCard() ? 1 : 0;
        stmt.bindLong(23, _tmp);
      }
    };
    this.__insertionAdapterOfContentTable_1 = new EntityInsertionAdapter<ContentTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ContentTable`(`nodeId`,`level`,`resourceId`,`parentId`,`nodeDesc`,`nodeType`,`nodeEnglishTitle`,`nodeTitle`,`resourcePath`,`resourceType`,`nodeServerImage`,`nodeImage`,`nodeAge`,`contentLanguage`,`version`,`origNodeVersion`,`subject`,`seq_no`,`studentId`,`nodeKeywords`,`isDownloaded`,`contentType`,`onSDCard`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContentTable value) {
        if (value.nodeId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.nodeId);
        }
        if (value.level == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.level);
        }
        if (value.resourceId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.resourceId);
        }
        if (value.parentId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.parentId);
        }
        if (value.nodeDesc == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.nodeDesc);
        }
        if (value.nodeType == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.nodeType);
        }
        if (value.nodeEnglishTitle == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.nodeEnglishTitle);
        }
        if (value.nodeTitle == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.nodeTitle);
        }
        if (value.resourcePath == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.resourcePath);
        }
        if (value.resourceType == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.resourceType);
        }
        if (value.nodeServerImage == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.nodeServerImage);
        }
        if (value.nodeImage == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.nodeImage);
        }
        if (value.nodeAge == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.nodeAge);
        }
        if (value.contentLanguage == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.contentLanguage);
        }
        if (value.version == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.version);
        }
        if (value.origNodeVersion == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.origNodeVersion);
        }
        if (value.subject == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.subject);
        }
        stmt.bindLong(18, value.seq_no);
        if (value.studentId == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.studentId);
        }
        if (value.nodeKeywords == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.nodeKeywords);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.isDownloaded);
        }
        if (value.contentType == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.contentType);
        }
        final int _tmp;
        _tmp = value.isOnSDCard() ? 1 : 0;
        stmt.bindLong(23, _tmp);
      }
    };
    this.__insertionAdapterOfContentTable_2 = new EntityInsertionAdapter<ContentTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `ContentTable`(`nodeId`,`level`,`resourceId`,`parentId`,`nodeDesc`,`nodeType`,`nodeEnglishTitle`,`nodeTitle`,`resourcePath`,`resourceType`,`nodeServerImage`,`nodeImage`,`nodeAge`,`contentLanguage`,`version`,`origNodeVersion`,`subject`,`seq_no`,`studentId`,`nodeKeywords`,`isDownloaded`,`contentType`,`onSDCard`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContentTable value) {
        if (value.nodeId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.nodeId);
        }
        if (value.level == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.level);
        }
        if (value.resourceId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.resourceId);
        }
        if (value.parentId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.parentId);
        }
        if (value.nodeDesc == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.nodeDesc);
        }
        if (value.nodeType == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.nodeType);
        }
        if (value.nodeEnglishTitle == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.nodeEnglishTitle);
        }
        if (value.nodeTitle == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.nodeTitle);
        }
        if (value.resourcePath == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.resourcePath);
        }
        if (value.resourceType == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.resourceType);
        }
        if (value.nodeServerImage == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.nodeServerImage);
        }
        if (value.nodeImage == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.nodeImage);
        }
        if (value.nodeAge == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.nodeAge);
        }
        if (value.contentLanguage == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.contentLanguage);
        }
        if (value.version == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.version);
        }
        if (value.origNodeVersion == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.origNodeVersion);
        }
        if (value.subject == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.subject);
        }
        stmt.bindLong(18, value.seq_no);
        if (value.studentId == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.studentId);
        }
        if (value.nodeKeywords == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.nodeKeywords);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.isDownloaded);
        }
        if (value.contentType == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.contentType);
        }
        final int _tmp;
        _tmp = value.isOnSDCard() ? 1 : 0;
        stmt.bindLong(23, _tmp);
      }
    };
    this.__preparedStmtOfDeleteContent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from ContentTable WHERE nodeid=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from ContentTable";
        return _query;
      }
    };
  }

  @Override
  public long[] insertAll(List<ContentTable> contentTableList) {
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfContentTable.insertAndReturnIdsArray(contentTableList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insert(ContentTable contentTableList) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfContentTable_1.insertAndReturnId(contentTableList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addContentList(List<ContentTable> contentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfContentTable_1.insert(contentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addNewContentList(List<ContentTable> contentList) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfContentTable_2.insert(contentList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteContent(String nodeId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteContent.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (nodeId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, nodeId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteContent.release(_stmt);
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
  public List<ContentTable> getContentData(String parentId, String studentId) {
    final String _sql = "select * from ContentTable where parentId= ? AND (studentId like? OR studentId like'%pratham_group%') order by seq_no";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentId);
    }
    _argIndex = 2;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ContentTable> getTestContentData(String parentId, String contentType) {
    final String _sql = "SELECT * FROM ContentTable WHERE parentId=? AND resourceType=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentId);
    }
    _argIndex = 2;
    if (contentType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, contentType);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getContentDataByTitle(String parentId, String nodetitle) {
    final String _sql = "select nodeId from ContentTable where parentId= ? and nodeTitle=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentId);
    }
    _argIndex = 2;
    if (nodetitle == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nodetitle);
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
  public String getContentDataByNodeAge(String parentId, String nodeAge) {
    final String _sql = "select nodeId from ContentTable where parentId= ? and nodeAge=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentId);
    }
    _argIndex = 2;
    if (nodeAge == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nodeAge);
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
  public List<ContentTable> getNodeData(String nodeId) {
    final String _sql = "select * from ContentTable where nodeId= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nodeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nodeId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ContentTable> getParentsHeaders(String language) {
    final String _sql = "SELECT * FROM ContentTable WHERE parentid ISNULL or parentid = 0 or parentid=''and contentLanguage=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (language == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, language);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ContentTable> getChildsOfParent(String id, String studentId) {
    final String _sql = "SELECT * FROM ContentTable WHERE parentid=? AND (studentId like? OR studentId like'%pratham_group%') ORDER BY seq_no";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    _argIndex = 2;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ContentTable> getChildsOfParent_forDelete(String id) {
    final String _sql = "SELECT * FROM ContentTable WHERE parentid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ContentTable> getChildsOfParent2(String id) {
    final String _sql = "SELECT * FROM ContentTable WHERE parentid=? AND nodeId!='4033'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getChildCountOfParent(String nodeId) {
    final String _sql = "SELECT COUNT(*) from ContentTable WHERE parentId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nodeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nodeId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ContentTable getContent(String id) {
    final String _sql = "SELECT * FROM ContentTable WHERE nodeId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final ContentTable _result;
      if(_cursor.moveToFirst()) {
        _result = new ContentTable();
        _result.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _result.level = _cursor.getString(_cursorIndexOfLevel);
        _result.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _result.parentId = _cursor.getString(_cursorIndexOfParentId);
        _result.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _result.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _result.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _result.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _result.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _result.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _result.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _result.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _result.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _result.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _result.version = _cursor.getString(_cursorIndexOfVersion);
        _result.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _result.subject = _cursor.getString(_cursorIndexOfSubject);
        _result.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _result.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _result.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _result.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _result.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _result.setOnSDCard(_tmpOnSDCard);
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
  public List<ContentTable> getListByResType(String id, String resType) {
    final String _sql = "SELECT * FROM ContentTable WHERE parentid=? and resourceType=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    _argIndex = 2;
    if (resType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resType);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getBottomNavigationId(String currentLanguage, String cosSection) {
    final String _sql = "SELECT nodeId FROM ContentTable WHERE nodeTitle=? and contentLanguage=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cosSection == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cosSection);
    }
    _argIndex = 2;
    if (currentLanguage == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentLanguage);
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
  public String getContentTitleById(String resourceID) {
    final String _sql = "SELECT nodeTitle FROM ContentTable WHERE resourceId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (resourceID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resourceID);
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
  public String getRootData(String nid, String studentId) {
    final String _sql = "SELECT nodeId FROM ContentTable WHERE parentId=? AND (studentId like? OR studentId like'%pratham_group%')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (nid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nid);
    }
    _argIndex = 2;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
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
  public List<ContentTable> getLanguages(String nid, String studentId) {
    final String _sql = "SELECT * FROM ContentTable WHERE parentId=? AND (studentId like? OR studentId like'%pratham_group%')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (nid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nid);
    }
    _argIndex = 2;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNodeId = _cursor.getColumnIndexOrThrow("nodeId");
      final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
      final int _cursorIndexOfResourceId = _cursor.getColumnIndexOrThrow("resourceId");
      final int _cursorIndexOfParentId = _cursor.getColumnIndexOrThrow("parentId");
      final int _cursorIndexOfNodeDesc = _cursor.getColumnIndexOrThrow("nodeDesc");
      final int _cursorIndexOfNodeType = _cursor.getColumnIndexOrThrow("nodeType");
      final int _cursorIndexOfNodeEnglishTitle = _cursor.getColumnIndexOrThrow("nodeEnglishTitle");
      final int _cursorIndexOfNodeTitle = _cursor.getColumnIndexOrThrow("nodeTitle");
      final int _cursorIndexOfResourcePath = _cursor.getColumnIndexOrThrow("resourcePath");
      final int _cursorIndexOfResourceType = _cursor.getColumnIndexOrThrow("resourceType");
      final int _cursorIndexOfNodeServerImage = _cursor.getColumnIndexOrThrow("nodeServerImage");
      final int _cursorIndexOfNodeImage = _cursor.getColumnIndexOrThrow("nodeImage");
      final int _cursorIndexOfNodeAge = _cursor.getColumnIndexOrThrow("nodeAge");
      final int _cursorIndexOfContentLanguage = _cursor.getColumnIndexOrThrow("contentLanguage");
      final int _cursorIndexOfVersion = _cursor.getColumnIndexOrThrow("version");
      final int _cursorIndexOfOrigNodeVersion = _cursor.getColumnIndexOrThrow("origNodeVersion");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfSeqNo = _cursor.getColumnIndexOrThrow("seq_no");
      final int _cursorIndexOfStudentId = _cursor.getColumnIndexOrThrow("studentId");
      final int _cursorIndexOfNodeKeywords = _cursor.getColumnIndexOrThrow("nodeKeywords");
      final int _cursorIndexOfIsDownloaded = _cursor.getColumnIndexOrThrow("isDownloaded");
      final int _cursorIndexOfContentType = _cursor.getColumnIndexOrThrow("contentType");
      final int _cursorIndexOfOnSDCard = _cursor.getColumnIndexOrThrow("onSDCard");
      final List<ContentTable> _result = new ArrayList<ContentTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ContentTable _item;
        _item = new ContentTable();
        _item.nodeId = _cursor.getString(_cursorIndexOfNodeId);
        _item.level = _cursor.getString(_cursorIndexOfLevel);
        _item.resourceId = _cursor.getString(_cursorIndexOfResourceId);
        _item.parentId = _cursor.getString(_cursorIndexOfParentId);
        _item.nodeDesc = _cursor.getString(_cursorIndexOfNodeDesc);
        _item.nodeType = _cursor.getString(_cursorIndexOfNodeType);
        _item.nodeEnglishTitle = _cursor.getString(_cursorIndexOfNodeEnglishTitle);
        _item.nodeTitle = _cursor.getString(_cursorIndexOfNodeTitle);
        _item.resourcePath = _cursor.getString(_cursorIndexOfResourcePath);
        _item.resourceType = _cursor.getString(_cursorIndexOfResourceType);
        _item.nodeServerImage = _cursor.getString(_cursorIndexOfNodeServerImage);
        _item.nodeImage = _cursor.getString(_cursorIndexOfNodeImage);
        _item.nodeAge = _cursor.getString(_cursorIndexOfNodeAge);
        _item.contentLanguage = _cursor.getString(_cursorIndexOfContentLanguage);
        _item.version = _cursor.getString(_cursorIndexOfVersion);
        _item.origNodeVersion = _cursor.getString(_cursorIndexOfOrigNodeVersion);
        _item.subject = _cursor.getString(_cursorIndexOfSubject);
        _item.seq_no = _cursor.getInt(_cursorIndexOfSeqNo);
        _item.studentId = _cursor.getString(_cursorIndexOfStudentId);
        _item.nodeKeywords = _cursor.getString(_cursorIndexOfNodeKeywords);
        _item.isDownloaded = _cursor.getString(_cursorIndexOfIsDownloaded);
        _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        final boolean _tmpOnSDCard;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfOnSDCard);
        _tmpOnSDCard = _tmp != 0;
        _item.setOnSDCard(_tmpOnSDCard);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
