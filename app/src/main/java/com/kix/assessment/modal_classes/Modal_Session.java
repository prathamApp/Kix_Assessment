package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Session")
public class Modal_Session {
    @PrimaryKey
    @NonNull
    @SerializedName("sessionId")
    public String sessionId;
    @SerializedName("fromDate")
    public String fromDate;
    @SerializedName("toDate")
    public String toDate;
    @SerializedName("sentFlag")
    public int sentFlag;

    @NonNull
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(@NonNull String sessionId) {
        this.sessionId = sessionId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getSentFlag() {
        return sentFlag;
    }

    public void setSentFlag(int sentFlag) {
        this.sentFlag = sentFlag;
    }
}
