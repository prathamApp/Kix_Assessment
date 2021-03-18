package com.kix.assessment.modal_classes;

import java.io.Serializable;

public class GameList implements Serializable {


    String code;
    String folder_name;

    public String getCode() {
        return code;
    }

    public void setCode(String game_Code) {
        code = game_Code;
    }

    public String getFolder_Name() {
        return folder_name;
    }

    public void setFolder_Name(String folder_Name) {
        folder_name = folder_Name;
    }
}