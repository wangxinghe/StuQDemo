package com.mouxuejie.stuqdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wangxinghe on 20/11/2016.
 */

public class WatchView extends View {
    private static final int DEFAULT_SIZE = 1000;

    private Paint mPaint;
    private Paint mLinePaint;

    public WatchView(Context context) {
        super(context);
        initPaint();
    }

    public WatchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public WatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //处理LayoutParams为wrap_content的情况,因为lp为wrap_content对应的specMode为相当于
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_SIZE, DEFAULT_SIZE);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_SIZE, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, DEFAULT_SIZE);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = getMeasuredWidth() - paddingLeft - paddingRight;
        int height = getMeasuredHeight() - paddingTop - paddingBottom;

        //中心坐标,半径
        int radius = Math.min(width, height) / 2;
        int cx = width / 2 + paddingLeft;
        int cy = height / 2 + paddingTop;

        //画表盘
        canvas.drawCircle(cx, cy, radius, mPaint);

        //画时间线
        canvas.drawLine(cx, cy - radius / 2, cx, cy - radius, mLinePaint);
        for (int i = 0; i < 11; i++) {
            //i == 0 和i == 1时分别暂存Canvas状态,结果不同
//            if (i == 0) {
//                canvas.save();
//            }
            if (i == 1) {
                canvas.save();
            }
            canvas.rotate(30, cx, cy);
            canvas.drawLine(cx, cy - radius / 2, cx, cy - radius, mLinePaint);
        }

        //恢复到save暂存时的Canvas状态
        canvas.restore();

        //Canvas再旋转15度
        canvas.rotate(15, cx, cy);
        canvas.drawLine(cx, cy - radius / 2, cx, cy - radius, mPaint);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4f);

        mLinePaint = new Paint();
        mLinePaint.setColor(Color.BLUE);
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setStrokeWidth(4f);
    }
}
