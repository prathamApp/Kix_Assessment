//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.sequenceLayout;

import android.content.Context;

public final class SequenceLayoutPresenterImp_
    extends SequenceLayoutPresenterImp
{
    private Context context_;
    private Object rootFragment_;

    private SequenceLayoutPresenterImp_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private SequenceLayoutPresenterImp_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static SequenceLayoutPresenterImp_ getInstance_(Context context) {
        return new SequenceLayoutPresenterImp_(context);
    }

    public static SequenceLayoutPresenterImp_ getInstance_(Context context, Object rootFragment) {
        return new SequenceLayoutPresenterImp_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }
}