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
    public String HH07a;//HH roofing (tick only one)
    public String HH07b;//HH wall (external) material (tick only one)
    public String HH07c;//What is the source of lighting regularly used in the household (tick only one)
    public String HH07cOther;//
    public String HH07d;//What is the source of drinking water used regularly in the HH (tick only one)
    public String HH07dOther;
    public String HH07e;//Electricity connection (to be marked 'yes' if HH06c is 'Electricity')
    public String HH07f;//Toilet
    public String HH07g;//Atleast one member (other than the child's parents) who has completed high school diploma?
    public String HH07h;//Any reading material other than school textbooks and religious books
    public String HH07i;//Computer
    public String HH07j;//Television
    public String HH07k;//Radio
    public String HH07l;//Mobile phone
    public String HH07m;//If yes in HH07l, is it a smartphone?
    public String HH07n;//Motorised 4-wheeler?
    public String HH07o;//Motorised 2-wheeler?
    public String HH07p;//Bicycle?
    public String householdId;
    public String villageId;
    public String createdOn;
    public int sentFlag = 0;

    protected Modal_HIF(final Parcel in) {
        hif_Id = in.readInt();
        HH07a = in.readString();
        HH07b = in.readString();
        HH07c = in.readString();
        HH07cOther = in.readString();
        HH07d = in.readString();
        HH07dOther = in.readString();
        HH07e = in.readString();
        HH07f = in.readString();
        HH07g = in.readString();
        HH07h = in.readString();
        HH07i = in.readString();
        HH07j = in.readString();
        HH07k = in.readString();
        HH07l = in.readString();
        HH07m = in.readString();
        HH07n = in.readString();
        HH07o = in.readString();
        HH07p = in.readString();
        householdId = in.readString();
        villageId = in.readString();
        createdOn = in.readString();
        sentFlag = in.readInt();
    }

    public static final Creator<Modal_HIF> CREATOR = new Creator<Modal_HIF>() {
        @Override
        public Modal_HIF createFromParcel(Parcel in) {
            return new Modal_HIF(in);
        }

        @Override
        public Modal_HIF[] newArray(int size) {
            return new Modal_HIF[size];
        }
    };

    public Modal_HIF() {
    }

    public int getHif_Id() {
        return this.hif_Id;
    }

    public void setHif_Id(final int hif_Id) {
        this.hif_Id = hif_Id;
    }

    public String getHH07a() {
        return this.HH07a;
    }

    public void setHH07a(final String HH07a) {
        this.HH07a = HH07a;
    }

    public String getHH07b() {
        return this.HH07b;
    }

    public void setHH07b(final String HH07b) {
        this.HH07b = HH07b;
    }

    public String getHH07c() {
        return this.HH07c;
    }

    public void setHH07c(final String HH07c) {
        this.HH07c = HH07c;
    }

    public String getHH07d() {
        return this.HH07d;
    }

    public void setHH07d(final String HH07d) {
        this.HH07d = HH07d;
    }

    public String getHH07e() {
        return this.HH07e;
    }

    public void setHH07e(final String HH07e) {
        this.HH07e = HH07e;
    }

    public String getHH07f() {
        return this.HH07f;
    }

    public void setHH07f(final String HH07f) {
        this.HH07f = HH07f;
    }

    public String getHH07g() {
        return this.HH07g;
    }

    public void setHH07g(final String HH07g) {
        this.HH07g = HH07g;
    }

    public String getHH07h() {
        return this.HH07h;
    }

    public void setHH07h(final String HH07h) {
        this.HH07h = HH07h;
    }

    public String getHH07i() {
        return this.HH07i;
    }

    public void setHH07i(final String HH07i) {
        this.HH07i = HH07i;
    }

    public String getHH07j() {
        return this.HH07j;
    }

    public void setHH07j(final String HH07j) {
        this.HH07j = HH07j;
    }

    public String getHH07k() {
        return this.HH07k;
    }

    public void setHH07k(final String HH07k) {
        this.HH07k = HH07k;
    }

    public String getHH07l() {
        return this.HH07l;
    }

    public void setHH07l(final String HH07l) {
        this.HH07l = HH07l;
    }

    public String getHH07m() {
        return this.HH07m;
    }

    public void setHH07m(final String HH07m) {
        this.HH07m = HH07m;
    }

    public String getHH07n() {
        return this.HH07n;
    }

    public void setHH07n(final String HH07n) {
        this.HH07n = HH07n;
    }

    public String getHH07o() {
        return this.HH07o;
    }

    public void setHH07o(final String HH07o) {
        this.HH07o = HH07o;
    }

    public String getHH07p() {
        return this.HH07p;
    }

    public void setHH07p(final String HH07p) {
        this.HH07p = HH07p;
    }

    public String getHouseholdId() {
        return this.householdId;
    }

    public void setHouseholdId(final String householdId) {
        this.householdId = householdId;
    }

    public String getVillageId() {
        return this.villageId;
    }

    public void setVillageId(final String villageId) {
        this.villageId = villageId;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
    }

    public String getHH07cOther() { return this.HH07cOther; }

    public void setHH07cOther(final String HH07cOther) { this.HH07cOther = HH07cOther; }

    public String getHH07dOther() { return this.HH07dOther; }

    public void setHH07dOther(final String HH07dOther) { this.HH07dOther = HH07dOther; }

    public int getSentFlag() {
        return this.sentFlag;
    }

    public void setSentFlag(final int sentFlag) {
        this.sentFlag = sentFlag;
    }

    public static Creator<Modal_HIF> getCREATOR() {
        return Modal_HIF.CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hif_Id);
        dest.writeString(HH07a);
        dest.writeString(HH07b);
        dest.writeString(HH07c);
        dest.writeString(HH07cOther);
        dest.writeString(HH07d);
        dest.writeString(HH07dOther);
        dest.writeString(HH07e);
        dest.writeString(HH07f);
        dest.writeString(HH07g);
        dest.writeString(HH07h);
        dest.writeString(HH07i);
        dest.writeString(HH07j);
        dest.writeString(HH07k);
        dest.writeString(HH07l);
        dest.writeString(HH07m);
        dest.writeString(HH07n);
        dest.writeString(HH07o);
        dest.writeString(HH07p);
        dest.writeString(householdId);
        dest.writeString(villageId);
        dest.writeString(createdOn);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
