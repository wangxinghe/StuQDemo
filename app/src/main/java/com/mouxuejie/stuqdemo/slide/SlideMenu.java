package com.mouxuejie.stuqdemo.slide;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

/**
 * Created by wangxinghe1 on 2016/11/24.
 */

public class SlideMenu extends ViewGroup {

    private static final int SLIDE_MODE_DEFAULT = 0;
    private static final int SLIDE_MODE_SLOW = 1;
    private static final int SLIDE_MODE_SLOW_SCALE = 2;

    private int mSlideMode = SLIDE_MODE_SLOW;

    private ViewGroup mMenu;
    private ViewGroup mContent;
    private int mMenuWidth;
    private int mContentWidth;
    private int mScreenWidth;
    private int mScreenHeight;
    private int mMenuRightPadding;
    private Scroller mScroller;
    private int mLastX;
    private int mLastY;
    private float scale;
    private boolean isOpen;

    public SlideMenu(Context context) {
        this(context, null, 0);
    }

    public SlideMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        //获取屏幕的宽和高
        mScreenWidth = metrics.widthPixels;
        mScreenHeight = metrics.heightPixels;
        //设置Menu距离屏幕右侧的距离，convertToDp是将代码中的100转换成100dp
        mMenuRightPadding = convertToDp(context,100);
        mScroller = new Scroller(context);
        isOpen = false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //拿到Menu，Menu是第0个孩子
        mMenu = (ViewGroup) getChildAt(0);
        //拿到Content，Content是第1个孩子
        mContent = (ViewGroup) getChildAt(1);
        //设置Menu的宽为屏幕的宽度减去Menu距离屏幕右侧的距离
        mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth - mMenuRightPadding;
        //设置Content的宽为屏幕的宽度
        mContentWidth = mContent.getLayoutParams().width = mScreenWidth;
        //测量Menu
        measureChild(mMenu,widthMeasureSpec,heightMeasureSpec);
        //测量Content
        measureChild(mContent, widthMeasureSpec, heightMeasureSpec);
        //测量自己，自己的宽度为Menu宽度加上Content宽度，高度为屏幕高度
        setMeasuredDimension(mMenuWidth + mContentWidth, mScreenHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //摆放Menu的位置，根据上面图可以确定上下左右的坐标
        mMenu.layout(-mMenuWidth, 0, 0, mScreenHeight);
        //摆放Content的位置
        mContent.layout(0, 0, mScreenWidth, mScreenHeight);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercept = false;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = (int) ev.getX() - mLastX;
                int deltaY = (int) ev.getY() - mLastY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    //横向滑动
                    intercept = true;
                } else {
                    //纵向滑动
                    intercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }
        mLastX = x;
        mLastY = y;

        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                mLastX = (int) event.getX();
                mLastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int currentX = (int) event.getX();
                int currentY = (int) event.getY();
                int deltaX = currentX - mLastX;
                int scrollX = getScrollX() - deltaX;

                Log.i("SlideMenu", "ACTION_MOVE: getScrollX() " + getScrollX() + ", deltaX "+ deltaX + ", scrollX " + scrollX);

                //scrollX范围 0至-mMenuWidth
                if (scrollX >= 0) {
                    //右边界处理
                    scrollTo(0, 0);
                } else if (scrollX <= -mMenuWidth) {
                    //左边界处理
                    scrollTo(-mMenuWidth, 0);
                } else {
                    //非边界情况
                    scrollBy(-deltaX, 0);
                    convertToSlideMode();
                }
                mLastX = currentX;
                mLastY = currentY;
                break;

            case MotionEvent.ACTION_UP:
                if (getScrollX() < -mMenuWidth / 2) {
                    // scrollX超过1/2滚动范围时,打开Menu
                    isOpen = true;
                    mScroller.startScroll(getScrollX(), 0, -mMenuWidth - getScrollX(), 0, 300);
                    invalidate();
                } else {
                    //不足1/2时,关闭Menu
                    isOpen = false;
                    mScroller.startScroll(getScrollX(), 0, -getScrollX(), 0, 300);
                    invalidate();
                }

                break;
        }
        return true;
    }

    /**
     * 将传进来的数转化为dp
     */
    private int convertToDp(Context context , int num) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,num,context.getResources().getDisplayMetrics());
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            convertToSlideMode();
            invalidate();
        }
    }

    private void convertToSlideMode() {
        switch (mSlideMode) {
            case SLIDE_MODE_DEFAULT:
                break;
            case SLIDE_MODE_SLOW:
                slowMode();
                break;
            case SLIDE_MODE_SLOW_SCALE:
                slowScaleMode();
                break;
        }
    }

    private void slowMode() {
        //Menu的translationX,从2/3 * mMenuWidth 到 0
        mMenu.setTranslationX(2*(mMenuWidth+getScrollX())/3);
    }

    private void slowScaleMode() {
        scale = Math.abs((float)getScrollX()) / (float) mMenuWidth;
        //Menu的translationX从1/2Menu到0,scale从0.7到1, alpha从0到1
        mMenu.setTranslationX(mMenuWidth + getScrollX() - (mMenuWidth/2)*(1.0f-scale));
        mMenu.setScaleX(0.7f + 0.3f*scale);
        mMenu.setScaleY(0.7f + 0.3f*scale);
        mMenu.setAlpha(scale);

        //Content的scale从1到0.7
        mContent.setScaleX(1 - 0.3f*scale);
        mContent.setPivotX(0);
        mContent.setScaleY(1.0f - 0.3f * scale);
    }

    /**
     * 点击开关，开闭Menu，如果当前menu已经打开，则关闭，如果当前menu已经关闭，则打开
     */
    public void toggleMenu(){
        if (isOpen){
            closeMenu();
        }else{
            openMenu();
        }
    }

    /**
     * 关闭menu
     */
    private void closeMenu() {
        //也是使用startScroll方法，dx和dy的计算方法一样
        mScroller.startScroll(getScrollX(),0,-getScrollX(),0,500);
        invalidate();
        isOpen = false;
    }

    /**
     * 打开menu
     */
    private void openMenu() {
        mScroller.startScroll(getScrollX(),0,-mMenuWidth-getScrollX(),0,500);
        invalidate();
        isOpen = true;
    }
}
