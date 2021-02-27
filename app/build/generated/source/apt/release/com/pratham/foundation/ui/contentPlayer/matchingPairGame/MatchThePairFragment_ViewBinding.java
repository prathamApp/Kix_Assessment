// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer.matchingPairGame;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MatchThePairFragment_ViewBinding implements Unbinder {
  private MatchThePairFragment target;

  private View view7f0a0069;

  @UiThread
  public MatchThePairFragment_ViewBinding(final MatchThePairFragment target, View source) {
    this.target = target;

    View view;
    target.rl_english = Utils.findRequiredViewAsType(source, R.id.rl_english, "field 'rl_english'", RecyclerView.class);
    target.rl_hindi = Utils.findRequiredViewAsType(source, R.id.rl_hindi, "field 'rl_hindi'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.btn_check, "method 'checkAnsClick'");
    view7f0a0069 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.checkAnsClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MatchThePairFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rl_english = null;
    target.rl_hindi = null;

    view7f0a0069.setOnClickListener(null);
    view7f0a0069 = null;
  }
}
