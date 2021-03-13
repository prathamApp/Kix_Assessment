package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_Surveyor;

@Dao
public interface SurveyorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSurveyor(Modal_Surveyor modal_surveyor);

    @Query("SELECT * FROM Surveyor WHERE Svr_Email=:email")
    Modal_Surveyor getSurveyorByEmail(String email);

    @Query("SELECT * FROM Surveyor WHERE Svr_Email=:email and Svr_Password=:password")
    Modal_Surveyor getSurveyorLogin(String email, String password);
}
