package com.kix.assessment.ui.household_activity.FragmentSelectHousehold;

import static com.kix.assessment.KIXApplication.householdDao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kix.assessment.R;
import com.kix.assessment.custom.flexbox.AlignItems;
import com.kix.assessment.custom.flexbox.FlexDirection;
import com.kix.assessment.custom.flexbox.FlexboxLayoutManager;
import com.kix.assessment.custom.flexbox.JustifyContent;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.attendance_activity.Activity_Attendance_;
import com.kix.assessment.ui.fragment_profile.Fragment_Profile;
import com.kix.assessment.ui.fragment_profile.Fragment_Profile_;
import com.kix.assessment.ui.household_activity.Fragment_AddHousehold;
import com.kix.assessment.ui.household_activity.Fragment_AddHousehold_;
import com.kix.assessment.ui.household_activity.household_information_form.Fragment_AddHouseholdInformation;
import com.kix.assessment.ui.household_activity.household_information_form.Fragment_AddHouseholdInformation_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_select_household)
public class Fragment_SelectHousehold extends Fragment implements ContractHouseholdList {

    @ViewById(R.id.rv_houseHold)
    RecyclerView rv_houseHold;

    @ViewById(R.id.fab_addVillage)
    FloatingActionButton fab_addVillage;

    private ArrayList<Modal_Household> households = new ArrayList<>();
    private boolean itemSelected;
    String surveyorCode, householdID, villageId, householdId;
    Modal_Household add_household = new Modal_Household();

    private HouseholdListAdapter householdListAdapter;

    public Fragment_SelectHousehold() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        Log.e("KIX : ", "selectstud");
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);

//        households = getArguments() != null ? getArguments().getParcelableArrayList(Kix_Constant.HOUSEHOLD_LIST) : null;
        this.households = (ArrayList<Modal_Household>) householdDao.getAllHouseholdBySurveyorCodeDescending(surveyorCode, villageId);
        if (this.households.size() == 0) {
            Toast.makeText(this.getActivity(), "No Household Found.", Toast.LENGTH_SHORT).show();
            final Animation anim = android.view.animation.AnimationUtils.loadAnimation(this.fab_addVillage.getContext(), R.anim.shake);
            anim.setDuration(200L);
            this.fab_addVillage.startAnimation(anim);
        }
/*        add_household.setHouseHold_Name("Add Village");
        if (!households.contains(add_household)){
            households.add(add_household);
        }*/
        this.initializeAdapter();
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @UiThread
    public void initializeAdapter() {
        FastSave.getInstance().saveString(Kix_Constant.COUNTRY, "NA");
        if (this.householdListAdapter == null) {
            this.householdListAdapter = new HouseholdListAdapter(this.households, this.getActivity(), this);
            this.rv_houseHold.setHasFixedSize(true);
            final FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this.getActivity(), FlexDirection.ROW);
            flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
            flexboxLayoutManager.setAlignItems(AlignItems.CENTER);
            this.rv_houseHold.setLayoutManager(flexboxLayoutManager);
            this.rv_houseHold.setAdapter(this.householdListAdapter);
        } else {
            this.householdListAdapter.notifyDataSetChanged();
        }
    }

    @Click(R.id.fab_addVillage)
    public void addHousehold() {
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        bundle.putString(Kix_Constant.VILLAGE_ID, villageId);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddHousehold_(), R.id.household_frame,
                bundle, Fragment_AddHousehold.class.getSimpleName());
    }

    @Override
    public void itemSelected(final int position) {
        Log.e("kix p : ",String.valueOf(position));
        /*Bundle bundle = new Bundle();
        if (position == households.size() - 1) {
            bundle.putString(Kix_Constant.SURVEYOR_CODE, surveyorCode);
            KIX_Utility.showFragment(getActivity(), new Fragment_AddVillage_(), R.id.household_frame,
                    bundle, Fragment_AddVillage.class.getSimpleName());
        } else {*/
        final Modal_Household modalHousehold = householdListAdapter.getitem(position);
        final Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, modalHousehold.householdId);
        startActivity(intent);
        //}
    }

    @Override
    public void editHousehold(final int position) {
        final Modal_Household modalHousehold = this.householdListAdapter.getitem(position);
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.EDIT_HOUSEHOLD, Kix_Constant.EDIT_HOUSEHOLD);
        bundle.putString(Kix_Constant.HOUSEHOLD_ID, modalHousehold.householdId);
        bundle.putString(Kix_Constant.VILLAGE_ID, modalHousehold.villageId);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddHousehold_(), R.id.household_frame,
                bundle, Fragment_AddHousehold.class.getSimpleName());
    }

    @Override
    public void addHIF(final int position) {
        final Modal_Household modalHousehold = this.householdListAdapter.getitem(position);
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.EDIT_VILLAGE, Kix_Constant.EDIT_VILLAGE);

        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddHouseholdInformation_(), R.id.household_frame,
                bundle, Fragment_AddHouseholdInformation.class.getSimpleName());
    }

    @Click(R.id.fab_profile)
    public void profile() {
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        bundle.putString(Kix_Constant.HOUSEHOLD_ID, this.householdID);
        bundle.putString(Kix_Constant.VILLAGE_ID, this.villageId);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_Profile_(), R.id.household_frame,
                bundle, Fragment_Profile.class.getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.rv_houseHold.setAdapter(null);
        this.householdListAdapter = null;
        this.rv_houseHold = null;
    }
}
