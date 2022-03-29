package com.kix.assessment.ui.village_activity.village_information_form;

import static com.kix.assessment.KIXApplication.villageDao;
import static com.kix.assessment.KIXApplication.villageInformationDao;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.UiThread;
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
        this.villageId = this.getArguments().getString(Kix_Constant.VILLAGE_ID);
        final Modal_Village modalVillage = villageDao.getVillageByVillId(this.villageId);
        final Modal_VIF modal_vif = villageInformationDao.getVIFbyVillageId(villageId);
        String vName = "NA";
        vName = modalVillage.getVillageName();
        if(modal_vif.getV01().equalsIgnoreCase("Yes")) tv_haveRoad.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_haveRoad.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modal_vif.getV02().equalsIgnoreCase("Yes")) tv_haveTransport.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_haveTransport.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modal_vif.getV03().equalsIgnoreCase("Yes")) tv_haveElectricity.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_haveElectricity.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modal_vif.getV04().equalsIgnoreCase("Yes")) tv_haveGovtHosp.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_haveGovtHosp.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modal_vif.getV05().equalsIgnoreCase("Yes")) tv_havePvtHosp.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_havePvtHosp.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modal_vif.getV06a().equalsIgnoreCase("Yes")) tv_havePrePrimSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_havePrePrimSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modal_vif.getV07a().equalsIgnoreCase("Yes")) tv_havePrimSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_havePrimSchool.setBackgroundResource(R.drawable.rounded_bg_red);

        tv_haveRoad.setText(modal_vif.getV01());
        tv_haveTransport.setText(modal_vif.getV02());
        tv_haveElectricity.setText(modal_vif.getV03());
        tv_haveGovtHosp.setText(modal_vif.getV04());
        tv_havePvtHosp.setText(modal_vif.getV05());
        tv_havePrePrimSchool.setText(modal_vif.getV06a());
        tv_havePrimSchool.setText(modal_vif.getV07a());
        tv_v06b_schoolType.setText(modal_vif.getV06b());
        tv_v07b_schoolType.setText(modal_vif.getV07b());



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
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @UiThread
    public void initializeAdapter() {
    }

    @Click(R.id.fab_Edit_VIF)
    public void EditClicked() {
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.VILLAGE_ID, this.villageId);
        bundle.putString(Kix_Constant.EDIT_VILLAGE,Kix_Constant.EDIT_VILLAGE);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddVillageInformation_(), R.id.frag_frame,
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
