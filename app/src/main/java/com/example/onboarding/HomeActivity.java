package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
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

public class HomeActivity extends AppCompatActivity{

    ViewPager2 viewPager2;
    CircleIndicator3 circleIndicator3;
    List<Banner> banners;

    BannerAdapter bannerAdapter;

    RecyclerView rcvPopular;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        // banner
        initData();
        initAdapter();
        // category
        initDataCategory();
        initAdapterCate();
        //popular
        recyclerViewPopular();
        initDataPopular();
    }

    private void initDataPopular() {
        popular = new ArrayList<>();
        popular.add(new Popular(R.drawable.dochoi_1,"name","20000","200000",20.000));
        popular.add(new Popular(R.drawable.dochoi_1,"name","20000","200000",20.000));
        popularAdapter = new PopularAdapter(HomeActivity.this,popular);
        rcvPopular.setAdapter(popularAdapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvPopular.setLayoutManager(layoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(rcvPopular.getContext(),layoutManager.getOrientation());
        rcvPopular.addItemDecoration(decoration);
    }


    private void initAdapterCate() {
        categoryAdapter = new CategoryAdapter(HomeActivity.this,R.layout.item_category_layout,category);
        gvCategory.setAdapter(categoryAdapter);
    }

    private void initDataCategory() {
        category = new ArrayList<Category>();
        category.add(new Category(R.drawable.food,"Đồ ăn"));
        category.add(new Category(R.drawable.yte,"Thuốc"));
        category.add(new Category(R.drawable.daugoi,"Tắm gội"));
        category.add(new Category(R.drawable.dodung,"Đồ dùng"));
        category.add(new Category(R.drawable.dochoi,"Đồ chơi"));
        category.add(new Category(R.drawable.phukien,"Phụ kiện"));
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
                handler.postDelayed(runnable,1000);
            }
        });
    }
    private List<Banner> initData() {
        List<Banner> list = new ArrayList<>();
        list.add(new Banner(R.drawable.banner));
        list.add(new Banner(R.drawable.bannerhai));
        list.add(new Banner(R.drawable.bannerba));
        return list;
    }

    private void linkViews() {
        viewPager2 = findViewById(R.id.view_page2);
        circleIndicator3 = findViewById(R.id.cricle_indicator);

        gvCategory = findViewById(R.id.gvCategory);

        rcvPopular = findViewById(R.id.rcvPopular);


    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,1000);
    }
}