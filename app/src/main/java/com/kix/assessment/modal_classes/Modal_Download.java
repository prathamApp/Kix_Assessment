package com.kix.assessment.modal_classes;


import java.util.ArrayList;

public class Modal_Download {
   
   String url;
    String dir_path;
    String f_name;
    String folder_name;
    Modal_Content content;
    ArrayList<Modal_Content> levelContents;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDir_path() {
        return dir_path;
    }

    public void setDir_path(String dir_path) {
        this.dir_path = dir_path;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getFolder_name() {
        return folder_name;
    }

    public void setFolder_name(String folder_name) {
        this.folder_name = folder_name;
    }

    public Modal_Content getContent() {
        return content;
    }

    public void setContent(Modal_Content content) {
        this.content = content;
    }

    public ArrayList<Modal_Content> getLevelContents() {
        return levelContents;
    }

    public void setLevelContents(ArrayList<Modal_Content> levelContents) {
        this.levelContents = levelContents;
    }
}
