package com.kix.assessment.ui.household_activity;

import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_add_household)
public class Fragment_AddHousehold extends Fragment {

/*    @ViewById(R.id.et_houseHoldName)
    TextInputEditText et_houseHoldName;
    @ViewById(R.id.et_houseHoldDistrict)
    TextInputEditText et_houseHoldDistrict;
    @ViewById(R.id.et_houseHoldState)
    TextInputEditText et_houseHoldState;

    @ViewById(R.id.tv_label)
    TextView tv_label;
    String surveyorCode, villageId, selectedLanguageCode;
    ArrayAdapter adapterCountry;*/
    String surveyorCode, villageId, selectedLanguageCode;

    public Fragment_AddHousehold() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        if (this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
/*            villageId = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
            Modal_Household modalVillage = householdDao.getVillageByVillId(villageId);
            tv_label.setText("Edit Village");
            et_houseHoldName.setText(modalVillage.getHouseholdName());
            et_houseHoldDistrict.setText(modalVillage.getHouseholdDistrict());
            et_houseHoldState.setText(modalVillage.getHouseholdState());*/
        }
        this.surveyorCode = this.getArguments().getString(Kix_Constant.SURVEYOR_CODE);
    }

/*
    @Click(R.id.btn_saveHousehold)
    public void saveHousehold() {
        if (!et_houseHoldName.getText().toString().isEmpty() && !et_houseHoldDistrict.getText().toString().isEmpty()
                && !et_houseHoldState.getText().toString().isEmpty()) {
            if (getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
                householdDao.updateVillage(et_houseHoldName.getText().toString(),
                        et_houseHoldDistrict.getText().toString(),
                        et_houseHoldState.getText().toString(),
                        villageId, FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India"));
                Toast.makeText(getActivity(), "Village Edited Successfully!", Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();
            }else
                insertHousehold();
        } else
            Toast.makeText(getActivity(), "All fields are mandatory!", Toast.LENGTH_SHORT).show();
    }

    private void insertHousehold() {
        String houseID = KIX_Utility.getUUID().toString();
        Modal_Household modal_household = new Modal_Household();
        modal_household.setHouseholdId("" + houseID);
        modal_household.setHouseholdName(et_houseHoldName.getText().toString());
        modal_household.setHouseholdDistrict(et_houseHoldDistrict.getText().toString());
        modal_household.setHouseholdState(et_houseHoldState.getText().toString());
        modal_household.setHouseholdAddress("NA");
        modal_household.setHouseholdDate("" + KIX_Utility.getCurrentDateTime());
        modal_household.setSvrCode(surveyorCode);
        modal_household.setCountryName(FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India"));
        modal_household.setSentFlag(0);
        householdDao.insertHousehold(modal_household);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Village Added Successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), Activity_Household_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, houseID);
        startActivity(intent);
    }
*/

}
