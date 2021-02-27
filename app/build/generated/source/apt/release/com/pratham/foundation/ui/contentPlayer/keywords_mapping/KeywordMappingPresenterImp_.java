//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.keywords_mapping;

import android.content.Context;
import org.androidannotations.api.BackgroundExecutor;

public final class KeywordMappingPresenterImp_
    extends KeywordMappingPresenterImp
{
    private Context context_;
    private Object rootFragment_;

    private KeywordMappingPresenterImp_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private KeywordMappingPresenterImp_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static KeywordMappingPresenterImp_ getInstance_(Context context) {
        return new KeywordMappingPresenterImp_(context);
    }

    public static KeywordMappingPresenterImp_ getInstance_(Context context, Object rootFragment) {
        return new KeywordMappingPresenterImp_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void getDataList() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    KeywordMappingPresenterImp_.super.getDataList();
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }
}
