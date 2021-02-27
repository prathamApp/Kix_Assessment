//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.admin_panel.fragment_admin_panel.tab_usage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.pratham.foundation.R;
import com.pratham.foundation.modalclasses.Modal_ResourcePlayedByGroups;
import com.pratham.foundation.modalclasses.Modal_TotalDaysGroupsPlayed;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class TabUsageActivity_
    extends TabUsageActivity
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
        setContentView(R.layout.activity_tab_usage);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T) this.findViewById(id));
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.presenter = TabUsagePresenter_.getInstance_(this, null);
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

    public static TabUsageActivity_.IntentBuilder_ intent(Context context) {
        return new TabUsageActivity_.IntentBuilder_(context);
    }

    public static TabUsageActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new TabUsageActivity_.IntentBuilder_(fragment);
    }

    public static TabUsageActivity_.IntentBuilder_ intent(androidx.fragment.app.Fragment supportFragment) {
        return new TabUsageActivity_.IntentBuilder_(supportFragment);
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
        this.txt_active = hasViews.internalFindViewById(R.id.txt_active);
        this.rv_stat_group = hasViews.internalFindViewById(R.id.rv_stat_group);
        this.rv_daily_stat = hasViews.internalFindViewById(R.id.rv_daily_stat);
        this.rl_no_data = hasViews.internalFindViewById(R.id.rl_no_data);
        View view_main_back = hasViews.internalFindViewById(R.id.main_back);

        if (view_main_back!= null) {
            view_main_back.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    TabUsageActivity_.this.setStatBack();
                }
            }
            );
        }
        initialize();
    }

    @SuppressLint({
        "SetTextI18n"
    })
    @Override
    public void showDeviceDays(final int days) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                TabUsageActivity_.super.showDeviceDays(days);
            }
        }
        , 0L);
    }

    @Override
    public void initializeGroupAdapter(final List<Modal_TotalDaysGroupsPlayed> modal_totalDaysGroupsPlayeds) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                TabUsageActivity_.super.initializeGroupAdapter(modal_totalDaysGroupsPlayeds);
            }
        }
        , 0L);
    }

    @Override
    public void initializeResourcesAdapter(final HashMap<String, List<Modal_ResourcePlayedByGroups>> modal_resourcePlayedByGroups) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                TabUsageActivity_.super.initializeResourcesAdapter(modal_resourcePlayedByGroups);
            }
        }
        , 0L);
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<TabUsageActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private androidx.fragment.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, TabUsageActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), TabUsageActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(androidx.fragment.app.Fragment fragment) {
            super(fragment.getActivity(), TabUsageActivity_.class);
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
