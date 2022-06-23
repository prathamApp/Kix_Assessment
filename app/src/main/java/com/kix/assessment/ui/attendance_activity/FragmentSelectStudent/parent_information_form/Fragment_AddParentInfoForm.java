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

    RadioButton rb_selectPerson;
    String age, str_selectedPerson;// str_PT01c, str_PT01e, str_PT01f, str_PT02c, str_PT02e, str_PT02f;

    //public String mothersName, fathersName;
    public String mothersAge, mothersSchooling, fathersAge, fathersSchooling;
    public String studentId, householdId;

    int selectedPT00, selectedPT01c, selectedPT01d, selectedPT01e, selectedPT01f, selectedPT02c, selectedPT02d, selectedPT02e, selectedPT02f;

    public Fragment_AddParentInfoForm() {
        // Required empty public constructor
    }

    @AfterViews
    public void init() {

        studentId = getArguments().getString(STUDENT_ID);
        householdId = getArguments().getString(HOUSEHOLD_ID);

        ageAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.parentAge, R.layout.spinner_item);
        spinner_mothersAge.setAdapter(ageAdapter);
        spinner_fathersAge.setAdapter(ageAdapter);

        this.selectedPT00 = this.selectedPT01c = this.selectedPT01d = this.selectedPT01e = this.selectedPT01f = this.selectedPT02c = this.selectedPT02d = this.selectedPT02e = this.selectedPT02f = 99;

        if (getArguments().getString(EDIT_PARENT) != null) {
            tv_label.setText(this.getString(R.string.update_parent_information));
            btn_saveParent.setVisibility(View.VISIBLE);

            Modal_PIF modalPif = parentInformationDao.getPIFbyStudentId(studentId);
            switch (modalPif.PT00) {
                case 1:
                    ll_motherInfo.setVisibility(View.VISIBLE);
                    ll_fatherInfo.setVisibility(View.GONE);
                    break;
                case 2:
                    ll_motherInfo.setVisibility(View.GONE);
                    ll_fatherInfo.setVisibility(View.VISIBLE);
                    break;

                case 3:
                    ll_motherInfo.setVisibility(View.VISIBLE);
                    ll_fatherInfo.setVisibility(View.VISIBLE);
                    break;

                case 4:
                    ll_motherInfo.setVisibility(View.GONE);
                    ll_fatherInfo.setVisibility(View.GONE);
                    break;

            }
            fetchParentDetails(modalPif);
        }

        rg_selectPerson.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_mother:
                    ll_motherInfo.setVisibility(View.VISIBLE);
                    ll_fatherInfo.setVisibility(View.GONE);
                    et_fatherName.setText("");
                    spinner_fathersAge.setSelection(0);
//                    rg_fatherAttendSchool.check(R.id.rb_PT02c_No);
//                    rg_fatherIncome.check(R.id.rb_PT02e_No);
                    rg_fatherAttendSchool.clearCheck();
                    rg_fatherIncome.clearCheck();
                    break;

                case R.id.rb_father:
                    ll_motherInfo.setVisibility(View.GONE);
                    ll_fatherInfo.setVisibility(View.VISIBLE);
                    et_motherName.setText("");
                    spinner_mothersAge.setSelection(0);
//                    rg_motherAttendSchool.check(R.id.rb_PT02c_No);
//                    rg_motherIncome.check(R.id.rb_PT02e_No);
                    rg_motherAttendSchool.clearCheck();
                    rg_motherIncome.clearCheck();
                    break;

                case R.id.rb_both:
                    ll_motherInfo.setVisibility(View.VISIBLE);
                    ll_fatherInfo.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_neither:
                    ll_motherInfo.setVisibility(View.GONE);
                    ll_fatherInfo.setVisibility(View.GONE);
                    et_fatherName.setText("NA");
                    spinner_fathersAge.setSelection(0);
                    rg_fatherAttendSchool.clearCheck();
                    rg_fatherIncome.clearCheck();
                    et_motherName.setText("NA");
                    spinner_mothersAge.setSelection(0);
                    rg_motherAttendSchool.clearCheck();
                    rg_motherIncome.clearCheck();
                    break;
            }
        });


        rg_motherAttendSchool.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT01c_yes) rl_motherSchooling.setVisibility(View.VISIBLE);
            else {
                rl_motherSchooling.setVisibility(View.GONE);
                this.rg_mothersScooling.clearCheck();
            }
        });

        rg_fatherAttendSchool.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_PT02c_yes) rl_fatherSchooling.setVisibility(View.VISIBLE);
            else {
                rl_fatherSchooling.setVisibility(View.GONE);
                this.rg_fathersSchooling.clearCheck();
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
        switch (modalPif.PT00) {
            case 1:
                rg_selectPerson.check(R.id.rb_mother);
                break;
            case 2:
                rg_selectPerson.check(R.id.rb_father);
                break;
            case 3:
                rg_selectPerson.check(R.id.rb_both);
                break;
            case 4:
                rg_selectPerson.check(R.id.rb_neither);
                break;
        }

        et_motherName.setText(modalPif.PT01a);
        try {
            if (modalPif.PT01b.equalsIgnoreCase("NA"))
                spinner_mothersAge.setSelection(0);
            else
                spinner_mothersAge.setSelection(Integer.parseInt(modalPif.PT01b)-17);
        } catch (NumberFormatException e) {
            spinner_mothersAge.setSelection(0);
            e.printStackTrace();
        }

        if (modalPif.PT01c.equalsIgnoreCase("1")) {
            rg_motherAttendSchool.check(R.id.rb_PT01c_yes);
            rl_motherSchooling.setVisibility(View.VISIBLE);
            if (modalPif.PT01d.equalsIgnoreCase("1"))
                this.rg_mothersScooling.check(R.id.rb_PT01d_one);
            else if (modalPif.PT01d.equalsIgnoreCase("2"))
                this.rg_mothersScooling.check(R.id.rb_PT01d_two);
            else if (modalPif.PT01d.equalsIgnoreCase("3"))
                this.rg_mothersScooling.check(R.id.rb_PT01d_three);
            else if (modalPif.PT01d.equalsIgnoreCase("4"))
                this.rg_mothersScooling.check(R.id.rb_PT01d_four);
        } else rg_motherAttendSchool.check(R.id.rb_PT01c_No);
        if (modalPif.PT01e.equalsIgnoreCase("1")) {
            rg_motherIncome.check(R.id.rb_PT01e_yes);
            rl_motherWork.setVisibility(View.VISIBLE);
            if (modalPif.PT01f.equalsIgnoreCase("1"))
                rg_motherWork.check(R.id.rb_PT01f_one);
            else if (modalPif.PT01f.equalsIgnoreCase("2"))
                rg_motherWork.check(R.id.rb_PT01f_two);
            else if (modalPif.PT01f.equalsIgnoreCase("3"))
                rg_motherWork.check(R.id.rb_PT01f_three);
            else if (modalPif.PT01f.equalsIgnoreCase("4"))
                rg_motherWork.check(R.id.rb_PT01f_four);
        } else rg_motherIncome.check(R.id.rb_PT01e_No);

        et_fatherName.setText(modalPif.PT02a);
        try {
            if (modalPif.PT02b.equalsIgnoreCase("NA"))
                spinner_fathersAge.setSelection(0);
            else
                spinner_fathersAge.setSelection(Integer.parseInt(modalPif.PT02b)-17);
        } catch (NumberFormatException e) {
            spinner_fathersAge.setSelection(0);
            e.printStackTrace();
        }

        if (modalPif.PT02c.equalsIgnoreCase("1")) {
            rg_fatherAttendSchool.check(R.id.rb_PT02c_yes);
            rl_fatherSchooling.setVisibility(View.VISIBLE);
            if (modalPif.PT02d.equalsIgnoreCase("1"))
                this.rg_fathersSchooling.check(R.id.rb_PT02d_one);
            else if (modalPif.PT02d.equalsIgnoreCase("2"))
                this.rg_fathersSchooling.check(R.id.rb_PT02d_two);
            else if (modalPif.PT02d.equalsIgnoreCase("3"))
                this.rg_fathersSchooling.check(R.id.rb_PT02d_three);
            else if (modalPif.PT02d.equalsIgnoreCase("4"))
                this.rg_fathersSchooling.check(R.id.rb_PT02d_four);
        } else rg_fatherAttendSchool.check(R.id.rb_PT02c_No);
        if (modalPif.PT02e.equalsIgnoreCase("1")) {
            rg_fatherIncome.check(R.id.rb_PT02e_yes);
            rl_fatherWork.setVisibility(View.VISIBLE);
            if (modalPif.PT02f.equalsIgnoreCase("1"))
                rg_fatherWork.check(R.id.rb_PT02f_one);
            else if (modalPif.PT02f.equalsIgnoreCase("2"))
                rg_fatherWork.check(R.id.rb_PT02f_two);
            else if (modalPif.PT02f.equalsIgnoreCase("3"))
                rg_fatherWork.check(R.id.rb_PT02f_three);
            else if (modalPif.PT02f.equalsIgnoreCase("4"))
                rg_fatherWork.check(R.id.rb_PT02f_four);
        } else rg_fatherIncome.check(R.id.rb_PT02e_No);
    }

    @Click(R.id.btn_saveParent)
    public void saveParent() {
        getRadioButtonValues();
        getSpinnerValues();

        if (selectedPT00 != 99) {
            if (selectedPT00 == 1) {
                if (this.selectedPT01c == 99 || this.selectedPT01e == 99 || et_motherName.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                } else {
                    if (this.selectedPT01e == 1) {
                        if (this.selectedPT01f != 99) {
                            if (getArguments().getString(EDIT_PARENT) != null) {
                                updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                        "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                            } else {
                                insertPIF();
                            }
                        } else {
                            Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (getArguments().getString(EDIT_PARENT) != null) {
                            updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                    "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                        } else {
                            insertPIF();
                        }
                    }
                }

                //todo Add new field in PIF db selectedPerson
            } else if (selectedPT00 == 2) {
                if (this.selectedPT02c == 99 || this.selectedPT02e == 99 || et_fatherName.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                } else {
                    if (this.selectedPT02e == 1) {
                        if (this.selectedPT02f != 99) {
                            if (getArguments().getString(EDIT_PARENT) != null) {
                                updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                        "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                            } else {
                                insertPIF();
                            }
                        } else {
                            Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (getArguments().getString(EDIT_PARENT) != null) {
                            updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                    "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                        } else {
                            insertPIF();
                        }
                    }
                }
            } else if (selectedPT00 == 3) {
                if (this.selectedPT01c == 99 || this.selectedPT01e == 99 || this.selectedPT02c == 99 || this.selectedPT02e == 99 ||
                        et_motherName.getText().toString().isEmpty() || et_fatherName.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                } else {
                    if (this.selectedPT01e == 1 && this.selectedPT02e == 1) {
                        if (this.selectedPT01f != 99 && this.selectedPT02f != 99) {
                            if (getArguments().getString(EDIT_PARENT) != null) {
                                updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                        "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                            } else {
                                insertPIF();
                            }
                        } else {
                            Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                        }
                    } else if (this.selectedPT01e == 1) {
                        if (this.selectedPT01f != 99) {
                            if (getArguments().getString(EDIT_PARENT) != null) {
                                updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                        "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                            } else {
                                insertPIF();
                            }
                        } else {
                            Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                        }
                    } else if (this.selectedPT02e == 1) {
                        if (this.selectedPT02f != 99) {
                            if (getArguments().getString(EDIT_PARENT) != null) {
                                updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                        "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                            } else {
                                insertPIF();
                            }
                        } else {
                            Toast.makeText(getActivity(), getString(R.string.all_fileds_mandatory), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (getArguments().getString(EDIT_PARENT) != null) {
                            updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                                    "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                        } else {
                            insertPIF();
                        }
                    }
                }
            } else if (selectedPT00 == 4) {
                if (getArguments().getString(EDIT_PARENT) != null) {
                    updatePIF("" + this.selectedPT01c, "" + this.selectedPT01e, "" + this.selectedPT01f,
                            "" + this.selectedPT02c, "" + this.selectedPT02e, "" + this.selectedPT02f);
                } else {
                    insertPIF();
                }
            }
        } else {
            Toast.makeText(getActivity(), R.string.select_atleast_one, Toast.LENGTH_SHORT).show();
        }
    }

    private void insertPIF() {

        String motherName = "NA", fatherName = "NA";
        if (!this.et_motherName.getText().toString().isEmpty())
            motherName = this.et_motherName.getText().toString();
        if (!this.et_fatherName.getText().toString().isEmpty())
            fatherName = this.et_fatherName.getText().toString();

        Modal_PIF modalPif = new Modal_PIF();
        modalPif.setPT00(selectedPT00);
        modalPif.setPT01a(motherName);
        modalPif.setPT01b(mothersAge);
        modalPif.setPT01c("" + this.selectedPT01c);
        modalPif.setPT01d("" + this.selectedPT01d);
        modalPif.setPT01e("" + this.selectedPT01e);
        modalPif.setPT01f("" + this.selectedPT01f);
        modalPif.setPT02a(fatherName);
        modalPif.setPT02b(this.fathersAge);
        modalPif.setPT02c("" + this.selectedPT02c);
        modalPif.setPT02d("" + this.selectedPT02d);
        modalPif.setPT02e("" + this.selectedPT02e);
        modalPif.setPT02f("" + this.selectedPT02f);
        modalPif.setStudentId(studentId);
        modalPif.setHouseholdId(householdId);
        modalPif.setInfo_createdOn(KIX_Utility.getCurrentDateTime());
        modalPif.setSentFlag(0);

        parentInformationDao.insertParentInfo(modalPif);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), getString(R.string.pif_Added_success), Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    private void updatePIF(String str_PT01c, String str_PT01e, String str_PT01f,
                           String str_PT02c, String str_PT02e, String str_PT02f) {

        String motherName = "NA", fatherName = "NA";
        if (!this.et_motherName.getText().toString().isEmpty())
            motherName = this.et_motherName.getText().toString();
        if (!this.et_fatherName.getText().toString().isEmpty())
            fatherName = this.et_fatherName.getText().toString();

        parentInformationDao.updateParent(
                selectedPT00,
                motherName,
                mothersAge,
                str_PT01c,
                "" + this.selectedPT01d,
                str_PT01e,
                str_PT01f,
                fatherName,
                fathersAge,
                str_PT02c,
                "" + this.selectedPT02d,
                str_PT02e,
                str_PT02f,
                studentId);

        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), getString(R.string.pif_Updated_success), Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }

    public void getRadioButtonValues() {
        if (getView().findViewById(rg_selectPerson.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_mother))
            this.selectedPT00 = 1;
        else if (getView().findViewById(rg_selectPerson.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_father))
            this.selectedPT00 = 2;
        else if (getView().findViewById(rg_selectPerson.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_both))
            this.selectedPT00 = 3;
        else if (getView().findViewById(rg_selectPerson.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_neither))
            this.selectedPT00 = 4;

        if (getView().findViewById(rg_motherAttendSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01c_yes))
            this.selectedPT01c = 1;
        else if (getView().findViewById(rg_motherAttendSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01c_No))
            this.selectedPT01c = 0;
        if (getView().findViewById(rg_mothersScooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01d_one))
            this.selectedPT01d = 1;
        else if (getView().findViewById(rg_mothersScooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01d_two))
            this.selectedPT01d = 2;
        else if (getView().findViewById(rg_mothersScooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01d_three))
            this.selectedPT01d = 3;
        else if (getView().findViewById(rg_mothersScooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01d_four))
            this.selectedPT01d = 4;
        if (getView().findViewById(rg_motherIncome.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01e_yes))
            this.selectedPT01e = 1;
        else if (getView().findViewById(rg_motherIncome.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01e_No))
            this.selectedPT01e = 0;
        if (getView().findViewById(rg_motherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01f_one))
            this.selectedPT01f = 1;
        else if (getView().findViewById(rg_motherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01f_two))
            this.selectedPT01f = 2;
        else if (getView().findViewById(rg_motherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01f_three))
            this.selectedPT01f = 3;
        else if (getView().findViewById(rg_motherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT01f_four))
            this.selectedPT01f = 4;

        if (getView().findViewById(rg_fatherAttendSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02c_yes))
            this.selectedPT02c = 1;
        else if (getView().findViewById(rg_fatherAttendSchool.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02c_No))
            this.selectedPT02c = 0;
        if (getView().findViewById(rg_fathersSchooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02d_one))
            this.selectedPT02d = 1;
        else if (getView().findViewById(rg_fathersSchooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02d_two))
            this.selectedPT02d = 2;
        else if (getView().findViewById(rg_fathersSchooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02d_three))
            this.selectedPT02d = 3;
        else if (getView().findViewById(rg_fathersSchooling.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02d_four))
            this.selectedPT02d = 4;
        if (getView().findViewById(rg_fatherIncome.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02e_yes))
            this.selectedPT02e = 1;
        else if (getView().findViewById(rg_fatherIncome.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02e_No))
            this.selectedPT02e = 0;
        if (getView().findViewById(rg_fatherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02f_one))
            this.selectedPT02f = 1;
        else if (getView().findViewById(rg_fatherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02f_two))
            this.selectedPT02f = 2;
        else if (getView().findViewById(rg_fatherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02f_three))
            this.selectedPT02f = 3;
        else if (getView().findViewById(rg_fatherWork.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_PT02f_four))
            this.selectedPT02f = 4;

    }

    private void getSpinnerValues() {
        int ageNo = spinner_mothersAge.getSelectedItemPosition()+17;
        if (ageNo == 17)
            mothersAge = "NA";
        else mothersAge = ""+ageNo;

        ageNo = spinner_fathersAge.getSelectedItemPosition()+17;
        if (ageNo == 17)
            fathersAge = "NA";
        else fathersAge = ""+ageNo;

/*        if (spinner_mothersAge.getSelectedItemPosition() == 0) mothersAge = "NA";
        else mothersAge = this.getSelectedAge(spinner_mothersAge.getSelectedItem().toString());

        if (spinner_fathersAge.getSelectedItemPosition() == 0) fathersAge = "NA";
        else fathersAge = this.getSelectedAge(spinner_fathersAge.getSelectedItem().toString());*/
    }
/*    private String getSelectedAge(final String age1) {
        final String[] split_age = age1.split(" ");
        if (split_age.length > 1)
            this.age = String.valueOf(Integer.parseInt(split_age[0]));
            //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, Integer.parseInt(split_age[1]));
        else
            this.age = "0";
        //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, 0);
        return this.age;
    }*/
}