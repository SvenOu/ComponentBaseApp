package com.sv.integrated.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sv.integrated.R;

public class ShellActivity extends AppCompatActivity implements PickModuleDialog.PickModuleListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_shell);
        PickModuleDialog dialog = new PickModuleDialog(this);
        dialog.setPickModuleListener(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.show();
            }
        },250);
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
        ShellActivity.this.finish();
    }
}
