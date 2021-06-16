package com.kix.assessment.modal_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Surveyor")
public class Modal_Surveyor {

    @PrimaryKey(autoGenerate = true)
    public int svrId;
    public String svrName;
    public String svrEmail;
    public String svrMobile;
    public String svrPassword;
    public String svrCode;
    public String svrBooklet;
    public int sentFlag;

    public int getSvrId() {
        return svrId;
    }

    public void setSvrId(int svrId) {
        this.svrId = svrId;
    }

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

    public String getSvrBooklet() {
        return svrBooklet;
    }

    public void setSvrBooklet(String svrBooklet) {
        this.svrBooklet = svrBooklet;
    }

    public int getSentFlag() { return sentFlag; }

    public void setSentFlag(int sentFlag) { this.sentFlag = sentFlag; }
}
