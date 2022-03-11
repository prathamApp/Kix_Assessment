package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent;

import static com.kix.assessment.KIXApplication.scoreDao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.kix.assessment.R;
import com.kix.assessment.modal_classes.Modal_Student;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.MyViewHolder> {
    private final List<Modal_Student> studnetList;
    private final Context context;
    private final ContractStudentList contractStudentList;

    public int index = -1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_studName;
        public MaterialCardView studentCardView;
        public ImageView iv_studentCheck, iv_studentEdit;
//        public LottieAnimationView iv_stud_icon;

        public MyViewHolder(View view) {
            super(view);
            tv_studName = view.findViewById(R.id.tv_studName);
            studentCardView = view.findViewById(R.id.student_cardView);
            iv_studentCheck = view.findViewById(R.id.iv_studentCheck);
            iv_studentEdit = view.findViewById(R.id.iv_studentEdit);
//            iv_stud_icon = view.findViewById(R.id.item_stud_icon);
        }
    }

    public StudentListAdapter(List<Modal_Student> studnetList, Context context, ContractStudentList contractStudentList) {
        this.studnetList = studnetList;
        this.context = context;
        this.contractStudentList = contractStudentList;
    }

    @NonNull
    @Override
    public StudentListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_select_student, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull StudentListAdapter.MyViewHolder holder, int position) {
        Modal_Student modalStudnet = studnetList.get(position);
        holder.tv_studName.setText(modalStudnet.getStudName());
        String examGivenByStud = scoreDao.getStudentId(modalStudnet.getStudentId());

        if (examGivenByStud != null) {
            holder.studentCardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorBtnGreenDark));
            holder.iv_studentCheck.setVisibility(View.VISIBLE);
        } else {
            holder.iv_studentCheck.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(v -> {
            contractStudentList.itemSelected(holder.getAdapterPosition());
            index = position;
            notifyDataSetChanged();
        });

        holder.iv_studentEdit.setOnClickListener(v -> {
            contractStudentList.editStudent(holder.getAdapterPosition());
        });
    }

    public Modal_Student getitem(int pos) {
        return studnetList.get(pos);
    }

    @Override
    public int getItemCount() {
        return studnetList.size();
    }
}