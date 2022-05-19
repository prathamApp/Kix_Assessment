package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Modal_VillageList implements Comparable, Parcelable {

    public String VillageName;

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
