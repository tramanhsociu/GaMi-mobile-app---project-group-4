package com.example.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Section;
import com.example.onboarding.R;

import java.util.ArrayList;
import java.util.List;

public class SectionAdapter extends BaseAdapter {
    Activity context;
    int setting_layout;
    List<Section> listData;

    public SectionAdapter(Activity context, int setting_layout, ArrayList<Section> listData) {
        this.context = context;
        this.setting_layout = setting_layout;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            //link view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(setting_layout, null);
            holder.txtTitle = view.findViewById(R.id.txtTitle);
            holder.imvNext= view.findViewById(R.id.imvNext);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Section s = listData.get(i);
        holder.imvNext.setImageResource(s.getSettingNext());
        holder.txtTitle.setText(String.valueOf(s.getSettingTitle()));

        return view;
    }
    private static class ViewHolder{
        ImageView imvNext;
        TextView txtTitle;
    }
}
