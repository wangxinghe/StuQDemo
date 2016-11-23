package com.mouxuejie.stuqdemo.scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mouxuejie.stuqdemo.R;

/**
 * Created by wangxinghe1 on 2016/11/23.
 */

public class FragmentA extends Fragment {
    private ListView mListView;

    public static FragmentA newInstance() {

        Bundle args = new Bundle();

        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_a, container, false);
        initView(contentView);
        return contentView;
    }

    private void initView(View contentView) {
        mListView = (ListView)contentView.findViewById(R.id.list_view);
        mListView.setAdapter(new ListViewAdapter());
    }

    private class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public String getItem(int position) {
            return "Item " + position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListViewAdapter.ViewHolder holder;
            if (convertView == null) {
                holder = new ListViewAdapter.ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, null);
                holder.mTv = (TextView)convertView.findViewById(R.id.item_tv);
                convertView.setTag(holder);
            }
            holder = (ListViewAdapter.ViewHolder) convertView.getTag();
            holder.mTv.setText(getItem(position));

            return convertView;
        }

        private class ViewHolder {
            private TextView mTv;
        }
    }
}
