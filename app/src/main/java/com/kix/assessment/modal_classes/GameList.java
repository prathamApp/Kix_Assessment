package com.kix.assessment.modal_classes;

import java.io.Serializable;

public class GameList implements Serializable {


    String contentCode;
    String contentFolderName;
    String contentBooklet;

    public String getContentCode() {
        return contentCode;
    }

    public void setContentCode(String game_Code) {
        contentCode = game_Code;
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