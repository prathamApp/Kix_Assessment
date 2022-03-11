package com.kix.assessment.modal_classes;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public class Modal_Sort_Booklet {

    public int booklet_No;
    public String booklet_Name;

    public int getBooklet_No() {
        return booklet_No;
    }

    public void setBooklet_No(int booklet_No) {
        this.booklet_No = booklet_No;
    }

    public String getBooklet_Name() {
        return booklet_Name;
    }

    public void setBooklet_Name(String booklet_Name) {
        this.booklet_Name = booklet_Name;
    }
}