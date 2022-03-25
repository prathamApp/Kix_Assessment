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

    @Query("SELECT * FROM Household WHERE svrCode=:svrCode AND villageId=:villageId")
    List<Modal_Household> getAllHouseholdBySurveyorCode(String svrCode, String villageId);

    @Query("SELECT * FROM Household WHERE svrCode=:svrCode AND villageId =:villageId ORDER BY householdId DESC")
    List<Modal_Household> getAllHouseholdBySurveyorCodeDescending(String svrCode, String villageId);

    @Query("select * from Household where sentFlag = 0")
    List<Modal_Household> getAllNewHouseholds();

    @Query("SELECT householdName FROM Household WHERE svrCode=:svrCode")
    List<String> getAllHouseholdNameBySurveyorCode(String svrCode);

//    @Query("update Household set sentFlag=1 where householdId=:householdId")
//    void updateSentHouseholdFlags(String householdId);

    @Query("update Household set sentFlag=1 where sentFlag=0")
    void updateSentFlag();
}
