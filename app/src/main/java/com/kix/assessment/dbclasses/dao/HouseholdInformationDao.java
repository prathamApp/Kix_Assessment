package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_HIF;
import com.kix.assessment.modal_classes.Modal_VIF;

@Dao
public interface HouseholdInformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHouseholdInfo(Modal_HIF modal_hif);

    @Query("Select * from HouseholdInformation where householdId =:householdId")
    Modal_HIF getHIFbyHouseholdId(String householdId);

    @Query("update HouseholdInformation set HH07a=:HH07a, HH07b=:HH07b, HH07c=:HH07c, HH07cOther=:HH07cOther, HH07d=:HH07d, " +
            "HH07dOther=:HH07dOther, HH07e=:HH07e, HH07f=:HH07f, HH07g=:HH07g, HH07h=:HH07h, HH07i=:HH07i, HH07j=:HH07j, HH07k=:HH07k, " +
            "HH07l=:HH07l, HH07m=:HH07m, HH07n=:HH07n, HH07o=:HH07o, HH07p=:HH07p, sentFlag=0 where householdId=:householdId")
    void updateHousehold(String HH07a, String HH07b, String HH07c, String HH07cOther, String HH07d, String HH07dOther,
                         String HH07e, String HH07f, String HH07g, String HH07h, String HH07i, String HH07j, String HH07k,
                         String HH07l, String HH07m, String HH07n, String HH07o, String HH07p, String householdId);

}
