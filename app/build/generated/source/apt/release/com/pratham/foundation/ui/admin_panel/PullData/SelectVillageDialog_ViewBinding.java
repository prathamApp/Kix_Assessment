// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.admin_panel.PullData;

import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectVillageDialog_ViewBinding implements Unbinder {
  private SelectVillageDialog target;

  private View view7f0a0067;

  private View view7f0a0351;

  private View view7f0a0355;

  @UiThread
  public SelectVillageDialog_ViewBinding(SelectVillageDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelectVillageDialog_ViewBinding(final SelectVillageDialog target, View source) {
    this.target = target;

    View view;
    target.txt_message_village = Utils.findRequiredViewAsType(source, R.id.txt_message, "field 'txt_message_village'", TextView.class);
    target.flowLayout = Utils.findRequiredViewAsType(source, R.id.flowLayout, "field 'flowLayout'", GridLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_back, "method 'closeDialog'");
    view7f0a0067 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.closeDialog();
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_clear_changes, "method 'clearChanges'");
    view7f0a0351 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clearChanges();
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_ok, "method 'ok'");
    view7f0a0355 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.ok();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectVillageDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txt_message_village = null;
    target.flowLayout = null;

    view7f0a0067.setOnClickListener(null);
    view7f0a0067 = null;
    view7f0a0351.setOnClickListener(null);
    view7f0a0351 = null;
    view7f0a0355.setOnClickListener(null);
    view7f0a0355 = null;
  }
}
