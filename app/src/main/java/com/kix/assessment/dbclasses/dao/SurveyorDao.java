package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_Surveyor;

import java.util.List;

@Dao
public interface SurveyorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSurveyor(Modal_Surveyor modal_surveyor);

    @Query("SELECT * FROM Surveyor WHERE svrEmail=:email")
    Modal_Surveyor getSurveyorByEmail(String email);

    @Query("SELECT * FROM Surveyor WHERE svrEmail=:email and svrPassword=:password")
    Modal_Surveyor getSurveyorLogin(String email, String password);

    @Query("select * from Surveyor where sentFlag = 0")
    List<Modal_Surveyor> getAllNewSurveyor();

    @Query("update Surveyor set sentFlag=1 where svrCode=:svrCode")
    void updateSentSurveyorFlags(String svrCode);

    @Query("update Surveyor set svrBooklet=:svrBooklet where svrCode=:svrCode")
    void updateSurveyorBooklet(String svrBooklet, String svrCode);
}
