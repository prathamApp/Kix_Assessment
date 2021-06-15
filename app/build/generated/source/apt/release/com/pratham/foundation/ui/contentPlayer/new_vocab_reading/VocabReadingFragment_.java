//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.new_vocab_reading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.pratham.foundation.R;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class VocabReadingFragment_
    extends com.pratham.foundation.ui.contentPlayer.new_vocab_reading.VocabReadingFragment
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
            contentView_ = inflater.inflate(R.layout.fragment_story_reading, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        wordFlowLayout = null;
        story_title = null;
        btn_previouspage = null;
        btn_nextpage = null;
        btn_Play = null;
        btn_Mic = null;
        myScrollView = null;
        btn_submit = null;
        btn_Stop = null;
        btn_camera = null;
        bottom_bar2 = null;
        iv_image = null;
        gif_view = null;
        floating_img = null;
        image_container = null;
        stt_result_tv = null;
        clean_stt = null;
        ll_edit_text = null;
        et_edit_ans = null;
        bt_edit_ok = null;
        silence_outer_layout = null;
        silence_main_layout = null;
        silence_iv = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.presenter = VocabReadingPresenter_.getInstance_(getActivity(), this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static VocabReadingFragment_.FragmentBuilder_ builder() {
        return new VocabReadingFragment_.FragmentBuilder_();
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
        this.wordFlowLayout = hasViews.internalFindViewById(R.id.myflowlayout);
        this.story_title = hasViews.internalFindViewById(R.id.tv_story_title);
        this.btn_previouspage = hasViews.internalFindViewById(R.id.btn_prev);
        this.btn_nextpage = hasViews.internalFindViewById(R.id.btn_next);
        this.btn_Play = hasViews.internalFindViewById(R.id.btn_play);
        this.btn_Mic = hasViews.internalFindViewById(R.id.btn_read_mic);
        this.myScrollView = hasViews.internalFindViewById(R.id.myScrollView);
        this.btn_submit = hasViews.internalFindViewById(R.id.btn_submit);
        this.btn_Stop = hasViews.internalFindViewById(R.id.btn_Stop);
        this.btn_camera = hasViews.internalFindViewById(R.id.btn_camera);
        this.bottom_bar2 = hasViews.internalFindViewById(R.id.bottom_bar2);
        this.iv_image = hasViews.internalFindViewById(R.id.iv_image);
        this.gif_view = hasViews.internalFindViewById(R.id.gif_view);
        this.floating_img = hasViews.internalFindViewById(R.id.floating_img);
        this.image_container = hasViews.internalFindViewById(R.id.image_container);
        this.stt_result_tv = hasViews.internalFindViewById(R.id.stt_result_tv);
        this.clean_stt = hasViews.internalFindViewById(R.id.clean_stt);
        this.ll_edit_text = hasViews.internalFindViewById(R.id.ll_edit_text);
        this.et_edit_ans = hasViews.internalFindViewById(R.id.et_edit_ans);
        this.bt_edit_ok = hasViews.internalFindViewById(R.id.bt_edit_ok);
        this.silence_outer_layout = hasViews.internalFindViewById(R.id.silence_outer);
        this.silence_main_layout = hasViews.internalFindViewById(R.id.silence_main_layout);
        this.silence_iv = hasViews.internalFindViewById(R.id.silence_iv);
        if (this.btn_Stop!= null) {
            this.btn_Stop.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.stopBtn();
                }
            }
            );
        }
        if (this.btn_Mic!= null) {
            this.btn_Mic.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.sttMethod();
                }
            }
            );
        }
        if (this.btn_Play!= null) {
            this.btn_Play.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.playReading();
                }
            }
            );
        }
        if (this.btn_previouspage!= null) {
            this.btn_previouspage.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.gotoPrevPage();
                }
            }
            );
        }
        if (this.btn_submit!= null) {
            this.btn_submit.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.submitTest();
                }
            }
            );
        }
        if (this.btn_nextpage!= null) {
            this.btn_nextpage.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.gotoNextPage();
                }
            }
            );
        }
        if (this.clean_stt!= null) {
            this.clean_stt.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.sttClearClicked();
                }
            }
            );
        }
        if (this.bt_edit_ok!= null) {
            this.bt_edit_ok.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    VocabReadingFragment_.this.editOKClicked();
                }
            }
            );
        }
        initialize();
    }

    @Override
    public void showLoader() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                VocabReadingFragment_.super.showLoader();
            }
        }
        , 0L);
    }

    @Override
    public void dismissLoadingDialog() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                VocabReadingFragment_.super.dismissLoadingDialog();
            }
        }
        , 0L);
    }

    @Override
    public void setCategoryTitle(final String title) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                VocabReadingFragment_.super.setCategoryTitle(title);
            }
        }
        , 0L);
    }

    @Override
    public void initializeContent(final int pageNo) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                VocabReadingFragment_.super.initializeContent(pageNo);
            }
        }
        , 0L);
    }

    @Override
    public void allCorrectAnswer() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                VocabReadingFragment_.super.allCorrectAnswer();
            }
        }
        , 0L);
    }

    @Override
    public void setCorrectViewColor() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                VocabReadingFragment_.super.setCorrectViewColor();
            }
        }
        , 0L);
    }

    @Override
    public void setSttResult(final ArrayList<String> sttResult) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                VocabReadingFragment_.super.setSttResult(sttResult);
            }
        }
        , 0L);
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<VocabReadingFragment_.FragmentBuilder_, com.pratham.foundation.ui.contentPlayer.new_vocab_reading.VocabReadingFragment>
    {

        @Override
        public com.pratham.foundation.ui.contentPlayer.new_vocab_reading.VocabReadingFragment build() {
            VocabReadingFragment_ fragment_ = new VocabReadingFragment_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}