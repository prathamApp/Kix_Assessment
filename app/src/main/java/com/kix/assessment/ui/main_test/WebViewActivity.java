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
import android.os.Looper;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.BaseActivity;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.MSAT.Model_Country;
import com.kix.assessment.modal_classes.MSAT.Model_LangBooklet;
import com.kix.assessment.modal_classes.MSAT.Model_LangGame;
import com.kix.assessment.modal_classes.MSAT.Model_LangLevel;
import com.kix.assessment.modal_classes.MSAT.Model_LangStage;
import com.kix.assessment.modal_classes.MSAT.Model_MathsBooklet;
import com.kix.assessment.modal_classes.MSAT.Model_MathsGame;
import com.kix.assessment.modal_classes.MSAT.Model_MathsLevel;
import com.kix.assessment.modal_classes.MSAT.Model_MathsStage;
import com.kix.assessment.modal_classes.Modal_Content;
import com.kix.assessment.modal_classes.Score;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.lang.reflect.Type;
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

    /**
     * Below are new variables added for FT3_MSAT
     */
    String str_dataJson;
    Gson gson = new Gson();
    List<Model_MathsBooklet> modelMathsBookletList;
    List<Model_MathsStage> modelMathsStageList;
    List<Model_MathsLevel> modelMathsLevelList;
    public static List<Model_MathsGame> modelMathsGameList;

    List<Model_LangBooklet> modelLangBookletList;
    List<Model_LangStage> modelLangStageList;
    List<Model_LangLevel> modelLangLevelList;
    public static List<Model_LangGame> modelLangGameList;
    public static int stageCount;
    String bklet;
    public static List<Score> tempScoresList;

    static final String INT = "INT";
    public String levelName;
    public static boolean isLanguage = true;
    private static final String INTB = "INTB";
    public static int correctScoreCount;
    public int levelValue;
    public int INTB_Score, INTB_Length, INTB_Position;
    int cutOffScore;

    @AfterViews
    public void init() {
        WebViewActivity.stageCount = 1;
        this.getJSONDataAsString();
        KIX_Utility.setMyLocale(this, FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        this.studentName = this.getIntent().getStringExtra(Kix_Constant.STUDENT_NAME);
        this.rl_gameover.setVisibility(View.GONE);
        WebViewActivity.gameListList = new ArrayList<>();
        WebViewActivity.scoresList = new ArrayList<>();
        WebViewActivity.tempScoresList = new ArrayList<>();
        WebViewActivity.modelMathsGameList = new ArrayList<>();
        WebViewActivity.modelLangGameList = new ArrayList<>();
        WebViewActivity.queCnt = 0;
        WebViewActivity.correctScoreCount =0;
        try {
            final String country = "" + FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India");
            if (!isDomainWise)
                this.bklet = getBooklet(country);
            else
                this.bklet = FastSave.getInstance().getString(Kix_Constant.BOOKLET, "A");
            Log.d("booklet", "Kix_Constant.BOOKLET: " + this.bklet);
            this.getStages(this.bklet);
            //gameListList = KixDatabase.getDatabaseInstance(this).getContentDao().getContentByBookletCountry("%" + bklet + ",%", country);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private void getJSONDataAsString() {
        this.modelMathsBookletList = new ArrayList<>();
        this.modelLangBookletList = new ArrayList<>();
        this.str_dataJson = KIX_Utility.getDataJsonAsString(this);
        final Type type = new TypeToken<Model_Country>() {
        }.getType();

        final Model_Country modelCountry = this.gson.fromJson(this.str_dataJson, type);
        this.modelMathsBookletList.addAll(modelCountry.getMathsBooklet());
        this.modelLangBookletList.addAll(modelCountry.getLangBooklet());
    }


    public String getBooklet(String country) {
        final List<String> listBooklet = new ArrayList<>();
        if (!FastSave.getInstance().getBoolean(Kix_Constant.BOOKLET_LIST_FLG, false)) {
            for (int i = 0; i < this.modelMathsBookletList.size(); i++) {
                listBooklet.add(this.modelMathsBookletList.get(i).getName());
            }
            Collections.shuffle(listBooklet);
            Log.d("booklet", "\n\nList SIZE: " + listBooklet.size());
            String strBooklet = listBooklet.toString();
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
                bklets = bklets.replace("]", "");
                //Log.d("booklet", "\n\nbookletString: " + bklets);
                Log.d("booklet", "bookletString: " + bklets);
                List<String> myBookletList = new ArrayList<String>(Arrays.asList(bklets.split(",")));
                int a = FastSave.getInstance().getInt(Kix_Constant.BOOKLET_NO, 0);
                a += 1;
                Log.d("booklet", "SIZE: " + myBookletList.size());
                Log.d("booklet", "COUNT: " + a);
                if (a >= myBookletList.size()) {
                    FastSave.getInstance().saveInt(Kix_Constant.BOOKLET_NO, 0);
                    Collections.shuffle(myBookletList);
                    FastSave.getInstance().saveString(Kix_Constant.SHUFFLED_BOOKLETS, myBookletList.toString());
                } else
                    FastSave.getInstance().saveInt(Kix_Constant.BOOKLET_NO, a);

                String bName = myBookletList.get(FastSave.getInstance().getInt(Kix_Constant.BOOKLET_NO, 0));
                FastSave.getInstance().saveString(Kix_Constant.BOOKLET_NAME, bName.trim());
                return bName.trim();
            }
        }
        return "A";
    }

    public void getStages(final String bookletName) {
        if (WebViewActivity.isLanguage) {
            for (int i = 0; i < this.modelLangBookletList.size(); i++) {
                if (bookletName.equalsIgnoreCase(this.modelLangBookletList.get(i).getName())) {
                    this.modelLangStageList = this.modelLangBookletList.get(i).getStages();
                    for (final Model_LangStage model_langStage : this.modelLangStageList) {
                        if (model_langStage.getStage() == WebViewActivity.stageCount) {
                            this.getLevels(model_langStage);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < this.modelMathsBookletList.size(); i++) {
                if (bookletName.equalsIgnoreCase(this.modelMathsBookletList.get(i).getName())) {
                    this.modelMathsStageList = this.modelMathsBookletList.get(i).getStages();
                    for (final Model_MathsStage model_mathsStage : this.modelMathsStageList) {
                        if (model_mathsStage.getStage() == WebViewActivity.stageCount) {
                            this.getLevels(model_mathsStage);
                        }
                    }
                }
            }
        }
    }

    private void getLevels(final Model_LangStage model_langStage) {
        this.modelLangLevelList = model_langStage.getLevels();
        if (this.modelLangLevelList.size() == 1) {
            this.getINTBLength();
            WebViewActivity.modelLangGameList.addAll(this.modelLangLevelList.get(this.levelValue).getGames());
            this.levelName = this.modelLangLevelList.get(this.levelValue).getLevel();
            this.cutOffScore = this.modelLangLevelList.get(this.levelValue).getCutoffscore();
            this.createWebView(WebViewActivity.queCnt);
        } else if (this.modelLangLevelList.size() > 1) {
            //int correctScore = calculateCorrectScore();
            Log.d("CorrectScr : ", String.valueOf(WebViewActivity.correctScoreCount));
            Log.d("CutOffScr : ", String.valueOf(this.cutOffScore));
            //tempScoresList.clear();
            if (WebViewActivity.correctScoreCount >= this.cutOffScore) {
                this.levelValue++;
                Log.d("Level: ", this.modelLangLevelList.get(this.levelValue).getLevel());
                this.getINTBLength();
                WebViewActivity.modelLangGameList.addAll(this.modelLangLevelList.get(this.levelValue).getGames());
                this.levelName = this.modelLangLevelList.get(this.levelValue).getLevel();
                this.cutOffScore = this.modelLangLevelList.get(this.levelValue).getCutoffscore();
            } else {
                Log.d("Level: ", this.modelLangLevelList.get(this.levelValue).getLevel());
                this.getINTBLength();
                WebViewActivity.modelLangGameList.addAll(this.modelLangLevelList.get(this.levelValue).getGames());
                this.levelName = this.modelLangLevelList.get(this.levelValue).getLevel();
                this.cutOffScore = this.modelLangLevelList.get(this.levelValue).getCutoffscore();
            }
            this.createWebView(WebViewActivity.queCnt);
        }
    }

    private void getINTBLength(){
        this.INTB_Length =0;
        this.INTB_Score =0;
        this.INTB_Position =1;
        List<Model_LangGame> tempGameList = new ArrayList<Model_LangGame>();
        tempGameList = this.modelLangLevelList.get(this.levelValue).getGames();
        for (final Model_LangGame langGame : tempGameList){
            if(langGame.getGametype().equalsIgnoreCase("INTB")){
//                Log.d("INTB Game : ", langGame.getGamename()+" | "+langGame.getGametype());
                this.INTB_Length++;
            }
        }
//        Log.d("INTB Length: ", String.valueOf(INTB_Length));
    }

    private void getLevels(final Model_MathsStage model_mathsStage) {
        this.modelMathsLevelList = model_mathsStage.getLevels();
        if (this.modelMathsLevelList.size() == 1) {
            WebViewActivity.modelMathsGameList.addAll(this.modelMathsLevelList.get(this.levelValue).getGames());
            this.levelName = this.modelMathsLevelList.get(this.levelValue).getLevel();
            this.cutOffScore = this.modelMathsLevelList.get(this.levelValue).getCutoffscore();
            this.createWebView(WebViewActivity.queCnt);
        } else if (this.modelMathsLevelList.size() > 1) {
//            int correctScore = calculateCorrectScore();
            Log.d("CorrectScr : ", String.valueOf(WebViewActivity.correctScoreCount));
            Log.d("CutOffScr : ", String.valueOf(this.cutOffScore));
            //tempScoresList.clear();
            if (WebViewActivity.correctScoreCount >= this.cutOffScore) {
                this.levelValue++;
                Log.d("Level: ", this.modelMathsLevelList.get(this.levelValue).getLevel());
                WebViewActivity.modelMathsGameList.addAll(this.modelMathsLevelList.get(this.levelValue).getGames());
                this.levelName = this.modelMathsLevelList.get(this.levelValue).getLevel();
                this.cutOffScore = this.modelMathsLevelList.get(this.levelValue).getCutoffscore();
            } else {
                Log.d("Level: ", this.modelMathsLevelList.get(this.levelValue).getLevel());
                WebViewActivity.modelMathsGameList.addAll(this.modelMathsLevelList.get(this.levelValue).getGames());
                this.levelName = this.modelMathsLevelList.get(this.levelValue).getLevel();
                this.cutOffScore = this.modelMathsLevelList.get(this.levelValue).getCutoffscore();
            }
            this.createWebView(WebViewActivity.queCnt);
        }
    }

    private int calculateCorrectScore() {
        Log.d("IntScores: ", String.valueOf(WebViewActivity.tempScoresList.size()));
        int correctScoreCount = 0;
        for (final Score score : WebViewActivity.tempScoresList) {
            if (score.getScoredMarks().equalsIgnoreCase("2")) {
                correctScoreCount++;
            }
        }
        return correctScoreCount;
/*        Log.d("CrctScrCnt : ", String.valueOf(correctScoreCount));
        int percent = 0;
        if (tempScoresList.size() > 0)
            percent = correctScoreCount * 100 / tempScoresList.size();
        return percent;*/
    }


    @UiThread
    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    public void createWebView(final int pos) {
        try {
            FastSave.getInstance().saveBoolean(Kix_Constant.TEST_FLAG, true);
//            testOnFlg = true;
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

            //if sdcard is used, then please use isLanguage condition here as well
            if (KIXApplication.isSDCard)
                this.webView.loadUrl(KIXApplication.contentSDPath + "/.KIX/" + WebViewActivity.modelMathsGameList.get(pos).getFolder());
            else {
                if (WebViewActivity.isLanguage)
                    this.webView.loadUrl("file:///android_asset/" + Kix_Constant.assessment_Games + "/" + WebViewActivity.modelLangGameList.get(pos).getFolder());
                else
                    this.webView.loadUrl("file:///android_asset/" + Kix_Constant.assessment_Games + "/" + WebViewActivity.modelMathsGameList.get(pos).getFolder());
            }
            this.dismissLoadingDialog();
        } catch (final Exception e) {
            e.printStackTrace();
            Log.d("TAG", "createWebView: PATH :  file:///android_asset/" + Kix_Constant.assessment_Games + "/" + WebViewActivity.modelMathsGameList.get(pos).getFolder());
            Log.d("TAG", "createWebView: ID :  file:///android_asset/" + Kix_Constant.assessment_Games + "/" + WebViewActivity.modelMathsGameList.get(pos).getGamename());
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
        if (WebViewActivity.isLanguage) {
            if (WebViewActivity.queCnt < WebViewActivity.modelLangGameList.size()) {
                this.createWebView(WebViewActivity.queCnt);
            } else {
                if (WebViewActivity.stageCount < this.modelLangStageList.size()) {
                    WebViewActivity.stageCount++;
                    this.getStages(this.bklet);
                } else {
                    this.dismissLoadingDialog();
                    WebViewActivity.isLanguage = false;
                    WebViewActivity.stageCount = 1;
                    this.levelValue = 0;
                    WebViewActivity.queCnt = 0;
                    this.getStages(this.bklet);
                    WebViewActivity.tempScoresList.clear();
                    WebViewActivity.correctScoreCount =0;
                }
            }
        } else {
            if (WebViewActivity.queCnt < WebViewActivity.modelMathsGameList.size()) {
                this.createWebView(WebViewActivity.queCnt);
            } else {
                if (WebViewActivity.stageCount < this.modelMathsStageList.size()) {
                    WebViewActivity.stageCount++;
                    this.getStages(this.bklet);
                } else {
                    this.dismissLoadingDialog();
                    this.webView.setVisibility(View.GONE);
                    //testOnFlg = false;
                    FastSave.getInstance().saveBoolean(Kix_Constant.TEST_FLAG, false);
                    this.tv_thankyou.setText(this.getResources().getString(R.string.thank_you) + ", " + this.studentName
                            + "!\n" + this.getResources().getString(R.string.test_submitted));
                    this.btn_next_student.setText(this.getResources().getString(R.string.next_student));
                    this.rl_gameover.setVisibility(View.VISIBLE);
                }
            }
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
        Log.d("ScoreList : ", String.valueOf(WebViewActivity.scoresList.size()));
        KixDatabase.getDatabaseInstance(this).getScoreDao().addScoreList(WebViewActivity.scoresList);
        sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
        FastSave.getInstance().saveString(STUDENT_ID, "NA");
        BackupDatabase.backup(this);
        WebViewActivity.isLanguage = true;
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
                abandonedScore.setGameType(WebViewActivity.scoresList.get(i).getGameType());
                abandonedScore.setScoredMarks(WebViewActivity.scoresList.get(i).getScoredMarks());
                abandonedScore.setSessionId(WebViewActivity.scoresList.get(i).getSessionId());
                abandonedScore.setStudentId(WebViewActivity.scoresList.get(i).getStudentId());
                abandonedScore.setStartDateTime(WebViewActivity.scoresList.get(i).getStartDateTime());
                abandonedScore.setEndDateTime(WebViewActivity.scoresList.get(i).getEndDateTime());
                abandonedScore.setLabel(WebViewActivity.scoresList.get(i).getLabel());
                abandonedScore.setSvrCode(WebViewActivity.scoresList.get(i).getSvrCode());
                abandonedScore.setSentFlag(WebViewActivity.scoresList.get(i).getSentFlag());
                abandonedScore.setBookletNo(FastSave.getInstance().getString(Kix_Constant.BOOKLET_NAME, "NA"));
                abandonedScore.setCountryName(WebViewActivity.scoresList.get(i).getCountryName());
                abandonedScore.setReason("Data Not Saved");
                abandonedScore.setStage(WebViewActivity.scoresList.get(i).getStage());
                abandonedScore.setLevel(WebViewActivity.scoresList.get(i).getLevel());
                WebViewActivity.abandonedScoreList.add(abandonedScore);
            }
            KixDatabase.getDatabaseInstance(this).getAbandonedScoreDao().addAbandonedScoreList(WebViewActivity.abandonedScoreList);
            sessionDao.UpdateToDate(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""), KIX_Utility.getCurrentDateTime());
            FastSave.getInstance().saveString(STUDENT_ID, "NA");
//            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
            WebViewActivity.isLanguage = true;
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
            WebViewActivity.isLanguage = true;
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
            Log.d("Stage & Game Cnt : ", WebViewActivity.stageCount + " | " + WebViewActivity.queCnt);
            if (WebViewActivity.queCnt == WebViewActivity.modelMathsGameList.size() - 1 && WebViewActivity.stageCount == this.modelMathsStageList.size())
                this.dia_title.setText(this.getResources().getString(R.string.submit_assessment));
            else
                this.dia_title.setText(this.getResources().getString(R.string.goto_next_task));
            this.dia_no.setOnClickListener(v -> {
                this.nextDialog.dismiss();
                this.dialogOpen = false;
            });
            this.dia_yes.setOnClickListener(v -> {
                this.addScoreToList(scoredMarks, label, startTime);
                /**added this 200ms delay before calling nextClicked()method,
                 * so that addScoreToList() can complete adding data to list*/
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        WebViewActivity.this.nextClicked();
                    }
                }, 200);
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
        if (WebViewActivity.isLanguage) {
            score.setResourceId("" + WebViewActivity.modelLangGameList.get(WebViewActivity.queCnt).getGamename());
            score.setGameType("" + WebViewActivity.modelLangGameList.get(WebViewActivity.queCnt).getGametype());
        }
        else {
            score.setResourceId("" + WebViewActivity.modelMathsGameList.get(WebViewActivity.queCnt).getGamename());
            score.setGameType("" + WebViewActivity.modelMathsGameList.get(WebViewActivity.queCnt).getGametype());
        }
        score.setStartDateTime("" + startTime);
        score.setEndDateTime(KIX_Utility.getCurrentDateTime());
        score.setScoredMarks("" + scoredMarks);
        if (!FastSave.getInstance().getString(STUDENT_ID, "NA").equalsIgnoreCase("NA"))
            score.setStudentId("" + FastSave.getInstance().getString(STUDENT_ID, "NA"));
        score.setLabel(label);
        score.setSvrCode(FastSave.getInstance().getString(Kix_Constant.SURVEYOR_CODE, ""));
        score.setBookletNo(FastSave.getInstance().getString(Kix_Constant.BOOKLET_NAME, ""));
        score.setLevel(this.levelName);
        score.setStage(WebViewActivity.stageCount);
        score.setCountryName(FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "NA"));
        score.setSentFlag(0);
        WebViewActivity.scoresList.add(score);
        final String scoreJson = new Gson().toJson(WebViewActivity.scoresList);
        Log.e("Score String : ", scoreJson);
        FastSave.getInstance().saveString(Kix_Constant.SCORE_LIST,scoreJson);
        if(WebViewActivity.scoresList.get(WebViewActivity.scoresList.size()-1).getGameType().equalsIgnoreCase(WebViewActivity.INT) && WebViewActivity.scoresList.get(WebViewActivity.scoresList.size()-1).getScoredMarks().equalsIgnoreCase("2"))
            WebViewActivity.correctScoreCount++;
        else {
            if (WebViewActivity.scoresList.get(WebViewActivity.scoresList.size()-1).getGameType().equalsIgnoreCase(WebViewActivity.INTB)) {
                final int markScored = Integer.parseInt(WebViewActivity.scoresList.get(WebViewActivity.scoresList.size()-1).getScoredMarks());
                if(this.INTB_Position < this.INTB_Length) {
                    this.INTB_Score = this.INTB_Score + markScored;
                    this.INTB_Position++;
                } else if (this.INTB_Position == this.INTB_Length) {
                    this.INTB_Score = this.INTB_Score + markScored;
                    Log.d("INTB_SCORE: ", String.valueOf(INTB_Score));
                    if(this.INTB_Score / this.INTB_Length ==2){
                        correctScoreCount +=2;
                    } else if(INTB_Score ==0 || INTB_Score == INTB_Length){
                        correctScoreCount +=0;
                    } else {
                        correctScoreCount++;
                    }
                }
            }
        }

/*        if(isLanguage){
            if(modelLangGameList.get(queCnt).getGametype().equalsIgnoreCase(INT))
                tempScoresList.add(score);
        } else {
            if(modelMathsGameList.get(queCnt).getGametype().equalsIgnoreCase(INT))
                tempScoresList.add(score);
        }*/
    }
}