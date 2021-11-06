package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Blog;
import com.example.onboarding.R;

import java.util.List;

public class BlogAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Blog> blogList;

    public BlogAdapter(Context context, int layout, List<Blog> blogList) {
        this.context = context;
        this.layout = layout;
        this.blogList = blogList;
    }

    @Override
    public int getCount() {
        return blogList.size();
    }

    @Override
    public Object getItem(int i) {
        return blogList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            holder=new ViewHolder();
            view =inflater.inflate(layout,null);
            holder.imvProduct=view.findViewById(R.id.imvImage);
            holder.txtContent=view.findViewById(R.id.txtContent);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();
        }

        Blog b=blogList.get(i);
        holder.txtContent.setText(b.getContent());
        holder.imvProduct.setImageResource(b.getImage());

        return view;
    }
    private static class ViewHolder {
        TextView txtContent;
        ImageView imvProduct;

    }
}
