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
    @ViewById(R.id.rg_CH04)
    RadioGroup rg_isStudentEnrolled;
    @ViewById(R.id.spn_CH05a)
    Spinner spinner_class;
    @ViewById(R.id.spn_CH05b)
    Spinner spinner_schoolType;
    @ViewById(R.id.rg_CH05c)
    RadioGroup rg_instructionLang;
    @ViewById(R.id.rg_CH05d)
    RadioGroup rg_schoolStatus;
    @ViewById(R.id.rg_CH05e)
    RadioGroup rg_schoolActivities;
    @ViewById(R.id.rg_CH05f)
    RadioGroup rg_haveTextbooks;
    @ViewById(R.id.rg_CH06a)
    RadioGroup rg_isStudentEverEnrolled;
    @ViewById(R.id.spn_CH06b1)
    Spinner spinner_dropoutYear;
    @ViewById(R.id.spn_CH06b2)
    Spinner spinner_dropout_class;
    @ViewById(R.id.rg_CH06b3)
    RadioGroup rg_dropOutReason;
    @ViewById(R.id.rg_CH07)
    RadioGroup rg_everEnrolledInNursary;
    @ViewById(R.id.rg_CH08)
    RadioGroup rg_paidTution;

    @ViewById(R.id.ll_spinnerDropout)
    LinearLayout ll_spinnerDropout;
    @ViewById(R.id.ll_schoolType)
    LinearLayout ll_schoolType;

    @ViewById(R.id.tv_label)
    TextView tv_label;

    @ViewById(R.id.ll_enrolledChildFields)
    LinearLayout ll_enrolledChildFields;
    @ViewById(R.id.ll_notEnrolledChildFields)
    LinearLayout ll_notEnrolledChildFields;
    @ViewById(R.id.ll_sub_CHo6a)
    LinearLayout ll_dropoutFields;
    @ViewById(R.id.rl_CH05e)
    RelativeLayout rl_kindOfActivities;

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

    RadioButton rb_CH04, rb_CH05c, rb_CH05d, rb_CH05e, rb_CH05f, rb_CH06a, rb_CH06b3, rb_CH07, rb_CH08;

    String str_CH05a, str_CH05b, str_CH05c, str_CH05d, str_CH05e, str_CH05f;
    String str_CH06a, str_CH06b1, str_CH06b2, str_CH06b3;

    public boolean isStudCurrentlyEnrolled;

    public Fragment_AddStudent() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @AfterViews
    public void initialize() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));

        this.surveyorCode = this.getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        this.householdID = this.getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        this.adapterAge = ArrayAdapter.createFromResource(Objects.requireNonNull(this.getActivity()), R.array.age, R.layout.spinner_item);
        this.spinner_age.setAdapter(this.adapterAge);
        this.adapterGender = ArrayAdapter.createFromResource(this.getActivity(), R.array.gender, R.layout.spinner_item);
        this.spinner_gender.setAdapter(this.adapterGender);
        this.adapterSchoolType = ArrayAdapter.createFromResource(this.getActivity(), R.array.school_type, R.layout.spinner_item);
        this.spinner_schoolType.setAdapter(this.adapterSchoolType);
        this.adapterDropYear = ArrayAdapter.createFromResource(this.getActivity(), R.array.dropout_year_list, R.layout.spinner_item);
        this.spinner_dropoutYear.setAdapter(this.adapterDropYear);
        this.adapterClass = ArrayAdapter.createFromResource(this.getActivity(), R.array.student_class, R.layout.spinner_item);
        this.spinner_class.setAdapter(this.adapterClass);
        this.spinner_dropout_class.setAdapter(this.adapterClass);

        if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
            this.studId = this.getArguments().getString(STUDENT_ID);
            this.modalStudent = studentDao.getStudentByStudId(this.studId);
            this.fetchChildDetails(this.modalStudent);
        }

        this.rg_isStudentEnrolled.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.rb_CH04_yes:
                    this.ll_enrolledChildFields.setVisibility(View.VISIBLE);
                    this.ll_notEnrolledChildFields.setVisibility(View.GONE);
                    this.btn_saveStudent.setVisibility(View.VISIBLE);
                    this.isStudCurrentlyEnrolled = true;
                    break;

                case R.id.rb_CH04_No:
                    this.ll_enrolledChildFields.setVisibility(View.GONE);
                    this.ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
                    this.btn_saveStudent.setVisibility(View.VISIBLE);
                    this.isStudCurrentlyEnrolled = false;
                    break;
            }
        });

        this.rg_isStudentEverEnrolled.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.rb_CH06a_yes:
                    this.ll_dropoutFields.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_CH06a_No:
                    this.ll_dropoutFields.setVisibility(View.GONE);
                    break;
            }
        });

        this.rg_schoolStatus.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_CH05d_one) this.rl_kindOfActivities.setVisibility(View.VISIBLE);
            else {
                this.rl_kindOfActivities.setVisibility(View.GONE);
                this.rg_schoolActivities.clearCheck();//todo test
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

    private void fetchChildDetails(final Modal_Student modalStudent) {
        this.tv_label.setText(this.getResources().getString(R.string.edit_child_info));
        this.btn_saveStudent.setText("EDIT");
        this.btn_saveStudent.setVisibility(View.VISIBLE);
        this.et_studentName.setText(modalStudent.getCH01());

        this.spinner_age.setSelection(this.adapterAge.getPosition("Age " + modalStudent.getCH03()));
        this.spinner_gender.setSelection(this.adapterGender.getPosition(modalStudent.getCH02()));

        if (modalStudent.CH04.equalsIgnoreCase(this.getString(R.string.yes))) {
            this.isStudCurrentlyEnrolled = true;
            this.rg_isStudentEnrolled.check(R.id.rb_CH04_yes);
            this.ll_enrolledChildFields.setVisibility(View.VISIBLE);
            this.spinner_class.setSelection(this.adapterClass.getPosition(modalStudent.CH05a));
            this.spinner_schoolType.setSelection(this.adapterSchoolType.getPosition(modalStudent.CH05b));

            if (modalStudent.CH05c.equalsIgnoreCase(this.getString(R.string.yes)))
                this.rg_instructionLang.check(R.id.rb_CH05c_yes);
            else this.rg_instructionLang.check(R.id.rb_CH05c_No);

            if (modalStudent.CH05d.equalsIgnoreCase(this.getString(R.string.str_CH05d_one))){
                this.rl_kindOfActivities.setVisibility(View.VISIBLE);
                this.rg_schoolStatus.check(R.id.rb_CH05d_one);

                if(modalStudent.CH05e.equalsIgnoreCase(this.getString(R.string.str_CH05e_one)))
                    this.rg_schoolActivities.check(R.id.rb_CH05e_one);
                else if(modalStudent.CH05e.equalsIgnoreCase(this.getString(R.string.str_CH05e_two)))
                    this.rg_schoolActivities.check(R.id.rb_CH05e_two);
                else if(modalStudent.CH05e.equalsIgnoreCase(this.getString(R.string.str_CH05e_three)))
                    this.rg_schoolActivities.check(R.id.rb_CH05e_three);
            }
            else if (modalStudent.CH05d.equalsIgnoreCase(this.getString(R.string.str_CH05d_two)))
                this.rg_schoolStatus.check(R.id.rb_CH05d_two);
            else this.rg_schoolStatus.check(R.id.rb_CH05d_three);

            if (modalStudent.CH05f.equalsIgnoreCase(this.getString(R.string.yes)))
                this.rg_haveTextbooks.check(R.id.rb_CH05f_yes);
            else this.rg_haveTextbooks.check(R.id.rb_CH05f_No);
        } else {
            this.isStudCurrentlyEnrolled = false;
            this.rg_isStudentEnrolled.check(R.id.rb_CH04_No);
            this.ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
            if (modalStudent.CH06a.equalsIgnoreCase(this.getString(R.string.yes))) {
                this.rg_isStudentEverEnrolled.check(R.id.rb_CH06a_yes);
                this.ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
                this.ll_dropoutFields.setVisibility(View.VISIBLE);
                this.spinner_dropoutYear.setSelection(this.adapterDropYear.getPosition(modalStudent.CH06b1));
                this.spinner_dropout_class.setSelection(this.adapterClass.getPosition(modalStudent.CH06b2));
                if (modalStudent.CH06b3.equalsIgnoreCase(this.getString(R.string.str_reasonToDrop_one)))
                    this.rg_dropOutReason.check(R.id.rb_CH06b3_one);
                else if (modalStudent.CH06b3.equalsIgnoreCase(this.getString(R.string.str_reasonToDrop_two)))
                    this.rg_dropOutReason.check(R.id.rb_CH06b3_two);
                else if (modalStudent.CH06b3.equalsIgnoreCase(this.getString(R.string.str_reasonToDrop_three)))
                    this.rg_dropOutReason.check(R.id.rb_CH06b3_three);
                else if (modalStudent.CH06b3.equalsIgnoreCase(this.getString(R.string.str_reasonToDrop_four)))
                    this.rg_dropOutReason.check(R.id.rb_CH06b3_four);
                else if (modalStudent.CH06b3.equalsIgnoreCase(this.getString(R.string.str_reasonToDrop_five)))
                    this.rg_dropOutReason.check(R.id.rb_CH06b3_five);
                else if (modalStudent.CH06b3.equalsIgnoreCase(this.getString(R.string.str_reasonToDrop_six)))
                    this.rg_dropOutReason.check(R.id.rb_CH06b3_six);
                else this.rg_dropOutReason.check(R.id.rb_CH06b3_seven);
            } else {
                this.ll_dropoutFields.setVisibility(View.GONE);
                this.rg_isStudentEverEnrolled.check(R.id.rb_CH06a_No);
            }
        }

        if (modalStudent.CH07.equalsIgnoreCase(this.getString(R.string.yes)))
            this.rg_everEnrolledInNursary.check(R.id.rb_CH07_yes);
        else this.rg_everEnrolledInNursary.check(R.id.rb_CH07_No);

        if (modalStudent.CH08.equalsIgnoreCase(this.getString(R.string.yes)))
            this.rg_paidTution.check(R.id.rb_CH08_yes);
        else this.rg_paidTution.check(R.id.rb_CH08_No);
    }

    @ItemSelect(R.id.spn_CH03)
    public void ageSelect(final boolean sel) {
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(this.getActivity()));
    }

    @ItemSelect(R.id.spn_CH02)
    public void genderSelect(final boolean sel) {
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(this.getActivity()));
    }

    @Click(R.id.rl_parentLayout)
    public void hideKeyboard() {
        KIX_Utility.HideInputKeypad(this.getActivity());
    }

    @Click(R.id.btn_saveStudent)
    public void saveStudent() {
        this.getSelectedAge();
        this.getSpinnerValues();
        this.getRadioButtonValues();

        if (!this.et_studentName.getText().toString().isEmpty()) {
            if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                this.insertStudent();
//                Toast.makeText(getActivity(), "Student Edited Successfully!", Toast.LENGTH_SHORT).show();
//                getFragmentManager().popBackStack();
            } else
                this.insertStudent();
        } else {
            Toast.makeText(this.getActivity(), "Enter Name First.", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertStudent() {

        if (this.isStudCurrentlyEnrolled) {
            this.str_CH05a = this.standard;
            this.str_CH05b = this.schoolType;

            if (this.rb_CH05c == null || this.rb_CH05d == null || this.rb_CH05f == null ||
                    this.rb_CH07 == null || this.rb_CH08 == null) {
                Toast.makeText(this.getActivity(), "All fields are mandatory.", Toast.LENGTH_SHORT).show();
            } else {
                this.str_CH05c = this.rb_CH05c.getText().toString();
                this.str_CH05d = this.rb_CH05d.getText().toString();
                if (this.rb_CH05e == null) this.str_CH05e = "NA";
                else this.str_CH05e = this.rb_CH05e.getText().toString();
                this.str_CH05f = this.rb_CH05f.getText().toString();

                this.str_CH06a = "";
                this.str_CH06b1 = "";
                this.str_CH06b2 = "";
                this.str_CH06b3 = "";
                if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                    studentDao.updateStudent(this.et_studentName.getText().toString(), this.age, this.spinner_gender.getSelectedItem().toString(),
                            this.rb_CH04.getText().toString(),
                            this.str_CH05a, this.str_CH05b, this.str_CH05c, this.str_CH05d, this.str_CH05e, this.str_CH05f,
                            this.str_CH06a, this.str_CH06b1, this.str_CH06b2, this.str_CH06b3,
                            this.rb_CH07.getText().toString(), this.rb_CH08.getText().toString(),
                            this.studId);
                    BackupDatabase.backup(this.getActivity());
                    Toast.makeText(this.getActivity(), "Student Edited Successfully!", Toast.LENGTH_SHORT).show();
                    this.getFragmentManager().popBackStack();
                } else this.insertStud();
            }
        } else {
            this.str_CH05a = "";
            this.str_CH05b = "";
            this.str_CH05c = "";
            this.str_CH05d = "";
            this.str_CH05e = "";
            this.str_CH05f = "";

            if (this.rb_CH06a == null || this.rb_CH07 == null || this.rb_CH08 == null) {
                Toast.makeText(this.getActivity(), "All fields are mandatory..", Toast.LENGTH_SHORT).show();
            } else {
                this.str_CH06a = this.rb_CH06a.getText().toString();
                if (this.str_CH06a.equalsIgnoreCase("yes")) {
                    this.str_CH06b1 = this.dropoutYear;
                    this.str_CH06b2 = this.dropoutStandard;

                    if (this.rb_CH06b3 == null) {
                        Toast.makeText(this.getActivity(), "All fields are mandatory...", Toast.LENGTH_SHORT).show();
                    } else {
                        this.str_CH06b3 = this.rb_CH06b3.getText().toString();
                        if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                            studentDao.updateStudent(this.et_studentName.getText().toString(), this.age, this.spinner_gender.getSelectedItem().toString(),
                                    this.rb_CH04.getText().toString(),
                                    this.str_CH05a, this.str_CH05b, this.str_CH05c, this.str_CH05d, this.str_CH05e, this.str_CH05f,
                                    this.str_CH06a, this.str_CH06b1, this.str_CH06b2, this.str_CH06b3,
                                    this.rb_CH07.getText().toString(), this.rb_CH08.getText().toString(),
                                    this.studId);
                            BackupDatabase.backup(this.getActivity());
                            Toast.makeText(this.getActivity(), "Student Edited Successfully!", Toast.LENGTH_SHORT).show();
                            this.getFragmentManager().popBackStack();
                        } else this.insertStud();
                    }
                } else {
                    if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                        studentDao.updateStudent(this.et_studentName.getText().toString(), this.age, this.spinner_gender.getSelectedItem().toString(),
                                this.rb_CH04.getText().toString(),
                                this.str_CH05a, this.str_CH05b, this.str_CH05c, this.str_CH05d, this.str_CH05e, this.str_CH05f,
                                this.str_CH06a, this.str_CH06b1, this.str_CH06b2, this.str_CH06b3,
                                this.rb_CH07.getText().toString(), this.rb_CH08.getText().toString(),
                                this.studId);
                        BackupDatabase.backup(this.getActivity());
                        Toast.makeText(this.getActivity(), "Student Edited Successfully!", Toast.LENGTH_SHORT).show();
                        this.getFragmentManager().popBackStack();
                    } else this.insertStud();
                }
            }
        }

/*        Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, householdID);
        startActivity(intent);*/
    }

    private void updateStudent() {
        Toast.makeText(this.getActivity(), "Student Edited Successfully!", Toast.LENGTH_SHORT).show();
    }

    public void insertStud() {
        final String sId = KIX_Utility.getUUID().toString();
        Log.d("TAG", "insertStudent: " + sId);
        final Modal_Student modal_student = new Modal_Student();
        modal_student.setStudentId(sId);
        modal_student.setCH01(this.et_studentName.getText().toString());
        modal_student.setCH02(this.spinner_gender.getSelectedItem().toString());
        modal_student.setCH03(this.age);
        modal_student.setCH04(this.rb_CH04.getText().toString());
        modal_student.setCH05a(this.str_CH05a);
        modal_student.setCH05b(this.str_CH05b);
        modal_student.setCH05c(this.str_CH05c);
        modal_student.setCH05d(this.str_CH05d);
        modal_student.setCH05e(this.str_CH05e);
        modal_student.setCH05f(this.str_CH05f);
        modal_student.setCH06a(this.str_CH06a);
        modal_student.setCH06b1(this.str_CH06b1);
        modal_student.setCH06b2(this.str_CH06b2);
        modal_student.setCH06b3(this.str_CH06b3);
        modal_student.setCH07(this.rb_CH07.getText().toString());
        modal_student.setCH08(this.rb_CH08.getText().toString());
        modal_student.setSvrCode(this.surveyorCode);
        modal_student.setHouseholdId(this.householdID);
        modal_student.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_student.setSentFlag(0);

        studentDao.insertStudent(modal_student);
        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "Student Added Successfully!", Toast.LENGTH_SHORT).show();
        this.startDialog(modal_student);

    }

    private void getSelectedAge() {
        final String age1 = this.spinner_age.getSelectedItem().toString();
        final String[] split_age = age1.split(" ");
        if (split_age.length > 1)
            this.age = String.valueOf(Integer.parseInt(split_age[1]));
            //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, Integer.parseInt(split_age[1]));
        else
            this.age = "0";
        //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, 0);
    }

    private void getSpinnerValues() {
        if (this.spinner_schoolType.getSelectedItemPosition() == 0) this.schoolType = "NA";
        else this.schoolType = this.spinner_schoolType.getSelectedItem().toString();

        if (this.spinner_dropoutYear.getSelectedItemPosition() == 0) this.dropoutYear = "NA";
        else this.dropoutYear = this.spinner_dropoutYear.getSelectedItem().toString();

        if (this.spinner_class.getSelectedItemPosition() == 0) this.standard = "NA";
        else this.standard = this.spinner_class.getSelectedItem().toString();

        if (this.spinner_dropout_class.getSelectedItemPosition() == 0) this.dropoutStandard = "NA";
        else this.dropoutStandard = this.spinner_dropout_class.getSelectedItem().toString();
    }

    public void getRadioButtonValues() {
        final int selectedCH04 = this.rg_isStudentEnrolled.getCheckedRadioButtonId();
        final int selectedCH05c = this.rg_instructionLang.getCheckedRadioButtonId();
        final int selectedCH05d = this.rg_schoolStatus.getCheckedRadioButtonId();
        final int selectedCH05e = this.rg_schoolActivities.getCheckedRadioButtonId();
        final int selectedCH05f = this.rg_haveTextbooks.getCheckedRadioButtonId();
        final int selectedCH06a = this.rg_isStudentEverEnrolled.getCheckedRadioButtonId();
        final int selectedCH06b3 = this.rg_dropOutReason.getCheckedRadioButtonId();
        final int selectedCH07 = this.rg_everEnrolledInNursary.getCheckedRadioButtonId();
        final int selectedCH08 = this.rg_paidTution.getCheckedRadioButtonId();

        this.rb_CH04 = this.getView().findViewById(selectedCH04);
        this.rb_CH05c = this.getView().findViewById(selectedCH05c);
        this.rb_CH05d = this.getView().findViewById(selectedCH05d);
        this.rb_CH05e = this.getView().findViewById(selectedCH05e);
        this.rb_CH05f = this.getView().findViewById(selectedCH05f);
        this.rb_CH06a = this.getView().findViewById(selectedCH06a);
        this.rb_CH06b3 = this.getView().findViewById(selectedCH06b3);
        this.rb_CH07 = this.getView().findViewById(selectedCH07);
        this.rb_CH08 = this.getView().findViewById(selectedCH08);

    }


    @UiThread
    public void startDialog(final Modal_Student modal_student) {
        this.startExamDialog = null;
        this.startExamDialog = new Dialog(Objects.requireNonNull(this.getActivity()));
        this.startExamDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(this.startExamDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.startExamDialog.setContentView(R.layout.start_game_dialog);
        this.startExamDialog.setCanceledOnTouchOutside(false);

//        dia_title = startExamDialog.findViewById(R.id.dia_title);
        this.dlg_yes = this.startExamDialog.findViewById(R.id.dlg_yes);
        this.dlg_no = this.startExamDialog.findViewById(R.id.dlg_no);
//        dia_title.setText("Save and Submit Test");
        this.dlg_no.setOnClickListener(v -> {
            this.getFragmentManager().popBackStack();
            this.startExamDialog.dismiss();
        });
        this.dlg_yes.setOnClickListener(v -> {
            this.getFragmentManager().popBackStack();
            FastSave.getInstance().saveString(STUDENT_ID, "" + modal_student.getStudentId());
            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, KIX_Utility.getUUID().toString());
            this.markAttendance(modal_student);
            final Intent intent = new Intent(this.getActivity(), WebViewActivity_.class);
            intent.putExtra(Kix_Constant.STUDENT_NAME, modal_student.getCH01());
            this.startActivity(intent);
            this.startExamDialog.dismiss();
        });
        this.startExamDialog.show();
    }

    private void markAttendance(final Modal_Student stud) {
        final ArrayList<Attendance> attendances = new ArrayList<>();
        final Attendance attendance = new Attendance();
        attendance.sessionId = FastSave.getInstance().getString(Kix_Constant.SESSIONID, "");
        attendance.studentId = stud.getStudentId();
        attendance.attendanceDate = KIX_Utility.getCurrentDateTime();
        attendance.sentFlag = 0;
        attendances.add(attendance);
        attendanceDao.insertAttendance(attendances);
        final Modal_Session s = new Modal_Session();
        s.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""));
        s.setFromDate(KIX_Utility.getCurrentDateTime());
//        s.setToDate("NA");
        sessionDao.insert(s);
    }

}
