package com.example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.model.Blog;
import com.example.onboarding.BlogFragment;
import com.example.onboarding.CommentBlog;
import com.example.onboarding.MainActivity;
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
            holder.imvReact=view.findViewById(R.id.imv_ic_tim);
            holder.imvCmt=view.findViewById(R.id.imv_ic_cmt);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();

        }

        Blog b=blogList.get(i);
        holder.txtContent.setText(b.getContent());
        holder.imvProduct.setImageResource(b.getImage());

        holder.imvReact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imvReact=view.findViewById(R.id.imv_ic_tim);
                imvReact.setSelected(!imvReact.isSelected());
                if(imvReact.isSelected()){
                    imvReact.setImageResource(R.drawable.ic_like);
                }else {
                    imvReact.setImageResource(R.drawable.ic_unlike);
                }
            }
        });

        holder.imvCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent= new Intent(view.getContext(),CommentBlog.class);
                    view.getContext().startActivity(intent);

            }
        });
        return view;
    }

    public static class ViewHolder {
        TextView txtContent;
        ImageView imvProduct;
        ImageView imvReact, imvCmt;

    }
}
