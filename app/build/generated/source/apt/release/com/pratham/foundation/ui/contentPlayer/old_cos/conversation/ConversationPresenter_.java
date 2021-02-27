//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.old_cos.conversation;

import java.util.ArrayList;
import android.content.Context;
import org.androidannotations.api.BackgroundExecutor;

public final class ConversationPresenter_
    extends ConversationPresenter
{
    private Context context_;
    private Object rootFragment_;

    private ConversationPresenter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private ConversationPresenter_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static ConversationPresenter_ getInstance_(Context context) {
        return new ConversationPresenter_(context);
    }

    public static ConversationPresenter_ getInstance_(Context context, Object rootFragment) {
        return new ConversationPresenter_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void fetchStory(final String convoPath) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    ConversationPresenter_.super.fetchStory(convoPath);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }

    @Override
    public void sttResultProcess(final ArrayList<String> sttServerResult, final String answer) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    ConversationPresenter_.super.sttResultProcess(sttServerResult, answer);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }

    @Override
    public void addCompletion(final float perc) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    ConversationPresenter_.super.addCompletion(perc);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }

    @Override
    public void addScore(final int wID, final String Word, final int scoredMarks, final int totalMarks, final String Label) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    ConversationPresenter_.super.addScore(wID, Word, scoredMarks, totalMarks, Label);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }
}
