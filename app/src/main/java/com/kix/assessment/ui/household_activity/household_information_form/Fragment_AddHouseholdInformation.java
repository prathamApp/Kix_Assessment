package com.kix.assessment.ui.household_activity.household_information_form;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_HIF;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static com.kix.assessment.KIXApplication.householdInformationDao;

@EFragment(R.layout.fragment_add_information_household)
public class Fragment_AddHouseholdInformation extends Fragment {

    @ViewById(R.id.tv_title)
    TextView tv_title;
    @ViewById(R.id.rg_HH07a)
    RadioGroup rg_hhRoofing;
    @ViewById(R.id.rg_HH07b)
    RadioGroup rg_hhWall;
    @ViewById(R.id.rg_HH07c)
    RadioGroup rg_lightSource;
    @ViewById(R.id.rg_HH07d)
    RadioGroup rg_waterSource;
    @ViewById(R.id.rg_HH07e)
    RadioGroup rg_electricity;
    @ViewById(R.id.rg_HH07f)
    RadioGroup rg_toilet;
    @ViewById(R.id.rg_HH07g)
    RadioGroup rg_memberCompletedDiploma;
    @ViewById(R.id.rg_HH07h)
    RadioGroup rg_readingMaterial;
    @ViewById(R.id.rg_HH07i)
    RadioGroup rg_computer;
    @ViewById(R.id.rg_HH07j)
    RadioGroup rg_television;
    @ViewById(R.id.rg_HH07k)
    RadioGroup rg_radio;
    @ViewById(R.id.rg_HH07l)
    RadioGroup rg_mobile;
    @ViewById(R.id.rg_HH07m)
    RadioGroup rg_isItSmartphone;
    @ViewById(R.id.rg_HH07n)
    RadioGroup rg_fourWheeler;
    @ViewById(R.id.rg_HH07o)
    RadioGroup rg_twoWheeler;
    @ViewById(R.id.rg_HH07p)
    RadioGroup rg_bicycle;

    @ViewById(R.id.rl_HH07m)
    RelativeLayout rl_isItSmartphone;

    @ViewById(R.id.til_HH07c)
    TextInputLayout til_HH07c;
    @ViewById(R.id.til_HH07d)
    TextInputLayout til_HH07d;

    @ViewById(R.id.et_HH07c_other)
    EditText et_HH07c_other;
    @ViewById(R.id.et_HH07d_other)
    EditText et_HH07d_other;

    @ViewById(R.id.btn_save)
    Button btn_save;

    String surveyorCode, villageId, householdId, hh07c_other="NA", hh07d_other="NA", str_isSmartphone;

    RadioButton rb_HH07a, rb_HH07b, rb_HH07c, rb_HH07d, rb_HH07e, rb_HH07f, rb_HH07g, rb_HH07h,
            rb_HH07i, rb_HH07j, rb_HH07k, rb_HH07l, rb_HH07m, rb_HH07n, rb_HH07o, rb_HH07p;

    public Fragment_AddHouseholdInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {

        householdId = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);
        btn_save.setText("Save");

        if(getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD)!=null){
            btn_save.setText("Edit");
            tv_title.setText("Edit Household Information");
            Modal_HIF modalHif = householdInformationDao.getHIFbyHouseholdId(householdId);
            setRadioButtonValues(modalHif);
        }

        rg_lightSource.setOnCheckedChangeListener((group, checkedId) -> {
                    if (checkedId == R.id.rb_HH07c_four) til_HH07c.setVisibility(View.VISIBLE);
                    else {
                        til_HH07c.setVisibility(View.GONE);
                        et_HH07c_other.setText("");
                    }
                }
        );

        rg_waterSource.setOnCheckedChangeListener((group, checkedId) -> {
                    if (checkedId == R.id.rb_HH07d_seven) til_HH07d.setVisibility(View.VISIBLE);
                    else {
                        til_HH07d.setVisibility(View.GONE);
                        et_HH07d_other.setText("");
                    }
                }
        );

        rg_mobile.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.rb_HH07l_yes) {
                rl_isItSmartphone.setVisibility(View.VISIBLE);
            } else {
                rl_isItSmartphone.setVisibility(View.GONE);
                rg_isItSmartphone.clearCheck();
            }
        });
    }

    @Click(R.id.btn_save)
    public void saveHIF(){
        getRadioButtonValues();

        if(rb_HH07a==null || rb_HH07b==null || rb_HH07c==null || rb_HH07d==null || rb_HH07e==null ||
        rb_HH07f==null || rb_HH07g==null || rb_HH07h==null || rb_HH07i==null || rb_HH07j==null ||
        rb_HH07l==null || rb_HH07l==null || rb_HH07n==null || rb_HH07o==null || rb_HH07p==null) {
            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            if (getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
                if (!et_HH07c_other.getText().toString().isEmpty())
                    hh07c_other = et_HH07c_other.getText().toString();
                if (!et_HH07d_other.getText().toString().isEmpty())
                    hh07d_other = et_HH07d_other.getText().toString();

                if(rb_HH07l.getText().toString().equalsIgnoreCase(getString(R.string.yes))){
                    if(rb_HH07m != null) {
                        updateHIF(rb_HH07m.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (rb_HH07m==null) str_isSmartphone="NA";
                    else str_isSmartphone = rb_HH07m.getText().toString();
                    updateHIF(str_isSmartphone);
                }
            } else {
                if(rb_HH07l.getText().toString().equalsIgnoreCase(getString(R.string.yes))){
                    if(rb_HH07m != null) {
                        insertHIF(rb_HH07m.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (rb_HH07m==null) str_isSmartphone="NA";
                    else str_isSmartphone = rb_HH07m.getText().toString();
                    insertHIF(str_isSmartphone);
                }
            }
        }
    }

    private void insertHIF(String isSmartphone) {

        if(!et_HH07c_other.getText().toString().isEmpty()) hh07c_other = et_HH07c_other.getText().toString();
        if(!et_HH07d_other.getText().toString().isEmpty()) hh07d_other = et_HH07d_other.getText().toString();

        Modal_HIF modal_hif = new Modal_HIF();
        modal_hif.setHH07a(rb_HH07a.getText().toString());
        modal_hif.setHH07b(rb_HH07b.getText().toString());
        modal_hif.setHH07c(rb_HH07c.getText().toString());
        modal_hif.setHH07cOther(hh07c_other);
        modal_hif.setHH07d(rb_HH07d.getText().toString());
        modal_hif.setHH07dOther(hh07d_other);
        modal_hif.setHH07e(rb_HH07e.getText().toString());
        modal_hif.setHH07f(rb_HH07f.getText().toString());
        modal_hif.setHH07g(rb_HH07g.getText().toString());
        modal_hif.setHH07h(rb_HH07h.getText().toString());
        modal_hif.setHH07i(rb_HH07i.getText().toString());
        modal_hif.setHH07j(rb_HH07j.getText().toString());
        modal_hif.setHH07k(rb_HH07k.getText().toString());
        modal_hif.setHH07l(rb_HH07l.getText().toString());
        modal_hif.setHH07m(isSmartphone);
        modal_hif.setHH07n(rb_HH07n.getText().toString());
        modal_hif.setHH07o(rb_HH07o.getText().toString());
        modal_hif.setHH07p(rb_HH07p.getText().toString());
        modal_hif.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_hif.setHouseholdId(householdId);
        modal_hif.setVillageId(villageId);
        modal_hif.setSentFlag(0);

        householdInformationDao.insertHouseholdInfo(modal_hif);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "HouseholdInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();

    }

    private void updateHIF(String isSmartphone) {
        householdInformationDao.updateHousehold(
                rb_HH07a.getText().toString(),
                rb_HH07b.getText().toString(),
                rb_HH07c.getText().toString(),
                et_HH07c_other.getText().toString(),
                rb_HH07d.getText().toString(),
                et_HH07d_other.getText().toString(),
                rb_HH07e.getText().toString(),
                rb_HH07f.getText().toString(),
                rb_HH07g.getText().toString(),
                rb_HH07h.getText().toString(),
                rb_HH07i.getText().toString(),
                rb_HH07j.getText().toString(),
                rb_HH07k.getText().toString(),
                rb_HH07l.getText().toString(),
                isSmartphone,
                rb_HH07n.getText().toString(),
                rb_HH07o.getText().toString(),
                rb_HH07p.getText().toString(),
                householdId);

        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "HouseholdInformation Edited Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    private void setRadioButtonValues(Modal_HIF modalHif) {

        if(modalHif.getHH07a().equalsIgnoreCase(getString(R.string.str_HH07a_one))) rg_hhRoofing.check(R.id.rb_HH07a_one);
        else if(modalHif.getHH07a().equalsIgnoreCase(getString(R.string.str_HH07a_two))) rg_hhRoofing.check(R.id.rb_HH07a_two);
        else if(modalHif.getHH07a().equalsIgnoreCase(getString(R.string.str_HH07a_three))) rg_hhRoofing.check(R.id.rb_HH07a_three);

        if(modalHif.getHH07b().equalsIgnoreCase(getString(R.string.str_HH07b_one))) rg_hhWall.check(R.id.rb_HH07b_one);
        else if(modalHif.getHH07b().equalsIgnoreCase(getString(R.string.str_HH07b_two))) rg_hhWall.check(R.id.rb_HH07b_two);
        else if(modalHif.getHH07b().equalsIgnoreCase(getString(R.string.str_HH07b_three))) rg_hhWall.check(R.id.rb_HH07b_three);

        if(modalHif.getHH07c().equalsIgnoreCase(getString(R.string.str_HH07c_one))) rg_lightSource.check(R.id.rb_HH07c_one);
        else if(modalHif.getHH07c().equalsIgnoreCase(getString(R.string.str_HH07c_two))) rg_lightSource.check(R.id.rb_HH07c_two);
        else if(modalHif.getHH07c().equalsIgnoreCase(getString(R.string.str_HH07c_three))) rg_lightSource.check(R.id.rb_HH07c_three);
        else if(modalHif.getHH07c().equalsIgnoreCase(getString(R.string.str_HH07c_four))) {
            rg_lightSource.check(R.id.rb_HH07c_four);
            et_HH07c_other.setText(modalHif.HH07cOther);
            til_HH07c.setVisibility(View.VISIBLE);
        }

        if(modalHif.getHH07d().equalsIgnoreCase(getString(R.string.str_HH07d_one))) rg_waterSource.check(R.id.rb_HH07d_one);
        else if(modalHif.getHH07d().equalsIgnoreCase(getString(R.string.str_HH07d_two))) rg_waterSource.check(R.id.rb_HH07d_two);
        else if(modalHif.getHH07d().equalsIgnoreCase(getString(R.string.str_HH07d_three))) rg_waterSource.check(R.id.rb_HH07d_three);
        else if(modalHif.getHH07d().equalsIgnoreCase(getString(R.string.str_HH07d_four))) rg_waterSource.check(R.id.rb_HH07d_four);
        else if(modalHif.getHH07d().equalsIgnoreCase(getString(R.string.str_HH07d_five))) rg_waterSource.check(R.id.rb_HH07d_five);
        else if(modalHif.getHH07d().equalsIgnoreCase(getString(R.string.str_HH07d_six))) rg_waterSource.check(R.id.rb_HH07d_six);
        else if(modalHif.getHH07d().equalsIgnoreCase(getString(R.string.str_HH07d_seven))) {
            rg_waterSource.check(R.id.rb_HH07d_seven);
            et_HH07d_other.setText(modalHif.HH07dOther);
            til_HH07d.setVisibility(View.VISIBLE);
        }

        if(modalHif.HH07e.equalsIgnoreCase(getString(R.string.yes))) rg_electricity.check(R.id.rb_HH07e_yes);
        else rg_electricity.check(R.id.rb_HH07e_No);

        if(modalHif.HH07f.equalsIgnoreCase(getString(R.string.yes))) rg_toilet.check(R.id.rb_HH07f_yes);
        else rg_toilet.check(R.id.rb_HH07f_No);

        if(modalHif.HH07g.equalsIgnoreCase(getString(R.string.yes))) rg_memberCompletedDiploma.check(R.id.rb_HH07g_yes);
        else rg_memberCompletedDiploma.check(R.id.rb_HH07g_No);

        if(modalHif.HH07h.equalsIgnoreCase(getString(R.string.yes))) rg_readingMaterial.check(R.id.rb_HH07h_yes);
        else rg_readingMaterial.check(R.id.rb_HH07h_No);

        if(modalHif.HH07i.equalsIgnoreCase(getString(R.string.yes))) rg_computer.check(R.id.rb_HH07i_yes);
        else rg_computer.check(R.id.rb_HH07i_No);

        if(modalHif.HH07j.equalsIgnoreCase(getString(R.string.yes))) rg_television.check(R.id.rb_HH07j_yes);
        else rg_television.check(R.id.rb_HH07j_No);

        if(modalHif.HH07k.equalsIgnoreCase(getString(R.string.yes))) rg_radio.check(R.id.rb_HH07k_yes);
        else rg_radio.check(R.id.rb_HH07k_No);

        if(modalHif.HH07l.equalsIgnoreCase(getString(R.string.yes))) {
            rg_mobile.check(R.id.rb_HH07l_yes);
            rl_isItSmartphone.setVisibility(View.VISIBLE);
        } else {
            rg_mobile.check(R.id.rb_HH07l_No);
            rl_isItSmartphone.setVisibility(View.GONE);
        }

        if(modalHif.HH07m.equalsIgnoreCase(getString(R.string.yes))) rg_isItSmartphone.check(R.id.rb_HH07m_yes);
        else rg_isItSmartphone.check(R.id.rb_HH07m_No);

        if(modalHif.HH07n.equalsIgnoreCase(getString(R.string.yes))) rg_fourWheeler.check(R.id.rb_HH07n_yes);
        else rg_fourWheeler.check(R.id.rb_HH07n_No);

        if(modalHif.HH07o.equalsIgnoreCase(getString(R.string.yes))) rg_twoWheeler.check(R.id.rb_HH07o_yes);
        else rg_twoWheeler.check(R.id.rb_HH07o_No);

        if(modalHif.HH07p.equalsIgnoreCase(getString(R.string.yes))) rg_bicycle.check(R.id.rb_HH07p_yes);
        else rg_bicycle.check(R.id.rb_HH07p_No);
    }

    public void getRadioButtonValues(){
        int selectedHH07a = rg_hhRoofing.getCheckedRadioButtonId();
        int selectedHH07b = rg_hhWall.getCheckedRadioButtonId();
        int selectedHH07c = rg_lightSource.getCheckedRadioButtonId();
        int selectedHH07d = rg_waterSource.getCheckedRadioButtonId();
        int selectedHH07e = rg_electricity.getCheckedRadioButtonId();
        int selectedHH07f = rg_toilet.getCheckedRadioButtonId();
        int selectedHH07g = rg_memberCompletedDiploma.getCheckedRadioButtonId();
        int selectedHH07h = rg_readingMaterial.getCheckedRadioButtonId();
        int selectedHH07i = rg_computer.getCheckedRadioButtonId();
        int selectedHH07j = rg_television.getCheckedRadioButtonId();
        int selectedHH07k = rg_radio.getCheckedRadioButtonId();
        int selectedHH07l = rg_mobile.getCheckedRadioButtonId();
        int selectedHH07m = rg_isItSmartphone.getCheckedRadioButtonId();
        int selectedHH07n = rg_fourWheeler.getCheckedRadioButtonId();
        int selectedHH07o = rg_twoWheeler.getCheckedRadioButtonId();
        int selectedHH07p = rg_bicycle.getCheckedRadioButtonId();

        rb_HH07a = getView().findViewById(selectedHH07a);
        rb_HH07b = getView().findViewById(selectedHH07b);
        rb_HH07c = getView().findViewById(selectedHH07c);
        rb_HH07d = getView().findViewById(selectedHH07d);
        rb_HH07e = getView().findViewById(selectedHH07e);
        rb_HH07f = getView().findViewById(selectedHH07f);
        rb_HH07g = getView().findViewById(selectedHH07g);
        rb_HH07h = getView().findViewById(selectedHH07h);
        rb_HH07i = getView().findViewById(selectedHH07i);
        rb_HH07j = getView().findViewById(selectedHH07j);
        rb_HH07k = getView().findViewById(selectedHH07k);
        rb_HH07l = getView().findViewById(selectedHH07l);
        rb_HH07m = getView().findViewById(selectedHH07m);
        rb_HH07n = getView().findViewById(selectedHH07n);
        rb_HH07o = getView().findViewById(selectedHH07o);
        rb_HH07p = getView().findViewById(selectedHH07p);
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
}
