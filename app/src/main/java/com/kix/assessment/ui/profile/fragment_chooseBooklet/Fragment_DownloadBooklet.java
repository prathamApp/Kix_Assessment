package com.kix.assessment.ui.profile.fragment_chooseBooklet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.async.API_Content;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.custom.progress_layout.ProgressLayout;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.temp.Modal_FileDownloading;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Objects;

@EFragment(R.layout.fragment_choose_booklet)
public class Fragment_DownloadBooklet extends Fragment implements DownloadBooklet_Contract.DownloadBookletView {

    @ViewById(R.id.spinner_country)
    Spinner spinner_country;

    @ViewById(R.id.spinner_language)
    Spinner spinner_language;

    @ViewById(R.id.spinner_booklet)
    Spinner spinner_booklet;

    public API_Content api_content;

    @Bean(Fragment_DownloadBooklet_Presenter.class)
    DownloadBooklet_Contract.DownloadBookletPresenter presenter;
    Context context;


    @AfterViews
    public void initialize() {
        context = getActivity();
        presenter.setView(Fragment_DownloadBooklet.this);
        ArrayAdapter adapterCountry = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_country, R.layout.support_simple_spinner_dropdown_item);
        spinner_country.setAdapter(adapterCountry);
        ArrayAdapter adapterLanguage = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_language, R.layout.support_simple_spinner_dropdown_item);
        spinner_language.setAdapter(adapterLanguage);
        ArrayAdapter adapterBooklet = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_booklet, R.layout.support_simple_spinner_dropdown_item);
        spinner_booklet.setAdapter(adapterBooklet);
    }

    @Click(R.id.btn_download)
    public void downloadBookletZip() {
        showLoader();
//        presenter.downloadBooklet("SCAPP_55008");
//        presenter.downloadBooklet("SCAPP_55413");
        presenter.downloadBooklet("SCAPP_55089");
    }

    private boolean loaderVisible = false;
    private CustomLodingDialog myLoadingDialog;

    @UiThread
    @Override
    public void showLoader() {
        if (!loaderVisible) {
            loaderVisible = true;
            myLoadingDialog = new CustomLodingDialog(context);
            myLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(myLoadingDialog.getWindow()).
                    setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myLoadingDialog.setContentView(R.layout.loading_dialog);
            myLoadingDialog.setCanceledOnTouchOutside(false);
            myLoadingDialog.show();
        }
    }

    @Override
    @UiThread
    public void dismissLoadingDialog() {
        try {
            loaderVisible = false;
            new Handler().postDelayed(() -> {
                if (myLoadingDialog != null && myLoadingDialog.isShowing())
                    myLoadingDialog.dismiss();
            }, 150);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    @Override
    public void dismissDownloadDialog() {
        try {
            if (downloadDialog != null)
                new Handler().postDelayed(() -> {
                    downloadDialog.dismiss();
                }, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CustomLodingDialog errorDialog;

    @UiThread
    public void showDownloadErrorDialog() {
        try {
            errorDialog = new CustomLodingDialog(context);
            errorDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(errorDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            errorDialog.setContentView(R.layout.dialog_file_error_downloading);
            errorDialog.setCanceledOnTouchOutside(false);
            Button dialog_error_btn = errorDialog.findViewById(R.id.dialog_error_btn);
            dialog_error_btn.setOnClickListener(v -> new Handler().postDelayed(() ->
                    errorDialog.dismiss(), 200));
            errorDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageReceived(EventMessage message) {
        Modal_FileDownloading modal_fileDownloading = message.getModal_fileDownloading();
        if (message.getMessage().equalsIgnoreCase(Kix_Constant.FILE_DOWNLOAD_STARTED)) {
            dismissLoadingDialog();
            resourceDownloadDialog(message.getModal_fileDownloading());
        } else if (message.getMessage().equalsIgnoreCase(Kix_Constant.FILE_DOWNLOAD_UPDATE)) {
            if (progressLayout != null)
                progressLayout.setCurProgress(message.getModal_fileDownloading().getProgress());
        } else if (message.getMessage().equalsIgnoreCase(Kix_Constant.FILE_DOWNLOAD_ERROR) ||
                message.getMessage().equalsIgnoreCase(Kix_Constant.UNZIPPING_ERROR) ||
                message.getMessage().equalsIgnoreCase(Kix_Constant.RESPONSE_CODE_ERROR)) {
            dismissDownloadDialog();
            showDownloadErrorDialog();
        } else if (message.getMessage().equalsIgnoreCase(Kix_Constant.UNZIPPING_DATA_FILE))
            showZipLoader();
        else if (message.getMessage().equalsIgnoreCase(Kix_Constant.FILE_DOWNLOAD_COMPLETE)) {
            ShowDwComplete();
        }
    }

    @UiThread
    public void ShowDwComplete() {
        try {
            dialog_roundProgress.setVisibility(View.GONE);
            dialog_file_name.setText("Download Completed\nSuccessfully");
            btn_dw_ok.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            downloadDialog.dismiss();
            dismissLoadingDialog();
            e.printStackTrace();
        }
    }

    private CustomLodingDialog downloadDialog;
    private ProgressLayout progressLayout;
    private TextView dialog_file_name;
    private Button btn_dw_ok;
    ProgressBar dialog_roundProgress;

    @SuppressLint("SetTextI18n")
    @UiThread
    public void resourceDownloadDialog(Modal_FileDownloading modal_fileDownloading) {
        if (downloadDialog != null)
            downloadDialog = null;
        try {
            downloadDialog = new CustomLodingDialog(context);
            downloadDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(downloadDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            downloadDialog.setContentView(R.layout.dialog_file_downloading);
            downloadDialog.setCanceledOnTouchOutside(false);
            downloadDialog.show();
//            SimpleDraweeView iv_file_trans = downloadDialog.findViewById(R.id.iv_file_trans);
            dialog_file_name = downloadDialog.findViewById(R.id.dialog_file_name);
            progressLayout = downloadDialog.findViewById(R.id.dialog_progressLayout);
            dialog_roundProgress = downloadDialog.findViewById(R.id.dialog_roundProgress);
            btn_dw_ok = downloadDialog.findViewById(R.id.btn_dw_ok);
/*            ImageRequest imageRequest = ImageRequestBuilder
                    .newBuilderWithSource(Uri.parse("" + resServerImageName))
                    .setLocalThumbnailPreviewsEnabled(false)
                    .build();
            if (imageRequest != null) {
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(imageRequest)
                        .setOldController(iv_file_trans.getController())
                        .build();
                iv_file_trans.setController(controller);
            }*/
            btn_dw_ok.setOnClickListener(v -> downloadDialog.dismiss());
            dialog_file_name.setText("Booklet");
            progressLayout.setCurProgress(modal_fileDownloading.getProgress());
            downloadDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    @UiThread
    public void showZipLoader() {
        try {
            dialog_file_name.setText("Loading\n" + "Booklet" + "\nPlease wait...");
            progressLayout.setVisibility(View.GONE);
            dialog_roundProgress.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
