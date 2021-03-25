package com.kix.assessment.modal_classes;

import java.io.Serializable;

public class GameList implements Serializable {


    String code;
    String folder_name;
    String booklet;

    public String getCode() {
        return code;
    }

    public void setCode(String game_Code) {
        code = game_Code;
    }

    public String getFolder_name() {
        return folder_name;
    }

    public void setFolder_name(String folder_name) {
        this.folder_name = folder_name;
    }

    public String getBooklet() {
        return booklet;
    }

    public void setBooklet(String booklet) {
        this.booklet = booklet;
    }
}