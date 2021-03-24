package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Household")
public class Modal_Household implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int hh_ID;
    public String houseHold_ID;
    public String houseHold_Name;
    public String houseHold_Address;
    public String Svr_Code;

    protected Modal_Household(Parcel in) {
        hh_ID = in.readInt();
        houseHold_ID = in.readString();
        houseHold_Name = in.readString();
        houseHold_Address = in.readString();
        Svr_Code = in.readString();
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

    public int getHh_ID() {
        return hh_ID;
    }

    public void setHh_ID(int hh_ID) {
        this.hh_ID = hh_ID;
    }

    public String getHouseHold_ID() {
        return houseHold_ID;
    }

    public void setHouseHold_ID(String houseHold_ID) {
        this.houseHold_ID = houseHold_ID;
    }

    public String getHouseHold_Name() {
        return houseHold_Name;
    }

    public void setHouseHold_Name(String houseHold_Name) {
        this.houseHold_Name = houseHold_Name;
    }

    public String getHouseHold_Address() {
        return houseHold_Address;
    }

    public void setHouseHold_Address(String houseHold_Address) {
        this.houseHold_Address = houseHold_Address;
    }

    public String getSvr_Code() {
        return Svr_Code;
    }

    public void setSvr_Code(String svr_Code) {
        Svr_Code = svr_Code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hh_ID);
        dest.writeString(houseHold_ID);
        dest.writeString(houseHold_Name);
        dest.writeString(houseHold_Address);
        dest.writeString(Svr_Code);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
