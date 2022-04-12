package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.widget.TextView;

import com.kix.assessment.R;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_PIF;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.household_activity.household_information_form.Fragment_AddHouseholdInformation;
import com.kix.assessment.ui.household_activity.household_information_form.Fragment_AddHouseholdInformation_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static com.kix.assessment.KIXApplication.parentInformationDao;
import static com.kix.assessment.KIXApplication.studentDao;

@EFragment(R.layout.fragment_parent_information)
public class Fragment_ParentInformation extends Fragment {

    @ViewById(R.id.tv_PT01a_val)
    TextView tv_mothersName;
    @ViewById(R.id.tv_PT01b_val)
    TextView tv_mothersAge;
    @ViewById(R.id.tv_PT01c_val)
    TextView tv_motherAttendSchool;
    @ViewById(R.id.tv_PT01d_val)
    TextView tv_mothersGrade;
    @ViewById(R.id.tv_PT01e_val)
    TextView tv_motherWorks;
    @ViewById(R.id.tv_PT01f_val)
    TextView tv_mothersWorkKind;
    @ViewById(R.id.tv_PT02a_val)
    TextView tv_fathersName;
    @ViewById(R.id.tv_PT02b_val)
    TextView tv_fathersAge;
    @ViewById(R.id.tv_PT02c_val)
    TextView tv_fatherAttendSchool;
    @ViewById(R.id.tv_PT02d_val)
    TextView tv_fathersGrade;
    @ViewById(R.id.tv_PT02e_val)
    TextView tv_fatherWorks;
    @ViewById(R.id.tv_PT02f_val)
    TextView tv_fathersWorkKind;

    String studentId;

    public Fragment_ParentInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void init(){
        this.studentId = this.getArguments().getString(Kix_Constant.STUDENT_ID);
        Modal_Student modalStudent = studentDao.getStudentByStudId(studentId);
        Modal_PIF modalPif = parentInformationDao.getPIFbyStudentId(studentId);

        String studentName = "NA";
        studentName = modalStudent.CH01;

        tv_mothersName.setText(modalPif.PT01a);
        tv_mothersAge.setText(modalPif.PT01b);
        tv_motherAttendSchool.setText(modalPif.PT01c);
        tv_mothersGrade.setText(modalPif.PT01d);
        tv_motherWorks.setText(modalPif.PT01e);
        tv_mothersWorkKind.setText(modalPif.PT01f);
        tv_fathersName.setText(modalPif.PT02a);
        tv_fathersAge.setText(modalPif.PT02b);
        tv_fatherAttendSchool.setText(modalPif.PT02c);
        tv_fathersGrade.setText(modalPif.PT02d);
        tv_fatherWorks.setText(modalPif.PT02e);
        tv_fathersWorkKind.setText(modalPif.PT02f);

        if(modalPif.PT01c.equalsIgnoreCase("Yes")) tv_motherAttendSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_motherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalPif.PT01e.equalsIgnoreCase("Yes")) tv_motherWorks.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_motherWorks.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalPif.PT02c.equalsIgnoreCase("Yes")) tv_fatherAttendSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_fatherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        if(modalPif.PT02e.equalsIgnoreCase("Yes")) tv_fatherWorks.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_fatherWorks.setBackgroundResource(R.drawable.rounded_bg_red);
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @Click(R.id.fab_Edit_PIF)
    public void EditClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.STUDENT_ID, studentId);
        bundle.putString(Kix_Constant.EDIT_PARENT,Kix_Constant.EDIT_PARENT);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddParentInfoForm_(), R.id.attendance_frame,
                bundle, Fragment_AddParentInfoForm.class.getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}