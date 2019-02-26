package com.tts.guest.saving.view;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tts.guest.R;
import com.tts.guest.common.view.BaseFragment;


public class CouponFragment extends BaseFragment {
	public final String TAG = CouponFragment.this.getClass().getSimpleName();

	@Override
	protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_offers, container, false);
	}
}