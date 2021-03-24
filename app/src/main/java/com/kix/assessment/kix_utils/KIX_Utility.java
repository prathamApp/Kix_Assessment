package com.kix.assessment.kix_utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.inputmethod.InputMethodManager;

import com.kix.assessment.KIXApplication;
import com.kix.assessment.ui.attendance_activity.Activity_Attendance;
import com.kix.assessment.ui.household_activity.Activity_Household;
import com.kix.assessment.ui.splash_activityy.SplashActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

import androidx.fragment.app.Fragment;

public class KIX_Utility {

    public KIX_Utility(Context context) {
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
}
