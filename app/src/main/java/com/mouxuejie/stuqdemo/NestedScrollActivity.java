package com.mouxuejie.stuqdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.mouxuejie.stuqdemo.scroll.Fragment1;
import com.mouxuejie.stuqdemo.scroll.Fragment2;
import com.mouxuejie.stuqdemo.scroll.Fragment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangxinghe1 on 2016/11/23.
 */

public class NestedScrollActivity extends FragmentActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll);

        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)findViewById(R.id.view_pager);

        mTitleList = Arrays.asList("Page1", "Page2", "Page3");
        mFragmentList = new ArrayList<>();
        mFragmentList.add(Fragment1.newInstance());
        mFragmentList.add(Fragment2.newInstance());
        mFragmentList.add(Fragment3.newInstance());

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new OutFragmentPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private class OutFragmentPagerAdapter extends FragmentPagerAdapter {

        public OutFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

        @Override
        public int getCount() {
            return mTitleList.size();
        }
    }
}
