package com.kix.assessment.ui.main_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

import static com.kix.assessment.ui.main_test.WebViewActivity.gameListList;
import static com.kix.assessment.ui.main_test.WebViewActivity.queCnt;


public class JSInterface {

    public Context mContext;
    public static MediaPlayer mp;
    public String extractedText, quesWord, resID;
    WebViewFragment webViewFragment;
    WebViewInterface webViewInterface;
    WebView webView;
    boolean resArray = false;
    private Intent recognizerIntent;
    private SpeechRecognizer speech = null;


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
        Log.d("GAME CODE", "POS : "+ queCnt+"     GAME CODE : "+gameListList.get(queCnt).getContentCode());
        return gameListList.get(queCnt).getContentCode();
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public String getLanguage(){
        //TODO Return Language
        return "lang";
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public void gotoNextGame(String scoredMarks, String startTime, String label){
        webViewInterface.onNextGame(scoredMarks, label, startTime);
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public void addScore(String resId, String questionId, String scoredMarks, String startTime, String label){
        webViewInterface.onNextGame(scoredMarks, label, startTime);
    }

}