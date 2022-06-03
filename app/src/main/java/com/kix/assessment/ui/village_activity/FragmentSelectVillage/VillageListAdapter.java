package com.kix.assessment.ui.village_activity.FragmentSelectVillage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kix.assessment.R;
import com.kix.assessment.dbclasses.dao.VillageInformationDao;
import com.kix.assessment.modal_classes.Modal_Village;

import java.util.List;

import static com.kix.assessment.KIXApplication.villageInformationDao;

public class VillageListAdapter extends RecyclerView.Adapter<VillageListAdapter.MyViewHolder>{
        private final List<Modal_Village> modalVillageList;
        private final Context context;
        private final ContractVillageList contractVillageList;

        public int index = -1;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_CardName,tv_CardInfo;
            public LinearLayout ll_card;
            public ImageView iv_CardEdit;

            public MyViewHolder(final View view) {
                super(view);
                this.tv_CardName = view.findViewById(R.id.tv_CardName);
                this.tv_CardInfo = view.findViewById(R.id.tv_CardInfo);
                this.ll_card = view.findViewById(R.id.ll_card);
                this.iv_CardEdit = view.findViewById(R.id.iv_CardEdit);
            }
        }

        public VillageListAdapter(final List<Modal_Village> modalVillageList, final Context context, final ContractVillageList contractVillageList) {
            this.modalVillageList = modalVillageList;
            this.context = context;
            this.contractVillageList=contractVillageList;
        }

        @NonNull
        @Override
        public VillageListAdapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
            final View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_select_village, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull final VillageListAdapter.MyViewHolder holder, final int position) {
            final Modal_Village modalVillage = this.modalVillageList.get(position);
            holder.tv_CardName.setText(modalVillage.getVillageName());

            boolean isVIFfilled = villageInformationDao.getVIF(modalVillage.villageId);
            if(isVIFfilled) holder.tv_CardInfo.setBackground(context.getDrawable(R.drawable.rounder_bg_green_rightcurve));

            holder.ll_card.setOnClickListener(v -> {
                this.contractVillageList.itemSelected(holder.getAdapterPosition());
                this.index =position;
                this.notifyDataSetChanged();
            });

            holder.iv_CardEdit.setOnClickListener(v -> {
                this.contractVillageList.editVillage(position);
            });

            holder.tv_CardInfo.setOnClickListener(v -> {
                this.contractVillageList.addVIF(position);
            });

        }

        public Modal_Village getitem(final int pos) {
            return this.modalVillageList.get(pos);
        }

        @Override
        public int getItemCount() {
            return this.modalVillageList.size();
        }
}
