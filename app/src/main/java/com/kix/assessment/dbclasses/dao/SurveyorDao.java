package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Surveyor;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SurveyorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSurveyor(Modal_Surveyor modal_surveyor);

    @Query("SELECT * FROM Surveyor WHERE Svr_Email=:email")
    Modal_Surveyor getSurveyorByEmail(String email);

    @Query("SELECT * FROM Surveyor WHERE Svr_Mobile=:mobile")
    Modal_Surveyor getSurveyorByMobile(String mobile);

    @Query("SELECT * FROM Surveyor WHERE Svr_Mobile=:mobile and Svr_Password=:password")
    Modal_Surveyor getSurveyorLogin(String mobile, String password);

    @Query("select * from Surveyor where sentFlag = 0")
    List<Modal_Surveyor> getAllNewSurveyor();

    @Query("update Surveyor set sentFlag=1 where Svr_Code=:svrCode")
    void updateSentSurveyorFlags(String svrCode);
}
