package com.kix.assessment.modal_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Content")
public class Modal_Content implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int contentId;
    public String contentCode;
    public String contentFolderName;
    public String contentBooklet;


    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
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