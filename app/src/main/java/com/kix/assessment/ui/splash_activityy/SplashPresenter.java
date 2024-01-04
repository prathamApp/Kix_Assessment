package com.kix.assessment.ui.splash_activityy;


import static com.kix.assessment.KIXApplication.contentSDPath;
import static com.kix.assessment.KIXApplication.statusDao;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.GameList;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Modal_Status;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@EBean
public class SplashPresenter implements SplashContract.SplashPresenter {

    SplashContract.SplashView splashView;
    Context mContext;

    public SplashPresenter(final Context mContext) {
        this.mContext = mContext;
    }

    //Sets View(UI)
    @Override
    public void setView(final SplashContract.SplashView splashView) {
        this.splashView = splashView;
    }

    @Background
    public void addDataToDB() {
        try {
            List<GameList> gameListList = new ArrayList<>();

            final InputStream is;
            if (KIXApplication.isSDCard) {
                is = new FileInputStream(contentSDPath + "/.KIX/msat_data.json");
            } else {
                is = this.mContext.getAssets().open(Kix_Constant.assessment_Games + "/msat_data.json");
            }

            final int size = is.available();
            final byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            final String jsonStr = new String(buffer);
            final Gson gson = new Gson();
            final Type type = new TypeToken<List<GameList>>() {
            }.getType();
            gameListList = gson.fromJson(jsonStr, type);

            final List<Modal_Content> modal_contentList = new ArrayList<>();
            for (int i = 0; i < gameListList.size(); i++) {
                final Modal_Content modal_content = new Modal_Content();
                modal_content.setContentBooklet("" + gameListList.get(i).getContentBooklet());
                modal_content.setContentCode("" + gameListList.get(i).getContentCode());
                modal_content.setContentFolderName("" + gameListList.get(i).getContentFolderName());
                modal_content.setContentCountry("" + gameListList.get(i).getContentCountry());
                modal_contentList.add(modal_content);
            }
            KixDatabase.getDatabaseInstance(this.mContext).getContentDao().insertAll(modal_contentList);
            FastSave.getInstance().saveBoolean(Kix_Constant.DATA_COPIED, true);
            BackupDatabase.backup(this.mContext);
            this.splashView.openSignupFragment();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    @Background
    @Override
    public void populateDefaultDB() {
        final Modal_Status statusObj = new Modal_Status();
        if (statusDao.getKey("deviceId") == null) {
            statusObj.statusKey = "deviceId";
            statusObj.value = KIX_Utility.getDeviceID();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("deviceName") == null) {
            statusObj.statusKey = "deviceName";
            statusObj.value = KIX_Utility.getDeviceName();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("serialId") == null) {
            statusObj.statusKey = "serialId";
            statusObj.value = KIX_Utility.getDeviceSerialID();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("apkType") == null) {
            statusObj.statusKey = "apkType";
            statusObj.value = "KIX FT3 MSAT App";
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("countryName") == null) {
            statusObj.statusKey = "countryName";
            statusObj.value = KIXApplication.app_country;
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("appName") == null) {
            statusObj.statusKey = "appName";
            statusObj.value = KIX_Utility.getApplicationName(this.mContext);
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("apkVersion") == null) {
            statusObj.statusKey = "apkVersion";
            statusObj.value = KIX_Utility.getCurrentVersion(this.mContext);
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("appBuildDate") == null) {
            statusObj.statusKey = "appBuildDate";
            statusObj.value = KIXApplication.appBuildDate;
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("androidOSVersion") == null) {
            statusObj.statusKey = "androidOSVersion";
            statusObj.value = KIX_Utility.getAndroidOSVersion();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("internalStorage") == null) {
            statusObj.statusKey = "internalStorage";
            statusObj.value = KIX_Utility.getInternalStorageStatus();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("deviceModel") == null) {
            statusObj.statusKey = "deviceModel";
            statusObj.value = KIX_Utility.getDeviceModel();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("deviceManufacturer") == null) {
            statusObj.statusKey = "deviceManufacturer";
            statusObj.value = KIX_Utility.getDeviceManufacturer();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("screenResolution") == null) {
            statusObj.statusKey = "screenResolution";
            statusObj.value = KIX_Utility.getScreenResolution();
            statusDao.insert(statusObj);
        }
        if (statusDao.getKey("wifiMAC") == null) {
            statusObj.statusKey = "wifiMAC";
            final WifiManager wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            final WifiInfo wInfo = wifiManager.getConnectionInfo();
            statusObj.value = wInfo.getMacAddress();
            statusDao.insert(statusObj);
        }
    }
}

