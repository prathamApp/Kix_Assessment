// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.admin_panel.fragment_admin_panel.tab_usage;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.card.MaterialCardView;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GroupAdapter$ViewHolder_ViewBinding implements Unbinder {
  private GroupAdapter.ViewHolder target;

  @UiThread
  public GroupAdapter$ViewHolder_ViewBinding(GroupAdapter.ViewHolder target, View source) {
    this.target = target;

    target.stat_grp_name = Utils.findRequiredViewAsType(source, R.id.stat_grp_name, "field 'stat_grp_name'", TextView.class);
    target.stat_grp_date = Utils.findRequiredViewAsType(source, R.id.stat_grp_date, "field 'stat_grp_date'", TextView.class);
    target.item_grp_card = Utils.findRequiredViewAsType(source, R.id.item_grp_card, "field 'item_grp_card'", MaterialCardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GroupAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stat_grp_name = null;
    target.stat_grp_date = null;
    target.item_grp_card = null;
  }
}
