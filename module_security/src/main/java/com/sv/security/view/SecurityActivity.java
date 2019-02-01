
package com.sv.security.view;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sv.common.AbstractBaseFragmentActivity;
import com.sv.common.screen_navigation.BaseMenuData;
import com.sv.common.screen_navigation.NavigatorListener;
import com.sv.common.util.Logger;
import com.sv.security.R;
import com.sv.security.bean.SecurityMenuData;

@Route(path = "/module_security/view/SecurityActivity")
public class SecurityActivity extends AbstractBaseFragmentActivity implements NavigatorListener {

    public static final String TAG = SecurityActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_security);
        intNavigator();
        iniFragment();
    }

    private void iniFragment() {
        switchFragmentByMenuData(BaseMenuData.newInstance(
                SecurityMenuData.APP_LAUNCH.getValue(), AppLaunchFragment.class));
    }

    private void intNavigator() {
        screenNavigator.bind(this, R.id.common_fragment_container,
                SecurityMenuData.APP_LAUNCH.getValue(), this);
    }

    @Override
    public boolean beforeSwitchScreen(BaseMenuData targetMenuData) {
        return true;
    }

    @Override
    public void onStopSwitchScreen(BaseMenuData targetMenuData) {

    }

    @Override
    public void afterSwitchScreen(BaseMenuData targetMenuData) {

    }
}