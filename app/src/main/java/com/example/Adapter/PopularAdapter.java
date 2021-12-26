package com.example.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.model.Products;

import com.example.onboarding.R;
import com.example.onboarding.ShowDetailActivity;

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
    public void onBindViewHolder(@NonNull PopularViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.imvthumb.setImageResource(productsList.get(position).getThumb());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(String.valueOf(productsList.get(position).getThumb()),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imvThumb);


        holder.txtPrice.setText((productsList.get(position).getPrice()+ " VND"));
        holder.txtName.setText(productsList.get(position).getName());
        // sự kiện cho addcart
        holder.btnAddCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",productsList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public static class PopularViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb;
        TextView txtPrice, txtName;
        ImageButton btnAddCart;


        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imvThumb = itemView.findViewById(R.id.imvThumb);
            txtName= itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            btnAddCart = itemView.findViewById(R.id.btnAddCart);
        }
    }
}

