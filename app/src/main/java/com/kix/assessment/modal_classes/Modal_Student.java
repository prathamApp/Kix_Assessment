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
    public String CH04a;//Does the child have any known disability?
    public String CH04b;//If yes in CH04a then, which disability? (select all that is applicable)
    public String CH05;//Is [child name] currently enrolled in any school or preschool?
    public String CH06a;//Grade/Class (write 0 if child is enrolled in preschool/pre-primary)
    public String CH06b;//School type (tick only one)
    public String CH06c;//Is [test lang] the official medium of instruction in this school?
//    public String CH06d;//What is the current status of the school?
//    public String CH06e;//If the first option is chosen in CH06d, then ask What kind of activities are being conducted?
    public String CH06f;//Does [child name] have textbooks for the current grade?
    public String CH06g;//Has the [child name] ever repeated a grade in school (ask only children currently enrolled in grade 1 and above)?
    public String CH07a;//Was [child name] ever enrolled in school?
    public String CH07b;//Year of dropping out
    public String CH07c;//Last grade/class completed before dropping out
    public String CH07d;//What was the main reason [child name] dropped out?
    public String CH08a;//Does anyone at home help the child with their homework?
    public String CH08b;//(If yes in CH08a then ask), who helps [child name] MOST often?
    public String CH09a;//Does [child name] take any paid tuition class (coaching) currently?
    public String CH09b;//Has [child name] brought home any materials to read (other than school textbooks) in the last 2 weeks from the school library or anyother place?
    public String CH09c;//How often does someone is the household read or tell stories to [child name]?
    public String createdOn;
    public String parentId;
    public String svrCode;
    public String householdId;
    public int sentFlag;


    protected Modal_Student(Parcel in) {
        sId = in.readInt();
        studentId = in.readString();
        CH01 = in.readString();
        CH02 = in.readString();
        CH03 = in.readString();
        CH04a = in.readString();
        CH04b = in.readString();
        CH05 = in.readString();
        CH06a = in.readString();
        CH06b = in.readString();
        CH06c = in.readString();
//        CH06d = in.readString();
//        CH06e = in.readString();
        CH06f = in.readString();
        CH06g = in.readString();
        CH07a = in.readString();
        CH07b = in.readString();
        CH07c = in.readString();
        CH07d = in.readString();
        CH09a = in.readString();
        CH09b = in.readString();
        CH08a = in.readString();
        CH08b = in.readString();
        CH09c = in.readString();
        parentId = in.readString();
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
        dest.writeString(CH04a);
        dest.writeString(CH04b);
        dest.writeString(CH05);
        dest.writeString(CH06a);
        dest.writeString(CH06b);
        dest.writeString(CH06c);
//        dest.writeString(CH06d);
//        dest.writeString(CH06e);
        dest.writeString(CH06f);
        dest.writeString(CH06g);
        dest.writeString(CH07a);
        dest.writeString(CH07b);
        dest.writeString(CH07c);
        dest.writeString(CH07d);
        dest.writeString(CH09a);
        dest.writeString(CH09b);
        dest.writeString(CH08a);
        dest.writeString(CH08b);
        dest.writeString(CH09c);
        dest.writeString(createdOn);
        dest.writeString(parentId);
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

    public String getCH04a() {
        return this.CH04a;
    }

    public void setCH04a(final String CH04a) {
        this.CH04a = CH04a;
    }

    public String getCH04b() {
        return this.CH04b;
    }

    public void setCH04b(final String CH04b) {
        this.CH04b = CH04b;
    }

    public String getCH05() {
        return this.CH05;
    }

    public void setCH05(final String CH05) {
        this.CH05 = CH05;
    }

    public String getCH06a() {
        return this.CH06a;
    }

    public void setCH06a(final String CH06a) {
        this.CH06a = CH06a;
    }

    public String getCH06b() {
        return this.CH06b;
    }

    public void setCH06b(final String CH06b) {
        this.CH06b = CH06b;
    }

    public String getCH06c() {
        return this.CH06c;
    }

    public void setCH06c(final String CH06c) {
        this.CH06c = CH06c;
    }

/*
    public String getCH06d() {
        return this.CH06d;
    }

    public void setCH06d(final String CH06d) {
        this.CH06d = CH06d;
    }

    public String getCH06e() {
        return this.CH06e;
    }

    public void setCH06e(final String CH06e) {
        this.CH06e = CH06e;
    }
*/

    public String getCH06f() {
        return this.CH06f;
    }

    public void setCH06f(final String CH06f) {
        this.CH06f = CH06f;
    }

    public String getCH06g() {
        return this.CH06g;
    }

    public void setCH06g(final String CH06g) {
        this.CH06g = CH06g;
    }

    public String getCH07a() {
        return this.CH07a;
    }

    public void setCH07a(final String CH07a) {
        this.CH07a = CH07a;
    }

    public String getCH07b() {
        return this.CH07b;
    }

    public void setCH07b(final String CH07b) {
        this.CH07b = CH07b;
    }

    public String getCH07c() {
        return this.CH07c;
    }

    public void setCH07c(final String CH07c) {
        this.CH07c = CH07c;
    }

    public String getCH07d() {
        return this.CH07d;
    }

    public void setCH07d(final String CH07d) {
        this.CH07d = CH07d;
    }

    public String getCH09a() {
        return this.CH09a;
    }

    public void setCH09a(final String CH09a) {
        this.CH09a = CH09a;
    }

    public String getCH09b() {
        return this.CH09b;
    }

    public void setCH09b(final String CH09b) {
        this.CH09b = CH09b;
    }

    public String getCH08a() {
        return this.CH08a;
    }

    public void setCH08a(final String CH08a) {
        this.CH08a = CH08a;
    }

    public String getCH08b() {
        return this.CH08b;
    }

    public void setCH08b(final String CH08b) {
        this.CH08b = CH08b;
    }

    public String getCH09c() {
        return this.CH09c;
    }

    public void setCH09c(final String CH09c) {
        this.CH09c = CH09c;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
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
