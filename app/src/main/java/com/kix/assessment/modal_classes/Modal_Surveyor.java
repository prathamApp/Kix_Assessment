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
    public int sentFlag;

    public String getSvrName() {
        return this.svrName;
    }

    public void setSvrName(final String svrName) {
        this.svrName = svrName;
    }

    public String getSvrEmail() {
        return this.svrEmail;
    }

    public void setSvrEmail(final String svrEmail) {
        this.svrEmail = svrEmail;
    }

    public String getSvrMobile() {
        return this.svrMobile;
    }

    public void setSvrMobile(final String svrMobile) {
        this.svrMobile = svrMobile;
    }

    public String getSvrPassword() {
        return this.svrPassword;
    }

    public void setSvrPassword(final String svrPassword) {
        this.svrPassword = svrPassword;
    }

    public String getSvrCode() { return this.svrCode; }

    public void setSvrCode(final String svrCode) { this.svrCode = svrCode; }

//    public String getSvrBooklet() {
//        return svrBooklet;
//    }
//
//    public void setSvrBooklet(String svrBooklet) {
//        this.svrBooklet = svrBooklet;
//    }

    public String getSvrRegistrationDate() {
        return this.svrRegistrationDate;
    }

    public void setSvrRegistrationDate(final String svrRegistrationDate) {
        this.svrRegistrationDate = svrRegistrationDate;
    }

    public String getSvrCountry() {
        return this.svrCountry;
    }

    public void setSvrCountry(final String svrCountry) {
        this.svrCountry = svrCountry;
    }

    public int getSentFlag() { return this.sentFlag; }

    public void setSentFlag(final int sentFlag) { this.sentFlag = sentFlag; }
}
