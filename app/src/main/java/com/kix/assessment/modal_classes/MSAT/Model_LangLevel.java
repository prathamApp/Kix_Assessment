package com.kix.assessment.modal_classes.MSAT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_LangLevel {

    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("games")
    @Expose
    private List<Model_LangGame> games;
    @SerializedName("cutoff")
    @Expose
    private Integer cutoffscore;


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Model_LangGame> getGames() {
        return games;
    }

    public void setGames(List<Model_LangGame> games) {
        this.games = games;
    }
    public Integer getCutoffscore() {
        return this.cutoffscore;
    }

    public void setCutoffscore(final Integer cutoffscore) {
        this.cutoffscore = cutoffscore;
    }
}
