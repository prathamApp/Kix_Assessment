// Generated code from Butter Knife. Do not modify!
package com.pratham.foundation.customView;

import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pratham.foundation.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ZoomImageDialog_ViewBinding implements Unbinder {
  private ZoomImageDialog target;

  private View view7f0a0075;

  @UiThread
  public ZoomImageDialog_ViewBinding(ZoomImageDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ZoomImageDialog_ViewBinding(final ZoomImageDialog target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_ok_img, "field 'btn_ok' and method 'closeDialog'");
    target.btn_ok = Utils.castView(view, R.id.btn_ok_img, "field 'btn_ok'", ImageButton.class);
    view7f0a0075 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.closeDialog();
      }
    });
    target.zoomImg = Utils.findRequiredViewAsType(source, R.id.iv_zoom_img, "field 'zoomImg'", ZoomageView.class);
    target.gifView = Utils.findRequiredViewAsType(source, R.id.iv_img, "field 'gifView'", GifViewZoom.class);
    target.videoView = Utils.findRequiredViewAsType(source, R.id.vv_video, "field 'videoView'", VideoView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ZoomImageDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btn_ok = null;
    target.zoomImg = null;
    target.gifView = null;
    target.videoView = null;

    view7f0a0075.setOnClickListener(null);
    view7f0a0075 = null;
  }
}
