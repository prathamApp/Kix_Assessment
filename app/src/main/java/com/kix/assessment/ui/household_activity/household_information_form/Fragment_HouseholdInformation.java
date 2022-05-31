package com.kix.assessment.ui.household_activity.household_information_form;

import static com.kix.assessment.KIXApplication.householdDao;
import static com.kix.assessment.KIXApplication.householdInformationDao;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_HIF;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_information_household)
public class Fragment_HouseholdInformation extends Fragment {


    @ViewById(R.id.tv_HH06a_val)
    TextView tv_members;
    @ViewById(R.id.tv_HH06b_val)
    TextView tv_speakEnglish;
    @ViewById(R.id.tv_HH06c_val)
    TextView tv_howOften;
    @ViewById(R.id.tv_HH06d_val)
    TextView tv_otherLang;
    @ViewById(R.id.tv_HH07a_val)
    TextView tv_roof;
    @ViewById(R.id.tv_HH07b_val)
    TextView tv_wall;
    @ViewById(R.id.tv_HH07c_val)
    TextView tv_lightSource;
    @ViewById(R.id.tv_HH07d_val)
    TextView tv_waterSource;
    @ViewById(R.id.tv_HH07e_val)
    TextView tv_electricity;
    @ViewById(R.id.tv_HH07f_val)
    TextView tv_toilet;
    @ViewById(R.id.tv_HH07g_val)
    TextView tv_memberCompletedDiploma;
    @ViewById(R.id.tv_HH07h_val)
    TextView tv_readingMaterial;
    @ViewById(R.id.tv_HH07i_val)
    TextView tv_computer;
    @ViewById(R.id.tv_HH07j_val)
    TextView tv_television;
    @ViewById(R.id.tv_HH07k_val)
    TextView tv_radio;
    @ViewById(R.id.tv_HH07l_val)
    TextView tv_mobile;
    @ViewById(R.id.tv_HH07m_val)
    TextView tv_isItSmartphone;
    @ViewById(R.id.tv_HH07n_val)
    TextView tv_fourWheeler;
    @ViewById(R.id.tv_HH07o_val)
    TextView tv_twoWheeler;
    @ViewById(R.id.tv_HH07p_val)
    TextView tv_bicycle;
    @ViewById(R.id.tv_HH07q_val)
    TextView tv_otherBook;

    @ViewById(R.id.scroll_View)
    ScrollView scroll_View;
    @ViewById(R.id.fab_Edit_VIF)
    FloatingActionButton fab_Edit_VIF;

    String householdId, addMode="";

    public Fragment_HouseholdInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        this.householdId = this.getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        Modal_Household modalHousehold = householdDao.getHouseholdByHouseholdId(householdId);
        Modal_HIF modalHif = householdInformationDao.getHIFbyHouseholdId(householdId);

        tv_members.setText(modalHif.HH06a);
        tv_speakEnglish.setText(modalHif.HH06b);
        tv_howOften.setText(modalHif.HH06c);
        tv_otherLang.setText(modalHif.HH06d);
        tv_roof.setText(modalHif.HH07a);
        tv_wall.setText(modalHif.HH07b);
        if(modalHif.HH07c.equalsIgnoreCase(getString(R.string.str_HH07c_four))) tv_lightSource.setText(modalHif.HH07cOther);
        else tv_lightSource.setText(modalHif.HH07c);
        if(modalHif.HH07d.equalsIgnoreCase(getString(R.string.str_HH07d_seven))) tv_waterSource.setText(modalHif.HH07dOther);
        else tv_waterSource.setText(modalHif.HH07d);
        tv_electricity.setText(modalHif.HH07e);
        tv_toilet.setText(modalHif.HH07f);
        tv_memberCompletedDiploma.setText(modalHif.HH07g);
        tv_readingMaterial.setText(modalHif.HH07h);
        tv_otherBook.setText(modalHif.HH07q);
        tv_computer.setText(modalHif.HH07i);
        tv_television.setText(modalHif.HH07j);
        tv_radio.setText(modalHif.HH07k);
        tv_mobile.setText(modalHif.HH07l);
        tv_isItSmartphone.setText(modalHif.HH07m);
        tv_fourWheeler.setText(modalHif.HH07n);
        tv_twoWheeler.setText(modalHif.HH07o);
        tv_bicycle.setText(modalHif.HH07p);

        if(modalHif.getHH06b().equalsIgnoreCase("Yes")) tv_speakEnglish.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_speakEnglish.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH06d().equalsIgnoreCase("Yes")) tv_otherLang.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_otherLang.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07e().equalsIgnoreCase("Yes")) tv_electricity.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_electricity.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07f().equalsIgnoreCase("Yes")) tv_toilet.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_toilet.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07g().equalsIgnoreCase("Yes")) tv_memberCompletedDiploma.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_memberCompletedDiploma.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07h().equalsIgnoreCase("Yes")) tv_readingMaterial.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_readingMaterial.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07i().equalsIgnoreCase("Yes")) tv_computer.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_computer.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07j().equalsIgnoreCase("Yes")) tv_television.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_television.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07k().equalsIgnoreCase("Yes")) tv_radio.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_radio.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07l().equalsIgnoreCase("Yes")) tv_mobile.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_mobile.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07m().equalsIgnoreCase("Yes")) tv_isItSmartphone.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_isItSmartphone.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07n().equalsIgnoreCase("Yes")) tv_fourWheeler.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_fourWheeler.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07o().equalsIgnoreCase("Yes")) tv_twoWheeler.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_twoWheeler.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07p().equalsIgnoreCase("Yes")) tv_bicycle.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_bicycle.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalHif.getHH07q().equalsIgnoreCase("Yes")) tv_otherBook.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_otherBook.setBackgroundResource(R.drawable.rounded_bg_red);

    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @Click(R.id.fab_Edit_HIF)
    public void EditClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.HOUSEHOLD_ID, householdId);
        bundle.putString(Kix_Constant.EDIT_HOUSEHOLD,Kix_Constant.EDIT_HOUSEHOLD);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddHouseholdInformation_(), R.id.household_frame,
                bundle, Fragment_AddHouseholdInformation.class.getSimpleName());

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
