package com.tts.guest.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


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

public class MainSlideMenuAdapter extends BaseAdapter {
    private List<MenuData> MENU_DATAS = new ArrayList<>();

    private Context context;
    private boolean hasRegister = false;

    public MainSlideMenuAdapter(Context context) {
        this.context = context;
        recreateMenuData();
    }

    public void recreateMenuData() {

        MENU_DATAS.clear();
        MENU_DATAS.add(MenuData.newInstance(R.string.home, R.drawable.icon_sidebar_home_selector, GuestMenuData.HOME.getValue(), HomeFragment.class));
        MENU_DATAS.add(MenuData.newInstance(R.string.feedback, R.drawable.main_menu_feedback_selector, GuestMenuData.NEW_EXPERIENCE.getValue(), NewExperienceFragment.class));
        MENU_DATAS.add(MenuData.newInstance(R.string.savings, R.drawable.main_menu_msvaing_selector, GuestMenuData.COUPON.getValue(), CouponFragment.class));
        MENU_DATAS.add(MenuData.newInstance(R.string.rewards, R.drawable.main_menu_rewardmv_selector, GuestMenuData.REWARDS.getValue(), RewardsViewFragment.class));
        MENU_DATAS.add(MenuData.newInstance(R.string.menu, R.drawable.main_menu_menu_selector, GuestMenuData.MENU.getValue(), MenuFragment.class));
        MENU_DATAS.add(MenuData.newInstance(R.string.locations, R.drawable.main_menu_fchurchs_selector, GuestMenuData.FIND_ALIGNMENT.getValue(), FindAlignmentFragment.class));
        MENU_DATAS.add(MenuData.newInstance(R.string.photo_filter, R.drawable.icon_sidebar_photo_filter_selector, GuestMenuData.HOME.getValue(),HomeFragment.class));
        MENU_DATAS.add(MenuData.newInstance(R.string.music, R.drawable.icon_sidebar_music_selector, GuestMenuData.MUSIC.getValue(), null));
        MENU_DATAS.add(MenuData.newInstance(R.string.myChurchs, R.drawable.main_menu_mchurchs_selector, GuestMenuData.PROFILE_INFO.getValue(), ProfileInfoFragment.class));
    }


    @Override
    public int getCount() {
        return MENU_DATAS.size();
    }

    @Override
    public Object getItem(int position) {
        return MENU_DATAS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int listViewItemType = getItemViewType(position);
        ViewHolder viewHolder = null;

        if(null == convertView){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(this.context).inflate(R.layout.main_slide_menu_item, null);
            viewHolder.menuTitle = (TextView) convertView.findViewById(R.id.menu_title);
            viewHolder.menuIcon = (ImageView) convertView.findViewById(R.id.menu_icon);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MenuData menuData = (MenuData) getItem(position);
        viewHolder.menuTitle.setText(menuData.getTitleResId());
        viewHolder.menuIcon.setImageResource(menuData.getIconResId());

        if(GuestMenuData.PROFILE_INFO.getValue().equalsIgnoreCase(menuData.getKey())
                && !hasRegister){
            viewHolder.menuTitle.setText(R.string.register);
        }

        return convertView;
    }

    private class ViewHolder{
        public  TextView menuTitle;
        public  ImageView menuIcon;
    }
}
