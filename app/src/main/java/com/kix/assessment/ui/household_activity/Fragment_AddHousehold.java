package com.kix.assessment.ui.household_activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static com.kix.assessment.KIXApplication.householdDao;

@EFragment(R.layout.fragment_add_household)
public class Fragment_AddHousehold extends Fragment {

    @ViewById(R.id.tv_label)
    TextView tv_title;

    @ViewById(R.id.et_HH00_hName)
    EditText et_householdName;

    @ViewById(R.id.et_HH01_respondentName)
    EditText et_respondentName;

    @ViewById(R.id.et_HH02_houseHeadName)
    EditText et_houseHeadName;

    @ViewById(R.id.et_HH03_memberCount)
    EditText et_memberCount;

    @ViewById(R.id.et_HH04_houseHeadNum)
    EditText et_telephoneNum;

    @ViewById(R.id.et_HH05b_houseAge)
    EditText et_noOfChilds;

    @ViewById(R.id.til_HH05b)
    TextInputLayout til_noOfChilds;

    @ViewById(R.id.rg_HH05a)
    RadioGroup rg_haveChildren;

    @ViewById(R.id.rg_HH06)
    RadioGroup rg_speakLang;

    @ViewById(R.id.btn_saveHousehold)
    Button btn_saveAndEdit;

    RadioButton rb_HH05a, rb_HH06;

    String surveyorCode, villageId, selectedLanguageCode, householdId;

    public Fragment_AddHousehold() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        surveyorCode = FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, "NA");
        villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);
        householdId = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);

        Log.e("hhh : ", householdId+" | "+villageId);

        if (getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
            tv_title.setText("Edit Household");
            Modal_Household modal_household = householdDao.getHouseholdBySurveyorCode(householdId, villageId);
            et_householdName.setText(modal_household.getHouseholdName());
            et_respondentName.setText(modal_household.getHH01());
            et_houseHeadName.setText(modal_household.getHH02());
            et_memberCount.setText(modal_household.getHH03());
            et_telephoneNum.setText(modal_household.getHH04());
            et_noOfChilds.setText(modal_household.getHH05b());

            if (modal_household.getHH05a().equalsIgnoreCase(Kix_Constant.YES)) {
                rg_haveChildren.check(R.id.rb_HH05a_yes);
                til_noOfChilds.setVisibility(View.VISIBLE);
            } else rg_haveChildren.check(R.id.rb_HH05a_No);

            if (modal_household.getHH06().equalsIgnoreCase(getString(R.string.str_HH06a))){
                rg_speakLang.check(R.id.rb_HH06_same);
            } else rg_speakLang.check(R.id.rb_HH06_diff);

            btn_saveAndEdit.setText("Edit");
        }

        rg_haveChildren.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_HH05a_yes:
                    til_noOfChilds.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_HH05a_No:
                    til_noOfChilds.setVisibility(View.GONE);
                    break;
            }
        });
    }

    @Click(R.id.btn_saveHousehold)
    public void saveHousehold() {
        getRadioButtonValues();
        if(!et_householdName.getText().toString().isEmpty() && !et_respondentName.getText().toString().isEmpty()){
            if(rb_HH05a!=null && rb_HH06!=null) {
                if (getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
                    householdDao.updateHousehold(
                            et_householdName.getText().toString(),
                            et_respondentName.getText().toString(),
                            et_houseHeadName.getText().toString(),
                            et_memberCount.getText().toString(),
                            et_telephoneNum.getText().toString(),
                            rb_HH05a.getText().toString(),
                            et_noOfChilds.getText().toString(),
                            rb_HH06.getText().toString(),
                            householdId,
                            villageId);
                    Toast.makeText(this.getActivity(), "Household Edited Successfully!", Toast.LENGTH_SHORT).show();
                    this.getFragmentManager().popBackStack();
                } else {
                    insertHousehold();
                }
            } else {
                Toast.makeText(getActivity(), "Please select radio button fields.", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(getActivity(), "Household and Respondent names are Mandatory!", Toast.LENGTH_SHORT).show();
        }
    }
    /*    if (!et_houseHoldName.getText().toString().isEmpty() && !et_houseHoldDistrict.getText().toString().isEmpty()
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
    }*/
    private void insertHousehold() {
        getRadioButtonValues();
        String str_haveChildren;
        String str_speakLanguage;

        if(rb_HH05a==null) str_haveChildren="";
        else str_haveChildren = rb_HH05a.getText().toString();
        if(rb_HH06==null) str_speakLanguage="";
        else str_speakLanguage = rb_HH06.getText().toString();

        String houseID = KIX_Utility.getUUID().toString();
        Modal_Household modal_household = new Modal_Household();
        modal_household.setHouseholdId(houseID);
        modal_household.setHouseholdName(et_householdName.getText().toString());
        modal_household.setHH01(et_respondentName.getText().toString());
        modal_household.setHH02(et_houseHeadName.getText().toString());
        modal_household.setHH03(et_memberCount.getText().toString());
        modal_household.setHH04(et_telephoneNum.getText().toString());
        modal_household.setHH05a(str_haveChildren);
        modal_household.setHH05b(et_noOfChilds.getText().toString());
        modal_household.setHH06(str_speakLanguage);
        modal_household.setCreatedOn("" + KIX_Utility.getCurrentDateTime());
        modal_household.setsvrCode(surveyorCode);
        modal_household.setVillageId(villageId);
        modal_household.setSentFlag(0);
        householdDao.insertHousehold(modal_household);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Household Added Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
/*        Intent intent = new Intent(getActivity(), Activity_Household_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.VILLAGE_ID, villageId);
        startActivity(intent);*/
    }

    public void getRadioButtonValues(){
        int selectedHH05a = rg_haveChildren.getCheckedRadioButtonId();
        int selectedHH06 = rg_speakLang.getCheckedRadioButtonId();

        rb_HH05a = getView().findViewById(selectedHH05a);
        rb_HH06 = getView().findViewById(selectedHH06);

    }

}
