package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Student;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Modal_Student studentsList);

    @Query("SELECT * FROM Student WHERE Svr_Code=:svrCode and Household_ID=:householdId")
    Modal_Student getStudentBySurveyorCode(String svrCode, String householdId);

    @Query("SELECT * FROM Student WHERE Svr_Code=:svrCode and Household_ID=:householdId")
    List<Modal_Student> getAllStudentsBySurveyorCode(String svrCode, String householdId);

    @Query("SELECT * FROM Student WHERE Svr_Code=:svrCode")
    List<Modal_Student> getAllStudentsBySurveyor(String svrCode);

}
