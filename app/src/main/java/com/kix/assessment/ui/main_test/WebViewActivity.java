package com.kix.assessment.ui.main_test;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kix.assessment.BaseActivity;
import com.kix.assessment.R;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Score;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.kix.assessment.KIXApplication.contentSDPath;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;


@EActivity(R.layout.activity_web_view)
public class WebViewActivity extends BaseActivity implements WebViewInterface {

    @ViewById(R.id.web_view)
    WebView webView;
    @ViewById(R.id.rl_gameover)
    RelativeLayout rl_gameover;
    @ViewById(R.id.btn_next_student)
    Button btn_next_student;
    @ViewById(R.id.tv_thankyou)
    TextView tv_thankyou;

    public static List<Modal_Content> gameListList;
    public static List<Score> scoresList;
    public String studentName;
    public static int queCnt = 0;

    @AfterViews
    public void init() {
        studentName = getIntent().getStringExtra(Kix_Constant.STUDENT_NAME);
        rl_gameover.setVisibility(View.GONE);
        gameListList = new ArrayList<>();
        scoresList = new ArrayList<>();
        queCnt = 0;
        try {
            String bklet = ""+FastSave.getInstance().getString(Kix_Constant.BOOKLET,"Booklet 1");
            Log.d("WebView", "Kix_Constant.BOOKLET: " + bklet);
            gameListList = KixDatabase.getDatabaseInstance(this).getContentDao().getContentByBooklet("%"+bklet+",%");
        } catch (Exception e) {
            e.printStackTrace();
        }
        createWebView(queCnt);
    }

    @UiThread
    @SuppressLint("JavascriptInterface")
    public void createWebView(int pos) {
        try {
            if (new File(contentSDPath + "/.KIX/" + gameListList.get(pos).getContentFolderName()).exists()) {
                webView.loadUrl(contentSDPath + "/.KIX/" + gameListList.get(pos).getContentFolderName());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
                webView.addJavascriptInterface(new JSInterface(this, this, webView, ""), "Android");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if (0 != (this.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE)) {
                        WebView.setWebContentsDebuggingEnabled(true);
                    }
                }

                webView.setWebViewClient(new WebViewClient());
                webView.setWebChromeClient(new WebChromeClient());
                webView.clearCache(true);
                webView.setVerticalScrollBarEnabled(false);
                webView.getSettings().setAllowFileAccess(true);
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setDomStorageEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                dismissLoadingDialog();
            } else Toast.makeText(this, "Problem Loading", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Problem Loading", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean loaderVisible = false;
    private CustomLodingDialog myLoadingDialog;

    @UiThread
    public void showLoader() {
        if (!loaderVisible) {
            loaderVisible = true;
            myLoadingDialog = new CustomLodingDialog(this);
            myLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(myLoadingDialog.getWindow()).
                    setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myLoadingDialog.setContentView(R.layout.loading_dialog);
            myLoadingDialog.setCanceledOnTouchOutside(false);
//        myLoadingDialog.setCancelable(false);
            myLoadingDialog.show();
        }
    }

    @UiThread
    public void dismissLoadingDialog() {
        try {
            loaderVisible = false;
            new Handler().postDelayed(() -> {
                if (myLoadingDialog != null && myLoadingDialog.isShowing())
                    myLoadingDialog.dismiss();
            }, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }*/

    @UiThread
    public void nextClicked() {
        queCnt++;
        if (queCnt < gameListList.size()) {
            createWebView(queCnt);
        } else {
            dismissLoadingDialog();
            webView.setVisibility(View.GONE);
            tv_thankyou.setText("Thank you, " + studentName + "!\nYour assessment is submitted.");
            rl_gameover.setVisibility(View.VISIBLE);
        }
    }

    @UiThread
    @Click(R.id.btn_next_student)
    public void nextStudentClicked() {
        KixDatabase.getDatabaseInstance(this).getScoreDao().addScoreList(scoresList);
        sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
        FastSave.getInstance().saveString(STUDENT_ID, "NA");
        BackupDatabase.backup(this);
        finish();
    }

    @Override
    public void onBackPressed() {
        testOverDialog();
    }

    public Dialog nextDialog, testover;
    Button dia_yes, dia_no, btn_cancel;
    TextView dia_title;

    @UiThread
    public void testOverDialog() {
        testover = null;
        testover = new Dialog(this);
        testover.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(testover.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        testover.setContentView(R.layout.exit_game_dialog);
        testover.setCanceledOnTouchOutside(false);

        dia_title = testover.findViewById(R.id.dia_title);
        dia_yes = testover.findViewById(R.id.dia_yes);
        dia_no = testover.findViewById(R.id.dia_no);
        btn_cancel = testover.findViewById(R.id.btn_cancel);
        dia_title.setText("Save and Submit Assessment");
        dia_no.setOnClickListener(v -> {
            testover.dismiss();
            sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
            finish();
        });
        btn_cancel.setOnClickListener(v -> {
            testover.dismiss();
        });
        dia_yes.setOnClickListener(v -> {
            KixDatabase.getDatabaseInstance(this).getScoreDao().addScoreList(scoresList);
            sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
            FastSave.getInstance().saveString(STUDENT_ID, "NA");
            BackupDatabase.backup(this);
            finish();
            testover.dismiss();
        });
        testover.show();
    }

/*
    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageReceived(EventMessage message) {
        if (message != null) {
            if (message.getMessage().equalsIgnoreCase("nextGame"))
                nextClicked();
        }
    }
*/

    @Override
    @UiThread
    public void onNextGame(String scoredMarks, String label, String startTime) {
        nextDialog = null;
        nextDialog = new Dialog(this);
        nextDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(nextDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        nextDialog.setContentView(R.layout.next_game_dialog);
        nextDialog.setCanceledOnTouchOutside(false);

        dia_title = nextDialog.findViewById(R.id.dia_title);
        dia_yes = nextDialog.findViewById(R.id.dia_yes);
        dia_no = nextDialog.findViewById(R.id.dia_no);
        if (queCnt == gameListList.size() - 1)
            dia_title.setText("Submit Assessment");
        dia_no.setOnClickListener(v -> nextDialog.dismiss());
        dia_yes.setOnClickListener(v -> {
            addScoreToList(scoredMarks, label, startTime);
            nextClicked();
            nextDialog.dismiss();
            showLoader();
        });
        nextDialog.show();
    }

    private void addScoreToList(String scoredMarks, String label, String startTime) {
        Score score = new Score();
        score.setSessionId(""+FastSave.getInstance().getString(Kix_Constant.SESSIONID,""));
        score.setDeviceId("");
        score.setResourceId("" + gameListList.get(queCnt).getContentCode());
        score.setStartDateTime("" + startTime);
        score.setEndDateTime(KIX_Utility.getCurrentDateTime());
        score.setScoredMarks("" + scoredMarks);
        if (!FastSave.getInstance().getString(STUDENT_ID, "NA").equalsIgnoreCase("NA"))
            score.setStudentId("" + FastSave.getInstance().getString(STUDENT_ID, "NA"));
        score.setLabel(label);
        score.setSentFlag(0);
        scoresList.add(score);
    }

}