package com.kix.assessment.dbclasses;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.MimeTypeMap;

import com.kix.assessment.kix_utils.Kix_Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Objects;

import static com.kix.assessment.KIXApplication.getStoragePath;
import static com.kix.assessment.dbclasses.KixDatabase.DB_NAME;
public class BackupDatabase {

/*
    public static void backup(Context mContext) {
        try {
            deletePreviousDbs();
            File sd = new File(Environment.getExternalStorageDirectory() + "/" + Kix_Constant.KIX_BACKUP);
            if (!sd.exists()) sd.mkdir();
            if (sd.canWrite()) {
                File currentDB = mContext.getDatabasePath(DB_NAME);
                File parentPath = currentDB.getParentFile();
                for (File f : parentPath.listFiles()) {
                    File temp = new File(sd, f.getName());
                    if (!temp.exists()) temp.createNewFile();
                    FileChannel src = new FileInputStream(f).getChannel();
                    FileChannel dst = new FileOutputStream(temp).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            } else {
*/
/*                EventMessage message = new EventMessage();
                message.setMessage(PD_Constant.WRITE_PERMISSION);
                EventBus.getDefault().post(message);*//*

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

    public static void backup(Context mContext) {
        try {
            File sd = new File(getStoragePath().getAbsolutePath() + "/KIXBackups");
            if (!sd.exists())
                sd.mkdirs();
            if (sd.canWrite()) {
                File currentDB = mContext.getDatabasePath(KixDatabase.DB_NAME);
                File parentPath = currentDB.getParentFile();
                Log.i("sizess", parentPath.listFiles().length + "--");
                for (File f : parentPath.listFiles()) {
                    Log.i("sizess1", f.getName());
                    File temp = new File(sd, f.getName());
                    if (!temp.exists()) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            ContentResolver resolver = mContext.getContentResolver();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, f.getName());
                            String fileMimeType = getMimeType(f.getAbsolutePath());
                            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, fileMimeType);
                            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS
                                    + File.separator + "KIXBackups");
                            final Uri uriSavedVideo = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
                            FileChannel src = new FileInputStream(f).getChannel();
                            FileOutputStream bos = (FileOutputStream) resolver.openOutputStream(Objects.requireNonNull(uriSavedVideo));
                            FileChannel dst = bos.getChannel();
                            dst.transferFrom(src, 0, src.size());
                            src.close();
                            dst.close();
                        } else {
                            temp.createNewFile();
                            FileChannel src = new FileInputStream(f).getChannel();
                            FileChannel dst = new FileOutputStream(temp).getChannel();
                            dst.transferFrom(src, 0, src.size());
                            src.close();
                            dst.close();
                        }
                    } else {
                        FileChannel src = new FileInputStream(f).getChannel();
                        FileChannel dst = new FileOutputStream(temp).getChannel();
                        dst.transferFrom(src, 0, src.size());
                        src.close();
                        dst.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }

    private static void deletePreviousDbs() {
        File sd = Environment.getExternalStorageDirectory();
        for (File f : sd.listFiles()) {
            if (f.getName().contains(DB_NAME))
                f.delete();
        }
    }
}
