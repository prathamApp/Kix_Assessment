//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.main_test;

import java.util.HashMap;
import java.util.Map;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.kix.assessment.R;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class WebViewActivity_
    extends WebViewActivity
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
        setContentView(R.layout.activity_web_view);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T) this.findViewById(id));
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
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

    public static WebViewActivity_.IntentBuilder_ intent(Context context) {
        return new WebViewActivity_.IntentBuilder_(context);
    }

    public static WebViewActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new WebViewActivity_.IntentBuilder_(fragment);
    }

    public static WebViewActivity_.IntentBuilder_ intent(androidx.fragment.app.Fragment supportFragment) {
        return new WebViewActivity_.IntentBuilder_(supportFragment);
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
        this.webView = hasViews.internalFindViewById(R.id.web_view);
        this.rl_gameover = hasViews.internalFindViewById(R.id.rl_gameover);
        this.btn_next_student = hasViews.internalFindViewById(R.id.btn_next_student);
        this.tv_thankyou = hasViews.internalFindViewById(R.id.tv_thankyou);
        if (this.btn_next_student!= null) {
            this.btn_next_student.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    WebViewActivity_.this.nextStudentClicked();
                }
            }
            );
        }
        init();
    }

    @SuppressLint({
        "JavascriptInterface",
        "SetJavaScriptEnabled"
    })
    @Override
    public void createWebView(final int pos) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                WebViewActivity_.super.createWebView(pos);
            }
        }
        , 0L);
    }

    @Override
    public void showLoader() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                WebViewActivity_.super.showLoader();
            }
        }
        , 0L);
    }

    @Override
    public void dismissLoadingDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                WebViewActivity_.super.dismissLoadingDialog();
            }
        }
        , 0L);
    }

    @Override
    public void nextClicked() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                WebViewActivity_.super.nextClicked();
            }
        }
        , 0L);
    }

    @Override
    public void nextStudentClicked() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                WebViewActivity_.super.nextStudentClicked();
            }
        }
        , 0L);
    }

    @Override
    public void testOverDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                WebViewActivity_.super.testOverDialog();
            }
        }
        , 0L);
    }

    @Override
    public void onNextGame(final String scoredMarks, final String label, final String startTime) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                WebViewActivity_.super.onNextGame(scoredMarks, label, startTime);
            }
        }
        , 0L);
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<WebViewActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private androidx.fragment.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, WebViewActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), WebViewActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(androidx.fragment.app.Fragment fragment) {
            super(fragment.getActivity(), WebViewActivity_.class);
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
