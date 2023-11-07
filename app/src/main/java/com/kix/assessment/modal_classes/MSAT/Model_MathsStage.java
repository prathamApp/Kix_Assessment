package com.kix.assessment.modal_classes.MSAT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_MathsStage {

    @SerializedName("stage")
    @Expose
    private Integer stage;
    @SerializedName("levels")
    @Expose
    private List<Model_MathsLevel> levels;

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public List<Model_MathsLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<Model_MathsLevel> levels) {
        this.levels = levels;
    }

}
