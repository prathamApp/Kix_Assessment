package com.kix.assessment.async;

import android.content.Context;
import android.util.Log;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Modal_Download;

import org.androidannotations.annotations.EBean;

import java.io.File;
import java.util.ArrayList;

import static com.kix.assessment.ui.profile.ProfileActivity.contentDownloadingTask;


/**
 * Created by User on 16/11/15.
 */
@EBean
public class ZipDownloader {

    private static final String TAG = ZipDownloader.class.getSimpleName();
    String filename;
    Context context;
    boolean unzipFlg;

    public ZipDownloader(Context context) {
        this.context = context;
    }

    public void initialize(Context context, String url,
                           String f_name, ArrayList<Modal_Content> levelContents, Modal_Content contentTable) {
        this.filename = f_name;
        this.unzipFlg = unzipFlg;
        createFolderAndStartDownload(url, f_name, context, levelContents, contentTable);
    }

    /*Creating folder in internal.
     *That internal might be of android internal or sdcard internal (if available and writable)
     * */
    private void createFolderAndStartDownload(String url, String f_name,
                                              Context context,ArrayList<Modal_Content> levelContents, Modal_Content contentTable) {

        File mydir = null;
        mydir = new File(KIXApplication.kixPath + "/.KIX");
        if (!mydir.exists()) mydir.mkdirs();

        Log.d("internal_file", mydir.getAbsolutePath());
        Modal_Download modal_download = new Modal_Download();
        modal_download.setUrl(url);
        modal_download.setDir_path(mydir.getAbsolutePath());
        modal_download.setF_name(filename);
        modal_download.setFolder_name("");
        modal_download.setContent(contentTable);
        modal_download.setLevelContents(levelContents);
        contentDownloadingTask.startContentDownload(modal_download, unzipFlg);
    }

}