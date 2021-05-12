package com.kix.assessment.ui.profile.fragment_chooseBooklet;

import android.content.Context;
import android.util.Log;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.R;
import com.kix.assessment.async.API_Content;
import com.kix.assessment.async.ZipDownloader;
import com.kix.assessment.interfaces.API_Content_Result;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Booklet;
import com.kix.assessment.modal_classes.Modal_Country;
import com.kix.assessment.modal_classes.Modal_DownloadContent;
import com.kix.assessment.modal_classes.Modal_Language;
import com.kix.assessment.newtemp.ContentTable;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@EBean
public class Fragment_DownloadBooklet_Presenter implements DownloadBooklet_Contract.DownloadBookletPresenter, API_Content_Result {

    @ViewById(R.id.spinner_country)
    Spinner spinner_country;

    @ViewById(R.id.spinner_language)
    Spinner spinner_language;

    @ViewById(R.id.spinner_booklet)
    Spinner spinner_booklet;

    private API_Content api_content;
    DownloadBooklet_Contract.DownloadBookletView downloadBookletView;
    Gson gson;
    Context mContext;

    @Bean(ZipDownloader.class)
    ZipDownloader zipDownloader;

    public Fragment_DownloadBooklet_Presenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void setView(DownloadBooklet_Contract.DownloadBookletView downloadBookletView) {
        this.downloadBookletView = downloadBookletView;
        gson = new Gson();
        api_content = new API_Content(mContext, Fragment_DownloadBooklet_Presenter.this);
    }

    @Override
    public void downloadBooklet(String nodeID) {
        api_content.getAPIContent(Kix_Constant.INTERNET_DOWNLOAD_RESOURCE, Kix_Constant.INTERNET_DOWNLOAD_RESOURCE_API, nodeID);
    }

    @Override
    public void fetchCountries(String url) {
        api_content.getCountry(Kix_Constant.FETCH_COUNTRY, url);
    }

    @Override
    public void fetchLanguages(String languageURL, String countryName) {
        api_content.getCountryWiseLang(Kix_Constant.FETCH_LANGUAGE, languageURL, countryName);
    }

    @Override
    public void fetchBooklets(String bookletURL, String languageName) {
        api_content.getBookletWiseLanguage(Kix_Constant.FETCH_BOOKLET, bookletURL, languageName);
    }

    @Override
    public void receivedContent(String header, String response) {

        Gson gson = new Gson();
        if(header.equalsIgnoreCase(Kix_Constant.INTERNET_DOWNLOAD_RESOURCE)){
            try {
                JSONObject jsonObject = new JSONObject(response);
                Modal_DownloadContent download_content = gson.fromJson(jsonObject.toString(), Modal_DownloadContent.class);
//                contentDetail = download_content.getNodelist().get(download_content.getNodelist().size() - 1);

                String fileName = download_content.getDownloadurl()
                        .substring(download_content.getDownloadurl().lastIndexOf('/') + 1);
                ArrayList<ContentTable> pos = new ArrayList<>();
                pos.addAll(download_content.getNodelist());
                ContentTable dwContent = pos.get(0);
                Log.d("HP", "doInBackground: fileName : " + fileName);
                Log.d("HP", "doInBackground: DW URL : " + download_content.getDownloadurl());
                    zipDownloader.initialize(mContext, download_content.getDownloadurl(),
                            download_content.getFoldername(), fileName, pos, dwContent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if(header.equalsIgnoreCase(Kix_Constant.FETCH_COUNTRY)){
            Type listType = new TypeToken<ArrayList<Modal_Country>>() {
            }.getType();
            List<Modal_Country> countryList = gson.fromJson(response, listType);
            downloadBookletView.fillCountrySpinner(countryList);
        } else if(header.equalsIgnoreCase(Kix_Constant.FETCH_LANGUAGE)){
            Type listType = new TypeToken<ArrayList<Modal_Language>>() {
            }.getType();
            List<Modal_Language> languageList = gson.fromJson(response, listType);
            downloadBookletView.fillLanguageSpinner(languageList);
        } else if(header.equalsIgnoreCase(Kix_Constant.FETCH_BOOKLET)){
            Type listType = new TypeToken<ArrayList<Modal_Booklet>>() {
            }.getType();
            List<Modal_Booklet> bookletList = gson.fromJson(response, listType);
            downloadBookletView.fillBookletSpinner(bookletList);
        }

    }

    @Override
    public void receivedError(String header) {

    }
}
