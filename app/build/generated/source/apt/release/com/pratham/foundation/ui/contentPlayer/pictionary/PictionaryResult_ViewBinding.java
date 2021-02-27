// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer.pictionary;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import com.pratham.foundation.customView.fontsview.SansButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PictionaryResult_ViewBinding implements Unbinder {
  private PictionaryResult target;

  private View view7f0a00d6;

  @UiThread
  public PictionaryResult_ViewBinding(PictionaryResult target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PictionaryResult_ViewBinding(final PictionaryResult target, View source) {
    this.target = target;

    View view;
    target.result = Utils.findRequiredViewAsType(source, R.id.result, "field 'result'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.dia_btn_green, "field 'dia_btn_green' and method 'onNext'");
    target.dia_btn_green = Utils.castView(view, R.id.dia_btn_green, "field 'dia_btn_green'", SansButton.class);
    view7f0a00d6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onNext();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PictionaryResult target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.result = null;
    target.dia_btn_green = null;

    view7f0a00d6.setOnClickListener(null);
    view7f0a00d6 = null;
  }
}
