package com.tts.guest.common.bean;

import com.sv.common.AbstractBaseFragment;
import com.sv.common.screen_navigation.BaseMenuData;

public class MenuData extends BaseMenuData {
    private int titleResId;
    private int iconResId;

    public MenuData(int titleResId, int iconResId, String key, Class<? extends AbstractBaseFragment> fragmentClass) {
        super(key, fragmentClass);
        //titleResId 和 iconResId只在 MainSlideMenuAdapter用到
        this.titleResId = titleResId;
        this.iconResId = iconResId;
    }

    public static MenuData newInstance(int titleResId, int iconResId, String key, Class<? extends AbstractBaseFragment> fragmentClass) {
        return new MenuData(titleResId, iconResId, key, fragmentClass);
    }

    public int getTitleResId() {
        return titleResId;
    }

    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}