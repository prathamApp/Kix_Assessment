// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer.chit_chat.level_2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MessageAdapter_2$ViewHolder_ViewBinding implements Unbinder {
  private MessageAdapter_2.ViewHolder target;

  @UiThread
  public MessageAdapter_2$ViewHolder_ViewBinding(MessageAdapter_2.ViewHolder target, View source) {
    this.target = target;

    target.mTextView = Utils.findRequiredViewAsType(source, R.id.text, "field 'mTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MessageAdapter_2.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextView = null;
  }
}