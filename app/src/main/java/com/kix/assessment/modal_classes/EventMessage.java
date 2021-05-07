package com.kix.assessment.modal_classes;

import com.kix.assessment.temp.Modal_FileDownloading;

public class EventMessage {
	
    private String message;
    private String other;
    private String pushData;
    private Modal_FileDownloading modal_fileDownloading;

    public Modal_FileDownloading getModal_fileDownloading() {
        return modal_fileDownloading;
    }

    public void setModal_fileDownloading(Modal_FileDownloading modal_fileDownloading) {
        this.modal_fileDownloading = modal_fileDownloading;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPushData() { return pushData; }

    public void setPushData(String pushData) { this.pushData = pushData; }

}
