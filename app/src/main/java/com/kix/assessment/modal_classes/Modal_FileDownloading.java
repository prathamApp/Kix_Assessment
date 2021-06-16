package com.kix.assessment.modal_classes;

import androidx.annotation.NonNull;


public class Modal_FileDownloading implements Comparable {
	
    String downloadId;
    String filename;
    int progress;
    Modal_Content contentDetail;

    @Override
    public String toString() {
        return "Modal_FileDownloading{" +
                "downloadId=" + downloadId +
                ", filename='" + filename + '\'' +
                ", progress=" + progress +
                ", contentDetail=" + contentDetail +
                '}';
    }

    public Modal_Content getContentDetail() {
        return contentDetail;
    }

    public void setContentDetail(Modal_Content contentDetail) {
        this.contentDetail = contentDetail;
    }

    public String getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(String downloadId) {
        this.downloadId = downloadId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Modal_FileDownloading compare = (Modal_FileDownloading) o;
        if (compare.getContentDetail().getContentCode() != null) {
            if (compare.getDownloadId() == (this.downloadId) && compare.getProgress() == this.progress)
                return 0;
            else return 1;
        } else
            return 0;
    }

}
