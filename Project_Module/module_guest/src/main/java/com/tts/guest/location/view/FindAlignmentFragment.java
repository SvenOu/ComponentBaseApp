package com.tts.guest.location.view;

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
import com.tts.guest.experience.view.ExperienceDetailFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class FindAlignmentFragment extends BaseFragment {
    private final String TAG = this.getClass().getSimpleName();
    @BindView(R2.id.btn_go_aligment_result) Button btnGoAligmentResult;

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find_church, container, false);
    }

    @OnClick(R2.id.btn_go_aligment_result)
    public void onViewClicked() {
        switchFragmentByMenuData(BaseMenuData.newInstance(
                GuestMenuData.ALIGNMENT_RESULT.getValue(), AlignmentResultFragment.class));
    }
}