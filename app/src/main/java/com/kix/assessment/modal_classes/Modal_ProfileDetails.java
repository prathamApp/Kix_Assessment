package com.kix.assessment.modal_classes;

import androidx.room.Ignore;

//Modal Class to show RecyclerView Contents
public class Modal_ProfileDetails {
    String StudentName, StudentAge, HouseholdName, ExamsGiven;
    @Ignore
    String ExamsSynced;

    public Modal_ProfileDetails() {
    }

    public Modal_ProfileDetails(String studentName, String householdName, String examsGiven, String examsSynced, String studentAge) {
        StudentName = studentName;
        HouseholdName = householdName;
        ExamsGiven = examsGiven;
        ExamsSynced = examsSynced;
        StudentAge = studentAge;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentAge() { return StudentAge; }

    public void setStudentAge(String studentAge) { StudentAge = studentAge; }

    public String getHouseholdName() {
        return HouseholdName;
    }

    public void setHouseholdName(String householdName) {
        HouseholdName = householdName;
    }

    public String getExamsGiven() {
        return ExamsGiven;
    }

    public void setExamsGiven(String examsGiven) {
        ExamsGiven = examsGiven;
    }

    public String getExamsSynced() {
        return ExamsSynced;
    }

    public void setExamsSynced(String examsSynced) {
        ExamsSynced = examsSynced;
    }
}
