package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kix.assessment.KIXApplication;
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

    @ViewById(R.id.rl_parentLayout)
    RelativeLayout rl_parentLayout;
    @ViewById(R.id.tv_PT01a_val)
    TextView tv_mothersName;
/*    @ViewById(R.id.tv_PT01b_val)
    TextView tv_mothersAge;*/
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
/*    @ViewById(R.id.tv_PT02b_val)
    TextView tv_fathersAge;*/
    @ViewById(R.id.tv_PT02c_val)
    TextView tv_fatherAttendSchool;
    @ViewById(R.id.tv_PT02d_val)
    TextView tv_fathersGrade;
    @ViewById(R.id.tv_PT02e_val)
    TextView tv_fatherWorks;
    @ViewById(R.id.tv_PT02f_val)
    TextView tv_fathersWorkKind;

    String parentId;

    public Fragment_ParentInformation() {
        // Required empty public constructor
    }

    @AfterViews
    public void init() {
        if(KIXApplication.app_country.equalsIgnoreCase("Pakistan")) {
            rl_parentLayout.setTextDirection(View.TEXT_DIRECTION_RTL);
            rl_parentLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }

        this.parentId = this.getArguments().getString(Kix_Constant.PARENT_ID);
        //Modal_Student modalStudent = studentDao.getStudentByStudId(studentId);
        Modal_PIF modalPif = parentInformationDao.getPIFbyParentId(parentId);

//        String studentName = "NA";
//        studentName = modalStudent.CH01;

        tv_mothersName.setText(modalPif.PT01a);
        //tv_mothersAge.setText(modalPif.PT01b);
        if (modalPif.PT01c.equalsIgnoreCase("1")) {
            tv_motherAttendSchool.setText(getString(R.string.yes));
            tv_motherAttendSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        }
        else if (modalPif.PT01c.equalsIgnoreCase("0")) {
            tv_motherAttendSchool.setText(getString(R.string.no));
            tv_motherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        }
        else {
            tv_motherAttendSchool.setText("NA");
            tv_motherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        }

        if (modalPif.PT01d.equalsIgnoreCase("1"))
            tv_mothersGrade.setText(getString(R.string.str_PT0d_one));
        else if (modalPif.PT01d.equalsIgnoreCase("2"))
            tv_mothersGrade.setText(getString(R.string.str_PT0d_two));
        else if (modalPif.PT01d.equalsIgnoreCase("3"))
            tv_mothersGrade.setText(getString(R.string.str_PT0d_three));
        else if (modalPif.PT01d.equalsIgnoreCase("4"))
            tv_mothersGrade.setText(getString(R.string.str_PT0d_four));
        else tv_mothersGrade.setText("NA");

        if (modalPif.PT01e.equalsIgnoreCase("1")) {
            tv_motherWorks.setText(getString(R.string.yes));
            tv_motherWorks.setBackgroundResource(R.drawable.rounder_bg_green);
        }
        else if (modalPif.PT01e.equalsIgnoreCase("0")) {
            tv_motherWorks.setText(getString(R.string.no));
            tv_motherWorks.setBackgroundResource(R.drawable.rounded_bg_red);
        }
        else {
            tv_motherWorks.setText("NA");
            tv_motherWorks.setBackgroundResource(R.drawable.rounded_bg_red);
        }

        if (modalPif.PT01f.equalsIgnoreCase("1"))
            tv_mothersWorkKind.setText(getString(R.string.str_PT01f_one));
        else if (modalPif.PT01f.equalsIgnoreCase("2"))
            tv_mothersWorkKind.setText(getString(R.string.str_PT01f_two));
        else if (modalPif.PT01f.equalsIgnoreCase("3"))
            tv_mothersWorkKind.setText(getString(R.string.str_PT01f_three));
        else if (modalPif.PT01f.equalsIgnoreCase("4"))
            tv_mothersWorkKind.setText(getString(R.string.str_PT01f_four));
        else tv_mothersWorkKind.setText("NA");

        //tv_mothersGrade.setText(modalPif.PT01d);
        //tv_motherWorks.setText(modalPif.PT01e);
        //tv_mothersWorkKind.setText(modalPif.PT01f);
        tv_fathersName.setText(modalPif.PT02a);
        //tv_fathersAge.setText(modalPif.PT02b);
/*        tv_fatherAttendSchool.setText(modalPif.PT02c);
        tv_fathersGrade.setText(modalPif.PT02d);
        tv_fatherWorks.setText(modalPif.PT02e);
        tv_fathersWorkKind.setText(modalPif.PT02f);*/
        if (modalPif.PT02c.equalsIgnoreCase("1")) {
            tv_fatherAttendSchool.setText(getString(R.string.yes));
            tv_fatherAttendSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        }
        else if (modalPif.PT02c.equalsIgnoreCase("0")) {
            tv_fatherAttendSchool.setText(getString(R.string.no));
            tv_fatherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        }
        else {
            tv_fatherAttendSchool.setText("NA");
            tv_fatherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        }

        if (modalPif.PT02d.equalsIgnoreCase("1"))
            tv_fathersGrade.setText(getString(R.string.str_PT0d_one));
        else if (modalPif.PT02d.equalsIgnoreCase("2"))
            tv_fathersGrade.setText(getString(R.string.str_PT0d_two));
        else if (modalPif.PT02d.equalsIgnoreCase("3"))
            tv_fathersGrade.setText(getString(R.string.str_PT0d_three));
        else if (modalPif.PT02d.equalsIgnoreCase("4"))
            tv_fathersGrade.setText(getString(R.string.str_PT0d_four));
        else tv_fathersGrade.setText("NA");

        if (modalPif.PT02e.equalsIgnoreCase("1")) {
            tv_fatherWorks.setText(getString(R.string.yes));
            tv_fatherWorks.setBackgroundResource(R.drawable.rounder_bg_green);
        }
        else if (modalPif.PT02e.equalsIgnoreCase("0")) {
            tv_fatherWorks.setText(getString(R.string.no));
            tv_fatherWorks.setBackgroundResource(R.drawable.rounded_bg_red);
        }
        else {
            tv_fatherWorks.setText("NA");
            tv_fatherWorks.setBackgroundResource(R.drawable.rounded_bg_red);
        }

        if (modalPif.PT02f.equalsIgnoreCase("1"))
            tv_fathersWorkKind.setText(getString(R.string.str_PT01f_one));
        else if (modalPif.PT02f.equalsIgnoreCase("2"))
            tv_fathersWorkKind.setText(getString(R.string.str_PT01f_two));
        else if (modalPif.PT02f.equalsIgnoreCase("3"))
            tv_fathersWorkKind.setText(getString(R.string.str_PT01f_three));
        else if (modalPif.PT02f.equalsIgnoreCase("4"))
            tv_fathersWorkKind.setText(getString(R.string.str_PT01f_four));
        else tv_fathersWorkKind.setText("NA");


/*        if (modalPif.PT01c.equalsIgnoreCase("Yes"))
            tv_motherAttendSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_motherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        if (modalPif.PT01e.equalsIgnoreCase("Yes"))
            tv_motherWorks.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_motherWorks.setBackgroundResource(R.drawable.rounded_bg_red);
        if (modalPif.PT02c.equalsIgnoreCase("Yes"))
            tv_fatherAttendSchool.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_fatherAttendSchool.setBackgroundResource(R.drawable.rounded_bg_red);
        if (modalPif.PT02e.equalsIgnoreCase("Yes"))
            tv_fatherWorks.setBackgroundResource(R.drawable.rounder_bg_green);
        else tv_fatherWorks.setBackgroundResource(R.drawable.rounded_bg_red);*/
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @Click(R.id.fab_Edit_PIF)
    public void EditClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.PARENT_ID, parentId);
        bundle.putString(Kix_Constant.EDIT_PARENT, Kix_Constant.EDIT_PARENT);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddParentInfoForm_(), R.id.attendance_frame,
                bundle, Fragment_AddParentInfoForm.class.getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}