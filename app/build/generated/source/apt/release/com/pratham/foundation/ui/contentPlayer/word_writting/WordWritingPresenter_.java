//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.word_writting;

import android.content.Context;
import org.androidannotations.api.BackgroundExecutor;

public final class WordWritingPresenter_
    extends WordWritingPresenter
{
    private Context context_;
    private Object rootFragment_;

    private WordWritingPresenter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private WordWritingPresenter_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static WordWritingPresenter_ getInstance_(Context context) {
        return new WordWritingPresenter_(context);
    }

    public static WordWritingPresenter_ getInstance_(Context context, Object rootFragment) {
        return new WordWritingPresenter_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void addImageOnly(final String resId, final String imageName) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    WordWritingPresenter_.super.addImageOnly(resId, imageName);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }
}