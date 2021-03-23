package com.kix.assessment.dbclasses.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kix.assessment.modal_classes.Modal_Content;

import java.util.List;

@Dao
public interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(List<Modal_Content> contentTableList);

    @Query("select * from Content where contentBooklet like:booklet")
    List<Modal_Content> getContentByBooklet(String booklet);

}