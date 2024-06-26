package com.kix.assessment.modal_classes;

import androidx.room.Ignore;

//Modal Class to show RecyclerView Contents
public class Modal_ProfileDetails {
    public String StudentName, StudentAge, RespondantName, ExamsGiven,villageId,villageName;
    @Ignore
    String ExamsSynced;

    public Modal_ProfileDetails() {
    }

    public Modal_ProfileDetails(String studentName, String respondantName, String examsGiven, String examsSynced,String studentAge,String villageId,String villageName) {
        StudentName = studentName;
        RespondantName = respondantName;
        ExamsGiven = examsGiven;
        ExamsSynced = examsSynced;
        StudentAge = studentAge;
        this.villageId = villageId;
        this.villageName = villageName;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentAge() { return StudentAge; }

    public void setStudentAge(String studentAge) { StudentAge = studentAge; }

    public String getRespondantName() {return this.RespondantName;}

    public void setRespondantName(final String respondantName) {this.RespondantName = respondantName;}

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

    public String getVillageId() {
        return this.villageId;
    }

    public void setVillageId(final String villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return this.villageName;
    }

    public void setVillageName(final String villageName) {
        this.villageName = villageName;
    }
}
