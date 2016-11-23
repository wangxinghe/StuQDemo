package com.mouxuejie.stuqdemo.scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mouxuejie.stuqdemo.R;

/**
 * Created by wangxinghe1 on 2016/11/23.
 */

public class FragmentC extends Fragment {

    public static FragmentC newInstance() {

        Bundle args = new Bundle();

        FragmentC fragment = new FragmentC();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_c, container, false);
        return contentView;
    }
}
