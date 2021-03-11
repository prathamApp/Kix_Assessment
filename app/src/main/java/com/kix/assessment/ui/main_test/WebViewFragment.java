package com.kix.assessment.ui.main_test;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kix.assessment.R;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.GameList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.List;
import java.util.Objects;


@EFragment(R.layout.fragment_web_view)
public class WebViewFragment extends Fragment implements WebViewInterface {

    @ViewById(R.id.loadPage)
    public WebView webView;
    @ViewById(R.id.main_rl)
    public RelativeLayout main_rl;
    GameList gameListList;
    int pos;

    public static Fragment newInstance(int pos, List<GameList> gameList) {
        WebViewFragment_ fragmentFirst = new WebViewFragment_();
        Bundle args = new Bundle();
        args.putInt("pos", pos);
        args.putSerializable("gameList", gameList.get(pos));
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @AfterViews
    public void init() {
        if (getArguments() != null) {
            pos = Objects.requireNonNull(getArguments()).getInt("pos", 0);
            gameListList = (GameList) getArguments().getSerializable("gameList");
        }
        String strPath = Environment.getExternalStorageDirectory().toString()+"/.KIX/"+gameListList.getFolder_Name();
/*        switch (pos) {
            case 0:
                main_rl.setBackgroundResource(R.color.level_0_color);
                strPath = Environment.getExternalStorageDirectory().toString()+"/.KIX/M14A_M21A/index.html";
                break;
            case 1:
                main_rl.setBackgroundResource(R.color.level_1_color);
                strPath = Environment.getExternalStorageDirectory().toString()+"/.KIX/M23A/index.html";
                break;
            case 2:
                main_rl.setBackgroundResource(R.color.level_2_color);
                strPath = Environment.getExternalStorageDirectory().toString()+"/.KIX/M25A/index.html";
                break;
            case 3:
                main_rl.setBackgroundResource(R.color.level_3_color);
                strPath = Environment.getExternalStorageDirectory().toString()+"/.KIX/N16A/index.html";
                break;
        }*/
        if (new File(strPath).exists())
            createWebView(strPath);
        else
            Toast.makeText(getActivity(), "Not Found", Toast.LENGTH_SHORT).show();
    }

    @UiThread
    @SuppressLint("JavascriptInterface")
    public void createWebView(String GamePath) {
        try {
            webView.loadUrl(GamePath);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView.addJavascriptInterface(new JSInterface(getActivity(), this, this ,webView, ""), "Android");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if (0 != (getActivity().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE)) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
            }
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.clearCache(true);
            webView.setVerticalScrollBarEnabled(false);
//        webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setDomStorageEnabled(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Problem Loading", Toast.LENGTH_SHORT).show();
        }
    }

    public Dialog nextDialog;
    Button dia_yes,dia_no;
    TextView dia_title;

    @Override
    public void onNextGame(WebView webView, String scoredMarks, String label, String startTime) {

            nextDialog = null;
            nextDialog = new Dialog(getActivity());
            nextDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(nextDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            nextDialog.setContentView(R.layout.next_game_dialog);
            nextDialog.setCanceledOnTouchOutside(false);
            nextDialog.show();

        dia_title = nextDialog.findViewById(R.id.dia_title);
        dia_yes = nextDialog.findViewById(R.id.dia_yes);
        dia_no = nextDialog.findViewById(R.id.dia_no);

        dia_no.setOnClickListener(v -> nextDialog.dismiss());
        dia_yes.setOnClickListener(v -> {
            //TODO add score in DB
            EventMessage updateAvailable = new EventMessage();
            updateAvailable.setMessage("nextGame");
            EventBus.getDefault().post(updateAvailable);
            nextDialog.dismiss();
        });
            nextDialog.show();
    }
}