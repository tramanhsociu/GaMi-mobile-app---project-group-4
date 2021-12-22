package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Products;
import com.example.onboarding.R;

import java.util.ArrayList;

public class DynamicRCVAdapter extends RecyclerView.Adapter<DynamicRCVAdapter.ViewHolder>{
    int selectedItem = 0;

    Context context;
    ArrayList<Products> list;


    public DynamicRCVAdapter(Context context, ArrayList<Products> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public DynamicRCVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rcv_item,parent,false);
        return new DynamicRCVAdapter.ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRCVAdapter.ViewHolder holder, int position) {

        holder.imvThumb.setImageResource(list.get(position).getThumb());
        holder.txtName.setText(list.get(position).getName());
        holder.txtPrice.setText((list.get(position).getPrice()+ " VND"));
        holder.ratingBar.setRating(list.get(position).getRate());

        if (selectedItem == position){
            holder.imvThumb.animate().scaleX(1.2f);
            holder.imvThumb.animate().scaleY(1.2f);
        }
        else {
            holder.imvThumb.animate().scaleX(1f);
            holder.imvThumb.animate().scaleY(1f);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtPrice;
        ImageView imvThumb;
        RatingBar ratingBar;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            imvThumb= itemView.findViewById(R.id.imvThumb);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            cardView = itemView.findViewById(R.id.cardView);
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    selectedItem = getLayoutPosition();
                    notifyDataSetChanged();
                }
            });

        }
    }
}
