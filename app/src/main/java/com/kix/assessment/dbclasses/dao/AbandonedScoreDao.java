package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.Modal_ProfileDetails;

import java.util.List;


@Dao
public interface AbandonedScoreDao {

    @Insert
    long insert(AbandonedScore AbandonedScore);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<AbandonedScore> AbandonedScore);

    @Update
    int update(AbandonedScore AbandonedScore);

    @Delete
    void delete(AbandonedScore AbandonedScore);

    @Delete
    void deleteAll(AbandonedScore... AbandonedScores);

    @Query("select * from AbandonedScore")
    List<AbandonedScore> getAllAbandonedScores();

    @Query("DELETE FROM AbandonedScore")
    void deleteAllAbandonedScores();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAbandonedScoreList(List<AbandonedScore> contentList);

    @Query("select * from AbandonedScore where studentId=:currentStudentID AND resourceId=:resourceId AND label=:label")
    List<AbandonedScore> getAbandonedScoreByStudIDAndResID(String currentStudentID, String resourceId, String label);

    @Query("select * from AbandonedScore where sentFlag = 0 ")
    List<AbandonedScore> getAllNotSentAbandonedScores();

    @Query("select * from AbandonedScore where sentFlag = 0 AND sessionId=:s_id")
    List<AbandonedScore> getAllNewAbandonedScores(String s_id);

    @Query("UPDATE AbandonedScore SET sentFlag = 1 where sessionId = :s_id")
    int updateFlag(String s_id);

    @Query("select Student.CH01 as StudentName, Student.CH03 as StudentAge, Household.householdName as HouseholdName, count(DISTINCT(AbandonedScore.sessionId)) as ExamsGiven from AbandonedScore\n" +
            "INNER JOIN Student on AbandonedScore.studentId = Student.studentId\n" +
            "INNER JOIN Household on Household.householdId = Student.householdId\n" +
            "INNER JOIN Surveyor on Surveyor.svrCode= Household.svrCode\n" +
            "WHERE Surveyor.svrCode=:svrCode GROUP by Student.studentId, Surveyor.svrName")
    List<Modal_ProfileDetails> getProfileData(String svrCode);

    @Query("select studentId from AbandonedScore where studentId=:studId")
    String getStudentId(String studId);

    @Query("select COUNT(*) from AbandonedScore where sentFlag=0")
    boolean getAllPushedAbandonedScoresCount();

    @Query("update AbandonedScore set sentFlag=1 where sentFlag=0")
    void updateSentFlag();
}
