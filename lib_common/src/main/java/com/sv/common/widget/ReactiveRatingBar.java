package com.sv.common.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.sv.common.R;
import com.sv.common.util.UIUtils;


public class ReactiveRatingBar extends View {

    private static final String TAG = ReactiveRatingBar.class.getSimpleName();

    private final int lightStarResourceId = R.drawable.image_star_light;
    private final int darkStarResourceId = R.drawable.image_star_dark;

    /**
     * 自动计算星星高度，宽度，间隔
     */
    private boolean isAutoCalculateHeight = true;
    /**
     * 星星数
     */
    private int numStars = 5;
    /**
     * 星星之间最大间隔
     */
    private int maxStarSpace = 50;
    /**
     * 星星与顶部或者底部的间隔
     */
    private int topBottomSpace = 0;
    /**
     * 星星的宽度
     */
    private int starWidth = 100;
    /**
     * 星星高度
     */
    private int starHeight = 100;
    /**
     * 星星分数（高亮星星数）
     */
    private int rating = 0;

    private Bitmap lightStarBitmap;
    private Bitmap darkStarBitmap;

    private ReactiveRatingBarListener reactiveRatingBarListener;

    public ReactiveRatingBar(Context context) {
        super(context);
    }

    public ReactiveRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReactiveRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ReactiveRatingBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    @SuppressLint("RestrictedApi")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth(), viewHeight = getHeight(), leftOrRightSpace = 0;
        if (isAutoCalculateHeight) {
            starHeight = (int) (viewHeight - 2.0 * topBottomSpace);
            starWidth = starHeight;
            maxStarSpace = starWidth;
        }
        if (null == lightStarBitmap) {
            Bitmap sourceBitmap = UIUtils.vectorToBitmap(getContext(), lightStarResourceId);
            lightStarBitmap = Bitmap.createScaledBitmap(sourceBitmap, starWidth, starHeight, false);
        }
        if (null == darkStarBitmap) {
            Bitmap sourceBitmap = UIUtils.vectorToBitmap(getContext(), darkStarResourceId);
            darkStarBitmap = Bitmap.createScaledBitmap(sourceBitmap, starWidth, starHeight, false);
        }

        int startSpace = (int) ((viewWidth - numStars * starWidth) / (numStars + 1.0));
        if (startSpace < maxStarSpace) {
            leftOrRightSpace = startSpace;
        } else {
            startSpace = maxStarSpace;
            leftOrRightSpace = (int) ((((viewWidth - numStars * starWidth) - ((numStars - 1) * startSpace))) / 2.0);
        }
        int left, top = topBottomSpace;
        for (int i = 1; i <= numStars; i++) {
            left = leftOrRightSpace + (i - 1) * (starWidth + startSpace);
            if (i <= rating) {
                canvas.drawBitmap(lightStarBitmap, left, top, null);
            } else {
                canvas.drawBitmap(darkStarBitmap, left, top, null);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int starRating = calculateStarRating(event);
        if (null != reactiveRatingBarListener) {
            reactiveRatingBarListener.onRatingChanged(this, starRating);
        }
        this.setRating(starRating);
        this.invalidate();
        return super.onTouchEvent(event);
    }

    /**
     * @return 0表示左侧区域，星星分数为0, -1表示无效
     */
    private int calculateStarRating(MotionEvent event) {
        int rating = 0, viewWidth = getWidth(), leftOrRightSpace, x = (int) event.getX();
        int startSpace = (int) ((viewWidth - numStars * starWidth) / (numStars + 1.0));
        if (startSpace < maxStarSpace) {
            leftOrRightSpace = startSpace;
        } else {
            startSpace = maxStarSpace;
            leftOrRightSpace = (int) ((((viewWidth - numStars * starWidth) - ((numStars - 1) * startSpace))) / 2.0);
        }
        if (x <= leftOrRightSpace) {
            return rating;
        } else if (x > (viewWidth - leftOrRightSpace)) {
            rating = numStars;
            return rating;
        }
        int startPointStart, startPointEnd;
        for (int i = 1; i <= numStars; i++) {
            if (i == 1) {
                startPointStart = leftOrRightSpace;
                startPointEnd = startPointStart + starWidth;
                if (x > startPointStart && x <= startPointEnd) {
                    rating = 1;
                    break;
                }
            } else {
                startPointStart = (leftOrRightSpace + starWidth) + (i - 2) * (startSpace + starWidth);
                startPointEnd = startPointStart + startSpace + starWidth;
                if (x > startPointStart && x <= startPointEnd) {
                    rating = i;
                    break;
                }
            }
        }
        return rating;
    }

    public interface ReactiveRatingBarListener {
        void onRatingChanged(ReactiveRatingBar reactiveRatingBar, int rating);
    }

    public ReactiveRatingBarListener getReactiveRatingBarListener() {
        return reactiveRatingBarListener;
    }

    public void setReactiveRatingBarListener(ReactiveRatingBarListener reactiveRatingBarListener) {
        this.reactiveRatingBarListener = reactiveRatingBarListener;
    }

    public int getNumStars() {
        return numStars;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    public int getMacSpace() {
        return maxStarSpace;
    }

    public void setMacSpace(int macSpace) {
        this.maxStarSpace = macSpace;
    }

    public int getRating() {
        return rating;
    }

    public int getStarWidth() {
        return starWidth;
    }

    public void setStarWidth(int starWidth) {
        this.starWidth = starWidth;
    }

    /**
     * @param rating setRating and refresh
     */
    public void setRating(int rating) {
        if (rating > numStars) {
            throw new RuntimeException("rating must <= numStars !");
        }
        this.rating = rating;
        invalidate();
    }

    public int getStarHeight() {
        return starHeight;
    }

    public void setStarHeight(int starHeight) {
        this.starHeight = starHeight;
    }

    public boolean isAutoCalculateHeight() {
        return isAutoCalculateHeight;
    }

    public void setAutoCalculateHeight(boolean autoCalculateHeight) {
        isAutoCalculateHeight = autoCalculateHeight;
    }

    public int getMaxStarSpace() {
        return maxStarSpace;
    }

    public void setMaxStarSpace(int maxStarSpace) {
        this.maxStarSpace = maxStarSpace;
    }

    public int getTopBottomSpace() {
        return topBottomSpace;
    }

    public void setTopBottomSpace(int topBottomSpace) {
        this.topBottomSpace = topBottomSpace;
    }
}
