package com.kix.assessment.async;

import android.content.Context;
import android.util.Log;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.modal_classes.Modal_Download;
import com.kix.assessment.newtemp.ContentTable;

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
                           String foldername, String f_name,ArrayList<ContentTable> levelContents, ContentTable contentTable) {
        this.filename = f_name;
        this.unzipFlg = unzipFlg;
        createFolderAndStartDownload(url, foldername, f_name, context, levelContents, contentTable);
    }

    /*Creating folder in internal.
     *That internal might be of android internal or sdcard internal (if available and writable)
     * */
    private void createFolderAndStartDownload(String url, String foldername, String f_name,
                                              Context context,ArrayList<ContentTable> levelContents, ContentTable contentTable) {


        File mydir = null;
        mydir = new File(KIXApplication.kixPath + "/.KIX");
        if (!mydir.exists()) mydir.mkdirs();

        Log.d("internal_file", mydir.getAbsolutePath());
        Modal_Download modal_download = new Modal_Download();
        modal_download.setUrl(url);
        modal_download.setDir_path(mydir.getAbsolutePath());
        modal_download.setF_name(filename);
        modal_download.setFolder_name(foldername);
        modal_download.setContent(contentTable);
        modal_download.setLevelContents(levelContents);
        contentDownloadingTask.startContentDownload(modal_download, unzipFlg);
//        new DownloadingTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, modal_download);
    }


//    private void createOverSdCardAndStartDownload(String url, String foldername, String f_name,
//                                                  ContentTable contentDetail,
//                                                  ArrayList<ContentTable> levelContents) {
//        String path = FastSave.getInstance().getString(KIXApplication.contentSDPath, "");
//        if (path.isEmpty())
//            return;
//        DocumentFile documentFile = DocumentFile.fromFile(new File(path));
//        if (documentFile.findFile("/.FCA/"+currentSubjectFolder+"/" + foldername) != null)
//            documentFile = documentFile.findFile("/.FCA/"+currentSubjectFolder+"/" + foldername);
//        else
//            documentFile = documentFile.createDirectory("/.FCA/"+currentSubjectFolder+"/" + foldername);
//        if (ApplicationClass.wiseF.isDeviceConnectedToSSID(FC_Constants.PRATHAM_KOLIBRI_HOTSPOT)) {
//            if (foldername.equalsIgnoreCase(FC_Constants.GAME)) {
//                f_name = f_name.substring(0, f_name.lastIndexOf("."));
//                if (documentFile.findFile(f_name) != null)
//                    documentFile = documentFile.findFile(f_name);
//                else
//                    documentFile = documentFile.createDirectory(f_name);
//            }
//        }
//        Modal_Download modal_download = new Modal_Download();
//        modal_download.setUrl(url);
//        modal_download.setDir_path(FileUtils.getPath(ApplicationClass.getInstance(), documentFile.getUri()));
//        modal_download.setF_name(filename);
//        modal_download.setFolder_name(foldername);
//        modal_download.setContent(contentDetail);
//        modal_download.setLevelContents(levelContents);
//        IS_DOWNLOADING = true;
//        contentDownloadingTask.startContentDownload(modal_download, unzipFlg);
////        new DownloadingTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, modal_download);
//    }
}