package com.kix.assessment.modal_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Surveyor")
public class Modal_Surveyor {

    @PrimaryKey
    @NotNull
    public String svrCode;
    public String svrName;
    public String svrEmail;
    public String svrMobile;
    public String svrPassword;
//    public String svrBooklet;
    public String svrRegistrationDate;
    public String svrCountry;
    public String deviceId;
    public int sentFlag;

    public String getSvrName() {
        return svrName;
    }

    public void setSvrName(String svrName) {
        this.svrName = svrName;
    }

    public String getSvrEmail() {
        return svrEmail;
    }

    public void setSvrEmail(String svrEmail) {
        this.svrEmail = svrEmail;
    }

    public String getSvrMobile() {
        return svrMobile;
    }

    public void setSvrMobile(String svrMobile) {
        this.svrMobile = svrMobile;
    }

    public String getSvrPassword() {
        return svrPassword;
    }

    public void setSvrPassword(String svrPassword) {
        this.svrPassword = svrPassword;
    }

    public String getSvrCode() { return svrCode; }

    public void setSvrCode(String svrCode) { this.svrCode = svrCode; }

//    public String getSvrBooklet() {
//        return svrBooklet;
//    }
//
//    public void setSvrBooklet(String svrBooklet) {
//        this.svrBooklet = svrBooklet;
//    }

    public String getSvrRegistrationDate() {
        return svrRegistrationDate;
    }

    public void setSvrRegistrationDate(String svrRegistrationDate) {
        this.svrRegistrationDate = svrRegistrationDate;
    }

    public String getSvrCountry() {
        return svrCountry;
    }

    public void setSvrCountry(String svrCountry) {
        this.svrCountry = svrCountry;
    }

    public int getSentFlag() { return sentFlag; }

    public void setSentFlag(int sentFlag) { this.sentFlag = sentFlag; }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
