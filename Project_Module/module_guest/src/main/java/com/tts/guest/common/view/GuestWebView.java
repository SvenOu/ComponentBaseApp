package com.tts.guest.common.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GuestWebView extends WebView {

	public GuestWebView(Context context) {
		super(context);
		init();
	}

	public GuestWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public GuestWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		this.setWebViewClient(new WebViewClient(){
			@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				view.loadUrl(request.getUrl().toString());
				return true;
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
	}

	@Override
	public boolean canGoBack() {
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_DOWN) {

			int temp_ScrollY = getScrollY();
			scrollTo(getScrollX(), getScrollY() + 1);
			scrollTo(getScrollX(), temp_ScrollY);

		}
		return super.onTouchEvent(event);
	}
}
