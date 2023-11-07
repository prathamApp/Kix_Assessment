package com.kix.assessment.modal_classes.MSAT;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_LangBooklet {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Stages")
    @Expose
    private List<Model_LangStage> stages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model_LangStage> getStages() {
        return stages;
    }

    public void setStages(List<Model_LangStage> stages) {
        this.stages = stages;
    }

}
