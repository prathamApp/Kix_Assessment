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
        surveyorCode = FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, "");
        villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);
        this.selectedV01 = this.selectedV02 = this.selectedV03 = this.selectedV04 = this.selectedV05 = this.selectedV06a = this.selectedV07a = 99;
        if (getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            tv_title.setText(this.getString(R.string.update_village_info));

            Modal_VIF modal_vif = villageInformationDao.getVIFbyVillageId(villageId);

            if (modal_vif.getV01().equalsIgnoreCase("1"))
                rg_haveRoad.check(R.id.rb_V01_yes);
            else
                rg_haveRoad.check(R.id.rb_V01_No);

            if (modal_vif.getV02().equalsIgnoreCase("1"))
                rg_haveTransport.check(R.id.rb_V02_yes);
            else
                rg_haveTransport.check(R.id.rb_V02_No);

            if (modal_vif.getV03().equalsIgnoreCase("1"))
                rg_haveElectricity.check(R.id.rb_V03_yes);
            else
                rg_haveElectricity.check(R.id.rb_V03_No);

            if (modal_vif.getV04().equalsIgnoreCase("1"))
                rg_haveGovHosp.check(R.id.rb_V04_yes);
            else
                rg_haveGovHosp.check(R.id.rb_V04_No);

            if (modal_vif.getV05().equalsIgnoreCase("1"))
                rg_havePvtHosp.check(R.id.rb_V05_yes);
            else
                rg_havePvtHosp.check(R.id.rb_V05_No);

            if (modal_vif.getV06a().equalsIgnoreCase("1")) {
                rg_havePrePrimSchool.check(R.id.rb_V06a_yes);
                ll_V06b.setVisibility(View.VISIBLE);
/*                String[] arrOfV06b = modal_vif.V06b.split(",");
                for (int i=0;i<arrOfV06b.length;i++)
                    Log.d("TAG", "initialize: "+arrOfV06b[i]);*/
                if (modal_vif.V06b.contains("1,"))
                    cb_v06bGovtPub.setChecked(true);
                if (modal_vif.V06b.contains("2,"))
                    cb_v06bPvt.setChecked(true);
                if (modal_vif.V06b.contains("3,"))
                    cb_v06bOther.setChecked(true);

/*                if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_government_public)))
                    cb_v06bGovtPub.setChecked(true);
                else if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_private)))
                    cb_v06bPvt.setChecked(true);
                else if(modal_vif.V06b.equalsIgnoreCase(getString(R.string.str_other)))
                    cb_v06bOther.setChecked(true);*/
            } else {
                rg_havePrePrimSchool.check(R.id.rb_V06a_No);
            }

            if (modal_vif.getV07a().equalsIgnoreCase("1")) {
                rg_havePrimSchool.check(R.id.rb_V07a_yes);
                ll_V07b.setVisibility(View.VISIBLE);
                if (modal_vif.V07b.contains("1,"))
                    cb_v07bGovtPub.setChecked(true);
                if (modal_vif.V07b.contains("2,"))
                    cb_v07bPvt.setChecked(true);
                if (modal_vif.V07b.contains("3,"))
                    cb_v07bOther.setChecked(true);

/*                if (modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_government_public)))
                    cb_v07bGovtPub.setChecked(true);
                else if (modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_private)))
                    cb_v07bPvt.setChecked(true);
                else if (modal_vif.V07b.equalsIgnoreCase(getString(R.string.str_other)))
                    cb_v07bOther.setChecked(true);*/

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
        if (selectedV01 == 99 || selectedV02 == 99 || selectedV03 == 99
                || selectedV04 == 99 || selectedV05 == 99 || selectedV06a == 99
                || selectedV07a == 99) {
            Toast.makeText(getActivity(), getString(R.string.all_fields_mandatory), Toast.LENGTH_SHORT).show();
        } else {
            if (this.selectedV06a == 1 && this.selectedV07a == 1) {
                if (str_v06b_schoolType.equalsIgnoreCase("")
                        || str_v07b_schoolType.equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), R.string.select_school_type, Toast.LENGTH_SHORT).show();
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
        if (selectedV01 == 99 || selectedV02 == 99 || selectedV03 == 99
               || selectedV04 == 99 || selectedV05 == 99 || selectedV06a == 99
               || selectedV07a == 99) {
            Toast.makeText(getActivity(), getString(R.string.all_fields_mandatory), Toast.LENGTH_SHORT).show();
        } else {
            if (this.selectedV06a == 1 && this.selectedV07a == 1) {
                if (str_v06b_schoolType.equalsIgnoreCase("")
                        || str_v07b_schoolType.equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), getString(R.string.select_school_type), Toast.LENGTH_SHORT).show();
                } else {
                    updateVIF();
                }
            } else {
                updateVIF();
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

        if (getView().findViewById(rg_haveRoad.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V01_yes))
            this.selectedV01 = 1;
        else if (getView().findViewById(rg_haveRoad.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V01_No))
            this.selectedV01 = 0;
        if (getView().findViewById(rg_haveTransport.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V02_yes))
            this.selectedV02 = 1;
        else if (getView().findViewById(rg_haveTransport.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V02_No))
            this.selectedV02 = 0;
        if (getView().findViewById(rg_haveElectricity.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V03_yes))
            this.selectedV03 = 1;
        else if (getView().findViewById(rg_haveElectricity.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V03_No))
            this.selectedV03 = 0;
        if (getView().findViewById(rg_haveGovHosp.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V04_yes))
            this.selectedV04 = 1;
        else if (getView().findViewById(rg_haveGovHosp.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V04_No))
            this.selectedV04 = 0;
        if (getView().findViewById(rg_havePvtHosp.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V05_yes))
            this.selectedV05 = 1;
        else if (getView().findViewById(rg_havePvtHosp.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V05_No))
            this.selectedV05 = 0;
        if (getView().findViewById(rg_havePrePrimSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V06a_yes))
            this.selectedV06a = 1;
        else if (getView().findViewById(rg_havePrePrimSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V06a_No))
            this.selectedV06a = 0;
        if (getView().findViewById(rg_havePrimSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V07a_yes))
            this.selectedV07a = 1;
        else if (getView().findViewById(rg_havePrimSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_V07a_No))
            this.selectedV07a = 0;

    }

    public void getCheckedBoxValues() {
        str_v06b_schoolType = "";
        if (cb_v06bGovtPub.isChecked())
            str_v06b_schoolType = str_v06b_schoolType + "1,";
        if (cb_v06bPvt.isChecked())
            str_v06b_schoolType = str_v06b_schoolType + "2,";
        if (cb_v06bOther.isChecked())
            str_v06b_schoolType = str_v06b_schoolType + "3,";

        str_v07b_schoolType = "";
        if (cb_v07bGovtPub.isChecked())
            str_v07b_schoolType = str_v07b_schoolType + "1,";
        if (cb_v07bPvt.isChecked())
            str_v07b_schoolType = str_v07b_schoolType + "2,";
        if (cb_v07bOther.isChecked())
            str_v07b_schoolType = str_v07b_schoolType + "3,";


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
        Modal_VIF modal_vif = new Modal_VIF();
        modal_vif.setV01(""+ this.selectedV01);
        modal_vif.setV02(""+ this.selectedV02);
        modal_vif.setV03(""+ this.selectedV03);
        modal_vif.setV04(""+ this.selectedV04);
        modal_vif.setV05(""+ this.selectedV05);
        modal_vif.setV06a(""+ this.selectedV06a);
        modal_vif.setV07a(""+ this.selectedV07a);
        modal_vif.setV06b(str_v06b_schoolType);
        modal_vif.setV07b(str_v07b_schoolType);
        modal_vif.setVillageId(villageId);
        modal_vif.setSvrCode(surveyorCode);
        modal_vif.setInfo_createdOn(KIX_Utility.getCurrentDateTime());
        modal_vif.setSentFlag(0);

        villageInformationDao.insertVillageInfo(modal_vif);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), getString(R.string.villinfo_added_success), Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    public void updateVIF() {
        villageInformationDao.updateVillage(
                ""+ this.selectedV01,
                ""+ this.selectedV02,
                ""+ this.selectedV03,
                ""+ this.selectedV04,
                ""+ this.selectedV05,
                ""+ this.selectedV06a,
                str_v06b_schoolType,
                ""+ this.selectedV07a,
                str_v07b_schoolType,
                villageId);

        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), getString(R.string.villinfo_Updated_success), Toast.LENGTH_SHORT).show();
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
