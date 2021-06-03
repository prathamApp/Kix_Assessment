package com.kix.assessment.ui.household_activity;

import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import androidx.fragment.app.Fragment;

import static com.kix.assessment.KIXApplication.householdDao;

@EFragment(R.layout.fragment_add_household)
public class Fragment_AddHousehold extends Fragment {

    @ViewById(R.id.et_houseHoldName)
    TextInputEditText et_houseHoldName;
    @ViewById(R.id.et_houseHoldDistrict)
    TextInputEditText et_houseHoldDistrict;
    @ViewById(R.id.et_houseHoldState)
    TextInputEditText et_houseHoldState;

    String surveyorCode;
    public Fragment_AddHousehold() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
    }

    @Click(R.id.btn_saveHousehold)
    public void saveHousehold(){
        if(!et_houseHoldName.getText().toString().isEmpty() && !et_houseHoldDistrict.getText().toString().isEmpty()
                && !et_houseHoldState.getText().toString().isEmpty())
        insertHousehold();
        else Toast.makeText(getActivity(), "All fields are mandatory!", Toast.LENGTH_SHORT).show();
    }

    private void insertHousehold() {
        String houseID = KIX_Utility.getUUID().toString();
        Modal_Household modal_household = new Modal_Household();
        modal_household.setHouseholdId(""+ houseID);
        modal_household.setHouseholdName(et_houseHoldName.getText().toString());
        modal_household.setHouseholdDistrict(et_houseHoldDistrict.getText().toString());
        modal_household.setHouseholdState(et_houseHoldState.getText().toString());
        modal_household.setHouseholdAddress("NA");
        modal_household.setSvrCode(surveyorCode);
        modal_household.setSentFlag(0);
        householdDao.insertHousehold(modal_household);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Village Added Successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), Activity_Household_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, houseID);
        startActivity(intent);
    }

}
