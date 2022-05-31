package com.kix.assessment.ui.household_activity.FragmentSelectHousehold;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;

import java.util.List;

import static com.kix.assessment.KIXApplication.householdDao;
import static com.kix.assessment.KIXApplication.householdInformationDao;
import static com.kix.assessment.KIXApplication.scoreDao;

public class HouseholdListAdapter extends RecyclerView.Adapter<HouseholdListAdapter.MyViewHolder>{
        private final List<Modal_Household> householdList;
        private final Context context;
        private final ContractHouseholdList contractHouseholdList;

        public int index = -1;

        public HouseholdListAdapter(final List<Modal_Household> householdList, final Context context, final ContractHouseholdList contractHouseholdList) {
            this.householdList = householdList;
            this.context = context;
            this.contractHouseholdList=contractHouseholdList;
        }

        @NonNull
        @Override
        public HouseholdListAdapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
            final View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_select_household, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull final HouseholdListAdapter.MyViewHolder holder, final int position) {
            final Modal_Household modalHousehold = this.householdList.get(position);
            holder.tv_CardName.setText(modalHousehold.getHH02());

            boolean isHIFfilled = householdInformationDao.getHIF(modalHousehold.householdId);
            if(isHIFfilled) holder.tv_CardInfo.setBackground(context.getDrawable(R.drawable.rounder_bg_green_rightcurve));

            if(modalHousehold.HH04a.equalsIgnoreCase(Kix_Constant.NO)){
                holder.ll_card.setBackground(context.getDrawable(R.drawable.rounder_bg_grey));
            } else if(modalHousehold.HH04a.equalsIgnoreCase(Kix_Constant.YES)){
                if(modalHousehold.HH04b.isEmpty() || modalHousehold.HH04b.equalsIgnoreCase("0"))
                    holder.ll_card.setBackground(context.getDrawable(R.drawable.rounder_bg_grey));
            }
//        holder.tv_studName.setSelected(false);

/*        if(position==0){
            holder.iv_stud_icon.setImageResource(R.drawable.ic_add_lightorange_24dp);
        }else{
            holder.iv_stud_icon.setAnimation(modalStudnet.getStudentAvatar());
        }*/

            holder.ll_card.setOnClickListener(v -> {
                if(modalHousehold.HH04a.equalsIgnoreCase(Kix_Constant.NO)){
                    Toast.makeText(context, "No Children Found!", Toast.LENGTH_SHORT).show();
                } else if(modalHousehold.HH04a.equalsIgnoreCase(Kix_Constant.YES)){
                    if(modalHousehold.HH04b.isEmpty() || modalHousehold.HH04b.equalsIgnoreCase("0"))
                        Toast.makeText(context, "No Children Found!", Toast.LENGTH_SHORT).show();
                    else {
                        this.contractHouseholdList.itemSelected(position);
                        this.index = position;
                        this.notifyDataSetChanged();
                    }
                }
                else {
                    this.contractHouseholdList.itemSelected(position);
                    this.index = position;
                    this.notifyDataSetChanged();
                }
            });

            holder.iv_CardEdit.setOnClickListener(v -> {
                this.contractHouseholdList.editHousehold(position);
            });

            holder.tv_CardInfo.setOnClickListener(v -> {
                this.contractHouseholdList.addHIF(position);
            });

        }

        public Modal_Household getitem(final int pos) {
            return this.householdList.get(pos);
        }

        @Override
        public int getItemCount() {
            return this.householdList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_CardName, tv_CardInfo;
            public LinearLayout ll_card;
            public ImageView iv_CardEdit;
//        public LottieAnimationView iv_stud_icon;

            public MyViewHolder(final View view) {
                super(view);
                this.tv_CardName = view.findViewById(R.id.tv_CardName);
                this.tv_CardInfo = view.findViewById(R.id.tv_CardInfo);
                this.ll_card = view.findViewById(R.id.ll_card);
                this.iv_CardEdit = view.findViewById(R.id.iv_CardEdit);
//            iv_stud_icon = view.findViewById(R.id.item_stud_icon);
            }
        }
}
