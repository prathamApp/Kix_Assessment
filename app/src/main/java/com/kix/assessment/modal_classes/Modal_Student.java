package com.kix.assessment.modal_classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Student")
public class Modal_Student implements Comparable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int sId;
    public String studentId;
    public String studName;
    public String studAge;
    public String studGender;
    public String studClass;
    public String studEnrollmentStatus;
    public String studSchoolType;
    public String studDropoutYear;
    public String studentRegistrationDate;
    public String svrCode;
    public String householdId;
    public int sentFlag;

    protected Modal_Student(Parcel in) {
        sId = in.readInt();
        studentId = in.readString();
        studName = in.readString();
        studAge = in.readString();
        studGender = in.readString();
        studClass = in.readString();
        studEnrollmentStatus = in.readString();
        studSchoolType = in.readString();
        studDropoutYear = in.readString();
        svrCode = in.readString();
        householdId = in.readString();
        studentRegistrationDate = in.readString();
        sentFlag = in.readInt();
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

    public int getsId() {
        return sId;
    }

    public void setsId(int S_Id) {
        S_Id = S_Id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public static Creator<Modal_Student> getCREATOR() {
        return CREATOR;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudAge() {
        return studAge;
    }

    public void setStudAge(String studAge) {
        this.studAge = studAge;
    }

    public String getStudGender() {
        return studGender;
    }

    public void setStudGender(String studGender) {
        this.studGender = studGender;
    }

    public String getStudClass() { return studClass; }

    public void setStudClass(String studClass) { this.studClass = studClass; }

    public String getSvrCode() { return svrCode; }

    public void setSvrCode(String svrCode) { this.svrCode = svrCode; }

    public String getHousehold_ID() { return householdId; }

    public void setHousehold_ID(String household_ID) { householdId = household_ID; }

    public String getStudEnrollmentStatus() { return studEnrollmentStatus; }

    public void setStudEnrollmentStatus(String studEnrollmentStatus) { this.studEnrollmentStatus = studEnrollmentStatus; }

    public String getStudSchoolType() { return studSchoolType; }

    public void setStudSchoolType(String studSchoolType) { this.studSchoolType = studSchoolType; }

    public String getStudDropoutYear() { return studDropoutYear; }

    public void setStudDropoutYear(String studDropoutYear) { this.studDropoutYear = studDropoutYear; }

    public String getStudentRegistrationDate() {
        return studentRegistrationDate;
    }

    public void setStudentRegistrationDate(String studentRegistrationDate) {
        this.studentRegistrationDate = studentRegistrationDate;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public int getSentFlag() { return sentFlag; }

    public void setSentFlag(int sentFlag) { this.sentFlag = sentFlag; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sId);
        dest.writeString(studentId);
        dest.writeString(studName);
        dest.writeString(studAge);
        dest.writeString(studGender);
        dest.writeString(studClass);
        dest.writeString(studEnrollmentStatus);
        dest.writeString(studSchoolType);
        dest.writeString(studDropoutYear);
        dest.writeString(svrCode);
        dest.writeString(householdId);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
