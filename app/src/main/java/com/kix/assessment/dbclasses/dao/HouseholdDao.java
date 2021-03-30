package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Household;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface HouseholdDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHousehold(Modal_Household modal_household);

    @Query("SELECT * FROM Household WHERE Svr_Code=:svrCode")
    Modal_Household getHouseholdBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Household WHERE Svr_Code=:svrCode")
    List<Modal_Household> getAllHouseholdBySurveyorCode(String svrCode);

    @Query("select * from Household where sentFlag = 0")
    List<Modal_Household> getAllNewHouseholds();

    @Query("update Household set sentFlag=1 where houseHold_ID=:householdId")
    void updateSentHouseholdFlags(String householdId);
}
