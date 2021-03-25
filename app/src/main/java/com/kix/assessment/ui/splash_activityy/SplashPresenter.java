package com.kix.assessment.ui.splash_activityy;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.modal_classes.GameList;
import com.kix.assessment.modal_classes.Modal_Content;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.kix.assessment.KIXApplication.contentSDPath;

@EBean
public class SplashPresenter implements SplashContract.SplashPresenter {

    SplashContract.SplashView splashView;
    Context mContext;

    //Sets View(UI)
    @Override
    public void setView(SplashContract.SplashView splashView) {
        this.splashView = splashView;
    }

    public SplashPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Background
    public void addDataToDB() {
        try {
            List<GameList> gameListList = new ArrayList<>();
            InputStream is = new FileInputStream(contentSDPath + "/.KIX/Data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String jsonStr = new String(buffer);
//            JSONObject jsonObj = new JSONObject(jsonStr);
            Gson gson = new Gson();
            Type type = new TypeToken<List<GameList>>() {
            }.getType();
            gameListList = gson.fromJson(jsonStr, type);
            List<Modal_Content> modal_contentList = new ArrayList<>();
            for(int i=0; i<gameListList.size(); i++){
                Modal_Content modal_content = new Modal_Content();
                modal_content.setContentBooklet(""+gameListList.get(i).getBooklet());
                modal_content.setContentCode(""+gameListList.get(i).getCode());
                modal_content.setContentFolderName(""+gameListList.get(i).getFolder_name());
                modal_contentList.add(modal_content);
            }
            KixDatabase.getDatabaseInstance(mContext).getContentDao().insertAll(modal_contentList);
            BackupDatabase.backup(mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

