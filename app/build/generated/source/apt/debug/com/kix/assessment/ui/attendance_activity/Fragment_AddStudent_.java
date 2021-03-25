//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.attendance_activity;

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
        spinner_age = null;
        spinner_gender = null;
        spinner_class = null;
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
        this.et_studentName = hasViews.internalFindViewById(R.id.et_studentName);
        this.spinner_age = hasViews.internalFindViewById(R.id.spinner_age);
        this.spinner_gender = hasViews.internalFindViewById(R.id.spinner_gender);
        this.spinner_class = hasViews.internalFindViewById(R.id.spinner_class);
        View view_rl_parentLayout = hasViews.internalFindViewById(R.id.rl_parentLayout);
        View view_btn_saveStudent = hasViews.internalFindViewById(R.id.btn_saveStudent);

        if (view_rl_parentLayout!= null) {
            view_rl_parentLayout.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddStudent_.this.hideKeyboard();
                }
            }
            );
        }
        if (view_btn_saveStudent!= null) {
            view_btn_saveStudent.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddStudent_.this.saveStudent();
                }
            }
            );
        }
        initialize();
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
