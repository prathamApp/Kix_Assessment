package com.kix.assessment;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

import okhttp3.OkHttpClient;

public class KIXApplication extends Application {

    OkHttpClient okHttpClient;
    public static KIXApplication kixApplication;
    private static final DateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
    private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        if (kixApplication == null) {
            kixApplication = this;
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static UUID getUniqueID() {
        return UUID.randomUUID();
    }

    public static KIXApplication getInstance() {
        return kixApplication;
    }

}
