//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.keywords_identification;

import android.content.Context;

public final class KeywordsIdentificationPresenter_
    extends KeywordsIdentificationPresenter
{
    private Context context_;
    private Object rootFragment_;

    private KeywordsIdentificationPresenter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private KeywordsIdentificationPresenter_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static KeywordsIdentificationPresenter_ getInstance_(Context context) {
        return new KeywordsIdentificationPresenter_(context);
    }

    public static KeywordsIdentificationPresenter_ getInstance_(Context context, Object rootFragment) {
        return new KeywordsIdentificationPresenter_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }
}