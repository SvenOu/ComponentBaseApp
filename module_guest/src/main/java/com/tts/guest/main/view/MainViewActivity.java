package com.tts.guest.main.view;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sv.common.widget.CycleCountView;
import com.tts.guest.BuildConfig;
import com.tts.guest.R;
import com.tts.guest.R2;
import com.tts.guest.common.view.BaseFragmentActivity;

import butterknife.BindView;

@Route(path = "/module_guest/main/MainViewActivity")
public class MainViewActivity extends BaseFragmentActivity {
    public static final String TAG = MainViewActivity.class.getSimpleName();
    @BindView(R2.id.top_slide_menu_icon) Button topSlideMenuIcon;
    @BindView(R2.id.btn_top_left_icon) Button btnTopLeftIcon;
    @BindView(R2.id.tv_top_left_label) TextView tvTopLeftLabel;
    @BindView(R2.id.ll_top_left) LinearLayout llTopLeft;
    @BindView(R2.id.iv_logo) ImageView ivLogo;
    @BindView(R2.id.btn_top_right_icon) Button btnTopRightIcon;
    @BindView(R2.id.tv_top_right_label) TextView tvTopRightLabel;
    @BindView(R2.id.header_bar) LinearLayout headerBar;
    @BindView(R2.id.fragment_container) FrameLayout fragmentContainer;
    @BindView(R2.id.fl_parent) FrameLayout flParent;
    @BindView(R2.id.coupon_count_view) CycleCountView couponCountView;
    @BindView(R2.id.rl_savings) RelativeLayout rlSavings;
    @BindView(R2.id.iv_feedback) ImageView ivFeedback;
    @BindView(R2.id.rewards_count_view) CycleCountView rewardsCountView;
    @BindView(R2.id.rl_rewards) RelativeLayout rlRewards;
    @BindView(R2.id.iv_location) ImageView ivLocation;
    @BindView(R2.id.iv_music) ImageView ivMusic;
    @BindView(R2.id.content_frame) LinearLayout contentFrame;
    @BindView(R2.id.left_drawer) ListView leftDrawer;
    @BindView(R2.id.left_menu_logo) LinearLayout leftMenuLogo;
    @BindView(R2.id.drawer_layout) DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        tvTopRightLabel.setText("呵呵");
    }
}