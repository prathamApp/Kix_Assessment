package com.kix.assessment.ui.household_activity.FragmentSelectHousehold;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kix.assessment.R;
import com.kix.assessment.custom.flexbox.AlignItems;
import com.kix.assessment.custom.flexbox.FlexDirection;
import com.kix.assessment.custom.flexbox.FlexboxLayoutManager;
import com.kix.assessment.custom.flexbox.JustifyContent;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.ui.attendance_activity.Activity_Attendance_;
import com.kix.assessment.ui.fragment_profile.Fragment_Profile;
import com.kix.assessment.ui.fragment_profile.Fragment_Profile_;
import com.kix.assessment.ui.household_activity.Fragment_AddHousehold;
import com.kix.assessment.ui.household_activity.Fragment_AddHousehold_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import static com.kix.assessment.KIXApplication.householdDao;

@EFragment(R.layout.fragment_select_household)
public class Fragment_SelectHousehold extends Fragment implements ContractHouseholdList {

    @ViewById(R.id.rv_houseHold)
    RecyclerView rv_houseHold;

    @ViewById(R.id.fab_addVillage)
    FloatingActionButton fab_addVillage;

    private ArrayList<Modal_Household> households = new ArrayList<>();
    private boolean itemSelected;
    String surveyorCode, householdID;
    Modal_Household add_household = new Modal_Household();

    private HouseholdListAdapter householdListAdapter;

    public Fragment_SelectHousehold() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        Log.e("KIX : ", "selectstud");
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
//        households = getArguments() != null ? getArguments().getParcelableArrayList(Kix_Constant.HOUSEHOLD_LIST) : null;
        households = (ArrayList<Modal_Household>) householdDao.getAllHouseholdBySurveyorCodeDescending(surveyorCode);
        if(households.size()==0){
            Toast.makeText(getActivity(), "No Village Found.", Toast.LENGTH_SHORT).show();
            Animation anim = android.view.animation.AnimationUtils.loadAnimation(fab_addVillage.getContext(),  R.anim.shake);
            anim.setDuration(200L);
            fab_addVillage.startAnimation(anim);
        }
/*        add_household.setHouseHold_Name("Add Village");
        if (!households.contains(add_household)){
            households.add(add_household);
        }*/
        initializeAdapter();
    }

    @UiThread
    public void initializeAdapter() {
        if (householdListAdapter == null) {
            householdListAdapter = new HouseholdListAdapter(households, getActivity(), Fragment_SelectHousehold.this);
            rv_houseHold.setHasFixedSize(true);
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getActivity(), FlexDirection.ROW);
            flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
            flexboxLayoutManager.setAlignItems(AlignItems.CENTER);
            rv_houseHold.setLayoutManager(flexboxLayoutManager);
            rv_houseHold.setAdapter(householdListAdapter);
        } else {
            householdListAdapter.notifyDataSetChanged();
        }
    }

    @Click(R.id.fab_addVillage)
    public void addVillage() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        KIX_Utility.showFragment(getActivity(), new Fragment_AddHousehold_(), R.id.household_frame,
                bundle, Fragment_AddHousehold.class.getSimpleName());
    }

    @Override
    public void itemSelected(int position) {
        /*Bundle bundle = new Bundle();
        if (position == households.size() - 1) {
            bundle.putString(Kix_Constant.SURVEYOR_CODE, surveyorCode);
            KIX_Utility.showFragment(getActivity(), new Fragment_AddHousehold_(), R.id.household_frame,
                    bundle, Fragment_AddHousehold.class.getSimpleName());
        } else {*/
            Modal_Household modalHousehold = householdListAdapter.getitem(position);
            Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
            intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
            intent.putExtra(Kix_Constant.HOUSEHOLD_ID, modalHousehold.householdId);
            startActivity(intent);
        //}
    }

    @Override
    public void editVillage(int position) {
        Modal_Household modalHousehold = householdListAdapter.getitem(position);
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.EDIT_VILLAGE,Kix_Constant.EDIT_VILLAGE);
        bundle.putString(Kix_Constant.HOUSEHOLD_ID,modalHousehold.getHouseholdId());
        KIX_Utility.showFragment(getActivity(), new Fragment_AddHousehold_(), R.id.household_frame,
                bundle, Fragment_AddHousehold.class.getSimpleName());
    }

    @Click(R.id.fab_profile)
    public void profile() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        bundle.putString(Kix_Constant.HOUSEHOLD_ID, householdID);
        KIX_Utility.showFragment(getActivity(), new Fragment_Profile_(), R.id.household_frame,
                bundle, Fragment_Profile.class.getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_houseHold.setAdapter(null);
        householdListAdapter = null;
        rv_houseHold = null;
    }
}
