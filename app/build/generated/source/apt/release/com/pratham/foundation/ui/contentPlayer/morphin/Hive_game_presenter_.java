//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.contentPlayer.morphin;

import android.content.Context;

public final class Hive_game_presenter_
    extends Hive_game_presenter
{
    private Context context_;
    private Object rootFragment_;

    private Hive_game_presenter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private Hive_game_presenter_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static Hive_game_presenter_ getInstance_(Context context) {
        return new Hive_game_presenter_(context);
    }

    public static Hive_game_presenter_ getInstance_(Context context, Object rootFragment) {
        return new Hive_game_presenter_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }
}