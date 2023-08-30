package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HouseholdInformation")
public class Modal_HIF implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int hif_Id;
    public String HH06a;//Number of members regularly living in the household
    public String HH06b;//Do you speak English at home?
    public String HH06c;//(If yes in HH06a), how often do you speak English at home?
    public String HH06d;//Do you speak any other language at home? (ask this irrespective of the responses in HH06a and HH06b)
    public String HH07a;//Does the household have finished roofing?
    public String HH07b;//Does the household have finished walls?
    public String HH07c;//What is the source of lighting regularly used in the household (tick only one)
    public String HH07cOther;//
    public String HH07d1;//Does the household have a regular source of drinking water within the compound (the source can be inside the house or outside, but only the members of the household exclusively use it)
    public String HH07d2;//(If yes in HH07d.1), do you pay to access/use this source of water?
    public String HH07f;//At least one toilet/latrine that is exclusively used by the members of the household?
    public String HH07g;//Atleast one member (other than the child's parents) who has completed high school diploma?
    public String HH07h;//Any children's books, or other suitable reading materials for children, like story books besides the school textbooks?
    public String HH07i;//Any other books or reading materials, like religious textbooks, newspapers magazines etc?
    public String HH07j;//Computer/laptop/tablet?
    public String HH07k;//Television
    public String HH07m;//Mobile phone
    public String HH07n;//If yes in HH07l, is it a smartphone?
    public String HH07o;//Motorised vehicle?
    public String HH07p;//if yes in HH07o, How many wheels does it have? (select all that applies)
    public String HH07q;//Bicycle?
    public String householdId;
    public String villageId;
    public static final Parcelable.Creator<Modal_HIF> CREATOR = new Parcelable.Creator<Modal_HIF>() {
        @Override
        public Modal_HIF createFromParcel(final Parcel in) {
            return new Modal_HIF(in);
        }

        @Override
        public Modal_HIF[] newArray(final int size) {
            return new Modal_HIF[size];
        }
    };
    public String info_createdOn;
    public int sentFlag;

    protected Modal_HIF(Parcel in) {
        this.hif_Id = in.readInt();
        this.HH06a = in.readString();
        this.HH06b = in.readString();
        this.HH06c = in.readString();
        this.HH06d = in.readString();
        this.HH07a = in.readString();
        this.HH07b = in.readString();
        this.HH07c = in.readString();
        this.HH07cOther = in.readString();
        this.HH07d1 = in.readString();
        this.HH07d2 = in.readString();
        this.HH07f = in.readString();
        this.HH07g = in.readString();
        this.HH07h = in.readString();
        this.HH07i = in.readString();
        this.HH07j = in.readString();
        this.HH07k = in.readString();
        this.HH07m = in.readString();
        this.HH07n = in.readString();
        this.HH07o = in.readString();
        this.HH07p = in.readString();
        this.HH07q = in.readString();
        this.householdId = in.readString();
        this.villageId = in.readString();
        this.info_createdOn = in.readString();
        this.sentFlag = in.readInt();
    }

    public Modal_HIF() {
    }

    public static Parcelable.Creator<Modal_HIF> getCREATOR() {
        return CREATOR;
    }

    public int getHif_Id() {
        return hif_Id;
    }

    public void setHif_Id(int hif_Id) {
        this.hif_Id = hif_Id;
    }

    public String getHH06a() {
        return HH06a;
    }

    public void setHH06a(String HH06a) {
        this.HH06a = HH06a;
    }

    public String getHH06b() {
        return HH06b;
    }

    public void setHH06b(String HH06b) {
        this.HH06b = HH06b;
    }

    public String getHH06c() {
        return HH06c;
    }

    public void setHH06c(String HH06c) {
        this.HH06c = HH06c;
    }

    public String getHH06d() {
        return HH06d;
    }

    public void setHH06d(String HH06d) {
        this.HH06d = HH06d;
    }

    public String getHH07a() {
        return HH07a;
    }

    public void setHH07a(String HH07a) {
        this.HH07a = HH07a;
    }

    public String getHH07b() {
        return HH07b;
    }

    public void setHH07b(String HH07b) {
        this.HH07b = HH07b;
    }

    public String getHH07c() {
        return HH07c;
    }

    public void setHH07c(String HH07c) {
        this.HH07c = HH07c;
    }

    public String getHH07d1() {
        return HH07d1;
    }

    public void setHH07d1(String HH07d1) {
        this.HH07d1 = HH07d1;
    }

    public String getHH07d2() {
        return HH07d2;
    }

    public void setHH07d2(String HH07d2) {
        this.HH07d2 = HH07d2;
    }

    public String getHH07f() {
        return HH07f;
    }

    public void setHH07f(String HH07f) {
        this.HH07f = HH07f;
    }

    public String getHH07g() {
        return HH07g;
    }

    public void setHH07g(String HH07g) {
        this.HH07g = HH07g;
    }

    public String getHH07h() {
        return HH07h;
    }

    public void setHH07h(String HH07h) {
        this.HH07h = HH07h;
    }

    public String getHH07i() {
        return HH07i;
    }

    public void setHH07i(String HH07i) {
        this.HH07i = HH07i;
    }

    public String getHH07j() {
        return HH07j;
    }

    public void setHH07j(String HH07j) {
        this.HH07j = HH07j;
    }

    public String getHH07k() {
        return HH07k;
    }

    public void setHH07k(String HH07k) {
        this.HH07k = HH07k;
    }

    public String getHH07m() {
        return HH07m;
    }

    public void setHH07m(String HH07m) {
        this.HH07m = HH07m;
    }

    public String getHH07n() {
        return HH07n;
    }

    public void setHH07n(String HH07n) {
        this.HH07n = HH07n;
    }

    public String getHH07o() {
        return HH07o;
    }

    public void setHH07o(String HH07o) {
        this.HH07o = HH07o;
    }

    public String getHH07p() {
        return HH07p;
    }

    public void setHH07p(String HH07p) {
        this.HH07p = HH07p;
    }

    public String getHH07q() { return HH07q; }

    public void setHH07q(String HH07q) { this.HH07q = HH07q; }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getInfo_createdOn() {
        return info_createdOn;
    }

    public void setInfo_createdOn(String info_createdOn) {
        this.info_createdOn = info_createdOn;
    }

    public String getHH07cOther() { return HH07cOther; }

    public void setHH07cOther(String HH07cOther) { this.HH07cOther = HH07cOther; }

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
        dest.writeInt(this.hif_Id);
        dest.writeString(this.HH06a);
        dest.writeString(this.HH06b);
        dest.writeString(this.HH06c);
        dest.writeString(this.HH06d);
        dest.writeString(this.HH07a);
        dest.writeString(this.HH07b);
        dest.writeString(this.HH07c);
        dest.writeString(this.HH07cOther);
        dest.writeString(this.HH07d1);
        dest.writeString(this.HH07d2);
        dest.writeString(this.HH07f);
        dest.writeString(this.HH07g);
        dest.writeString(this.HH07h);
        dest.writeString(this.HH07i);
        dest.writeString(this.HH07j);
        dest.writeString(this.HH07k);
        dest.writeString(this.HH07m);
        dest.writeString(this.HH07n);
        dest.writeString(this.HH07o);
        dest.writeString(this.HH07p);
        dest.writeString(this.HH07q);
        dest.writeString(this.householdId);
        dest.writeString(this.villageId);
        dest.writeString(this.info_createdOn);
        dest.writeInt(this.sentFlag);
    }

    @Override
    public int compareTo(final Object o) {
        return 0;
    }
}
