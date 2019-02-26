package com.tts.guest.profile.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tts.guest.R;
import com.tts.guest.R2;
import com.tts.guest.common.view.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;


public class ProfileInfoFragment extends BaseFragment {
    public static final String TAG = ProfileInfoFragment.class.getSimpleName();

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

}