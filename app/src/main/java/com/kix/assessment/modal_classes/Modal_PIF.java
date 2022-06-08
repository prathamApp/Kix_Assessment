package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ParentInformation")
public class Modal_PIF implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int pifId;
    public String PT01a;//Mother's name
    public String PT01b;//Mother's age
    public String PT01c;//Has the mother ever attended school?
    public String PT01d;//If yes in PT01c, upto what grade has she completed schooling?
    public String PT01e;//Does the mother have an income generating work/job?
    public String PT01f;//If yes in PT01e then, what kind?
    public String PT02a;//Father's name
    public String PT02b;//father's age
    public String PT02c;//Has the father ever attended school?
    public String PT02d;//If yes in PT02c, upto what grade has he completed schooling?
    public String PT02e;//Does the father have an income generating work/job?
    public String PT02f;//If yes in PT02e then, what kind?
    public String studentId;
    public String householdId;
    public static final Creator<Modal_PIF> CREATOR = new Creator<Modal_PIF>() {
        @Override
        public Modal_PIF createFromParcel(final Parcel in) {
            return new Modal_PIF(in);
        }

        @Override
        public Modal_PIF[] newArray(final int size) {
            return new Modal_PIF[size];
        }
    };
    public String info_createdOn;

    public Modal_PIF(){}
    public int sentFlag;

    protected Modal_PIF(final Parcel in) {
        this.pifId = in.readInt();
        this.PT01a = in.readString();
        this.PT01b = in.readString();
        this.PT01c = in.readString();
        this.PT01d = in.readString();
        this.PT01e = in.readString();
        this.PT01f = in.readString();
        this.PT02a = in.readString();
        this.PT02b = in.readString();
        this.PT02c = in.readString();
        this.PT02d = in.readString();
        this.PT02e = in.readString();
        this.PT02f = in.readString();
        this.studentId = in.readString();
        this.householdId = in.readString();
        this.info_createdOn = in.readString();
        this.sentFlag = in.readInt();
    }

    public static Creator<Modal_PIF> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public int compareTo(final Object o) {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(this.pifId);
        dest.writeString(this.PT01a);
        dest.writeString(this.PT01b);
        dest.writeString(this.PT01c);
        dest.writeString(this.PT01d);
        dest.writeString(this.PT01e);
        dest.writeString(this.PT01f);
        dest.writeString(this.PT02a);
        dest.writeString(this.PT02b);
        dest.writeString(this.PT02c);
        dest.writeString(this.PT02d);
        dest.writeString(this.PT02e);
        dest.writeString(this.PT02f);
        dest.writeString(this.studentId);
        dest.writeString(this.householdId);
        dest.writeString(this.info_createdOn);
        dest.writeInt(this.sentFlag);
    }

    public int getPifId() {
        return pifId;
    }

    public void setPifId(int pifId) {
        this.pifId = pifId;
    }

    public String getPT01a() {
        return PT01a;
    }

    public void setPT01a(String PT01a) {
        this.PT01a = PT01a;
    }

    public String getPT01b() {
        return PT01b;
    }

    public void setPT01b(String PT01b) {
        this.PT01b = PT01b;
    }

    public String getPT01c() {
        return PT01c;
    }

    public void setPT01c(String PT01c) {
        this.PT01c = PT01c;
    }

    public String getPT01d() {
        return PT01d;
    }

    public void setPT01d(String PT01d) {
        this.PT01d = PT01d;
    }

    public String getPT01e() {
        return PT01e;
    }

    public void setPT01e(String PT01e) {
        this.PT01e = PT01e;
    }

    public String getPT01f() {
        return PT01f;
    }

    public void setPT01f(String PT01f) {
        this.PT01f = PT01f;
    }

    public String getPT02a() {
        return PT02a;
    }

    public void setPT02a(String PT02a) {
        this.PT02a = PT02a;
    }

    public String getPT02b() {
        return PT02b;
    }

    public void setPT02b(String PT02b) {
        this.PT02b = PT02b;
    }

    public String getPT02c() {
        return PT02c;
    }

    public void setPT02c(String PT02c) {
        this.PT02c = PT02c;
    }

    public String getPT02d() {
        return PT02d;
    }

    public void setPT02d(String PT02d) {
        this.PT02d = PT02d;
    }

    public String getPT02e() {
        return PT02e;
    }

    public void setPT02e(String PT02e) {
        this.PT02e = PT02e;
    }

    public String getPT02f() {
        return PT02f;
    }

    public void setPT02f(String PT02f) {
        this.PT02f = PT02f;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getInfo_createdOn() {
        return info_createdOn;
    }

    public void setInfo_createdOn(String info_createdOn) {
        this.info_createdOn = info_createdOn;
    }

    public int getSentFlag() {
        return sentFlag;
    }

    public void setSentFlag(int sentFlag) {
        this.sentFlag = sentFlag;
    }
}
