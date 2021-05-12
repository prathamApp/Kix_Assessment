package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Language")
public class Modal_Language {

    @PrimaryKey
    @SerializedName("languageId")
    private Integer languageId;
    @SerializedName("languageCode")
    private String languageCode;
    @SerializedName("languageName")
    private String languageName;
    @SerializedName("countryName")
    private String countryName;

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}