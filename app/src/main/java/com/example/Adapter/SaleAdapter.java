package com.example.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Khuyenmai;
import com.example.onboarding.R;

import java.util.List;

public class SaleAdapter extends BaseAdapter {

    Activity context;
    int item_layout;
    List<Khuyenmai> salelist;

    public SaleAdapter(Activity context, int item_layout, List<Khuyenmai> salelist) {
        this.context = context;
        this.item_layout = item_layout;
        this.salelist = salelist;
    }

    @Override
    public int getCount() {
        return salelist.size();
    }

    @Override
    public Object getItem(int i) {
        return salelist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){

            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            holder.imvThumb = view.findViewById(R.id.imvSaleitem);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtContent = view.findViewById(R.id.txtContent);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        Khuyenmai k= salelist.get(i);
        holder.imvThumb.setImageResource(k.getSaleThumb());
        holder.txtName.setText(k.getSaleName());
        holder.txtContent.setText(k.getSaleContent());
        return view;
    }

    public static class ViewHolder {
        ImageView imvThumb;
        TextView txtName,txtContent;
    }
}
