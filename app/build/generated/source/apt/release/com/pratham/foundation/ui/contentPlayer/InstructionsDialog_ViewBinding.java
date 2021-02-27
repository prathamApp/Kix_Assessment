// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import com.pratham.foundation.customView.fontsview.SansTextViewBold;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InstructionsDialog_ViewBinding implements Unbinder {
  private InstructionsDialog target;

  private View view7f0a00d6;

  @UiThread
  public InstructionsDialog_ViewBinding(InstructionsDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InstructionsDialog_ViewBinding(final InstructionsDialog target, View source) {
    this.target = target;

    View view;
    target.dia_title = Utils.findRequiredViewAsType(source, R.id.dia_title, "field 'dia_title'", SansTextViewBold.class);
    view = Utils.findRequiredView(source, R.id.dia_btn_green, "method 'playGame'");
    view7f0a00d6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.playGame();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    InstructionsDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.dia_title = null;

    view7f0a00d6.setOnClickListener(null);
    view7f0a00d6 = null;
  }
}
