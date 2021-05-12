package com.kix.assessment.dbclasses.dao;

import com.kix.assessment.modal_classes.Modal_Country;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCountry(Modal_Country country);

    @Query("SELECT * FROM Country")
    List<Modal_Country> getAllCountry();

    @Query("SELECT countryName FROM Country")
    List<String> getCountryList();
}
