//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.keywords_mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.pratham.foundation.R;
import com.pratham.foundation.modalclasses.ScienceQuestion;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class KeywordMappingFragment_
    extends com.pratham.foundation.ui.contentPlayer.keywords_mapping.KeywordMappingFragment
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
            contentView_ = inflater.inflate(R.layout.fragment_keyword_mapping, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        keyword = null;
        recycler_view = null;
        previous = null;
        submitBtn = null;
        next = null;
        showAnswer = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.presenter = KeywordMappingPresenterImp_.getInstance_(getActivity(), this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static KeywordMappingFragment_.FragmentBuilder_ builder() {
        return new KeywordMappingFragment_.FragmentBuilder_();
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
        this.keyword = hasViews.internalFindViewById(R.id.keyword);
        this.recycler_view = hasViews.internalFindViewById(R.id.recycler_view);
        this.previous = hasViews.internalFindViewById(R.id.btn_prev);
        this.submitBtn = hasViews.internalFindViewById(R.id.btn_submit);
        this.next = hasViews.internalFindViewById(R.id.btn_next);
        this.showAnswer = hasViews.internalFindViewById(R.id.showAnswer);
        if (this.next!= null) {
            this.next.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    KeywordMappingFragment_.this.onNextClick();
                }
            }
            );
        }
        if (this.previous!= null) {
            this.previous.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    KeywordMappingFragment_.this.onPreviousClick();
                }
            }
            );
        }
        if (this.submitBtn!= null) {
            this.submitBtn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    KeywordMappingFragment_.this.submitClick();
                }
            }
            );
        }
        if (this.showAnswer!= null) {
            this.showAnswer.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    KeywordMappingFragment_.this.showAnswer();
                }
            }
            );
        }
        initiate();
    }

    @Override
    public void loadUI(final List<ScienceQuestion> list) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                KeywordMappingFragment_.super.loadUI(list);
            }
        }
        , 0L);
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<KeywordMappingFragment_.FragmentBuilder_, com.pratham.foundation.ui.contentPlayer.keywords_mapping.KeywordMappingFragment>
    {

        @Override
        public com.pratham.foundation.ui.contentPlayer.keywords_mapping.KeywordMappingFragment build() {
            KeywordMappingFragment_ fragment_ = new KeywordMappingFragment_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
