package com.kix.assessment.ui.main_test;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.BaseActivity;
import com.kix.assessment.R;
import com.kix.assessment.custom.NonSwipeableViewPager;
import com.kix.assessment.custom.dots_indicator.WormDotsIndicator;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.GameList;
import com.kix.assessment.modal_classes.Score;

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
import java.util.Objects;


@EActivity(R.layout.activity_main_test)
public class MainTestActivity extends BaseActivity implements MainTestContract.MainTestView {

    @Bean(MainTestPresenter.class)
    MainTestPresenter mainTestPresenter;

    @ViewById(R.id.fragment_view_pager)
    NonSwipeableViewPager fragment_view_pager;
    @ViewById(R.id.dots_indicator)
    WormDotsIndicator dots_indicator;
    @ViewById(R.id.btn_next)
    Button btn_next;
    @ViewById(R.id.rl_gameover)
    RelativeLayout rl_gameover;
    @ViewById(R.id.btn_next_student)
    Button btn_next_student;

    ViewpagerAdapter viewpagerAdapter;
    public static List<GameList> gameListList;
    public static List<Score> scoresList;
    Fragment currentFragment;
    public static int queCnt = 0;

    @AfterViews
    public void init() {
        Toast.makeText(this, "Welcome "+getIntent().getStringExtra(Kix_Constant.STUDENT_NAME), Toast.LENGTH_SHORT).show();
        rl_gameover.setVisibility(View.GONE);
        gotoNext();
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
        scoresList = new ArrayList<>();
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
    }

    @Click(R.id.btn_next)
    public void nextClicked() {
        queCnt++;
        if (queCnt < gameListList.size()) {
            fragment_view_pager.setCurrentItem(queCnt);
        }else{
            fragment_view_pager.setVisibility(View.GONE);
            rl_gameover.setVisibility(View.VISIBLE);
        }
    }

    @Click(R.id.btn_next_student)
    public void nextStudentClicked() {
        KixDatabase.getDatabaseInstance(this).getScoreDao().addScoreList(scoresList);
        BackupDatabase.backup(this);
        finish();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "BACK", Toast.LENGTH_SHORT).show();
    }

    public Dialog nextDialog;
    Button dia_yes,dia_no;
    TextView dia_title;

    public void testOverDialog(boolean testOver) {

        nextDialog = null;
        nextDialog = new Dialog(this);
        nextDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(nextDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        nextDialog.setContentView(R.layout.next_game_dialog);
        nextDialog.setCanceledOnTouchOutside(false);
        nextDialog.show();

        dia_title = nextDialog.findViewById(R.id.dia_title);
        dia_yes = nextDialog.findViewById(R.id.dia_yes);
        dia_no = nextDialog.findViewById(R.id.dia_no);
           dia_title.setText("Submit Test");
        dia_no.setOnClickListener(v -> nextDialog.dismiss());
        dia_yes.setOnClickListener(v -> {
            if(testOver) {
            }else
                nextDialog.dismiss();
        });
        nextDialog.show();
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