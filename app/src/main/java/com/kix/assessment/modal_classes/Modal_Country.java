package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Country")
public class Modal_Country {

    @PrimaryKey
    @SerializedName("countryId")
    private Integer countryId;
    @SerializedName("countryName")
    private String countryName;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}