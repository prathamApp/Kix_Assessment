//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.app_home.learning_fragment.attendance_bottom_fragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pratham.foundation.R;
import com.pratham.foundation.database.domain.Student;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class AttendanceBottomFragment_
    extends com.pratham.foundation.ui.app_home.learning_fragment.attendance_bottom_fragment.AttendanceBottomFragment
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
            contentView_ = inflater.inflate(R.layout.attendance_bottom_fragment, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        rl_students = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.presenter = AttendanceStudentsPresenter_.getInstance_(getActivity(), this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static AttendanceBottomFragment_.FragmentBuilder_ builder() {
        return new AttendanceBottomFragment_.FragmentBuilder_();
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
        this.rl_students = hasViews.internalFindViewById(R.id.students_recyclerView);
        initialize();
    }

    @Override
    public void setStudentList(final List<Student> fragmentModalsList) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.setStudentList(fragmentModalsList);
            }
        }
        , 0L);
    }

    @Override
    public void clearList() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.clearList();
            }
        }
        , 0L);
    }

    @Override
    public void notifyStudentAdapter() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.notifyStudentAdapter();
            }
        }
        , 0L);
    }

    @Override
    public void showProgressDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.showProgressDialog();
            }
        }
        , 0L);
    }

    @Override
    public void dismissProgressDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.dismissProgressDialog();
            }
        }
        , 0L);
    }

    @Override
    public void dismissProgressDialog2() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.dismissProgressDialog2();
            }
        }
        , 0L);
    }

    @Override
    public void onStudentClick(final Student bottomFragmentModal, final int position) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.onStudentClick(bottomFragmentModal, position);
            }
        }
        , 0L);
    }

    @SuppressLint({
        "SetTextI18n"
    })
    @Override
    public void downloadAssessmentAppDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                AttendanceBottomFragment_.super.downloadAssessmentAppDialog();
            }
        }
        , 0L);
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<AttendanceBottomFragment_.FragmentBuilder_, com.pratham.foundation.ui.app_home.learning_fragment.attendance_bottom_fragment.AttendanceBottomFragment>
    {

        @Override
        public com.pratham.foundation.ui.app_home.learning_fragment.attendance_bottom_fragment.AttendanceBottomFragment build() {
            AttendanceBottomFragment_ fragment_ = new AttendanceBottomFragment_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
