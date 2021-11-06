package com.example.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Category;
import com.example.onboarding.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter{
    Activity context;
    int item_layout;
    List<Category> categoryList;

    public CategoryAdapter(Activity context, int item_layout, List<Category> categoryList) {
        this.context = context;
        this.item_layout = item_layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return categoryList.get(i);
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
            holder.imvThumb =view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);
            view.setTag(holder);

        }else {
            holder = (ViewHolder) view.getTag();
        }
        // biding data
        Category c =categoryList.get(i);
        holder.imvThumb.setImageResource(c.getProductThumb());
        holder.txtName.setText(c.getProductName());
        return view;

    }
    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName;
    }

}
