package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Content;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(List<Modal_Content> contentTableList);

    @Query("select * from Content where contentBooklet like:booklet")
    List<Modal_Content> getContentByBooklet(String booklet);

/*    @Query("WITH split(contentCode,contentBooklet,str) AS (\n" +
            "SELECT contentCode,'',contentBooklet||',' FROM Content\n" +
            "UNION ALL SELECT contentCode,\n" +
            "substr(str,0,instr(str,',')),\n" +
            "substr(str,instr(str,',')+1)\n" +
            "FROM split where str!=''\n" +
            "\n" +
            ")SELECT DISTINCT(contentBooklet) FROM split WHERE contentBooklet!='' ORDER by contentBooklet ASC;\n")*/


}