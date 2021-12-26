package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.InfoOrder;
import com.example.model.Sale;
import com.example.onboarding.R;

import java.util.ArrayList;

public class InfoOrderAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<InfoOrder> infoOrders;

    public InfoOrderAdapter(Context context, int item_layout, ArrayList<InfoOrder> infoOrders) {
        this.context = context;
        this.item_layout = item_layout;
        this.infoOrders = infoOrders;
    }

    @Override
    public int getCount() {
        return infoOrders.size();
    }

    @Override
    public Object getItem(int i) {
        return infoOrders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            holder.orderThumb = view.findViewById(R.id.imvOrder);
            holder.orderName = view.findViewById(R.id.txtNameInfo);
            holder.orderContent = view.findViewById(R.id.txtContentInfo);
            holder.orderTime = view.findViewById(R.id.txtTime);
            holder.showInfo = view.findViewById(R.id.btnShowInfo);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        InfoOrder o = infoOrders.get(i);
        holder.orderThumb.setImageResource(o.getOrderThumb());
        holder.orderName.setText(o.getOrderName());
        holder.orderContent.setText(o.getOrderContent());
        holder.orderTime.setText(o.getOrderTime());
        holder.showInfo.setImageResource(o.getShowInfo());
        return view;
    }

    public static class ViewHolder {
        ImageView orderThumb, showInfo;
        TextView orderName,orderContent, orderTime;
    }
}
