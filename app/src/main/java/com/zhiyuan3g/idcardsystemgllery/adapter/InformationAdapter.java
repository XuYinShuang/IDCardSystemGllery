package com.zhiyuan3g.idcardsystemgllery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyuan3g.idcardsystemgllery.R;
import com.zhiyuan3g.idcardsystemgllery.entity.Information;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class InformationAdapter extends BaseAdapter {

    List<Information> informations;
    Context context;

    public InformationAdapter(List<Information> informations, Context context) {
        this.informations = informations;
        this.context = context;
    }

    @Override
    public int getCount() {
        return informations.size();
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

        Holder holder = new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_information, null);
            holder.address = (TextView) convertView.findViewById(R.id.txtAddress);
            holder.shenfen = (TextView) convertView.findViewById(R.id.txtNumber);
            holder.name = (TextView) convertView.findViewById(R.id.txtName);
            holder.sex = (TextView) convertView.findViewById(R.id.txtSex);
            holder.imageView= (ImageView) convertView.findViewById(R.id.image);
            holder.country = (TextView) convertView.findViewById(R.id.txtCountry);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Information information = informations.get(position);
        holder.address.setText("地址：" + information.getAddress());
        holder.shenfen.setText("身份证：" + information.getShenfen());
        holder.name.setText("姓名：" + information.getName());
        holder.sex.setText("性别：" + information.getSex());
        holder.imageView.setImageResource(information.getIndex());
        holder.country.setText("民族：" + information.getCountry());
        return convertView;
    }

    class Holder {
        TextView name, shenfen, address, sex, country;
        ImageView imageView;
    }
}
