//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.group_selection.fragment_select_group;

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

public final class FragmentSelectGroup_
    extends com.pratham.foundation.ui.group_selection.fragment_select_group.FragmentSelectGroup
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
            contentView_ = inflater.inflate(R.layout.fragment_select_group, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        rv_group = null;
        main_layout = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static FragmentSelectGroup_.FragmentBuilder_ builder() {
        return new FragmentSelectGroup_.FragmentBuilder_();
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
        this.rv_group = hasViews.internalFindViewById(R.id.rv_group);
        this.main_layout = hasViews.internalFindViewById(R.id.main_layout);
        View view_btn_group_next = hasViews.internalFindViewById(R.id.btn_group_next);
        View view_btn_back = hasViews.internalFindViewById(R.id.btn_back);

        if (view_btn_group_next!= null) {
            view_btn_group_next.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    FragmentSelectGroup_.this.setNext(view);
                }
            }
            );
        }
        if (view_btn_back!= null) {
            view_btn_back.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    FragmentSelectGroup_.this.pressedBackButton();
                }
            }
            );
        }
        initialize();
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<FragmentSelectGroup_.FragmentBuilder_, com.pratham.foundation.ui.group_selection.fragment_select_group.FragmentSelectGroup>
    {

        @Override
        public com.pratham.foundation.ui.group_selection.fragment_select_group.FragmentSelectGroup build() {
            FragmentSelectGroup_ fragment_ = new FragmentSelectGroup_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
