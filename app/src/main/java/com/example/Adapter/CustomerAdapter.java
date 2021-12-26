package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.model.Customer;
import com.example.onboarding.R;

import java.util.ArrayList;

public class CustomerAdapter extends BaseAdapter {

    Context context;
    int item_layout;
    ArrayList<Customer> customers;

    public CustomerAdapter(Context context, int item_layout, ArrayList<Customer> customers) {
        this.context = context;
        this.item_layout = item_layout;
        this.customers = customers;
    }

    @Override
    public int getCount() {
        return customers.size();
    }

    @Override
    public Object getItem(int i) {
        return customers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder= null;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            holder = new ViewHolder();
            view = inflater.inflate(item_layout, null);
            holder.imvAvatar= view.findViewById(R.id.imvAvatar);
            holder.edtName =view.findViewById(R.id.edtName);
            holder.spinner_gioitinh =view.findViewById(R.id.spiner_gioitinh);
            holder.edtNumberPhone =view.findViewById(R.id.edtNumberPhone);
            holder.edtAddress =view.findViewById(R.id.edtAddress);
            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }
        //Binding data
        Customer s= customers.get(i);
        holder.imvAvatar.setImageResource(s.getCustomerAvatar());
        holder.edtName.setText(s.getCustomerName());
        holder.spinner_gioitinh.setSelected(s.getCustomerGender());
        return view;
    }
    public static  class ViewHolder{
        ImageView imvAvatar;
        EditText edtName, edtNumberPhone, edtAddress;
        Spinner spinner_gioitinh;
    }
}
