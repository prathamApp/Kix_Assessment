package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Log;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface LogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLog(Modal_Log log);

    @Insert
    void insertAllLogs(List<Modal_Log> log);

    @Query("DELETE FROM Logs")
    void deleteLogs();

    @Query("select * from Logs where sentFlag=0 AND sessionId=:s_id")
    List<Modal_Log> getAllLogs(String s_id);

    @Query("select * from Logs where sentFlag=0")
    List<Modal_Log> getAllLogs();

    @Query("update Logs set sentFlag=1 where sentFlag=0")
    void updateSentFlag();
}