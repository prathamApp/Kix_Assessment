//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.fragment_profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.kix.assessment.R;
import com.kix.assessment.async.PushDataBaseZipToServer_;
import com.kix.assessment.modal_classes.Modal_ProfileDetails;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class Fragment_Profile_
    extends com.kix.assessment.ui.fragment_profile.Fragment_Profile
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
            contentView_ = inflater.inflate(R.layout.fragment_profile, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        tv_profileName = null;
        tv_TotStudCount = null;
        tv_AssessmentGivenCount = null;
        tv_totVillageCount = null;
        tv_totHHCount = null;
        rv_examDetail = null;
        ll_ageFilterSpinner = null;
        ll_villageFilterSpinner = null;
        spinner_ageFilter = null;
        spinner_villageFilter = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.profilePresenter = ProfilePresenter_.getInstance_(getActivity(), this);
        this.pushDataBaseZipToServer = PushDataBaseZipToServer_.getInstance_(getActivity(), this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static Fragment_Profile_.FragmentBuilder_ builder() {
        return new Fragment_Profile_.FragmentBuilder_();
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
        this.tv_profileName = hasViews.internalFindViewById(R.id.tv_profileName);
        this.tv_TotStudCount = hasViews.internalFindViewById(R.id.tv_childTotalCount);
        this.tv_AssessmentGivenCount = hasViews.internalFindViewById(R.id.tv_childAssessedTotalCount);
        this.tv_totVillageCount = hasViews.internalFindViewById(R.id.tv_villTotalCount);
        this.tv_totHHCount = hasViews.internalFindViewById(R.id.tv_hhTotalCount);
        this.rv_examDetail = hasViews.internalFindViewById(R.id.rv_examDetail);
        this.ll_ageFilterSpinner = hasViews.internalFindViewById(R.id.ll_ageFilterSpinner);
        this.ll_villageFilterSpinner = hasViews.internalFindViewById(R.id.ll_villageFilterSpinner);
        this.spinner_ageFilter = hasViews.internalFindViewById(R.id.spinner_ageFilter);
        this.spinner_villageFilter = hasViews.internalFindViewById(R.id.spinner_villageFilter);
        View view_fab_sync = hasViews.internalFindViewById(R.id.fab_sync);
        View view_fab_db_sync = hasViews.internalFindViewById(R.id.fab_db_sync);

        if (view_fab_sync!= null) {
            view_fab_sync.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_Profile_.this.sync();
                }
            }
            );
        }
        if (view_fab_db_sync!= null) {
            view_fab_db_sync.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_Profile_.this.syncDB();
                }
            }
            );
        }
        if (this.spinner_ageFilter!= null) {
            ((AdapterView<?> ) this.spinner_ageFilter).setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Fragment_Profile_.this.ageFilter(false);
                }

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Fragment_Profile_.this.ageFilter(true);
                }
            }
            );
        }
        if (this.spinner_villageFilter!= null) {
            ((AdapterView<?> ) this.spinner_villageFilter).setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Fragment_Profile_.this.villageFilter(false);
                }

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Fragment_Profile_.this.villageFilter(true);
                }
            }
            );
        }
        initialize();
    }

    @Override
    public void showProfileData(final List<Modal_ProfileDetails> profileDetails) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                Fragment_Profile_.super.showProfileData(profileDetails);
            }
        }
        , 0L);
    }

    @Override
    public void initializeAdapter() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                Fragment_Profile_.super.initializeAdapter();
            }
        }
        , 0L);
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<Fragment_Profile_.FragmentBuilder_, com.kix.assessment.ui.fragment_profile.Fragment_Profile>
    {

        @Override
        public com.kix.assessment.ui.fragment_profile.Fragment_Profile build() {
            Fragment_Profile_ fragment_ = new Fragment_Profile_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
