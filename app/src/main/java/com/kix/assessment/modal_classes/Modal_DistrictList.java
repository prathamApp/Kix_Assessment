package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Modal_DistrictList implements Comparable, Parcelable {

    public String DistrictName;
    public List <Modal_VillageList> VillageList;

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }

    public List<Modal_VillageList> getVillageList() {
        return VillageList;
    }

    public void setVillageList(List<Modal_VillageList> villageList) {
        VillageList = villageList;
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
