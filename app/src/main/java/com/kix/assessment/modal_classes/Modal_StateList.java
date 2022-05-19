package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Modal_StateList implements Comparable, Parcelable {

    public String StateName;
    public List <Modal_DistrictList> DistrictList;


    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public List<Modal_DistrictList> getDistrictList() {
        return DistrictList;
    }

    public void setDistrictList(List<Modal_DistrictList> districtList) {
        DistrictList = districtList;
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
