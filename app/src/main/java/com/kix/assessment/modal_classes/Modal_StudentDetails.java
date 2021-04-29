package com.kix.assessment.modal_classes;

import androidx.room.Ignore;

//Modal Class to show RecyclerView Contents
public class Modal_StudentDetails {
    String StudentName, HouseholdName, ExamsGiven;
    @Ignore
    String ExamsSynced;

    public Modal_StudentDetails() {
    }

    public Modal_StudentDetails(String studentName, String householdName, String examsGiven, String examsSynced) {
        StudentName = studentName;
        HouseholdName = householdName;
        ExamsGiven = examsGiven;
        ExamsSynced = examsSynced;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

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
