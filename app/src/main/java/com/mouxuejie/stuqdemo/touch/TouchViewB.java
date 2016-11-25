package com.mouxuejie.stuqdemo.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by wangxinghe1 on 2016/11/25.
 */

public class TouchViewB extends LinearLayout {

    public TouchViewB(Context context) {
        super(context);
    }

    public TouchViewB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.info("TouchViewB", "dispatchTouchEvent", ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtil.info("TouchViewB", "onInterceptTouchEvent", ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.info("TouchViewB", "onTouchEvent", event.getAction());
        return super.onTouchEvent(event);
    }

}
