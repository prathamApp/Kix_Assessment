package com.kix.assessment.ui.household_activity;

import static com.kix.assessment.KIXApplication.householdDao;

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

//    @ViewById(R.id.rg_isSampledHH)
//    RadioGroup rg_isSampledHH;

    @ViewById(R.id.btn_saveHousehold)
    Button btn_saveAndEdit;

    @ViewById(R.id.ll_isSampledHH)
    LinearLayout ll_isSampledHH;

    RadioButton rb_HH04a;
    int str_rb_HH04a = 99, str_rb_isSampledHH, str_HHOO = 99;
    String surveyorCode, villageId, selectedLanguageCode, householdId;
    Modal_Household modal_household;

    public Fragment_AddHousehold() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        this.surveyorCode = FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, "NA");
        this.villageId = this.getArguments().getString(Kix_Constant.VILLAGE_ID);
        this.householdId = this.getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        this.modal_household = householdDao.getHouseholdBySurveyorCode(this.householdId, this.villageId);
        this.sv_householdDetail.setVisibility(View.GONE);

        Log.e("hhh : ", this.householdId + " | " + this.villageId);

        if (this.getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
            if (this.modal_household.getHH00().equalsIgnoreCase("1")) {
                this.rg_isSampledHH.check(R.id.rb_isSampledHH_one);
                this.sv_householdDetail.setVisibility(View.GONE);
            } else if (this.modal_household.getHH00().equalsIgnoreCase("2")) {
                this.rg_isSampledHH.check(R.id.rb_isSampledHH_two);
                this.sv_householdDetail.setVisibility(View.GONE);
            } else if (this.modal_household.getHH00().equalsIgnoreCase("3")) {
                this.rg_isSampledHH.check(R.id.rb_isSampledHH_three);
                this.sv_householdDetail.setVisibility(View.VISIBLE);
            }

            this.ll_isSampledHH.setVisibility(View.VISIBLE);
//            sv_householdDetail.setVisibility(View.VISIBLE);
            this.tv_title.setText("Update Household");
            this.et_hhNumber.setText(this.modal_household.getHH01());
            this.et_respondentName.setText(this.modal_household.getHH02());
            this.et_houseHeadName.setText(this.modal_household.getHH03());
            this.et_telephoneNum.setText(this.modal_household.getHH05());
            this.et_noOfChilds.setText(this.modal_household.getHH04b());

            if (this.modal_household.getHH04a().equalsIgnoreCase("1")) {
                this.rg_haveChildren.check(R.id.rb_HH04a_yes);
                this.til_noOfChilds.setVisibility(View.VISIBLE);
            } else if (this.modal_household.getHH04a().equalsIgnoreCase("0")) {
                this.rg_haveChildren.check(R.id.rb_HH04a_No);
            }

/*            if (modal_household.getHH04a().equalsIgnoreCase(Kix_Constant.YES)) {
                rg_haveChildren.check(R.id.rb_HH04a_yes);
                til_noOfChilds.setVisibility(View.VISIBLE);
            } else rg_haveChildren.check(R.id.rb_HH04a_No);*/
        }

        this.rg_haveChildren.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_HH04a_yes:
                    this.til_noOfChilds.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_HH04a_No:
                    this.til_noOfChilds.setVisibility(View.GONE);
                    this.et_noOfChilds.setText("");
                    break;
            }
        });

        this.rg_isSampledHH.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_isSampledHH_one:
                case R.id.rb_isSampledHH_two:
                    this.sv_householdDetail.setVisibility(View.GONE);

                    this.et_hhNumber.setText("");
                    this.et_respondentName.setText("");
                    this.et_houseHeadName.setText("");
                    this.et_telephoneNum.setText("");
                    this.et_noOfChilds.setText("");
                    this.rg_haveChildren.clearCheck();
                    this.til_noOfChilds.setVisibility(View.GONE);
                    break;
                case R.id.rb_isSampledHH_three:
                    this.sv_householdDetail.setVisibility(View.VISIBLE);
            }
        });
    }

    @Click(R.id.btn_saveHousehold)
    public void saveHousehold() {
        this.getRadioButtonValues();
        if (this.str_HHOO != 99) {
            if (this.str_HHOO != 3 ||
                    (!this.et_hhNumber.getText().toString().isEmpty() && !this.et_respondentName.getText().toString().isEmpty())) {
                if (this.str_HHOO != 3 || this.str_rb_HH04a != 99) {
                    if (this.getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
                        final String hh_name;
                        if (this.str_HHOO == 1)
                            hh_name = this.getString(R.string.str_isSampledHH_one);
                        else if (this.str_HHOO == 2)
                            hh_name = this.getString(R.string.str_isSampledHH_two);
                        else
                            hh_name = this.et_respondentName.getText().toString();

                        householdDao.updateHousehold(
                                "" + this.str_HHOO,
                                this.et_hhNumber.getText().toString(),
                                ""+hh_name,
                                this.et_houseHeadName.getText().toString(),
                                this.et_telephoneNum.getText().toString(),
                                "" + this.str_rb_HH04a,
                                this.et_noOfChilds.getText().toString(),
                                this.householdId,
                                this.villageId);
                        Toast.makeText(getActivity(), getString(R.string.hh_Updated_success), Toast.LENGTH_SHORT).show();
                        getFragmentManager().popBackStack();
                    } else {
                        this.insertHousehold();
                    }
                } else {
                    Toast.makeText(this.getActivity(), getString(R.string.select_radio_button), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this.getActivity(), getString(R.string.hhName_mandatory), Toast.LENGTH_SHORT).show();
            }
        } else
            Toast.makeText(this.getActivity(), getString(R.string.select_atleast_one), Toast.LENGTH_SHORT).show();
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
        this.getRadioButtonValues();
        String str_haveChildren = "99";
        String str_speakLanguage;

        if (getView().findViewById(rg_haveChildren.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH04a_yes))
            str_haveChildren = "1";
        else if (getView().findViewById(rg_haveChildren.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH04a_No))
            str_haveChildren = "0";

/*        if(rb_HH04a==null)
            str_haveChildren="";
        else
            str_haveChildren = rb_HH04a.getText().toString();*/
        final String hh_name;
        if (this.str_HHOO == 1)
            hh_name = this.getString(R.string.str_isSampledHH_one);
        else if (this.str_HHOO == 2)
            hh_name = this.getString(R.string.str_isSampledHH_two);
        else
            hh_name = this.et_respondentName.getText().toString();

        final String houseID = KIX_Utility.getUUID().toString();
        final Modal_Household modal_household = new Modal_Household();
        modal_household.setHouseholdId(houseID);
        modal_household.setHH00("" + this.str_HHOO);
        modal_household.setHH01(this.et_hhNumber.getText().toString());
        modal_household.setHH02(hh_name);
        modal_household.setHH03(this.et_houseHeadName.getText().toString());
        modal_household.setHH05(this.et_telephoneNum.getText().toString());
        modal_household.setHH04a(str_haveChildren);
        modal_household.setHH04b(this.et_noOfChilds.getText().toString());
        modal_household.setCreatedOn("" + KIX_Utility.getCurrentDateTime());
        modal_household.setsvrCode(this.surveyorCode);
        modal_household.setVillageId(this.villageId);
        modal_household.setSentFlag(0);
        householdDao.insertHousehold(modal_household);
        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), getString(R.string.hh_Added_success), Toast.LENGTH_SHORT).show();
        this.getFragmentManager().popBackStack();
/*        Intent intent = new Intent(getActivity(), Activity_Household_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.VILLAGE_ID, villageId);
        startActivity(intent);*/
    }

    public void getRadioButtonValues() {
//        rb_HH04a = getView().findViewById(rg_haveChildren.getCheckedRadioButtonId());
        this.str_rb_HH04a = 99;
        if (getView().findViewById(this.rg_haveChildren.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH04a_yes))
            this.str_rb_HH04a = 1;
        else if (getView().findViewById(this.rg_haveChildren.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH04a_No))
            this.str_rb_HH04a = 0;

        this.str_HHOO = 99;
        if (getView().findViewById(this.rg_isSampledHH.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_isSampledHH_one))
            this.str_HHOO = 1;
        else if (getView().findViewById(this.rg_isSampledHH.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_isSampledHH_two))
            this.str_HHOO = 2;
        else if (getView().findViewById(this.rg_isSampledHH.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_isSampledHH_three))
            this.str_HHOO = 3;

    }

}
