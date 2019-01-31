package com.tts.guest.app.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.tts.guest.R;
import com.sv.common.util.Logger;

import java.util.List;

//暂时只支持3个button的group
public class SegmentedButton extends FrameLayout implements View.OnClickListener{

    private static final String TAG = SegmentedButton.class.getSimpleName();

    private LinearLayout mLlContentView;
    private Button mBtnLeft;
    private Button mBtnMiddle;
    private Button mBtnRight;
    private LayoutInflater mLayoutInflater;
    private String selectedLabel = null;
    private String selectedValue = null;

    private List<SegmentedButtonData> data;

    public SegmentedButton(Context context) {
        super(context);
        iniView();
    }

    public SegmentedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniView();
    }

    public SegmentedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SegmentedButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        iniView();
    }


    private void iniView() {
        mLayoutInflater = LayoutInflater.from(getContext());
        mLlContentView = (LinearLayout) mLayoutInflater.inflate(R.layout.tts_segmented_button, null);
        addView(mLlContentView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        mBtnLeft = (Button) mLlContentView.findViewById(R.id.btn_left);
        mBtnMiddle = (Button) mLlContentView.findViewById(R.id.btn_middle);
        mBtnRight = (Button) mLlContentView.findViewById(R.id.btn_right);
    }

    private void loadData() {
        if(null == data || data.size() <= 0){
            Logger.e(TAG, "data is empty. ");
            return;
        }

        mBtnLeft.setText(data.get(0).getLabel());
        mBtnLeft.setTag(data.get(0).getValue());

        mBtnMiddle.setText(data.get(1).getLabel());
        mBtnMiddle.setTag(data.get(1).getValue());

        mBtnRight.setText(data.get(2).getLabel());
        mBtnRight.setTag(data.get(2).getValue());

        mBtnLeft.setOnClickListener(this);
        mBtnMiddle.setOnClickListener(this);
        mBtnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Button button = (Button) v;
        selectedValue = (String) button.getTag();
        selectedLabel = (String) button.getText();

        int i = v.getId();
        if (i == R.id.btn_left) {
            mBtnLeft.setBackgroundResource(R.drawable.segmented_button_left_or_right_pressed);
            mBtnLeft.setTextColor(ContextCompat.getColor(getContext(), R.color.c4_1));

            mBtnMiddle.setBackgroundResource(R.drawable.segmented_button_middle);
            mBtnMiddle.setTextColor(ContextCompat.getColor(getContext(), R.color.c3_1));

            mBtnRight.setBackgroundResource(R.drawable.segmented_button_left_or_right);
            mBtnRight.setTextColor(ContextCompat.getColor(getContext(), R.color.c3_1));

        } else if (i == R.id.btn_middle) {
            mBtnLeft.setBackgroundResource(R.drawable.segmented_button_left_or_right);
            mBtnLeft.setTextColor(ContextCompat.getColor(getContext(), R.color.c3_1));

            mBtnMiddle.setBackgroundResource(R.drawable.segmented_button_middle_pressed);
            mBtnMiddle.setTextColor(ContextCompat.getColor(getContext(), R.color.c4_1));

            mBtnRight.setBackgroundResource(R.drawable.segmented_button_left_or_right);
            mBtnRight.setTextColor(ContextCompat.getColor(getContext(), R.color.c3_1));

        } else if (i == R.id.btn_right) {
            mBtnLeft.setBackgroundResource(R.drawable.segmented_button_left_or_right);
            mBtnLeft.setTextColor(ContextCompat.getColor(getContext(), R.color.c3_1));

            mBtnMiddle.setBackgroundResource(R.drawable.segmented_button_middle);
            mBtnMiddle.setTextColor(ContextCompat.getColor(getContext(), R.color.c3_1));

            mBtnRight.setBackgroundResource(R.drawable.segmented_button_left_or_right_pressed);
            mBtnRight.setTextColor(ContextCompat.getColor(getContext(), R.color.c4_1));

        } else {
        }
    }

    public static class SegmentedButtonData{

        private String label;
        private String value;

        public SegmentedButtonData(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public String getValue() {
            return value;
        }

    }

    public List<SegmentedButtonData> getData() {
        return data;
    }

    public void setAndLoadData(List<SegmentedButtonData> data) {
        this.data = data;
        loadData();
    }

    public String getSelectedLabel() {
        return selectedLabel;
    }

    public void setSelectedLabel(String selectedLabel) {
        this.selectedLabel = selectedLabel;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

}
