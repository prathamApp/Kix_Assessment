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

    @Query("Select * from VillageInformartion where villageId=:villageId")
    Modal_VIF getVIFbyVillageId(String villageId);

    @Query("update VillageInformartion set V01=:v01, V02=:v02, V03=:v03, V04=:v04, V05=:v05," +
            " V06a=:v06a, V06b=:v06b, V07a=:v07a, V07b=:v07b, sentFlag=0 where villageId=:villageId")
    void updateVillage(String v01, String v02, String v03, String v04, String v05, String v06a, String v06b, String v07a, String v07b, String villageId);
}
