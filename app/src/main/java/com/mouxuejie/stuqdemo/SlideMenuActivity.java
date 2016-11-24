package com.mouxuejie.stuqdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mouxuejie.stuqdemo.slide.ContentAdapter;
import com.mouxuejie.stuqdemo.slide.ContentItem;
import com.mouxuejie.stuqdemo.slide.MenuAdapter;
import com.mouxuejie.stuqdemo.slide.MenuItem;
import com.mouxuejie.stuqdemo.slide.SlideMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxinghe1 on 2016/11/24.
 */

public class SlideMenuActivity extends Activity {
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private SlideMenu mSlidingMenu;
    private ListView mContentListView;
    private ListView mMenuListView;
    private ImageView mMenuToggle;
    private MenuAdapter mMenuAdapter;
    private ContentAdapter mContentAdapter;
    private List<MenuItem> mMenuDatas;
    private List<ContentItem> mContentDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_slide_menu);
        mSlidingMenu = (SlideMenu) findViewById(R.id.slidingmenu);
        mMenu = (ViewGroup) findViewById(R.id.menu);
        mContent = (ViewGroup) findViewById(R.id.content);

        mMenuListView = (ListView) mMenu.findViewById(R.id.menu_listview);
        initMenuDatas();
        mMenuAdapter = new MenuAdapter(getApplicationContext(),mMenuDatas);
        mMenuListView.setAdapter(mMenuAdapter);
        mMenuListView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SlideMenuActivity.this, "Clicked 菜单" + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });

        mContentListView = (ListView) mContent.findViewById(R.id.content_listview);
        mMenuToggle = (ImageView) mContent.findViewById(R.id.menu_toggle);
        initContentDatas();
        mContentAdapter = new ContentAdapter(getApplicationContext(),mContentDatas);
        mContentListView.setAdapter(mContentAdapter);
        mContentListView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mContentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SlideMenuActivity.this,"Clicked Content - "+(position+1),Toast.LENGTH_SHORT).show();
            }
        });

        mMenuToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlidingMenu.toggleMenu();
            }
        });
    }

    private void initMenuDatas() {
        mMenuDatas = new ArrayList<>();
        mMenuDatas.add(new MenuItem(R.mipmap.menu_1 , "菜单1"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_2 , "菜单2"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_3, "菜单3"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_4, "菜单4"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_5, "菜单5"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_6 , "菜单6"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_7 , "菜单7"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_8, "菜单8"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_9 , "菜单9"));
        mMenuDatas.add(new MenuItem(R.mipmap.menu_10, "菜单10"));
    }

    private void initContentDatas() {
        mContentDatas = new ArrayList<>();
        mContentDatas.add(new ContentItem(R.mipmap.content_1 , "Content - 1"));
        mContentDatas.add(new ContentItem(R.mipmap.content_2 , "Content - 2"));
        mContentDatas.add(new ContentItem(R.mipmap.content_3 , "Content - 3"));
        mContentDatas.add(new ContentItem(R.mipmap.content_4 , "Content - 4"));
        mContentDatas.add(new ContentItem(R.mipmap.content_5 , "Content - 5"));
        mContentDatas.add(new ContentItem(R.mipmap.content_6 , "Content - 6"));
        mContentDatas.add(new ContentItem(R.mipmap.content_7 , "Content - 7"));
        mContentDatas.add(new ContentItem(R.mipmap.content_8 , "Content - 8"));
        mContentDatas.add(new ContentItem(R.mipmap.content_9 , "Content - 9"));
        mContentDatas.add(new ContentItem(R.mipmap.content_10 , "Content - 10"));
        mContentDatas.add(new ContentItem(R.mipmap.content_11 , "Content - 11"));
        mContentDatas.add(new ContentItem(R.mipmap.content_12 , "Content - 12"));
        mContentDatas.add(new ContentItem(R.mipmap.content_13 , "Content - 13"));
    }

}
