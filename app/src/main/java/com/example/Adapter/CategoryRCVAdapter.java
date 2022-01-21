package com.example.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Category;
import com.example.onboarding.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class CategoryRCVAdapter extends RecyclerView.Adapter<CategoryRCVAdapter.ViewHolder>{

    int selectedItem = 0;

    Context context;
    ArrayList<Category> list;
    OnCategoryClick onCategoryClick;

    public interface OnCategoryClick{
        void onClick(int pos);
    }

    public CategoryRCVAdapter(Context context, ArrayList<Category> list, OnCategoryClick onCategoryClick) {
        this.context = context;
        this.list = list;
        this.onCategoryClick = onCategoryClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_rcv_item,parent,false);
        return new ViewHolder(view) ;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvThumb.setImageResource(list.get(position).getCategoryImage());
        holder.txtName.setText(list.get(position).getCategoryName());
        if(position == selectedItem){
            // đổi màu card được chọn

           holder.cardView.setBackgroundResource(R.drawable.category_rcv_selected_bg);
        }else {

            holder.cardView.setBackgroundResource(R.drawable.category_rcv_bg);
        }




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb;
        TextView txtName;
        MaterialCardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvThumb = itemView.findViewById(R.id.imvThumb);
            txtName = itemView.findViewById(R.id.txtName);

            cardView = itemView.findViewById(R.id.cardView);
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                   selectedItem = getLayoutPosition();
                   notifyDataSetChanged();
                   if (onCategoryClick != null){
                       onCategoryClick.onClick(getLayoutPosition());
                   }
                }
            });
        }


    }
}
