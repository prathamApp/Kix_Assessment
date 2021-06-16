package com.kix.assessment.ui.attendance_activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Student;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

import static com.kix.assessment.KIXApplication.studentDao;

@EFragment(R.layout.fragment_add_student)
public class Fragment_AddStudent extends Fragment {

    @ViewById(R.id.et_studentName)
    EditText et_studentName;
    @ViewById(R.id.spinner_age)
    Spinner spinner_age;
    @ViewById(R.id.spinner_gender)
    Spinner spinner_gender;
    @ViewById(R.id.spinner_class)
    Spinner spinner_class;
    @ViewById(R.id.spinner_enrollStatus)
    Spinner spinner_enrollStatue;
    @ViewById(R.id.spinner_schoolType)
    Spinner spinner_schoolType;
    @ViewById(R.id.spinner_dropoutYear)
    Spinner spinner_dropoutYear;

    @ViewById(R.id.ll_spinnersByStatus)
    LinearLayout ll_spinnerByStatus;

    String age, surveyorCode, householdID;
    String schoolType, dropoutYear, standard;

    public Fragment_AddStudent() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        ll_spinnerByStatus.setVisibility(View.GONE);
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        householdID = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        ArrayAdapter adapterAge = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.age, R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapterAge);
        ArrayAdapter adapterGender = ArrayAdapter.createFromResource(getActivity(), R.array.gender, R.layout.support_simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapterGender);
        ArrayAdapter adapterClass = ArrayAdapter.createFromResource(getActivity(), R.array.student_class, R.layout.support_simple_spinner_dropdown_item);
        spinner_class.setAdapter(adapterClass);
        ArrayAdapter adapterEnrollStatus = ArrayAdapter.createFromResource(getActivity(), R.array.enrollment_status, R.layout.support_simple_spinner_dropdown_item);
        spinner_enrollStatue.setAdapter(adapterEnrollStatus);
        ArrayAdapter adapterSchoolType = ArrayAdapter.createFromResource(getActivity(), R.array.school_type, R.layout.support_simple_spinner_dropdown_item);
        spinner_schoolType.setAdapter(adapterSchoolType);
        ArrayAdapter adapterDropYear = ArrayAdapter.createFromResource(getActivity(), R.array.dropout_year, R.layout.support_simple_spinner_dropdown_item);
        spinner_dropoutYear.setAdapter(adapterDropYear);

        spinner_enrollStatue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Enrolled"))
                {
                    ll_spinnerByStatus.setVisibility(View.VISIBLE);
                    spinner_dropoutYear.setVisibility(View.GONE);
                    spinner_schoolType.setVisibility(View.VISIBLE);
                }
                else if(selectedItem.equals("Never Enrolled"))
                {
                    ll_spinnerByStatus.setVisibility(View.GONE);
                }
                if(selectedItem.equals("Drop Out"))
                {
                    ll_spinnerByStatus.setVisibility(View.VISIBLE);
                    spinner_schoolType.setVisibility(View.GONE);
                    spinner_dropoutYear.setVisibility(View.VISIBLE);
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    @Click(R.id.rl_parentLayout)
    public void hideKeyboard() {
        KIX_Utility.HideInputKeypad(getActivity());
    }

    @Click(R.id.btn_saveStudent)
    public void saveStudent() {
        if(spinner_enrollStatue.getSelectedItemPosition()==0)
            Toast.makeText(getActivity(), "Select Enrollment Status.", Toast.LENGTH_SHORT).show();
        else
            insertStudent();
    }

    private void insertStudent() {
        getSelectedAge();
        getSpinnerValues();
        Modal_Student modal_student = new Modal_Student();
        modal_student.setStud_Id("" + KIX_Utility.getUUID());
        modal_student.setStudName(et_studentName.getText().toString());
        modal_student.setStudAge(age);
        modal_student.setStudGender(spinner_gender.getSelectedItem().toString());
        modal_student.setStudClass(standard);
        modal_student.setStudEnrollmentStatus(spinner_enrollStatue.getSelectedItem().toString());
        modal_student.setStudSchoolType(schoolType);
        modal_student.setStudDropoutYear(dropoutYear);
        modal_student.setSvrCode(surveyorCode);
        modal_student.setHousehold_ID(householdID);
        modal_student.setSentFlag(0);
        studentDao.insertStudent(modal_student);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Student Added Successfully!", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
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
        if(spinner_schoolType.getSelectedItemPosition()==0) schoolType = "NA";
        else schoolType = spinner_schoolType.getSelectedItem().toString();

        if(spinner_dropoutYear.getSelectedItemPosition()==0) dropoutYear = "NA";
        else dropoutYear = spinner_dropoutYear.getSelectedItem().toString();

        if(spinner_class.getSelectedItemPosition()==0) standard = "NA";
        else standard = spinner_class.getSelectedItem().toString();
    }
}
