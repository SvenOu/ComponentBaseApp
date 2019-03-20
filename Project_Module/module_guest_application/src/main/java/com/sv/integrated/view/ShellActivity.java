package com.sv.integrated.view;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sv.integrated.BuildConfig;
import com.sv.integrated.R;

import java.util.Random;

public class ShellActivity extends AppCompatActivity implements PickModuleDialog.PickModuleListener {
    private PickModuleDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_shell);
        dialog = new PickModuleDialog(this);
        dialog.setPickModuleListener(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.show();
            }
        },250);

        if(BuildConfig.aRouterDebugMode){
            ARouter.getInstance().build("/lib_app_file_manager/appfile/WebServerActivity")
                    .withString("applicationId", BuildConfig.APPLICATION_ID)
//                    .withInt("serverPort", getRandomNumberInRange(8000, 8999))
                    .navigation();
        }
    }

    @Override
    public void onButtonsClick(View v) {
        int btnId = v.getId();

        if(btnId == R.id.btn_goTestWigetActivity){
            ARouter.getInstance().build("/lib_common/test/TestWigetActivity").navigation();
        }else if(btnId == R.id.btn_goMainViewActivity){
            ARouter.getInstance().build("/module_guest/main/MainViewActivity").navigation();
        }else if(btnId == R.id.btn_goSecurityActivity){
            ARouter.getInstance().build("/module_security/view/SecurityActivity").navigation();
        }
        dialog.cancel();
        ShellActivity.this.finish();
    }

    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
