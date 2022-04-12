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
    public String createdOn;
    public int sentFlag = 0;

    public Modal_PIF(){}

    protected Modal_PIF(Parcel in) {
        pifId = in.readInt();
        PT01a = in.readString();
        PT01b = in.readString();
        PT01c = in.readString();
        PT01d = in.readString();
        PT01e = in.readString();
        PT01f = in.readString();
        PT02a = in.readString();
        PT02b = in.readString();
        PT02c = in.readString();
        PT02d = in.readString();
        PT02e = in.readString();
        PT02f = in.readString();
        studentId = in.readString();
        householdId = in.readString();
        createdOn = in.readString();
        sentFlag = in.readInt();
    }

    public static final Creator<Modal_PIF> CREATOR = new Creator<Modal_PIF>() {
        @Override
        public Modal_PIF createFromParcel(Parcel in) {
            return new Modal_PIF(in);
        }

        @Override
        public Modal_PIF[] newArray(int size) {
            return new Modal_PIF[size];
        }
    };

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pifId);
        dest.writeString(PT01a);
        dest.writeString(PT01b);
        dest.writeString(PT01c);
        dest.writeString(PT01d);
        dest.writeString(PT01e);
        dest.writeString(PT01f);
        dest.writeString(PT02a);
        dest.writeString(PT02b);
        dest.writeString(PT02c);
        dest.writeString(PT02d);
        dest.writeString(PT02e);
        dest.writeString(PT02f);
        dest.writeString(studentId);
        dest.writeString(householdId);
        dest.writeString(createdOn);
        dest.writeInt(sentFlag);
    }

    public int getPifId() {
        return this.pifId;
    }

    public void setPifId(final int pifId) {
        this.pifId = pifId;
    }

    public String getPT01a() {
        return this.PT01a;
    }

    public void setPT01a(final String PT01a) {
        this.PT01a = PT01a;
    }

    public String getPT01b() {
        return this.PT01b;
    }

    public void setPT01b(final String PT01b) {
        this.PT01b = PT01b;
    }

    public String getPT01c() {
        return this.PT01c;
    }

    public void setPT01c(final String PT01c) {
        this.PT01c = PT01c;
    }

    public String getPT01d() {
        return this.PT01d;
    }

    public void setPT01d(final String PT01d) {
        this.PT01d = PT01d;
    }

    public String getPT01e() {
        return this.PT01e;
    }

    public void setPT01e(final String PT01e) {
        this.PT01e = PT01e;
    }

    public String getPT01f() {
        return this.PT01f;
    }

    public void setPT01f(final String PT01f) {
        this.PT01f = PT01f;
    }

    public String getPT02a() {
        return this.PT02a;
    }

    public void setPT02a(final String PT02a) {
        this.PT02a = PT02a;
    }

    public String getPT02b() {
        return this.PT02b;
    }

    public void setPT02b(final String PT02b) {
        this.PT02b = PT02b;
    }

    public String getPT02c() {
        return this.PT02c;
    }

    public void setPT02c(final String PT02c) {
        this.PT02c = PT02c;
    }

    public String getPT02d() {
        return this.PT02d;
    }

    public void setPT02d(final String PT02d) {
        this.PT02d = PT02d;
    }

    public String getPT02e() {
        return this.PT02e;
    }

    public void setPT02e(final String PT02e) {
        this.PT02e = PT02e;
    }

    public String getPT02f() {
        return this.PT02f;
    }

    public void setPT02f(final String PT02f) {
        this.PT02f = PT02f;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(final String studentId) {
        this.studentId = studentId;
    }

    public String getHouseholdId() {
        return this.householdId;
    }

    public void setHouseholdId(final String householdId) {
        this.householdId = householdId;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
    }

    public int getSentFlag() {
        return this.sentFlag;
    }

    public void setSentFlag(final int sentFlag) {
        this.sentFlag = sentFlag;
    }

    public static Creator<Modal_PIF> getCREATOR() {
        return Modal_PIF.CREATOR;
    }
}
