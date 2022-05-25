package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Village")
public class Modal_Village implements Comparable, Parcelable {

    @PrimaryKey
    @NonNull
    public String villageId;
    public String villageName;
    public String villageDistrict;
    public String villageState;
    public String villageDate;
    public String countryName;
    public static final Parcelable.Creator<Modal_Village> CREATOR = new Parcelable.Creator<Modal_Village>() {
        @Override
        public Modal_Village createFromParcel(Parcel in) {
            return new Modal_Village(in);
        }

        @Override
        public Modal_Village[] newArray(int size) {
            return new Modal_Village[size];
        }
    };
    public String svrCode;
    public int sentFlag;
    public String villageBooklet;

    protected Modal_Village(Parcel in) {
        villageId = in.readString();
        villageName = in.readString();
        villageDistrict = in.readString();
        countryName = in.readString();
        villageState = in.readString();
        villageDate = in.readString();
        villageBooklet = in.readString();
        svrCode = in.readString();
        sentFlag = in.readInt();
    }

    public Modal_Village() {
    }

    public static Parcelable.Creator<Modal_Village> getCREATOR() {
        return CREATOR;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getVillageDistrict() {
        return villageDistrict;
    }

    public void setVillageDistrict(String villageDistrict) {
        this.villageDistrict = villageDistrict;
    }

    public String getVillageState() {
        return villageState;
    }

    public void setVillageState(String villageState) {
        this.villageState = villageState;
    }

    public String getVillageDate() {
        return villageDate;
    }

    public void setVillageDate(String villageDate) {
        this.villageDate = villageDate;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getVillageBooklet() {
        return villageBooklet;
    }

    public void setVillageBooklet(String villageBooklet) {
        this.villageBooklet = villageBooklet;
    }

    public String getSvrCode() {
        return svrCode;
    }

    public void setSvrCode(String svrCode) {
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(villageId);
        dest.writeString(villageName);
        dest.writeString(countryName);
        dest.writeString(villageBooklet);
        dest.writeString(svrCode);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
