package com.kix.assessment.ui.main_test;

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
        this.studentName = this.getIntent().getStringExtra(Kix_Constant.STUDENT_NAME);
        this.rl_gameover.setVisibility(View.GONE);
        WebViewActivity.gameListList = new ArrayList<>();
        WebViewActivity.scoresList = new ArrayList<>();
        WebViewActivity.queCnt = 0;
        try {
            final String country = "" + FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India");
            final String bklet = getBooklet(country);
//            final String bklet = "" + FastSave.getInstance().getString(Kix_Constant.BOOKLET, "Booklet 1");
            Log.d("booklet", "Kix_Constant.BOOKLET: " + bklet);
            WebViewActivity.gameListList = KixDatabase.getDatabaseInstance(this).getContentDao().getContentByBookletCountry("%" + bklet + ",%", country);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        this.createWebView(WebViewActivity.queCnt);
    }


    public String getBooklet(String country) {

        if (!FastSave.getInstance().getBoolean(Kix_Constant.BOOKLET_LIST_FLG, false)) {
//                || FastSave.getInstance().getInt("bookletNo", 9999) == 9999) {
            List<String> listBooklet = KIXApplication.contentDao.getBooklets(country);
            Collections.shuffle(listBooklet);
            Log.d("booklet", "\n\nList SIZE: " + listBooklet.size());
            String strBooklet = listBooklet.toString();
            Log.d("booklet", "\n\nbookletString: " + strBooklet);

            FastSave.getInstance().saveString(Kix_Constant.SHUFFLED_BOOKLETS, strBooklet);
            FastSave.getInstance().saveInt(Kix_Constant.BOOKLET_NO, 0);
            FastSave.getInstance().saveBoolean(Kix_Constant.BOOKLET_LIST_FLG, true);
            return listBooklet.get(0).trim();
        } else {
            String bklets = FastSave.getInstance().getString(Kix_Constant.SHUFFLED_BOOKLETS, "NA");
            if (!bklets.equalsIgnoreCase("NA")) {
                bklets = bklets.replace("[", "");
//                System.out.println(replace);
                bklets = bklets.replace("]", "");
                Log.d("booklet", "\n\nbookletString: " + bklets);
                List<String> myBookletList = new ArrayList<String>(Arrays.asList(bklets.split(",")));
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
                
                String bName = myBookletList.get(FastSave.getInstance().getInt(Kix_Constant.BOOKLET_NO, 0));
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
    public void createWebView(final int pos) {
        try {
            WebViewActivity.testOnFlg = true;
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            this.webView.addJavascriptInterface(new JSInterface(this, this, this.webView, ""), "Android");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if (0 != (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE)) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
            }

            this.webView.setWebViewClient(new WebViewClient());
            this.webView.setWebChromeClient(new WebChromeClient());
            this.webView.clearCache(true);
            this.webView.setVerticalScrollBarEnabled(false);
            this.webView.getSettings().setAllowFileAccess(true);
            this.webView.getSettings().setLoadsImagesAutomatically(true);
            this.webView.getSettings().setDomStorageEnabled(true);
            this.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

            if (KIXApplication.isSDCard)
                this.webView.loadUrl(KIXApplication.contentSDPath + "/.KIX/" + WebViewActivity.gameListList.get(pos).getContentFolderName());
            else
                this.webView.loadUrl("file:///android_asset/" + Kix_Constant.assessment_Games + "/" + WebViewActivity.gameListList.get(pos).getContentFolderName());
            this.dismissLoadingDialog();
        } catch (final Exception e) {
            e.printStackTrace();
            Log.d("TAG", "createWebView: PATH :  file:///android_asset/" + Kix_Constant.assessment_Games + "/" + WebViewActivity.gameListList.get(pos).getContentFolderName());
            Log.d("TAG", "createWebView: ID :  file:///android_asset/" + Kix_Constant.assessment_Games + "/" + WebViewActivity.gameListList.get(pos).getContentCode());
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
        if (!this.loaderVisible) {
            this.loaderVisible = true;
            this.myLoadingDialog = new CustomLodingDialog(this);
            this.myLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(this.myLoadingDialog.getWindow()).
                    setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            this.myLoadingDialog.setContentView(R.layout.loading_dialog);
            this.myLoadingDialog.setCanceledOnTouchOutside(false);
//        myLoadingDialog.setCancelable(false);
            this.myLoadingDialog.show();
        }
    }

    @UiThread
    public void dismissLoadingDialog() {
        try {
            this.loaderVisible = false;
            new Handler().postDelayed(() -> {
                if (this.myLoadingDialog != null && this.myLoadingDialog.isShowing())
                    this.myLoadingDialog.dismiss();
            }, 300);
        } catch (final Exception e) {
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
        WebViewActivity.queCnt++;
        if (WebViewActivity.queCnt < WebViewActivity.gameListList.size()) {
            this.createWebView(WebViewActivity.queCnt);
        } else {
            this.dismissLoadingDialog();
            this.webView.setVisibility(View.GONE);
            WebViewActivity.testOnFlg = false;
            this.tv_thankyou.setText(this.getResources().getString(R.string.thank_you) + ", " + this.studentName
                    + "!\n" + this.getResources().getString(R.string.test_submitted));
            this.btn_next_student.setText(this.getResources().getString(R.string.next_student));
            this.rl_gameover.setVisibility(View.VISIBLE);
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
        KixDatabase.getDatabaseInstance(this).getScoreDao().addScoreList(WebViewActivity.scoresList);
        sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
        FastSave.getInstance().saveString(STUDENT_ID, "NA");
        BackupDatabase.backup(this);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        this.testOverDialog();
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
        this.testover = null;
        this.testover = new Dialog(this);
        this.testover.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(this.testover.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.testover.setContentView(R.layout.exit_game_dialog);
        this.testover.setCanceledOnTouchOutside(false);

        this.dia_title = this.testover.findViewById(R.id.dia_title);
        this.dia_yes = this.testover.findViewById(R.id.dia_yes);
        this.dia_no = this.testover.findViewById(R.id.dia_no);
        this.btn_cancel = this.testover.findViewById(R.id.btn_cancel);
        this.dia_title.setText(this.getResources().getString(R.string.save_n_submit));
        this.dia_no.setOnClickListener(v -> {
            this.testover.dismiss();
            WebViewActivity.abandonedScoreList = new ArrayList<>();
            for (int i = 0; i < WebViewActivity.scoresList.size(); i++) {
                final AbandonedScore abandonedScore = new AbandonedScore();
                abandonedScore.setDeviceId(WebViewActivity.scoresList.get(i).getDeviceId());
                abandonedScore.setResourceId(WebViewActivity.scoresList.get(i).getResourceId());
                abandonedScore.setScoredMarks(WebViewActivity.scoresList.get(i).getScoredMarks());
                abandonedScore.setSessionId(WebViewActivity.scoresList.get(i).getSessionId());
                abandonedScore.setStudentId(WebViewActivity.scoresList.get(i).getStudentId());
                abandonedScore.setStartDateTime(WebViewActivity.scoresList.get(i).getStartDateTime());
                abandonedScore.setEndDateTime(WebViewActivity.scoresList.get(i).getEndDateTime());
                abandonedScore.setLabel(WebViewActivity.scoresList.get(i).getLabel());
                abandonedScore.setSvrCode(WebViewActivity.scoresList.get(i).getSvrCode());
                abandonedScore.setSentFlag(WebViewActivity.scoresList.get(i).getSentFlag());
                abandonedScore.setBookletNo(WebViewActivity.scoresList.get(i).getBookletNo());
                abandonedScore.setCountryName(WebViewActivity.scoresList.get(i).getCountryName());
                abandonedScore.setReason("Data Not Saved");
                WebViewActivity.abandonedScoreList.add(abandonedScore);
            }
            KixDatabase.getDatabaseInstance(this).getAbandonedScoreDao().addAbandonedScoreList(WebViewActivity.abandonedScoreList);
            sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
            FastSave.getInstance().saveString(STUDENT_ID, "NA");
//            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
            this.finish();
        });
        this.btn_cancel.setOnClickListener(v -> {
            this.testover.dismiss();
        });
        this.dia_yes.setOnClickListener(v -> {
            KixDatabase.getDatabaseInstance(this).getScoreDao().addScoreList(WebViewActivity.scoresList);
            sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
            FastSave.getInstance().saveString(STUDENT_ID, "NA");
            BackupDatabase.backup(this);
//            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
            this.testover.dismiss();
            this.finish();
        });
        this.testover.show();
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
    public void onNextGame(final String scoredMarks, final String label, final String startTime) {
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        if (!this.dialogOpen) {
            this.nextDialog = null;
            this.dialogOpen = true;
            this.nextDialog = new Dialog(this);
            this.nextDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(this.nextDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            this.nextDialog.setContentView(R.layout.next_game_dialog);
            this.nextDialog.setCanceledOnTouchOutside(false);

            this.dia_title = this.nextDialog.findViewById(R.id.dia_title);
            this.dia_yes = this.nextDialog.findViewById(R.id.dia_yes);
            this.dia_no = this.nextDialog.findViewById(R.id.dia_no);
            if (WebViewActivity.queCnt == WebViewActivity.gameListList.size() - 1)
                this.dia_title.setText(this.getResources().getString(R.string.submit_assessment));
            else
                this.dia_title.setText(this.getResources().getString(R.string.goto_next_task));
            this.dia_no.setOnClickListener(v -> {
                this.nextDialog.dismiss();
                this.dialogOpen = false;
            });
            this.dia_yes.setOnClickListener(v -> {
                this.addScoreToList(scoredMarks, label, startTime);
                this.nextClicked();
                this.dialogOpen = false;
                this.nextDialog.dismiss();
                this.showLoader();
            });
            this.nextDialog.show();
        }
    }

    private void addScoreToList(final String scoredMarks, final String label, final String startTime) {
        final Score score = new Score();
        score.setSessionId("" + FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""));
        score.setDeviceId("" + KIX_Utility.getDeviceID());
        score.setResourceId("" + WebViewActivity.gameListList.get(WebViewActivity.queCnt).getContentCode());
        score.setStartDateTime("" + startTime);
        score.setEndDateTime(KIX_Utility.getCurrentDateTime());
        score.setScoredMarks("" + scoredMarks);
        if (!FastSave.getInstance().getString(STUDENT_ID, "NA").equalsIgnoreCase("NA"))
            score.setStudentId("" + FastSave.getInstance().getString(STUDENT_ID, "NA"));
        score.setLabel(label);
        score.setSvrCode(FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, ""));
        score.setBookletNo(FastSave.getInstance().getString(Kix_Constant.BOOKLET, ""));
        score.setCountryName(FastSave.getInstance().getString(Kix_Constant.COUNTRY, "NA"));
        score.setSentFlag(0);
        WebViewActivity.scoresList.add(score);
    }

}