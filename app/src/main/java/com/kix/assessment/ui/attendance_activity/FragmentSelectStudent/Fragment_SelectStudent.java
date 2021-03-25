package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kix.assessment.R;
import com.kix.assessment.custom.flexbox.AlignItems;
import com.kix.assessment.custom.flexbox.FlexDirection;
import com.kix.assessment.custom.flexbox.FlexboxLayoutManager;
import com.kix.assessment.custom.flexbox.JustifyContent;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.attendance_activity.Fragment_AddStudent;
import com.kix.assessment.ui.attendance_activity.Fragment_AddStudent_;
import com.kix.assessment.ui.main_test.WebViewActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

@EFragment(R.layout.fragment_select_student)
public class Fragment_SelectStudent extends Fragment implements ContractStudentList{

    @ViewById(R.id.rv_student)
    RecyclerView rv_student;

    private ArrayList<Modal_Student> students = new ArrayList<>();
    private boolean itemSelected;
    String surveyorCode, householdID;
    Modal_Student add_student = new Modal_Student();

    private StudentListAdapter studentListAdapter;

    public Fragment_SelectStudent() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        Log.e("KIX : ","selectstud");
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        householdID = getArguments().getString(Kix_Constant.HOUSEHOLD_ID);
        students = getArguments() != null ? getArguments().getParcelableArrayList(Kix_Constant.STUDENT_LIST) : null;
        add_student.setStud_Name("Add Student");
        if (!students.contains(add_student)){
            students.add(add_student);
        }
        else{

        }
        initializeAdapter();
    }

    @UiThread
    public void initializeAdapter() {
        if (studentListAdapter == null) {
            studentListAdapter = new StudentListAdapter(students, getActivity(), Fragment_SelectStudent.this);
            rv_student.setHasFixedSize(true);
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getActivity(), FlexDirection.ROW);
            flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
            flexboxLayoutManager.setAlignItems(AlignItems.CENTER);
            rv_student.setLayoutManager(flexboxLayoutManager);
            rv_student.setAdapter(studentListAdapter);
        } else {
            studentListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void itemSelected(int position) {
        Bundle bundle = new Bundle();
        if(position == students.size()-1) {
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            bundle.putString(Kix_Constant.HOUSEHOLD_ID,householdID);
            KIX_Utility.showFragment(getActivity(), new Fragment_AddStudent_(), R.id.attendance_frame,
                    bundle, Fragment_AddStudent.class.getSimpleName());
        }
        else {
            Modal_Student modalStudnet = studentListAdapter.getitem(position);
            FastSave.getInstance().saveString(STUDENT_ID, ""+modalStudnet.getStud_Id());
            Intent intent = new Intent(getActivity(), WebViewActivity_.class);
            intent.putExtra(Kix_Constant.STUDENT_NAME, modalStudnet.Stud_Name);
            startActivity(intent);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_student.setAdapter(null);
        studentListAdapter = null;
        rv_student=null;
    }
}
