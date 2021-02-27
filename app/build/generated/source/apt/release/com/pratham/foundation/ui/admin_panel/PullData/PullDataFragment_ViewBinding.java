// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.admin_panel.PullData;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PullDataFragment_ViewBinding implements Unbinder {
  private PullDataFragment target;

  private View view7f0a028b;

  private View view7f0a0067;

  @UiThread
  public PullDataFragment_ViewBinding(final PullDataFragment target, View source) {
    this.target = target;

    View view;
    target.programSpinner = Utils.findRequiredViewAsType(source, R.id.programSpinner, "field 'programSpinner'", Spinner.class);
    target.stateSpinner = Utils.findRequiredViewAsType(source, R.id.stateSpinner, "field 'stateSpinner'", Spinner.class);
    target.blockSpinner = Utils.findRequiredViewAsType(source, R.id.blockSpinner, "field 'blockSpinner'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.save_button, "field 'save_button' and method 'saveData'");
    target.save_button = Utils.castView(view, R.id.save_button, "field 'save_button'", Button.class);
    view7f0a028b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.saveData();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_back, "method 'pressedBackButton'");
    view7f0a0067 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.pressedBackButton();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PullDataFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.programSpinner = null;
    target.stateSpinner = null;
    target.blockSpinner = null;
    target.save_button = null;

    view7f0a028b.setOnClickListener(null);
    view7f0a028b = null;
    view7f0a0067.setOnClickListener(null);
    view7f0a0067 = null;
  }
}
