//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.app_home.profile_new.course_enrollment;

import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.pratham.foundation.R;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class CourseEnrollmentActivity_
    extends CourseEnrollmentActivity
    implements BeanHolder, HasViews, OnViewChangedListener
{
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private final Map<Class<?> , Object> beans_ = new HashMap<Class<?> , Object>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(R.layout.activity_course_enrollment);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T) this.findViewById(id));
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.presenter = CourseEnrollmentPresenter_.getInstance_(this, null);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static CourseEnrollmentActivity_.IntentBuilder_ intent(Context context) {
        return new CourseEnrollmentActivity_.IntentBuilder_(context);
    }

    public static CourseEnrollmentActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new CourseEnrollmentActivity_.IntentBuilder_(fragment);
    }

    public static CourseEnrollmentActivity_.IntentBuilder_ intent(androidx.fragment.app.Fragment supportFragment) {
        return new CourseEnrollmentActivity_.IntentBuilder_(supportFragment);
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
        this.board_spinner = hasViews.internalFindViewById(R.id.board_spinner);
        this.level_spinner = hasViews.internalFindViewById(R.id.level_spinner);
        this.learning_spinner = hasViews.internalFindViewById(R.id.learning_spinner);
        this.subject_spinner = hasViews.internalFindViewById(R.id.subject_spinner);
        this.lang_spinner = hasViews.internalFindViewById(R.id.lang_spinner);
        this.rl_calendar_view = hasViews.internalFindViewById(R.id.rl_calendar_view);
        this.rl_no_data = hasViews.internalFindViewById(R.id.rl_no_data);
        this.spinner_rl = hasViews.internalFindViewById(R.id.spinner_rl);
        this.iv_close_calendar = hasViews.internalFindViewById(R.id.iv_close_calendar);
        this.date_btn = hasViews.internalFindViewById(R.id.date_btn);
        this.tv_Topic = hasViews.internalFindViewById(R.id.tv_Topic);
        this.my_recycler_view = hasViews.internalFindViewById(R.id.course_recycler_view);
        this.rl_add_course = hasViews.internalFindViewById(R.id.rl_add_course);
        this.list_display = hasViews.internalFindViewById(R.id.list_display);
        this.course_date_picker = hasViews.internalFindViewById(R.id.course_date_picker);
        View view_add_course_btn = hasViews.internalFindViewById(R.id.add_course_btn);
        View view_main_back2 = hasViews.internalFindViewById(R.id.main_back2);
        View view_main_back = hasViews.internalFindViewById(R.id.main_back);
        View view_btn_course_time_select = hasViews.internalFindViewById(R.id.btn_course_time_select);

        if (this.date_btn!= null) {
            this.date_btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    CourseEnrollmentActivity_.this.dateBtnClicked();
                }
            }
            );
        }
        if (view_add_course_btn!= null) {
            view_add_course_btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    CourseEnrollmentActivity_.this.onAddNewCourse();
                }
            }
            );
        }
        if (view_main_back2 != null) {
            view_main_back2 .setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    CourseEnrollmentActivity_.this.onMain_back2();
                }
            }
            );
        }
        if (view_main_back!= null) {
            view_main_back.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    CourseEnrollmentActivity_.this.onMain_back();
                }
            }
            );
        }
        if (view_btn_course_time_select!= null) {
            view_btn_course_time_select.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    CourseEnrollmentActivity_.this.onCourseTimeSelected();
                }
            }
            );
        }
        if (this.iv_close_calendar!= null) {
            this.iv_close_calendar.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    CourseEnrollmentActivity_.this.closeCalender();
                }
            }
            );
        }
        initialize();
    }

    @Override
    public void showLoader() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                CourseEnrollmentActivity_.super.showLoader();
            }
        }
        , 0L);
    }

    @Override
    public void dismissLoadingDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                CourseEnrollmentActivity_.super.dismissLoadingDialog();
            }
        }
        , 0L);
    }

    @Override
    public void setProfileName() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                CourseEnrollmentActivity_.super.setProfileName();
            }
        }
        , 0L);
    }

    @Override
    public void noCource() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                CourseEnrollmentActivity_.super.noCource();
            }
        }
        , 0L);
    }

    @Override
    public void courseAdded() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                CourseEnrollmentActivity_.super.courseAdded();
            }
        }
        , 0L);
    }

    @Override
    public void courseAlreadySelected() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                CourseEnrollmentActivity_.super.courseAlreadySelected();
            }
        }
        , 0L);
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<CourseEnrollmentActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private androidx.fragment.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, CourseEnrollmentActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), CourseEnrollmentActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(androidx.fragment.app.Fragment fragment) {
            super(fragment.getActivity(), CourseEnrollmentActivity_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public PostActivityStarter startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    fragment_.startActivityForResult(intent, requestCode, lastOptions);
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        context.startActivity(intent, lastOptions);
                    }
                }
            }
            return new PostActivityStarter(context);
        }
    }
}
