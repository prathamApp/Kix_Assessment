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

    @Query("update Student set CH01=:studName, CH02=:studAge, CH03=:studGender, CH04=:studEnrollment, CH05a=:studClass, CH05b=:studSchoolType," +
            "CH05c=:instructionLang, CH05d=:schoolStatus, CH05e=:schoolActivities, CH05f=:haveTextBooks, CH06a=:isStudentEverEnrolled," +
            "CH06b1=:studDropoutYear, CH06b2=:studDropoutGrade, CH06b3=:dropoutReason, CH07=:everEnrolledInNursary, CH08=:paidTution, sentFlag=0 where studentId=:sId")
    void updateStudent(String studName, String studAge, String studGender, String studEnrollment, String studClass, String studSchoolType,
                       String instructionLang, String schoolStatus, String schoolActivities, String haveTextBooks, String isStudentEverEnrolled,
                       String studDropoutYear, String studDropoutGrade, String dropoutReason, String everEnrolledInNursary,
                       String paidTution, String sId);

}
