package com.tts.guest;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.sv.common.util.Logger;
import com.tts.android.db.DatabaseConfig;
import com.tts.android.db.DatabaseManager;
import com.tts.guest.common.context.GuestContext;
import com.umeng.analytics.MobclickAgent;

import java.io.File;


public class GuestAppModule {
    private static final String TAG = GuestAppModule.class.getSimpleName();

    public static final String DATABASE_NAME = BuildConfig.DATA_BASE_NAME;

    private Application application;
    private Config config;

    protected void init(Application application) {
        this.application = application;
        this.config = GuestContext.getInstance().getConfig();
        onCreate();
    }

    public void onCreate() {

        initImageLoader();

        MobclickAgent.setDebugMode(false);

        config.deviceType = Build.MANUFACTURER + " " + Build.MODEL;
        //内部存储空间/data/data/packagename/files
        config.setBaseImageRoot(application.getFilesDir());

        PackageInfo pInfo = null;
        try {
            pInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            config.setAppVersion(pInfo.versionName);
            config.setAppVersionNumber(pInfo.versionCode);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        File extStgDir = Environment.getExternalStorageDirectory();
        Logger.i(TAG, "ExternalStorageDirectory: " + extStgDir.getAbsolutePath());

        String dbName = Config.getAppModePrefix() + DATABASE_NAME;
        DatabaseManager.getInstance().setMybatisContext(application,
                new DatabaseConfig(application, dbName, R.array.db_change_array), R.array.mybatis_array);

    }

    private void initImageLoader() {
        int DISK_CACHE_SIZE = 50 * 1024 * 1024;// 50 Mb
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(
                application).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(DISK_CACHE_SIZE)
                .tasksProcessingOrder(QueueProcessingType.LIFO);

        if (Config.isDevelopMode()) {
            builder.writeDebugLogs(); // Remove for release app
        }

        ImageLoaderConfiguration config = builder.build();
        ImageLoader loader = ImageLoader.getInstance();
        loader.init(config);
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