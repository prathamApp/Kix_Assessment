package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Household")
public class Modal_Household implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int hh_ID;
    public String HouseHold_ID;
    public String HouseHold_Name;
    public String HouseHold_District;
    public String HouseHold_State;
    public String HouseHold_Address;
    public String Svr_Code;
    public int sentFlag;

    protected Modal_Household(Parcel in) {
        hh_ID = in.readInt();
        HouseHold_ID = in.readString();
        HouseHold_Name = in.readString();
        HouseHold_District = in.readString();
        HouseHold_State = in.readString();
        HouseHold_Address = in.readString();
        Svr_Code = in.readString();
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

    public int getHh_ID() {
        return hh_ID;
    }

    public void setHh_ID(int hh_ID) {
        this.hh_ID = hh_ID;
    }

    public String getHouseHold_ID() {
        return HouseHold_ID;
    }

    public void setHouseHold_ID(String HouseHold_ID) {
        this.HouseHold_ID = HouseHold_ID;
    }

    public String getHouseHold_Name() {
        return HouseHold_Name;
    }

    public void setHouseHold_Name(String houseHold_Name) {
        this.HouseHold_Name = houseHold_Name;
    }

    public String getHouseHold_District() { return HouseHold_District; }

    public void setHouseHold_District(String houseHold_District) { HouseHold_District = houseHold_District; }

    public String getHouseHold_State() { return HouseHold_State; }

    public void setHouseHold_State(String houseHold_State) { HouseHold_State = houseHold_State; }

    public String getHouseHold_Address() {
        return HouseHold_Address;
    }

    public void setHouseHold_Address(String HouseHold_Address) { this.HouseHold_Address = HouseHold_Address; }

    public String getSvr_Code() {
        return Svr_Code;
    }

    public void setSvr_Code(String svr_Code) {
        Svr_Code = svr_Code;
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
        dest.writeInt(hh_ID);
        dest.writeString(HouseHold_ID);
        dest.writeString(HouseHold_Name);
        dest.writeString(HouseHold_Address);
        dest.writeString(Svr_Code);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
