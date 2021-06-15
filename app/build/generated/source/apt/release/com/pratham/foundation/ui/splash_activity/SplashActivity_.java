//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.splash_activity;

import java.util.HashMap;
import java.util.Map;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.pratham.foundation.R;
import com.pratham.foundation.modalclasses.EventMessage;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;
import org.greenrobot.eventbus.Subscribe;

public final class SplashActivity_
    extends SplashActivity
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
        setContentView(R.layout.activity_splash);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T) this.findViewById(id));
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.splashPresenter = SplashPresenter_.getInstance_(this, null);
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

    public static SplashActivity_.IntentBuilder_ intent(Context context) {
        return new SplashActivity_.IntentBuilder_(context);
    }

    public static SplashActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new SplashActivity_.IntentBuilder_(fragment);
    }

    public static SplashActivity_.IntentBuilder_ intent(androidx.fragment.app.Fragment supportFragment) {
        return new SplashActivity_.IntentBuilder_(supportFragment);
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
        this.splash_root = hasViews.internalFindViewById(R.id.splash_root);
        this.tv_typer = hasViews.internalFindViewById(R.id.tv_typer);
        init();
    }

    @Override
    public void showButton() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.showButton();
            }
        }
        , 0L);
    }

    @Override
    public void showUpdateDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.showUpdateDialog();
            }
        }
        , 0L);
    }

    @Override
    public void startApp() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.startApp();
            }
        }
        , 0L);
    }

    @Override
    public void showProgressDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.showProgressDialog();
            }
        }
        , 0L);
    }

    @Override
    public void dismissProgressDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.dismissProgressDialog();
            }
        }
        , 0L);
    }

    @SuppressLint({
        "SetTextI18n"
    })
    @Override
    public void showExitDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.showExitDialog();
            }
        }
        , 0L);
    }

    @Override
    public void preShowBtn() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.preShowBtn();
            }
        }
        , 0L);
    }

    @Override
    public void gotoNextActivity() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.gotoNextActivity();
            }
        }
        , 0L);
    }

    @Override
    public void show_STT_Dialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.show_STT_Dialog();
            }
        }
        , 0L);
    }

    @SuppressLint({
        "SetTextI18n"
    })
    @Subscribe
    @Override
    public void messageRecieved(final EventMessage message) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.messageRecieved(message);
            }
        }
        , 0L);
    }

    @Override
    public void showBottomFragment() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                SplashActivity_.super.showBottomFragment();
            }
        }
        , 0L);
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<SplashActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private androidx.fragment.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, SplashActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), SplashActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(androidx.fragment.app.Fragment fragment) {
            super(fragment.getActivity(), SplashActivity_.class);
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