package com.kix.assessment.ui.main_test;

import static com.kix.assessment.KIXApplication.isDomainWise;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

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
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Score;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


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
    public static List<AbandonedScore> abandonedScoreList;
    public String studentName;
    public static int queCnt;
    public static boolean testOnFlg;

    @AfterViews
    public void init() {
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        studentName = getIntent().getStringExtra(Kix_Constant.STUDENT_NAME);
        rl_gameover.setVisibility(View.GONE);
        gameListList = new ArrayList<>();
        scoresList = new ArrayList<>();
        queCnt = 0;
        try {
            String country = "" + FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India");
            String bklet;
            if (!isDomainWise)
                bklet = this.getBooklet(country);
            else
                bklet = FastSave.getInstance().getString(Kix_Constant.BOOKLET, "Booklet 1");
//            final String bklet = "" + FastSave.getInstance().getString(Kix_Constant.BOOKLET, "Booklet 1");
            Log.d("booklet", "Kix_Constant.BOOKLET: " + bklet);
            gameListList = KixDatabase.getDatabaseInstance(this).getContentDao().getContentByBookletCountry("%" + bklet + ",%", country);
        } catch (Exception e) {
            e.printStackTrace();
        }
        createWebView(queCnt);
    }


    public String getBooklet(final String country) {

        if (!FastSave.getInstance().getBoolean(Kix_Constant.BOOKLET_LIST_FLG, false)) {
//                || FastSave.getInstance().getInt("bookletNo", 9999) == 9999) {
            final List<String> listBooklet = KIXApplication.contentDao.getBooklets(country);
            Collections.shuffle(listBooklet);
            Log.d("booklet", "\n\nList SIZE: " + listBooklet.size());
            final String strBooklet = listBooklet.toString();
            Log.d("booklet", "\n\nbookletString: " + strBooklet);

            FastSave.getInstance().saveString(Kix_Constant.SHUFFLED_BOOKLETS, strBooklet);
            FastSave.getInstance().saveInt(Kix_Constant.BOOKLET_NO, 0);
            FastSave.getInstance().saveBoolean(Kix_Constant.BOOKLET_LIST_FLG, true);
            FastSave.getInstance().saveString(Kix_Constant.BOOKLET_NAME, listBooklet.get(0).trim());
            return listBooklet.get(0).trim();
        } else {
            String bklets = FastSave.getInstance().getString(Kix_Constant.SHUFFLED_BOOKLETS, "NA");
            if (!bklets.equalsIgnoreCase("NA")) {
                bklets = bklets.replace("[", "");
//                System.out.println(replace);
                bklets = bklets.replace("]", "");
                Log.d("booklet", "\n\nbookletString: " + bklets);
                final List<String> myBookletList = new ArrayList<String>(Arrays.asList(bklets.split(",")));
                int a = FastSave.getInstance().getInt(Kix_Constant.BOOKLET_NO, 0);
                a+=1;
                Log.d("booklet", "getBooklet: SIZE: " + myBookletList.size());
                Log.d("booklet", "getBooklet: COUNT: " + a);
                if (a >= myBookletList.size()) {
                    FastSave.getInstance().saveInt(Kix_Constant.BOOKLET_NO, 0);
                    Collections.shuffle(myBookletList);
                    FastSave.getInstance().saveString(Kix_Constant.SHUFFLED_BOOKLETS, myBookletList.toString());
                } else
                    FastSave.getInstance().saveInt(Kix_Constant.BOOKLET_NO, a);

                final String bName = myBookletList.get(FastSave.getInstance().getInt(Kix_Constant.BOOKLET_NO, 0));
                FastSave.getInstance().saveString(Kix_Constant.BOOKLET_NAME, bName.trim());
                return bName.trim();
            }
        }
        return "booklet 1";
    }

/*
    String arrBooklet[] = KIXApplication.contentDao.getBooklets(country);
    String booklet_Str = String.join(",", arrBooklet);
            Log.d("booklet", "signIn: " + booklet_Str);
    String bkarr[] = booklet_Str.split(",");
            Log.d("booklet", "\n\nLENGTH: " + bkarr.length);
            for (int ik = 0; ik < bkarr.length; ik++)
            Log.d("booklet", "\nbooklet_new: " + bkarr[ik]);
*/


    @UiThread
    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    public void createWebView(int pos) {
        try {
            testOnFlg = true;
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

            if (KIXApplication.isSDCard)
                webView.loadUrl(KIXApplication.contentSDPath + "/.KIX/" + gameListList.get(pos).getContentFolderName());
            else
                webView.loadUrl("file:///android_asset/" + Kix_Constant.assessment_Games + "/" + gameListList.get(pos).getContentFolderName());
            dismissLoadingDialog();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("TAG", "createWebView: PATH :  file:///android_asset/" + Kix_Constant.assessment_Games + "/" + gameListList.get(pos).getContentFolderName());
            Log.d("TAG", "createWebView: ID :  file:///android_asset/" + Kix_Constant.assessment_Games + "/" + gameListList.get(pos).getContentCode());
            Toast.makeText(this, "Problem Loading", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    private boolean loaderVisible;
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
            testOnFlg = false;
            tv_thankyou.setText(getResources().getString(R.string.thank_you) + ", " + studentName
                    + "!\n" + getResources().getString(R.string.test_submitted));
            btn_next_student.setText(getResources().getString(R.string.next_student));
            rl_gameover.setVisibility(View.VISIBLE);
        }
    }

    @UiThread
    @Click(R.id.btn_next_student)
    public void nextStudentClicked() {
        //TODO - iteratorLogic
//        int a = FastSave.getInstance().getInt("bookletNo", 0);
//        String bklets = FastSave.getInstance().getString("shuffledBooklets", "NA");
//        if (!bklets.equalsIgnoreCase("NA")) {
//            bklets = bklets.replace("[", "");
//            bklets = bklets.replace("]", "");
//        }
//        a += 1;
//        FastSave.getInstance().saveInt("bookletNo", a);
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

    @Override
    protected void onPause() {
        sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
        super.onPause();
    }

    @UiThread
    public void testOverDialog() {
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
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
        dia_title.setText(getResources().getString(R.string.save_n_submit));
        dia_no.setOnClickListener(v -> {
            testover.dismiss();
            abandonedScoreList = new ArrayList<>();
            for (int i = 0; i < scoresList.size(); i++) {
                AbandonedScore abandonedScore = new AbandonedScore();
                abandonedScore.setDeviceId(scoresList.get(i).getDeviceId());
                abandonedScore.setResourceId(scoresList.get(i).getResourceId());
                abandonedScore.setScoredMarks(scoresList.get(i).getScoredMarks());
                abandonedScore.setSessionId(scoresList.get(i).getSessionId());
                abandonedScore.setStudentId(scoresList.get(i).getStudentId());
                abandonedScore.setStartDateTime(scoresList.get(i).getStartDateTime());
                abandonedScore.setEndDateTime(scoresList.get(i).getEndDateTime());
                abandonedScore.setLabel(scoresList.get(i).getLabel());
                abandonedScore.setSvrCode(scoresList.get(i).getSvrCode());
                abandonedScore.setSentFlag(scoresList.get(i).getSentFlag());
                abandonedScore.setBookletNo(FastSave.getInstance().getString(Kix_Constant.BOOKLET_NAME, "NA"));
                abandonedScore.setCountryName(scoresList.get(i).getCountryName());
                abandonedScore.setReason("Data Not Saved");
                abandonedScoreList.add(abandonedScore);
            }
            KixDatabase.getDatabaseInstance(this).getAbandonedScoreDao().addAbandonedScoreList(abandonedScoreList);
            sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
            FastSave.getInstance().saveString(STUDENT_ID, "NA");
//            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
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
//            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
            testover.dismiss();
            finish();
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

    boolean dialogOpen;

    @Override
    @UiThread
    public void onNextGame(String scoredMarks, String label, String startTime) {
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        if (!dialogOpen) {
            nextDialog = null;
            dialogOpen = true;
            nextDialog = new Dialog(this);
            nextDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(nextDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            nextDialog.setContentView(R.layout.next_game_dialog);
            nextDialog.setCanceledOnTouchOutside(false);

            dia_title = nextDialog.findViewById(R.id.dia_title);
            dia_yes = nextDialog.findViewById(R.id.dia_yes);
            dia_no = nextDialog.findViewById(R.id.dia_no);
            if (queCnt == gameListList.size() - 1)
                dia_title.setText(getResources().getString(R.string.submit_assessment));
            else
                dia_title.setText(getResources().getString(R.string.goto_next_task));
            dia_no.setOnClickListener(v -> {
                nextDialog.dismiss();
                dialogOpen = false;
            });
            dia_yes.setOnClickListener(v -> {
                addScoreToList(scoredMarks, label, startTime);
                nextClicked();
                dialogOpen = false;
                nextDialog.dismiss();
                showLoader();
            });
            nextDialog.show();
        }
    }

    private void addScoreToList(String scoredMarks, String label, String startTime) {
        Score score = new Score();
        score.setSessionId("" + FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""));
        score.setDeviceId("" + KIX_Utility.getDeviceID());
        score.setResourceId("" + gameListList.get(queCnt).getContentCode());
        score.setStartDateTime("" + startTime);
        score.setEndDateTime(KIX_Utility.getCurrentDateTime());
        score.setScoredMarks("" + scoredMarks);
        if (!FastSave.getInstance().getString(STUDENT_ID, "NA").equalsIgnoreCase("NA"))
            score.setStudentId("" + FastSave.getInstance().getString(STUDENT_ID, "NA"));
        score.setLabel(label);
        score.setSvrCode(FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, ""));
        score.setBookletNo(FastSave.getInstance().getString(Kix_Constant.BOOKLET_NAME, ""));
        score.setCountryName(FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "NA"));
        score.setSentFlag(0);
        scoresList.add(score);
    }

}