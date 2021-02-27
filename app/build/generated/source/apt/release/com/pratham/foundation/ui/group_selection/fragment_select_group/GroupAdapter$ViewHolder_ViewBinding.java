// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.group_selection.fragment_select_group;

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

    target.group_card = Utils.findRequiredViewAsType(source, R.id.group_card, "field 'group_card'", MaterialCardView.class);
    target.group_name = Utils.findRequiredViewAsType(source, R.id.group_name, "field 'group_name'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GroupAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.group_card = null;
    target.group_name = null;
  }
}
