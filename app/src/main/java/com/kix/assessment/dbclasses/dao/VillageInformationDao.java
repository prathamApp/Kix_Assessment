package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_VIF;

@Dao
public interface VillageInformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVillageInfo(Modal_VIF modal_vif);

    @Query("update VillageInformartion set sentFlag=1 where sentFlag=0")
    void updateSentFlag();

//    @Query("update Village set villageName=:vName, villageDistrict=:vDistrict, villageState=:vState, sentFlag=0, countryName=:countryName where villageId=:vId")
//    void updateVillage(String vName, String vDistrict, String vState, String vId, String countryName);
}
