//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.main_test;

import android.content.Context;

public final class MainTestPresenter_
    extends MainTestPresenter
{
    private Context context_;
    private Object rootFragment_;

    private MainTestPresenter_(Context context) {
        context_ = context;
        init_();
    }

    private MainTestPresenter_(Context context, Object rootFragment) {
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static MainTestPresenter_ getInstance_(Context context) {
        return new MainTestPresenter_(context);
    }

    public static MainTestPresenter_ getInstance_(Context context, Object rootFragment) {
        return new MainTestPresenter_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }
}
