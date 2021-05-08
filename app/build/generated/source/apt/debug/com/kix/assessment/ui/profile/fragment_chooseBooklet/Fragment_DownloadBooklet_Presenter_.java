//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.kix.assessment.ui.profile.fragment_chooseBooklet;

import android.content.Context;
import com.kix.assessment.R;
import com.kix.assessment.async.ZipDownloader_;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class Fragment_DownloadBooklet_Presenter_
    extends Fragment_DownloadBooklet_Presenter
    implements OnViewChangedListener
{
    private Context context_;
    private Object rootFragment_;

    private Fragment_DownloadBooklet_Presenter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private Fragment_DownloadBooklet_Presenter_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static Fragment_DownloadBooklet_Presenter_ getInstance_(Context context) {
        return new Fragment_DownloadBooklet_Presenter_(context);
    }

    public static Fragment_DownloadBooklet_Presenter_ getInstance_(Context context, Object rootFragment) {
        return new Fragment_DownloadBooklet_Presenter_(context, rootFragment);
    }

    private void init_() {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        this.zipDownloader = ZipDownloader_.getInstance_(context_, rootFragment_);
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        this.spinner_country = hasViews.internalFindViewById(R.id.spinner_country);
        this.spinner_language = hasViews.internalFindViewById(R.id.spinner_language);
        this.spinner_booklet = hasViews.internalFindViewById(R.id.spinner_booklet);
    }
}
