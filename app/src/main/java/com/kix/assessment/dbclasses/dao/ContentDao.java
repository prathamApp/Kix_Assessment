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

    @Query("select * from Content where contentBooklet like:booklet AND contentCountry=:country")
    List<Modal_Content> getContentByBookletCountry(String booklet, String country);

    @Query("select DISTINCT contentCountry from Content")
    List<String> getCountryList();

    @Query("WITH split(contentCountry,contentCode,contentBooklet,str)" +
            " AS (SELECT contentCountry,contentCode,'',contentBooklet||',' " +
            "FROM Content UNION ALL SELECT contentCountry, contentCode, " +
            "substr(str,0,instr(str,',')), substr(str,instr(str,',')+1) " +
            "FROM split where str!='' ) SELECT DISTINCT(contentBooklet) " +
            "FROM split WHERE contentBooklet!='' and contentCountry=:country " +
            "ORDER by contentBooklet ASC")
    List<String> getBooklets(String country);


}