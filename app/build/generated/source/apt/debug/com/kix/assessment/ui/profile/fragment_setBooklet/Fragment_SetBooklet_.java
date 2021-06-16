//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.profile.fragment_setBooklet;

import java.util.HashMap;
import java.util.Map;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.kix.assessment.R;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class Fragment_SetBooklet_
    extends com.kix.assessment.ui.profile.fragment_setBooklet.Fragment_SetBooklet
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
            contentView_ = inflater.inflate(R.layout.fragment_set_booklet, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        spinner_country = null;
        spinner_language = null;
        spinner_booklet = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static Fragment_SetBooklet_.FragmentBuilder_ builder() {
        return new Fragment_SetBooklet_.FragmentBuilder_();
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
        this.spinner_country = hasViews.internalFindViewById(R.id.set_spinner_country);
        this.spinner_language = hasViews.internalFindViewById(R.id.set_spinner_language);
        this.spinner_booklet = hasViews.internalFindViewById(R.id.set_spinner_booklet);
        View view_btn_setBooklet = hasViews.internalFindViewById(R.id.btn_setBooklet);

        if (view_btn_setBooklet!= null) {
            view_btn_setBooklet.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_SetBooklet_.this.setBooklet();
                }
            }
            );
        }
        if (this.spinner_country!= null) {
            ((AdapterView<?> ) this.spinner_country).setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Fragment_SetBooklet_.this.countrySpinner(false);
                }

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Fragment_SetBooklet_.this.countrySpinner(true);
                }
            }
            );
        }
        if (this.spinner_language!= null) {
            ((AdapterView<?> ) this.spinner_language).setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Fragment_SetBooklet_.this.languageSpinner(false);
                }

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Fragment_SetBooklet_.this.languageSpinner(true);
                }
            }
            );
        }
        initialize();
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<Fragment_SetBooklet_.FragmentBuilder_, com.kix.assessment.ui.profile.fragment_setBooklet.Fragment_SetBooklet>
    {

        @Override
        public com.kix.assessment.ui.profile.fragment_setBooklet.Fragment_SetBooklet build() {
            Fragment_SetBooklet_ fragment_ = new Fragment_SetBooklet_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}