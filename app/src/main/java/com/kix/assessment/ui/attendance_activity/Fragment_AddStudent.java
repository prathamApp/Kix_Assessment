package com.kix.assessment.ui.attendance_activity;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

import androidx.fragment.app.Fragment;

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

    String age, surveyorCode, householdID;

    public Fragment_AddStudent() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        householdID = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.age, R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapter);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.gender, R.layout.support_simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter2);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.student_class, R.layout.support_simple_spinner_dropdown_item);
        spinner_class.setAdapter(adapter3);
    }

    @Click(R.id.rl_parentLayout)
    public void hideKeyboard(){
        KIX_Utility.HideInputKeypad(getActivity());
    }

    @Click(R.id.btn_saveStudent)
    public void saveStudent(){
        insertStudent();
    }

    private void insertStudent() {
        getSelectedAge();
        Modal_Student modal_student = new Modal_Student();
        modal_student.setStud_Id(""+ KIX_Utility.getUUID());
        modal_student.setStud_Name(et_studentName.getText().toString());
        modal_student.setStud_Age(age);
        modal_student.setStud_Gender(spinner_gender.getSelectedItem().toString());
        modal_student.setStud_Class(spinner_class.getSelectedItem().toString());
        modal_student.setSvr_Code(surveyorCode);
        modal_student.setHousehold_ID(householdID);
        modal_student.setSentFlag(0);
        studentDao.insertStudent(modal_student);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), "Student Added Successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), Activity_Attendance_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.HOUSEHOLD_ID, householdID);
        startActivity(intent);
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
}
