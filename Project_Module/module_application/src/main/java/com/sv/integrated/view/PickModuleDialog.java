package com.sv.integrated.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.sv.integrated.R;

/**
 * Created by sven-ou on 2017/3/2.
 */

public class PickModuleDialog extends Dialog implements View.OnClickListener {
    private static final String TAG = PickModuleDialog.class.getSimpleName();

    private Button btnGoAndroidFileServer;
    private Button btnGoTestWigetActivity;
    private Button btnGoMainViewActivity;
    private Button btnGoSecurityActivity;

    public interface PickModuleListener{
        void onButtonsClick(View v);
    }
    private PickModuleListener pickModuleListener;

    public PickModuleDialog(Context context) {
        super(context, R.style.translucentDialog);
        init();
    }

    private void init() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_pick_module);

        btnGoAndroidFileServer = findViewById(R.id.btn_goAndroidFileServer);
        btnGoTestWigetActivity = findViewById(R.id.btn_goTestWigetActivity);
        btnGoMainViewActivity = findViewById(R.id.btn_goMainViewActivity);
        btnGoSecurityActivity = findViewById(R.id.btn_goSecurityActivity);

        btnGoAndroidFileServer.setOnClickListener(this);
        btnGoTestWigetActivity.setOnClickListener(this);
        btnGoMainViewActivity.setOnClickListener(this);
        btnGoSecurityActivity.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {}

    @Override
    public void onClick(View v) {
        if(null != pickModuleListener){
            pickModuleListener.onButtonsClick(v);
        }
    }

    public PickModuleListener getPickModuleListener() {
        return pickModuleListener;
    }

    public void setPickModuleListener(PickModuleListener pickModuleListener) {
        this.pickModuleListener = pickModuleListener;
    }
}
