package com.example.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Products;
import com.example.onboarding.R;

import java.util.List;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder>{
    Context context;
    List<Products> productsList;

    public PopularAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_popular,parent,false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        holder.imvthumb.setImageResource(productsList.get(position).getThumb());
        holder.txtPrice.setText(String.valueOf(productsList.get(position).getPrice()));
        holder.txtName.setText(productsList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public static class PopularViewHolder extends RecyclerView.ViewHolder{
        ImageView imvthumb;
        TextView txtPrice, txtName;


        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imvthumb = itemView.findViewById(R.id.imvThumb);
            txtName= itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}

