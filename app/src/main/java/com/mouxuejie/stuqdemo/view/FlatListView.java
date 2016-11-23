package com.mouxuejie.stuqdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by wangxinghe1 on 2016/11/23.
 */

public class FlatListView extends ListView {

    public FlatListView(Context context) {
        super(context);
    }

    public FlatListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlatListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
