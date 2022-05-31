package com.kix.assessment.ui.village_activity.village_information_form;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_VIF;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static com.kix.assessment.KIXApplication.villageInformationDao;

@EFragment(R.layout.fragment_add_information_village)
public class Fragment_AddVillageInformation extends Fragment implements CompoundButton.OnCheckedChangeListener {

    @ViewById(R.id.tv_title)
    TextView tv_title;

    @ViewById(R.id.rg_V01)
    RadioGroup rg_haveRoad;

    @ViewById(R.id.rg_V02)
    RadioGroup rg_haveTransport;

    @ViewById(R.id.rg_V03)
    RadioGroup rg_haveElectricity;

    @ViewById(R.id.rg_V04)
    RadioGroup rg_haveGovHosp;

    @ViewById(R.id.rg_V05)
    RadioGroup rg_havePvtHosp;

    @ViewById(R.id.rg_V06a)
    RadioGroup rg_havePrePrimSchool;

    @ViewById(R.id.rg_V07a)
    RadioGroup rg_havePrimSchool;

    @ViewById(R.id.ll_V06b)
    LinearLayout ll_V06b;

    @ViewById(R.id.ch1_V06b)
    CheckBox cb_v06bGovtPub;
    @ViewById(R.id.ch2_V06b)
    CheckBox cb_v06bPvt;
    @ViewById(R.id.ch3_V06b)
    CheckBox cb_v06bOther;

    @ViewById(R.id.ll_V07b)
    LinearLayout ll_V07b;
    @ViewById(R.id.ch1_V07b)
    CheckBox cb_v07bGovtPub;
    @ViewById(R.id.ch2_V07b)
    CheckBox cb_v07bPvt;
    @ViewById(R.id.ch3_V07b)
    CheckBox cb_v07bOther;

    @ViewById(R.id.btn_save)
    Button btn_saveVIF;

    @ViewById(R.id.btn_edit)
    Button btn_editVIF;

    String surveyorCode, villageId;

    RadioButton rb_V01, rb_V02, rb_V03, rb_V04, rb_V05, rb_V06a, rb_V07a;

    String str_v06b_schoolType = "", str_v07b_schoolType = "";

    public Fragment_AddVillageInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        surveyorCode = FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, "");
        villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);

        if (getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            tv_title.setText("Edit Village Information");

            Modal_VIF modal_vif = villageInformationDao.getVIFbyVillageId(villageId);

            if (modal_vif.getV01().equalsIgnoreCase(Kix_Constant.YES))
                rg_haveRoad.check(R.id.rb_V01_yes);
            else rg_haveRoad.check(R.id.rb_V01_No);

            if (modal_vif.getV02().equalsIgnoreCase(Kix_Constant.YES))
                rg_haveTransport.check(R.id.rb_V02_yes);
            else rg_haveTransport.check(R.id.rb_V02_No);

            if (modal_vif.getV03().equalsIgnoreCase(Kix_Constant.YES))
                rg_haveElectricity.check(R.id.rb_V03_yes);
            else rg_haveTransport.check(R.id.rb_V03_No);

            if (modal_vif.getV04().equalsIgnoreCase(Kix_Constant.YES))
                rg_haveGovHosp.check(R.id.rb_V04_yes);
            else rg_haveGovHosp.check(R.id.rb_V04_No);

            if (modal_vif.getV05().equalsIgnoreCase(Kix_Constant.YES))
                rg_havePvtHosp.check(R.id.rb_V05_yes);
            else rg_havePvtHosp.check(R.id.rb_V05_No);

            if (modal_vif.getV06a().equalsIgnoreCase(Kix_Constant.YES)) {
                rg_havePrePrimSchool.check(R.id.rb_V06a_yes);
                ll_V06b.setVisibility(View.VISIBLE);
                if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_government_public))) cb_v06bGovtPub.setChecked(true);
                else if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_private))) cb_v06bPvt.setChecked(true);
                else if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_other))) cb_v06bOther.setChecked(true);
            } else {
                rg_havePrePrimSchool.check(R.id.rb_V06a_No);
            }

            if (modal_vif.getV07a().equalsIgnoreCase(Kix_Constant.YES)) {
                rg_havePrimSchool.check(R.id.rb_V07a_yes);
                ll_V07b.setVisibility(View.VISIBLE);
                if(modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_government_public))) cb_v07bGovtPub.setChecked(true);
                else if(modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_private))) cb_v07bPvt.setChecked(true);
                else if(modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_other))) cb_v07bOther.setChecked(true);

            } else rg_havePrimSchool.check(R.id.rb_V07a_No);

            btn_saveVIF.setVisibility(View.GONE);
            btn_editVIF.setVisibility(View.VISIBLE);
        }

        rg_havePrePrimSchool.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_V06a_yes:
                    ll_V06b.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_V06a_No:
                    ll_V06b.setVisibility(View.GONE);
                    cb_v06bGovtPub.setChecked(false);
                    cb_v06bOther.setChecked(false);
                    cb_v06bPvt.setChecked(false);
                    break;
            }
        });

        rg_havePrimSchool.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_V07a_yes:
                    ll_V07b.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_V07a_No:
                    ll_V07b.setVisibility(View.GONE);
                    cb_v07bGovtPub.setChecked(false);
                    cb_v07bOther.setChecked(false);
                    cb_v07bPvt.setChecked(false);
                    break;
            }
        });

        cb_v06bGovtPub.setOnCheckedChangeListener(this);
        cb_v06bOther.setOnCheckedChangeListener(this);
        cb_v06bPvt.setOnCheckedChangeListener(this);
        cb_v07bGovtPub.setOnCheckedChangeListener(this);
        cb_v07bOther.setOnCheckedChangeListener(this);
        cb_v07bPvt.setOnCheckedChangeListener(this);
    }

    @Click(R.id.btn_save)
    public void saveVIF() {
        getRadioButtonValues();
        getCheckedBoxValues();
        if (rb_V01 == null || rb_V02 == null || rb_V03 == null || rb_V04 == null || rb_V05 == null || rb_V06a == null || rb_V07a == null) {
            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            if (rb_V06a.getText().toString().equalsIgnoreCase(Kix_Constant.YES) &&
                    rb_V07a.getText().toString().equalsIgnoreCase(Kix_Constant.YES)) {
                if (str_v06b_schoolType.equalsIgnoreCase("") || str_v07b_schoolType.equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Select School Type", Toast.LENGTH_SHORT).show();
                } else {
                    insertVIF();
                }
            } else {
                insertVIF();
            }
        }
    }

    @Click(R.id.btn_edit)
    public void editVIF() {
        getRadioButtonValues();
        getCheckedBoxValues();
        if (rb_V01 == null || rb_V02 == null || rb_V03 == null || rb_V04 == null || rb_V05 == null || rb_V06a == null || rb_V07a == null) {
            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            if (rb_V06a.getText().toString().equalsIgnoreCase(Kix_Constant.YES) &&
                    rb_V07a.getText().toString().equalsIgnoreCase(Kix_Constant.YES)) {
                if (str_v06b_schoolType.equalsIgnoreCase("") || str_v07b_schoolType.equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Select School Type", Toast.LENGTH_SHORT).show();
                } else {
                    updateVIF();
                }
            } else {
                updateVIF();
            }
        }
    }

    public void getRadioButtonValues() {
        int selectedV01 = rg_haveRoad.getCheckedRadioButtonId();
        int selectedV02 = rg_haveTransport.getCheckedRadioButtonId();
        int selectedV03 = rg_haveElectricity.getCheckedRadioButtonId();
        int selectedV04 = rg_haveGovHosp.getCheckedRadioButtonId();
        int selectedV05 = rg_havePvtHosp.getCheckedRadioButtonId();
        int selectedV06a = rg_havePrePrimSchool.getCheckedRadioButtonId();
        int selectedV07a = rg_havePrimSchool.getCheckedRadioButtonId();

        rb_V01 = getView().findViewById(selectedV01);
        rb_V02 = getView().findViewById(selectedV02);
        rb_V03 = getView().findViewById(selectedV03);
        rb_V04 = getView().findViewById(selectedV04);
        rb_V05 = getView().findViewById(selectedV05);
        rb_V06a = getView().findViewById(selectedV06a);
        rb_V07a = getView().findViewById(selectedV07a);
    }

    public void getCheckedBoxValues() {
        if (cb_v06bGovtPub.isChecked())
            str_v06b_schoolType = "Government/Public"; //else str_v06b_schoolType = "";
        if (cb_v06bOther.isChecked())
            str_v06b_schoolType = "Other"; //else str_v06b_schoolType = "";
        if (cb_v06bPvt.isChecked())
            str_v06b_schoolType = "Private"; //else str_v06b_schoolType = "";

        if (cb_v07bGovtPub.isChecked())
            str_v07b_schoolType = "Government/Public"; //else str_v07b_schoolType = "";
        if (cb_v07bOther.isChecked())
            str_v07b_schoolType = "Other"; //else str_v07b_schoolType = "";
        if (cb_v07bPvt.isChecked())
            str_v07b_schoolType = "Private"; //else str_v07b_schoolType = "";
    }

    public void insertVIF() {
        Modal_VIF modal_vif = new Modal_VIF();
        modal_vif.setV01(rb_V01.getText().toString());
        modal_vif.setV02(rb_V02.getText().toString());
        modal_vif.setV03(rb_V03.getText().toString());
        modal_vif.setV04(rb_V04.getText().toString());
        modal_vif.setV05(rb_V05.getText().toString());
        modal_vif.setV06a(rb_V06a.getText().toString());
        modal_vif.setV07a(rb_V07a.getText().toString());
        modal_vif.setV06b(str_v06b_schoolType);
        modal_vif.setV07b(str_v07b_schoolType);
        modal_vif.setVillageId(villageId);
        modal_vif.setSvrCode(surveyorCode);
        modal_vif.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_vif.setSentFlag(0);

        villageInformationDao.insertVillageInfo(modal_vif);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "VillageInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    public void updateVIF(){
        villageInformationDao.updateVillage(
                rb_V01.getText().toString(),
                rb_V02.getText().toString(),
                rb_V03.getText().toString(),
                rb_V04.getText().toString(),
                rb_V05.getText().toString(),
                rb_V06a.getText().toString(),
                str_v06b_schoolType,
                rb_V07a.getText().toString(),
                str_v07b_schoolType,
                villageId);

        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "VillageInformation Edited Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }
    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
