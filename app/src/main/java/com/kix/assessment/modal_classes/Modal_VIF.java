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
    public static final Creator<Modal_VIF> CREATOR = new Creator<Modal_VIF>() {
        @Override
        public Modal_VIF createFromParcel(Parcel in) {
            return new Modal_VIF(in);
        }

        @Override
        public Modal_VIF[] newArray(int size) {
            return new Modal_VIF[size];
        }
    };
    public int sentFlag;
    public String info_createdOn;

    protected Modal_VIF(Parcel in) {
        vif_Id = in.readInt();
        V01 = in.readString();
        V02 = in.readString();
        V03 = in.readString();
        V04 = in.readString();
        V05 = in.readString();
        V06a = in.readString();
        V06b = in.readString();
        V07a = in.readString();
        V07b = in.readString();
        villageId = in.readString();
        svrCode = in.readString();
        info_createdOn = in.readString();
        sentFlag = in.readInt();
    }

    public Modal_VIF() {
    }

    public static Creator<Modal_VIF> getCREATOR() {
        return CREATOR;
    }

    @NonNull
    public int getVif_Id() {
        return this.vif_Id;
    }

    public void setVif_Id(@NonNull final int vif_Id) {
        this.vif_Id = vif_Id;
    }

    public String getV01() {
        return this.V01;
    }

    public void setV01(final String v01) {
        this.V01 = v01;
    }

    public String getV02() {
        return this.V02;
    }

    public void setV02(final String v02) {
        this.V02 = v02;
    }

    public String getV03() {
        return this.V03;
    }

    public void setV03(final String v03) {
        this.V03 = v03;
    }

    public String getV04() {
        return this.V04;
    }

    public void setV04(final String v04) {
        this.V04 = v04;
    }

    public String getV05() {
        return this.V05;
    }

    public void setV05(final String v05) {
        this.V05 = v05;
    }

    public String getV06a() {
        return this.V06a;
    }

    public void setV06a(final String v06a) {
        this.V06a = v06a;
    }

    public String getV06b() {
        return this.V06b;
    }

    public void setV06b(final String v06b) {
        this.V06b = v06b;
    }

    public String getV07a() {
        return this.V07a;
    }

    public void setV07a(final String v07a) {
        this.V07a = v07a;
    }

    public String getV07b() {
        return this.V07b;
    }

    public void setV07b(final String v07b) {
        this.V07b = v07b;
    }

    public String getVillageId() {
        return this.villageId;
    }

    public void setVillageId(final String villageId) {
        this.villageId = villageId;
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

    public String getInfo_createdOn() { return info_createdOn; }

    public void setInfo_createdOn(String info_createdOn) { this.info_createdOn = info_createdOn; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(vif_Id);
        dest.writeString(V01);
        dest.writeString(V02);
        dest.writeString(V03);
        dest.writeString(V04);
        dest.writeString(V05);
        dest.writeString(V06a);
        dest.writeString(V06b);
        dest.writeString(V07a);
        dest.writeString(V07b);
        dest.writeString(villageId);
        dest.writeString(svrCode);
        dest.writeString(info_createdOn);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
