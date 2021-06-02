package com.kix.assessment.ui.profile.fragment_chooseBooklet;

import android.content.Context;
import android.util.Log;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.async.API_Content;
import com.kix.assessment.async.ZipDownloader;
import com.kix.assessment.interfaces.API_Content_Result;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Booklet;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Modal_Country;
import com.kix.assessment.modal_classes.Modal_DownloadContent;
import com.kix.assessment.modal_classes.Modal_Language;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
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
        api_content.getAPIContent(Kix_Constant.DOWNLOAD_BOOKLET, Kix_Constant.DOWNLOAD_BOOKLET_API, nodeID);
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
        if (header.equalsIgnoreCase(Kix_Constant.DOWNLOAD_BOOKLET)) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                Modal_DownloadContent download_content = gson.fromJson(jsonObject.toString(), Modal_DownloadContent.class);
//                contentDetail = download_content.getNodelist().get(download_content.getNodelist().size() - 1);

                String fileName = "";
                fileName = download_content.getDownloadurl()
                        .substring(download_content.getDownloadurl().lastIndexOf('/') + 1);
                ArrayList<Modal_Content> pos = new ArrayList<>();
                pos.addAll(download_content.getNodelist());
                Modal_Content dwContent = pos.get(0);
                Log.d("HP", "doInBackground: fileName : " + fileName);
                Log.d("HP", "doInBackground: DW URL : " + download_content.getDownloadurl());
                File mydir = null;
                mydir = new File(KIXApplication.kixPath + "/.KIX");
                if (!mydir.exists()) mydir.mkdirs();
                zipDownloader.initialize(mContext, download_content.getDownloadurl(), fileName, pos, dwContent);
//                downloadZip(download_content.getDownloadurl(), KIXApplication.kixPath + "/.KIX", fileName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (header.equalsIgnoreCase(Kix_Constant.FETCH_COUNTRY)) {
            Type listType = new TypeToken<ArrayList<Modal_Country>>() {
            }.getType();
            List<Modal_Country> countryList = gson.fromJson(response, listType);
            downloadBookletView.fillCountrySpinner(countryList);
        } else if (header.equalsIgnoreCase(Kix_Constant.FETCH_LANGUAGE)) {
            Type listType = new TypeToken<ArrayList<Modal_Language>>() {
            }.getType();
            List<Modal_Language> languageList = gson.fromJson(response, listType);
            downloadBookletView.fillLanguageSpinner(languageList);
        } else if (header.equalsIgnoreCase(Kix_Constant.FETCH_BOOKLET)) {
            Type listType = new TypeToken<ArrayList<Modal_Booklet>>() {
            }.getType();
            List<Modal_Booklet> bookletList = gson.fromJson(response, listType);
            downloadBookletView.fillBookletSpinner(bookletList);
        }

    }

/*
    public void downloadZip(String url, String dirPath, String fileName) {
        AndroidNetworking.download(url, dirPath, fileName)
                .setTag("downloadTest")
                .setPriority(Priority.MEDIUM)
                .build()
                .setDownloadProgressListener(new DownloadProgressListener() {
                    @Override
                    public void onProgress(long bytesDownloaded, long totalBytes) {
                        // do anything with progress
                    }
                })
                .startDownload(new DownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        downloadBookletView.dismissLoadingDialog();
                        downloadBookletView.showTost("Complete");
                        try {
                            unzip(new ZipFile(dirPath +"/"+ fileName), new File(dirPath+ "/"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // do anything after completion
                    }

                    @Override
                    public void onError(ANError error) {
                        downloadBookletView.dismissLoadingDialog();
                        downloadBookletView.showTost("Error");
                        // handle error
                    }
                });
    }
*/

/*    public void unzip(ZipFile source, File destination) throws IOException {
        for (final ZipEntry entry : Collections.list(source.entries())) {
            unzip(source, entry, destination);
        }
    }
    private static void unzip(final ZipFile source, final ZipEntry entry, final File destination) throws IOException {
        if (!entry.isDirectory()) {
            final File resource = new File(destination, entry.getName());
            if (!resource.getCanonicalPath().startsWith(destination.getCanonicalPath() + File.separator)) {
                throw new IOException("Entry is outside of the target dir: " + entry);
            }
            final File folder = resource.getParentFile();
            if (!folder.exists()) {
                if (!folder.mkdirs()) {
                    throw new IOException();
                }
            }
            try (final BufferedInputStream input = new BufferedInputStream(source.getInputStream(entry));
                 final BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(resource))) {
                output.write(input.read());
                output.flush();
                Toast.makeText(KIXApplication.getInstance(), "Unzip Complete", Toast.LENGTH_SHORT).show();
            }
        }
    }*/


    @Override
    public void receivedError(String header) {

    }
}
