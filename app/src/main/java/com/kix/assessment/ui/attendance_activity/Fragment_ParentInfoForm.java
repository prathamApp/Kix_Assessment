package com.kix.assessment.ui.attendance_activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.kix.assessment.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

@EFragment(R.layout.fragment_parent_info_form)
public class Fragment_ParentInfoForm extends Fragment {

    @ViewById(R.id.spinner_age)
    Spinner spinner_age;

    @ViewById(R.id.spinner_grade)
    Spinner spinner_grade;

    @ViewById(R.id.ll_PT01a)
    LinearLayout ll_PT01a;

    @ViewById(R.id.ll_PT02a)
    LinearLayout ll_PT02a;

    @ViewById(R.id.rg_parent)
    RadioGroup rg_parent;

    ArrayAdapter ageAdapter, gradeAdapter;

    public Fragment_ParentInfoForm() {
        // Required empty public constructor
    }

    @AfterViews
    public void init(){
        ageAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.parentAge, R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(ageAdapter);
        gradeAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.parentGrade, R.layout.support_simple_spinner_dropdown_item);
        spinner_grade.setAdapter(gradeAdapter);

        rg_parent.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId){
                case R.id.rb_mother :
                    ll_PT01a.setVisibility(View.VISIBLE);
                    ll_PT02a.setVisibility(View.GONE);
                    break;

                case R.id.rb_father :
                    ll_PT01a.setVisibility(View.GONE);
                    ll_PT02a.setVisibility(View.VISIBLE);
                    break;
            }
        });
    }

}