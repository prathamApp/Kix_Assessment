package com.kix.assessment.modal_classes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Modal_PushData {
    @SerializedName("session")
    private List<Modal_PushSessionData> pushSession;
    @SerializedName("students")
    private List<Modal_Student> students;
    @SerializedName("surveyor")
    private List<Modal_Surveyor> surveyors;
    @SerializedName("household")
    private List<Modal_Household> households;

    public List<Modal_PushSessionData> getPushSession() {
        return pushSession;
    }

    public void setPushSession(List<Modal_PushSessionData> pushSession) {
        this.pushSession = pushSession;
    }

    public List<Modal_Student> getStudents() {
        return students;
    }

    public void setStudents(List<Modal_Student> students) {
        this.students = students;
    }

    public List<Modal_Surveyor> getSurveyors() { return surveyors; }

    public void setSurveyors(List<Modal_Surveyor> surveyors) { this.surveyors = surveyors; }

    public List<Modal_Household> getHouseholds() { return households; }

    public void setHouseholds(List<Modal_Household> households) { this.households = households; }

    public class Modal_PushSessionData {
        @SerializedName("session_id")
        String sessionId;
        @SerializedName("scores")
        List<Score> scores;
        @SerializedName("attendances")
        List<Attendance> attendances;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public List<Score> getScores() {
            return scores;
        }

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }

        public List<Attendance> getAttendances() {
            return attendances;
        }

        public void setAttendances(List<Attendance> attendances) {
            this.attendances = attendances;
        }
    }
}
