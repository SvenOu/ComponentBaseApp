package com.sv.common.screen_navigation;

import com.sv.common.AbstractBaseFragment;

public class BaseMenuData {
    private String key;
    private Class<? extends AbstractBaseFragment> fragmentClass;

    public BaseMenuData(String key, Class<? extends AbstractBaseFragment> fragmentClass) {
        this.key = key;
        this.fragmentClass = fragmentClass;
    }

    public static BaseMenuData newInstance(String key, Class<? extends AbstractBaseFragment> fragmentClass) {
        return new BaseMenuData(key, fragmentClass);
    }

    public Class<? extends AbstractBaseFragment> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<? extends AbstractBaseFragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "BaseMenuData{" +
                "key='" + key + '\'' +
                ", fragmentClass=" + fragmentClass +
                '}';
    }
}
