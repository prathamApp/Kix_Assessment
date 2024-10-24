package com.kix.assessment.modal_classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Score")
public class Score implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "scoreId")
    private int scoreId;
    @ColumnInfo(name = "sessionId")
    private String sessionId;
    @ColumnInfo(name = "studentId")
    private String studentId;
    @ColumnInfo(name = "deviceId")
    private String deviceId;
    @ColumnInfo(name = "resourceId")
    private String resourceId;
    @ColumnInfo(name = "scoredMarks")
    private String scoredMarks;
    @ColumnInfo(name = "startDateTime")
    private String startDateTime;
    @ColumnInfo(name = "endDateTime")
    private String endDateTime;
    @ColumnInfo(name = "label")
    private String label;
    @ColumnInfo(name = "svrCode")
    private String svrCode;
    @ColumnInfo(name = "bookletNo")
    private String bookletNo;
    @ColumnInfo(name = "countryName")
    private String countryName;
    @ColumnInfo(name = "sentFlag")
    private int sentFlag;


    @Override
    public String toString() {
        return "Score{" +
                "ScoreId='" + scoreId + '\'' +
                ", SessionID='" + sessionId + '\'' +
                ", StudentID='" + studentId + '\'' +
                ", DeviceId='" + deviceId + '\'' +
                ", ResourceID='" + resourceId + '\'' +
                ", ScoredMarks=" + scoredMarks +
                ", StartDateTime='" + startDateTime + '\'' +
                ", EndDateTime='" + endDateTime + '\'' +
                ", svrCode='" + svrCode + '\'' +
                ", bookletNo='" + bookletNo + '\'' +
                ", countryName='" + countryName+ '\'' +
                '}';
    }

    public int getSentFlag() {
        return sentFlag;
    }

    public void setSentFlag(int sentFlag) {
        this.sentFlag = sentFlag;
    }

    @NonNull
    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(@NonNull int scoreId) {
        this.scoreId = scoreId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getScoredMarks() {
        return scoredMarks;
    }

    public void setScoredMarks(String scoredMarks) {
        this.scoredMarks = scoredMarks;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSvrCode() {
        return svrCode;
    }

    public void setSvrCode(String svrCode) {
        this.svrCode = svrCode;
    }

    public String getBookletNo() {
        return bookletNo;
    }

    public void setBookletNo(String bookletNo) {
        this.bookletNo = bookletNo;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
