package com.sv.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sv.common.util.Logger;

public class CommonApplication extends Application {
    private static final String TAG = CommonApplication.class.getSimpleName();
    private static CommonApplication instance;
    static {
        // 开启 5.0 以下系统的 vector 支持
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //支持 MultiDex
        MultiDex.install(this);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initArouter();
    }

    private void initArouter() {
        if (isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    private boolean isDebug() {
        return true;
    }

    public static CommonApplication getInstance() {
        if (null == instance) {
            Logger.e(TAG, "Application instance is null.");
            return null;
        }
        return instance;
    }
}
