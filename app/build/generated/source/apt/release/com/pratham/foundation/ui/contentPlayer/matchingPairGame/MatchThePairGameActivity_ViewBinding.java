// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer.matchingPairGame;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MatchThePairGameActivity_ViewBinding implements Unbinder {
  private MatchThePairGameActivity target;

  private View view7f0a0074;

  private View view7f0a0077;

  @UiThread
  public MatchThePairGameActivity_ViewBinding(MatchThePairGameActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MatchThePairGameActivity_ViewBinding(final MatchThePairGameActivity target, View source) {
    this.target = target;

    View view;
    target.rl_match_the_pair = Utils.findRequiredViewAsType(source, R.id.rl_match_the_pair, "field 'rl_match_the_pair'", RelativeLayout.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.topicTitle, "field 'title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_next, "field 'next' and method 'onNextClick'");
    target.next = Utils.castView(view, R.id.btn_next, "field 'next'", ImageButton.class);
    view7f0a0074 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onNextClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_prev, "field 'prev' and method 'onPrevClick'");
    target.prev = Utils.castView(view, R.id.btn_prev, "field 'prev'", ImageButton.class);
    view7f0a0077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPrevClick();
      }
    });
    target.frameLayoutMathThePair = Utils.findRequiredViewAsType(source, R.id.frameLayoutMathThePair, "field 'frameLayoutMathThePair'", FrameLayout.class);

    Context context = source.getContext();
    target.fourDwBg = ContextCompat.getDrawable(context, R.drawable.bg_anim_fourth_layer);
  }

  @Override
  @CallSuper
  public void unbind() {
    MatchThePairGameActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rl_match_the_pair = null;
    target.title = null;
    target.next = null;
    target.prev = null;
    target.frameLayoutMathThePair = null;

    view7f0a0074.setOnClickListener(null);
    view7f0a0074 = null;
    view7f0a0077.setOnClickListener(null);
    view7f0a0077 = null;
  }
}
