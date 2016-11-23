package com.mouxuejie.stuqdemo.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by wangxinghe1 on 2016/11/23.
 */

public class NestedChildViewPager extends ViewPager {
    private int mTouchSlop;
    private float mLastX;
    private float mLastY;

    public NestedChildViewPager(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public NestedChildViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        for(int i = 0; i < getChildCount(); i++)
        {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

            int h = child.getMeasuredHeight();
            if(h > height) height = h;
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        int curPosition;
//        float curLastX = ev.getX();
//        float curLastY = ev.getY();
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                getParent().requestDisallowInterceptTouchEvent(true);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                curPosition = this.getCurrentItem();
//                int count = this.getAdapter().getCount();
//                Log.i("NestedChildViewPager", "curPosition:=" +curPosition);
//                // 水平方向，当前页面在最后一页和第0页的时候，由父亲拦截触摸事件
//                if (Math.abs(curLastX - mLastX) > mTouchSlop
//                        && Math.abs(curLastX - mLastX) > Math.abs(curLastY - mLastY)) {
//                    if (curPosition == count - 1 || curPosition == 0) {
//                        getParent().requestDisallowInterceptTouchEvent(false);
//                    } else {//其他情况，由孩子拦截触摸事件
//                        getParent().requestDisallowInterceptTouchEvent(true);
//                    }
//                } else {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                }
//                break;
//            default:
//                break;
//
//        }
//
//        mLastX = curLastX;
//        mLastY = curLastY;

        return super.dispatchTouchEvent(ev);
    }
}
