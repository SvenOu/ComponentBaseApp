package com.tts.guest.menu.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.sv.common.util.Logger;
import com.tts.guest.R;
import com.tts.guest.R2;
import com.tts.guest.common.view.BaseFragment;
import com.tts.guest.common.view.GuestWebView;

import butterknife.BindView;

public class MenuFragment extends BaseFragment {
    private static final String TAG = MenuFragment.class.getSimpleName();

    private static final String URL = "http://www.baidu.com";

    @BindView(R2.id.pb_web) ProgressBar pbWeb;
    @BindView(R2.id.webview_menu) GuestWebView webviewMenu;

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        pbWeb.setProgress(0);
        webviewMenu.setWebChromeClient(new WebChromeClient() {
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

        webviewMenu.getSettings().setJavaScriptEnabled(true);
        webviewMenu.getSettings().setDefaultTextEncodingName("UTF-8");
        webviewMenu.setClickable(true);
        webviewMenu.loadUrl(URL);
    }
}
