package com.kix.assessment.modal_classes.MSAT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_LangStage {

    @SerializedName("stage")
    @Expose
    private Integer stage;
    @SerializedName("levels")
    @Expose
    private List<Model_LangLevel> levels;

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public List<Model_LangLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<Model_LangLevel> levels) {
        this.levels = levels;
    }

}
