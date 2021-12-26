package com.example.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.PayMethod;
import com.example.onboarding.R;

import java.util.List;

public class PayMethodAdapter extends BaseAdapter {
    Activity context;
    int item_pay_method;
    List<PayMethod> payMethods;

    public PayMethodAdapter(Activity context, int item_pay_method, List<PayMethod> payMethods) {
        this.context = context;
        this.item_pay_method = item_pay_method;
        this.payMethods = payMethods;
    }


    @Override
    public int getCount() {
        return payMethods.size();
    }

    @Override
    public Object getItem(int i) {
        return payMethods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(item_pay_method,null);
            holder.imvThumb=view.findViewById(R.id.imvThumb);
            holder.imvPayArrow=view.findViewById(R.id.imvPayArrow);
            holder.txtPayTitle=view.findViewById(R.id.txtPayTitle);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }
        PayMethod p = payMethods.get(i);
        holder.imvThumb.setImageResource(p.getPayThumb());
        holder.imvPayArrow.setImageResource(p.getPayArrow());
        holder.txtPayTitle.setText(String.valueOf(p.getPayTitle()));
        return view;
    }
    private static class ViewHolder{
        ImageView imvThumb, imvPayArrow;
        TextView txtPayTitle;
    }
}
