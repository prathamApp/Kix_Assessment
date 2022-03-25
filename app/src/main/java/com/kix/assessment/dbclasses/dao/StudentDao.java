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

    @Query("SELECT * FROM Student WHERE svrCode=:svrCode and householdId=:householdId")
    Modal_Student getStudentBySurveyorCode(String svrCode, String householdId);

    @Query("SELECT * FROM Student WHERE svrCode=:svrCode and householdId=:householdId")
    List<Modal_Student> getAllStudentsBySurveyorCode(String svrCode, String householdId);

    @Query("SELECT * FROM Student WHERE svrCode=:svrCode and householdId=:householdId ORDER BY sId DESC")
    List<Modal_Student> getAllStudentsBySurveyorCodeDescending(String svrCode, String householdId);

    @Query("SELECT * FROM Student WHERE svrCode=:svrCode")
    List<Modal_Student> getAllStudentsBySurveyor(String svrCode);

    @Query("select * from Student where sentFlag = 0")
    List<Modal_Student> getAllNewStudents();

    @Query("SELECT * FROM Student WHERE studentId=:studId")
    Modal_Student getStudentByStudId(String studId);

//    @Query("update Student set sentFlag=1 where studentId=:s_id")
//    void updateSentStudentFlags(String s_id);

    @Query("update Student set sentFlag=1 where sentFlag=0")
    void updateSentFlag();

    @Query("update Student set CH01=:studName, CH02=:studAge, CH03=:studGender," +
            "CH05a=:studClass, CH04=:studEnrollment, CH05b=:studSchoolType," +
            "CH06b1=:studDropoutYear, sentFlag=0 where studentId=:sId")
    void updateStudent(String studName, String studAge, String studGender, String studClass,
                       String studEnrollment, String studSchoolType, String studDropoutYear, String sId);

}
