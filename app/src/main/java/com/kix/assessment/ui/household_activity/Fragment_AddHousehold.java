package com.kix.assessment.ui.household_activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
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

    @ViewById(R.id.rg_isSampledHH)
    RadioGroup rg_isSampledHH;

    @ViewById(R.id.sv_household)
    ScrollView sv_householdDetail;

    @ViewById(R.id.et_HH01)
    EditText et_hhNumber;

    @ViewById(R.id.et_HH02_respondentName)
    EditText et_respondentName;

    @ViewById(R.id.et_HH03_houseHeadName)
    EditText et_houseHeadName;

    @ViewById(R.id.et_HH05_mobile)
    EditText et_telephoneNum;

    @ViewById(R.id.et_HH04b_noOfChild)
    EditText et_noOfChilds;

    @ViewById(R.id.til_HH04b)
    TextInputLayout til_noOfChilds;

    @ViewById(R.id.rg_HH04a)
    RadioGroup rg_haveChildren;

    @ViewById(R.id.btn_saveHousehold)
    Button btn_saveAndEdit;

    @ViewById(R.id.ll_isSampledHH)
    LinearLayout ll_isSampledHH;

    RadioButton rb_HH04a;

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
            ll_isSampledHH.setVisibility(View.GONE);
            sv_householdDetail.setVisibility(View.VISIBLE);
            tv_title.setText("Update Household");
            Modal_Household modal_household = householdDao.getHouseholdBySurveyorCode(householdId, villageId);
            et_hhNumber.setText(modal_household.getHH01());
            et_respondentName.setText(modal_household.getHH02());
            et_houseHeadName.setText(modal_household.getHH03());
            et_telephoneNum.setText(modal_household.getHH05());
            et_noOfChilds.setText(modal_household.getHH04b());

            if (modal_household.getHH04a().equalsIgnoreCase(Kix_Constant.YES)) {
                rg_haveChildren.check(R.id.rb_HH04a_yes);
                til_noOfChilds.setVisibility(View.VISIBLE);
            } else rg_haveChildren.check(R.id.rb_HH04a_No);
            
            btn_saveAndEdit.setText("Update");
        }

        rg_haveChildren.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_HH04a_yes:
                    til_noOfChilds.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_HH04a_No:
                    til_noOfChilds.setVisibility(View.GONE);
                    et_noOfChilds.setText("");
                    break;
            }
        });

        rg_isSampledHH.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_isSampledHH_one:
                case R.id.rb_isSampledHH_two:
                    sv_householdDetail.setVisibility(View.GONE);
                    break;

                case R.id.rb_isSampledHH_three:
                    sv_householdDetail.setVisibility(View.VISIBLE);
            }
        });
    }

    @Click(R.id.btn_saveHousehold)
    public void saveHousehold() {
        getRadioButtonValues();
        if(!et_hhNumber.getText().toString().isEmpty() && !et_respondentName.getText().toString().isEmpty()){
            if(rb_HH04a!=null) {
                if (getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
                    householdDao.updateHousehold(
                            et_hhNumber.getText().toString(),
                            et_respondentName.getText().toString(),
                            et_houseHeadName.getText().toString(),
                            et_telephoneNum.getText().toString(),
                            rb_HH04a.getText().toString(),
                            et_noOfChilds.getText().toString(),
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
            Toast.makeText(getActivity(), "Household Number and Respondent names are Mandatory!", Toast.LENGTH_SHORT).show();
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

        if(rb_HH04a==null) str_haveChildren="";
        else str_haveChildren = rb_HH04a.getText().toString();

        String houseID = KIX_Utility.getUUID().toString();
        Modal_Household modal_household = new Modal_Household();
        modal_household.setHouseholdId(houseID);
        modal_household.setHH01(et_hhNumber.getText().toString());
        modal_household.setHH02(et_respondentName.getText().toString());
        modal_household.setHH03(et_houseHeadName.getText().toString());
        modal_household.setHH05(et_telephoneNum.getText().toString());
        modal_household.setHH04a(str_haveChildren);
        modal_household.setHH04b(et_noOfChilds.getText().toString());
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

        rb_HH04a = getView().findViewById(selectedHH05a);
    }

}
