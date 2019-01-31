package com.tts.guest.common.context;

import com.sv.common.BuildConfig;
import com.sv.common.context.ContextManager;
import com.tts.guest.Config;

public class GuestContext {
	private Config config = new Config();


	// 限制单例
	private GuestContext() {}
	public static GuestContext getInstance(){
		return ContextManager.getInstance().getModuleContext(
				BuildConfig.MODULE_NAME,
				GuestContext.class);
	}

	public Config getConfig() {
		return config;
	}
}