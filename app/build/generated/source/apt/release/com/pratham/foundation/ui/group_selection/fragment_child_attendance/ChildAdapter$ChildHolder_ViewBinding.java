// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.group_selection.fragment_child_attendance;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChildAdapter$ChildHolder_ViewBinding implements Unbinder {
  private ChildAdapter.ChildHolder target;

  @UiThread
  public ChildAdapter$ChildHolder_ViewBinding(ChildAdapter.ChildHolder target, View source) {
    this.target = target;

    target.child_name = Utils.findRequiredViewAsType(source, R.id.child_name, "field 'child_name'", TextView.class);
    target.child_avatar = Utils.findRequiredViewAsType(source, R.id.iv_child, "field 'child_avatar'", SimpleDraweeView.class);
    target.iv_camera = Utils.findRequiredViewAsType(source, R.id.iv_camera, "field 'iv_camera'", ImageView.class);
    target.main_layout = Utils.findRequiredViewAsType(source, R.id.rl_child_attendance, "field 'main_layout'", MaterialCardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ChildAdapter.ChildHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.child_name = null;
    target.child_avatar = null;
    target.iv_camera = null;
    target.main_layout = null;
  }
}
