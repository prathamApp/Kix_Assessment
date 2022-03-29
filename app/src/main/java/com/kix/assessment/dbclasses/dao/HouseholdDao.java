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

    @Query("SELECT * FROM Household WHERE householdId=:householdId AND villageId=:villageId")
    Modal_Household getHouseholdBySurveyorCode(String householdId, String villageId);

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

    @Query("update Household set householdName=:househldName, HH01=:respondentName, HH02=:householdHead, HH03=:memberCount," +
            "HH04=:telephoneNum, HH05a=:haveChildren, HH05b=:noOfChildren, HH06=:speakLang, sentFlag=0" +
            " where householdId=:hId AND villageId=:villageId")
    void updateHousehold(String househldName, String respondentName, String householdHead, String memberCount, String telephoneNum,
                       String haveChildren, String noOfChildren, String speakLang, String hId, String villageId);
}
