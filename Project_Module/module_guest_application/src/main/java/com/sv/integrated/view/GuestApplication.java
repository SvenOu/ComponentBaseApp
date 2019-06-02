package com.sv.integrated.view;

import com.github.moduth.blockcanary.BlockCanary;
import com.sv.common.CommonApplication;
import com.sv.integrated.context.AppBlockCanaryContext;
import com.sv.integrated.BuildConfig;

public class GuestApplication extends CommonApplication {
    @Override
    public void onCreate() {
        initBlockCanary();
        super.onCreate();

    }

    @Override
    public boolean isDebugMode() {
        return BuildConfig.aRouterDebugMode;
    }

    private void initBlockCanary() {
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }
}
