// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.contentPlayer.fillInTheBlanks;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import com.pratham.foundation.customView.GifView;
import com.pratham.foundation.customView.fontsview.SansTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FillInTheBlanksFragment_ViewBinding implements Unbinder {
  private FillInTheBlanksFragment target;

  private View view7f0a0159;

  private View view7f0a0221;

  private View view7f0a01f6;

  private View view7f0a02e6;

  @UiThread
  public FillInTheBlanksFragment_ViewBinding(final FillInTheBlanksFragment target, View source) {
    this.target = target;

    View view;
    target.question = Utils.findRequiredViewAsType(source, R.id.tv_question, "field 'question'", SansTextView.class);
    target.questionImage = Utils.findRequiredViewAsType(source, R.id.iv_question_image, "field 'questionImage'", ImageView.class);
    target.questionGif = Utils.findRequiredViewAsType(source, R.id.iv_question_gif, "field 'questionGif'", GifView.class);
    target.etAnswer = Utils.findRequiredViewAsType(source, R.id.et_answer, "field 'etAnswer'", EditText.class);
    view = Utils.findRequiredView(source, R.id.ib_mic, "field 'ib_mic' and method 'onMicClicked'");
    target.ib_mic = Utils.castView(view, R.id.ib_mic, "field 'ib_mic'", ImageButton.class);
    view7f0a0159 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onMicClicked();
      }
    });
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
    FillInTheBlanksFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.question = null;
    target.questionImage = null;
    target.questionGif = null;
    target.etAnswer = null;
    target.ib_mic = null;

    view7f0a0159.setOnClickListener(null);
    view7f0a0159 = null;
    view7f0a0221.setOnClickListener(null);
    view7f0a0221 = null;
    view7f0a01f6.setOnClickListener(null);
    view7f0a01f6 = null;
    view7f0a02e6.setOnClickListener(null);
    view7f0a02e6 = null;
  }
}
