package com.tts.guest.common.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sv.common.AbstractBaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends AbstractBaseFragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != unbinder) {
            unbinder.unbind();
        }
    }
}