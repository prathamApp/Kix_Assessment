package com.kix.assessment.kix_utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.kix.assessment.ui.attendance_activity.Activity_Attendance;
import com.kix.assessment.ui.splash_activityy.SplashActivity;

import java.util.UUID;

import androidx.fragment.app.Fragment;

public class KIX_Utility {

    public KIX_Utility(Context context){}

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
        }  else if (mActivity instanceof Activity_Attendance) {
            ((Activity_Attendance) mActivity).getSupportFragmentManager()
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
        }
    }

    public static UUID getUUID() {
        return UUID.randomUUID();
    }

}
