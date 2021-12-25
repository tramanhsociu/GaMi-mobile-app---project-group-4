package com.example.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.helper.ManagementCard;
import com.example.interfaces.ChangeNumberItemListener;
import com.example.model.Products;
import com.example.onboarding.R;
import com.example.onboarding.ShowDetailActivity;

import java.util.ArrayList;
import java.util.List;


public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.PopularViewHolder>{

    private List<Products> productsList;
    private ManagementCard managementCard;
    private ChangeNumberItemListener changeNumberItemListener;

    public CartListAdapter(Context context, List<Products> productsList,ChangeNumberItemListener changeNumberItemListener) {
        this.productsList = productsList;
        managementCard = new ManagementCard(context);
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.imvthumb.setImageResource(productsList.get(position).getThumb());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(String.valueOf(productsList.get(position).getThumb()),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imvThumb);


        holder.txtFeeEachItem.setText(productsList.get(position).getPrice() +" VND");
        holder.txtName.setText(productsList.get(position).getName());
        holder.txtFeeTotalItem.setText(Math.round(productsList.get(position).getNumberInCard()*productsList.get(position).getPrice())+" VND");
        holder.txtNumberOrder.setText(String.valueOf(productsList.get(position).getNumberInCard()));

        holder.plusItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                managementCard.plusNumberProduct((ArrayList<Products>) productsList, position, new ChangeNumberItemListener(){
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();


                    }
                });
            }
        });
        holder.minusItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                managementCard.MinusNumberProduct((ArrayList<Products>) productsList, position, new ChangeNumberItemListener(){
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public static class PopularViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb , plusItem, minusItem;
        TextView txtFeeEachItem,txtFeeTotalItem, txtName,txtNumberOrder;



        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imvThumb = itemView.findViewById(R.id.imvThumb);
            txtName= itemView.findViewById(R.id.txtName);
            txtFeeEachItem = itemView.findViewById(R.id.txtFeeEachItem);
            txtNumberOrder = itemView.findViewById(R.id.txtNumOder);
            plusItem = itemView.findViewById(R.id.imvPlus);
            minusItem = itemView.findViewById(R.id.imvMinus);
            txtFeeTotalItem = itemView.findViewById(R.id.txtFeeTotalItem);

        }
    }
}

