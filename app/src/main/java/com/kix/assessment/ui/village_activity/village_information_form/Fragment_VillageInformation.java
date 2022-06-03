package com.kix.assessment.ui.village_activity.village_information_form;

import static com.kix.assessment.KIXApplication.villageDao;
import static com.kix.assessment.KIXApplication.villageInformationDao;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_VIF;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_information_village)
public class Fragment_VillageInformation extends Fragment {

    @ViewById(R.id.tv_V01_val)
    TextView tv_haveRoad;
    @ViewById(R.id.tv_V02_val)
    TextView tv_haveTransport;
    @ViewById(R.id.tv_V03_val)
    TextView tv_haveElectricity;
    @ViewById(R.id.tv_V04_val)
    TextView tv_haveGovtHosp;
    @ViewById(R.id.tv_V05_val)
    TextView tv_havePvtHosp;
    @ViewById(R.id.tv_V06a_val)
    TextView tv_havePrePrimSchool;
    @ViewById(R.id.tv_V06b_val)
    TextView tv_v06b_schoolType;
    @ViewById(R.id.tv_V07a_val)
    TextView tv_havePrimSchool;
    @ViewById(R.id.tv_V07b_val)
    TextView tv_v07b_schoolType;

    @ViewById(R.id.scroll_View)
    ScrollView scroll_View;
    @ViewById(R.id.fab_Edit_VIF)
    FloatingActionButton fab_Edit_VIF;

    String villageId, addMode="";

    public Fragment_VillageInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);
        Modal_Village modalVillage = villageDao.getVillageByVillId(villageId);
        Modal_VIF modal_vif = villageInformationDao.getVIFbyVillageId(this.villageId);
        String vName = "NA";
        vName = modalVillage.getVillageName();
        if(modal_vif.getV01().equalsIgnoreCase("1")) {
            this.tv_haveRoad.setBackgroundResource(R.drawable.rounder_bg_green);
            this.tv_haveRoad.setText(getString(R.string.yes));
        } else{
            this.tv_haveRoad.setBackgroundResource(R.drawable.rounded_bg_red);
            this.tv_haveRoad.setText(getString(R.string.no));
        }
        if(modal_vif.getV02().equalsIgnoreCase("1")){
            this.tv_haveTransport.setBackgroundResource(R.drawable.rounder_bg_green);
            this.tv_haveTransport.setText(getString(R.string.yes));
        } else {
            this.tv_haveTransport.setBackgroundResource(R.drawable.rounded_bg_red);
            this.tv_haveTransport.setText(getString(R.string.no));
        }
        if(modal_vif.getV03().equalsIgnoreCase("1")){
            this.tv_haveElectricity.setBackgroundResource(R.drawable.rounder_bg_green);
            this.tv_haveElectricity.setText(getString(R.string.yes));
        } else{
            this.tv_haveElectricity.setBackgroundResource(R.drawable.rounded_bg_red);
            this.tv_haveElectricity.setText(getString(R.string.no));
        }
        if(modal_vif.getV04().equalsIgnoreCase("1")){
            this.tv_haveGovtHosp.setBackgroundResource(R.drawable.rounder_bg_green);
            this.tv_haveGovtHosp.setText(getString(R.string.yes));
        } else{
            this.tv_haveGovtHosp.setBackgroundResource(R.drawable.rounded_bg_red);
            this.tv_haveGovtHosp.setText(getString(R.string.no));
        }
        if(modal_vif.getV05().equalsIgnoreCase("1")){
            this.tv_havePvtHosp.setBackgroundResource(R.drawable.rounder_bg_green);
            this.tv_havePvtHosp.setText(getString(R.string.yes));
        } else{
            this.tv_havePvtHosp.setBackgroundResource(R.drawable.rounded_bg_red);
            this.tv_havePvtHosp.setText(getString(R.string.no));
        }
        if(modal_vif.getV06a().equalsIgnoreCase("1")) {
            this.tv_havePrePrimSchool.setBackgroundResource(R.drawable.rounder_bg_green);
            this.tv_havePrePrimSchool.setText(getString(R.string.yes));
        } else {
            this.tv_havePrePrimSchool.setBackgroundResource(R.drawable.rounded_bg_red);
            this.tv_havePrePrimSchool.setText(getString(R.string.no));
        }
        if(modal_vif.getV07a().equalsIgnoreCase("1")) {
            this.tv_havePrimSchool.setBackgroundResource(R.drawable.rounder_bg_green);
            this.tv_havePrimSchool.setText(getString(R.string.yes));
        } else {
            this.tv_havePrimSchool.setBackgroundResource(R.drawable.rounded_bg_red);
            this.tv_havePrimSchool.setText(getString(R.string.no));
        }

/*        this.tv_haveTransport.setText(modal_vif.getV02());
        this.tv_haveElectricity.setText(modal_vif.getV03());
        this.tv_haveGovtHosp.setText(modal_vif.getV04());
        this.tv_havePvtHosp.setText(modal_vif.getV05());
        this.tv_havePrePrimSchool.setText(modal_vif.getV06a());
        this.tv_havePrimSchool.setText(modal_vif.getV07a());*/
        String v06b_schoolType="";
        String v07b_schoolType="";
        if(modal_vif.getV06b().contains("1,"))
            v06b_schoolType = v06b_schoolType+"> "+ this.getString(R.string.str_government_public);
        if(modal_vif.getV06b().contains("2,")) {
            if(modal_vif.getV06b().contains("1,"))
               v06b_schoolType = v06b_schoolType + "\n> " + this.getString(R.string.str_private);
            else
               v06b_schoolType = v06b_schoolType + "> " + this.getString(R.string.str_private);
        }if(modal_vif.getV06b().contains("3,")) {
            if(modal_vif.getV06b().contains("1,") || modal_vif.getV06b().contains("2,"))
                v06b_schoolType = v06b_schoolType + "\n> " + this.getString(R.string.str_other);
            else
                v06b_schoolType = v06b_schoolType + "> " + this.getString(R.string.str_other);
        }

        if(modal_vif.getV07b().contains("1,"))
            v07b_schoolType = v07b_schoolType+"> "+ this.getString(R.string.str_government_public);
        if(modal_vif.getV07b().contains("2,")) {
            if(modal_vif.getV07b().contains("1,"))
                v07b_schoolType = v07b_schoolType + "\n> " + this.getString(R.string.str_private);
            else
                v07b_schoolType = v07b_schoolType + "> " + this.getString(R.string.str_private);
        }
        if(modal_vif.getV07b().contains("3,")) {
            if(modal_vif.getV07b().contains("1,") || modal_vif.getV07b().contains("2,"))
                v07b_schoolType = v07b_schoolType + "\n> " + this.getString(R.string.str_other);
            else
                v07b_schoolType = v07b_schoolType + "> " + this.getString(R.string.str_other);
        }
        this.tv_v06b_schoolType.setText(v06b_schoolType);
        this.tv_v07b_schoolType.setText(v07b_schoolType);
/*
        if(!vName.equalsIgnoreCase("NA")){
            this.fab_Edit_VIF.setImageResource(R.drawable.ic_add_white_64dp);
            this.addMode = "Add";
        }else{
            this.fab_Edit_VIF.setImageResource(R.drawable.ic_edit_white_24dp);
            this.addMode = "Edit";
            this.scroll_View.setVisibility(View.VISIBLE);
        }
*/
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @Click(R.id.fab_Edit_VIF)
    public void EditClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.VILLAGE_ID, villageId);
        bundle.putString(Kix_Constant.EDIT_VILLAGE,Kix_Constant.EDIT_VILLAGE);
        KIX_Utility.showFragment(getActivity(), new Fragment_AddVillageInformation_(), R.id.frag_frame,
                bundle, Fragment_AddVillageInformation.class.getSimpleName());

/*
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, "surveyorCode");
        KIX_Utility.showFragment(getActivity(), new Fragment_AddVillageInformation_(), R.id.frag_frame,
                bundle, Fragment_AddVillageInformation.class.getSimpleName());
*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        rv_village.setAdapter(null);
//        villageListAdapter = null;
//        rv_village = null;
    }
}
