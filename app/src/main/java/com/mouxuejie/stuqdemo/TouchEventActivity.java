package com.mouxuejie.stuqdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.mouxuejie.stuqdemo.touch.LogUtil;

/**
 * Created by wangxinghe1 on 2016/11/23.
 */

public class TouchEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.info("TouchEventActivity", "dispatchTouchEvent", ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.info("TouchEventActivity", "onTouchEvent", event.getAction());
        return super.onTouchEvent(event);
    }
}
