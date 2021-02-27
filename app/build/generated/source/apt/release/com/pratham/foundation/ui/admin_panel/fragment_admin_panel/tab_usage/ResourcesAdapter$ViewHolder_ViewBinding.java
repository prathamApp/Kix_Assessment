// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.admin_panel.fragment_admin_panel.tab_usage;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ResourcesAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ResourcesAdapter.ViewHolder target;

  @UiThread
  public ResourcesAdapter$ViewHolder_ViewBinding(ResourcesAdapter.ViewHolder target, View source) {
    this.target = target;

    target.stat_res_name = Utils.findRequiredViewAsType(source, R.id.stat_res_name, "field 'stat_res_name'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ResourcesAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stat_res_name = null;
  }
}
