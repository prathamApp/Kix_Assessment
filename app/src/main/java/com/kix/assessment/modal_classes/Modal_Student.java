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
    public String CH01;//name
    public String CH02;//sex
    public String CH03;//age
    public String CH04;//Is [child name] currently enrolled in any school or preschool?
    public String CH05a;//Grade/Class (write 0 if child is enrolled in preschool/pre-primary)
    public String CH05b;//School type (tick only one)
    public String CH05c;//Is [test lang] the official medium of instruction in this school?
    public String CH05d;//What is the current status of the school?
    public String CH05e;//If the first option is chosen in CH05d, then ask What kind of activities are being conducted?
    public String CH05f;//Does [child name] have textbooks for the current grade?
    public String CH06a;//Was [child name] ever enrolled in school?
    public String CH06b1;//Year of dropping out
    public String CH06b2;//Last grade/class completed before dropping out
    public String CH06b3;//What was the main reason [child name] dropped out?
    public String CH07;//Was [child name] ever enrolled in a pre-primary/nursery class? (ask only if the child is currently not enrolled in pre-primary/nursery)
    public String CH08;//Does [child name] take any paid tuition class (coaching) currently?
    public String createdOn;
    public String svrCode;
    public String householdId;
    public int sentFlag;


    protected Modal_Student(Parcel in) {
        sId = in.readInt();
        studentId = in.readString();
        CH01 = in.readString();
        CH02 = in.readString();
        CH03 = in.readString();
        CH04 = in.readString();
        CH05a = in.readString();
        CH05b = in.readString();
        CH05c = in.readString();
        CH05d = in.readString();
        CH05e = in.readString();
        CH05f = in.readString();
        CH06a = in.readString();
        CH06b1 = in.readString();
        CH06b2 = in.readString();
        CH06b3 = in.readString();
        CH07 = in.readString();
        CH08 = in.readString();
        svrCode = in.readString();
        householdId = in.readString();
        createdOn = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sId);
        dest.writeString(studentId);
        dest.writeString(CH01);
        dest.writeString(CH02);
        dest.writeString(CH03);
        dest.writeString(CH04);
        dest.writeString(CH05a);
        dest.writeString(CH05b);
        dest.writeString(CH05c);
        dest.writeString(CH05d);
        dest.writeString(CH05e);
        dest.writeString(CH05f);
        dest.writeString(CH06a);
        dest.writeString(CH06b1);
        dest.writeString(CH06b2);
        dest.writeString(CH06b3);
        dest.writeString(CH07);
        dest.writeString(CH08);
        dest.writeString(createdOn);
        dest.writeString(svrCode);
        dest.writeString(householdId);
        dest.writeInt(sentFlag);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public int getsId() {
        return this.sId;
    }

    public void setsId(final int sId) {
        this.sId = sId;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(final String studentId) {
        this.studentId = studentId;
    }

    public String getCH01() {
        return this.CH01;
    }

    public void setCH01(final String CH01) {
        this.CH01 = CH01;
    }

    public String getCH02() {
        return this.CH02;
    }

    public void setCH02(final String CH02) {
        this.CH02 = CH02;
    }

    public String getCH03() {
        return this.CH03;
    }

    public void setCH03(final String CH03) {
        this.CH03 = CH03;
    }

    public String getCH04() {
        return this.CH04;
    }

    public void setCH04(final String CH04) {
        this.CH04 = CH04;
    }

    public String getCH05a() {
        return this.CH05a;
    }

    public void setCH05a(final String CH05a) {
        this.CH05a = CH05a;
    }

    public String getCH05b() {
        return this.CH05b;
    }

    public void setCH05b(final String CH05b) {
        this.CH05b = CH05b;
    }

    public String getCH05c() {
        return this.CH05c;
    }

    public void setCH05c(final String CH05c) {
        this.CH05c = CH05c;
    }

    public String getCH05d() {
        return this.CH05d;
    }

    public void setCH05d(final String CH05d) {
        this.CH05d = CH05d;
    }

    public String getCH05e() {
        return this.CH05e;
    }

    public void setCH05e(final String CH05e) {
        this.CH05e = CH05e;
    }

    public String getCH05f() {
        return this.CH05f;
    }

    public void setCH05f(final String CH05f) {
        this.CH05f = CH05f;
    }

    public String getCH06a() {
        return this.CH06a;
    }

    public void setCH06a(final String CH06a) {
        this.CH06a = CH06a;
    }

    public String getCH06b1() {
        return this.CH06b1;
    }

    public void setCH06b1(final String CH06b1) {
        this.CH06b1 = CH06b1;
    }

    public String getCH06b2() {
        return this.CH06b2;
    }

    public void setCH06b2(final String CH06b2) {
        this.CH06b2 = CH06b2;
    }

    public String getCH06b3() {
        return this.CH06b3;
    }

    public void setCH06b3(final String CH06b3) {
        this.CH06b3 = CH06b3;
    }

    public String getCH07() {
        return this.CH07;
    }

    public void setCH07(final String CH07) {
        this.CH07 = CH07;
    }

    public String getCH08() {
        return this.CH08;
    }

    public void setCH08(final String CH08) {
        this.CH08 = CH08;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
    }

    public String getSvrCode() {
        return this.svrCode;
    }

    public void setSvrCode(final String svrCode) {
        this.svrCode = svrCode;
    }

    public String getHouseholdId() {
        return this.householdId;
    }

    public void setHouseholdId(final String householdId) {
        this.householdId = householdId;
    }

    public int getSentFlag() {
        return this.sentFlag;
    }

    public void setSentFlag(final int sentFlag) {
        this.sentFlag = sentFlag;
    }

    public static Creator<Modal_Student> getCREATOR() {
        return Modal_Student.CREATOR;
    }

    /*    @PrimaryKey(autoGenerate = true)
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
    }*/
}
