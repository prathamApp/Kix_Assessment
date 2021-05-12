package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Language;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface LanguageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLanguage(Modal_Language language);

    @Query("SELECT * FROM Language")
    List<Modal_Language> getAllLanguage();

    @Query("SELECT languageName FROM Language where countryName=:countryName")
    List<String> getLanguageList(String countryName);
}
