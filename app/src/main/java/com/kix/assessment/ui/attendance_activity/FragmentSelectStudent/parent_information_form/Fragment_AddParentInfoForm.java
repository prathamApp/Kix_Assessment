package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form;

import androidx.fragment.app.Fragment;

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

import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_PIF;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

import static com.kix.assessment.KIXApplication.parentInformationDao;
import static com.kix.assessment.kix_utils.Kix_Constant.EDIT_PARENT;
import static com.kix.assessment.kix_utils.Kix_Constant.HOUSEHOLD_ID;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

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
    @ViewById(R.id.spinner_mothersGrade)
    Spinner spinner_mothersGrade;
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
    @ViewById(R.id.spinner_fathersGrade)
    Spinner spinner_fathersGrade;
    @ViewById(R.id.rg_PT02e)
    RadioGroup rg_fatherIncome;
    @ViewById(R.id.rg_PT02f)
    RadioGroup rg_fatherWork;

    @ViewById(R.id.rl_PT01f)
    RelativeLayout rl_motherWork;
    @ViewById(R.id.rl_PT02f)
    RelativeLayout rl_fatherWork;

    @ViewById(R.id.ll_PT01d)
    LinearLayout ll_spinnerMothersGrade;
    @ViewById(R.id.ll_PT02d)
    LinearLayout ll_spinnerFathersGrade;

    @ViewById(R.id.rg_eslectPerson)
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

    RadioButton rb_PT01c, rb_PT01e, rb_PT01f, rb_PT02c, rb_PT02e, rb_PT02f, rb_selectPerson;
    String str_selectedPerson;// str_PT01c, str_PT01e, str_PT01f, str_PT02c, str_PT02e, str_PT02f;

    //public String mothersName, fathersName;
    public String mothersAge, mothersGrade, fathersAge, fathersGrade;
    public String studentId, householdId;

    public Fragment_AddParentInfoForm() {
        // Required empty public constructor
    }

    @AfterViews
    public void init() {

        studentId = getArguments().getString(STUDENT_ID);
        householdId = getArguments().getString(HOUSEHOLD_ID);

        ageAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.parentAge, R.layout.support_simple_spinner_dropdown_item);
        spinner_mothersAge.setAdapter(ageAdapter);
        spinner_fathersAge.setAdapter(ageAdapter);
        gradeAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.parentGrade, R.layout.support_simple_spinner_dropdown_item);
        spinner_mothersGrade.setAdapter(gradeAdapter);
        spinner_fathersGrade.setAdapter(gradeAdapter);

        if (getArguments().getString(Kix_Constant.EDIT_PARENT) != null) {
            ll_selectPerson.setVisibility(View.GONE);
            sv_pif.setVisibility(View.VISIBLE);
            ll_motherInfo.setVisibility(View.VISIBLE);
            ll_fatherInfo.setVisibility(View.VISIBLE);
            btn_saveParent.setText("EDIT");
            tv_label.setText("Edit Parent Information");
            btn_saveParent.setVisibility(View.VISIBLE);

            Modal_PIF modalPif = parentInformationDao.getPIFbyStudentId(studentId);
            fetchParentDetails(modalPif);
        }

        rg_motherAttendSchool.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT01c_yes) ll_spinnerMothersGrade.setVisibility(View.VISIBLE);
            else {
                ll_spinnerMothersGrade.setVisibility(View.GONE);
                spinner_mothersGrade.setSelection(0);
            }
        });

        rg_fatherAttendSchool.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT02c_yes) ll_spinnerFathersGrade.setVisibility(View.VISIBLE);
            else {
                ll_spinnerFathersGrade.setVisibility(View.GONE);
                spinner_fathersGrade.setSelection(0);
            }
        });

        rg_motherIncome.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT01e_yes) rl_motherWork.setVisibility(View.VISIBLE);
            else {
                rl_motherWork.setVisibility(View.GONE);
                rg_motherWork.clearCheck();
            }
        });

        rg_fatherIncome.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT02e_yes) rl_fatherWork.setVisibility(View.VISIBLE);
            else {
                rl_fatherWork.setVisibility(View.GONE);
                rg_fatherWork.clearCheck();
            }
        });

    }

    private void fetchParentDetails(Modal_PIF modalPif) {
        et_motherName.setText(modalPif.PT01a);
        spinner_mothersAge.setSelection(ageAdapter.getPosition(modalPif.PT01b));
        if (modalPif.PT01c.equalsIgnoreCase(getString(R.string.yes))) {
            rg_motherAttendSchool.check(R.id.rb_PT01c_yes);
            ll_spinnerMothersGrade.setVisibility(View.VISIBLE);
            spinner_mothersGrade.setSelection(gradeAdapter.getPosition(modalPif.PT01d));
        } else rg_motherAttendSchool.check(R.id.rb_PT01c_No);
        if (modalPif.PT01e.equalsIgnoreCase(getString(R.string.yes))) {
            rg_motherIncome.check(R.id.rb_PT01e_yes);
            rl_motherWork.setVisibility(View.VISIBLE);
            if (modalPif.PT01f.equalsIgnoreCase(getString(R.string.str_PT01f_one)))
                rg_motherWork.check(R.id.rb_PT01f_one);
            else if (modalPif.PT01f.equalsIgnoreCase(getString(R.string.str_PT01f_two)))
                rg_motherWork.check(R.id.rb_PT01f_two);
            else if (modalPif.PT01f.equalsIgnoreCase(getString(R.string.str_PT01f_three)))
                rg_motherWork.check(R.id.rb_PT01f_three);
            else if (modalPif.PT01f.equalsIgnoreCase(getString(R.string.str_PT01f_four)))
                rg_motherWork.check(R.id.rb_PT01f_four);
        } else rg_motherIncome.check(R.id.rb_PT01e_No);

        et_fatherName.setText(modalPif.PT02a);
        spinner_fathersAge.setSelection(ageAdapter.getPosition(modalPif.PT02b));
        if (modalPif.PT02c.equalsIgnoreCase(getString(R.string.yes))) {
            rg_fatherAttendSchool.check(R.id.rb_PT02c_yes);
            ll_spinnerFathersGrade.setVisibility(View.VISIBLE);
            spinner_fathersGrade.setSelection(gradeAdapter.getPosition(modalPif.PT02d));
        } else rg_fatherAttendSchool.check(R.id.rb_PT02c_No);
        if (modalPif.PT02e.equalsIgnoreCase(getString(R.string.yes))) {
            rg_fatherIncome.check(R.id.rb_PT02e_yes);
            rl_fatherWork.setVisibility(View.VISIBLE);
            if (modalPif.PT02f.equalsIgnoreCase(getString(R.string.str_PT01f_one)))
                rg_fatherWork.check(R.id.rb_PT02f_one);
            else if (modalPif.PT02f.equalsIgnoreCase(getString(R.string.str_PT01f_two)))
                rg_fatherWork.check(R.id.rb_PT02f_two);
            else if (modalPif.PT02f.equalsIgnoreCase(getString(R.string.str_PT01f_three)))
                rg_fatherWork.check(R.id.rb_PT02f_three);
            else if (modalPif.PT02f.equalsIgnoreCase(getString(R.string.str_PT01f_four)))
                rg_fatherWork.check(R.id.rb_PT02f_four);
        } else rg_fatherIncome.check(R.id.rb_PT02e_No);
    }

    @Click(R.id.btn_enterDetails)
    public void enterDetails() {
        int selectedPerson = rg_selectPerson.getCheckedRadioButtonId();
        rb_selectPerson = getView().findViewById(selectedPerson);
        str_selectedPerson = rb_selectPerson.getText().toString();

        if (rb_selectPerson != null) {
            sv_pif.setVisibility(View.VISIBLE);
            btn_saveParent.setVisibility(View.VISIBLE);
            if (str_selectedPerson.equalsIgnoreCase(getString(R.string.str_mother))) {
                ll_motherInfo.setVisibility(View.VISIBLE);
                ll_selectPerson.setVisibility(View.GONE);
            } else if (str_selectedPerson.equalsIgnoreCase(getString(R.string.str_father))) {
                ll_fatherInfo.setVisibility(View.VISIBLE);
                ll_selectPerson.setVisibility(View.GONE);
            } else if (str_selectedPerson.equalsIgnoreCase(getString(R.string.str_both))) {
                ll_motherInfo.setVisibility(View.VISIBLE);
                ll_fatherInfo.setVisibility(View.VISIBLE);
                ll_selectPerson.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(getActivity(), "Select Parent First.", Toast.LENGTH_SHORT).show();
        }
    }

    @Click(R.id.btn_saveParent)
    public void saveParent() {
        getRadioButtonValues();
        getSpinnerValues();

        if (getArguments().getString(EDIT_PARENT) != null) {
            if (rb_PT01c == null || rb_PT01e == null || rb_PT02c == null || rb_PT02e == null ||
                    et_motherName.getText().toString().isEmpty() || et_fatherName.getText().toString().isEmpty()) {
                Toast.makeText(getActivity(), "All Fields are mandatory.", Toast.LENGTH_SHORT).show();
            } else {
                String str_PT01f, str_PT02f;
                if(rb_PT01f == null) str_PT01f="NA";
                else str_PT01f = rb_PT01f.getText().toString();
                if(rb_PT02f == null) str_PT02f="NA";
                else str_PT02f = rb_PT02f.getText().toString();

                updatePIF(rb_PT01c.getText().toString(), rb_PT01e.getText().toString(), str_PT01f,
                        rb_PT02c.getText().toString(), rb_PT02e.getText().toString(), str_PT02f);
            }
        } else {
            if (str_selectedPerson.equalsIgnoreCase(getString(R.string.str_mother))) {
                if (rb_PT01c == null || rb_PT01e == null || et_motherName.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                } else {
                    if (rb_PT01e.getText().toString().equalsIgnoreCase(getString(R.string.yes))) {
                        if (rb_PT01f != null) {
                            insertPIF(et_motherName.getText().toString(), rb_PT01c.getText().toString(), rb_PT01e.getText().toString(), rb_PT01f.getText().toString(),
                                    "NA", "NA", "NA", "NA");
                        } else {
                            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        insertPIF(et_motherName.getText().toString(), rb_PT01c.getText().toString(), rb_PT01e.getText().toString(), "NA",
                                "NA", "NA", "NA", "NA");
                    }
                }

                //todo Add new field in PIF db selectedPerson
            } else if (str_selectedPerson.equalsIgnoreCase(getString(R.string.str_father))) {
                if (rb_PT02c == null || rb_PT02e == null || et_fatherName.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                } else {
                    if (rb_PT02e.getText().toString().equalsIgnoreCase(getString(R.string.yes))) {
                        if (rb_PT02f != null) {
                            insertPIF("NA", "NA", "NA", "NA",
                                    et_fatherName.getText().toString(), rb_PT02c.getText().toString(), rb_PT02e.getText().toString(), rb_PT02f.getText().toString());
                        } else {
                            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        insertPIF("NA", "NA", "NA", "NA",
                                et_fatherName.getText().toString(), rb_PT02c.getText().toString(), rb_PT02e.getText().toString(), "NA");
                    }
                }
            } else if (str_selectedPerson.equalsIgnoreCase(getString(R.string.str_both))) {
                if (rb_PT01c == null || rb_PT01e == null || rb_PT02c == null || rb_PT02e == null ||
                        et_motherName.getText().toString().isEmpty() || et_fatherName.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                } else {
                    if (rb_PT01e.getText().toString().equalsIgnoreCase(getString(R.string.yes)) && rb_PT02e.getText().toString().equalsIgnoreCase(getString(R.string.yes))) {
                        if (rb_PT01f != null && rb_PT02f != null) {
                            insertPIF(et_motherName.getText().toString(), rb_PT01c.getText().toString(), rb_PT01e.getText().toString(), rb_PT01f.getText().toString(),
                                    et_fatherName.getText().toString(), rb_PT02c.getText().toString(), rb_PT02e.getText().toString(), rb_PT02f.getText().toString());
                        } else {
                            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else if (rb_PT01e.getText().toString().equalsIgnoreCase(getString(R.string.yes))) {
                        if (rb_PT01f != null) {
                            insertPIF(et_motherName.getText().toString(), rb_PT01c.getText().toString(), rb_PT01e.getText().toString(), rb_PT01f.getText().toString(),
                                    et_fatherName.getText().toString(), rb_PT02c.getText().toString(), rb_PT02e.getText().toString(), "NA");
                        } else {
                            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else if (rb_PT02e.getText().toString().equalsIgnoreCase(getString(R.string.yes))) {
                        if (rb_PT02f != null) {
                            insertPIF(et_motherName.getText().toString(), rb_PT01c.getText().toString(), rb_PT01e.getText().toString(), "NA",
                                    et_fatherName.getText().toString(), rb_PT02c.getText().toString(), rb_PT02e.getText().toString(), rb_PT02f.getText().toString());
                        } else {
                            Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        insertPIF(et_motherName.getText().toString(), rb_PT01c.getText().toString(), rb_PT01e.getText().toString(), "NA",
                                et_fatherName.getText().toString(), rb_PT02c.getText().toString(), rb_PT02e.getText().toString(), "NA");
                    }
                }
            }
        }
    }

    private void insertPIF(String mothersName, String str_PT01c, String str_PT01e, String str_PT01f,
                           String fathersName, String str_PT02c, String str_PT02e, String str_PT02f) {

        Modal_PIF modalPif = new Modal_PIF();
        modalPif.setPT01a(mothersName);
        modalPif.setPT01b(mothersAge);
        modalPif.setPT01c(str_PT01c);
        modalPif.setPT01d(mothersGrade);
        modalPif.setPT01e(str_PT01e);
        modalPif.setPT01f(str_PT01f);
        modalPif.setPT02a(fathersName);
        modalPif.setPT02b(fathersAge);
        modalPif.setPT02c(str_PT02c);
        modalPif.setPT02d(fathersGrade);
        modalPif.setPT02e(str_PT02e);
        modalPif.setPT02f(str_PT02f);
        modalPif.setStudentId(studentId);
        modalPif.setHouseholdId(householdId);
        modalPif.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modalPif.setSentFlag(0);

        parentInformationDao.insertParentInfo(modalPif);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "ParentInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    private void updatePIF(String str_PT01c, String str_PT01e, String str_PT01f,
                           String str_PT02c, String str_PT02e, String str_PT02f) {
        parentInformationDao.updateParent(
                et_motherName.getText().toString(),
                mothersAge,
                str_PT01c,
                mothersGrade,
                str_PT01e,
                str_PT01f,
                et_fatherName.getText().toString(),
                fathersAge,
                str_PT02c,
                fathersGrade,
                str_PT02e,
                str_PT02f,
                studentId);

        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "ParentInformation Added Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    public void getRadioButtonValues() {
        int selectedPT01c = rg_motherAttendSchool.getCheckedRadioButtonId();
        int selectedPT01e = rg_motherIncome.getCheckedRadioButtonId();
        int selectedPT01f = rg_motherWork.getCheckedRadioButtonId();
        int selectedPT02c = rg_fatherAttendSchool.getCheckedRadioButtonId();
        int selectedPT02e = rg_fatherIncome.getCheckedRadioButtonId();
        int selectedPT02f = rg_fatherWork.getCheckedRadioButtonId();

        rb_PT01c = getView().findViewById(selectedPT01c);
        rb_PT01e = getView().findViewById(selectedPT01e);
        rb_PT01f = getView().findViewById(selectedPT01f);
        rb_PT02c = getView().findViewById(selectedPT02c);
        rb_PT02e = getView().findViewById(selectedPT02e);
        rb_PT02f = getView().findViewById(selectedPT02f);
    }

    private void getSpinnerValues() {
        if (spinner_mothersAge.getSelectedItemPosition() == 0) mothersAge = "NA";
        else mothersAge = spinner_mothersAge.getSelectedItem().toString();

        if (spinner_mothersGrade.getSelectedItemPosition() == 0) mothersGrade = "NA";
        else mothersGrade = spinner_mothersGrade.getSelectedItem().toString();

        if (spinner_fathersAge.getSelectedItemPosition() == 0) fathersAge = "NA";
        else fathersAge = spinner_fathersAge.getSelectedItem().toString();

        if (spinner_fathersGrade.getSelectedItemPosition() == 0) fathersGrade = "NA";
        else fathersGrade = spinner_fathersGrade.getSelectedItem().toString();
    }


}