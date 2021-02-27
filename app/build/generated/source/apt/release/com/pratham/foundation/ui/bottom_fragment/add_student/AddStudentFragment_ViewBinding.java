// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.ui.bottom_fragment.add_student;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddStudentFragment_ViewBinding implements Unbinder {
  private AddStudentFragment target;

  private View view7f0a0233;

  private View view7f0a0232;

  private View view7f0a0063;

  @UiThread
  public AddStudentFragment_ViewBinding(final AddStudentFragment target, View source) {
    this.target = target;

    View view;
    target.homeRoot = Utils.findRequiredViewAsType(source, R.id.form_root, "field 'homeRoot'", RelativeLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.rv_Avatars, "field 'recyclerView'", RecyclerView.class);
    target.et_studentName = Utils.findRequiredViewAsType(source, R.id.et_studentName, "field 'et_studentName'", EditText.class);
    target.spinner_age = Utils.findRequiredViewAsType(source, R.id.spinner_age, "field 'spinner_age'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.rb_male, "field 'rb_male' and method 'maleGenderClicked'");
    target.rb_male = Utils.castView(view, R.id.rb_male, "field 'rb_male'", RadioButton.class);
    view7f0a0233 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.maleGenderClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_female, "field 'rb_female' and method 'femaleGenderClicked'");
    target.rb_female = Utils.castView(view, R.id.rb_female, "field 'rb_female'", RadioButton.class);
    view7f0a0232 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.femaleGenderClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_add_new_student, "method 'onAddNewClick'");
    view7f0a0063 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAddNewClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AddStudentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.homeRoot = null;
    target.recyclerView = null;
    target.et_studentName = null;
    target.spinner_age = null;
    target.rb_male = null;
    target.rb_female = null;

    view7f0a0233.setOnClickListener(null);
    view7f0a0233 = null;
    view7f0a0232.setOnClickListener(null);
    view7f0a0232 = null;
    view7f0a0063.setOnClickListener(null);
    view7f0a0063 = null;
  }
}
