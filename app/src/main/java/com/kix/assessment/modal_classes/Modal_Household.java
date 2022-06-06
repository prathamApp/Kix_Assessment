package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Household")
public class Modal_Household implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int hhId;
    public String householdId;
    public static final Creator<Modal_Household> CREATOR = new Creator<Modal_Household>() {
        @Override
        public Modal_Household createFromParcel(final Parcel in) {
            return new Modal_Household(in);
        }

        @Override
        public Modal_Household[] newArray(final int size) {
            return new Modal_Household[size];
        }
    };
    public String HH01;//Household number from the houselisting format
    public String HH02;//Name of the respondent
    public String HH03;//Name of the household head
    public String HH04a;//Does the HH have children (living regularly) in the age group 4-10 years?
    public String HH04b;//If yes in HH05a, how many?
    public String HH05;//Telephone/Mobile number of the household (write only if available and willing to share)
    public String createdOn;
    public String villageId;
    public String svrCode;
    public int sentFlag;
    public String HH00;//Household number from the houselisting format

    protected Modal_Household(final Parcel in) {
        this.hhId = in.readInt();
        this.householdId = in.readString();
        this.HH00 = in.readString();
        this.HH01 = in.readString();
        this.HH02 = in.readString();
        this.HH03 = in.readString();
        this.HH04a = in.readString();
        this.HH04b = in.readString();
        this.HH05 = in.readString();
        this.createdOn = in.readString();
        this.villageId = in.readString();
        this.svrCode = in.readString();
        this.sentFlag = in.readInt();
    }

    public Modal_Household(){}

    public static Creator<Modal_Household> getCREATOR() {
        return CREATOR;
    }

    public int getHhId() {
        return hhId;
    }

    public void setHhId(int hhId) {
        this.hhId = hhId;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getHH00() {
        return HH00;
    }

    public void setHH00(String HH00) {
        this.HH00 = HH00;
    }

    public String getSvrCode() {
        return svrCode;
    }

    public void setSvrCode(String svrCode) {
        this.svrCode = svrCode;
    }

    public String getHH01() {
        return HH01;
    }

    public void setHH01(String HH01) {
        this.HH01 = HH01;
    }

    public String getHH02() {
        return HH02;
    }

    public void setHH02(String HH02) {
        this.HH02 = HH02;
    }

    public String getHH03() {
        return HH03;
    }

    public void setHH03(String HH03) {
        this.HH03 = HH03;
    }

    public String getHH04a() {
        return HH04a;
    }

    public void setHH04a(String HH04a) {
        this.HH04a = HH04a;
    }

    public String getHH04b() {
        return HH04b;
    }

    public void setHH04b(String HH04b) {
        this.HH04b = HH04b;
    }

    public String getHH05() {
        return HH05;
    }

    public void setHH05(String HH05) {
        this.HH05 = HH05;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getsvrCode() {
        return svrCode;
    }

    public void setsvrCode(String svrCode) {
        this.svrCode = svrCode;
    }

    public int getSentFlag() {
        return sentFlag;
    }

    public void setSentFlag(int sentFlag) {
        this.sentFlag = sentFlag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(this.hhId);
        dest.writeString(this.householdId);
        dest.writeString(this.HH00);
        dest.writeString(this.HH01);
        dest.writeString(this.HH02);
        dest.writeString(this.HH03);
        dest.writeString(this.HH04a);
        dest.writeString(this.HH04b);
        dest.writeString(this.HH05);
        dest.writeString(this.createdOn);
        dest.writeString(this.villageId);
        dest.writeString(this.svrCode);
        dest.writeInt(this.sentFlag);
    }

    @Override
    public int compareTo(final Object o) {
        return 0;
    }
}


//old model fields
/*
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Household")
public class Modal_Household implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int hhId;
    public String householdId;
    public String householdName;
    public String countryName;
    public String householdDistrict;
    public String householdState;
    public String householdAddress;
    public String householdDate;
    public String svrCode;
    public int sentFlag;

    protected Modal_Household(Parcel in) {
        hhId = in.readInt();
        householdId = in.readString();
        householdName = in.readString();
        householdDistrict = in.readString();
        countryName = in.readString();
        householdState = in.readString();
        householdAddress = in.readString();
        householdDate = in.readString();
        svrCode = in.readString();
        sentFlag = in.readInt();
    }

    public static final Creator<Modal_Household> CREATOR = new Creator<Modal_Household>() {
        @Override
        public Modal_Household createFromParcel(Parcel in) {
            return new Modal_Household(in);
        }

        @Override
        public Modal_Household[] newArray(int size) {
            return new Modal_Household[size];
        }
    };

    public Modal_Household() {
    }

    public int getHhId() {
        return hhId;
    }

    public void setHhId(int hhId) {
        this.hhId = hhId;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String HouseHold_ID) {
        this.householdId = HouseHold_ID;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getHouseholdDistrict() { return householdDistrict; }

    public void setHouseholdDistrict(String householdDistrict) { this.householdDistrict = householdDistrict; }

    public String getHouseholdState() { return householdState; }

    public void setHouseholdState(String householdState) { this.householdState = householdState; }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String HouseHold_Address) { this.householdAddress = HouseHold_Address; }

    public String getHouseholdDate() {
        return householdDate;
    }

    public void setHouseholdDate(String householdDate) {
        this.householdDate = householdDate;
    }

    public String getSvrCode() {
        return svrCode;
    }

    public void setSvrCode(String svrCode) {
        this.svrCode = svrCode;
    }

    public int getSentFlag() { return sentFlag; }

    public static Creator<Modal_Household> getCREATOR() {
        return CREATOR;
    }

    public void setSentFlag(int sentFlag) { this.sentFlag = sentFlag; }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hhId);
        dest.writeString(householdId);
        dest.writeString(householdName);
        dest.writeString(countryName);
        dest.writeString(householdAddress);
        dest.writeString(svrCode);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
*/
