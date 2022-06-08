package com.kix.assessment.ui.household_activity.household_information_form;

import static com.kix.assessment.KIXApplication.householdInformationDao;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_HIF;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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

        this.householdId = this.getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        this.villageId = this.getArguments().getString(Kix_Constant.VILLAGE_ID);

        this.selectedHH06b = this.selectedHH06c = this.selectedHH06d = this.selectedHH07a = this.selectedHH07b = this.selectedHH07c = this.selectedHH07d = this.selectedHH07e
                = this.selectedHH07f = this.selectedHH07g = this.selectedHH07h = this.selectedHH07i = this.selectedHH07j = this.selectedHH07k = this.selectedHH07l = this.selectedHH07m
                = this.selectedHH07n = this.selectedHH07o = this.selectedHH07p = this.selectedHH07q = 99;

        if(this.getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD)!=null){

            this.tv_title.setText(this.getString(R.string.str_update_household_info));
            final Modal_HIF modalHif = householdInformationDao.getHIFbyHouseholdId(this.householdId);
            this.et_members.setText(modalHif.HH06a);
            this.setRadioButtonValues(modalHif);
            if (modalHif.getHH06b().equalsIgnoreCase("1")) {
                this.rl_howOften.setVisibility(View.VISIBLE);
            }

        }

        this.rg_lightSource.setOnCheckedChangeListener((group, checkedId) -> {
                    if (checkedId == R.id.rb_HH07c_four) this.til_HH07c.setVisibility(View.VISIBLE);
                    else {
                        this.til_HH07c.setVisibility(View.GONE);
                        this.et_HH07c_other.setText("");
                    }
                }
        );

        this.rg_waterSource.setOnCheckedChangeListener((group, checkedId) -> {
                    if (checkedId == R.id.rb_HH07d_seven) this.til_HH07d.setVisibility(View.VISIBLE);
                    else {
                        this.til_HH07d.setVisibility(View.GONE);
                        this.et_HH07d_other.setText("");
                    }
                }
        );

        this.rg_mobile.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.rb_HH07m_yes) {
                this.rl_isItSmartphone.setVisibility(View.VISIBLE);
            } else {
                this.rl_isItSmartphone.setVisibility(View.GONE);
                this.rg_isItSmartphone.clearCheck();
            }
        });

        this.rg_speakEnglish.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.rb_HH06b_yes) {
                this.rl_howOften.setVisibility(View.VISIBLE);
            } else {
                this.rl_howOften.setVisibility(View.GONE);
                this.rg_engHowOften.clearCheck();
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
        this.getRadioButtonValues();

        if(this.selectedHH06b ==99 || this.selectedHH06d ==99 || this.selectedHH07a ==99 || this.selectedHH07b ==99 || this.selectedHH07c ==99 || this.selectedHH07d ==99 || this.selectedHH07e ==99 ||
                this.selectedHH07f ==99 || this.selectedHH07g ==99 || this.selectedHH07h ==99 || this.selectedHH07i ==99 || this.selectedHH07j ==99 ||
                this.selectedHH07k ==99 || this.selectedHH07l ==99 || this.selectedHH07m ==99 || this.selectedHH07o ==99 || this.selectedHH07p ==99 || this.selectedHH07q ==99) {
            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            if (this.getArguments().getString(Kix_Constant.EDIT_HOUSEHOLD) != null) {
                if (!this.et_HH07c_other.getText().toString().isEmpty())
                    this.hh07c_other = this.et_HH07c_other.getText().toString();
                if (!this.et_HH07d_other.getText().toString().isEmpty())
                    this.hh07d_other = this.et_HH07d_other.getText().toString();

                if(this.selectedHH07m ==1){
                    if(this.selectedHH07n != 99) {
                        this.updateHIF();
                    } else {
                        Toast.makeText(this.getActivity(), "All fields are mandatory..", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    this.updateHIF();
                }
            } else {
                if(this.selectedHH07m ==1){
                    if(this.selectedHH07n != 99) {
                        this.insertHIF();
                    } else {
                        Toast.makeText(this.getActivity(), "All fields are mandatory...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    this.insertHIF();
                }
            }
        }
    }

    private void insertHIF() {

        if(!this.et_HH07c_other.getText().toString().isEmpty()) this.hh07c_other = this.et_HH07c_other.getText().toString();
        if(!this.et_HH07d_other.getText().toString().isEmpty()) this.hh07d_other = this.et_HH07d_other.getText().toString();

        final Modal_HIF modal_hif = new Modal_HIF();
        modal_hif.setHH06a(this.et_members.getText().toString());
        modal_hif.setHH06b(""+ this.selectedHH06b);
        modal_hif.setHH06c(""+ this.selectedHH06c);
        modal_hif.setHH06d(""+ this.selectedHH06d);
        modal_hif.setHH07a(""+ this.selectedHH07a);
        modal_hif.setHH07b(""+ this.selectedHH07b);
        modal_hif.setHH07c(""+ this.selectedHH07c);
        modal_hif.setHH07cOther(this.hh07c_other);
        modal_hif.setHH07d(""+ this.selectedHH07d);
        modal_hif.setHH07dOther(this.hh07d_other);
        modal_hif.setHH07e(""+ this.selectedHH07e);
        modal_hif.setHH07f(""+ this.selectedHH07f);
        modal_hif.setHH07g(""+ this.selectedHH07g);
        modal_hif.setHH07h(""+ this.selectedHH07h);
        modal_hif.setHH07i(""+ this.selectedHH07i);
        modal_hif.setHH07j(""+ this.selectedHH07j);
        modal_hif.setHH07k(""+ this.selectedHH07k);
        modal_hif.setHH07l(""+ this.selectedHH07l);
        modal_hif.setHH07m(""+ this.selectedHH07m);
        modal_hif.setHH07n(""+ this.selectedHH07n);
        modal_hif.setHH07o(""+ this.selectedHH07o);
        modal_hif.setHH07p(""+ this.selectedHH07p);
        modal_hif.setHH07q(""+ this.selectedHH07q);
        modal_hif.setInfo_createdOn(KIX_Utility.getCurrentDateTime());
        modal_hif.setHouseholdId(this.householdId);
        modal_hif.setVillageId(this.villageId);
        modal_hif.setSentFlag(0);

        householdInformationDao.insertHouseholdInfo(modal_hif);
        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "HouseholdInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        this.getFragmentManager().popBackStack();

    }

    private void updateHIF() {
        householdInformationDao.updateHousehold(
                this.et_members.getText().toString(),
                ""+ this.selectedHH06b,
                ""+ this.selectedHH06c,
                ""+ this.selectedHH06d,
                ""+ this.selectedHH07a,
                ""+ this.selectedHH07b,
                ""+ this.selectedHH07c,
                this.et_HH07c_other.getText().toString(),
                ""+ this.selectedHH07d,
                this.et_HH07d_other.getText().toString(),
                ""+ this.selectedHH07e,
                ""+ this.selectedHH07f,
                ""+ this.selectedHH07g,
                ""+ this.selectedHH07h,
                ""+ this.selectedHH07i,
                ""+ this.selectedHH07j,
                ""+ this.selectedHH07k,
                ""+ this.selectedHH07l,
                ""+ this.selectedHH07m,
                ""+ this.selectedHH07n,
                ""+ this.selectedHH07o,
                ""+ this.selectedHH07p,
                ""+ this.selectedHH07q,
                this.householdId);

        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "HouseholdInformation Edited Successfully!", Toast.LENGTH_SHORT).show();
        this.getFragmentManager().popBackStack();
    }

    private void setRadioButtonValues(final Modal_HIF modalHif) {

        if(modalHif.HH06b.equalsIgnoreCase("1")) this.rg_speakEnglish.check(R.id.rb_HH06b_yes);
        else this.rg_speakEnglish.check(R.id.rb_HH06b_No);

        if(modalHif.HH06c.equalsIgnoreCase("1")) this.rg_engHowOften.check(R.id.rb_HH06c_yes);
        else if (modalHif.HH06c.equalsIgnoreCase("0")) this.rg_engHowOften.check(R.id.rb_HH06c_No);

        if(modalHif.HH06d.equalsIgnoreCase("1")) this.rg_anyOtherLang.check(R.id.rb_HH06d_yes);
        else this.rg_anyOtherLang.check(R.id.rb_HH06d_No);

        if(modalHif.getHH07a().equalsIgnoreCase("1")) this.rg_hhRoofing.check(R.id.rb_HH07a_one);
        else if(modalHif.getHH07a().equalsIgnoreCase("2")) this.rg_hhRoofing.check(R.id.rb_HH07a_two);
        else if(modalHif.getHH07a().equalsIgnoreCase("3")) this.rg_hhRoofing.check(R.id.rb_HH07a_three);

        if(modalHif.getHH07b().equalsIgnoreCase("1")) this.rg_hhWall.check(R.id.rb_HH07b_one);
        else if(modalHif.getHH07b().equalsIgnoreCase("2")) this.rg_hhWall.check(R.id.rb_HH07b_two);
        else if(modalHif.getHH07b().equalsIgnoreCase("3")) this.rg_hhWall.check(R.id.rb_HH07b_three);

        if(modalHif.getHH07c().equalsIgnoreCase("1")) this.rg_lightSource.check(R.id.rb_HH07c_one);
        else if(modalHif.getHH07c().equalsIgnoreCase("2")) this.rg_lightSource.check(R.id.rb_HH07c_two);
        else if(modalHif.getHH07c().equalsIgnoreCase("3")) this.rg_lightSource.check(R.id.rb_HH07c_three);
        else if(modalHif.getHH07c().equalsIgnoreCase("4")) {
            this.rg_lightSource.check(R.id.rb_HH07c_four);
            this.et_HH07c_other.setText(modalHif.HH07cOther);
            this.til_HH07c.setVisibility(View.VISIBLE);
        }

        if(modalHif.getHH07d().equalsIgnoreCase("1")) this.rg_waterSource.check(R.id.rb_HH07d_one);
        else if(modalHif.getHH07d().equalsIgnoreCase("2")) this.rg_waterSource.check(R.id.rb_HH07d_two);
        else if(modalHif.getHH07d().equalsIgnoreCase("3")) this.rg_waterSource.check(R.id.rb_HH07d_three);
        else if(modalHif.getHH07d().equalsIgnoreCase("4")) this.rg_waterSource.check(R.id.rb_HH07d_four);
        else if(modalHif.getHH07d().equalsIgnoreCase("5")) this.rg_waterSource.check(R.id.rb_HH07d_five);
        else if(modalHif.getHH07d().equalsIgnoreCase("6")) this.rg_waterSource.check(R.id.rb_HH07d_six);
        else if(modalHif.getHH07d().equalsIgnoreCase("7")) {
            this.rg_waterSource.check(R.id.rb_HH07d_seven);
            this.et_HH07d_other.setText(modalHif.HH07dOther);
            this.til_HH07d.setVisibility(View.VISIBLE);
        }

        if(modalHif.HH07e.equalsIgnoreCase("1")) this.rg_electricity.check(R.id.rb_HH07e_yes);
        else this.rg_electricity.check(R.id.rb_HH07e_No);

        if(modalHif.HH07f.equalsIgnoreCase("1")) this.rg_toilet.check(R.id.rb_HH07f_yes);
        else this.rg_toilet.check(R.id.rb_HH07f_No);

        if(modalHif.HH07g.equalsIgnoreCase("1")) this.rg_memberCompletedDiploma.check(R.id.rb_HH07g_yes);
        else this.rg_memberCompletedDiploma.check(R.id.rb_HH07g_No);

        if(modalHif.HH07h.equalsIgnoreCase("1")) this.rg_readingMaterial.check(R.id.rb_HH07h_yes);
        else this.rg_readingMaterial.check(R.id.rb_HH07h_No);

        if(modalHif.HH07i.equalsIgnoreCase("1")) this.rg_otherBooks.check(R.id.rb_HH07i_yes);
        else this.rg_otherBooks.check(R.id.rb_HH07i_No);

        if(modalHif.HH07j.equalsIgnoreCase("1")) this.rg_computer.check(R.id.rb_HH07j_yes);
        else this.rg_computer.check(R.id.rb_HH07j_No);

        if(modalHif.HH07k.equalsIgnoreCase("1")) this.rg_television.check(R.id.rb_HH07k_yes);
        else this.rg_television.check(R.id.rb_HH07k_No);

        if(modalHif.HH07l.equalsIgnoreCase("1")) {
            this.rg_radio.check(R.id.rb_HH07l_yes);
        } else {
            this.rg_radio.check(R.id.rb_HH07l_No);
        }

        if(modalHif.HH07m.equalsIgnoreCase("1")) {
            this.rg_mobile.check(R.id.rb_HH07m_yes);
            this.rl_isItSmartphone.setVisibility(View.VISIBLE);
        }
        else {
            this.rg_mobile.check(R.id.rb_HH07m_No);
            this.rl_isItSmartphone.setVisibility(View.GONE);
        }

        if(modalHif.HH07n.equalsIgnoreCase("1")) this.rg_isItSmartphone.check(R.id.rb_HH07n_yes);
        else this.rg_isItSmartphone.check(R.id.rb_HH07n_No);

        if(modalHif.HH07o.equalsIgnoreCase("1")) this.rg_fourWheeler.check(R.id.rb_HH07o_yes);
        else this.rg_fourWheeler.check(R.id.rb_HH07o_No);

        if(modalHif.HH07p.equalsIgnoreCase("1")) this.rg_twoWheeler.check(R.id.rb_HH07p_yes);
        else this.rg_twoWheeler.check(R.id.rb_HH07p_No);

        if(modalHif.HH07q.equalsIgnoreCase("1")) this.rg_bicycle.check(R.id.rb_HH07q_yes);
        else this.rg_bicycle.check(R.id.rb_HH07q_No);
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

        if (getView().findViewById(rg_speakEnglish.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH06b_yes))
            this.selectedHH06b = 1;
        else if (getView().findViewById(rg_speakEnglish.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH06b_No))
            this.selectedHH06b = 0;
        if (getView().findViewById(rg_engHowOften.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH06c_yes))
            this.selectedHH06c = 1;
        else if (getView().findViewById(rg_engHowOften.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH06c_No))
            this.selectedHH06c = 0;
        if (getView().findViewById(rg_anyOtherLang.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH06d_yes))
            this.selectedHH06d = 1;
        else if (getView().findViewById(rg_anyOtherLang.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH06d_No))
            this.selectedHH06d = 0;
        if (getView().findViewById(rg_hhRoofing.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07a_one))
            this.selectedHH07a = 1;
        else if (getView().findViewById(rg_hhRoofing.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07a_two))
            this.selectedHH07a = 2;
        else if (getView().findViewById(rg_hhRoofing.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07a_three))
            this.selectedHH07a = 3;
        if (getView().findViewById(rg_hhWall.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07b_one))
            this.selectedHH07b = 1;
        else if (getView().findViewById(rg_hhWall.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07b_two))
            this.selectedHH07b = 2;
        else if (getView().findViewById(rg_hhWall.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07b_three))
            this.selectedHH07b = 3;
        if (getView().findViewById(rg_lightSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07c_one))
            this.selectedHH07c = 1;
        else if (getView().findViewById(rg_lightSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07c_two))
            this.selectedHH07c = 2;
        else if (getView().findViewById(rg_lightSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07c_three))
            this.selectedHH07c = 3;
        else if (getView().findViewById(rg_lightSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07c_four))
            this.selectedHH07c = 4;
        if (getView().findViewById(rg_waterSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07d_one))
            this.selectedHH07d = 1;
        else if (getView().findViewById(rg_waterSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07d_two))
            this.selectedHH07d = 2;
        else if (getView().findViewById(rg_waterSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07d_three))
            this.selectedHH07d = 3;
        else if (getView().findViewById(rg_waterSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07d_four))
            this.selectedHH07d = 4;
        else if (getView().findViewById(rg_waterSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07d_five))
            this.selectedHH07d = 5;
        else if (getView().findViewById(rg_waterSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07d_six))
            this.selectedHH07d = 6;
        else if (getView().findViewById(rg_waterSource.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07d_seven))
            this.selectedHH07d = 7;
        if (getView().findViewById(rg_electricity.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07e_yes))
            this.selectedHH07e = 1;
        else if (getView().findViewById(rg_electricity.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07e_No))
            this.selectedHH07e = 0;

        if (getView().findViewById(rg_toilet.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07f_yes))
            this.selectedHH07f = 1;
        else if (getView().findViewById(rg_toilet.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07f_No))
            this.selectedHH07f = 0;

        if (getView().findViewById(rg_memberCompletedDiploma.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07g_yes))
            this.selectedHH07g = 1;
        else if (getView().findViewById(rg_memberCompletedDiploma.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07g_No))
            this.selectedHH07g = 0;
        if (getView().findViewById(rg_readingMaterial.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07h_yes))
            this.selectedHH07h = 1;
        else if (getView().findViewById(rg_readingMaterial.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07h_No))
            this.selectedHH07h = 0;
        if (getView().findViewById(rg_otherBooks.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07i_yes))
            this.selectedHH07i = 1;
        else if (getView().findViewById(rg_otherBooks.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07i_No))
            this.selectedHH07i = 0;
        if (getView().findViewById(rg_computer.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07j_yes))
            this.selectedHH07j = 1;
        else if (getView().findViewById(rg_computer.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07j_No))
            this.selectedHH07j = 0;

        if (getView().findViewById(rg_television.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07k_yes))
            this.selectedHH07k = 1;
        else if (getView().findViewById(rg_television.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07k_No))
            this.selectedHH07k = 0;

        if (getView().findViewById(rg_radio.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07l_yes))
            this.selectedHH07l = 1;
        else if (getView().findViewById(rg_radio.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07l_No))
            this.selectedHH07l = 0;

        if (getView().findViewById(rg_mobile.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07m_yes))
            this.selectedHH07m = 1;
        else if (getView().findViewById(rg_mobile.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07m_No))
            this.selectedHH07m = 0;

        if (getView().findViewById(rg_isItSmartphone.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07n_yes))
            this.selectedHH07n = 1;
        else if (getView().findViewById(rg_isItSmartphone.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07n_No))
            this.selectedHH07n = 0;

        if (getView().findViewById(rg_fourWheeler.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07o_yes))
            this.selectedHH07o = 1;
        else if (getView().findViewById(rg_fourWheeler.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07o_No))
            this.selectedHH07o = 0;

        if (getView().findViewById(rg_twoWheeler.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07p_yes))
            this.selectedHH07p = 1;
        else if (getView().findViewById(rg_twoWheeler.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07p_No))
            this.selectedHH07p = 0;

        if (getView().findViewById(rg_bicycle.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07q_yes))
            this.selectedHH07q = 1;
        else if (getView().findViewById(rg_bicycle.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_HH07q_No))
            this.selectedHH07q = 0;
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
}
