package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

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

    @Query("select * from Score where StudentID=:currentStudentID AND ResourceID=:resourceId AND Label=:label")
    List<Score> getScoreByStudIDAndResID(String currentStudentID, String resourceId, String label);

    @Query("select * from Score where sentFlag = 0 ")
    List<Score> getAllNotSentScores();

}