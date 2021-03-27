package com.kix.assessment.async;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import androidx.documentfile.provider.DocumentFile;

import static com.kix.assessment.KIXApplication.statusDao;
import static com.kix.assessment.dbclasses.KixDatabase.DB_NAME;

public class CopyDbToOTG extends AsyncTask {

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            Uri treeUri = (Uri) objects[0];
            DocumentFile rootFile = DocumentFile.fromTreeUri(KIXApplication.getInstance(), treeUri);
            DocumentFile kix_backup_file = rootFile.findFile("KIX_DBs");
            if (kix_backup_file == null)
                kix_backup_file = rootFile.createDirectory("KIX_DBs");
            String thisdeviceFolderName = "DeviceId" + statusDao.getValue("DeviceId");
            DocumentFile thisTabletFolder = kix_backup_file.findFile(thisdeviceFolderName);
            if (thisTabletFolder == null)
                thisTabletFolder = kix_backup_file.createDirectory(thisdeviceFolderName);
            //copy db files
            File currentDB = KIXApplication.getInstance().getDatabasePath(DB_NAME);
            File parentPath = currentDB.getParentFile();
            for (File f : parentPath.listFiles()) {
                DocumentFile file = thisTabletFolder.findFile(f.getName());
                if (file != null) file.delete();
                file = thisTabletFolder.createFile("image", f.getName());
                copyyFile(file, f);
            }

            //copy helper folder
            File internal_helper = new File(KIXApplication.kixPath, Kix_Constant.HELPER_FOLDER);
            copyActivityData(internal_helper, thisTabletFolder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void copyActivityData(File activityPhotosFile, DocumentFile parentFolder) {
        DocumentFile currentFolder = parentFolder.findFile(activityPhotosFile.getName());
        if (currentFolder == null)
            currentFolder = parentFolder.createDirectory(activityPhotosFile.getName());
        File[] files = activityPhotosFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                Log.d("Files", "\nDirectory : " + file.getName());
                copyActivityData(file, currentFolder);
            } else {
                Log.d("Files", "\nFile : " + file.getName());
                DocumentFile dFile = currentFolder.createFile("image", file.getName());
                if (dFile != null) {
                    copyyFile(dFile, file);
                }
            }
        }
    }

    private void copyyFile(DocumentFile outputFile, File inputFile) {
        try {
            OutputStream out = KIXApplication.getInstance().getContentResolver().openOutputStream(outputFile.getUri());
            FileInputStream in = new FileInputStream(inputFile.getAbsolutePath());
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        EventMessage message = new EventMessage();
        if ((boolean) o) message.setMessage(Kix_Constant.BACKUP_DB_COPIED);
        else message.setMessage(Kix_Constant.BACKUP_DB_NOT_COPIED);
        EventBus.getDefault().post(message);
    }
}
