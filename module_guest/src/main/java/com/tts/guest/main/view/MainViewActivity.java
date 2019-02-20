package com.tts.guest.main.view;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sv.common.screen_navigation.BaseMenuData;
import com.sv.common.screen_navigation.NavigatorListener;
import com.sv.common.widget.CycleTextView;
import com.tts.guest.GuestAppModule;
import com.tts.guest.R;
import com.tts.guest.R2;
import com.tts.guest.common.bean.GuestMenuData;
import com.tts.guest.common.bean.MenuData;
import com.tts.guest.common.view.BaseFragmentActivity;
import com.tts.guest.experience.view.NewExperienceFragment;
import com.tts.guest.location.view.FindAlignmentFragment;
import com.tts.guest.music.view.MusicPlayView;
import com.tts.guest.rewards.view.RewardsViewFragment;
import com.tts.guest.saving.view.CouponFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/module_guest/main/MainViewActivity")
public class MainViewActivity extends BaseFragmentActivity implements NavigatorListener {
    public static final String TAG = MainViewActivity.class.getSimpleName();

    @BindView(R2.id.top_slide_menu_icon) Button topSlideMenuIcon;
    @BindView(R2.id.btn_top_left_icon) Button btnTopLeftIcon;
    @BindView(R2.id.tv_top_left_label) TextView tvTopLeftLabel;
    @BindView(R2.id.ll_top_left) LinearLayout llTopLeft;
    @BindView(R2.id.iv_logo) ImageView ivLogo;
    @BindView(R2.id.btn_top_right_icon) Button btnTopRightIcon;
    @BindView(R2.id.tv_top_right_label) TextView tvTopRightLabel;
    @BindView(R2.id.header_bar) LinearLayout headerBar;
    @BindView(R2.id.common_fragment_container) FrameLayout fragmentContainer;
    @BindView(R2.id.fl_parent) FrameLayout flParent;
    @BindView(R2.id.coupon_count_view) CycleTextView couponCountView;
    @BindView(R2.id.rl_savings) RelativeLayout rlSavings;
    @BindView(R2.id.iv_feedback) ImageView ivFeedback;
    @BindView(R2.id.rewards_count_view) CycleTextView rewardsCountView;
    @BindView(R2.id.rl_rewards) RelativeLayout rlRewards;
    @BindView(R2.id.iv_location) ImageView ivLocation;
    @BindView(R2.id.iv_music) ImageView ivMusic;
    @BindView(R2.id.content_frame) LinearLayout contentFrame;
    @BindView(R2.id.left_drawer) ListView leftDrawer;
    @BindView(R2.id.left_menu_logo) LinearLayout leftMenuLogo;
    @BindView(R2.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R2.id.music_play_view) MusicPlayView musicPlayView;

    private MainSlideMenuAdapter mainSlideMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GuestAppModule.getInstance().init(getApplication());
        setContentView(R.layout.activity_main_layout);
        ButterKnife.bind(this);
        init();
        intNavigator();
        iniFragment();
    }

    private void init() {
        View leftDrawerHeaderView = LayoutInflater.from(this).inflate(R.layout.main_slide_menu_header, null);
        leftDrawer.addHeaderView(leftDrawerHeaderView);
        mainSlideMenuAdapter = new MainSlideMenuAdapter(this);
        leftDrawer.setAdapter(mainSlideMenuAdapter);
        leftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position - 1;
                if(index < 0){
                    index = 0;
                }
                MenuData menuData = (MenuData) mainSlideMenuAdapter.getItem(index);
                switchFragmentByMenuData(menuData);
                drawerLayout.closeDrawers();
            }
        });
    }

    private void iniFragment() {
        switchFragmentByMenuData(BaseMenuData.newInstance(
                GuestMenuData.HOME.getValue(), HomeFragment.class));
    }

    private void intNavigator() {
        screenNavigator.bind(this, R.id.common_fragment_container,
                GuestMenuData.HOME.getValue(), this);
    }

    @Override
    public boolean beforeSwitchScreen(BaseMenuData targetMenuData) {
        if(null != targetMenuData && targetMenuData.getKey().equals(GuestMenuData.MUSIC.getValue())){
            musicPlayView.setVisibility(View.VISIBLE);
            return false;
        }else {
            musicPlayView.setVisibility(View.GONE);
        }
        return true;
    }

    @Override
    public void onStopSwitchScreen(BaseMenuData targetMenuData) {

    }

    @Override
    public void afterSwitchScreen(BaseMenuData targetMenuData) {

    }

    @OnClick({
            R2.id.rl_savings,
            R2.id.iv_feedback,
            R2.id.rl_rewards,
            R2.id.iv_location,
            R2.id.iv_music
    })
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.rl_savings) {
            switchFragmentByMenuData(BaseMenuData.newInstance(
                    GuestMenuData.COUPON.getValue(), CouponFragment.class));
        }
        else if (i == R.id.iv_feedback) {
            switchFragmentByMenuData(BaseMenuData.newInstance(
                    GuestMenuData.NEW_EXPERIENCE.getValue(), NewExperienceFragment.class));
        }
        else if (i == R.id.rl_rewards) {
            switchFragmentByMenuData(BaseMenuData.newInstance(
                    GuestMenuData.REWARDS.getValue(), RewardsViewFragment.class));
        }
        else if (i == R.id.iv_location) {
            switchFragmentByMenuData(BaseMenuData.newInstance(
                    GuestMenuData.FIND_ALIGNMENT.getValue(), FindAlignmentFragment.class));
        }
        else if (i == R.id.iv_music) {
            switchFragmentByMenuData(BaseMenuData.newInstance(
                    GuestMenuData.MUSIC.getValue(), null));
        }
    }
}