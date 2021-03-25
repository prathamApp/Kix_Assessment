package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Attendance;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AttendanceDao {
    @Insert
    void insertAttendance(List<Attendance> attendancesList);

    @Query("DELETE FROM Attendance")
    void deleteAllAttendances();

    @Query("SELECT * FROM Attendance")
    List<Attendance> getAllAttendances();

    @Query("SELECT * FROM Attendance WHERE sentFlag=0 AND SessionID=:s_id")
    List<Attendance> getNewAttendances(String s_id);

    @Query("SELECT * FROM Attendance WHERE sentFlag=0")
    List<Attendance> getNewAttendances();
}
