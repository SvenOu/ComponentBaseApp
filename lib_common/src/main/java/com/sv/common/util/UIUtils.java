package com.sv.common.util;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatDrawableManager;

public class UIUtils {

	public static Bitmap vectorToBitmap(Context ctx, @DrawableRes int resVector) {
		@SuppressLint("RestrictedApi") Drawable drawable = AppCompatDrawableManager.get().getDrawable(ctx, resVector);
		Bitmap b = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(b);
		drawable.setBounds(0, 0, c.getWidth(), c.getHeight());
		drawable.draw(c);
		return b;
	}

	public static  void dialog(Context ctx,String msg) {
		Builder builder = new Builder(ctx);
		builder.setMessage(msg);
		builder.setTitle("Warning");
		builder.setNegativeButton("OK", null);
		builder.create().show();
	}

	/***** image_util ***/
	public static Boolean haveSDCard() {
		Boolean isSDPresent = android.os.Environment.getExternalStorageState()
				.equals(android.os.Environment.MEDIA_MOUNTED);
		if (isSDPresent) {
			return isSDPresent;
		} else {
			return false;
		}

	}
	/***** image_util_end ***/
}
