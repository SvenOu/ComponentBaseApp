package com.sv.security.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sv.common.AbstractBaseFragment;
import com.sv.common.screen_navigation.BaseMenuData;
import com.sv.security.R;
import com.sv.security.R2;
import com.sv.security.bean.SecurityMenuData;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterModeFragment extends AbstractBaseFragment {

    private static final String TAG = RegisterModeFragment.class.getSimpleName();
    @BindView(R2.id.btnSkip) Button btnSkip;

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_register_mode, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iniUI();
    }

    private void iniUI() {

    }

    @OnClick(R2.id.btnSkip)
    public void onBtnSkipClicked() {
        switchFragmentByMenuData(BaseMenuData.newInstance(
                SecurityMenuData.REGISTER.getValue(), RegisterFragment.class));
    }
}