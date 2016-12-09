package com.mouxuejie.stuqdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mouxuejie.stuqdemo.scroll.AnimActivity;
import com.mouxuejie.stuqdemo.scroll.SmoothScrollActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button canvasBtn = (Button)findViewById(R.id.canvas_btn);
        Button touchEventBtn = (Button)findViewById(R.id.touch_event_btn);
        Button slideMenuBtn = (Button)findViewById(R.id.slide_menu_btn);
        Button scrollBtn = (Button)findViewById(R.id.scroll_btn);
        Button smoothScrollBtn = (Button)findViewById(R.id.smooth_scroll_btn);
        canvasBtn.setOnClickListener(this);
        touchEventBtn.setOnClickListener(this);
        slideMenuBtn.setOnClickListener(this);
        scrollBtn.setOnClickListener(this);
        smoothScrollBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.canvas_btn:
                startActivity(new Intent(MainActivity.this, CanvasActivity.class));
                break;
            case R.id.touch_event_btn:
                startActivity(new Intent(MainActivity.this, TouchEventActivity.class));
                break;
            case R.id.slide_menu_btn:
                startActivity(new Intent(MainActivity.this, SlideMenuActivity.class));
                break;
            case R.id.scroll_btn:
                startActivity(new Intent(MainActivity.this, AnimActivity.class));
                break;
            case R.id.smooth_scroll_btn:
                startActivity(new Intent(MainActivity.this, SmoothScrollActivity.class));
                break;
            default:
                break;
        }
    }
}
