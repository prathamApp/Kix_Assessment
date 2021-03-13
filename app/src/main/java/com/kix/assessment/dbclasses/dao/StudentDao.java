package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Modal_Student studentsList);

    @Query("SELECT * FROM Student WHERE Svr_Code=:svrCode")
    Modal_Student getStudentBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Student WHERE Svr_Code=:svrCode")
    List<Modal_Student> getAllStudentsBySurveyorCode(String svrCode);

}
