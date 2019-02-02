package com.tts.guest.common.bean;

public enum GuestMenuData {
    /**
     *
     */
    HOME("home"),
    NEW_EXPERIENCE("newExperience"),
    EXPERIENCE_DETAIL("experienceDetail"),
    FIND_ALIGNMENT("findAlignment"),
    ALIGNMENT_RESULT("alignmentResult"),
    MENU("menu"),
    MUSIC("music"),
    PROFILE_INFO("profileInfo"),
    REWARDS("rewards"),
    COUPON("coupon"),
    ;

    private String value;

    GuestMenuData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
