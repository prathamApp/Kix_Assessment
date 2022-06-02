package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form;

import static com.kix.assessment.KIXApplication.parentInformationDao;
import static com.kix.assessment.kix_utils.Kix_Constant.EDIT_PARENT;
import static com.kix.assessment.kix_utils.Kix_Constant.HOUSEHOLD_ID;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.modal_classes.Modal_PIF;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

@EFragment(R.layout.fragment_add_parentinformation)
public class Fragment_AddParentInfoForm extends Fragment {

    @ViewById(R.id.tv_label)
    TextView tv_label;
    @ViewById(R.id.et_mothersName)
    EditText et_motherName;
    @ViewById(R.id.spinner_mothersAge)
    Spinner spinner_mothersAge;
    @ViewById(R.id.rg_PT01c)
    RadioGroup rg_motherAttendSchool;
    @ViewById(R.id.rg_PT01d)
    RadioGroup rg_mothersScooling;
    @ViewById(R.id.rg_PT01e)
    RadioGroup rg_motherIncome;
    @ViewById(R.id.rg_PT01f)
    RadioGroup rg_motherWork;

    @ViewById(R.id.et_fathersName)
    EditText et_fatherName;
    @ViewById(R.id.spinner_fathersAge)
    Spinner spinner_fathersAge;
    @ViewById(R.id.rg_PT02c)
    RadioGroup rg_fatherAttendSchool;
    @ViewById(R.id.rg_PT02d)
    RadioGroup rg_fathersSchooling;
    @ViewById(R.id.rg_PT02e)
    RadioGroup rg_fatherIncome;
    @ViewById(R.id.rg_PT02f)
    RadioGroup rg_fatherWork;

    @ViewById(R.id.rl_PT01f)
    RelativeLayout rl_motherWork;
    @ViewById(R.id.rl_PT02f)
    RelativeLayout rl_fatherWork;

    @ViewById(R.id.rl_PT01d)
    RelativeLayout rl_motherSchooling;
    @ViewById(R.id.rl_PT02d)
    RelativeLayout rl_fatherSchooling;

    @ViewById(R.id.rg_selectPerson)
    RadioGroup rg_selectPerson;
    @ViewById(R.id.ll_selectPerson)
    LinearLayout ll_selectPerson;
    @ViewById(R.id.sv_pif)
    ScrollView sv_pif;
    @ViewById(R.id.ll_motherInfo)
    LinearLayout ll_motherInfo;
    @ViewById(R.id.ll_fatherInfo)
    LinearLayout ll_fatherInfo;

    @ViewById(R.id.btn_saveParent)
    Button btn_saveParent;

    ArrayAdapter ageAdapter, gradeAdapter;

    RadioButton rb_PT01c, rb_PT01d, rb_PT01e, rb_PT01f, rb_PT02c, rb_PT02d, rb_PT02e, rb_PT02f, rb_selectPerson;
    String str_selectedPerson;// str_PT01c, str_PT01e, str_PT01f, str_PT02c, str_PT02e, str_PT02f;

    //public String mothersName, fathersName;
    public String mothersAge, mothersSchooling, fathersAge, fathersSchooling;
    public String studentId, householdId;

    public Fragment_AddParentInfoForm() {
        // Required empty public constructor
    }

    @AfterViews
    public void init() {

        this.studentId = this.getArguments().getString(STUDENT_ID);
        this.householdId = this.getArguments().getString(HOUSEHOLD_ID);

        this.ageAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(this.getActivity()), R.array.parentAge, R.layout.spinner_item);
        this.spinner_mothersAge.setAdapter(this.ageAdapter);
        this.spinner_fathersAge.setAdapter(this.ageAdapter);

        if (this.getArguments().getString(EDIT_PARENT) != null) {
            this.ll_selectPerson.setVisibility(View.GONE);
            this.sv_pif.setVisibility(View.VISIBLE);
            this.ll_motherInfo.setVisibility(View.VISIBLE);
            this.ll_fatherInfo.setVisibility(View.VISIBLE);
            this.btn_saveParent.setText("Update");
            this.tv_label.setText("Update Parent Information");
            this.btn_saveParent.setVisibility(View.VISIBLE);

            final Modal_PIF modalPif = parentInformationDao.getPIFbyStudentId(this.studentId);
            this.fetchParentDetails(modalPif);
        }

        this.rg_motherAttendSchool.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT01c_yes) this.rl_motherSchooling.setVisibility(View.VISIBLE);
            else {
                this.rl_motherSchooling.setVisibility(View.GONE);
                rg_mothersScooling.clearCheck();
            }
        });

        this.rg_fatherAttendSchool.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT02c_yes) this.rl_fatherSchooling.setVisibility(View.VISIBLE);
            else {
                this.rl_fatherSchooling.setVisibility(View.GONE);
                rg_fathersSchooling.clearCheck();
            }
        });

        this.rg_motherIncome.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT01e_yes) this.rl_motherWork.setVisibility(View.VISIBLE);
            else {
                this.rl_motherWork.setVisibility(View.GONE);
                this.rg_motherWork.clearCheck();
            }
        });

        this.rg_fatherIncome.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT02e_yes) this.rl_fatherWork.setVisibility(View.VISIBLE);
            else {
                this.rl_fatherWork.setVisibility(View.GONE);
                this.rg_fatherWork.clearCheck();
            }
        });

    }

    private void fetchParentDetails(final Modal_PIF modalPif) {
        this.et_motherName.setText(modalPif.PT01a);
        this.spinner_mothersAge.setSelection(this.ageAdapter.getPosition(modalPif.PT01b));
        if (modalPif.PT01c.equalsIgnoreCase(this.getString(R.string.yes))) {
            this.rg_motherAttendSchool.check(R.id.rb_PT01c_yes);
            this.rl_motherSchooling.setVisibility(View.VISIBLE);
            if (modalPif.PT01d.equalsIgnoreCase(getString(R.string.str_PT0d_one)))
                rg_mothersScooling.check(R.id.rb_PT01d_one);
            else if (modalPif.PT01d.equalsIgnoreCase(getString(R.string.str_PT0d_two)))
                rg_mothersScooling.check(R.id.rb_PT01d_two);
            else if (modalPif.PT01d.equalsIgnoreCase(getString(R.string.str_PT0d_three)))
                rg_mothersScooling.check(R.id.rb_PT01d_three);
            else if (modalPif.PT01d.equalsIgnoreCase(getString(R.string.str_PT0d_four)))
                rg_mothersScooling.check(R.id.rb_PT01d_four);
        } else this.rg_motherAttendSchool.check(R.id.rb_PT01c_No);
        if (modalPif.PT01e.equalsIgnoreCase(this.getString(R.string.yes))) {
            this.rg_motherIncome.check(R.id.rb_PT01e_yes);
            this.rl_motherWork.setVisibility(View.VISIBLE);
            if (modalPif.PT01f.equalsIgnoreCase(this.getString(R.string.str_PT01f_one)))
                this.rg_motherWork.check(R.id.rb_PT01f_one);
            else if (modalPif.PT01f.equalsIgnoreCase(this.getString(R.string.str_PT01f_two)))
                this.rg_motherWork.check(R.id.rb_PT01f_two);
            else if (modalPif.PT01f.equalsIgnoreCase(this.getString(R.string.str_PT01f_three)))
                this.rg_motherWork.check(R.id.rb_PT01f_three);
            else if (modalPif.PT01f.equalsIgnoreCase(this.getString(R.string.str_PT01f_four)))
                this.rg_motherWork.check(R.id.rb_PT01f_four);
        } else this.rg_motherIncome.check(R.id.rb_PT01e_No);

        this.et_fatherName.setText(modalPif.PT02a);
        this.spinner_fathersAge.setSelection(this.ageAdapter.getPosition(modalPif.PT02b));
        if (modalPif.PT02c.equalsIgnoreCase(this.getString(R.string.yes))) {
            this.rg_fatherAttendSchool.check(R.id.rb_PT02c_yes);
            this.rl_fatherSchooling.setVisibility(View.VISIBLE);
            if (modalPif.PT02d.equalsIgnoreCase(getString(R.string.str_PT0d_one)))
                rg_fathersSchooling.check(R.id.rb_PT02d_one);
            else if (modalPif.PT02d.equalsIgnoreCase(getString(R.string.str_PT0d_two)))
                rg_fathersSchooling.check(R.id.rb_PT02d_two);
            else if (modalPif.PT02d.equalsIgnoreCase(getString(R.string.str_PT0d_three)))
                rg_fathersSchooling.check(R.id.rb_PT02d_three);
            else if (modalPif.PT02d.equalsIgnoreCase(getString(R.string.str_PT0d_four)))
                rg_fathersSchooling.check(R.id.rb_PT02d_four);
        } else this.rg_fatherAttendSchool.check(R.id.rb_PT02c_No);
        if (modalPif.PT02e.equalsIgnoreCase(this.getString(R.string.yes))) {
            this.rg_fatherIncome.check(R.id.rb_PT02e_yes);
            this.rl_fatherWork.setVisibility(View.VISIBLE);
            if (modalPif.PT02f.equalsIgnoreCase(this.getString(R.string.str_PT01f_one)))
                this.rg_fatherWork.check(R.id.rb_PT02f_one);
            else if (modalPif.PT02f.equalsIgnoreCase(this.getString(R.string.str_PT01f_two)))
                this.rg_fatherWork.check(R.id.rb_PT02f_two);
            else if (modalPif.PT02f.equalsIgnoreCase(this.getString(R.string.str_PT01f_three)))
                this.rg_fatherWork.check(R.id.rb_PT02f_three);
            else if (modalPif.PT02f.equalsIgnoreCase(this.getString(R.string.str_PT01f_four)))
                this.rg_fatherWork.check(R.id.rb_PT02f_four);
        } else this.rg_fatherIncome.check(R.id.rb_PT02e_No);
    }

    @Click(R.id.btn_enterDetails)
    public void enterDetails() {
        final int selectedPerson = this.rg_selectPerson.getCheckedRadioButtonId();
        this.rb_selectPerson = this.getView().findViewById(selectedPerson);
        this.str_selectedPerson = this.rb_selectPerson.getText().toString();

        if (this.rb_selectPerson != null) {
            this.sv_pif.setVisibility(View.VISIBLE);
            this.btn_saveParent.setVisibility(View.VISIBLE);
            if (this.str_selectedPerson.equalsIgnoreCase(this.getString(R.string.str_mother))) {
                this.ll_motherInfo.setVisibility(View.VISIBLE);
                this.ll_selectPerson.setVisibility(View.GONE);
            } else if (this.str_selectedPerson.equalsIgnoreCase(this.getString(R.string.str_father))) {
                this.ll_fatherInfo.setVisibility(View.VISIBLE);
                this.ll_selectPerson.setVisibility(View.GONE);
            } else if (this.str_selectedPerson.equalsIgnoreCase(this.getString(R.string.str_both))) {
                this.ll_motherInfo.setVisibility(View.VISIBLE);
                this.ll_fatherInfo.setVisibility(View.VISIBLE);
                this.ll_selectPerson.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(this.getActivity(), "Select Parent First.", Toast.LENGTH_SHORT).show();
        }
    }

    @Click(R.id.btn_saveParent)
    public void saveParent() {
        this.getRadioButtonValues();
        this.getSpinnerValues();

        if (this.getArguments().getString(EDIT_PARENT) != null) {
            if (this.rb_PT01c == null || this.rb_PT01e == null || this.rb_PT02c == null || this.rb_PT02e == null ||
                    this.et_motherName.getText().toString().isEmpty() || this.et_fatherName.getText().toString().isEmpty()) {
                Toast.makeText(this.getActivity(), "All Fields are mandatory.", Toast.LENGTH_SHORT).show();
            } else {
                final String str_PT01f;
                final String str_PT02f;
                if(this.rb_PT01f == null) str_PT01f="NA";
                else str_PT01f = this.rb_PT01f.getText().toString();
                if(this.rb_PT02f == null) str_PT02f="NA";
                else str_PT02f = this.rb_PT02f.getText().toString();
                if(rb_PT01d == null) mothersSchooling="NA";
                else mothersSchooling=rb_PT01d.getText().toString();
                if(rb_PT02d == null) fathersSchooling="NA";
                else fathersSchooling=rb_PT02d.getText().toString();

                this.updatePIF(this.rb_PT01c.getText().toString(), this.rb_PT01e.getText().toString(), str_PT01f,
                        this.rb_PT02c.getText().toString(), this.rb_PT02e.getText().toString(), str_PT02f);
            }
        } else {
            if (this.str_selectedPerson.equalsIgnoreCase(this.getString(R.string.str_mother))) {
                if (this.rb_PT01c == null || this.rb_PT01e == null || this.et_motherName.getText().toString().isEmpty()) {
                    Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                } else {
                    if(rb_PT01d == null) mothersSchooling="NA";
                    else mothersSchooling=rb_PT01d.getText().toString();
                    fathersSchooling="NA";
                    if (this.rb_PT01e.getText().toString().equalsIgnoreCase(this.getString(R.string.yes))) {
                        if (this.rb_PT01f != null) {
                            this.insertPIF(this.et_motherName.getText().toString(), this.rb_PT01c.getText().toString(), this.rb_PT01e.getText().toString(), this.rb_PT01f.getText().toString(),
                                    "NA", "NA", "NA", "NA");
                        } else {
                            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        this.insertPIF(this.et_motherName.getText().toString(), this.rb_PT01c.getText().toString(), this.rb_PT01e.getText().toString(), "NA",
                                "NA", "NA", "NA", "NA");
                    }
                }

                //todo Add new field in PIF db selectedPerson
            } else if (this.str_selectedPerson.equalsIgnoreCase(this.getString(R.string.str_father))) {
                if (this.rb_PT02c == null || this.rb_PT02e == null || this.et_fatherName.getText().toString().isEmpty()) {
                    Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                } else {
                    if(rb_PT02d == null) fathersSchooling="NA";
                    else fathersSchooling=rb_PT02d.getText().toString();
                    mothersSchooling="NA";
                    if (this.rb_PT02e.getText().toString().equalsIgnoreCase(this.getString(R.string.yes))) {
                        if (this.rb_PT02f != null) {
                            this.insertPIF("NA", "NA", "NA", "NA",
                                    this.et_fatherName.getText().toString(), this.rb_PT02c.getText().toString(), this.rb_PT02e.getText().toString(), this.rb_PT02f.getText().toString());
                        } else {
                            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        this.insertPIF("NA", "NA", "NA", "NA",
                                this.et_fatherName.getText().toString(), this.rb_PT02c.getText().toString(), this.rb_PT02e.getText().toString(), "NA");
                    }
                }
            } else if (this.str_selectedPerson.equalsIgnoreCase(this.getString(R.string.str_both))) {
                if (this.rb_PT01c == null || this.rb_PT01e == null || this.rb_PT02c == null || this.rb_PT02e == null ||
                        this.et_motherName.getText().toString().isEmpty() || this.et_fatherName.getText().toString().isEmpty()) {
                    Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                } else {
                    if(rb_PT01d == null) mothersSchooling="NA";
                    else mothersSchooling=rb_PT01d.getText().toString();
                    if(rb_PT02d == null) fathersSchooling="NA";
                    else fathersSchooling=rb_PT02d.getText().toString();

                    if (this.rb_PT01e.getText().toString().equalsIgnoreCase(this.getString(R.string.yes)) && this.rb_PT02e.getText().toString().equalsIgnoreCase(this.getString(R.string.yes))) {
                        if (this.rb_PT01f != null && this.rb_PT02f != null) {
                            this.insertPIF(this.et_motherName.getText().toString(), this.rb_PT01c.getText().toString(), this.rb_PT01e.getText().toString(), this.rb_PT01f.getText().toString(),
                                    this.et_fatherName.getText().toString(), this.rb_PT02c.getText().toString(), this.rb_PT02e.getText().toString(), this.rb_PT02f.getText().toString());
                        } else {
                            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else if (this.rb_PT01e.getText().toString().equalsIgnoreCase(this.getString(R.string.yes))) {
                        if (this.rb_PT01f != null) {
                            this.insertPIF(this.et_motherName.getText().toString(), this.rb_PT01c.getText().toString(), this.rb_PT01e.getText().toString(), this.rb_PT01f.getText().toString(),
                                    this.et_fatherName.getText().toString(), this.rb_PT02c.getText().toString(), this.rb_PT02e.getText().toString(), "NA");
                        } else {
                            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else if (this.rb_PT02e.getText().toString().equalsIgnoreCase(this.getString(R.string.yes))) {
                        if (this.rb_PT02f != null) {
                            this.insertPIF(this.et_motherName.getText().toString(), this.rb_PT01c.getText().toString(), this.rb_PT01e.getText().toString(), "NA",
                                    this.et_fatherName.getText().toString(), this.rb_PT02c.getText().toString(), this.rb_PT02e.getText().toString(), this.rb_PT02f.getText().toString());
                        } else {
                            Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        this.insertPIF(this.et_motherName.getText().toString(), this.rb_PT01c.getText().toString(), this.rb_PT01e.getText().toString(), "NA",
                                this.et_fatherName.getText().toString(), this.rb_PT02c.getText().toString(), this.rb_PT02e.getText().toString(), "NA");
                    }
                }
            }
        }
    }

    private void insertPIF(final String mothersName, final String str_PT01c, final String str_PT01e, final String str_PT01f,
                           final String fathersName, final String str_PT02c, final String str_PT02e, final String str_PT02f) {

        final Modal_PIF modalPif = new Modal_PIF();
        modalPif.setPT01a(mothersName);
        modalPif.setPT01b(this.mothersAge);
        modalPif.setPT01c(str_PT01c);
        modalPif.setPT01d(mothersSchooling);
        modalPif.setPT01e(str_PT01e);
        modalPif.setPT01f(str_PT01f);
        modalPif.setPT02a(fathersName);
        modalPif.setPT02b(this.fathersAge);
        modalPif.setPT02c(str_PT02c);
        modalPif.setPT02d(fathersSchooling);
        modalPif.setPT02e(str_PT02e);
        modalPif.setPT02f(str_PT02f);
        modalPif.setStudentId(this.studentId);
        modalPif.setHouseholdId(this.householdId);
        modalPif.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modalPif.setSentFlag(0);

        parentInformationDao.insertParentInfo(modalPif);
        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "ParentInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        this.getFragmentManager().popBackStack();
    }

    private void updatePIF(final String str_PT01c, final String str_PT01e, final String str_PT01f,
                           final String str_PT02c, final String str_PT02e, final String str_PT02f) {
        parentInformationDao.updateParent(
                this.et_motherName.getText().toString(),
                this.mothersAge,
                str_PT01c,
                mothersSchooling,
                str_PT01e,
                str_PT01f,
                this.et_fatherName.getText().toString(),
                this.fathersAge,
                str_PT02c,
                fathersSchooling,
                str_PT02e,
                str_PT02f,
                this.studentId);

        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "ParentInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        this.getFragmentManager().popBackStack();
    }

    public void getRadioButtonValues() {
        final int selectedPT01c = this.rg_motherAttendSchool.getCheckedRadioButtonId();
        final int selectedPT01d = this.rg_mothersScooling.getCheckedRadioButtonId();
        final int selectedPT01e = this.rg_motherIncome.getCheckedRadioButtonId();
        final int selectedPT01f = this.rg_motherWork.getCheckedRadioButtonId();
        final int selectedPT02c = this.rg_fatherAttendSchool.getCheckedRadioButtonId();
        final int selectedPT02d = this.rg_fathersSchooling.getCheckedRadioButtonId();
        final int selectedPT02e = this.rg_fatherIncome.getCheckedRadioButtonId();
        final int selectedPT02f = this.rg_fatherWork.getCheckedRadioButtonId();

        this.rb_PT01c = this.getView().findViewById(selectedPT01c);
        this.rb_PT01d = this.getView().findViewById(selectedPT01d);
        this.rb_PT01e = this.getView().findViewById(selectedPT01e);
        this.rb_PT01f = this.getView().findViewById(selectedPT01f);
        this.rb_PT02c = this.getView().findViewById(selectedPT02c);
        this.rb_PT02d = this.getView().findViewById(selectedPT02d);
        this.rb_PT02e = this.getView().findViewById(selectedPT02e);
        this.rb_PT02f = this.getView().findViewById(selectedPT02f);
    }

    private void getSpinnerValues() {
        if (this.spinner_mothersAge.getSelectedItemPosition() == 0) this.mothersAge = "NA";
        else this.mothersAge = this.spinner_mothersAge.getSelectedItem().toString();

        if (this.spinner_fathersAge.getSelectedItemPosition() == 0) this.fathersAge = "NA";
        else this.fathersAge = this.spinner_fathersAge.getSelectedItem().toString();
    }

//todo check pif
}