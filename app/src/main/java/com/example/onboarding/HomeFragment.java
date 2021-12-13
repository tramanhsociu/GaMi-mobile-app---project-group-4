package com.example.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.Adapter.BannerAdapter;
import com.example.Adapter.CategoryAdapter;
import com.example.Adapter.PopularAdapter;
import com.example.model.Banner;
import com.example.model.Category;
import com.example.model.Popular;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;


public class HomeFragment extends Fragment{
    ViewPager2 viewPager2;
    CircleIndicator3 circleIndicator3;
    ArrayList<Banner> banners;

    BannerAdapter bannerAdapter;

    RecyclerView rcvPopular,rcvPopular2;
    PopularAdapter popularAdapter;
    ArrayList<Popular> popular;


    GridView gvCategory;
    ArrayList<Category> category;
    CategoryAdapter categoryAdapter;
    Handler handler = new Handler();


    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() == banners.size() - 1) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        }
    };




    private void initDataPopular() {
        popular = new ArrayList<>();
        popular.add(new Popular(R.drawable.dochoi_1,"name","Đồ chơi dành cho chó và mèo ","200000",20.000));
        popular.add(new Popular(R.drawable.dochoi_2,"name","20000","30000",40.000));
        popular.add(new Popular(R.drawable.dochoi_3,"name","20000","200000",20.000));
        popular.add(new Popular(R.drawable.dochoi_4,"name","20000","200000",30.000));
        popular.add(new Popular(R.drawable.dochoi_1,"name","20000","200000",50.000));
        popularAdapter = new PopularAdapter(getContext(),popular);
        rcvPopular.setAdapter(popularAdapter);
        rcvPopular2.setAdapter(popularAdapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcvPopular.setLayoutManager(layoutManager);
    }

    private void initAdapterCate() {
        categoryAdapter = new CategoryAdapter(getContext(),R.layout.item_category_layout,initDataCategory());
        gvCategory.setAdapter(categoryAdapter);
    }

    private ArrayList<Category> initDataCategory() {
        category = new ArrayList<Category>();
        category.add(new Category(R.drawable.ic_doan,"Đồ ăn"));
        category.add(new Category(R.drawable.yte,"Thuốc"));
        category.add(new Category(R.drawable.daugoi,"Tắm gội"));
        category.add(new Category(R.drawable.dodung,"Đồ dùng"));
        category.add(new Category(R.drawable.dochoi,"Đồ chơi"));
        category.add(new Category(R.drawable.phukien,"Phụ kiện"));
        return category;
    }

    private void initAdapter() {
        banners = initData();
        bannerAdapter = new BannerAdapter(banners);
        viewPager2.setAdapter(bannerAdapter);
        circleIndicator3.setViewPager(viewPager2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,3000);
            }
        });
    }

    private  ArrayList<Banner> initData() {
        banners = new ArrayList<Banner>();
        banners.add(new com.example.model.Banner(R.drawable.banner_1));
        banners.add(new com.example.model.Banner(R.drawable.banner_2));
        banners.add(new com.example.model.Banner(R.drawable.banner_3));
        banners.add(new com.example.model.Banner(R.drawable.banner_4));
        banners.add(new com.example.model.Banner(R.drawable.banner_6));
        return banners;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager2 = view.findViewById(R.id.view_page2);
        circleIndicator3 = view.findViewById(R.id.cricle_indicator);

        gvCategory = view.findViewById(R.id.gvCategory);

        rcvPopular = view.findViewById(R.id.rcvPopular);
        rcvPopular2 = view.findViewById(R.id.rcvPopular2);
        // banner
        initData();
        initAdapter();
//        // category
        initDataCategory();
        initAdapterCate();
        //popular
        recyclerViewPopular();
        initDataPopular();


        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,3000);
    }
}