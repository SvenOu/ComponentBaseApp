package com.sv.integrated.view;

import com.github.moduth.blockcanary.BlockCanary;
import com.sv.common.CommonApplication;
import com.sv.integrated.context.AppBlockCanaryContext;
import com.sv.integrated.BuildConfig;

public class GuestApplication extends CommonApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initBlockCanary();
    }

    @Override
    protected boolean isDebugMode() {
        return BuildConfig.aRouterDebugMode;
    }

    private void initBlockCanary() {
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }
}
