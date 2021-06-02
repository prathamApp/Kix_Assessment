package com.kix.assessment.async;

import android.content.Context;
import android.util.Log;

import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Modal_Download;
import com.kix.assessment.temp.Modal_FileDownloading;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

//import net.lingala.zip4j.core.ZipFile;
//import net.lingala.zip4j.exception.ZipException;


@EBean
public class ContentDownloadingTask {

    private static final String TAG = ContentDownloadingTask.class.getSimpleName();
    String url;
    String dir_path;
    String f_name;
    String folder_name;
    Modal_Content content;
    String downloadID;
    boolean unziping_error = false;
    Context context;
    //GamesDisplay gamesDisplay;
    //    DownloadService downloadService;
    ArrayList<Modal_Content> levelContents;

    public ContentDownloadingTask(Context context) {
        this.context = context;
    }

    public void initialize(Modal_Download download) {
        this.url = download.getUrl();
        this.dir_path = download.getDir_path();
        this.f_name = download.getF_name();
        this.folder_name = download.getFolder_name();
        this.content = download.getContent();
        this.downloadID = download.getContent().getContentCode();
        this.levelContents = download.getLevelContents();
        //gamesDisplay = new GamesDisplay();
    }

    protected void afterInit() {
        Modal_FileDownloading modal_fileDownloading = new Modal_FileDownloading();
        modal_fileDownloading.setDownloadId(downloadID);
        modal_fileDownloading.setFilename(content.getContentFolderName());
        modal_fileDownloading.setProgress(0);
        modal_fileDownloading.setContentDetail(content);
        EventMessage eventMessage = new EventMessage();
        eventMessage.setModal_fileDownloading(modal_fileDownloading);
        eventMessage.setMessage(Kix_Constant.FILE_DOWNLOAD_STARTED);
        EventBus.getDefault().post(eventMessage);
        //gamesDisplay.fileDownloadStarted(downloadID, modal_fileDownloading);
    }

    @Background
    public void startContentDownload(Modal_Download download, boolean unzipFlg) {
        Log.d(TAG, "doInBackground: url: " + url);
        initialize(download);
        afterInit();
        InputStream input = null;
        OutputStream output = null;
        HttpURLConnection connection = null;
        try {
            // String root = Environment.getExternalStorageDirectory().toString();
            URL urlFormed = new URL(url);
            connection = (HttpURLConnection) urlFormed.openConnection();
            connection.setConnectTimeout(15000);
            connection.connect();
            // expect HTTP 200 OK, so we don't mistakenly save error report
            // instead of the file
            Log.d(TAG, "doInBackground: getResponseCode: " + connection.getResponseCode());
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // getting file length
                dowloadImages();
                int lenghtOfFile = connection.getContentLength();
                // input stream to read file - with 8k buffer
                input = connection.getInputStream();
                // Output stream to write file
                output = new FileOutputStream(dir_path + "/" + f_name);
                byte[] data = new byte[4096];
                long total = 0;
//                long download_percentage_old = 00;
                int count;
                while ((count = input.read(data)) != -1) {
/*                if (isCancelled()) {
                    input.close();
                    return false;
                }*/
                    total += count;
                    // writing data to file
                    output.write(data, 0, count);
                    long download_percentage_new = (100 * total) / lenghtOfFile;
                    updateProgress(download_percentage_new);
                }
                // flushing output AND closing streams
                output.close();
                input.close();

//                unziping_error = unzipFile(dir_path + "/" + f_name, dir_path);

//                if (unzipFlg) {
//                    unziping_error = unzipFile(dir_path + "/" + f_name, dir_path+ "/");

                unzip(new ZipFile(dir_path +"/"+ f_name), new File(dir_path+ "/"));
//                    unzip(dir_path + "/Downloads.zip", dir_path+ "/");
                    if (unziping_error)
                        unzipingError();
                    else
                        downloadCompleted();
//                } else
//                    downloadCompleted();

            } else {
//                IS_DOWNLOADING = false;
                EventMessage eventMessage = new EventMessage();
                eventMessage.setMessage(Kix_Constant.RESPONSE_CODE_ERROR);
                EventBus.getDefault().post(eventMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            IS_DOWNLOADING = false;
            EventMessage eventMessage = new EventMessage();
            eventMessage.setMessage(Kix_Constant.FILE_DOWNLOAD_ERROR);
            EventBus.getDefault().post(eventMessage);
        }
    }

    public void unzip(ZipFile source, File destination) throws IOException {
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
            }
        }
    }

/*
    public void unzip(String source, String dest) throws IOException {
        java.util.zip.ZipFile zipFile = new ZipFile(source);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                File entryDestination = new File(dest, entry.getName());
                if (entry.isDirectory()) {
                    entryDestination.mkdirs();
                } else {
                    entryDestination.getParentFile().mkdirs();
                    InputStream in = zipFile.getInputStream(entry);
                    OutputStream out = new FileOutputStream(entryDestination);
                    IOUtils.copy(in, out);
                    IOUtils.closeQuietly(in);
                    out.close();
                }
            }
        } finally {
            zipFile.close();
        }
    }
*/


    private void unzipingError() {
//        IS_DOWNLOADING = false;
        EventMessage eventMessage = new EventMessage();
        eventMessage.setMessage(Kix_Constant.UNZIPPING_ERROR);
        EventBus.getDefault().post(eventMessage);
        onCompleteContentDownloadTase(false);
    }

    @Background
    public void downloadCompleted() {
        Log.d(TAG, "updateFileProgress: " + downloadID);
        ArrayList<Modal_Content> temp = new ArrayList<>(levelContents);
        for(int j=0; j<levelContents.size(); j++){
            if(content.getContentCode().equalsIgnoreCase(levelContents.get(j).getContentCode()))
                content = temp.get(j);
        }
        temp.add(content);
        for (int i = 0; i < temp.size(); i++) {
//            temp.get(i).setIsDownloaded("" + true);
//            temp.get(i).setOnSDCard(false);
//            if (temp.get(i).getStudentId() != null)
//                temp.get(i).setStudentId(temp.get(i).getStudentId() + "," + FastSave.getInstance().getString(CURRENT_STUDENT_ID, ""));
//            else
//                temp.get(i).setStudentId(FastSave.getInstance().getString(CURRENT_STUDENT_ID, ""));
        }
//        IS_DOWNLOADING = false;
//        KixDatabase.getDatabaseInstance(context).getContentTableDao().addContentList(temp);
        onCompleteContentDownloadTase(true);
    }

    private void updateProgress(long download_percentage_new) {
        if (downloadID != null) {
            Modal_FileDownloading modal_fileDownloading = new Modal_FileDownloading();
            modal_fileDownloading.setDownloadId(downloadID);
            modal_fileDownloading.setFilename("content.getNodeTitle()");
            modal_fileDownloading.setProgress((int) download_percentage_new);
            modal_fileDownloading.setContentDetail(content);
            onProgressUpdate(modal_fileDownloading);
        }
    }

    private void dowloadImages() {
    }

    public void onProgressUpdate(Modal_FileDownloading modal_fileDownloading) {
//        Modal_FileDownloading mfd = (Modal_FileDownloading) values[0];
        Log.d(TAG, "onProgressUpdate: " + downloadID + ":::" + f_name + ":::" + modal_fileDownloading.getProgress());
        EventMessage eventMessage = new EventMessage();
        eventMessage.setModal_fileDownloading(modal_fileDownloading);
        eventMessage.setMessage(Kix_Constant.FILE_DOWNLOAD_UPDATE);
        EventBus.getDefault().post(eventMessage);
    }

    protected void onCompleteContentDownloadTase(boolean success) {
        Log.d(TAG, "onPostExecute");
//        IS_DOWNLOADING = false;
        if (success) {
            EventMessage eventMessage = new EventMessage();
            eventMessage.setMessage(Kix_Constant.FILE_DOWNLOAD_COMPLETE);
            EventBus.getDefault().post(eventMessage);
//            gamesDisplay.onDownloadCompleted(downloadID, content);
        } else {
            EventMessage eventMessage = new EventMessage();
            eventMessage.setMessage(Kix_Constant.FILE_DOWNLOAD_ERROR);
            EventBus.getDefault().post(eventMessage);
//            gamesDisplay.ondownloadError(downloadID);
        }
    }
}
