package com.sv.security.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sv.common.AbstractBaseFragment;
import com.sv.common.util.Logger;
import com.sv.security.R;
import com.sv.security.R2;

import butterknife.BindView;
import butterknife.OnClick;


public class TermsFragment extends AbstractBaseFragment {

    public static final String TAG = TermsFragment.class.getSimpleName();

    @BindView(R2.id.btn_decline) Button btnDecline;
    @BindView(R2.id.btn_agree) Button btnAgree;

    @Override
    protected View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_terms, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R2.id.btn_decline, R2.id.btn_agree})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.btn_decline) {
            popBackScreen();
        } else if (i == R.id.btn_agree) {
            ARouter.getInstance().build("/module_guest/main/MainViewActivity").navigation();
            getActivity().finish();
        }
    }
}