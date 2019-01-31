package com.sv.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.sv.common.R;

public class CycleCountView extends View {

	private static final int BACKGROUND_COLOR = Color.TRANSPARENT;
	private static final int CYCLE_BORDER_COLOR = R.color.cycle_border_color;
	private static final int CYCLE_COLOR = R.color.cycle_color;

	private static final int CIRCLE_SPACE = 5;

	private int mWidth = 0;
	private int mCouponCount = 0;
	private int mTextSize = 25;

	private final Rect textBounds = new Rect();

	public CycleCountView(Context context) {
		super(context);
	}

	public CycleCountView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CycleCountView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@SuppressLint({"DrawAllocation" })
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		mWidth = getWidth();
		canvas.drawColor(BACKGROUND_COLOR);
		if(mCouponCount <=0) {
            return;
        }
		/*外层圆*/
		Paint paint1 = new Paint();
		paint1.setAntiAlias(true);
		int r1 = mWidth /2;
		paint1.setColor(ContextCompat.getColor(getContext(),CYCLE_BORDER_COLOR));
		canvas.drawCircle(r1, r1, r1, paint1);

		/*内层圆*/
		Paint paint2 = new Paint();
		paint2.setAntiAlias(true);
		int r2 = mWidth /2-CIRCLE_SPACE;
		paint2.setColor(ContextCompat.getColor(getContext(), CYCLE_COLOR));
		canvas.drawCircle(r1, r1, r2, paint2);

		/*内层文字*/
		paint1.setTextSize(mTextSize);
		String text = String.valueOf(mCouponCount);
		paint1.getTextBounds(text, 0, text.length(), textBounds);
		canvas.drawText(text, r1 - textBounds.exactCenterX(), r1 - textBounds.exactCenterY(), paint1);
	}

	public boolean updateCount(int couponCount) {
		mCouponCount = couponCount;
		invalidate();
		return false;
	}

	public int getCouponCount() {
		return mCouponCount;
	}

	public void setCouponCount(int couponCount) {
		mCouponCount = couponCount;
		invalidate();
	}

	public int getTextSize() {
		return mTextSize;
	}

	public void setTextSize(int textSize) {
		mTextSize = textSize;
		invalidate();
	}

}
