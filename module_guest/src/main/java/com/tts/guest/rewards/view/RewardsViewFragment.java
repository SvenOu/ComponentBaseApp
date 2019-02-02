package com.tts.guest.rewards.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tts.guest.R;
import com.tts.guest.common.view.BaseFragment;

public class RewardsViewFragment extends BaseFragment {
	public static final String TAG = RewardsViewFragment.class.getSimpleName();

	@Override
	protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_rewards_view, container, false);
	}
}
