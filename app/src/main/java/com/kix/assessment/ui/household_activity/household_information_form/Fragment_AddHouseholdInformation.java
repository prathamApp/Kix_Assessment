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
    @ViewById(R.id.et_HH06a)
    EditText et_members;
    @ViewById(R.id.rg_HH06b)
    RadioGroup rg_speakEnglish;
    @ViewById(R.id.rg_HH06c)
    RadioGroup rg_engHowOften;
    @ViewById(R.id.rg_HH06d)
    RadioGroup rg_anyOtherLang;
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
    RadioGroup rg_otherBooks;
    @ViewById(R.id.rg_HH07j)
    RadioGroup rg_computer;
    @ViewById(R.id.rg_HH07k)
    RadioGroup rg_television;
    @ViewById(R.id.rg_HH07l)
    RadioGroup rg_radio;
    @ViewById(R.id.rg_HH07m)
    RadioGroup rg_mobile;
    @ViewById(R.id.rg_HH07n)
    RadioGroup rg_isItSmartphone;
    @ViewById(R.id.rg_HH07o)
    RadioGroup rg_fourWheeler;
    @ViewById(R.id.rg_HH07p)
    RadioGroup rg_twoWheeler;
    @ViewById(R.id.rg_HH07q)
    RadioGroup rg_bicycle;

    @ViewById(R.id.rl_HH07n)
    RelativeLayout rl_isItSmartphone;

    @ViewById(R.id.rl_HH06c)
    RelativeLayout rl_howOften;

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

    String surveyorCode, villageId, householdId, hh07c_other="NA", hh07d_other="NA", str_isSmartphone;//, str_howOften="NA";

    RadioButton rb_HH06b, rb_HH06c, rb_HH06d, rb_HH07a, rb_HH07b, rb_HH07c, rb_HH07d, rb_HH07e, rb_HH07f, rb_HH07g, rb_HH07h,
            rb_HH07i, rb_HH07j, rb_HH07k, rb_HH07l, rb_HH07m, rb_HH07n, rb_HH07o, rb_HH07p, rb_HH07q;

    int selectedHH06b,selectedHH06c,selectedHH06d,selectedHH07a,selectedHH07b,selectedHH07c,selectedHH07d,selectedHH07e,selectedHH07f,selectedHH07g,selectedHH07h
            ,selectedHH07i,selectedHH07j,selectedHH07k,selectedHH07l,selectedHH07m,selectedHH07n,selectedHH07o,selectedHH07p,selectedHH07q;


    public Fragment_AddHouseholdInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {

        householdId = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);

        selectedHH06b = selectedHH06c = selectedHH06d = selectedHH07a = selectedHH07b = selectedHH07c = selectedHH07d = selectedHH07e
                = selectedHH07f = selectedHH07g = selectedHH07h = selectedHH07i = selectedHH07j = selectedHH07k = selectedHH07l = selectedHH07m
                = selectedHH07n = selectedHH07o = selectedHH07p = selectedHH07q = 99;

        if(getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD)!=null){

            tv_title.setText(getString(R.string.str_update_household_info));
            Modal_HIF modalHif = householdInformationDao.getHIFbyHouseholdId(householdId);
            et_members.setText(modalHif.HH06a);
            setRadioButtonValues(modalHif);
            if (modalHif.getHH06b().equalsIgnoreCase("1")) {
                rl_howOften.setVisibility(View.VISIBLE);
            }

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
            if(checkedId == R.id.rb_HH07m_yes) {
                rl_isItSmartphone.setVisibility(View.VISIBLE);
            } else {
                rl_isItSmartphone.setVisibility(View.GONE);
                rg_isItSmartphone.clearCheck();
            }
        });

        rg_speakEnglish.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.rb_HH06b_yes) {
                rl_howOften.setVisibility(View.VISIBLE);
            } else {
                rl_howOften.setVisibility(View.GONE);
                rg_engHowOften.clearCheck();
            }
        });

/*        rg_engHowOften.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==R.id.rb_HH06c_yes) {
                str_howOften="Always";
            } else if(checkedId==R.id.rb_HH06c_No){
                str_howOften="Sometimes";
            } else {
                str_howOften="NA";
            }
        });*/
    }

    @Click(R.id.btn_save)
    public void saveHIF(){
        getRadioButtonValues();

        if(selectedHH06b==99 || selectedHH06d==99 || selectedHH07a==99 || selectedHH07b==99 || selectedHH07c==99 || selectedHH07d==99 || selectedHH07e==99 ||
        selectedHH07f==99 || selectedHH07g==99 || selectedHH07h==99 || selectedHH07i==99 || selectedHH07j==99 ||
        selectedHH07k==99 ||selectedHH07l==99 || selectedHH07m==99 || selectedHH07o==99 || selectedHH07p==99 || selectedHH07q==99) {
            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            if (getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
                if (!et_HH07c_other.getText().toString().isEmpty())
                    hh07c_other = et_HH07c_other.getText().toString();
                if (!et_HH07d_other.getText().toString().isEmpty())
                    hh07d_other = et_HH07d_other.getText().toString();

                if(selectedHH07m==1){
                    if(selectedHH07n != 99) {
                        updateHIF();
                    } else {
                        Toast.makeText(getActivity(), "All fields are mandatory..", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    updateHIF();
                }
            } else {
                if(selectedHH07m==1){
                    if(selectedHH07n != 99) {
                        insertHIF();
                    } else {
                        Toast.makeText(getActivity(), "All fields are mandatory...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    insertHIF();
                }
            }
        }
    }

    private void insertHIF() {

        if(!et_HH07c_other.getText().toString().isEmpty()) hh07c_other = et_HH07c_other.getText().toString();
        if(!et_HH07d_other.getText().toString().isEmpty()) hh07d_other = et_HH07d_other.getText().toString();

        Modal_HIF modal_hif = new Modal_HIF();
        modal_hif.setHH06a(et_members.getText().toString());
        modal_hif.setHH06b(""+selectedHH06b);
        modal_hif.setHH06c(""+selectedHH06c);
        modal_hif.setHH06d(""+selectedHH06d);
        modal_hif.setHH07a(""+selectedHH07a);
        modal_hif.setHH07b(""+selectedHH07b);
        modal_hif.setHH07c(""+selectedHH07c);
        modal_hif.setHH07cOther(hh07c_other);
        modal_hif.setHH07d(""+selectedHH07d);
        modal_hif.setHH07dOther(hh07d_other);
        modal_hif.setHH07e(""+selectedHH07e);
        modal_hif.setHH07f(""+selectedHH07f);
        modal_hif.setHH07g(""+selectedHH07g);
        modal_hif.setHH07h(""+selectedHH07h);
        modal_hif.setHH07i(""+selectedHH07i);
        modal_hif.setHH07j(""+selectedHH07j);
        modal_hif.setHH07k(""+selectedHH07k);
        modal_hif.setHH07l(""+selectedHH07l);
        modal_hif.setHH07m(""+selectedHH07m);
        modal_hif.setHH07n(""+selectedHH07n);
        modal_hif.setHH07o(""+selectedHH07o);
        modal_hif.setHH07p(""+selectedHH07p);
        modal_hif.setHH07q(""+selectedHH07q);
        modal_hif.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_hif.setHouseholdId(householdId);
        modal_hif.setVillageId(villageId);
        modal_hif.setSentFlag(0);

        householdInformationDao.insertHouseholdInfo(modal_hif);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "HouseholdInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();

    }

    private void updateHIF() {
        householdInformationDao.updateHousehold(
                et_members.getText().toString(),
                ""+selectedHH06b,
                ""+selectedHH06c,
                ""+selectedHH06d,
                ""+selectedHH07a,
                ""+selectedHH07b,
                ""+selectedHH07c,
                et_HH07c_other.getText().toString(),
                ""+selectedHH07d,
                et_HH07d_other.getText().toString(),
                ""+selectedHH07e,
                ""+selectedHH07f,
                ""+selectedHH07g,
                ""+selectedHH07h,
                ""+selectedHH07i,
                ""+selectedHH07j,
                ""+selectedHH07k,
                ""+selectedHH07l,
                ""+selectedHH07m,
                ""+selectedHH07n,
                ""+selectedHH07o,
                ""+selectedHH07p,
                ""+selectedHH07q,
                householdId);

        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "HouseholdInformation Edited Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    private void setRadioButtonValues(Modal_HIF modalHif) {

        if(modalHif.HH06b.equalsIgnoreCase("1")) rg_speakEnglish.check(R.id.rb_HH06b_yes);
        else rg_speakEnglish.check(R.id.rb_HH06b_No);

        if(modalHif.HH06c.equalsIgnoreCase("1")) rg_engHowOften.check(R.id.rb_HH06c_yes);
        else if (modalHif.HH06c.equalsIgnoreCase("0")) rg_engHowOften.check(R.id.rb_HH06c_No);

        if(modalHif.HH06d.equalsIgnoreCase("1")) rg_anyOtherLang.check(R.id.rb_HH06d_yes);
        else rg_anyOtherLang.check(R.id.rb_HH06d_No);

        if(modalHif.getHH07a().equalsIgnoreCase("1")) rg_hhRoofing.check(R.id.rb_HH07a_one);
        else if(modalHif.getHH07a().equalsIgnoreCase("2")) rg_hhRoofing.check(R.id.rb_HH07a_two);
        else if(modalHif.getHH07a().equalsIgnoreCase("3")) rg_hhRoofing.check(R.id.rb_HH07a_three);

        if(modalHif.getHH07b().equalsIgnoreCase("1")) rg_hhWall.check(R.id.rb_HH07b_one);
        else if(modalHif.getHH07b().equalsIgnoreCase("2")) rg_hhWall.check(R.id.rb_HH07b_two);
        else if(modalHif.getHH07b().equalsIgnoreCase("3")) rg_hhWall.check(R.id.rb_HH07b_three);

        if(modalHif.getHH07c().equalsIgnoreCase("1")) rg_lightSource.check(R.id.rb_HH07c_one);
        else if(modalHif.getHH07c().equalsIgnoreCase("2")) rg_lightSource.check(R.id.rb_HH07c_two);
        else if(modalHif.getHH07c().equalsIgnoreCase("3")) rg_lightSource.check(R.id.rb_HH07c_three);
        else if(modalHif.getHH07c().equalsIgnoreCase("4")) {
            rg_lightSource.check(R.id.rb_HH07c_four);
            et_HH07c_other.setText(modalHif.HH07cOther);
            til_HH07c.setVisibility(View.VISIBLE);
        }

        if(modalHif.getHH07d().equalsIgnoreCase("1")) rg_waterSource.check(R.id.rb_HH07d_one);
        else if(modalHif.getHH07d().equalsIgnoreCase("2")) rg_waterSource.check(R.id.rb_HH07d_two);
        else if(modalHif.getHH07d().equalsIgnoreCase("3")) rg_waterSource.check(R.id.rb_HH07d_three);
        else if(modalHif.getHH07d().equalsIgnoreCase("4")) rg_waterSource.check(R.id.rb_HH07d_four);
        else if(modalHif.getHH07d().equalsIgnoreCase("5")) rg_waterSource.check(R.id.rb_HH07d_five);
        else if(modalHif.getHH07d().equalsIgnoreCase("6")) rg_waterSource.check(R.id.rb_HH07d_six);
        else if(modalHif.getHH07d().equalsIgnoreCase("7")) {
            rg_waterSource.check(R.id.rb_HH07d_seven);
            et_HH07d_other.setText(modalHif.HH07dOther);
            til_HH07d.setVisibility(View.VISIBLE);
        }

        if(modalHif.HH07e.equalsIgnoreCase("1")) rg_electricity.check(R.id.rb_HH07e_yes);
        else rg_electricity.check(R.id.rb_HH07e_No);

        if(modalHif.HH07f.equalsIgnoreCase("1")) rg_toilet.check(R.id.rb_HH07f_yes);
        else rg_toilet.check(R.id.rb_HH07f_No);

        if(modalHif.HH07g.equalsIgnoreCase("1")) rg_memberCompletedDiploma.check(R.id.rb_HH07g_yes);
        else rg_memberCompletedDiploma.check(R.id.rb_HH07g_No);

        if(modalHif.HH07h.equalsIgnoreCase("1")) rg_readingMaterial.check(R.id.rb_HH07h_yes);
        else rg_readingMaterial.check(R.id.rb_HH07h_No);

        if(modalHif.HH07i.equalsIgnoreCase("1")) rg_otherBooks.check(R.id.rb_HH07i_yes);
        else rg_otherBooks.check(R.id.rb_HH07i_No);

        if(modalHif.HH07j.equalsIgnoreCase("1")) rg_computer.check(R.id.rb_HH07j_yes);
        else rg_computer.check(R.id.rb_HH07j_No);

        if(modalHif.HH07k.equalsIgnoreCase("1")) rg_television.check(R.id.rb_HH07k_yes);
        else rg_television.check(R.id.rb_HH07k_No);

        if(modalHif.HH07l.equalsIgnoreCase("1")) {
            rg_radio.check(R.id.rb_HH07l_yes);
        } else {
            rg_radio.check(R.id.rb_HH07l_No);
        }

        if(modalHif.HH07m.equalsIgnoreCase("1")) {
            rg_mobile.check(R.id.rb_HH07m_yes);
            rl_isItSmartphone.setVisibility(View.VISIBLE);
        }
        else {
            rg_mobile.check(R.id.rb_HH07m_No);
            rl_isItSmartphone.setVisibility(View.GONE);
        }

        if(modalHif.HH07n.equalsIgnoreCase("1")) rg_isItSmartphone.check(R.id.rb_HH07n_yes);
        else rg_isItSmartphone.check(R.id.rb_HH07n_No);

        if(modalHif.HH07o.equalsIgnoreCase("1")) rg_fourWheeler.check(R.id.rb_HH07o_yes);
        else rg_fourWheeler.check(R.id.rb_HH07o_No);

        if(modalHif.HH07p.equalsIgnoreCase("1")) rg_twoWheeler.check(R.id.rb_HH07p_yes);
        else rg_twoWheeler.check(R.id.rb_HH07p_No);

        if(modalHif.HH07q.equalsIgnoreCase("1")) rg_bicycle.check(R.id.rb_HH07q_yes);
        else rg_bicycle.check(R.id.rb_HH07q_No);
    }

    public void getRadioButtonValues(){
/*        int selectedHH06b = rg_speakEnglish.getCheckedRadioButtonId();
        int selectedHH06c = rg_engHowOften.getCheckedRadioButtonId();
        int selectedHH06d = rg_anyOtherLang.getCheckedRadioButtonId();
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
        int selectedHH07q = rg_otherBooks.getCheckedRadioButtonId();

        rb_HH06b = getView().findViewById(selectedHH06b);
        rb_HH06c = getView().findViewById(selectedHH06c);
        rb_HH06d = getView().findViewById(selectedHH06d);
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
        rb_HH07q = getView().findViewById(selectedHH07q);*/

        if (this.getView().findViewById(this.rg_speakEnglish.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH06b_yes))
            selectedHH06b = 1;
        else if (this.getView().findViewById(this.rg_speakEnglish.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH06b_No))
            selectedHH06b = 0;
        if (this.getView().findViewById(this.rg_engHowOften.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH06c_yes))
            selectedHH06c = 1;
        else if (this.getView().findViewById(this.rg_engHowOften.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH06c_No))
            selectedHH06c = 0;
        if (this.getView().findViewById(this.rg_anyOtherLang.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH06d_yes))
            selectedHH06d = 1;
        else if (this.getView().findViewById(this.rg_anyOtherLang.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH06d_No))
            selectedHH06d = 0;
        if (this.getView().findViewById(this.rg_hhRoofing.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07a_one))
            selectedHH07a = 1;
        else if (this.getView().findViewById(this.rg_hhRoofing.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07a_two))
            selectedHH07a = 2;
        else if (this.getView().findViewById(this.rg_hhRoofing.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07a_three))
            selectedHH07a = 3;
        if (this.getView().findViewById(this.rg_hhWall.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07b_one))
            selectedHH07b = 1;
        else if (this.getView().findViewById(this.rg_hhWall.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07b_two))
            selectedHH07b = 2;
        else if (this.getView().findViewById(this.rg_hhWall.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07b_three))
            selectedHH07b = 3;
        if (this.getView().findViewById(this.rg_lightSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07c_one))
            selectedHH07c = 1;
        else if (this.getView().findViewById(this.rg_lightSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07c_two))
            selectedHH07c = 2;
        else if (this.getView().findViewById(this.rg_lightSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07c_three))
            selectedHH07c = 3;
        else if (this.getView().findViewById(this.rg_lightSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07c_four))
            selectedHH07c = 4;
        if (this.getView().findViewById(this.rg_waterSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07d_one))
            selectedHH07d = 1;
        else if (this.getView().findViewById(this.rg_waterSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07d_two))
            selectedHH07d = 2;
        else if (this.getView().findViewById(this.rg_waterSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07d_three))
            selectedHH07d = 3;
        else if (this.getView().findViewById(this.rg_waterSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07d_four))
            selectedHH07d = 4;
        else if (this.getView().findViewById(this.rg_waterSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07d_five))
            selectedHH07d = 5;
        else if (this.getView().findViewById(this.rg_waterSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07d_six))
            selectedHH07d = 6;
        else if (this.getView().findViewById(this.rg_waterSource.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07d_seven))
            selectedHH07d = 7;
        if (this.getView().findViewById(this.rg_electricity.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07e_yes))
            selectedHH07e = 1;
        else if (this.getView().findViewById(this.rg_electricity.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07e_No))
            selectedHH07e = 0;

        if (this.getView().findViewById(this.rg_toilet.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07f_yes))
            selectedHH07f = 1;
        else if (this.getView().findViewById(this.rg_toilet.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07f_No))
            selectedHH07f = 0;

        if (this.getView().findViewById(this.rg_memberCompletedDiploma.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07g_yes))
            selectedHH07g = 1;
        else if (this.getView().findViewById(this.rg_memberCompletedDiploma.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07g_No))
            selectedHH07g = 0;
        if (this.getView().findViewById(this.rg_readingMaterial.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07h_yes))
            selectedHH07h = 1;
        else if (this.getView().findViewById(this.rg_readingMaterial.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07h_No))
            selectedHH07h = 0;
        if (this.getView().findViewById(this.rg_otherBooks.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07i_yes))
            selectedHH07i = 1;
        else if (this.getView().findViewById(this.rg_otherBooks.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07i_No))
            selectedHH07i = 0;
        if (this.getView().findViewById(this.rg_computer.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07j_yes))
            selectedHH07j = 1;
        else if (this.getView().findViewById(this.rg_computer.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07j_No))
            selectedHH07j = 0;

        if (this.getView().findViewById(this.rg_television.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07k_yes))
            selectedHH07k = 1;
        else if (this.getView().findViewById(this.rg_television.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07k_No))
            selectedHH07k = 0;

        if (this.getView().findViewById(this.rg_radio.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07l_yes))
            selectedHH07l = 1;
        else if (this.getView().findViewById(this.rg_radio.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07l_No))
            selectedHH07l = 0;

        if (this.getView().findViewById(this.rg_mobile.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07m_yes))
            selectedHH07m = 1;
        else if (this.getView().findViewById(this.rg_mobile.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07m_No))
            selectedHH07m = 0;

        if (this.getView().findViewById(this.rg_isItSmartphone.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07n_yes))
            selectedHH07n = 1;
        else if (this.getView().findViewById(this.rg_isItSmartphone.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07n_No))
            selectedHH07n = 0;

        if (this.getView().findViewById(this.rg_fourWheeler.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07o_yes))
            selectedHH07o = 1;
        else if (this.getView().findViewById(this.rg_fourWheeler.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07o_No))
            selectedHH07o = 0;

        if (this.getView().findViewById(this.rg_twoWheeler.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07p_yes))
            selectedHH07p = 1;
        else if (this.getView().findViewById(this.rg_twoWheeler.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07p_No))
            selectedHH07p = 0;

        if (this.getView().findViewById(this.rg_bicycle.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07q_yes))
            selectedHH07q = 1;
        else if (this.getView().findViewById(this.rg_bicycle.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_HH07q_No))
            selectedHH07q = 0;
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
