package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_Village;

import java.util.List;

@Dao
public interface VillageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVillage(Modal_Village modal_village);

    @Query("SELECT * FROM Village WHERE svrCode=:svrCode")
    Modal_Village getVillageBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Village WHERE svrCode=:svrCode")
    List<Modal_Village> getAllVillageBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Village WHERE svrCode=:svrCode")
    List<Modal_Village> getAllVillageBySurveyorCodeDescending(String svrCode);

    @Query("select * from Village where sentFlag = 0")
    List<Modal_Village> getAllNewVillages();

    @Query("SELECT VillageName FROM Village WHERE svrCode=:svrCode")
    List<String> getAllVillageNameBySurveyorCode(String svrCode);

    @Query("SELECT * FROM Village WHERE villageId=:villageId")
    Modal_Village getVillageByVillId(String villageId);

//    @Query("update Village set sentFlag=1 where villageId=:villageId")
//    void Village(String villageId);

    @Query("update Village set sentFlag=1 where sentFlag=0")
    void updateSentFlag();

    @Query("update Village set villageName=:vName, villageDistrict=:vDistrict, villageState=:vState, sentFlag=0, countryName=:countryName, villageBooklet=:booklet where villageId=:vId")
    void updateVillage(String vName, String vDistrict, String vState, String vId, String countryName, String booklet);

    @Query("SELECT villageName from Village WHERE villageName=:villName AND villageState=:stateName AND villageDistrict=:districtName")
    String getVillageName(String villName, String stateName, String districtName);
}
