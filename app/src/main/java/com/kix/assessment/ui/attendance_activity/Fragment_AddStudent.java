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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


    @ViewById(R.id.btn_saveStudent)
    Button btn_saveStudent;


    String age, surveyorCode, householdID;
    String schoolType, dropoutYear, standard;

    public Dialog startExamDialog;
    Button dlg_yes, dlg_no;

    ArrayAdapter adapterAge, adapterGender, adapterEnrollStatus,
            adapterClass, adapterSchoolType, adapterDropYear;

    Modal_Student modalStudent;

    String studId;

    RadioButton rb_CH04, rb_CH05c, rb_CH05d, rb_CH05e, rb_CH05f, rb_CH06a, rb_CH06b3, rb_CH07, rb_CH08;

    String str_CH05a, str_CH05b, str_CH05c, str_CH05d, str_CH05e, str_CH05f;
    String str_CH06a, str_CH06b1, str_CH06b2, str_CH06b3;

    public boolean isStudCurrentlyEnrolled = false;

    public Fragment_AddStudent() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @AfterViews
    public void initialize() {
        KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));

        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        householdID = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        adapterAge = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.age, R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapterAge);
        adapterGender = ArrayAdapter.createFromResource(getActivity(), R.array.gender, R.layout.support_simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapterGender);
        adapterSchoolType = ArrayAdapter.createFromResource(getActivity(), R.array.school_type, R.layout.support_simple_spinner_dropdown_item);
        spinner_schoolType.setAdapter(adapterSchoolType);
        adapterDropYear = ArrayAdapter.createFromResource(getActivity(), R.array.dropout_year_list, R.layout.support_simple_spinner_dropdown_item);
        spinner_dropoutYear.setAdapter(adapterDropYear);
        adapterClass = ArrayAdapter.createFromResource(getActivity(), R.array.student_class, R.layout.support_simple_spinner_dropdown_item);
        spinner_class.setAdapter(adapterClass);
        spinner_dropout_class.setAdapter(adapterClass);

        if (getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
            studId = getArguments().getString(STUDENT_ID);
            modalStudent = studentDao.getStudentByStudId(studId);
            tv_label.setText(getResources().getString(R.string.edit_child_info));
            et_studentName.setText(modalStudent.getCH01());

            spinner_age.setSelection(adapterAge.getPosition("Age "+modalStudent.getCH03()));
            spinner_gender.setSelection(adapterGender.getPosition(modalStudent.getCH02()));
/*            if(modalStudent.getStudEnrollmentStatus().equalsIgnoreCase(getResources().getString(R.string.enrolled))){
                spinner_schoolType.setSelection(adapterSchoolType.getPosition(modalStudent.getStudSchoolType()));
            } else if(modalStudent.getStudEnrollmentStatus().equalsIgnoreCase(getResources().getString(R.string.drop_out))){
                spinner_dropoutYear.setSelection(adapterDropYear.getPosition(modalStudent.getStudDropoutYear()));
            }*/
        }

        rg_isStudentEnrolled.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.rb_CH04_yes:
                    ll_enrolledChildFields.setVisibility(View.VISIBLE);
                    ll_notEnrolledChildFields.setVisibility(View.GONE);
                    btn_saveStudent.setVisibility(View.VISIBLE);
                    isStudCurrentlyEnrolled = true;
                    break;

                case R.id.rb_CH04_No:
                    ll_enrolledChildFields.setVisibility(View.GONE);
                    ll_notEnrolledChildFields.setVisibility(View.VISIBLE);
                    btn_saveStudent.setVisibility(View.VISIBLE);
                    isStudCurrentlyEnrolled = false;
                    break;
            }
        });

        rg_isStudentEverEnrolled.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.rb_CH06a_yes:
                    ll_dropoutFields.setVisibility(View.VISIBLE);
                    break;

                case R.id.rb_CH06a_No:
                    ll_dropoutFields.setVisibility(View.GONE);
                    break;
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
        if (!et_studentName.getText().toString().isEmpty()) {
            if (getArguments().getString(Kix_Constant.EDIT_STUDENT) != null) {
                getSelectedAge();
                getSpinnerValues();
           /*         studentDao.updateStudent(et_studentName.getText().toString(), age,
                            spinner_gender.getSelectedItem().toString(), standard,
                            spinner_enrollStatue.getSelectedItem().toString(),
                            schoolType, dropoutYear, studId);*/
                Toast.makeText(getActivity(), "Student Edited Successfully!", Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();
            } else
                insertStudent();
        } else {
            Toast.makeText(getActivity(), "Enter Name First.", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertStudent() {
        getSelectedAge();
        getSpinnerValues();
        getRadioButtonValues();

            if (isStudCurrentlyEnrolled) {
                str_CH05a = standard;
                str_CH05b = schoolType;

                if(rb_CH05c==null) str_CH05c="";
                else str_CH05c = rb_CH05c.getText().toString();

                if(rb_CH05d==null) str_CH05d="";
                else str_CH05d = rb_CH05d.getText().toString();

                if(rb_CH05e==null) str_CH05e="";
                else str_CH05e = rb_CH05e.getText().toString();

                if(rb_CH05f==null) str_CH05f="";
                else str_CH05f = rb_CH05f.getText().toString();

                str_CH06a = "";
                str_CH06b1 = "";
                str_CH06b2 = "";
                str_CH06b3 = "";
            } else
                {
                str_CH05a = "";
                str_CH05b = "";
                str_CH05c = "";
                str_CH05d = "";
                str_CH05e = "";
                str_CH05f = "";

                if(rb_CH06a==null) str_CH06a="";
                else str_CH06a = rb_CH06a.getText().toString();

                str_CH06b1 = dropoutYear;
                str_CH06b2 = standard;

                if(rb_CH06b3==null) str_CH06b3="";
                else str_CH06b3 = rb_CH06b3.getText().toString();
            }

        String sId = KIX_Utility.getUUID().toString();
        Log.d("TAG", "insertStudent: " + sId);
        Modal_Student modal_student = new Modal_Student();
        modal_student.setStudentId(sId);
        modal_student.setCH01(et_studentName.getText().toString());
        modal_student.setCH02(spinner_gender.getSelectedItem().toString());
        modal_student.setCH03(age);
        modal_student.setCH04(rb_CH04.getText().toString());
        modal_student.setCH05a(str_CH05a);
        modal_student.setCH05b(str_CH05b);
        modal_student.setCH05c(str_CH05c);
        modal_student.setCH05d(str_CH05d);
        modal_student.setCH05e(str_CH05e);
        modal_student.setCH05f(str_CH05f);
        modal_student.setCH06a(str_CH06a);
        modal_student.setCH06b1(str_CH06b1);
        modal_student.setCH06b2(str_CH06b2);
        modal_student.setCH06b3(str_CH06b3);
        modal_student.setCH07(rb_CH07.getText().toString());
        modal_student.setCH08(rb_CH08.getText().toString());
        modal_student.setSvrCode(surveyorCode);
        modal_student.setHouseholdId(householdID);
        modal_student.setCreatedOn(KIX_Utility.getCurrentDateTime());
        modal_student.setSentFlag(0);

        studentDao.insertStudent(modal_student);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Student Added Successfully!", Toast.LENGTH_SHORT).show();
        startDialog(modal_student);
/*        Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, householdID);
        startActivity(intent);*/
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
    }

    public void getRadioButtonValues(){
        int selectedCH04 = rg_isStudentEnrolled.getCheckedRadioButtonId();
        int selectedCH05c = rg_instructionLang.getCheckedRadioButtonId();
        int selectedCH05d = rg_schoolStatus.getCheckedRadioButtonId();
        int selectedCH05e = rg_schoolActivities.getCheckedRadioButtonId();
        int selectedCH05f = rg_haveTextbooks.getCheckedRadioButtonId();
        int selectedCH06a = rg_isStudentEverEnrolled.getCheckedRadioButtonId();
        int selectedCH06b3 = rg_dropOutReason.getCheckedRadioButtonId();
        int selectedCH07 = rg_everEnrolledInNursary.getCheckedRadioButtonId();
        int selectedCH08 = rg_paidTution.getCheckedRadioButtonId();

        rb_CH04 = getView().findViewById(selectedCH04);
        rb_CH05c = getView().findViewById(selectedCH05c);
        rb_CH05d = getView().findViewById(selectedCH05d);
        rb_CH05e = getView().findViewById(selectedCH05e);
        rb_CH05f = getView().findViewById(selectedCH05f);
        rb_CH06a = getView().findViewById(selectedCH06a);
        rb_CH06b3 = getView().findViewById(selectedCH06b3);
        rb_CH07 = getView().findViewById(selectedCH07);
        rb_CH08 = getView().findViewById(selectedCH08);

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
