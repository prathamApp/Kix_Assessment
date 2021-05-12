package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Booklet;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface BookletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBooklet(Modal_Booklet booklet);

    @Query("SELECT * FROM Booklet")
    List<Modal_Booklet> getAllBooklet();

    @Query("SELECT bookletName FROM Booklet where languageName=:languageName")
    List<String> bookletList(String languageName);
}
