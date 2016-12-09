package com.mouxuejie.stuqdemo.scroll;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mouxuejie.stuqdemo.R;

/**
 * Created by wangxinghe on 9/12/2016.
 */

public class SmoothScrollActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_smooth_scroll);
        LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smoothScroll(v);
            }
        });
    }

    private void smoothScroll(final View v) {
        final int startY = 0;
        final int deltaY = -400;
        final ValueAnimator animator = ValueAnimator.ofInt(0, 1);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animator.getAnimatedFraction();
                //改变的是LinearLayout的内容的位置
                v.scrollTo(startY + (int)(deltaY * fraction), 0);
            }
        });
        animator.start();
    }

}
