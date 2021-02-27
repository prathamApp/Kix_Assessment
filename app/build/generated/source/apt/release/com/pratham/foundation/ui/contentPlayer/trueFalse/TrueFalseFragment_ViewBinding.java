// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer.trueFalse;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import com.pratham.foundation.customView.GifView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrueFalseFragment_ViewBinding implements Unbinder {
  private TrueFalseFragment target;

  private View view7f0a0221;

  private View view7f0a01f6;

  private View view7f0a02e6;

  @UiThread
  public TrueFalseFragment_ViewBinding(final TrueFalseFragment target, View source) {
    this.target = target;

    View view;
    target.question = Utils.findRequiredViewAsType(source, R.id.tv_question, "field 'question'", TextView.class);
    target.rg_true_false = Utils.findRequiredViewAsType(source, R.id.rg_true_false, "field 'rg_true_false'", RadioGroup.class);
    target.questionImage = Utils.findRequiredViewAsType(source, R.id.iv_question_image, "field 'questionImage'", ImageView.class);
    target.questionGif = Utils.findRequiredViewAsType(source, R.id.iv_question_gif, "field 'questionGif'", GifView.class);
    target.radioButtonTrue = Utils.findRequiredViewAsType(source, R.id.rb_true, "field 'radioButtonTrue'", Button.class);
    target.radioButtonFalse = Utils.findRequiredViewAsType(source, R.id.rb_false, "field 'radioButtonFalse'", Button.class);
    view = Utils.findRequiredView(source, R.id.previous, "method 'onPreviousClick'");
    view7f0a0221 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPreviousClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.next, "method 'onNextClick'");
    view7f0a01f6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onNextClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.submitBtn, "method 'onsubmitBtnClick'");
    view7f0a02e6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsubmitBtnClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TrueFalseFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.question = null;
    target.rg_true_false = null;
    target.questionImage = null;
    target.questionGif = null;
    target.radioButtonTrue = null;
    target.radioButtonFalse = null;

    view7f0a0221.setOnClickListener(null);
    view7f0a0221 = null;
    view7f0a01f6.setOnClickListener(null);
    view7f0a01f6 = null;
    view7f0a02e6.setOnClickListener(null);
    view7f0a02e6 = null;
  }
}
