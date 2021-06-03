package com.kix.assessment.modal_classes;

import java.io.Serializable;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Content")
public class Modal_Content implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public long contentId;
    public String contentCode;
    public String contentFolderName;
    public String contentBooklet;


    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public String getContentCode() {
        return contentCode;
    }

    public void setContentCode(String contentCode) {
        this.contentCode = contentCode;
    }

    public String getContentFolderName() {
        return contentFolderName;
    }

    public void setContentFolderName(String contentFolderName) {
        this.contentFolderName = contentFolderName;
    }

    public String getContentBooklet() {
        return contentBooklet;
    }

    public void setContentBooklet(String contentBooklet) {
        this.contentBooklet = contentBooklet;
    }

}