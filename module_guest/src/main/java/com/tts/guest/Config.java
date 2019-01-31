package com.tts.guest;



import com.sv.common.util.WidgetUtil;

import java.io.File;

public class Config {

	/**
	 * 本地连接服务器
	 */
	//服务器地址，不同开发模式下连接服务器地址不一样。
	private static final String DEV_BASE_URL = "http://testkudugs.nextxnow.com";
	/**
	 * 测试服务器
	 */
	private static final String TEST_BASE_URL = "http://testkudugs.nextxnow.com";
	/**
	 * 正式版服务器
	 */
	private static final String SERVER_BASE_URL = "http://testkudugs.nextxnow.com";


	/**
	 * 本地开发模式
	 */
	private static final String DEV_MODE = BuildConfig.DEV_MODE;
	/**
	 * 测试模式
	 */
	private static final String TEST_MODE = BuildConfig.TEST_MODE;
	/**
	 * 正式版发布
	 */
	private static final String PROD_MODE = BuildConfig.PROD_MODE;

	/**
	 * TimeStamp Parttern.
	 */
	public static final String DATE_TIME_PARTTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

	private static final String PROD_PROMOTION_CLIENT_ID = "churchsgs_2017_android";
	private static final String PROD_PROMOTION_PASSWORD = "5f59ca34509cd794584b6a5416488b8e";

	private static final String TEST_PROMOTION_CLIENT_ID = "churchsgs_2017_android";
	private static final String TEST_PROMOTION_PASSWORD = "5f59ca34509cd794584b6a5416488b8e";


	/**
	 * change to "false" if need to publish the app.
	 */
	public static final boolean IS_DEVELOP_MODE = BuildConfig.IS_DEVELOP_MODE;
	/**
	 * change to "PROD" if need to publish the app.
	 */
	private static final String CURRENT_MODE = BuildConfig.CURRENT_MODE;

	/*
	 * Device Information
	 */
	private static final String APP_ID = "gueststar_android";
	private static final String TEST_APP_ID = "churchsce_android";
	private static final String LOCAL_TEST_APP_ID = "churchsce_android";

	public static final String DEVICE_SYSTEM = "Android";
	public static final String SOURCE = "Android";
	public static final String GOOGLE_MAP_API_KEY = BuildConfig.GOOGLE_MAP_APP_ID;


	private String appVersion = "";
	private int appVersionNumber;
	/**
	 * 设备类型 {@link #DEVICE_SYSTEM}
	 */
	public String deviceType;
//	public Context appContext;

	private File baseImageRoot;//set it in GuestStarApplication
	/**
	 * 资源存储位置,首选SD卡根目录
	 */
	public static File TEMP_BASE_FOLDER =  null;//set it in BaseActivity
	/**
	 * 相对于{@link #TEMP_BASE_FOLDER}的位置
	 */
	public static String TEMP_IMAGE_FOLDER_IN_SDCARD = null;//set it in BaseActivity

	private String languageCode = WidgetUtil.en;

	public String adid;//广告ID

	/**
	 * 设置当前的语言环境
	 * @param languageCode {@link WidgetUtil#en} or {@link WidgetUtil#es}
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public File getBaseImageRoot() {
		return baseImageRoot;
	}

	public void setBaseImageRoot(File baseImageRoot) {
		this.baseImageRoot = baseImageRoot;
	}

	public  String getAppVersion() {
		return appVersion;
	}

	public  void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public static String getAppModePrefix(){

		String devPrefix = "dev_";
		String testPrefix = "test_";
		String proPrefix = "";
		String traPrefix = "tra_";

		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE)) {
            return proPrefix;
        } else if (CURRENT_MODE.equalsIgnoreCase(TEST_MODE)) {
            return testPrefix;
        } else if (CURRENT_MODE.equalsIgnoreCase(DEV_MODE)) {
            return devPrefix;
        } else {
            return devPrefix;
        }
	}

	/**
	 * 获取后台服务器地址
	 * @return {@link #SERVER_BASE_URL} <br/>
	 * {@link #TEST_BASE_URL}<br/>
	 * {@link #DEV_BASE_URL} <br/>
	 */
	public static String getBaseURL(){

		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE)) {
            return Config.SERVER_BASE_URL;
        } else if (CURRENT_MODE.equalsIgnoreCase(TEST_MODE)) {
            return Config.TEST_BASE_URL;
        } else if (CURRENT_MODE.equalsIgnoreCase(DEV_MODE)) {
            return Config.DEV_BASE_URL;
        } else {
            return Config.DEV_BASE_URL;
        }
	}

	public static String getAppId(){
		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE)){
			if(IS_DEVELOP_MODE) {
                return TEST_APP_ID;
            } else {
                return APP_ID;
            }
		}
		return LOCAL_TEST_APP_ID;
	}

	public static String getAppStatusText(){
		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE)){
			if(IS_DEVELOP_MODE) {
                return "PROD SERVER DEV";
            } else {
                return "";
            }
		}
		if (CURRENT_MODE.equalsIgnoreCase(TEST_MODE)){
			if(IS_DEVELOP_MODE) {
                return "TEST SERVER DEV";
            } else {
                return "TEST SERVER";
            }
		}
		if (CURRENT_MODE.equalsIgnoreCase(DEV_MODE)){
			if(IS_DEVELOP_MODE) {
                return "LOCAL SERVER DEV";
            } else {
                return "LOCAL SERVER";
            }
		}
		return "unknow";
	}

	private static final String DEV_ONLINE_CONFIG_URL = "http://onlineconfig.easternphoenix.com:8621/";
	private static final String TEST_ONLINE_CONFIG_URL = "http://testonlineconfig.technologystudios.com";
	private static final String TRAINER_ONLINE_CONFIG_URL = "https://onlineconfig.nextxnow.com";
	private static final String SERVER_ONLINE_CONFIG_URL = "https://onlineconfig.nextxnow.com";

	public static String getOnlineConfigMode(){
		if(CURRENT_MODE.equals(TEST_MODE)){
			return "TEST";
		}else if(CURRENT_MODE.equals(PROD_MODE)){
			return "PROD";
		}
		return "DEBUG";
	}

	public static String getOnlineConfigURL() {
		if (CURRENT_MODE.equals(TEST_MODE)) {
			return TEST_ONLINE_CONFIG_URL;
		}else if (CURRENT_MODE.equals(PROD_MODE)) {
			return SERVER_ONLINE_CONFIG_URL;
		}
		return DEV_ONLINE_CONFIG_URL;
	}

	public static boolean isDevelopMode(){
		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE) && !IS_DEVELOP_MODE) {
            return false;
        }
		return true;
	}

	public int getAppVersionNumber() {
		return appVersionNumber;
	}

	public void setAppVersionNumber(int appVersionNumber) {
		this.appVersionNumber = appVersionNumber;
	}


	public static String getPromotionClientId(){
		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE) && !IS_DEVELOP_MODE) {
			return PROD_PROMOTION_CLIENT_ID;
		} else if (CURRENT_MODE.equalsIgnoreCase(TEST_MODE) || IS_DEVELOP_MODE) {
			return TEST_PROMOTION_CLIENT_ID;
		} else {
			return TEST_PROMOTION_CLIENT_ID;
		}
	}

	public static String getPromotionPassword(){
		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE) && !IS_DEVELOP_MODE) {
			return PROD_PROMOTION_PASSWORD;
		} else if (CURRENT_MODE.equalsIgnoreCase(TEST_MODE) || IS_DEVELOP_MODE) {
			return TEST_PROMOTION_PASSWORD;
		} else {
			return TEST_PROMOTION_PASSWORD;
		}
	}

	public static String getAppMode(){
		if (CURRENT_MODE.equalsIgnoreCase(PROD_MODE) && !IS_DEVELOP_MODE) {
			return PROD_MODE;
		} else if (CURRENT_MODE.equalsIgnoreCase(TEST_MODE) || IS_DEVELOP_MODE) {
			return TEST_MODE;
		} else {
			return TEST_MODE;
		}
	}
}