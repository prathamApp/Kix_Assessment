//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.keywords_identification;

import java.util.HashMap;
import java.util.Map;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.pratham.foundation.R;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class KeywordsIdentificationFragment_
    extends com.pratham.foundation.ui.contentPlayer.keywords_identification.KeywordsIdentificationFragment
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
            contentView_ = inflater.inflate(R.layout.fragment_keywords_identification, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        paraghaph = null;
        keywords = null;
        btn_submit = null;
        keyword_selected = null;
        show_me_keywords = null;
        resultLayout = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.presenter = KeywordsIdentificationPresenter_.getInstance_(getActivity(), this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static KeywordsIdentificationFragment_.FragmentBuilder_ builder() {
        return new KeywordsIdentificationFragment_.FragmentBuilder_();
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
        this.paraghaph = hasViews.internalFindViewById(R.id.paragraph);
        this.keywords = hasViews.internalFindViewById(R.id.keywords);
        this.btn_submit = hasViews.internalFindViewById(R.id.btn_submit);
        this.keyword_selected = hasViews.internalFindViewById(R.id.keyword_selected);
        this.show_me_keywords = hasViews.internalFindViewById(R.id.show_me_keywords);
        this.resultLayout = hasViews.internalFindViewById(R.id.resultLayout);
        if (this.btn_submit!= null) {
            this.btn_submit.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    KeywordsIdentificationFragment_.this.submitClicked();
                }
            }
            );
        }
        if (this.show_me_keywords!= null) {
            this.show_me_keywords.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    KeywordsIdentificationFragment_.this.show_me_keywords();
                }
            }
            );
        }
        initiate();
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<KeywordsIdentificationFragment_.FragmentBuilder_, com.pratham.foundation.ui.contentPlayer.keywords_identification.KeywordsIdentificationFragment>
    {

        @Override
        public com.pratham.foundation.ui.contentPlayer.keywords_identification.KeywordsIdentificationFragment build() {
            KeywordsIdentificationFragment_ fragment_ = new KeywordsIdentificationFragment_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}