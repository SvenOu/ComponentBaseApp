package com.tts.guest.main.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sv.common.screen_navigation.BaseMenuData;
import com.tts.guest.R;
import com.tts.guest.common.view.BaseFragment;


public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }



    private void initView() {

    }
}
