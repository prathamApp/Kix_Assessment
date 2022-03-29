//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.village_activity.village_information_form;

import java.util.HashMap;
import java.util.Map;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.kix.assessment.R;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class Fragment_AddVillageInformation_
    extends com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation
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
            contentView_ = inflater.inflate(R.layout.fragment_add_information_village, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        rg_haveRoad = null;
        rg_haveTransport = null;
        rg_haveElectricity = null;
        rg_haveGovHosp = null;
        rg_havePvtHosp = null;
        rg_havePrePrimSchool = null;
        rg_havePrimSchool = null;
        ll_V06b = null;
        cb_v06bPvt = null;
        cb_v06bGovt = null;
        cb_v06bPublic = null;
        ll_V07b = null;
        cb_v07bPvt = null;
        cb_v07bGovt = null;
        cb_v07bPublic = null;
        btn_saveVIF = null;
        btn_editVIF = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static Fragment_AddVillageInformation_.FragmentBuilder_ builder() {
        return new Fragment_AddVillageInformation_.FragmentBuilder_();
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
        this.rg_haveRoad = hasViews.internalFindViewById(R.id.rg_V01);
        this.rg_haveTransport = hasViews.internalFindViewById(R.id.rg_V02);
        this.rg_haveElectricity = hasViews.internalFindViewById(R.id.rg_V03);
        this.rg_haveGovHosp = hasViews.internalFindViewById(R.id.rg_V04);
        this.rg_havePvtHosp = hasViews.internalFindViewById(R.id.rg_V05);
        this.rg_havePrePrimSchool = hasViews.internalFindViewById(R.id.rg_V06a);
        this.rg_havePrimSchool = hasViews.internalFindViewById(R.id.rg_V07a);
        this.ll_V06b = hasViews.internalFindViewById(R.id.ll_V06b);
        this.cb_v06bPvt = hasViews.internalFindViewById(R.id.ch1_V06b);
        this.cb_v06bGovt = hasViews.internalFindViewById(R.id.ch2_V06b);
        this.cb_v06bPublic = hasViews.internalFindViewById(R.id.ch3_V06b);
        this.ll_V07b = hasViews.internalFindViewById(R.id.ll_V07b);
        this.cb_v07bPvt = hasViews.internalFindViewById(R.id.ch1_V07b);
        this.cb_v07bGovt = hasViews.internalFindViewById(R.id.ch2_V07b);
        this.cb_v07bPublic = hasViews.internalFindViewById(R.id.ch3_V07b);
        this.btn_saveVIF = hasViews.internalFindViewById(R.id.btn_save);
        this.btn_editVIF = hasViews.internalFindViewById(R.id.btn_edit);
        if (this.btn_saveVIF!= null) {
            this.btn_saveVIF.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddVillageInformation_.this.saveVIF();
                }
            }
            );
        }
        if (this.btn_editVIF!= null) {
            this.btn_editVIF.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Fragment_AddVillageInformation_.this.editVIF();
                }
            }
            );
        }
        initialize();
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<Fragment_AddVillageInformation_.FragmentBuilder_, com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation>
    {

        @Override
        public com.kix.assessment.ui.village_activity.village_information_form.Fragment_AddVillageInformation build() {
            Fragment_AddVillageInformation_ fragment_ = new Fragment_AddVillageInformation_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
