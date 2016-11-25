package com.mouxuejie.stuqdemo.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wangxinghe1 on 2016/11/25.
 */

public class TouchViewC extends View {

    public TouchViewC(Context context) {
        super(context);
    }

    public TouchViewC(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogUtil.info("TouchViewC", "dispatchTouchEvent", event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.info("TouchViewC", "onTouchEvent", event.getAction());
        return super.onTouchEvent(event);
    }
}
