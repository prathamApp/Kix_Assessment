package com.kix.assessment.modal_classes;

import java.io.Serializable;

public class GameList implements Serializable {


    String Game_Code;
    String Folder_Name;

    public String getGame_Code() {
        return Game_Code;
    }

    public void setGame_Code(String game_Code) {
        Game_Code = game_Code;
    }

    public String getFolder_Name() {
        return Folder_Name;
    }

    public void setFolder_Name(String folder_Name) {
        Folder_Name = folder_Name;
    }
}