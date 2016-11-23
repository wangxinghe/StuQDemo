package com.mouxuejie.stuqdemo.scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mouxuejie.stuqdemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangxinghe1 on 2016/11/23.
 */

public class Fragment1 extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    public static Fragment1 newInstance() {

        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_1, container, false);
        initView(contentView);
        return contentView;
    }

    private void initView(View contentView) {
        mTabLayout = (TabLayout)contentView.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)contentView.findViewById(R.id.view_pager);

        mTitleList = Arrays.asList("PageA", "PageB", "PageC");
        mFragmentList = new ArrayList<>();
        mFragmentList.add(FragmentA.newInstance());
        mFragmentList.add(FragmentB.newInstance());
        mFragmentList.add(FragmentC.newInstance());

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new InnerFragmentPagerAdapter(getChildFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private class InnerFragmentPagerAdapter extends FragmentPagerAdapter {

        public InnerFragmentPagerAdapter(FragmentManager fm) {
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
