package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Comment;
import com.example.onboarding.R;

import java.util.List;

public class CommentAdapter extends BaseAdapter {

    private Context context;
    private int item_layout;
    private List<Comment> comment;

    public CommentAdapter(Context context, int item_layout, List<Comment> comment) {
        this.context = context;
        this.item_layout = item_layout;
        this.comment = comment;
    }

    @Override
    public int getCount() {
        return comment.size();
    }

    @Override
    public Object getItem(int i) {
        return comment.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view==null){
            holder= new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(item_layout,null);
            holder.txtCmt=view.findViewById(R.id.txtCmt);
            holder.txtName=view.findViewById(R.id.txtName);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }

        Comment c=comment.get(i);
        holder.txtCmt.setText(c.getCmt());
        holder.txtName.setText(c.getName());
        return view;
    }

    public static class ViewHolder{

        TextView txtCmt,txtName;


    }
}
