package com.mouxuejie.stuqdemo.scroll;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.mouxuejie.stuqdemo.R;

/**
 * Created by wangxinghe on 9/12/2016.
 */

public class AnimActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_scroll);

        final Button animationButton = (Button)findViewById(R.id.animation_btn);
        animationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnimActivity.this, "animation oops!", Toast.LENGTH_SHORT).show();
                animationButton.startAnimation(AnimationUtils.loadAnimation(AnimActivity.this, R.anim.translate_anim));
            }
        });

        final Button animatorButton = (Button)findViewById(R.id.animator_btn);
        animatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnimActivity.this, "animator oops!", Toast.LENGTH_SHORT).show();
                ObjectAnimator animator = ObjectAnimator.ofFloat(animatorButton, "translationY", 0, 1000);
                animator.setDuration(100);
                animator.start();
            }
        });

        final Button lpButton = (Button)findViewById(R.id.lp_btn);
        lpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //case 改变布局属性
                Toast.makeText(AnimActivity.this, "lp oops!", Toast.LENGTH_SHORT).show();
                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) lpButton.getLayoutParams();
                lp.topMargin = 500;
                lpButton.setLayoutParams(lp);
            }
        });
    }

}
