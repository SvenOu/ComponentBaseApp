package com.sv.integrated.view;

import com.sv.common.CommonApplication;
import com.sv.integrated.BuildConfig;

public class GuestApplication extends CommonApplication {
    @Override
    protected boolean isDebugMode() {
        return BuildConfig.aRouterDebugMode;
    }
}
