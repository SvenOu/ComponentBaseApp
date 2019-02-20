package com.tts.guest;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;

import com.sv.common.util.Logger;
import com.tts.android.db.DatabaseConfig;
import com.tts.android.db.DatabaseManager;
import com.tts.guest.common.context.GuestContext;

import java.io.File;


public class GuestAppModule {
    private static final String TAG = GuestAppModule.class.getSimpleName();

    public static final String DATABASE_NAME = BuildConfig.DATA_BASE_NAME;

    private Application application;
    private Config config;

    public void init(Application application) {
        this.application = application;
        this.config = GuestContext.getInstance().getConfig();
        initModule();
    }

    private void initModule() {
        config.deviceType = Build.MANUFACTURER + " " + Build.MODEL;
        //内部存储空间/data/data/packagename/files
        config.setBaseImageRoot(application.getFilesDir());

        File extStgDir = Environment.getExternalStorageDirectory();
        Logger.i(TAG, "ExternalStorageDirectory: " + extStgDir.getAbsolutePath());

        String dbName = Config.getAppModePrefix() + DATABASE_NAME;
        DatabaseManager.getInstance().setMybatisContext(application,
                new DatabaseConfig(application, dbName, R.array.db_change_array), R.array.mybatis_array);

    }

    private volatile static GuestAppModule instance;
    public static GuestAppModule getInstance() {
        if (instance == null) {
            synchronized (GuestAppModule.class) {
                if (instance == null) {
                    instance = new GuestAppModule();
                }
            }
        }
        return instance;
    }
    protected GuestAppModule() {}
}