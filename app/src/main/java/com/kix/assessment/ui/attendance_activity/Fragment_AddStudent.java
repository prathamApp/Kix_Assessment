package com.kix.assessment.ui.attendance_activity;

import static com.kix.assessment.KIXApplication.attendanceDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.KIXApplication.studentDao;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Attendance;
import com.kix.assessment.modal_classes.Modal_Session;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.main_test.WebViewActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Objects;

@SuppressLint("NonConstantResourceId")
@EFragment(R.layout.fragment_add_student)
public class Fragment_AddStudent extends Fragment {

    @ViewById(R.id.et_CH01)
    EditText et_studentName;
    @ViewById(R.id.spn_CH02)
    Spinner spinner_age;
    @ViewById(R.id.spn_CH03)
    Spinner spinner_gender;
    @ViewById(R.id.rg_CH04a)
    RadioGroup rg_anyDisability;
    @ViewById(R.id.rg_CH04b)
    RadioGroup rg_whichDisability;
    @ViewById(R.id.rg_CH05)
    RadioGroup rg_isStudentEnrolled;
    @ViewById(R.id.spn_CH06a)
    Spinner spinner_class;
    @ViewById(R.id.spn_CH06b)
    Spinner spinner_schoolType;
    @ViewById(R.id.rg_CH06c)
    RadioGroup rg_instructionLang;
    @ViewById(R.id.rg_CH06d)
    RadioGroup rg_schoolStatus;
    @ViewById(R.id.rg_CH06e)
    RadioGroup rg_schoolActivities;
    @ViewById(R.id.rg_CH06f)
    RadioGroup rg_haveTextbooks;
    @ViewById(R.id.rg_CH06g)
    RadioGroup rg_gradeRepeat;
    @ViewById(R.id.rg_CH07a)
    RadioGroup rg_isStudentEverEnrolled;
    @ViewById(R.id.spn_CH07b)
    Spinner spinner_dropoutYear;
    @ViewById(R.id.spn_CH07c)
    Spinner spinner_dropout_class;
    @ViewById(R.id.rg_CH07d)
    RadioGroup rg_dropOutReason;
    @ViewById(R.id.rg_CH08)
    RadioGroup rg_paidTution;
    @ViewById(R.id.rg_CH09)
    RadioGroup rg_readMaterial;
    @ViewById(R.id.rg_CH10a)
    RadioGroup rg_helpChild;
    @ViewById(R.id.rg_CH10b)
    RadioGroup rg_mostOften;
    @ViewById(R.id.rg_CH10c)
    RadioGroup rg_oftenReads;

    @ViewById(R.id.ll_spinnerDropout)
    LinearLayout ll_spinnerDropout;
    @ViewById(R.id.ll_schoolType)
    LinearLayout ll_schoolType;

    @ViewById(R.id.tv_label)
    TextView tv_label;

    @ViewById(R.id.rl_CH04b)
    RelativeLayout rl_CH04b;
    @ViewById(R.id.ll_enrolledChildFields)
    LinearLayout ll_enrolledChildFields;
    @ViewById(R.id.ll_notEnrolledChildFields)
    LinearLayout ll_notEnrolledChildFields;
    @ViewById(R.id.ll_sub_CH07b)
    LinearLayout ll_dropoutFields;
    @ViewById(R.id.rl_CH06e)
    RelativeLayout rl_kindOfActivities;
    @ViewById(R.id.rl_CH10a)
    RelativeLayout rl_CH10a;
    @ViewById(R.id.rl_CH10b)
    RelativeLayout rl_CH10b;

    @ViewById(R.id.btn_saveStudent)
    Button btn_saveStudent;

    String age, surveyorCode, householdID;
    String schoolType, dropoutYear, standard, dropoutStandard;

    public Dialog startExamDialog;
    Button dlg_yes, dlg_no;

    ArrayAdapter adapterAge, adapterGender, adapterEnrollStatus,
            adapterClass, adapterSchoolType, adapterDropYear;

    Modal_Student modalStudent;

    String studId;

    RadioButton rb_CH04a, rb_CH04b, rb_CH05, rb_CH06c, rb_CH06d, rb_CH06e, rb_CH06f, rb_CH06g, rb_CH07a, rb_CH07d, rb_CH08,
            rb_CH09, rb_CH10a, rb_CH10b, rb_CH10c ;

    String str_CH06a, str_CH06b, str_CH06c, str_CH06d, str_CH06e, str_CH06f, str_CH06g;
    String str_CH07a, str_CH07b, str_CH07c, str_CH07d;
    String str_CH10a, str_CH10b;
    String str_CH04b;

    public boolean isStudCurrentlyEnrolled;

    public Fragment_AddStudent() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @AfterViews
    public void initialize() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));

        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        householdID = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        adapterAge = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.age, R.layout.spinner_item);
        spinner_age.setAdapter(adapterAge);
        adapterGender = ArrayAdapter.createFromResource(getActivity(), R.array.gender, R.layout.spinner_item);
        spinner_gender.setAdapter(adapterGender);
        adapterSchoolType = ArrayAdapter.createFromResource(getActivity(), R.array.school_type, R.layout.spinner_item);
        spinner_schoolType.setAdapter(adapterSchoolType);
        adapterDropYear = ArrayAdapter.createFromResource(getActivity(), R.array.dropout_year_list, R.layout.spinner_item);
        spinner_dropoutYear.setAdapter(adapterDropYear);
        adapterClass = ArrayAdapter.createFromResource(getActivity(), R.array.student_class, R.layout.spinner_item);
        spinner_class.setAdapter(adapterClass);
        spinner_dropout_class.setAdapter(adapterClass);

        if (getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
            studId = getArguments().getString(STUDENT_ID);
            modalStudent = studentDao.getStudentByStudId(studId);
            fetchChildDetails(modalStudent);
        }

        rg_isStudentEnrolled.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.rb_CH05_yes:
                    ll_enrolledChildFields.setVisibility(View.VISIBLE);
                    ll_notEnrolledChildFields.setVisibility(View.GONE);
                    rl_CH10a.setVisibility(View.VISIBLE);
                    rl_CH10b.setVisibility(View.VISIBLE);
                    btn_saveStudent.setVisibility(View.VISIBLE);
                    isStudCurrentlyEnrolled = true;
                    break;

                case R.id.rb_CH05_No:
                    ll_enrolledChildFields.setVisibility(View.GONE);
                    ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
                    rl_CH10a.setVisibility(View.GONE);
                    rl_CH10b.setVisibility(View.GONE);
                    btn_saveStudent.setVisibility(View.VISIBLE);
                    isStudCurrentlyEnrolled = false;
                    break;
            }
        });

        rg_isStudentEverEnrolled.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.rb_CH07a_yes:
                    ll_dropoutFields.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_CH07a_No:
                    ll_dropoutFields.setVisibility(View.GONE);
                    break;
            }
        });

        rg_schoolStatus.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_CH06d_one) rl_kindOfActivities.setVisibility(View.VISIBLE);
            else {
                rl_kindOfActivities.setVisibility(View.GONE);
                rg_schoolActivities.clearCheck();//todo test
            }
        });

        rg_anyDisability.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==R.id.rb_CH04a_yes) rl_CH04b.setVisibility(View.VISIBLE);
            else {
                rl_CH04b.setVisibility(View.GONE);
                rg_whichDisability.clearCheck();
            }
        });

/*        spinner_enrollStatue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals(getResources().getString(R.string.enrolled)))
                {
                    adapterClass = ArrayAdapter.createFromResource(getActivity(), R.array.student_class, R.layout.support_simple_spinner_dropdown_item);
                    spinner_class.setAdapter(adapterClass);
                    if(getArguments().getString(Kix_Constant.EDIT_STUDENT)!=null) {
                        spinner_class.setSelection(adapterClass.getPosition(modalStudent.getStudClass()));
                        spinner_dropoutYear.setSelection(0);
                    }
                    ll_spinnerByStatus.setVisibility(View.VISIBLE);
                    ll_spinnerDropout.setVisibility(View.GONE);
                    ll_schoolType.setVisibility(View.VISIBLE);
                }
                else if(selectedItem.equals(getResources().getString(R.string.never_enrolled)))
                {
                    ll_spinnerByStatus.setVisibility(View.GONE);
                }
                if(selectedItem.equals(getResources().getString(R.string.drop_out)))
                {
                    adapterClass = ArrayAdapter.createFromResource(getActivity(), R.array.student_dropoutclass, R.layout.support_simple_spinner_dropdown_item);
                    spinner_class.setAdapter(adapterClass);
                    if(getArguments().getString(Kix_Constant.EDIT_STUDENT)!=null) {
                        spinner_class.setSelection(adapterClass.getPosition(modalStudent.getStudClass()));
                        spinner_schoolType.setSelection(0);
                    }
                    ll_spinnerByStatus.setVisibility(View.VISIBLE);
                    ll_schoolType.setVisibility(View.GONE);
                    ll_spinnerDropout.setVisibility(View.VISIBLE);
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });*/
    }

    private void fetchChildDetails(Modal_Student modalStudent) {
        tv_label.setText(getResources().getString(R.string.edit_child_info));
        btn_saveStudent.setText("Update");
        btn_saveStudent.setVisibility(View.VISIBLE);
        et_studentName.setText(modalStudent.getCH01());

        spinner_age.setSelection(adapterAge.getPosition("Age " + modalStudent.getCH02()));
        spinner_gender.setSelection(adapterGender.getPosition(modalStudent.getCH03()));

        if(modalStudent.CH04a.equalsIgnoreCase(getString(R.string.yes))){
            rg_anyDisability.check(R.id.rb_CH04a_yes);
            rl_CH04b.setVisibility(View.VISIBLE);

            if(modalStudent.CH04b.equalsIgnoreCase(getString(R.string.str_CH04b_op1)))
                rg_whichDisability.check(R.id.rb_CH04b_op1);
            else if(modalStudent.CH04b.equalsIgnoreCase(getString(R.string.str_CH04b_op2)))
                rg_whichDisability.check(R.id.rb_CH04b_op2);
            else if(modalStudent.CH04b.equalsIgnoreCase(getString(R.string.str_CH04b_op3)))
                rg_whichDisability.check(R.id.rb_CH04b_op3);
            else if(modalStudent.CH04b.equalsIgnoreCase(getString(R.string.str_CH04b_op4)))
                rg_whichDisability.check(R.id.rb_CH04b_op4);
        } else {
            rg_anyDisability.check(R.id.rb_CH04a_No);
        }

        if (modalStudent.CH05.equalsIgnoreCase(getString(R.string.yes))) {
            isStudCurrentlyEnrolled = true;
            rg_isStudentEnrolled.check(R.id.rb_CH05_yes);
            ll_enrolledChildFields.setVisibility(View.VISIBLE);
            rl_CH10a.setVisibility(View.VISIBLE);
            spinner_class.setSelection(adapterClass.getPosition(modalStudent.CH06a));
            spinner_schoolType.setSelection(adapterSchoolType.getPosition(modalStudent.CH06b));

            if (modalStudent.CH06c.equalsIgnoreCase(getString(R.string.yes)))
                rg_instructionLang.check(R.id.rb_CH06c_yes);
            else rg_instructionLang.check(R.id.rb_CH06c_No);

            if (modalStudent.CH06d.equalsIgnoreCase(getString(R.string.str_CH06d_one))){
                rl_kindOfActivities.setVisibility(View.VISIBLE);
                rg_schoolStatus.check(R.id.rb_CH06d_one);

                if(modalStudent.CH06e.equalsIgnoreCase(getString(R.string.str_CH06e_one)))
                    rg_schoolActivities.check(R.id.rb_CH06e_one);
                else if(modalStudent.CH06e.equalsIgnoreCase(getString(R.string.str_CH06e_two)))
                    rg_schoolActivities.check(R.id.rb_CH06e_two);
                else if(modalStudent.CH06e.equalsIgnoreCase(getString(R.string.str_CH06e_three)))
                    rg_schoolActivities.check(R.id.rb_CH06e_three);
            }
            else if (modalStudent.CH06d.equalsIgnoreCase(getString(R.string.str_CH06d_two)))
                rg_schoolStatus.check(R.id.rb_CH06d_two);
            else rg_schoolStatus.check(R.id.rb_CH06d_three);

            if (modalStudent.CH06f.equalsIgnoreCase(getString(R.string.yes)))
                rg_haveTextbooks.check(R.id.rb_CH06f_yes);
            else rg_haveTextbooks.check(R.id.rb_CH06f_No);

            if (modalStudent.CH06g.equalsIgnoreCase(getString(R.string.yes)))
                rg_gradeRepeat.check(R.id.rb_CH06g_yes);
            else rg_gradeRepeat.check(R.id.rb_CH06g_No);

            if (modalStudent.CH10a.equalsIgnoreCase(getString(R.string.yes))) {
                rg_helpChild.check(R.id.rb_CH10a_yes);
                rl_CH10b.setVisibility(View.VISIBLE);
            }
            else rg_helpChild.check(R.id.rb_CH10a_No);

        } else {
            isStudCurrentlyEnrolled = false;
            rg_isStudentEnrolled.check(R.id.rb_CH05_No);
            ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
            if (modalStudent.CH07a.equalsIgnoreCase(getString(R.string.yes))) {
                rg_isStudentEverEnrolled.check(R.id.rb_CH07a_yes);
                ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
                ll_dropoutFields.setVisibility(View.VISIBLE);
                spinner_dropoutYear.setSelection(adapterDropYear.getPosition(modalStudent.CH07b));
                spinner_dropout_class.setSelection(adapterClass.getPosition(modalStudent.CH07c));
                if (modalStudent.CH07d.equalsIgnoreCase(getString(R.string.str_reasonToDrop_one)))
                    rg_dropOutReason.check(R.id.rb_CH07d_one);
                else if (modalStudent.CH07d.equalsIgnoreCase(getString(R.string.str_reasonToDrop_two)))
                    rg_dropOutReason.check(R.id.rb_CH07d_two);
                else if (modalStudent.CH07d.equalsIgnoreCase(getString(R.string.str_reasonToDrop_three)))
                    rg_dropOutReason.check(R.id.rb_CH07d_three);
                else if (modalStudent.CH07d.equalsIgnoreCase(getString(R.string.str_reasonToDrop_four)))
                    rg_dropOutReason.check(R.id.rb_CH07d_four);
                else if (modalStudent.CH07d.equalsIgnoreCase(getString(R.string.str_reasonToDrop_five)))
                    rg_dropOutReason.check(R.id.rb_CH07d_five);
                else if (modalStudent.CH07d.equalsIgnoreCase(getString(R.string.str_reasonToDrop_six)))
                    rg_dropOutReason.check(R.id.rb_CH07d_six);
                else rg_dropOutReason.check(R.id.rb_CH07d_seven);
            } else {
                ll_dropoutFields.setVisibility(View.GONE);
                rg_isStudentEverEnrolled.check(R.id.rb_CH07a_No);
            }
        }

        if (modalStudent.CH08.equalsIgnoreCase(getString(R.string.yes)))
            rg_paidTution.check(R.id.rb_CH08_yes);
        else rg_paidTution.check(R.id.rb_CH08_No);

        if (modalStudent.CH09.equalsIgnoreCase(getString(R.string.yes)))
            rg_readMaterial.check(R.id.rb_CH09_yes);
        else rg_readMaterial.check(R.id.rb_CH09_No);

        if (modalStudent.CH10c.equalsIgnoreCase(getString(R.string.str_CH10c_one)))
            rg_oftenReads.check(R.id.rb_CH10c_one);
        else if (modalStudent.CH10c.equalsIgnoreCase(getString(R.string.str_CH10c_two)))
            rg_oftenReads.check(R.id.rb_CH10c_two);
        else if (modalStudent.CH10c.equalsIgnoreCase(getString(R.string.str_CH10c_three)))
            rg_oftenReads.check(R.id.rb_CH10c_three);
        else if (modalStudent.CH10c.equalsIgnoreCase(getString(R.string.str_CH10c_four)))
            rg_oftenReads.check(R.id.rb_CH10c_four);
        else if (modalStudent.CH10c.equalsIgnoreCase(getString(R.string.str_CH10c_five)))
            rg_oftenReads.check(R.id.rb_CH10c_five);
    }

    @ItemSelect(R.id.spn_CH03)
    public void ageSelect(boolean sel) {
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(getActivity()));
    }

    @ItemSelect(R.id.spn_CH02)
    public void genderSelect(boolean sel) {
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(getActivity()));
    }

    @Click(R.id.rl_parentLayout)
    public void hideKeyboard() {
        KIX_Utility.HideInputKeypad(getActivity());
    }

    @Click(R.id.btn_saveStudent)
    public void saveStudent() {
        getSelectedAge();
        getSpinnerValues();
        getRadioButtonValues();

        if (!et_studentName.getText().toString().isEmpty() && spinner_age.getSelectedItemPosition()!=0
                && spinner_gender.getSelectedItemPosition()!=0 && rb_CH04a!=null && rb_CH05 != null && rb_CH08 != null
                && rb_CH09 != null && rb_CH10c != null) {
            if (rb_CH04b == null) str_CH04b = "NA";
            else str_CH04b = rb_CH04b.getText().toString();
            insertStudent();
        } else {
            Toast.makeText(getActivity(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertStudent() {

        if (isStudCurrentlyEnrolled) {
            str_CH06a = standard;
            str_CH06b = schoolType;

            if (rb_CH06c == null || rb_CH06d == null || rb_CH06f == null || rb_CH06g == null || rb_CH10a == null) {
                Toast.makeText(getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
            } else {
                str_CH06c = rb_CH06c.getText().toString();
                str_CH06d = rb_CH06d.getText().toString();
                if (rb_CH06e == null) str_CH06e = "NA";
                else str_CH06e = rb_CH06e.getText().toString();
                str_CH06f = rb_CH06f.getText().toString();
                str_CH06g = rb_CH06g.getText().toString();
                str_CH10a = rb_CH10a.getText().toString();
                if(rb_CH10b==null) str_CH10b="NA";
                else str_CH10b = rb_CH10b.getText().toString();

                str_CH07a = "NA";
                str_CH07b = "NA";
                str_CH07c = "NA";
                str_CH07d = "NA";
                if (getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                    studentDao.updateStudent(et_studentName.getText().toString(), age, spinner_gender.getSelectedItem().toString(),
                            rb_CH04a.getText().toString(), str_CH04b,
                            rb_CH05.getText().toString(),
                            str_CH06a, str_CH06b, str_CH06c, str_CH06d, str_CH06e, str_CH06f, str_CH06g,
                            str_CH07a, str_CH07b, str_CH07c, str_CH07d,
                            rb_CH08.getText().toString(),rb_CH09.getText().toString(),
                            str_CH10a, str_CH10b, rb_CH10c.getText().toString(),
                            studId);
                    BackupDatabase.backup(getActivity());
                    Toast.makeText(getActivity(), "Student Updated Successfully!", Toast.LENGTH_SHORT).show();
                    getFragmentManager().popBackStack();
                } else insertStud();
            }
        } else {
            str_CH06a = "NA";
            str_CH06b = "NA";
            str_CH06c = "NA";
            str_CH06d = "NA";
            str_CH06e = "NA";
            str_CH06f = "NA";
            str_CH06g = "NA";
            str_CH10a = "NA";
            str_CH10b = "NA";

            if (rb_CH07a == null) {
                Toast.makeText(getActivity(), "All fields are mandatory..", Toast.LENGTH_SHORT).show();
            } else {
                str_CH07a = rb_CH07a.getText().toString();
                if (str_CH07a.equalsIgnoreCase("yes")) {
                    str_CH07b = dropoutYear;
                    str_CH07c = dropoutStandard;

                    if (rb_CH07d == null) {
                        Toast.makeText(getActivity(), "All fields are mandatory...", Toast.LENGTH_SHORT).show();
                    } else {
                        str_CH07d = rb_CH07d.getText().toString();
                        if (getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                            studentDao.updateStudent(et_studentName.getText().toString(), age, spinner_gender.getSelectedItem().toString(),
                                    rb_CH04a.getText().toString(), str_CH04b,
                                    rb_CH05.getText().toString(),
                                    str_CH06a, str_CH06b, str_CH06c, str_CH06d, str_CH06e, str_CH06f, str_CH06g,
                                    str_CH07a, str_CH07b, str_CH07c, str_CH07d,
                                    rb_CH08.getText().toString(), rb_CH09.getText().toString(),
                                    str_CH10a, str_CH10b, rb_CH10c.getText().toString(),
                                    studId);
                            BackupDatabase.backup(getActivity());
                            Toast.makeText(getActivity(), "Student Updated Successfully!", Toast.LENGTH_SHORT).show();
                            getFragmentManager().popBackStack();
                        } else insertStud();
                    }
                } else {
                    str_CH07b="NA";
                    str_CH07c="NA";
                    str_CH07d="NA";
                    if (getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                        studentDao.updateStudent(et_studentName.getText().toString(), age, spinner_gender.getSelectedItem().toString(),
                                rb_CH04a.getText().toString(), str_CH04b,
                                rb_CH05.getText().toString(),
                                str_CH06a, str_CH06b, str_CH06c, str_CH06d, str_CH06e, str_CH06f, str_CH06g,
                                str_CH07a, str_CH07b, str_CH07c, str_CH07d,
                                rb_CH08.getText().toString(), rb_CH09.getText().toString(),
                                str_CH10a, str_CH10b, rb_CH10c.getText().toString(),
                                studId);
                        BackupDatabase.backup(getActivity());
                        Toast.makeText(getActivity(), "Student Updated Successfully!", Toast.LENGTH_SHORT).show();
                        getFragmentManager().popBackStack();
                    } else insertStud();
                }
            }
        }

/*        Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, householdID);
        startActivity(intent);*/
    }

    private void updateStudent() {
        Toast.makeText(getActivity(), "Student Edited Successfully!", Toast.LENGTH_SHORT).show();
    }

    public void insertStud() {
        String sId = KIX_Utility.getUUID().toString();
        Log.d("TAG", "insertStudent: " + sId);
        Modal_Student modal_student = new Modal_Student();
        modal_student.setStudentId(sId);
        modal_student.setCH01(et_studentName.getText().toString());
        modal_student.setCH02(age);
        modal_student.setCH03(spinner_gender.getSelectedItem().toString());
        modal_student.setCH04a(rb_CH04a.getText().toString());
        modal_student.setCH04b(str_CH04b);
        modal_student.setCH05(rb_CH05.getText().toString());
        modal_student.setCH06a(str_CH06a);
        modal_student.setCH06b(str_CH06b);
        modal_student.setCH06c(str_CH06c);
        modal_student.setCH06d(str_CH06d);
        modal_student.setCH06e(str_CH06e);
        modal_student.setCH06f(str_CH06f);
        modal_student.setCH06g(str_CH06g);
        modal_student.setCH07a(str_CH07a);
        modal_student.setCH07b(str_CH07b);
        modal_student.setCH07c(str_CH07c);
        modal_student.setCH07d(str_CH07d);
        modal_student.setCH08(rb_CH08.getText().toString());
        modal_student.setCH09(rb_CH09.getText().toString());
        modal_student.setCH10a(str_CH10a);
        modal_student.setCH10b(str_CH10b);
        modal_student.setCH10c(rb_CH10c.getText().toString());
        modal_student.setSvrCode(surveyorCode);
        modal_student.setHouseholdId(householdID);
        modal_student.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_student.setSentFlag(0);

        studentDao.insertStudent(modal_student);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Student Added Successfully!", Toast.LENGTH_SHORT).show();
        startDialog(modal_student);

    }

    private void getSelectedAge() {
        String age1 = spinner_age.getSelectedItem().toString();
        String[] split_age = age1.split(" ");
        if (split_age.length > 1)
            age = String.valueOf(Integer.parseInt(split_age[1]));
            //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, Integer.parseInt(split_age[1]));
        else
            age = "0";
        //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, 0);
    }

    private void getSpinnerValues() {
        if (spinner_schoolType.getSelectedItemPosition() == 0) schoolType = "NA";
        else schoolType = spinner_schoolType.getSelectedItem().toString();

        if (spinner_dropoutYear.getSelectedItemPosition() == 0) dropoutYear = "NA";
        else dropoutYear = spinner_dropoutYear.getSelectedItem().toString();

        if (spinner_class.getSelectedItemPosition() == 0) standard = "NA";
        else standard = spinner_class.getSelectedItem().toString();

        if (spinner_dropout_class.getSelectedItemPosition() == 0) dropoutStandard = "NA";
        else dropoutStandard = spinner_dropout_class.getSelectedItem().toString();
    }

    public void getRadioButtonValues() {
        int selectedCH04a = rg_anyDisability.getCheckedRadioButtonId();
        int selectedCH04b = rg_whichDisability.getCheckedRadioButtonId();
        int selectedCH05 = rg_isStudentEnrolled.getCheckedRadioButtonId();
        int selectedCH06c = rg_instructionLang.getCheckedRadioButtonId();
        int selectedCH06d = rg_schoolStatus.getCheckedRadioButtonId();
        int selectedCH06e = rg_schoolActivities.getCheckedRadioButtonId();
        int selectedCH06f = rg_haveTextbooks.getCheckedRadioButtonId();
        int selectedCH06g = rg_gradeRepeat.getCheckedRadioButtonId();
        int selectedCH07a = rg_isStudentEverEnrolled.getCheckedRadioButtonId();
        int selectedCH07d = rg_dropOutReason.getCheckedRadioButtonId();
        int selectedCH08 = rg_paidTution.getCheckedRadioButtonId();
        int selectedCH09 = rg_readMaterial.getCheckedRadioButtonId();
        int selectedCH10a = rg_helpChild.getCheckedRadioButtonId();
        int selectedCH10b = rg_mostOften.getCheckedRadioButtonId();
        int selectedCH10c = rg_oftenReads.getCheckedRadioButtonId();

        rb_CH04a = getView().findViewById(selectedCH04a);
        rb_CH04b = getView().findViewById(selectedCH04b);
        rb_CH05 = getView().findViewById(selectedCH05);
        rb_CH06c = getView().findViewById(selectedCH06c);
        rb_CH06d = getView().findViewById(selectedCH06d);
        rb_CH06e = getView().findViewById(selectedCH06e);
        rb_CH06f = getView().findViewById(selectedCH06f);
        rb_CH06g = getView().findViewById(selectedCH06g);
        rb_CH07a = getView().findViewById(selectedCH07a);
        rb_CH07d = getView().findViewById(selectedCH07d);
        rb_CH08 = getView().findViewById(selectedCH08);
        rb_CH09 = getView().findViewById(selectedCH09);
        rb_CH10a = getView().findViewById(selectedCH10a);
        rb_CH10b = getView().findViewById(selectedCH10b);
        rb_CH10c = getView().findViewById(selectedCH10c);

    }


    @UiThread
    public void startDialog(Modal_Student modal_student) {
        startExamDialog = null;
        startExamDialog = new Dialog(Objects.requireNonNull(getActivity()));
        startExamDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(startExamDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        startExamDialog.setContentView(R.layout.start_game_dialog);
        startExamDialog.setCanceledOnTouchOutside(false);

//        dia_title = startExamDialog.findViewById(R.id.dia_title);
        dlg_yes = startExamDialog.findViewById(R.id.dlg_yes);
        dlg_no = startExamDialog.findViewById(R.id.dlg_no);
//        dia_title.setText("Save and Submit Test");
        dlg_no.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
            startExamDialog.dismiss();
        });
        dlg_yes.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
            FastSave.getInstance().saveString(STUDENT_ID, "" + modal_student.getStudentId());
            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, KIX_Utility.getUUID().toString());
            markAttendance(modal_student);
            Intent intent = new Intent(getActivity(), WebViewActivity_.class);
            intent.putExtra(Kix_Constant.STUDENT_NAME, modal_student.getCH01());
            startActivity(intent);
            startExamDialog.dismiss();
        });
        startExamDialog.show();
    }

    private void markAttendance(Modal_Student stud) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        Attendance attendance = new Attendance();
        attendance.sessionId = FastSave.getInstance().getString(Kix_Constant.SESSIONID, "");
        attendance.studentId = stud.getStudentId();
        attendance.attendanceDate = KIX_Utility.getCurrentDateTime();
        attendance.sentFlag = 0;
        attendances.add(attendance);
        attendanceDao.insertAttendance(attendances);
        Modal_Session s = new Modal_Session();
        s.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""));
        s.setFromDate(KIX_Utility.getCurrentDateTime());
//        s.setToDate("NA");
        sessionDao.insert(s);
    }

}
