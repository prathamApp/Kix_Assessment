//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.attendance_activity;

import java.util.HashMap;
import java.util.Map;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.kix.assessment.R;
import com.kix.assessment.modal_classes.Modal_Student;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

@SuppressLint({
    "NonConstantResourceId"
})
public final class Fragment_AddStudent_
    extends com.kix.assessment.ui.attendance_activity.Fragment_AddStudent
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
            contentView_ = inflater.inflate(R.layout.fragment_add_student, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        et_studentName = null;
        spinner_gender = null;
        spinner_age = null;
        rg_anyDisability = null;
        cb_CH04b_op1 = null;
        cb_CH04b_op2 = null;
        cb_CH04b_op3 = null;
        cb_CH04b_op4 = null;
        rg_isStudentEnrolled = null;
        spinner_class = null;
        spinner_schoolType = null;
        rg_instructionLang = null;
        rg_haveTextbooks = null;
        rg_gradeRepeat = null;
        rg_isStudentEverEnrolled = null;
        spinner_dropoutYear = null;
        spinner_dropout_class = null;
        rg_dropOutReason = null;
        rg_paidTution = null;
        rg_readMaterial = null;
        rg_helpChild = null;
        rg_mostOften = null;
        rg_oftenReads = null;
        ll_spinnerDropout = null;
        ll_schoolType = null;
        tv_label = null;
        rl_CH04b = null;
        ll_enrolledChildFields = null;
        ll_notEnrolledChildFields = null;
        ll_dropoutFields = null;
        rl_CH08a = null;
        rl_CH08b = null;
        btn_saveStudent = null;
        tv_CHO4a = null;
        tv_CHO5 = null;
        tv_CHO6f = null;
        tv_CHO6g = null;
        tv_CHO7a = null;
        tv_CHO7d = null;
        tv_CHO8a = null;
        tv_CHO8b = null;
        tv_CHO9a = null;
        tv_CHO9b = null;
        tv_CHO9c = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static Fragment_AddStudent_.FragmentBuilder_ builder() {
        return new Fragment_AddStudent_.FragmentBuilder_();
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
        this.et_studentName = hasViews.internalFindViewById(R.id.et_CH01);
        this.spinner_gender = hasViews.internalFindViewById(R.id.spn_CH02);
        this.spinner_age = hasViews.internalFindViewById(R.id.spn_CH03);
        this.rg_anyDisability = hasViews.internalFindViewById(R.id.rg_CH04a);
        this.cb_CH04b_op1 = hasViews.internalFindViewById(R.id.cb_CH04b_op1);
        this.cb_CH04b_op2 = hasViews.internalFindViewById(R.id.cb_CH04b_op2);
        this.cb_CH04b_op3 = hasViews.internalFindViewById(R.id.cb_CH04b_op3);
        this.cb_CH04b_op4 = hasViews.internalFindViewById(R.id.cb_CH04b_op4);
        this.rg_isStudentEnrolled = hasViews.internalFindViewById(R.id.rg_CH05);
        this.spinner_class = hasViews.internalFindViewById(R.id.spn_CH06a);
        this.spinner_schoolType = hasViews.internalFindViewById(R.id.spn_CH06b);
        this.rg_instructionLang = hasViews.internalFindViewById(R.id.rg_CH06c);
        this.rg_haveTextbooks = hasViews.internalFindViewById(R.id.rg_CH06f);
        this.rg_gradeRepeat = hasViews.internalFindViewById(R.id.rg_CH06g);
        this.rg_isStudentEverEnrolled = hasViews.internalFindViewById(R.id.rg_CH07a);
        this.spinner_dropoutYear = hasViews.internalFindViewById(R.id.spn_CH07b);
        this.spinner_dropout_class = hasViews.internalFindViewById(R.id.spn_CH07c);
        this.rg_dropOutReason = hasViews.internalFindViewById(R.id.rg_CH07d);
        this.rg_paidTution = hasViews.internalFindViewById(R.id.rg_CH09a);
        this.rg_readMaterial = hasViews.internalFindViewById(R.id.rg_CH09b);
        this.rg_helpChild = hasViews.internalFindViewById(R.id.rg_CH08a);
        this.rg_mostOften = hasViews.internalFindViewById(R.id.rg_CH08b);
        this.rg_oftenReads = hasViews.internalFindViewById(R.id.rg_CH09c);
        this.ll_spinnerDropout = hasViews.internalFindViewById(R.id.ll_spinnerDropout);
        this.ll_schoolType = hasViews.internalFindViewById(R.id.ll_schoolType);
        this.tv_label = hasViews.internalFindViewById(R.id.tv_label);
        this.rl_CH04b = hasViews.internalFindViewById(R.id.rl_CH04b);
        this.ll_enrolledChildFields = hasViews.internalFindViewById(R.id.ll_enrolledChildFields);
        this.ll_notEnrolledChildFields = hasViews.internalFindViewById(R.id.ll_notEnrolledChildFields);
        this.ll_dropoutFields = hasViews.internalFindViewById(R.id.ll_sub_CH07b);
        this.rl_CH08a = hasViews.internalFindViewById(R.id.rl_CH08a);
        this.rl_CH08b = hasViews.internalFindViewById(R.id.rl_CH08b);
        this.btn_saveStudent = hasViews.internalFindViewById(R.id.btn_saveStudent);
        this.tv_CHO4a = hasViews.internalFindViewById(R.id.lbl_CH04a);
        this.tv_CHO5 = hasViews.internalFindViewById(R.id.lbl_CH05);
        this.tv_CHO6f = hasViews.internalFindViewById(R.id.lbl_CH06f);
        this.tv_CHO6g = hasViews.internalFindViewById(R.id.lbl_CH06g);
        this.tv_CHO7a = hasViews.internalFindViewById(R.id.lbl_CH07a);
        this.tv_CHO7d = hasViews.internalFindViewById(R.id.lbl_reasonToDrop);
        this.tv_CHO8a = hasViews.internalFindViewById(R.id.lbl_CH08a);
        this.tv_CHO8b = hasViews.internalFindViewById(R.id.lbl_CH08b);
        this.tv_CHO9a = hasViews.internalFindViewById(R.id.lbl_CH09a);
        this.tv_CHO9b = hasViews.internalFindViewById(R.id.lbl_CH09b);
        this.tv_CHO9c = hasViews.internalFindViewById(R.id.lbl_CH09c);
        View view_rl_parentLayout = hasViews.internalFindViewById(R.id.rl_parentLayout);

        if (view_rl_parentLayout!= null) {
            view_rl_parentLayout.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddStudent_.this.hideKeyboard();
                }
            }
            );
        }
        if (this.btn_saveStudent!= null) {
            this.btn_saveStudent.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddStudent_.this.saveStudent();
                }
            }
            );
        }
        if (this.spinner_age!= null) {
            ((AdapterView<?> ) this.spinner_age).setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Fragment_AddStudent_.this.ageSelect(false);
                }

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Fragment_AddStudent_.this.ageSelect(true);
                }
            }
            );
        }
        if (this.spinner_gender!= null) {
            ((AdapterView<?> ) this.spinner_gender).setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Fragment_AddStudent_.this.genderSelect(false);
                }

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Fragment_AddStudent_.this.genderSelect(true);
                }
            }
            );
        }
        initialize();
    }

    @Override
    public void startDialog(final Modal_Student modal_student) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                Fragment_AddStudent_.super.startDialog(modal_student);
            }
        }
        , 0L);
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<Fragment_AddStudent_.FragmentBuilder_, com.kix.assessment.ui.attendance_activity.Fragment_AddStudent>
    {

        @Override
        public com.kix.assessment.ui.attendance_activity.Fragment_AddStudent build() {
            Fragment_AddStudent_ fragment_ = new Fragment_AddStudent_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
