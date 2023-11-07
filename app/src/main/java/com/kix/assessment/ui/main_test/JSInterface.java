package com.kix.assessment.ui.main_test;

import static com.kix.assessment.ui.main_test.WebViewActivity.gameListList;
import static com.kix.assessment.ui.main_test.WebViewActivity.isLanguage;
import static com.kix.assessment.ui.main_test.WebViewActivity.modelLangGameList;
import static com.kix.assessment.ui.main_test.WebViewActivity.modelMathsGameList;
import static com.kix.assessment.ui.main_test.WebViewActivity.queCnt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.services.shared_preferences.FastSave;


public class JSInterface {

    public Context mContext;
    public static MediaPlayer mp;
    public String extractedText, quesWord, resID;
    WebViewFragment webViewFragment;
    WebViewInterface webViewInterface;
    WebView webView;
    boolean resArray = false;
    private Intent recognizerIntent;
    private final SpeechRecognizer speech = null;


    public JSInterface(Context mContext, WebViewInterface webViewInterface, WebView webView, String resID) {
        this.mContext = mContext;
        this.webViewFragment = webViewFragment;
        this.webViewInterface = webViewInterface;
        this.webView = webView;
        this.resID = resID;
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public String getGameID(){
        if(isLanguage){
            Log.d("GAME CODE", "POS : "+ queCnt+"Lang_Game_CODE : "+modelLangGameList.get(queCnt).getGamename());
            return modelLangGameList.get(queCnt).getGamename();
        } else {
            Log.d("GAME CODE", "POS : " + queCnt + "Math_Game_CODE : " + modelMathsGameList.get(queCnt).getGamename());
            return modelMathsGameList.get(queCnt).getGamename();
        }
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public String getGameLang(){
//        return returnLang;
        String s = FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India");
        return s;
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public void gotoNextGame(String scoredMarks, String startTime, String label){
        String[] splited;
        String[] splitedDate;
        String[] splitedTime;
        String customDate, customTime, finalTime;

        splited = startTime.split("\\s+");
        splitedDate = splited[0].split("\\-+");
        splitedTime = splited[1].split("\\:+");
        customDate = formatCustomDate(splitedDate, "-");
        customTime = formatCustomDate(splitedTime, ":");
        finalTime = customDate + " " + customTime;

        webViewInterface.onNextGame(scoredMarks, label, finalTime);
    }

    public String formatCustomDate(String[] splitedDate, String delimiter) {
        for (int k = 0; k < splitedDate.length; k++) {
            if (Integer.parseInt(splitedDate[k]) < 10) {
                splitedDate[k] = "0" + splitedDate[k];
            }
        }
        return TextUtils.join(delimiter, splitedDate);
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public void addScore(String resId, String questionId, String scoredMarks, String startTime, String label){
        webViewInterface.onNextGame(scoredMarks, label, startTime);
    }

}