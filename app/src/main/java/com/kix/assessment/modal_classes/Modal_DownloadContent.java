package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Modal_DownloadContent {

    @SerializedName("content")
    ArrayList<Modal_Content> nodelist;
    @SerializedName("downloadURL")
    String downloadurl;

    @Override
    public String toString() {
        return "Modal_DownloadContent{" +
                "nodelist=" + nodelist +
                ", downloadurl='" + downloadurl + '\'' +
                '}';
    }

    public ArrayList<Modal_Content> getNodelist() {
        return nodelist;
    }

    public void setNodelist(ArrayList<Modal_Content> nodelist) {
        this.nodelist = nodelist;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

}
