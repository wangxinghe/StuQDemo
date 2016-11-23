package com.mouxuejie.stuqdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button canvasBtn = (Button)findViewById(R.id.canvas_btn);
        Button touchEventBtn = (Button)findViewById(R.id.touch_event_btn);
        Button nestedScrollBtn = (Button)findViewById(R.id.nest_scroll_btn);
        canvasBtn.setOnClickListener(this);
        touchEventBtn.setOnClickListener(this);
        nestedScrollBtn.setOnClickListener(this);
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
            case R.id.nest_scroll_btn:
                startActivity(new Intent(MainActivity.this, NestedScrollActivity.class));
                break;
            default:
                break;
        }
    }
}
