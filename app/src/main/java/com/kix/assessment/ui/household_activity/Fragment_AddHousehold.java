package com.kix.assessment.ui.household_activity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

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
    EditText et_houseHoldName;

    @ViewById(R.id.et_houseHoldAddress)
    EditText et_houseHoldAddress;

    String surveyorCode;
    public Fragment_AddHousehold() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
    }

    @Click(R.id.btn_saveHousehold)
    public void saveStudent(){
        insertHousehold();
    }

    private void insertHousehold() {
        String houseID = KIX_Utility.getUUID().toString();
        Modal_Household modal_household = new Modal_Household();
        modal_household.setHouseHold_ID(""+ houseID);
        modal_household.setHouseHold_Name(et_houseHoldName.getText().toString());
        modal_household.setHouseHold_Address(et_houseHoldAddress.getText().toString());
        modal_household.setSvr_Code(surveyorCode);
        householdDao.insertHousehold(modal_household);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Household Added Successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), Activity_Household_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, houseID);
        startActivity(intent);
    }

}
