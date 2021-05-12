package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Booklet")
public class Modal_Booklet {

    @PrimaryKey
    @SerializedName("bookletId")
    private Integer bookletId;
    @SerializedName("bookletName")
    private String bookletName;
    @SerializedName("languageName")
    private String languageName;

    public Integer getBookletId() {
        return bookletId;
    }

    public void setBookletId(Integer bookletId) {
        this.bookletId = bookletId;
    }

    public String getBookletName() {
        return bookletName;
    }

    public void setBookletName(String bookletName) {
        this.bookletName = bookletName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}
