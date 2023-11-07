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

    @Query("update Student set CH01=:studName, CH02=:studGender, CH03=:studAge, CH04a=:anyDisability, CH04b=:whichDisability, CH05=:studEnrollment," +
            " CH06a=:studClass, CH06b=:studSchoolType, CH06c=:instructionLang, CH06f=:haveTextBooks, CH06g=:repeatGrade," +
            "CH07a=:isStudentEverEnrolled, CH07b=:studDropoutYear, CH07c=:studDropoutGrade, CH07d=:dropoutReason, CH09a=:paidTution, " +
            "CH09b=:readMaterial, CH08a=:helpChild, CH08b=:mostOften, CH09c=:oftenRead, sentFlag=0 where studentId=:sId")
    void updateStudent(String studName, String studGender, String studAge, String anyDisability, String whichDisability,
                       String studEnrollment, String studClass, String studSchoolType, String instructionLang,
                       String haveTextBooks, String repeatGrade, String isStudentEverEnrolled,
                       String studDropoutYear, String studDropoutGrade, String dropoutReason, String paidTution, String readMaterial,
                       String helpChild, String mostOften, String oftenRead, String sId);

    @Query("update Student set parentId=:parentId, sentFlag=0 where studentId=:sId")
    void addParentId(String parentId, String sId);

    @Query("SELECT * FROM Student WHERE parentId=:parId")
    Modal_Student getStudentByParentId(String parId);
}
