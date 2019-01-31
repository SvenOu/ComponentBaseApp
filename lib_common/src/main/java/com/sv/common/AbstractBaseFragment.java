package com.sv.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.kayvannj.permission_utils.Func;

public abstract class AbstractBaseFragment extends Fragment{
    private static final String TAG = AbstractBaseFragment.class.getSimpleName();

    protected View rootView;
    protected boolean cacheContentData = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (null == rootView || !cacheContentData) {
            rootView = onCreateFragmentView(inflater, container, savedInstanceState);
        }
        return rootView;
    }
    /**
     * @return use for {@link AbstractBaseFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}, for butterknife bind.
     */
    protected abstract View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 提供给子类调用,适用于单个或多个permission的简单请求（https://github.com/kayvannj/PermissionUtil）
     */
    protected void doSimpleRequestPermission(String[] permissionStr, int requestCode, Func
            onAllGranted, Func onAnyDenied) {
        AbstractBaseFragmentActivity baseFragmentActivity = (AbstractBaseFragmentActivity) getActivity();
        baseFragmentActivity.doSimpleRequestPermission(permissionStr, requestCode, onAllGranted, onAnyDenied);
    }

    protected void showToast(int resId) {
        if(null != getActivity()){
            Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT).show();
        }
    }
    protected void showToast(String resStr) {
        if(null != getActivity()){
            Toast.makeText(getActivity(), resStr, Toast.LENGTH_SHORT).show();
        }
    }
    public boolean isCacheContentData() {
        return cacheContentData;
    }

    public void setCacheContentData(boolean cacheContentData) {
        this.cacheContentData = cacheContentData;
    }
    public View getRootView() {
        return rootView;
    }
}