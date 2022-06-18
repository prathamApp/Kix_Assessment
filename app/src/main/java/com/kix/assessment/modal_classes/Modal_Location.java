package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Modal_Location implements Comparable, Parcelable {

    public String CountryName;
    public List <Modal_StateList> StateList;

    public String getCountryName() {
        return this.CountryName;
    }

    public void setCountryName(final String countryName) {
        this.CountryName = countryName;
    }

    public List<Modal_StateList> getStateList() {
        return this.StateList;
    }

    public void setStateList(final List<Modal_StateList> stateList) {
        this.StateList = stateList;
    }


    public Modal_Location() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}