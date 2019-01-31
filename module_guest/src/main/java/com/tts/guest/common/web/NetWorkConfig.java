package com.tts.guest.common.web;

import com.tts.guest.Config;

/**
 * Created by sven-ou on 2017/12/21.
 */

public class NetWorkConfig {
    public static final String signUpUrl =  Config.getBaseURL() + "/signup.do";
    public static final String updateUserInfoUrl =  Config.getBaseURL() + "/updateuserinfo.do";
    public static final String signInUrl =  Config.getBaseURL() + "/signin.do";
    public static final String signOutUrl =  Config.getBaseURL() + "/signout.do";
}
