package com.kix.assessment.view_holders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.kix.assessment.R;
import com.kix.assessment.modal_classes.Modal_StudentDetails;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    public TextView studentName, householdName, examsGiven, examsSynced;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        studentName = itemView.findViewById(R.id.tv_StudName);
        householdName = itemView.findViewById(R.id.tv_HouseholdName);
        examsGiven = itemView.findViewById(R.id.tv_ExamGiven);
        examsSynced = itemView.findViewById(R.id.tv_ExamSynced);
    }

    public void setProfileView(Context context, Modal_StudentDetails details, int position, int listSize)
    {
        studentName.setText(details.getStudentName());
        householdName.setText(details.getHouseholdName());
        examsGiven.setText(details.getExamsGiven());
        examsSynced.setText(details.getExamsSynced());
    }
}
