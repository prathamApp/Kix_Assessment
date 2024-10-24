//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form;

import java.util.HashMap;
import java.util.Map;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.kix.assessment.R;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class Fragment_AddParentInfoForm_
    extends com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form.Fragment_AddParentInfoForm
    implements BeanHolder, HasViews, OnViewChangedListener
{
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private View contentView_;
    private final Map<Class<?> , Object> beans_ = new HashMap<Class<?> , Object>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T)((contentView_ == null)?null:contentView_.findViewById(id)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(R.layout.fragment_add_parentinformation, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        tv_label = null;
        et_motherName = null;
        spinner_mothersAge = null;
        rg_motherAttendSchool = null;
        spinner_mothersGrade = null;
        rg_motherIncome = null;
        rg_motherWork = null;
        et_fatherName = null;
        spinner_fathersAge = null;
        rg_fatherAttendSchool = null;
        spinner_fathersGrade = null;
        rg_fatherIncome = null;
        rg_fatherWork = null;
        rl_motherWork = null;
        rl_fatherWork = null;
        ll_spinnerMothersGrade = null;
        ll_spinnerFathersGrade = null;
        rg_selectPerson = null;
        ll_selectPerson = null;
        sv_pif = null;
        ll_motherInfo = null;
        ll_fatherInfo = null;
        btn_saveParent = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static Fragment_AddParentInfoForm_.FragmentBuilder_ builder() {
        return new Fragment_AddParentInfoForm_.FragmentBuilder_();
    }

    @Override
    public<T> T getBean(Class<T> key) {
        return ((T) beans_.get(key));
    }

    @Override
    public<T> void putBean(Class<T> key, T value) {
        beans_.put(key, value);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        this.tv_label = hasViews.internalFindViewById(R.id.tv_label);
        this.et_motherName = hasViews.internalFindViewById(R.id.et_mothersName);
        this.spinner_mothersAge = hasViews.internalFindViewById(R.id.spinner_mothersAge);
        this.rg_motherAttendSchool = hasViews.internalFindViewById(R.id.rg_PT01c);
        this.spinner_mothersGrade = hasViews.internalFindViewById(R.id.spinner_mothersGrade);
        this.rg_motherIncome = hasViews.internalFindViewById(R.id.rg_PT01e);
        this.rg_motherWork = hasViews.internalFindViewById(R.id.rg_PT01f);
        this.et_fatherName = hasViews.internalFindViewById(R.id.et_fathersName);
        this.spinner_fathersAge = hasViews.internalFindViewById(R.id.spinner_fathersAge);
        this.rg_fatherAttendSchool = hasViews.internalFindViewById(R.id.rg_PT02c);
        this.spinner_fathersGrade = hasViews.internalFindViewById(R.id.spinner_fathersGrade);
        this.rg_fatherIncome = hasViews.internalFindViewById(R.id.rg_PT02e);
        this.rg_fatherWork = hasViews.internalFindViewById(R.id.rg_PT02f);
        this.rl_motherWork = hasViews.internalFindViewById(R.id.rl_PT01f);
        this.rl_fatherWork = hasViews.internalFindViewById(R.id.rl_PT02f);
        this.ll_spinnerMothersGrade = hasViews.internalFindViewById(R.id.ll_PT01d);
        this.ll_spinnerFathersGrade = hasViews.internalFindViewById(R.id.ll_PT02d);
        this.rg_selectPerson = hasViews.internalFindViewById(R.id.rg_eslectPerson);
        this.ll_selectPerson = hasViews.internalFindViewById(R.id.ll_selectPerson);
        this.sv_pif = hasViews.internalFindViewById(R.id.sv_pif);
        this.ll_motherInfo = hasViews.internalFindViewById(R.id.ll_motherInfo);
        this.ll_fatherInfo = hasViews.internalFindViewById(R.id.ll_fatherInfo);
        this.btn_saveParent = hasViews.internalFindViewById(R.id.btn_saveParent);
        View view_btn_enterDetails = hasViews.internalFindViewById(R.id.btn_enterDetails);

        if (view_btn_enterDetails!= null) {
            view_btn_enterDetails.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddParentInfoForm_.this.enterDetails();
                }
            }
            );
        }
        if (this.btn_saveParent!= null) {
            this.btn_saveParent.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddParentInfoForm_.this.saveParent();
                }
            }
            );
        }
        init();
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<Fragment_AddParentInfoForm_.FragmentBuilder_, com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form.Fragment_AddParentInfoForm>
    {

        @Override
        public com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form.Fragment_AddParentInfoForm build() {
            Fragment_AddParentInfoForm_ fragment_ = new Fragment_AddParentInfoForm_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
