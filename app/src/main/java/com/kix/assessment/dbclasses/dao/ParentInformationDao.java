package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_PIF;

import java.util.List;

@Dao
public interface ParentInformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertParentInfo(Modal_PIF modal_pif);

    @Query("Select * from ParentInformation where parentId =:parentId")
    Modal_PIF getPIFbyParentId(String parentId);

    @Query("Select * from ParentInformation where sentFlag = 0")
    List<Modal_PIF> getAllPIF();

    @Query("update ParentInformation set sentFlag=1 where sentFlag=0")
    void updateSentFlag();

    @Query("update ParentInformation set PT00=:PT00, PT01a=:PT01a, PT01c=:PT01c, PT01d=:PT01d, PT01e=:PT01e, PT01f=:PT01f,"+
            "PT02a=:PT02a, PT02c=:PT02c, PT02d=:PT02d, PT02e=:PT02e, PT02f=:PT02f, sentFlag=0 where parentId=:parentId")
    void updateParent(int PT00, String PT01a, String PT01c, String PT01d, String PT01e, String PT01f,
                      String PT02a, String PT02c, String PT02d, String PT02e, String PT02f,
                      String parentId);

    @Query("select COUNT(*) from ParentInformation where parentId=:parentId")
    boolean getPIF(String parentId);

    @Query("SELECT * FROM ParentInformation WHERE (PT01a!='NA' or PT02a!='NA') AND householdId=:hId")
    List<Modal_PIF> getParentFromHousehold(String hId);
}
