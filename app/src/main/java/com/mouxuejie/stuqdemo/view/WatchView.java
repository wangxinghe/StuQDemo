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
    private static final int DEFAULT_SIZE = 300;

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
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int radius = Math.min(width, height) / 2;

        //画表盘
        canvas.drawCircle(width / 2, height / 2, radius, mPaint);

        //画时间线
        canvas.drawLine(width / 2, height / 2 - radius / 2, width / 2, height / 2 - radius, mLinePaint);
        for (int i = 0; i < 11; i++) {
            //i == 0 和i == 1时分别暂存Canvas状态,结果不同
//            if (i == 0) {
//                canvas.save();
//            }
            if (i == 1) {
                canvas.save();
            }
            canvas.rotate(30, width / 2, height / 2);
            canvas.drawLine(width / 2, height / 2 - radius / 2, width / 2, height / 2 - radius, mLinePaint);
        }

        //恢复到save暂存时的Canvas状态
        canvas.restore();

        //Canvas再旋转15度
        canvas.rotate(15, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - radius / 2, width / 2, height / 2 - radius, mPaint);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10f);

        mLinePaint = new Paint();
        mLinePaint.setColor(Color.BLUE);
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setStrokeWidth(10f);
    }
}
