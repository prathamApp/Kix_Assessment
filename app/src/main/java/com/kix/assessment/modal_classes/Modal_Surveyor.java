package com.kix.assessment.modal_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Surveyor")
public class Modal_Surveyor {

    @PrimaryKey(autoGenerate = true)
    public int Svr_Id;
    public String Svr_Name;
    public String Svr_Email;
    public String Svr_Mobile;
    public String Svr_Password;
    public String Svr_Code;

    public int getSvr_Id() {
        return Svr_Id;
    }

    public void setSvr_Id(int svr_Id) {
        Svr_Id = svr_Id;
    }

    public String getSvr_Name() {
        return Svr_Name;
    }

    public void setSvr_Name(String svr_Name) {
        Svr_Name = svr_Name;
    }

    public String getSvr_Email() {
        return Svr_Email;
    }

    public void setSvr_Email(String svr_Email) {
        Svr_Email = svr_Email;
    }

    public String getSvr_Mobile() {
        return Svr_Mobile;
    }

    public void setSvr_Mobile(String svr_Mobile) {
        Svr_Mobile = svr_Mobile;
    }

    public String getSvr_Password() {
        return Svr_Password;
    }

    public void setSvr_Password(String svr_Password) {
        Svr_Password = svr_Password;
    }

    public String getSvr_Code() { return Svr_Code; }

    public void setSvr_Code(String svr_Code) { Svr_Code = svr_Code; }
}
