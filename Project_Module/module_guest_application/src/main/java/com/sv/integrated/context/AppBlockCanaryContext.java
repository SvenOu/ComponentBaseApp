package com.sv.integrated.context;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.sv.common.util.Logger;
import com.sv.common.util.NetWorkUtil;
import com.sv.integrated.BuildConfig;
import com.sv.integrated.view.GuestApplication;

import java.io.File;
// TODO: 2019/5/30 需要以后修改
public class AppBlockCanaryContext extends BlockCanaryContext {
    public static final String TAG = AppBlockCanaryContext.class.getName();

    @Override
    public String getQualifier() {
        return BuildConfig.VERSION_NAME + "googlePlay" + "gradle";
    }

    @Override
    public String getUid() {
        return BuildConfig.APPLICATION_ID;
    }

    @Override
    public String getNetworkType() {
        if(GuestApplication.getInstance() == null){
            return "unGetNetwork";
        }
        return NetWorkUtil.getNetworkClass(GuestApplication.getInstance());
    }

    @Override
    public int getConfigDuration() {
        return 5;
    }

    @Override
    public int getConfigBlockThreshold() {
        return 4000;
    }

    // if set true, notification will be shown, else only write log file
    @Override
    public boolean isNeedDisplay() {
        return BuildConfig.DEBUG;
    }

    // path to save log file
    @Override
    public String getLogPath() {
        return "/" + BuildConfig.APPLICATION_ID + "/blockcanary/performance";
    }

    @Override
    public boolean zipLogFile(File[] src, File dest) {
        return false;
    }

    @Override
    public void uploadLogFile(File zippedFile) {
        Logger.i(TAG, "uploadLogFile:  " + zippedFile.getAbsolutePath());
    }

}
