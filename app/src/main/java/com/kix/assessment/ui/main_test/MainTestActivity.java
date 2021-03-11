package com.kix.assessment.ui.main_test;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.R;
import com.kix.assessment.custom.NonSwipeableViewPager;
import com.kix.assessment.custom.dots_indicator.WormDotsIndicator;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.GameList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@EActivity(R.layout.activity_main_test)
public class MainTestActivity extends AppCompatActivity implements MainTestContract.MainTestView {

    @Bean(MainTestPresenter.class)
    MainTestPresenter mainTestPresenter;

    @ViewById(R.id.fragment_view_pager)
    NonSwipeableViewPager fragment_view_pager;
    @ViewById(R.id.dots_indicator)
    WormDotsIndicator dots_indicator;
    @ViewById(R.id.btn_next)
    Button btn_next;

    ViewpagerAdapter viewpagerAdapter;
    public static List<GameList> gameListList;
    Fragment currentFragment;
    public static int queCnt = 0;

    @AfterViews
    public void init() {
        new Handler().postDelayed(this::gotoNext, 500);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void gotoNext() {
        gameListList = new ArrayList<>();
        queCnt = 0;
        try {
            InputStream is = new FileInputStream(Environment.getExternalStorageDirectory().toString()+"/.KIX/Data.json");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        setAdapter();
        Toast.makeText(this, "GOTO Next", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.btn_next)
    public void nextClicked() {
        if (queCnt < gameListList.size()) {
            queCnt++;
            fragment_view_pager.setCurrentItem(queCnt);
        }

    }

    @UiThread
    public void setAdapter() {
        try {
            viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), this, gameListList);
//        fragment_view_pager.setOffscreenPageLimit(scienceQuestionList.size());
            fragment_view_pager.setSaveFromParentEnabled(true);
            fragment_view_pager.setAdapter(viewpagerAdapter);
            dots_indicator.setViewPager(fragment_view_pager);
            currentFragment = viewpagerAdapter.getItem(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageReceived(EventMessage message) {
        if (message != null) {
            if (message.getMessage().equalsIgnoreCase("nextGame"))
                btn_next.performClick();
        }
    }
}