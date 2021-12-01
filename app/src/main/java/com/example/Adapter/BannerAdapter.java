package com.example.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.model.Banner;
import com.example.onboarding.R;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder>{
    private List<Banner> ListBanner;

    public BannerAdapter(List<Banner> listBanner) {
        ListBanner = listBanner;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner,parent,false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        Banner banner = ListBanner.get(position);
        if(banner == null){
            return;
        }
        holder.imvBanner.setImageResource(banner.getImvBanner());
    }
    @Override
    public int getItemCount() {
        return ListBanner.size();
    }
    public class BannerViewHolder extends RecyclerView.ViewHolder{
        private ImageView imvBanner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBanner = itemView.findViewById(R.id.imvBanner);
        }
    }
}
