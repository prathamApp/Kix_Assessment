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
    public static final Creator<Modal_Village> CREATOR = new Creator<Modal_Village>() {
        @Override
        public Modal_Village createFromParcel(final Parcel in) {
            return new Modal_Village(in);
        }

        @Override
        public Modal_Village[] newArray(final int size) {
            return new Modal_Village[size];
        }
    };
    public String countryName;
    public String createdOn;
    public String svrCode;
    public int sentFlag;
    public String villageBooklet;

    protected Modal_Village(final Parcel in) {
        this.villageId = in.readString();
        this.villageName = in.readString();
        this.villageDistrict = in.readString();
        this.countryName = in.readString();
        this.villageState = in.readString();
        this.createdOn = in.readString();
        this.villageBooklet = in.readString();
        this.svrCode = in.readString();
        this.sentFlag = in.readInt();
    }

    public Modal_Village() {
    }

    public static Creator<Modal_Village> getCREATOR() {
        return Modal_Village.CREATOR;
    }

    public String getVillageId() {
        return this.villageId;
    }

    public void setVillageId(final String villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return this.villageName;
    }

    public void setVillageName(final String villageName) {
        this.villageName = villageName;
    }

    public String getVillageDistrict() {
        return this.villageDistrict;
    }

    public void setVillageDistrict(final String villageDistrict) {
        this.villageDistrict = villageDistrict;
    }

    public String getVillageState() {
        return this.villageState;
    }

    public void setVillageState(final String villageState) {
        this.villageState = villageState;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public String getVillageBooklet() {
        return this.villageBooklet;
    }

    public void setVillageBooklet(final String villageBooklet) {
        this.villageBooklet = villageBooklet;
    }

    public String getSvrCode() {
        return this.svrCode;
    }

    public void setSvrCode(final String svrCode) {
        this.svrCode = svrCode;
    }

    public int getSentFlag() {
        return this.sentFlag;
    }

    public void setSentFlag(final int sentFlag) {
        this.sentFlag = sentFlag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(this.villageId);
        dest.writeString(this.villageName);
        dest.writeString(this.countryName);
        dest.writeString(this.villageBooklet);
        dest.writeString(this.createdOn);
        dest.writeString(this.svrCode);
        dest.writeInt(this.sentFlag);
    }

    @Override
    public int compareTo(final Object o) {
        return 0;
    }
}
