package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_Household;

import java.util.List;

@Dao
public interface HouseholdDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHousehold(Modal_Household modal_household);

    @Query("SELECT * FROM Household WHERE svrCode=:svrCode")
    Modal_Household getHouseholdBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Household WHERE svrCode=:svrCode")
    List<Modal_Household> getAllHouseholdBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Household WHERE svrCode=:svrCode ORDER BY hhId DESC")
    List<Modal_Household> getAllHouseholdBySurveyorCodeDescending(String svrCode);

    @Query("select * from Household where sentFlag = 0")
    List<Modal_Household> getAllNewHouseholds();

    @Query("SELECT householdName FROM Household WHERE svrCode=:svrCode")
    List<String> getAllHouseholdNameBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Household WHERE householdId=:householdId")
    Modal_Household getVillageByVillId(String householdId);

//    @Query("update Household set sentFlag=1 where householdId=:householdId")
//    void updateSentHouseholdFlags(String householdId);

    @Query("update Household set sentFlag=1 where sentFlag=0")
    void updateSentFlag();

    @Query("update Household set householdName=:householdName, householdDistrict=:householdDistrict, householdState=:householdState, sentFlag=0, countryName=:countryName where householdId=:householdId")
    void updateVillage(String householdName, String householdDistrict, String householdState, String householdId, String countryName);
}
