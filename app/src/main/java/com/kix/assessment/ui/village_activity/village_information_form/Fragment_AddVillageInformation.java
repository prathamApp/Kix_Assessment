package com.kix.assessment.ui.village_activity.village_information_form;

import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_add_information_village)
public class Fragment_AddVillageInformation extends Fragment {

//    @ViewById(R.id.ll_V06b)
//    LinearLayout ll_V06b;

    @ViewById(R.id.ll_V06b)
    LinearLayout ll_V06b;
    @ViewById(R.id.ch1_V06b)
    CheckBox ch1_V06b;
    @ViewById(R.id.ch2_V06b)
    CheckBox ch2_V06b;
    @ViewById(R.id.ch3_V06b)
    CheckBox ch3_V06b;

    @ViewById(R.id.ll_V07b)
    LinearLayout ll_V07b;
    @ViewById(R.id.ch1_V07b)
    CheckBox ch1_V07b;
    @ViewById(R.id.ch2_V07b)
    CheckBox ch2_V07b;
    @ViewById(R.id.ch3_V07b)
    CheckBox ch3_V07b;


    public Fragment_AddVillageInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @UiThread
    public void initializeAdapter() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        rv_village.setAdapter(null);
//        villageListAdapter = null;
//        rv_village = null;
    }
}
