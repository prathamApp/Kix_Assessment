package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;
import com.kix.assessment.newtemp.ContentTable;

import java.util.ArrayList;

public class Modal_DownloadContent {

    @SerializedName("contentlist")
    ArrayList<ContentTable> nodelist;
    @SerializedName("downloadurl")
    String downloadurl;
    @SerializedName("resourcetype")
    String foldername;

    @Override
    public String toString() {
        return "Modal_DownloadContent{" +
                "nodelist=" + nodelist +
                ", downloadurl='" + downloadurl + '\'' +
                ", foldername='" + foldername + '\'' +
                '}';
    }

    public ArrayList<ContentTable> getNodelist() {
        return nodelist;
    }

    public void setNodelist(ArrayList<ContentTable> nodelist) {
        this.nodelist = nodelist;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }
}
