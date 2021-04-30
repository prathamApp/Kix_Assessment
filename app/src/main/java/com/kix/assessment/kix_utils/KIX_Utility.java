package com.kix.assessment.kix_utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.modal_classes.StorageInfo;
import com.kix.assessment.ui.attendance_activity.Activity_Attendance;
import com.kix.assessment.ui.household_activity.Activity_Household;
import com.kix.assessment.ui.profile.ProfileActivity;
import com.kix.assessment.ui.splash_activityy.SplashActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.UUID;

import androidx.fragment.app.Fragment;

import static android.content.Context.ACTIVITY_SERVICE;

public class KIX_Utility {

    private static String TAG = "Utility";
    public static Context context;
    public KIX_Utility(Context context) {
        KIX_Utility.context =context;
    }

    /**
     * Function to show Fragment
     *
     * @param mActivity
     * @param mFragment
     * @param mBundle
     * @param TAG
     */
    public static void showFragment(Activity mActivity, Fragment mFragment, int frame,
                                    Bundle mBundle, String TAG) {

        if (mBundle != null)
            mFragment.setArguments(mBundle);

        if (mActivity instanceof SplashActivity) {
            ((SplashActivity) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        } else if (mActivity instanceof Activity_Attendance) {
            ((Activity_Attendance) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        } else if (mActivity instanceof Activity_Household) {
            ((Activity_Household) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        } else if (mActivity instanceof ProfileActivity) {
            ((ProfileActivity) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        }
    }

    public static void addFragment(Activity mActivity, Fragment mFragment, int frame,
                                   Bundle mBundle, String TAG) {
        if (mBundle != null)
            mFragment.setArguments(mBundle);
        if (mActivity instanceof SplashActivity) {
            ((SplashActivity) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .add(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        } else if (mActivity instanceof Activity_Attendance) {
            ((Activity_Attendance) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .add(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        } else if (mActivity instanceof Activity_Household) {
            ((Activity_Household) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .add(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        } else if (mActivity instanceof ProfileActivity) {
            ((ProfileActivity) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .add(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        }
    }

    public static UUID getUUID() {
        return UUID.randomUUID();
    }


    public static String getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        return dateFormat.format(cal.getTime());
    }

    public static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return dateFormat.format(cal.getTime());
    }

    public static String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        return dateFormat.format(cal.getTime());
    }

    public static void getSdCardPath(Context context) {
        String fpath;
        ArrayList<String> base_path = SDCardUtil.getExtSdCardPaths(context);
        if (base_path.size() > 0) {
            String path = base_path.get(0).replace("[", "");
            path = path.replace("]", "");
            fpath = path;
        } else
            fpath = Environment.getExternalStorageDirectory().getAbsolutePath();

        KIXApplication.contentSDPath = fpath;
    }

    public static String getInternalPath(Context context) {
        File[] intDir = context.getExternalFilesDirs("");
        if (intDir.length > 1) {
            try {
                File file = new File(intDir[1].getAbsolutePath(), "hello.txt");
                if (!file.exists())
                    file.createNewFile();
                file.delete();
                Kix_Constant.STORING_IN = "SD-Card";
                return intDir[1].getAbsolutePath();
            } catch (Exception e) {
                e.printStackTrace();
                Kix_Constant.STORING_IN = "Internal Storage";
                return intDir[0].getAbsolutePath();
            }
        } else {
            Kix_Constant.STORING_IN = "Internal Storage";
            return intDir[0].getAbsolutePath();
        }
    }


    /**
     * Method to Hide Soft Input Keyboard
     * @param act
     */
    public static void HideInputKeypad(Activity act) {

        InputMethodManager inputManager = (InputMethodManager) act
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (act.getCurrentFocus() != null)
            inputManager.hideSoftInputFromWindow(act.getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }

    //get serial Id of device
    public static String getDeviceSerialID() {
        return Build.SERIAL;
    }

    //get device id
    public static String getDeviceID() {
        return Settings.Secure.getString(KIXApplication.getInstance().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    //get device name
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    //get application name
    public static String getApplicationName(Context context) {
        String appname = "";
        CharSequence c = "";
        ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = context.getPackageManager();
        ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
        try {
            c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
            appname = c.toString();
            Log.w("LABEL", c.toString());
            return appname;
        } catch (Exception e) {
            e.printStackTrace();
            return "KIX";
        }
    }

    //get current version
    public static String getCurrentVersion(Context context) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pInfo = null;
        try {
            pInfo = pm.getPackageInfo(context.getPackageName(), 0);

        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        String currentVersion = pInfo.versionName;
        return currentVersion;
    }

    public static String getAndroidOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getInternalStorageStatus() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long bytesAvailable, internalStorageSize;
        bytesAvailable = stat.getBlockSizeLong() * stat.getAvailableBlocksLong();
        internalStorageSize = bytesAvailable / (1024 * 1024);
        String storage = String.valueOf(internalStorageSize);
        return "" + storage + " MB";
    }

    public static String getDeviceManufacturer() {
        return "" + Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return "" + Build.MODEL;
    }

    public static String getScreenResolution() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) Objects.requireNonNull(context.getSystemService(Context.WINDOW_SERVICE)))
                .getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Configuration config = context.getResources().getConfiguration();
        String strwidth = String.valueOf(width);
        String strheight = String.valueOf(height);
        Log.d("COSLS", "initialize: COSLS - " + strwidth);

        String resolution = strwidth + "px x " + strheight + "px (" + config.densityDpi + " dpi)";
        return resolution;
    }

    public static List<StorageInfo> getStorageList() {
        List<StorageInfo> list = new ArrayList<StorageInfo>();
        String def_path = Environment.getExternalStorageDirectory().getPath();
        boolean def_path_removable = Environment.isExternalStorageRemovable();
        String def_path_state = Environment.getExternalStorageState();
        boolean def_path_available = def_path_state.equals(Environment.MEDIA_MOUNTED)
                || def_path_state.equals(Environment.MEDIA_MOUNTED_READ_ONLY);
        boolean def_path_readonly = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY);

        HashSet<String> paths = new HashSet<String>();
        int cur_removable_number = 1;

        if (def_path_available) {
            paths.add(def_path);
            list.add(0, new StorageInfo(def_path, def_path_readonly, def_path_removable, def_path_removable ? cur_removable_number++ : -1));
        }

        BufferedReader buf_reader = null;
        try {
            buf_reader = new BufferedReader(new FileReader("/proc/mounts"));
            String line;
            Log.d(TAG, "/proc/mounts");
            while ((line = buf_reader.readLine()) != null) {
                Log.d(TAG, line);
                if (line.contains("vfat") || line.contains("/mnt")) {
                    StringTokenizer tokens = new StringTokenizer(line, " ");
                    String unused = tokens.nextToken(); //device
                    String mount_point = tokens.nextToken(); //mount point
                    if (paths.contains(mount_point)) {
                        continue;
                    }
                    unused = tokens.nextToken(); //file system
                    List<String> flags = Arrays.asList(tokens.nextToken().split(",")); //flags
                    boolean readonly = flags.contains("ro");

                    if (line.contains("/dev/block/vold")) {
                        if (!line.contains("/mnt/secure")
                                && !line.contains("/mnt/asec")
                                && !line.contains("/mnt/obb")
                                && !line.contains("/dev/mapper")
                                && !line.contains("tmpfs")) {
                            paths.add(mount_point);
                            list.add(new StorageInfo(mount_point, readonly, true, cur_removable_number++));
                        }
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (buf_reader != null) {
                try {
                    buf_reader.close();
                } catch (IOException ex) {
                }
            }
        }
        return list;
    }
}
