package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Modal_Location implements Comparable, Parcelable {

    public List <Modal_StateList> StateList;


    public List<Modal_StateList> getStateList() {
        return StateList;
    }

    public void setStateList(List<Modal_StateList> stateList) {
        StateList = stateList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {

    }

    @Override
    public int compareTo(final Object o) {
        return 0;
    }
}