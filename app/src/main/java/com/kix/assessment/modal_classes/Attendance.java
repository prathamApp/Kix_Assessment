package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Attendance {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("attendanceId")
    public int attendanceId;
    @SerializedName("sessionId")
    public String sessionId;
    @SerializedName("studentId")
    public String studentId;
    @SerializedName("date")
    public String date;
    @SerializedName("present")
    public int present;
    @SerializedName("sentFlag")
    public int sentFlag;

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getSentFlag() {
        return sentFlag;
    }

    public void setSentFlag(int sentFlag) {
        this.sentFlag = sentFlag;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
