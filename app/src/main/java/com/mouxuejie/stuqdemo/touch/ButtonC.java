package com.mouxuejie.stuqdemo.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by wangxinghe1 on 2016/11/25.
 */

public class ButtonC extends Button {

    public ButtonC(Context context) {
        super(context);
    }

    public ButtonC(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogUtil.info("ButtonC", "dispatchTouchEvent", event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.info("ButtonC", "onTouchEvent", event.getAction());
        return super.onTouchEvent(event);
    }

}
