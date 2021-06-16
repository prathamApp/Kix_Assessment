package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kix.assessment.modal_classes.Modal_StudentDetails;
import com.kix.assessment.modal_classes.Score;

import java.util.List;


@Dao
public interface ScoreDao {

    @Insert
    long insert(Score score);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Score> score);

    @Update
    int update(Score score);

    @Delete
    void delete(Score score);

    @Delete
    void deleteAll(Score... scores);

    @Query("select * from Score")
    List<Score> getAllScores();

    @Query("DELETE FROM Score")
    void deleteAllScores();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addScoreList(List<Score> contentList);

    @Query("select * from Score where studentId=:currentStudentID AND resourceId=:resourceId AND label=:label")
    List<Score> getScoreByStudIDAndResID(String currentStudentID, String resourceId, String label);

    @Query("select * from Score where sentFlag = 0 ")
    List<Score> getAllNotSentScores();

    @Query("select * from Score where sentFlag = 0 AND sessionId=:s_id")
    List<Score> getAllNewScores(String s_id);

    @Query("UPDATE Score SET sentFlag = 1 where sessionId = :s_id")
    int updateFlag(String s_id);

    @Query("select Student.studName as StudentName, Household.householdName as HouseholdName, count(DISTINCT(Score.sessionId)) as ExamsGiven from Score\n" +
            "INNER JOIN Student on Score.studentId = Student.studId\n" +
            "INNER JOIN Household on Household.householdId = Student.householdId\n" +
            "INNER JOIN Surveyor on Surveyor.svrCode= Household.svrCode\n" +
            "WHERE Surveyor.svrCode=:svrCode GROUP by Student.studName, Surveyor.svrName")
    List<Modal_StudentDetails> getProfileData(String svrCode);
}
