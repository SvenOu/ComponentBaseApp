package com.tts.guest.common.view;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

import com.sv.common.AbstractBaseFragmentActivity;

import butterknife.ButterKnife;

public abstract class BaseFragmentActivity extends AbstractBaseFragmentActivity {

	private static final String TAG = BaseFragmentActivity.class.getSimpleName();
	@Override
	public void setContentView(@LayoutRes int layoutResID) {
		super.setContentView(layoutResID);
		initContentView();
	}

	@Override
	public void setContentView(View view) {
		super.setContentView(view);
		initContentView();
	}

	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params) {
		super.setContentView(view, params);
		initContentView();
	}

	private void initContentView() {
		//must behind setContentView()
		ButterKnife.bind(this);
	}
}