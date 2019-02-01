package com.sv.security.bean;

public enum SecurityMenuData {
    /**
     *
     */
    APP_LAUNCH("appLaunch"),
    REGISTER_MODE("registerMode"),
    TERMS("terms"),
    REGISTER("register");

    private String value;

    SecurityMenuData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
