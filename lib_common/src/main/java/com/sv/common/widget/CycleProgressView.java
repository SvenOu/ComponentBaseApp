package com.sv.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.sv.common.R;

/**
 * Created by sven-ou on 2017/7/26.
 */

public class CycleProgressView extends View {

    private int strokeWidth = 20;//dp
    private int progressColor = R.color.progress_color;
    private int unProgressColor = R.color.un_progress_color;

    private Paint paint;
    private float value = 100f;
    private float maxValue = 100f;

    private int rotate = 90;

    public CycleProgressView(Context context) {
        super(context);
        init();
    }

    public CycleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CycleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CycleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth(), viewHeight = getHeight(), pxStrokeWidth = dipTopx(getContext(),strokeWidth);
        int rectLength, strokeOffset = (int) Math.round(pxStrokeWidth / 2.0);
        int offset = (int) Math.abs(Math.round((viewHeight - viewWidth) / 2.0));
        int drawValue = Math.round((value / maxValue) * 360);
        RectF rectfHead;
        if (viewWidth > viewHeight) {
            rectLength = viewHeight;
            rectfHead = new RectF(strokeOffset + offset, strokeOffset,
                    rectLength - strokeOffset + offset, rectLength - strokeOffset);
        } else {
            rectLength = viewWidth;
            rectfHead = new RectF(strokeOffset, strokeOffset + offset,
                    rectLength - strokeOffset, rectLength - strokeOffset + offset);
        }
        if (null == paint) {
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(pxStrokeWidth);
        }

        // progress
        paint.setColor(ContextCompat.getColor(getContext(), progressColor));
        canvas.drawArc(rectfHead, rotate, drawValue, false, paint);

        //un progress
        if(drawValue < 360){
            paint.setColor(ContextCompat.getColor(getContext(), unProgressColor));
            canvas.drawArc(rectfHead, drawValue + rotate -1, 362 - drawValue, false, paint);
        }
    }

	/**
	 * 将dip或dp值转换为px值，保证尺寸大小不变
	 */
	public static int dipTopx(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}


    // get and set method
    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getProgressColor() {
        return progressColor;
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
    }

    public int getUnProgressColor() {
        return unProgressColor;
    }

    public void setUnProgressColor(int unProgressColor) {
        this.unProgressColor = unProgressColor;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public int getRotate() {
        return rotate;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }
}
