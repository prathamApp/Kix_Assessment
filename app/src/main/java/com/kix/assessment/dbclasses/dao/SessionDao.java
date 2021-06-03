package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Session;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Modal_Session session);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Modal_Session> sessions);

    @Query("UPDATE Session SET sentFlag = 1 where sessionId = :s_id")
    int updateFlag(String s_id);

    @Query("UPDATE Session SET sentFlag = 1")
    int updateAllFlag();

    @Delete
    void delete(Modal_Session session);

    @Delete
    void deleteAll(Modal_Session... sessions);

    @Query("select * from Session where sentFlag=0")
    List<Modal_Session> getAllNewSessions();

    @Query("UPDATE Session SET toDate = :toDate where sessionId = :SessionID")
    void UpdateToDate(String SessionID, String toDate);

    @Query("select * from Session where sessionId = :SessionID")
    Modal_Session getSession(String SessionID);

}
