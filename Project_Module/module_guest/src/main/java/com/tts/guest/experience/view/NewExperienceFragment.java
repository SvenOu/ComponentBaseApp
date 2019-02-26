package com.tts.guest.experience.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sv.common.screen_navigation.BaseMenuData;
import com.tts.guest.R;
import com.tts.guest.R2;
import com.tts.guest.common.bean.GuestMenuData;
import com.tts.guest.common.view.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class NewExperienceFragment extends BaseFragment {
    public static final String TAG = NewExperienceFragment.class.getSimpleName();

    @BindView(R2.id.btn_go_experience_detail) Button btnGoExpericeDetail;

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_experience, container, false);
    }

    @OnClick(R2.id.btn_go_experience_detail)
    public void onBtnGoExperienceDetailClicked() {
        switchFragmentByMenuData(BaseMenuData.newInstance(
                GuestMenuData.EXPERIENCE_DETAIL.getValue(), ExperienceDetailFragment.class));
    }
}