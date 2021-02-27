// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer.vocabulary_qa;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QA_Adapter$ViewHolder_ViewBinding implements Unbinder {
  private QA_Adapter.ViewHolder target;

  @UiThread
  public QA_Adapter$ViewHolder_ViewBinding(QA_Adapter.ViewHolder target, View source) {
    this.target = target;

    target.mTextView = Utils.findRequiredViewAsType(source, R.id.text, "field 'mTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QA_Adapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextView = null;
  }
}
