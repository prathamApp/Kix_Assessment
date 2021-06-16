package com.kix.assessment.modal_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Booklet")
public class Modal_Booklet {

    @PrimaryKey
    @SerializedName("bookletId")
    private long bookletId;
    @SerializedName("bookletName")
    private String bookletName;
    @SerializedName("languageName")
    private String languageName;

    public long getBookletId() {
        return bookletId;
    }

    public void setBookletId(long bookletId) {
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
