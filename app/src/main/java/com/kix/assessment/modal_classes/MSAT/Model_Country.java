
package com.kix.assessment.modal_classes.MSAT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_Country {

    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("MathsBooklet")
    @Expose
    private List<Model_MathsBooklet> mathsBooklet;
    @SerializedName("LangBooklet")
    @Expose
    private List<Model_LangBooklet> langBooklet;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Model_MathsBooklet> getMathsBooklet() {
        return mathsBooklet;
    }

    public void setMathsBooklet(List<Model_MathsBooklet> mathsBooklet) {
        this.mathsBooklet = mathsBooklet;
    }

    public List<Model_LangBooklet> getLangBooklet() {
        return langBooklet;
    }

    public void setLangBooklet(List<Model_LangBooklet> langBooklet) {
        this.langBooklet = langBooklet;
    }

}
