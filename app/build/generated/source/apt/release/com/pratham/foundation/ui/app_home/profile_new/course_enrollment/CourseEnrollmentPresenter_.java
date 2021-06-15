//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.app_home.profile_new.course_enrollment;

import java.util.Calendar;
import android.content.Context;
import com.pratham.foundation.database.domain.ContentTable;
import org.androidannotations.api.BackgroundExecutor;

public final class CourseEnrollmentPresenter_
    extends CourseEnrollmentPresenter
{
    private Context context_;
    private Object rootFragment_;

    private CourseEnrollmentPresenter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private CourseEnrollmentPresenter_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static CourseEnrollmentPresenter_ getInstance_(Context context) {
        return new CourseEnrollmentPresenter_(context);
    }

    public static CourseEnrollmentPresenter_ getInstance_(Context context, Object rootFragment) {
        return new CourseEnrollmentPresenter_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void addCourseToDb(final String week, final ContentTable selectedCourse, final Calendar startDate, final Calendar endDate) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    CourseEnrollmentPresenter_.super.addCourseToDb(week, selectedCourse, startDate, endDate);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }
}