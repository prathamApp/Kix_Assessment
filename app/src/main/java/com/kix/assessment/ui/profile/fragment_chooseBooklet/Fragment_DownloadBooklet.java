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
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.async.API_Content;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.custom.progress_layout.ProgressLayout;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Booklet;
import com.kix.assessment.modal_classes.Modal_Country;
import com.kix.assessment.modal_classes.Modal_Language;
import com.kix.assessment.temp.Modal_FileDownloading;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.kix.assessment.KIXApplication.bookletDao;
import static com.kix.assessment.KIXApplication.countryDao;
import static com.kix.assessment.KIXApplication.languageDao;

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

    private boolean loaderVisible = false;
    private CustomLodingDialog myLoadingDialog;

    ArrayList<Modal_Country> country_List = new ArrayList<>();
    ArrayList<Modal_Language> language_List = new ArrayList<>();
    ArrayList<Modal_Booklet> booklet_List = new ArrayList<>();


    @AfterViews
    public void initialize() {
        context = getActivity();
        presenter.setView(Fragment_DownloadBooklet.this);
        showLoader();
        presenter.fetchCountries(Kix_Constant.COUNTRY_API);
    }

    @ItemSelect(R.id.spinner_country)
    public void countrySpinner(boolean sel){
        if(!(spinner_country.getSelectedItemPosition()==0))
            showLoader();
            presenter.fetchLanguages(Kix_Constant.LANGUAGE_API, spinner_country.getSelectedItem().toString());
    }

    @ItemSelect(R.id.spinner_language)
    public void languageSpinner(boolean sel){
        if(!(spinner_language.getSelectedItemPosition()==0))
            showLoader();
            presenter.fetchBooklets(Kix_Constant.BOOKLET_API, spinner_language.getSelectedItem().toString());
    }

//    @ItemSelect(R.id.spinner_booklet)
//    public void setBooklet(boolean sel){
//        if(!(spinner_booklet.getSelectedItemPosition()==0)) {
//            showLoader();
////            Toast.makeText(context, ""+spinner_booklet.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void fillCountrySpinner(List<Modal_Country> countryList) {
        country_List= (ArrayList<Modal_Country>) countryList;
        dismissLoadingDialog();
        ArrayList<String> countryName = new ArrayList<>();
        countryName.add("Country");
        for(int i=0;i<countryList.size();i++){
            countryName.add(countryList.get(i).getCountryName());
        }
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, countryName);
        spinner_country.setAdapter(adapterCountry);
    }

    @Override
    public void fillLanguageSpinner(List<Modal_Language> languageList) {
        language_List = (ArrayList<Modal_Language>) languageList;
        dismissLoadingDialog();
        ArrayList<String> languageName = new ArrayList<>();
        languageName.add("Language");
        for(int i=0 ; i<languageList.size() ; i++){
            languageName.add(languageList.get(i).getLanguageName());
        }
        ArrayAdapter<String> adapterLanguage = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, languageName);
        spinner_language.setAdapter(adapterLanguage);
    }

    @Override
    public void fillBookletSpinner(List<Modal_Booklet> bookletList) {
        booklet_List = (ArrayList<Modal_Booklet>) bookletList;
        dismissLoadingDialog();
        ArrayList<String> bookletName = new ArrayList<>();
        bookletName.add("Booklet");
        for(int i=0 ; i<bookletList.size() ; i++){
            bookletName.add(bookletList.get(i).getBookletName());
        }
        ArrayAdapter<String> adapterBooklet = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, bookletName);
        spinner_booklet.setAdapter(adapterBooklet);
    }

    @Click(R.id.btn_download)
    public void downloadBookletZip() {
        addSpinnerValToDB();
        showLoader();
        presenter.downloadBooklet(spinner_booklet.getSelectedItem().toString());
//        presenter.downloadBooklet("SCAPP_55008");
//        presenter.downloadBooklet("SCAPP_55413");
//        presenter.downloadBooklet("SCAPP_55089");
    }

    public void addSpinnerValToDB(){
        for(int i=0;i<country_List.size();i++) {
            if(country_List.get(i).getCountryName().equalsIgnoreCase(spinner_country.getSelectedItem().toString())) {
                Modal_Country modalCountry = new Modal_Country();
                modalCountry.setCountryId(country_List.get(i).getCountryId());
                modalCountry.setCountryName(country_List.get(i).getCountryName());
                countryDao.insertCountry(modalCountry);
                break;
            }
        }

        for(int i=0;i<language_List.size();i++) {
            if(language_List.get(i).getLanguageName().equalsIgnoreCase(spinner_language.getSelectedItem().toString())){
                Modal_Language modalLanguage = new Modal_Language();
                modalLanguage.setLanguageId(language_List.get(i).getLanguageId());
                modalLanguage.setLanguageCode(language_List.get(i).getLanguageCode());
                modalLanguage.setLanguageName(language_List.get(i).getLanguageName());
                modalLanguage.setCountryName(language_List.get(i).getCountryName());
                languageDao.insertLanguage(modalLanguage);
                break;
            }
        }

        for(int i=0;i<booklet_List.size();i++) {
            if (booklet_List.get(i).getBookletName().equalsIgnoreCase(spinner_booklet.getSelectedItem().toString())) {
                Modal_Booklet modalBooklet = new Modal_Booklet();
                modalBooklet.setBookletId(booklet_List.get(i).getBookletId());
                modalBooklet.setBookletName(booklet_List.get(i).getBookletName());
                modalBooklet.setLanguageName(booklet_List.get(i).getLanguageName());
                bookletDao.insertBooklet(modalBooklet);
                break;
            }
        }
    }

    @Override
    public void showTost(String text) {
        Toast.makeText(context, ""+text, Toast.LENGTH_SHORT).show();
    }

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
