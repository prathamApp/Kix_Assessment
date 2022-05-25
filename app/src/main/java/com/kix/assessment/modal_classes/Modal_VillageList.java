package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Modal_VillageList implements Comparable, Parcelable {

    public String ContentBooklet;
    public String VillageName;


    public String getContentBooklet() {
        return ContentBooklet;
    }

    public void setContentBooklet(String contentBooklet) {
        ContentBooklet = contentBooklet;
    }

    public String getVillageName() {
        return VillageName;
    }

    public void setVillageName(String villageName) {
        VillageName = villageName;
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
