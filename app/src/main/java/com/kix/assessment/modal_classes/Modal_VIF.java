package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "VillageInformartion")
public class Modal_VIF implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int vif_Id;
    public String V01;//Is there tarmac/all weather road leading to the village?
    public String V02;//Is there public transport facility available to the village?
    public String V03;//Does the village have electricity connection?
    public String V04;//Does the village have any government/public health facility?
    public String V05;//Does the village have any private health facility?
    public String V06a;//Does the village have any pre-primary schools or any school offering pre-primary grades/classes?
    public String V06b;//If yes in V06a, which type of school(s) in the village offers pre-primary grades/classes? (Tick all that apply)
    public String V07a;//Does the village have any schools offering primary grades/classes (definition of primary grades would vary from country to country, so select accordingly. Eg. in India primary grades are 1 to 5)
    public String V07b;//If yes in V07a, which type of school(s) in the village offers primary grades/classes? (Tick all that apply)
    public String villageId;
    public String svrCode;
    public String createdOn;
    public int sentFlag;

    protected Modal_VIF(final Parcel in) {
        this.vif_Id = in.readInt();
        this.V01 = in.readString();
        this.V02 = in.readString();
        this.V03 = in.readString();
        this.V04 = in.readString();
        this.V05 = in.readString();
        this.V06a = in.readString();
        this.V06b = in.readString();
        this.V07a = in.readString();
        this.V07b = in.readString();
        this.villageId = in.readString();
        this.svrCode = in.readString();
        this.createdOn = in.readString();
        this.sentFlag = in.readInt();
    }

    public static final Parcelable.Creator<Modal_VIF> CREATOR = new Parcelable.Creator<Modal_VIF>() {
        @Override
        public Modal_VIF createFromParcel(final Parcel in) {
            return new Modal_VIF(in);
        }

        @Override
        public Modal_VIF[] newArray(final int size) {
            return new Modal_VIF[size];
        }
    };

    public Modal_VIF() {
    }

    @NonNull
    public int getVif_Id() {
        return vif_Id;
    }

    public void setVif_Id(@NonNull int vif_Id) {
        this.vif_Id = vif_Id;
    }

    public String getV01() {
        return V01;
    }

    public void setV01(String v01) {
        V01 = v01;
    }

    public String getV02() {
        return V02;
    }

    public void setV02(String v02) {
        V02 = v02;
    }

    public String getV03() {
        return V03;
    }

    public void setV03(String v03) {
        V03 = v03;
    }

    public String getV04() {
        return V04;
    }

    public void setV04(String v04) {
        V04 = v04;
    }

    public String getV05() {
        return V05;
    }

    public void setV05(String v05) {
        V05 = v05;
    }

    public String getV06a() {
        return V06a;
    }

    public void setV06a(String v06a) {
        V06a = v06a;
    }

    public String getV06b() {
        return V06b;
    }

    public void setV06b(String v06b) {
        V06b = v06b;
    }

    public String getV07a() {
        return V07a;
    }

    public void setV07a(String v07a) {
        V07a = v07a;
    }

    public String getV07b() {
        return V07b;
    }

    public void setV07b(String v07b) {
        V07b = v07b;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
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

    public String getCreatedOn() { return this.createdOn; }

    public void setCreatedOn(final String createdOn) { this.createdOn = createdOn; }

    public static Parcelable.Creator<Modal_VIF> getCREATOR() {
        return Modal_VIF.CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(this.vif_Id);
        dest.writeString(this.V01);
        dest.writeString(this.V02);
        dest.writeString(this.V03);
        dest.writeString(this.V04);
        dest.writeString(this.V05);
        dest.writeString(this.V06a);
        dest.writeString(this.V06b);
        dest.writeString(this.V07a);
        dest.writeString(this.V07b);
        dest.writeString(this.villageId);
        dest.writeString(this.svrCode);
        dest.writeString(this.createdOn);
        dest.writeInt(this.sentFlag);
    }

    @Override
    public int compareTo(final Object o) {
        return 0;
    }

}
