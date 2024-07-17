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
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kix.assessment.KIXApplication;
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

    @ViewById(R.id.rl_parentLayout)
    RelativeLayout rl_parentLayout;
    @ViewById(R.id.et_CH01)
    EditText et_studentName;
    @ViewById(R.id.spn_CH02)
    Spinner spinner_gender;
    @ViewById(R.id.spn_CH03)
    Spinner spinner_age;
    @ViewById(R.id.rg_CH04a)
    RadioGroup rg_anyDisability;
    @ViewById(R.id.cb_CH04b_op1)
    CheckBox cb_CH04b_op1;
    @ViewById(R.id.cb_CH04b_op2)
    CheckBox cb_CH04b_op2;
    @ViewById(R.id.cb_CH04b_op3)
    CheckBox cb_CH04b_op3;
    @ViewById(R.id.cb_CH04b_op4)
    CheckBox cb_CH04b_op4;
    @ViewById(R.id.rg_CH05)
    RadioGroup rg_isStudentEnrolled;
    @ViewById(R.id.spn_CH06a)
    Spinner spinner_class;
    @ViewById(R.id.spn_CH06b)
    Spinner spinner_schoolType;
    @ViewById(R.id.rg_CH06c)
    RadioGroup rg_instructionLang;
    /*    @ViewById(R.id.rg_CH06d)
        RadioGroup rg_schoolStatus;
        @ViewById(R.id.rg_CH06e)
        RadioGroup rg_schoolActivities;*/
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
    @ViewById(R.id.rg_CH09a)
    RadioGroup rg_paidTution;
    @ViewById(R.id.rg_CH09b)
    RadioGroup rg_readMaterial;
    @ViewById(R.id.rg_CH08a)
    RadioGroup rg_helpChild;
    @ViewById(R.id.rg_CH08b)
    RadioGroup rg_mostOften;
    @ViewById(R.id.rg_CH09c)
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
    /*    @ViewById(R.id.rl_CH06e)
        RelativeLayout rl_kindOfActivities;*/
    @ViewById(R.id.rl_CH08a)
    RelativeLayout rl_CH08a;
    @ViewById(R.id.rl_CH08b)
    RelativeLayout rl_CH08b;

    @ViewById(R.id.btn_saveStudent)
    Button btn_saveStudent;

    @ViewById(R.id.lbl_CH04a)
    TextView tv_CHO4a;

    @ViewById(R.id.lbl_CH05)
    TextView tv_CHO5;

    @ViewById(R.id.lbl_CH06f)
    TextView tv_CHO6f;

    @ViewById(R.id.lbl_CH06g)
    TextView tv_CHO6g;

    @ViewById(R.id.lbl_CH07a)
    TextView tv_CHO7a;

    @ViewById(R.id.lbl_reasonToDrop)
    TextView tv_CHO7d;

    @ViewById(R.id.lbl_CH08a)
    TextView tv_CHO8a;

    @ViewById(R.id.lbl_CH08b)
    TextView tv_CHO8b;

    @ViewById(R.id.lbl_CH09a)
    TextView tv_CHO9a;

    @ViewById(R.id.lbl_CH09b)
    TextView tv_CHO9b;

    @ViewById(R.id.lbl_CH09c)
    TextView tv_CHO9c;

    String age, gender, surveyorCode, householdID;
    String schoolType, dropoutYear, standard, dropoutStandard;

    public Dialog startExamDialog;
    Button dlg_yes, dlg_no;

    ArrayAdapter adapterAge, adapterGender, adapterEnrollStatus,
            adapterClass, adapterDropoutClass, adapterSchoolType, adapterDropYear;

    Modal_Student modalStudent;

    String studId;

    RadioButton rb_CH04a, rb_CH05, rb_CH06c, rb_CH06f, rb_CH06g, rb_CH07a, rb_CH07d, rb_CH09a,
            rb_CH09b, rb_CH08a, rb_CH08b, rb_CH09c;

    String str_CH06a, str_CH06b, str_CH06c, str_CH06f, str_CH06g;
    String str_CH07a, str_CH07b, str_CH07c, str_CH07d;
    String str_CH09a, str_CH09b;
    String str_CH08a, str_CH08b, str_CH09c;
    String str_disabilityType = "";

    int selectedCH04a, selectedCH05, selectedCH06c, selectedCH06f, selectedCH06g, selectedCH07a,
            selectedCH07d, selectedCH09a, selectedCH09b, selectedCH08a, selectedCH08b, selectedCH09c;

    public boolean isStudCurrentlyEnrolled;

    private static final int REQUEST_CODE_ASSESSMENT_BACK = 1111;

    public Fragment_AddStudent() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @AfterViews
    public void initialize() {
        if(KIXApplication.app_country.equalsIgnoreCase("Pakistan")) {
            rl_parentLayout.setTextDirection(View.TEXT_DIRECTION_RTL);
            rl_parentLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }

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
        adapterDropoutClass = ArrayAdapter.createFromResource(getActivity(), R.array.student_dropoutclass, R.layout.spinner_item);
        spinner_dropout_class.setAdapter(adapterDropoutClass);

        selectedCH04a = selectedCH05 = selectedCH06c = selectedCH06f = selectedCH06g = selectedCH07a =
                selectedCH07d = selectedCH09a = selectedCH09b = selectedCH08a = selectedCH08b = selectedCH09c = 99;

        if (getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
            studId = getArguments().getString(STUDENT_ID);
            modalStudent = studentDao.getStudentByStudId(studId);
            fetchChildDetails(modalStudent);
            addChildNameToQuestion();
        }

        rg_isStudentEnrolled.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.rb_CH05_yes:
                    ll_enrolledChildFields.setVisibility(View.VISIBLE);
                    ll_notEnrolledChildFields.setVisibility(View.GONE);
                    rl_CH08a.setVisibility(View.VISIBLE);
                    btn_saveStudent.setVisibility(View.VISIBLE);
                    isStudCurrentlyEnrolled = true;
                    break;

                case R.id.rb_CH05_No:
                    ll_enrolledChildFields.setVisibility(View.GONE);
                    ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
                    rl_CH08a.setVisibility(View.GONE);
                    rl_CH08b.setVisibility(View.GONE);
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

/*        rg_schoolStatus.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_CH06d_one) rl_kindOfActivities.setVisibility(View.VISIBLE);
            else {
                rl_kindOfActivities.setVisibility(View.GONE);
                rg_schoolActivities.clearCheck();//todo test
            }
        });*/

        rg_anyDisability.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_CH04a_yes) rl_CH04b.setVisibility(View.VISIBLE);
            else {
                rl_CH04b.setVisibility(View.GONE);
                cb_CH04b_op1.setChecked(false);
                cb_CH04b_op2.setChecked(false);
                cb_CH04b_op3.setChecked(false);
                cb_CH04b_op4.setChecked(false);
            }
        });

        rg_helpChild.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_CH08a_yes) rl_CH08b.setVisibility(View.VISIBLE);
            else {
                rl_CH08b.setVisibility(View.GONE);
                rg_mostOften.clearCheck();
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

/*        spinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                et_studentName.clearFocus();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                et_studentName.clearFocus();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/

/*        et_studentName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    addChildNameToQuestion();
                }*//* else {
                    Toast.makeText(getActivity(), "Lost the focus", Toast.LENGTH_LONG).show();
                }*//*
            }
        });*/

        et_studentName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    addChildNameToQuestion();
            }
        });
    }

    public void addChildNameToQuestion(){
        final SpannableStringBuilder sb1 = new SpannableStringBuilder(getString(R.string.str_CH05).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb2 = new SpannableStringBuilder(getString(R.string.str_CH06f).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb3 = new SpannableStringBuilder(getString(R.string.str_CH06g).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb4 = new SpannableStringBuilder(getString(R.string.str_CH07a).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb5 = new SpannableStringBuilder(getString(R.string.str_CH08b).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb6 = new SpannableStringBuilder(getString(R.string.str_CH09a).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb7 = new SpannableStringBuilder(getString(R.string.str_CH09b).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb8 = new SpannableStringBuilder(getString(R.string.str_CH09c).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb9 = new SpannableStringBuilder(getString(R.string.str_CH04a).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb10 = new SpannableStringBuilder(getString(R.string.str_CH07d).replace("[###]", et_studentName.getText()));
        final SpannableStringBuilder sb11 = new SpannableStringBuilder(getString(R.string.str_CH08a).replace("[###]", et_studentName.getText()));
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

        sb1.setSpan(bss, 0, 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb2.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb3.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb4.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb5.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb6.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb7.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb8.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb9.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb10.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb11.setSpan(bss, 0, 6, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        //tv_CHO5.setText(Html.fromHtml(getString(R.string.str_CH05).replace("[###]",et_studentName.getText())));
        tv_CHO4a.setText(sb9);
        tv_CHO5.setText(sb1);
        tv_CHO6f.setText(sb2);
        tv_CHO6g.setText(sb3);
        tv_CHO7a.setText(sb4);
        //tv_CHO7d.setText(getString(R.string.str_CH06d).replace("[###]",et_studentName.getText()));
        tv_CHO8b.setText(sb5);
        tv_CHO9a.setText(sb6);
        tv_CHO9b.setText(sb7);
        tv_CHO9c.setText(sb8);
        tv_CHO7d.setText(sb10);
        tv_CHO8a.setText(sb11);
    }

    private void fetchChildDetails(Modal_Student modalStudent) {
        tv_label.setText(getString(R.string.update_child));
        btn_saveStudent.setVisibility(View.VISIBLE);
        et_studentName.setText(modalStudent.getCH01());

//        spinner_age.setSelection(adapterAge.getPosition(modalStudent.getCH02()+" "+getString(R.string.years)));
        spinner_gender.setSelection(Integer.parseInt(modalStudent.getCH02()));
        spinner_age.setSelection(Integer.parseInt(modalStudent.getCH03())-3);

        if(modalStudent.CH04a.equalsIgnoreCase("1")){
            rg_anyDisability.check(R.id.rb_CH04a_yes);
            rl_CH04b.setVisibility(View.VISIBLE);

            if(modalStudent.CH04b.contains("1,"))
                cb_CH04b_op1.setChecked(true);
            if(modalStudent.CH04b.contains("2,"))
                cb_CH04b_op2.setChecked(true);
            if(modalStudent.CH04b.contains("3,"))
                cb_CH04b_op3.setChecked(true);
            if(modalStudent.CH04b.contains("4,"))
                cb_CH04b_op4.setChecked(true);
        } else {
            rg_anyDisability.check(R.id.rb_CH04a_No);
        }

        if (modalStudent.CH05.equalsIgnoreCase("1")) {
            isStudCurrentlyEnrolled = true;
            rg_isStudentEnrolled.check(R.id.rb_CH05_yes);
            ll_enrolledChildFields.setVisibility(View.VISIBLE);
            rl_CH08a.setVisibility(View.VISIBLE);

            if(modalStudent.CH06a.equalsIgnoreCase("NA"))
                spinner_class.setSelection(adapterClass.getPosition(modalStudent.CH06a));
            else spinner_class.setSelection(Integer.parseInt(modalStudent.CH06a)+1);
            if(modalStudent.CH06b.equalsIgnoreCase("NA"))
                spinner_schoolType.setSelection(adapterSchoolType.getPosition(modalStudent.CH06b));
            else spinner_schoolType.setSelection(Integer.parseInt(modalStudent.CH06b));

            if (modalStudent.CH06c.equalsIgnoreCase("1"))
                rg_instructionLang.check(R.id.rb_CH06c_yes);
            else rg_instructionLang.check(R.id.rb_CH06c_No);

/*            if (modalStudent.CH06d.equalsIgnoreCase("1")){
                rl_kindOfActivities.setVisibility(View.VISIBLE);
                rg_schoolStatus.check(R.id.rb_CH06d_one);

                if(modalStudent.CH06e.equalsIgnoreCase("1"))
                    rg_schoolActivities.check(R.id.rb_CH06e_one);
                else if(modalStudent.CH06e.equalsIgnoreCase("2"))
                    rg_schoolActivities.check(R.id.rb_CH06e_two);
                else if(modalStudent.CH06e.equalsIgnoreCase("3"))
                    rg_schoolActivities.check(R.id.rb_CH06e_three);
            }
            else if (modalStudent.CH06d.equalsIgnoreCase("2"))
                rg_schoolStatus.check(R.id.rb_CH06d_two);
            else if (modalStudent.CH06d.equalsIgnoreCase("3"))
                rg_schoolStatus.check(R.id.rb_CH06d_three);*/

            if (modalStudent.CH06f.equalsIgnoreCase("1"))
                rg_haveTextbooks.check(R.id.rb_CH06f_yes);
            else rg_haveTextbooks.check(R.id.rb_CH06f_No);

            if (modalStudent.CH06g.equalsIgnoreCase("1"))
                rg_gradeRepeat.check(R.id.rb_CH06g_yes);
            else this.rg_gradeRepeat.check(R.id.rb_CH06g_No);

            if (modalStudent.CH08a.equalsIgnoreCase("1")) {
                this.rg_helpChild.check(R.id.rb_CH08a_yes);
                this.rl_CH08b.setVisibility(View.VISIBLE);

                if (modalStudent.CH08b.equalsIgnoreCase("1"))
                    this.rg_mostOften.check(R.id.rb_CH08b_one);
                else if (modalStudent.CH08b.equalsIgnoreCase("2"))
                    this.rg_mostOften.check(R.id.rb_CH08b_two);
                else if (modalStudent.CH08b.equalsIgnoreCase("3"))
                    this.rg_mostOften.check(R.id.rb_CH08b_three);
                else if (modalStudent.CH08b.equalsIgnoreCase("4"))
                    this.rg_mostOften.check(R.id.rb_CH08b_four);

            } else this.rg_helpChild.check(R.id.rb_CH08a_No);

        } else {
            this.isStudCurrentlyEnrolled = false;
            this.rg_isStudentEnrolled.check(R.id.rb_CH05_No);
            this.ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
            if (modalStudent.CH07a.equalsIgnoreCase("1")) {
                this.rg_isStudentEverEnrolled.check(R.id.rb_CH07a_yes);
                this.ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
                this.ll_dropoutFields.setVisibility(View.VISIBLE);
                this.spinner_dropoutYear.setSelection(this.adapterDropYear.getPosition(modalStudent.CH07b));
                if (modalStudent.CH07c.equalsIgnoreCase("NA"))
                    this.spinner_dropout_class.setSelection(this.adapterClass.getPosition(modalStudent.CH07c));
                else this.spinner_dropout_class.setSelection(Integer.parseInt(modalStudent.CH07c) + 1);
                if (modalStudent.CH07d.equalsIgnoreCase("1"))
                    this.rg_dropOutReason.check(R.id.rb_CH07d_one);
                else if (modalStudent.CH07d.equalsIgnoreCase("2"))
                    this.rg_dropOutReason.check(R.id.rb_CH07d_two);
                else if (modalStudent.CH07d.equalsIgnoreCase("3"))
                    this.rg_dropOutReason.check(R.id.rb_CH07d_three);
                else if (modalStudent.CH07d.equalsIgnoreCase("4"))
                    this.rg_dropOutReason.check(R.id.rb_CH07d_four);
                else if (modalStudent.CH07d.equalsIgnoreCase("5"))
                    this.rg_dropOutReason.check(R.id.rb_CH07d_five);
                else if (modalStudent.CH07d.equalsIgnoreCase("6"))
                    this.rg_dropOutReason.check(R.id.rb_CH07d_six);
                else if (modalStudent.CH07d.equalsIgnoreCase("7"))
                    this.rg_dropOutReason.check(R.id.rb_CH07d_seven);
            } else {
                this.ll_dropoutFields.setVisibility(View.GONE);
                this.rg_isStudentEverEnrolled.check(R.id.rb_CH07a_No);
            }
        }

        if (modalStudent.CH09a.equalsIgnoreCase("1"))
            this.rg_paidTution.check(R.id.rb_CH09a_yes);
        else this.rg_paidTution.check(R.id.rb_CH09a_No);

        if (modalStudent.CH09b.equalsIgnoreCase("1"))
            this.rg_readMaterial.check(R.id.rb_CH09b_yes);
        else this.rg_readMaterial.check(R.id.rb_CH09b_No);

        if (modalStudent.CH09c.equalsIgnoreCase("1"))
            this.rg_oftenReads.check(R.id.rb_CH09c_one);
        else if (modalStudent.CH09c.equalsIgnoreCase("2"))
            this.rg_oftenReads.check(R.id.rb_CH09c_two);
        else if (modalStudent.CH09c.equalsIgnoreCase("3"))
            this.rg_oftenReads.check(R.id.rb_CH09c_three);
        else if (modalStudent.CH09c.equalsIgnoreCase("4"))
            this.rg_oftenReads.check(R.id.rb_CH09c_four);
        else if (modalStudent.CH09c.equalsIgnoreCase("5"))
            this.rg_oftenReads.check(R.id.rb_CH09c_five);
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
        this.getCheckedBoxValues();

        if (!this.et_studentName.getText().toString().isEmpty() && this.spinner_age.getSelectedItemPosition() != 0
                && this.spinner_gender.getSelectedItemPosition() != 0 && this.selectedCH04a != 99 && this.selectedCH05 != 99 && this.selectedCH09a != 99
                && this.selectedCH09b != 99 && this.selectedCH09c != 99) {
            this.insertStudent();
        } else {
            Toast.makeText(this.getActivity(), this.getString(R.string.all_fields_mandatory), Toast.LENGTH_SHORT).show();
        }
    }

    private void insertStudent() {

        if (this.isStudCurrentlyEnrolled) {
            this.str_CH06a = this.standard;
            this.str_CH06b = this.schoolType;

            if (this.selectedCH06c == 99 || this.selectedCH06f == 99 || this.selectedCH06g == 99 || this.selectedCH08a == 99) {
                Toast.makeText(this.getActivity(), this.getString(R.string.all_fields_mandatory), Toast.LENGTH_SHORT).show();
            } else {
/*                str_CH06c = rb_CH06c.getText().toString();
                str_CH06d = rb_CH06d.getText().toString();
                if (rb_CH06e == null) str_CH06e = "NA";
                else str_CH06e = rb_CH06e.getText().toString();
                str_CH06f = rb_CH06f.getText().toString();
                str_CH06g = rb_CH06g.getText().toString();
                str_CH08a = rb_CH08a.getText().toString();
                if(rb_CH08b==null) str_CH08b="NA";
                else str_CH08b = rb_CH08b.getText().toString();

                str_CH07a = "NA";
                str_CH07b = "NA";
                str_CH07c = "NA";
                str_CH07d = "NA";*/
                this.str_CH07b = "NA";
                this.str_CH07c = "NA";
                this.str_CH07d = "NA";
                if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                    studentDao.updateStudent(this.et_studentName.getText().toString(), this.gender, this.age,
                            "" + this.selectedCH04a, this.str_disabilityType,
                            "" + this.selectedCH05,
                            this.str_CH06a, this.str_CH06b, "" + this.selectedCH06c,
                            "" + this.selectedCH06f, "" + this.selectedCH06g,
                            "" + this.selectedCH07a, this.str_CH07b, this.str_CH07c, this.str_CH07d,
                            "" + this.selectedCH09a, "" + this.selectedCH09b,
                            "" + this.selectedCH08a, "" + this.selectedCH08b, "" + this.selectedCH09c,
                            this.studId);
                    BackupDatabase.backup(this.getActivity());
                    Toast.makeText(this.getActivity(), this.getString(R.string.child_update_success), Toast.LENGTH_SHORT).show();
                    this.getFragmentManager().popBackStack();
                } else this.insertStud();
            }
        } else {
            this.str_CH06a = "NA";
            this.str_CH06b = "NA";
            this.str_CH06c = "NA";
            this.str_CH06f = "NA";
            this.str_CH06g = "NA";
/*            str_CH06c = "NA";
            str_CH06d = "NA";
            str_CH06e = "NA";
            str_CH06f = "NA";
            str_CH06g = "NA";
            str_CH08a = "NA";
            str_CH08b = "NA";*/

            if (this.selectedCH07a == 99) {
                Toast.makeText(this.getActivity(), this.getString(R.string.all_fields_mandatory), Toast.LENGTH_SHORT).show();
            } else {
                /*                str_CH07a = rb_CH07a.getText().toString();*/
                if (this.selectedCH07a == 1) {
                    this.str_CH07b = this.dropoutYear;
                    this.str_CH07c = this.dropoutStandard;

                    if (this.selectedCH07d == 99) {
                        Toast.makeText(this.getActivity(), this.getString(R.string.all_fields_mandatory), Toast.LENGTH_SHORT).show();
                    } else {
                        /*                        str_CH07d = rb_CH07d.getText().toString();*/
                        if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                            studentDao.updateStudent(this.et_studentName.getText().toString(), this.gender, this.age,
                                    "" + this.selectedCH04a, this.str_disabilityType,
                                    "" + this.selectedCH05, this.str_CH06a, this.str_CH06b, this.str_CH06c,
                                    this.str_CH06f, this.str_CH06g,
                                    "" + this.selectedCH07a, this.str_CH07b, this.str_CH07c, "" + this.selectedCH07d,
                                    "" + this.selectedCH09a, "" + this.selectedCH09b, "" + this.selectedCH08a, "" + this.selectedCH08b,
                                    "" + this.selectedCH09c, this.studId);
                            BackupDatabase.backup(this.getActivity());
                            Toast.makeText(this.getActivity(), this.getString(R.string.child_update_success), Toast.LENGTH_SHORT).show();
                            this.getFragmentManager().popBackStack();
                        } else this.insertStud();
                    }
                } else {
                    this.str_CH07b ="NA";
                    this.str_CH07c ="NA";
                    //str_CH07d="NA";
                    if (this.getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                        studentDao.updateStudent(this.et_studentName.getText().toString(), this.gender, this.age,
                                "" + this.selectedCH04a, this.str_disabilityType,
                                "" + this.selectedCH05, this.str_CH06a, this.str_CH06b, "" + this.selectedCH06c,
                                "" + this.selectedCH06f, "" + this.selectedCH06g,
                                "" + this.selectedCH07a, this.str_CH07b, this.str_CH07c, "" + this.selectedCH07d,
                                "" + this.selectedCH09a, "" + this.selectedCH09b, "" + this.selectedCH08a, "" + this.selectedCH08b,
                                "" + this.selectedCH09c, this.studId);
                        BackupDatabase.backup(this.getActivity());
                        Toast.makeText(this.getActivity(), this.getString(R.string.child_update_success), Toast.LENGTH_SHORT).show();
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

    public void insertStud() {
        final String sId = KIX_Utility.getUUID().toString();
        Log.d("TAG", "insertStudent: " + sId);
        final Modal_Student modal_student = new Modal_Student();
        modal_student.setStudentId(sId);
        modal_student.setCH01(this.et_studentName.getText().toString());
        modal_student.setCH02(this.gender);
        modal_student.setCH03(this.age);
        modal_student.setCH04a("" + this.selectedCH04a);
        modal_student.setCH04b(this.str_disabilityType);
        modal_student.setCH05("" + this.selectedCH05);
        modal_student.setCH06a(this.str_CH06a);
        modal_student.setCH06b(this.str_CH06b);
        modal_student.setCH06c("" + this.selectedCH06c);
        modal_student.setCH06f("" + this.selectedCH06f);
        modal_student.setCH06g("" + this.selectedCH06g);
        modal_student.setCH07a("" + this.selectedCH07a);
        modal_student.setCH07b(this.str_CH07b);
        modal_student.setCH07c(this.str_CH07c);
        modal_student.setCH07d("" + this.selectedCH07d);
        modal_student.setCH09a("" + this.selectedCH09a);
        modal_student.setCH09b("" + this.selectedCH09b);
        modal_student.setCH08a("" + this.selectedCH08a);
        modal_student.setCH08b("" + this.selectedCH08b);
        modal_student.setCH09c("" + this.selectedCH09c);
        modal_student.setParentId("");
        modal_student.setSvrCode(this.surveyorCode);
        modal_student.setHouseholdId(this.householdID);
        modal_student.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_student.setSentFlag(0);

        studentDao.insertStudent(modal_student);
        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), this.getString(R.string.child_add_success), Toast.LENGTH_SHORT).show();
        this.startDialog(modal_student);

    }

    private void getSelectedAge() {
        final int ageNo = this.spinner_age.getSelectedItemPosition()+3;
        this.age = ""+ageNo;
/*        String age1 = spinner_age.getSelectedItem().toString();
        String[] split_age = age1.split(" ");
        if (split_age.length > 1)
            age = String.valueOf(Integer.parseInt(split_age[1]));
            //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, Integer.parseInt(split_age[1]));
        else
            age = "0";
        //FastSave.getInstance().saveInt(PD_Constant.STUDENT_PROFILE_AGE, 0);*/
    }

    private void getSpinnerValues() {
        switch (this.spinner_gender.getSelectedItemPosition()){
            case 1 :
                this.gender = "1"; break;
            case 2 :
                this.gender = "2"; break;
        }

        switch (this.spinner_schoolType.getSelectedItemPosition()){
            case 0 :
                this.schoolType = "NA"; break;
            case 1 :
                this.schoolType = "1"; break;
            case 2 :
                this.schoolType = "2"; break;
            case 3 :
                this.schoolType = "3"; break;
            default:
        }

        if (this.spinner_dropoutYear.getSelectedItemPosition() == 0) this.dropoutYear = "NA";
        else this.dropoutYear = this.spinner_dropoutYear.getSelectedItem().toString();

        switch (this.spinner_class.getSelectedItemPosition()){
            case 0 :
                this.standard = "NA"; break;
            case 1 :
                this.standard = "0"; break;
            case 2 :
                this.standard = "1"; break;
            case 3 :
                this.standard = "2"; break;
            case 4 :
                this.standard = "3"; break;
            case 5 :
                this.standard = "4"; break;
            case 6 :
                this.standard = "5"; break;
            case 7 :
                this.standard = "6"; break;
            default:
        }

        switch (this.spinner_dropout_class.getSelectedItemPosition()){
            case 0 :
                this.dropoutStandard = "NA"; break;
            case 1 :
                this.dropoutStandard = "0"; break;
            case 2 :
                this.dropoutStandard = "1"; break;
            case 3 :
                this.dropoutStandard = "2"; break;
            case 4 :
                this.dropoutStandard = "3"; break;
            case 5 :
                this.dropoutStandard = "4"; break;
            case 6 :
                this.dropoutStandard = "5"; break;
            case 7 :
                this.dropoutStandard = "6"; break;

            default:
        }
    }

    public void getRadioButtonValues() {
/*        int selectedCH04a = rg_anyDisability.getCheckedRadioButtonId();
        int selectedCH05 = rg_isStudentEnrolled.getCheckedRadioButtonId();
        int selectedCH06c = rg_instructionLang.getCheckedRadioButtonId();
        int selectedCH06d = rg_schoolStatus.getCheckedRadioButtonId();
        int selectedCH06e = rg_schoolActivities.getCheckedRadioButtonId();
        int selectedCH06f = rg_haveTextbooks.getCheckedRadioButtonId();
        int selectedCH06g = rg_gradeRepeat.getCheckedRadioButtonId();
        int selectedCH07a = rg_isStudentEverEnrolled.getCheckedRadioButtonId();
        int selectedCH07d = rg_dropOutReason.getCheckedRadioButtonId();
        int selectedCH09a = rg_paidTution.getCheckedRadioButtonId();
        int selectedCH09b = rg_readMaterial.getCheckedRadioButtonId();
        int selectedCH08a = rg_helpChild.getCheckedRadioButtonId();
        int selectedCH08b = rg_mostOften.getCheckedRadioButtonId();
        int selectedCH09c = rg_oftenReads.getCheckedRadioButtonId();*/

/*        rb_CH04a = getView().findViewById(selectedCH04a);
        rb_CH05 = getView().findViewById(selectedCH05);
        rb_CH06c = getView().findViewById(selectedCH06c);
        rb_CH06d = getView().findViewById(selectedCH06d);
        rb_CH06e = getView().findViewById(selectedCH06e);
        rb_CH06f = getView().findViewById(selectedCH06f);
        rb_CH06g = getView().findViewById(selectedCH06g);
        rb_CH07a = getView().findViewById(selectedCH07a);
        rb_CH07d = getView().findViewById(selectedCH07d);
        rb_CH08 = getView().findViewById(selectedCH09a);
        rb_CH09 = getView().findViewById(selectedCH09b);
        rb_CH08a = getView().findViewById(selectedCH08a);
        rb_CH08b = getView().findViewById(selectedCH08b);
        rb_CH09c = getView().findViewById(selectedCH09c);*/
        if (getView().findViewById(rg_anyDisability.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH04a_yes))
            this.selectedCH04a = 1;
        else if (getView().findViewById(rg_anyDisability.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH04a_No))
            this.selectedCH04a = 0;
        if (getView().findViewById(rg_isStudentEnrolled.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH05_yes))
            this.selectedCH05 = 1;
        else if (getView().findViewById(rg_isStudentEnrolled.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH05_No))
            this.selectedCH05 = 0;
        if (getView().findViewById(rg_instructionLang.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH06c_yes))
            this.selectedCH06c = 1;
        else if (getView().findViewById(rg_instructionLang.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH06c_No))
            this.selectedCH06c = 0;

/*        if (this.getView().findViewById(this.rg_schoolStatus.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_CH06d_one))
            selectedCH06d = 1;
        else if (this.getView().findViewById(this.rg_schoolStatus.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_CH06d_two))
            selectedCH06d = 2;
        else if (this.getView().findViewById(this.rg_schoolStatus.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_CH06d_three))
            selectedCH06d = 3;
        if (this.getView().findViewById(this.rg_schoolActivities.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_CH06e_one))
            selectedCH06e = 1;
        else if (this.getView().findViewById(this.rg_schoolActivities.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_CH06e_two))
            selectedCH06e = 2;
        else if (this.getView().findViewById(this.rg_schoolActivities.getCheckedRadioButtonId())
                == this.getView().findViewById(R.id.rb_CH06e_three))
            selectedCH06e = 3;*/
        if (getView().findViewById(rg_haveTextbooks.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH06f_yes))
            this.selectedCH06f = 1;
        else if (getView().findViewById(rg_haveTextbooks.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH06f_No))
            this.selectedCH06f = 0;
        if (getView().findViewById(rg_gradeRepeat.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH06g_yes))
            this.selectedCH06g = 1;
        else if (getView().findViewById(rg_gradeRepeat.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH06g_No))
            this.selectedCH06g = 0;

        if (getView().findViewById(rg_isStudentEverEnrolled.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07a_yes))
            this.selectedCH07a = 1;
        else if (getView().findViewById(rg_isStudentEverEnrolled.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07a_No))
            this.selectedCH07a = 0;
        if (getView().findViewById(rg_dropOutReason.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07d_one))
            this.selectedCH07d = 1;
        else if (getView().findViewById(rg_dropOutReason.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07d_two))
            this.selectedCH07d = 2;
        else if (getView().findViewById(rg_dropOutReason.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07d_three))
            this.selectedCH07d = 3;
        else if (getView().findViewById(rg_dropOutReason.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07d_four))
            this.selectedCH07d = 4;
        else if (getView().findViewById(rg_dropOutReason.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07d_five))
            this.selectedCH07d = 5;
        else if (getView().findViewById(rg_dropOutReason.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07d_six))
            this.selectedCH07d = 6;
        else if (getView().findViewById(rg_dropOutReason.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH07d_seven))
            this.selectedCH07d = 7;

        if (getView().findViewById(rg_paidTution.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09a_yes))
            this.selectedCH09a = 1;
        else if (getView().findViewById(rg_paidTution.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09a_No))
            this.selectedCH09a = 0;
        if (getView().findViewById(rg_readMaterial.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09b_yes))
            this.selectedCH09b = 1;
        else if (getView().findViewById(rg_readMaterial.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09b_No))
            this.selectedCH09b = 0;

        if (getView().findViewById(rg_helpChild.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH08a_yes))
            this.selectedCH08a = 1;
        else if (getView().findViewById(rg_helpChild.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH08a_No))
            this.selectedCH08a = 0;
        if (getView().findViewById(rg_mostOften.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH08b_one))
            this.selectedCH08b = 1;
        else if (getView().findViewById(rg_mostOften.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH08b_two))
            this.selectedCH08b = 2;
        else if (getView().findViewById(rg_mostOften.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH08b_three))
            this.selectedCH08b = 3;
        else if (getView().findViewById(rg_mostOften.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH08b_four))
            this.selectedCH08b = 4;

        if (getView().findViewById(rg_oftenReads.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09c_one))
            this.selectedCH09c = 1;
        else if (getView().findViewById(rg_oftenReads.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09c_two))
            this.selectedCH09c = 2;
        else if (getView().findViewById(rg_oftenReads.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09c_three))
            this.selectedCH09c = 3;
        else if (getView().findViewById(rg_oftenReads.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09c_four))
            this.selectedCH09c = 4;
        else if (getView().findViewById(rg_oftenReads.getCheckedRadioButtonId())
                == getView().findViewById(R.id.rb_CH09c_five))
            this.selectedCH09c = 5;

    }

    public void getCheckedBoxValues() {
        this.str_disabilityType ="";
        if (this.cb_CH04b_op1.isChecked())
            this.str_disabilityType = this.str_disabilityType +"1,";
        if (this.cb_CH04b_op2.isChecked())
            this.str_disabilityType = this.str_disabilityType +"2,";
        if (this.cb_CH04b_op3.isChecked())
            this.str_disabilityType = this.str_disabilityType +"3,";
        if (this.cb_CH04b_op4.isChecked())
            this.str_disabilityType = this.str_disabilityType +"4,";
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
            FastSave.getInstance().saveString(STUDENT_ID, "" + modal_student.getStudentId());
            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, KIX_Utility.getUUID().toString());
                this.markAttendance(modal_student);
            final Intent intent = new Intent(this.getActivity(), WebViewActivity_.class);
            intent.putExtra(Kix_Constant.STUDENT_NAME, modal_student.getCH01());
                this.startActivityForResult(intent, REQUEST_CODE_ASSESSMENT_BACK);
                this.startExamDialog.dismiss();
        });
            this.startExamDialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ASSESSMENT_BACK) {
            this.getFragmentManager().popBackStack();
        }
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
