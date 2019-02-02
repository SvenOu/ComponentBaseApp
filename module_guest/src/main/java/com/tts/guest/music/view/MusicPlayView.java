package com.tts.guest.music.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.sv.common.util.Logger;
import com.tts.guest.R;
import com.tts.guest.common.view.GuestWebView;

public class MusicPlayView extends LinearLayout {
    private static final String TAG = MusicPlayView.class.getSimpleName();
    private static final String URL = "http://google.com";

    private ProgressBar pbWeb;
    private GuestWebView webviewMusic;

    public MusicPlayView(Context context) {
        this(context, null);
        initView();
    }

    public MusicPlayView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initView();
    }

    public MusicPlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View content = LayoutInflater.from(context).inflate(R.layout.screen_music, this, false);
        addView(content);
        initView();
    }

    private void initView(){
        pbWeb = findViewById(R.id.pb_web);
        webviewMusic = findViewById(R.id.webview_music);

        pbWeb.setProgress(0);
        webviewMusic.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if(null == pbWeb){
                    Logger.e(TAG, "mPbWeb is null !");
                    return;
                }
                if(progress < 100) {
                    pbWeb.setVisibility(View.VISIBLE);
                } else {
                    pbWeb.setVisibility(View.GONE);
                }
                pbWeb.setProgress(progress);
            }
        });

        webviewMusic.getSettings().setJavaScriptEnabled(true);
        webviewMusic.getSettings().setDefaultTextEncodingName("UTF-8");
        webviewMusic.setClickable(true);
        webviewMusic.loadUrl(URL);
    }
}
