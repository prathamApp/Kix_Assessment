package com.kix.assessment.modal_classes.MSAT;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_MathsGame {

    @SerializedName("gametype")
    @Expose
    private String gametype;
    @SerializedName("gamename")
    @Expose
    private String gamename;
    @SerializedName("folder")
    @Expose
    private String folder;

    public String getGametype() {
        return this.gametype;
    }

    public void setGametype(final String gametype) {
        this.gametype = gametype;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

}
