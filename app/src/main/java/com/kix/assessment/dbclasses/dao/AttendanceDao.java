package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Attendance;

import java.util.List;

@Dao
public interface AttendanceDao {
    @Insert
    void insertAttendance(List<Attendance> attendancesList);

    @Query("DELETE FROM Attendance")
    void deleteAllAttendances();

    @Query("SELECT * FROM Attendance")
    List<Attendance> getAllAttendances();

    @Query("SELECT * FROM Attendance WHERE sentFlag=0 AND sessionId=:s_id")
    List<Attendance> getNewAttendances(String s_id);

    @Query("SELECT * FROM Attendance WHERE sentFlag=0")
    List<Attendance> getNewAttendances();

    @Query("UPDATE Attendance SET sentFlag=1 WHERE sessionId=:s_id")
    void updateSentFlag(String s_id);
}
