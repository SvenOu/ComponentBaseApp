package com.sv.integrated;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

public class ShellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_shell);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build("/module_guest/main/MainViewActivity").navigation();
            }
        },2000);
    }
}
