package com.zhiyuan3g.idcardsystemgllery.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class GallaryAdapter extends BaseAdapter {

    List<Integer>list;
    Context context;

    public GallaryAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view=new ImageView(context);
        view.setImageResource(list.get(position));
        int width= Gallery.LayoutParams.WRAP_CONTENT;

        int height=Gallery.LayoutParams.WRAP_CONTENT;

        Gallery.LayoutParams params=new Gallery.LayoutParams(width,height);
        view.setLayoutParams(params);
        return view;
    }
}
