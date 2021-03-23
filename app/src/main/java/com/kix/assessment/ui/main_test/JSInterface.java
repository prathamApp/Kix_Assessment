package com.kix.assessment.ui.main_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import static com.kix.assessment.ui.main_test.MainTestActivity.gameListList;
import static com.kix.assessment.ui.main_test.MainTestActivity.queCnt;
import static com.kix.assessment.ui.main_test.WebViewFragment.gamePos;


public class JSInterface{

    public Context mContext;
    public static MediaPlayer mp;
    public String extractedText, quesWord, resID;
    WebViewFragment webViewFragment;
    WebViewInterface webViewInterface;
    WebView webView;
    boolean resArray = false;
    private Intent recognizerIntent;
    private SpeechRecognizer speech = null;


    public JSInterface(Context mContext, WebViewInterface webViewInterface, WebViewFragment webViewFragment, WebView webView, String resID) {
        this.mContext = mContext;
        this.webViewFragment = webViewFragment;
        this.webViewInterface = webViewInterface;
        this.webView = webView;
        this.resID = resID;
    }

    @SuppressLint("StaticFieldLeak")
    @JavascriptInterface
    public String getGameID(){
        Log.d("GAME CODE", "POS : "+queCnt+"     GAME CODE : "+gameListList.get(gamePos).getContentCode());
        return gameListList.get(gamePos).getContentCode();
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