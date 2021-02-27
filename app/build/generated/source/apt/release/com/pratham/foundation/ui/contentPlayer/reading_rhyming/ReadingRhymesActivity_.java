//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.reading_rhyming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.pratham.foundation.R;
import com.pratham.foundation.modalclasses.ModalRhymingWords;
import org.androidannotations.api.UiThreadExecutor;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class ReadingRhymesActivity_
    extends ReadingRhymesActivity
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
        setContentView(R.layout.activity_rhymes_reading);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T) this.findViewById(id));
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.presenter = ReadingRhymesPresenter_.getInstance_(this, null);
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

    public static ReadingRhymesActivity_.IntentBuilder_ intent(Context context) {
        return new ReadingRhymesActivity_.IntentBuilder_(context);
    }

    public static ReadingRhymesActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new ReadingRhymesActivity_.IntentBuilder_(fragment);
    }

    public static ReadingRhymesActivity_.IntentBuilder_ intent(androidx.fragment.app.Fragment supportFragment) {
        return new ReadingRhymesActivity_.IntentBuilder_(supportFragment);
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
        this.story_ll = hasViews.internalFindViewById(R.id.story_ll);
        this.cardLayout1 = hasViews.internalFindViewById(R.id.rl_card1);
        this.cardLayout2 = hasViews.internalFindViewById(R.id.rl_card2);
        this.cardLayout3 = hasViews.internalFindViewById(R.id.rl_card3);
        this.cardLayout4 = hasViews.internalFindViewById(R.id.rl_card4);
        this.cardLayout5 = hasViews.internalFindViewById(R.id.rl_card5);
        this.cardText1 = hasViews.internalFindViewById(R.id.rhyming_card_word1);
        this.cardText2 = hasViews.internalFindViewById(R.id.rhyming_card_word2);
        this.cardText3 = hasViews.internalFindViewById(R.id.rhyming_card_word3);
        this.cardText4 = hasViews.internalFindViewById(R.id.rhyming_card_word4);
        this.cardText5 = hasViews.internalFindViewById(R.id.rhyming_card_word5);
        this.btn_play = hasViews.internalFindViewById(R.id.btn_play);
        this.btn_next = hasViews.internalFindViewById(R.id.btn_next);
        this.floating_back = hasViews.internalFindViewById(R.id.floating_back);
        this.floating_info = hasViews.internalFindViewById(R.id.floating_info);
        if (this.btn_next!= null) {
            this.btn_next.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    ReadingRhymesActivity_.this.nextBtnPressed();
                }
            }
            );
        }
        if (this.floating_back!= null) {
            this.floating_back.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    ReadingRhymesActivity_.this.pressedBackBtn();
                }
            }
            );
        }
        initialize();
    }

    @Override
    public void noNextButton() {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                ReadingRhymesActivity_.super.noNextButton();
            }
        }
        , 0L);
    }

    @Override
    public void setListData(final List<ModalRhymingWords> wordsDataList) {
        UiThreadExecutor.runTask("", new Runnable() {

            @Override
            public void run() {
                ReadingRhymesActivity_.super.setListData(wordsDataList);
            }
        }
        , 0L);
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<ReadingRhymesActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private androidx.fragment.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, ReadingRhymesActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), ReadingRhymesActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(androidx.fragment.app.Fragment fragment) {
            super(fragment.getActivity(), ReadingRhymesActivity_.class);
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
