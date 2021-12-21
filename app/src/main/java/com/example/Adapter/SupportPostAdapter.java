package com.example.Adapter;

import static java.util.Collections.addAll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.model.SupportPost;
import com.example.onboarding.R;

import java.util.ArrayList;
import java.util.List;

public class SupportPostAdapter extends BaseAdapter implements Filterable {
    private Context context;
    int custom_list_setting_support;
    List<SupportPost> posts;
    List<SupportPost> postListFilter;

    public SupportPostAdapter(Context context, int custom_list_setting_support, List<SupportPost> posts) {
        this.context = context;
        this.custom_list_setting_support = custom_list_setting_support;
        this.postListFilter = posts;
        this.posts = posts;


    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(custom_list_setting_support,null);
            holder.text=view.findViewById(R.id.text);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        SupportPost s = posts.get(i);
        holder.text.setText(String.valueOf(s.getTitlePost()));
        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults =new FilterResults();
                if(charSequence == null | charSequence.length() == 0){
                    filterResults.count = postListFilter.size();
                    filterResults.values = postListFilter;
                }else{
                    String searchChr = charSequence.toString().toLowerCase();
                    List<SupportPost> resultData = new ArrayList<>();

                    for(SupportPost supportPost : postListFilter){
                        if(supportPost.getTitlePost().toLowerCase().contains(searchChr)){
                            resultData.add(supportPost);
                        }
                    }
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                posts = (List<SupportPost>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    private static class ViewHolder{
        TextView text;
    }

}
