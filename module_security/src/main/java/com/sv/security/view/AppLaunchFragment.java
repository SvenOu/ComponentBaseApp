package com.sv.security.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sv.common.AbstractBaseFragment;
import com.sv.common.screen_navigation.BaseMenuData;
import com.sv.security.R;
import com.sv.security.bean.SecurityMenuData;

@Route(path = "/module_security/view/AppLaunchFragment")
public class AppLaunchFragment extends AbstractBaseFragment {
    private static final String TAG = AppLaunchFragment.class.getSimpleName();

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app_launch, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switchFragmentByMenuData(BaseMenuData.newInstance(
                    SecurityMenuData.REGISTER_MODE.getValue(), RegisterModeFragment.class));
            }
        },250);
    }
}