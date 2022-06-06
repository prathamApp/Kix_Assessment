package com.kix.assessment.ui.village_activity.village_information_form;

import static com.kix.assessment.KIXApplication.villageInformationDao;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    int selectedV01, selectedV02, selectedV03, selectedV04, selectedV05, selectedV06a, selectedV07a;

    public Fragment_AddVillageInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        this.surveyorCode = FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, "");
        this.villageId = this.getArguments().getString(Kix_Constant.VILLAGE_ID);
        selectedV01 = selectedV02 = selectedV03 = selectedV04 = selectedV05 = selectedV06a = selectedV07a = 99;
        if (this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            this.tv_title.setText(getString(R.string.update_village_info));

            final Modal_VIF modal_vif = villageInformationDao.getVIFbyVillageId(this.villageId);

            if (modal_vif.getV01().equalsIgnoreCase("1"))
                this.rg_haveRoad.check(R.id.rb_V01_yes);
            else
                this.rg_haveRoad.check(R.id.rb_V01_No);

            if (modal_vif.getV02().equalsIgnoreCase("1"))
                this.rg_haveTransport.check(R.id.rb_V02_yes);
            else
                this.rg_haveTransport.check(R.id.rb_V02_No);

            if (modal_vif.getV03().equalsIgnoreCase("1"))
                this.rg_haveElectricity.check(R.id.rb_V03_yes);
            else
                this.rg_haveElectricity.check(R.id.rb_V03_No);

            if (modal_vif.getV04().equalsIgnoreCase("1"))
                this.rg_haveGovHosp.check(R.id.rb_V04_yes);
            else
                this.rg_haveGovHosp.check(R.id.rb_V04_No);

            if (modal_vif.getV05().equalsIgnoreCase("1"))
                this.rg_havePvtHosp.check(R.id.rb_V05_yes);
            else
                this.rg_havePvtHosp.check(R.id.rb_V05_No);

            if (modal_vif.getV06a().equalsIgnoreCase("1")) {
                this.rg_havePrePrimSchool.check(R.id.rb_V06a_yes);
                this.ll_V06b.setVisibility(View.VISIBLE);
/*                String[] arrOfV06b = modal_vif.V06b.split(",");
                for (int i=0;i<arrOfV06b.length;i++)
                    Log.d("TAG", "initialize: "+arrOfV06b[i]);*/
                if (modal_vif.V06b.contains("1,"))
                    this.cb_v06bGovtPub.setChecked(true);
                if (modal_vif.V06b.contains("2,"))
                    this.cb_v06bPvt.setChecked(true);
                if (modal_vif.V06b.contains("3,"))
                    this.cb_v06bOther.setChecked(true);

/*                if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_government_public)))
                    cb_v06bGovtPub.setChecked(true);
                else if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_private)))
                    cb_v06bPvt.setChecked(true);
                else if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_other)))
                    cb_v06bOther.setChecked(true);*/
            } else {
                this.rg_havePrePrimSchool.check(R.id.rb_V06a_No);
            }

            if (modal_vif.getV07a().equalsIgnoreCase("1")) {
                this.rg_havePrimSchool.check(R.id.rb_V07a_yes);
                this.ll_V07b.setVisibility(View.VISIBLE);
                if (modal_vif.V07b.contains("1,"))
                    this.cb_v07bGovtPub.setChecked(true);
                if (modal_vif.V07b.contains("2,"))
                    this.cb_v07bPvt.setChecked(true);
                if (modal_vif.V07b.contains("3,"))
                    this.cb_v07bOther.setChecked(true);

/*                if (modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_government_public)))
                    cb_v07bGovtPub.setChecked(true);
                else if (modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_private)))
                    cb_v07bPvt.setChecked(true);
                else if (modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_other)))
                    cb_v07bOther.setChecked(true);*/

            } else this.rg_havePrimSchool.check(R.id.rb_V07a_No);

            this.btn_saveVIF.setVisibility(View.GONE);
            this.btn_editVIF.setVisibility(View.VISIBLE);
        }

        this.rg_havePrePrimSchool.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_V06a_yes:
                    this.ll_V06b.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_V06a_No:
                    this.ll_V06b.setVisibility(View.GONE);
                    this.cb_v06bGovtPub.setChecked(false);
                    this.cb_v06bOther.setChecked(false);
                    this.cb_v06bPvt.setChecked(false);
                    break;
            }
        });

        this.rg_havePrimSchool.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_V07a_yes:
                    this.ll_V07b.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_V07a_No:
                    this.ll_V07b.setVisibility(View.GONE);
                    this.cb_v07bGovtPub.setChecked(false);
                    this.cb_v07bOther.setChecked(false);
                    this.cb_v07bPvt.setChecked(false);
                    break;
            }
        });

        this.cb_v06bGovtPub.setOnCheckedChangeListener(this);
        this.cb_v06bOther.setOnCheckedChangeListener(this);
        this.cb_v06bPvt.setOnCheckedChangeListener(this);
        this.cb_v07bGovtPub.setOnCheckedChangeListener(this);
        this.cb_v07bOther.setOnCheckedChangeListener(this);
        this.cb_v07bPvt.setOnCheckedChangeListener(this);
    }

    @Click(R.id.btn_save)
    public void saveVIF() {
        this.getRadioButtonValues();
        this.getCheckedBoxValues();
        if (this.selectedV01 == 99 || this.selectedV02 == 99 || this.selectedV03 == 99
                || this.selectedV04 == 99 || this.selectedV05 == 99 || this.selectedV06a == 99
                || this.selectedV07a == 99) {
            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            if (selectedV06a == 1 && selectedV07a == 1) {
                if (this.str_v06b_schoolType.equalsIgnoreCase("")
                        || this.str_v07b_schoolType.equalsIgnoreCase("")) {
                    Toast.makeText(this.getActivity(), "Select School Type", Toast.LENGTH_SHORT).show();
                } else {
                    this.insertVIF();
                }
            } else {
                this.insertVIF();
            }
        }
    }

    @Click(R.id.btn_edit)
    public void editVIF() {
        this.getRadioButtonValues();
        this.getCheckedBoxValues();
        if (this.selectedV01 == 99 || this.selectedV02 == 99 || this.selectedV03 == 99
               || this.selectedV04 == 99 || this.selectedV05 == 99 || this.selectedV06a == 99
               || this.selectedV07a == 99) {
            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            if (selectedV06a == 1 && selectedV07a == 1) {
                if (this.str_v06b_schoolType.equalsIgnoreCase("")
                        || this.str_v07b_schoolType.equalsIgnoreCase("")) {
                    Toast.makeText(this.getActivity(), "Select School Type", Toast.LENGTH_SHORT).show();
                } else {
                    this.updateVIF();
                }
            } else {
                this.updateVIF();
            }
        }
    }

    public void getRadioButtonValues() {
/*        int selectedV01 = this.rg_haveRoad.getCheckedRadioButtonId();
        int selectedV02 = this.rg_haveTransport.getCheckedRadioButtonId();
        int selectedV03 = this.rg_haveElectricity.getCheckedRadioButtonId();
        int selectedV04 = this.rg_haveGovHosp.getCheckedRadioButtonId();
        int selectedV05 = this.rg_havePvtHosp.getCheckedRadioButtonId();
        int selectedV06a = this.rg_havePrePrimSchool.getCheckedRadioButtonId();
        int selectedV07a = this.rg_havePrimSchool.getCheckedRadioButtonId();

        this.rb_V01 = this.getView().findViewById(selectedV01);
        this.rb_V02 = this.getView().findViewById(selectedV02);
        this.rb_V03 = this.getView().findViewById(selectedV03);
        this.rb_V04 = this.getView().findViewById(selectedV04);
        this.rb_V05 = this.getView().findViewById(selectedV05);
        this.rb_V06a = this.getView().findViewById(selectedV06a);
        this.rb_V07a = this.getView().findViewById(selectedV07a);*/

        if (this.getView().findViewById(this.rg_haveRoad.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V01_yes))
            selectedV01 = 1;
        else if (this.getView().findViewById(this.rg_haveRoad.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V01_No))
            selectedV01 = 0;
        if (this.getView().findViewById(this.rg_haveTransport.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V02_yes))
            selectedV02 = 1;
        else if (this.getView().findViewById(this.rg_haveTransport.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V02_No))
            selectedV02 = 0;
        if (this.getView().findViewById(this.rg_haveElectricity.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V03_yes))
            selectedV03 = 1;
        else if (this.getView().findViewById(this.rg_haveElectricity.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V03_No))
            selectedV03 = 0;
        if (this.getView().findViewById(this.rg_haveGovHosp.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V04_yes))
            selectedV04 = 1;
        else if (this.getView().findViewById(this.rg_haveGovHosp.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V04_No))
            selectedV04 = 0;
        if (this.getView().findViewById(this.rg_havePvtHosp.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V05_yes))
            selectedV05 = 1;
        else if (this.getView().findViewById(this.rg_havePvtHosp.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V05_No))
            selectedV05 = 0;
        if (this.getView().findViewById(this.rg_havePrePrimSchool.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V06a_yes))
            selectedV06a = 1;
        else if (this.getView().findViewById(this.rg_havePrePrimSchool.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V06a_No))
            selectedV06a = 0;
        if (this.getView().findViewById(this.rg_havePrimSchool.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V07a_yes))
            selectedV07a = 1;
        else if (this.getView().findViewById(this.rg_havePrimSchool.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_V07a_No))
            selectedV07a = 0;

    }

    public void getCheckedBoxValues() {
        this.str_v06b_schoolType = "";
        if (this.cb_v06bGovtPub.isChecked())
            this.str_v06b_schoolType = this.str_v06b_schoolType + "1,";
        if (this.cb_v06bPvt.isChecked())
            this.str_v06b_schoolType = this.str_v06b_schoolType + "2,";
        if (this.cb_v06bOther.isChecked())
            this.str_v06b_schoolType = this.str_v06b_schoolType + "3,";

        this.str_v07b_schoolType = "";
        if (this.cb_v07bGovtPub.isChecked())
            this.str_v07b_schoolType = this.str_v07b_schoolType + "1,";
        if (this.cb_v07bPvt.isChecked())
            this.str_v07b_schoolType = this.str_v07b_schoolType + "2,";
        if (this.cb_v07bOther.isChecked())
            this.str_v07b_schoolType = this.str_v07b_schoolType + "3,";


/*        if (cb_v06bGovtPub.isChecked())
            str_v06b_schoolType = "Government/Public"; //else str_v06b_schoolType = "";
        if (cb_v06bOther.isChecked())
            str_v06b_schoolType = "Other"; //else str_v06b_schoolType = "";
        if (cb_v06bPvt.isChecked())
            str_v06b_schoolType = "Private"; //else str_v06b_schoolType = "";*/

/*        if (cb_v07bGovtPub.isChecked())
            str_v07b_schoolType = "Government/Public"; //else str_v07b_schoolType = "";
        if (cb_v07bOther.isChecked())
            str_v07b_schoolType = "Other"; //else str_v07b_schoolType = "";
        if (cb_v07bPvt.isChecked())
            str_v07b_schoolType = "Private"; //else str_v07b_schoolType = "";*/
    }

    public void insertVIF() {
        final Modal_VIF modal_vif = new Modal_VIF();
        modal_vif.setV01(""+ selectedV01);
        modal_vif.setV02(""+ selectedV02);
        modal_vif.setV03(""+ selectedV03);
        modal_vif.setV04(""+ selectedV04);
        modal_vif.setV05(""+ selectedV05);
        modal_vif.setV06a(""+ selectedV06a);
        modal_vif.setV07a(""+ selectedV07a);
        modal_vif.setV06b(this.str_v06b_schoolType);
        modal_vif.setV07b(this.str_v07b_schoolType);
        modal_vif.setVillageId(this.villageId);
        modal_vif.setSvrCode(this.surveyorCode);
        modal_vif.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_vif.setSentFlag(0);

        villageInformationDao.insertVillageInfo(modal_vif);
        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "VillageInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        this.getFragmentManager().popBackStack();
    }

    public void updateVIF() {
        villageInformationDao.updateVillage(
                ""+ selectedV01,
                ""+ selectedV02,
                ""+ selectedV03,
                ""+ selectedV04,
                ""+ selectedV05,
                ""+ selectedV06a,
                this.str_v06b_schoolType,
                ""+ selectedV07a,
                this.str_v07b_schoolType,
                this.villageId);

        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "VillageInformation Edited Successfully!", Toast.LENGTH_SHORT).show();
        this.getFragmentManager().popBackStack();
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {

    }
}
