package com.kix.assessment.ui.village_activity.FragmentSelectVillage;

import static com.kix.assessment.KIXApplication.villageDao;
import static com.kix.assessment.KIXApplication.villageInformationDao;

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
import com.kix.assessment.modal_classes.Modal_VIF;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.household_activity.Activity_Household_;
import com.kix.assessment.ui.village_activity.Fragment_AddVillage;
import com.kix.assessment.ui.village_activity.Fragment_AddVillage_;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation_;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_VillageInformation;
import com.kix.assessment.ui.village_activity.village_information_form.Fragment_VillageInformation_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_select_village)
public class Fragment_SelectVillage extends Fragment implements ContractVillageList {

    @ViewById(R.id.rv_village)
    RecyclerView rv_village;

    @ViewById(R.id.fab_addVillage)
    FloatingActionButton fab_addVillage;

    private ArrayList<Modal_Village> villageArrayList = new ArrayList<>();
    private boolean itemSelected;
    String surveyorCode, villageID;
    Modal_Village village = new Modal_Village();

    private VillageListAdapter villageListAdapter;

    public Fragment_SelectVillage() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        Log.e("KIX : ", "selectstud");
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        villageArrayList = (ArrayList<Modal_Village>) villageDao.getAllVillageBySurveyorCode(surveyorCode);
        if (villageArrayList.size() == 0) {
            Toast.makeText(getActivity(), "No Village Found.", Toast.LENGTH_SHORT).show();
            Animation anim = android.view.animation.AnimationUtils.loadAnimation(fab_addVillage.getContext(), R.anim.shake);
            anim.setDuration(200L);
            fab_addVillage.startAnimation(anim);
        }
        initializeAdapter();
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @UiThread
    public void initializeAdapter() {
        FastSave.getInstance().saveString(Kix_Constant.COUNTRY, "NA");
        if (villageListAdapter == null) {
            villageListAdapter = new VillageListAdapter(villageArrayList, getActivity(), this);
            rv_village.setHasFixedSize(true);
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getActivity(), FlexDirection.ROW);
            flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
            flexboxLayoutManager.setAlignItems(AlignItems.CENTER);
            rv_village.setLayoutManager(flexboxLayoutManager);
            rv_village.setAdapter(villageListAdapter);
        } else {
            villageListAdapter.notifyDataSetChanged();
        }
    }

    @Click(R.id.fab_addVillage)
    public void addVillage() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        KIX_Utility.showFragment(getActivity(), new Fragment_AddVillage_(), R.id.frag_frame,
                bundle, Fragment_AddVillage.class.getSimpleName());
    }

    @Override
    public void itemSelected(int position) {
        final Modal_Village modal_village = this.villageListAdapter.getitem(position);
        FastSave.getInstance().saveString(Kix_Constant.BOOKLET,modal_village.getVillageBooklet());
//        Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
//        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
//        intent.putExtra(Kix_Constant.VILLAGE_ID, modal_village.villageId);
//        FastSave.getInstance().saveString(Kix_Constant.COUNTRY, modal_village.getCountryName());
//        if (!FastSave.getInstance().getString(Kix_Constant.COUNTRY, "NA").equalsIgnoreCase("NA"))
//            startActivity(intent);
        Intent intent = new Intent(this.getActivity(), Activity_Household_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        intent.putExtra(Kix_Constant.VILLAGE_ID,modal_village.villageId);
        FastSave.getInstance().saveString(Kix_Constant.COUNTRY, modal_village.getCountryName());
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        this.startActivity(intent);
    }

    @Override
    public void addVIF(int position){
        Modal_Village modal_village = villageListAdapter.getitem(position);
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.VILLAGE_ID, modal_village.getVillageId());

        final Modal_VIF modal_vif = villageInformationDao.getVIFbyVillageId(modal_village.getVillageId());
        if(modal_vif!=null){
            KIX_Utility.showFragment(getActivity(), new Fragment_VillageInformation_(), R.id.frag_frame,
                    bundle, Fragment_VillageInformation.class.getSimpleName());
        } else {
            KIX_Utility.showFragment(getActivity(), new Fragment_AddVillageInformation_(), R.id.frag_frame,
                    bundle, Fragment_AddVillageInformation.class.getSimpleName());
        }
    }

    @Override
    public void editVillage(int position) {
        Modal_Village modal_village = villageListAdapter.getitem(position);
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.EDIT_VILLAGE, Kix_Constant.EDIT_VILLAGE);
        bundle.putString(Kix_Constant.VILLAGE_ID, modal_village.getVillageId());
        KIX_Utility.showFragment(getActivity(), new Fragment_AddVillage_(), R.id.frag_frame,
                bundle, Fragment_AddVillage.class.getSimpleName());
    }

    @Click(R.id.fab_profile)
    public void profile() {
/*        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        bundle.putString(Kix_Constant.HOUSEHOLD_ID, householdID);
        KIX_Utility.showFragment(getActivity(), new Fragment_Profile_(), R.id.household_frame,
                bundle, Fragment_Profile.class.getSimpleName());*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_village.setAdapter(null);
        villageListAdapter = null;
        rv_village = null;
    }
}
