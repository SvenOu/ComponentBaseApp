package com.sv.security.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sv.common.AbstractBaseFragment;
import com.sv.common.screen_navigation.BaseMenuData;
import com.sv.common.util.Logger;
import com.sv.security.R;
import com.sv.security.R2;
import com.sv.security.bean.SecurityMenuData;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterFragment extends AbstractBaseFragment {

    public static String TAG = RegisterFragment.class.getSimpleName();
    @BindView(R2.id.skipBtn) Button skipBtn;

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initUI();
    }

    private void initUI() {

    }

    @OnClick(R2.id.skipBtn)
    public void onSkipBtnClicked() {
        switchFragmentByMenuData(BaseMenuData.newInstance(
                SecurityMenuData.TERMS.getValue(), TermsFragment.class));
    }
}