package com.kix.assessment.ui.fragment_profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kix.assessment.R;
import com.kix.assessment.modal_classes.Modal_ProfileDetails;
import com.kix.assessment.view_holders.EmptyHolder;
import com.kix.assessment.view_holders.ProfileViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ProfileAdapter extends RecyclerView.Adapter{
    private List<Modal_ProfileDetails> detailsList;
    private Context context;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;

    public ProfileAdapter(Context context, List<Modal_ProfileDetails> detailsList) {
        this.context=context;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_HEADER:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_profile_header, parent, false);
                return new ProfileViewHolder(itemView);

            case TYPE_ITEM:
                View itemView1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_profile_details, parent, false);
                return new ProfileViewHolder(itemView1);

            case TYPE_FOOTER:
                View itemView2 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_profile_footer, parent, false);
                return new EmptyHolder(itemView2);
            default:
                return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == detailsList.size() + 1) {
            return TYPE_FOOTER;
        }
            return TYPE_ITEM;
    }

/*  @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        Modal_ProfileDetails details = detailsList.get(position);
        int detailListSize = detailsList.size();
        holder.setProfileView(context,details,position,detailListSize);
    }*/

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Modal_ProfileDetails details = detailsList.get(position);
        int detailListSize = detailsList.size();
        switch (holder.getItemViewType()) {
            case TYPE_HEADER:
            case TYPE_ITEM:
                ProfileViewHolder profileViewHolder = (ProfileViewHolder) holder;
                profileViewHolder.setProfileView(context,details,position,detailListSize);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public void updateList(ArrayList<Modal_ProfileDetails> list){
        detailsList = list;
        notifyDataSetChanged();
    }
}
