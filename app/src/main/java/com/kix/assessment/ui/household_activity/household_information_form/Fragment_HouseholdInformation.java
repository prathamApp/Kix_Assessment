package com.kix.assessment.ui.household_activity.household_information_form;

import static com.kix.assessment.KIXApplication.villageDao;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kix.assessment.R;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_information_village)
public class Fragment_HouseholdInformation extends Fragment {

    @ViewById(R.id.scroll_View)
    ScrollView scroll_View;
    @ViewById(R.id.fab_Edit_VIF)
    FloatingActionButton fab_Edit_VIF;

    String villageId, addMode="";

    public Fragment_HouseholdInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        this.villageId = this.getArguments().getString(Kix_Constant.VILLAGE_ID);
        final Modal_Village modalVillage = villageDao.getVillageByVillId(this.villageId);
//        scroll_View.setVisibility(View.GONE);
        String vName = "NA";
        vName = modalVillage.getVillageName();

        if(!vName.equalsIgnoreCase("NA")){
            this.fab_Edit_VIF.setImageResource(R.drawable.ic_add_white_64dp);
            this.addMode = "Add";
        }else{
            this.fab_Edit_VIF.setImageResource(R.drawable.ic_edit_white_24dp);
            this.addMode = "Edit";
            this.scroll_View.setVisibility(View.VISIBLE);
        }
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
