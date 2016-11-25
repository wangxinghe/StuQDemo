package com.mouxuejie.stuqdemo.touch;

import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by wangxinghe1 on 2016/11/25.
 */

public class LogUtil {

    public static void info(String tag, String method, int action) {
        String actionStr = "";
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                actionStr = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                actionStr = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                actionStr = "ACTION_UP";
                break;
            default:
                break;
        }

        Log.i(tag, method + " " + actionStr);
    }
}
