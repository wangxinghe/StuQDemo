package com.mouxuejie.stuqdemo.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by wangxinghe1 on 2016/11/25.
 */

public class TouchViewA extends LinearLayout {

    public TouchViewA(Context context) {
        super(context);
    }

    public TouchViewA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.info("TouchViewA", "dispatchTouchEvent", ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtil.info("TouchViewA", "onInterceptTouchEvent", ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.info("TouchViewA", "onTouchEvent", event.getAction());
        return super.onTouchEvent(event);
    }

}
