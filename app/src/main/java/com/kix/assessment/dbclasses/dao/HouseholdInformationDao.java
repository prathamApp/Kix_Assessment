package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_HIF;

import java.util.List;

@Dao
public interface HouseholdInformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHouseholdInfo(Modal_HIF modal_hif);

    @Query("select * from HouseholdInformation where sentFlag = 0")
    List<Modal_HIF> getAllNewHIF();

    @Query("Select * from HouseholdInformation where householdId =:householdId")
    Modal_HIF getHIFbyHouseholdId(String householdId);

    @Query("update HouseholdInformation set sentFlag=1 where sentFlag=0")
    void updateSentFlag();

    @Query("update HouseholdInformation set HH06a=:HH06a, HH06b=:HH06b, HH06c=:HH06c, HH06d=:HH06d," +
            " HH07a=:HH07a, HH07b=:HH07b, HH07c=:HH07c, HH07cOther=:HH07cOther, HH07d1=:HH07d1, " +
            "HH07d2=:HH07d2, HH07f=:HH07f, HH07g=:HH07g, HH07h=:HH07h, HH07i=:HH07i, HH07j=:HH07j, HH07k=:HH07k, " +
            "HH07m=:HH07m, HH07n=:HH07n, HH07o=:HH07o, HH07p=:HH07p, HH07q=:HH07q, sentFlag=0 where householdId=:householdId")
    void updateHousehold(String HH06a, String HH06b, String HH06c, String HH06d,
                         String HH07a, String HH07b, String HH07c, String HH07cOther, String HH07d1,
                         String HH07d2, String HH07f, String HH07g, String HH07h, String HH07i, String HH07j, String HH07k,
                         String HH07m, String HH07n, String HH07o, String HH07p, String HH07q, String householdId);

    @Query("select COUNT(*) from HouseholdInformation where householdId=:householdId")
    boolean getHIF(String householdId);

}
