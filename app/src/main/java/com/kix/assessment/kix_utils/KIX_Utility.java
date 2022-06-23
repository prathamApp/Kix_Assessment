package com.kix.assessment.kix_utils;

import static android.content.Context.ACTIVITY_SERVICE;

import android.annotation.SuppressLint;
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

import androidx.fragment.app.Fragment;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.modal_classes.StorageInfo;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.attendance_activity.Activity_Attendance;
import com.kix.assessment.ui.household_activity.Activity_Household;
import com.kix.assessment.ui.splash_activityy.SplashActivity;
import com.kix.assessment.ui.village_activity.Activity_Village;

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

public class KIX_Utility {

    private static final String TAG = "Utility";
    public static Context context;

    public KIX_Utility(final Context context) {
        KIX_Utility.context = context;
    }

    /**
     * Function to show Fragment
     *
     * @param mActivity
     * @param mFragment
     * @param mBundle
     * @param TAG
     */
    public static void showFragment(final Activity mActivity, final Fragment mFragment, final int frame,
                                    final Bundle mBundle, final String TAG) {

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
        }else if (mActivity instanceof Activity_Village) {
            ((Activity_Village) mActivity).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(frame, mFragment, TAG)
                    .addToBackStack(TAG)
                    .commit();
        }
    }

    public static String getLanguageCode(final String countryName) {
        String code = "NA";
        String country = "NA";
        if (countryName.equalsIgnoreCase("Hindi-India")) {
            country = "IN";
            code = "en";
        } else if (countryName.equalsIgnoreCase("Urdu-Pakistan")) {
            country = "PK";
            code = "ur";
        } else if (countryName.equalsIgnoreCase("Spanish-Nicaragua")) {
            country = "NI";
            code = "es";
        } else if (countryName.equalsIgnoreCase("Spanish-Mexico")) {
            country = "MX";
            code = "es";
        } else if (countryName.equalsIgnoreCase("Bangla-Bangladesh")) {
            country = "BD";
            code = "bn";
        }else if (countryName.equalsIgnoreCase("French-Senegal")) {
            country = "SN";
            code = "fr";
        }else if (countryName.equalsIgnoreCase("French-Mali")) {
            country = "ML";
            code = "fr";
        } else if (countryName.equalsIgnoreCase("Nepali-Nepal")) {
            country = "NP";
            code = "ne";
        } else if (countryName.equalsIgnoreCase("English-Uganda")) {
            country = "UG";
            code = "en";
        } else if (countryName.equalsIgnoreCase("Kiswahili-Tanzania")) {
            country = "TZ";
            code = "sw";
        } else {
            country = "IN";
            code = "en";
        }
        FastSave.getInstance().saveString(Kix_Constant.LANGUAGE_CODE, code);
        FastSave.getInstance().saveString(Kix_Constant.COUNTRY_CODE, country);
        return code;
    }

    //    public static void setMyLocale(Activity activity, String languageCode, String countryCode ) {
//        Locale locale = new Locale(languageCode, countryCode);
    public static void setMyLocale(final Activity activity, final String languageCode, final String countryCode) {
/*        Locale locale = new Locale(languageCode, countryCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());*/
    }

    public static void addFragment(final Activity mActivity, final Fragment mFragment, final int frame,
                                   final Bundle mBundle, final String TAG) {
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
        } else if (mActivity instanceof Activity_Village) {
            ((Activity_Village) mActivity).getSupportFragmentManager()
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
        final Calendar cal = Calendar.getInstance();
        final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        return dateFormat.format(cal.getTime());
    }

    public static String getCurrentDateTime2() {
        final Calendar cal = Calendar.getInstance();
        final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss", Locale.ENGLISH);
        return dateFormat.format(cal.getTime());
    }

    public static String getTimeInMilli() {
        final Calendar cal = Calendar.getInstance();
        return "" + cal.getTimeInMillis();
//        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss", Locale.ENGLISH);
//        return dateFormat.format(cal.getTime());
    }

    public static String getCurrentDate() {
        final Calendar cal = Calendar.getInstance();
        final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return dateFormat.format(cal.getTime());
    }

    public static String getCurrentTime() {
        final Calendar cal = Calendar.getInstance();
        final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        return dateFormat.format(cal.getTime());
    }

    public static void getSdCardPath(final Context context) {
        final String fpath;
        final ArrayList<String> base_path = SDCardUtil.getExtSdCardPaths(context);
        if (base_path.size() > 0) {
            String path = base_path.get(0).replace("[", "");
            path = path.replace("]", "");
            fpath = path;
        } else
            fpath = Environment.getExternalStorageDirectory().getAbsolutePath();

        KIXApplication.contentSDPath = fpath;
    }

    public static String getInternalPath(final Context context) {
        final File[] intDir = context.getExternalFilesDirs("");
        if (intDir.length > 1) {
            try {
                final File file = new File(intDir[1].getAbsolutePath(), "hello.txt");
                if (!file.exists())
                    file.createNewFile();
                file.delete();
                Kix_Constant.STORING_IN = "SD-Card";
                return intDir[1].getAbsolutePath();
            } catch (final Exception e) {
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
     *
     * @param act
     */
    public static void HideInputKeypad(final Activity act) {

        final InputMethodManager inputManager = (InputMethodManager) act
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
    @SuppressLint("HardwareIds")
    public static String getDeviceID() {
        return Settings.Secure.getString(KIXApplication.getInstance().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    //get device name
    public static String getDeviceName() {
        final String manufacturer = Build.MANUFACTURER;
        final String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return KIX_Utility.capitalize(model);
        } else {
            return KIX_Utility.capitalize(manufacturer) + " " + model;
        }
    }

    private static String capitalize(final String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        final char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    //get application name
    public static String getApplicationName(final Context context) {
        String appname = "";
        CharSequence c = "";
        final ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        final List l = am.getRunningAppProcesses();
        final Iterator i = l.iterator();
        final PackageManager pm = context.getPackageManager();
        final ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
        try {
            c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
            appname = c.toString();
            Log.w("LABEL", c.toString());
            return appname;
        } catch (final Exception e) {
            e.printStackTrace();
            return "KIX";
        }
    }

    //get current version
    public static String getCurrentVersion(final Context context) {
        final PackageManager pm = context.getPackageManager();
        PackageInfo pInfo = null;
        try {
            pInfo = pm.getPackageInfo(context.getPackageName(), 0);

        } catch (final PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        final String currentVersion = pInfo.versionName;
        return currentVersion;
    }

    public static String getAndroidOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getInternalStorageStatus() {
        final StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        final long bytesAvailable;
        final long internalStorageSize;
        bytesAvailable = stat.getBlockSizeLong() * stat.getAvailableBlocksLong();
        internalStorageSize = bytesAvailable / (1024 * 1024);
        final String storage = String.valueOf(internalStorageSize);
        return "" + storage + " MB";
    }

    public static String getDeviceManufacturer() {
        return "" + Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return "" + Build.MODEL;
    }

    public static String getScreenResolution() {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) Objects.requireNonNull(KIX_Utility.context.getSystemService(Context.WINDOW_SERVICE)))
                .getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;
        final Configuration config = KIX_Utility.context.getResources().getConfiguration();
        final String strwidth = String.valueOf(width);
        final String strheight = String.valueOf(height);
        Log.d("COSLS", "initialize: COSLS - " + strwidth);

        final String resolution = strwidth + "px x " + strheight + "px (" + config.densityDpi + " dpi)";
        return resolution;
    }

    public static List<StorageInfo> getStorageList() {
        final List<StorageInfo> list = new ArrayList<StorageInfo>();
        final String def_path = Environment.getExternalStorageDirectory().getPath();
        final boolean def_path_removable = Environment.isExternalStorageRemovable();
        final String def_path_state = Environment.getExternalStorageState();
        final boolean def_path_available = def_path_state.equals(Environment.MEDIA_MOUNTED)
                || def_path_state.equals(Environment.MEDIA_MOUNTED_READ_ONLY);
        final boolean def_path_readonly = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY);

        final HashSet<String> paths = new HashSet<String>();
        int cur_removable_number = 1;

        if (def_path_available) {
            paths.add(def_path);
            list.add(0, new StorageInfo(def_path, def_path_readonly, def_path_removable, def_path_removable ? cur_removable_number++ : -1));
        }

        BufferedReader buf_reader = null;
        try {
            buf_reader = new BufferedReader(new FileReader("/proc/mounts"));
            String line;
            Log.d(KIX_Utility.TAG, "/proc/mounts");
            while ((line = buf_reader.readLine()) != null) {
                Log.d(KIX_Utility.TAG, line);
                if (line.contains("vfat") || line.contains("/mnt")) {
                    final StringTokenizer tokens = new StringTokenizer(line, " ");
                    String unused = tokens.nextToken(); //device
                    final String mount_point = tokens.nextToken(); //mount point
                    if (paths.contains(mount_point)) {
                        continue;
                    }
                    unused = tokens.nextToken(); //file system
                    final List<String> flags = Arrays.asList(tokens.nextToken().split(",")); //flags
                    final boolean readonly = flags.contains("ro");

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

        } catch (final FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (buf_reader != null) {
                try {
                    buf_reader.close();
                } catch (final IOException ex) {
                }
            }
        }
        return list;
    }
}
