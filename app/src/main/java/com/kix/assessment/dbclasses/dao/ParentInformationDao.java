package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_PIF;

@Dao
public interface ParentInformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertParentInfo(Modal_PIF modal_pif);

    @Query("Select * from ParentInformation where studentId =:studentId")
    Modal_PIF getPIFbyStudentId(String studentId);

    @Query("update ParentInformation set PT01a=:PT01a, PT01b=:PT01b, PT01c=:PT01c, PT01d=:PT01d, PT01e=:PT01e, PT01f=:PT01f,"+
            "PT02a=:PT02a, PT02b=:PT02b, PT02c=:PT02c, PT02d=:PT02d, PT02e=:PT02e, PT02f=:PT02f, sentFlag=0 where studentId=:studentId")
    void updateParent(String PT01a, String PT01b, String PT01c, String PT01d, String PT01e, String PT01f,
                      String PT02a, String PT02b, String PT02c, String PT02d, String PT02e, String PT02f,
                      String studentId);
}
