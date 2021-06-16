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
    public String householdName;
    public String householdDistrict;
    public String householdState;
    public String householdAddress;
    public String svrCode;
    public int sentFlag;

    protected Modal_Household(Parcel in) {
        hhId = in.readInt();
        householdId = in.readString();
        householdName = in.readString();
        householdDistrict = in.readString();
        householdState = in.readString();
        householdAddress = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hhId);
        dest.writeString(householdId);
        dest.writeString(householdName);
        dest.writeString(householdAddress);
        dest.writeString(svrCode);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
