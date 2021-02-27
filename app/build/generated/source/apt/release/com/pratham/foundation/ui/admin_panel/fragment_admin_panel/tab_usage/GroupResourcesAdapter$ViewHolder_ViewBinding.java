// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.admin_panel.fragment_admin_panel.tab_usage;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GroupResourcesAdapter$ViewHolder_ViewBinding implements Unbinder {
  private GroupResourcesAdapter.ViewHolder target;

  @UiThread
  public GroupResourcesAdapter$ViewHolder_ViewBinding(GroupResourcesAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.stat_date = Utils.findRequiredViewAsType(source, R.id.stat_date, "field 'stat_date'", TextView.class);
    target.rv_stat_resource = Utils.findRequiredViewAsType(source, R.id.rv_stat_resource, "field 'rv_stat_resource'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GroupResourcesAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stat_date = null;
    target.rv_stat_resource = null;
  }
}
