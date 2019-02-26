package com.tts.guest.main.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.sv.common.widget.AbstractSimpleListBaseAdapter;
import com.tts.guest.R;
import com.tts.guest.common.bean.GuestMenuData;
import com.tts.guest.common.bean.MenuData;
import com.tts.guest.experience.view.NewExperienceFragment;
import com.tts.guest.location.view.FindAlignmentFragment;
import com.tts.guest.menu.view.MenuFragment;
import com.tts.guest.profile.view.ProfileInfoFragment;
import com.tts.guest.rewards.view.RewardsViewFragment;
import com.tts.guest.saving.view.CouponFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainSlideMenuAdapter extends AbstractSimpleListBaseAdapter<MenuData> {
    private List<MenuData> menuDatas = new ArrayList<>();
    public MainSlideMenuAdapter(Context context) {
        super(context, null);
        recreateMenuData();
        setData(menuDatas);
    }

    public void recreateMenuData() {
        menuDatas.clear();
        menuDatas.add(MenuData.newInstance(R.string.home, R.drawable.icon_sidebar_home_selector, GuestMenuData.HOME.getValue(), HomeFragment.class));
        menuDatas.add(MenuData.newInstance(R.string.feedback, R.drawable.main_menu_feedback_selector, GuestMenuData.NEW_EXPERIENCE.getValue(), NewExperienceFragment.class));
        menuDatas.add(MenuData.newInstance(R.string.savings, R.drawable.main_menu_msvaing_selector, GuestMenuData.COUPON.getValue(), CouponFragment.class));
        menuDatas.add(MenuData.newInstance(R.string.rewards, R.drawable.main_menu_rewardmv_selector, GuestMenuData.REWARDS.getValue(), RewardsViewFragment.class));
        menuDatas.add(MenuData.newInstance(R.string.menu, R.drawable.main_menu_menu_selector, GuestMenuData.MENU.getValue(), MenuFragment.class));
        menuDatas.add(MenuData.newInstance(R.string.locations, R.drawable.main_menu_fchurchs_selector, GuestMenuData.FIND_ALIGNMENT.getValue(), FindAlignmentFragment.class));
        menuDatas.add(MenuData.newInstance(R.string.photo_filter, R.drawable.icon_sidebar_photo_filter_selector, GuestMenuData.HOME.getValue(),HomeFragment.class));
        menuDatas.add(MenuData.newInstance(R.string.music, R.drawable.icon_sidebar_music_selector, GuestMenuData.MUSIC.getValue(), null));
        menuDatas.add(MenuData.newInstance(R.string.myChurchs, R.drawable.main_menu_mchurchs_selector, GuestMenuData.PROFILE_INFO.getValue(), ProfileInfoFragment.class));
    }

    @Override
    protected void onBindViewHolder(AbstractSimpleListBaseAdapter.ViewBinder viewBinder) {
        viewBinder.itemId = R.layout.main_slide_menu_item;
        viewBinder.elementIds = new String[] {"id.menu_title", "id.menu_icon"};
    }

    @Override
    protected void onBindView(MenuData itemData, Map viewHolder, View convertView, int position) {
        TextView menuTitle = (TextView) viewHolder.get("id.menu_title");
        ImageView menuIcon = (ImageView) viewHolder.get("id.menu_icon");
        menuTitle.setText(itemData.getTitleResId());
        menuIcon.setImageResource(itemData.getIconResId());
    }
}
