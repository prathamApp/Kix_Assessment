package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Student")
public class Modal_Student implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int S_Id;
    public String Stud_Id;
    public String Stud_Name;
    public String Stud_Age;
    public String Stud_Gender;
    public String Stud_Class;
    public String Svr_Code;

    protected Modal_Student(Parcel in) {
        S_Id = in.readInt();
        Stud_Id = in.readString();
        Stud_Name = in.readString();
        Stud_Age = in.readString();
        Stud_Gender = in.readString();
        Stud_Class = in.readString();
        Svr_Code = in.readString();
    }

    public static final Creator<Modal_Student> CREATOR = new Creator<Modal_Student>() {
        @Override
        public Modal_Student createFromParcel(Parcel in) {
            return new Modal_Student(in);
        }

        @Override
        public Modal_Student[] newArray(int size) {
            return new Modal_Student[size];
        }
    };

    public Modal_Student() {
    }

    public int getS_Id() {
        return S_Id;
    }

    public void setS_Id(int S_Id) {
        S_Id = S_Id;
    }

    public String getStud_Id() {
        return Stud_Id;
    }

    public void setStud_Id(String stud_Id) {
        Stud_Id = stud_Id;
    }

    public static Creator<Modal_Student> getCREATOR() {
        return CREATOR;
    }

    public String getStud_Name() {
        return Stud_Name;
    }

    public void setStud_Name(String stud_Name) {
        Stud_Name = stud_Name;
    }

    public String getStud_Age() {
        return Stud_Age;
    }

    public void setStud_Age(String stud_Age) {
        Stud_Age = stud_Age;
    }

    public String getStud_Gender() {
        return Stud_Gender;
    }

    public void setStud_Gender(String stud_Gender) {
        Stud_Gender = stud_Gender;
    }

    public String getStud_Class() { return Stud_Class; }

    public void setStud_Class(String stud_Class) { Stud_Class = stud_Class; }

    public String getSvr_Code() { return Svr_Code; }

    public void setSvr_Code(String svr_Code) { Svr_Code = svr_Code; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(S_Id);
        dest.writeString(Stud_Name);
        dest.writeString(Stud_Age);
        dest.writeString(Stud_Gender);
        dest.writeString(Stud_Class);
        dest.writeString(Svr_Code);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
