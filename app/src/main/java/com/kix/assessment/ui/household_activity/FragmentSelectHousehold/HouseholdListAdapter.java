package com.kix.assessment.ui.household_activity.FragmentSelectHousehold;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.kix.assessment.R;
import com.kix.assessment.modal_classes.Modal_Household;

import java.util.List;

public class HouseholdListAdapter extends RecyclerView.Adapter<HouseholdListAdapter.MyViewHolder>{
        private List<Modal_Household> householdList;
        private Context context;
        private final ContractHouseholdList contractHouseholdList;

        public int index = -1;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_householdName;
            public MaterialCardView materialCardView;
//        public LottieAnimationView iv_stud_icon;

            public MyViewHolder(View view) {
                super(view);
                tv_householdName = view.findViewById(R.id.tv_householdName);
                materialCardView = view.findViewById(R.id.household_view);
//            iv_stud_icon = view.findViewById(R.id.item_stud_icon);
            }
        }

        public HouseholdListAdapter(List<Modal_Household> householdList, Context context, ContractHouseholdList contractHouseholdList) {
            this.householdList = householdList;
            this.context = context;
            this.contractHouseholdList=contractHouseholdList;
        }

        @NonNull
        @Override
        public HouseholdListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_select_household, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull HouseholdListAdapter.MyViewHolder holder, int position) {
            Modal_Household modalHousehold = householdList.get(position);
            holder.tv_householdName.setText(modalHousehold.getHouseholdName());
//        holder.tv_studName.setSelected(false);

/*        if(position==0){
            holder.iv_stud_icon.setImageResource(R.drawable.ic_add_lightorange_24dp);
        }else{
            holder.iv_stud_icon.setAnimation(modalStudnet.getStudentAvatar());
        }*/

            holder.itemView.setOnClickListener(v -> {
                contractHouseholdList.itemSelected(holder.getAdapterPosition());
                index=position;
                notifyDataSetChanged();
            });

        }

        public Modal_Household getitem(int pos) {
            return householdList.get(pos);
        }

        @Override
        public int getItemCount() {
            return householdList.size();
        }
}
