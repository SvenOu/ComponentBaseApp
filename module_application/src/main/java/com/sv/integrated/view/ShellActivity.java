package com.sv.integrated.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sv.integrated.R;

public class ShellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_shell);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                ARouter.getInstance().build("/module_security/view/SecurityActivity").navigation();
//                ARouter.getInstance().build("/module_guest/main/MainViewActivity").navigation();
                ARouter.getInstance().build("/lib_common/test/TestWigetActivity").navigation();
                ShellActivity.this.finish();
            }
        },250);
    }
}
