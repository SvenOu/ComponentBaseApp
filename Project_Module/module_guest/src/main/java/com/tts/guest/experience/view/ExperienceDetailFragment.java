package com.tts.guest.experience.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sv.common.screen_navigation.BaseMenuData;
import com.tts.guest.R;
import com.tts.guest.R2;
import com.tts.guest.common.bean.GuestMenuData;
import com.tts.guest.common.view.BaseFragment;
import com.tts.guest.main.view.HomeFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class ExperienceDetailFragment extends BaseFragment {
    private static final String TAG = ExperienceDetailFragment.class.getSimpleName();

    @BindView(R2.id.btn_go_home) Button btnGoHome;
    @BindView(R2.id.contenView) LinearLayout contenView;

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feedback_detail_content, container, false);
    }

    @OnClick(R2.id.btn_go_home)
    public void onBtnGoHomeClicked() {
        switchFragmentByMenuData(BaseMenuData.newInstance(
                GuestMenuData.HOME.getValue(), HomeFragment.class));
    }
}

