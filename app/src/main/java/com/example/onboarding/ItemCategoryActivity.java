package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;

import com.example.Adapter.CategoryRCVAdapter;
import com.example.Adapter.DynamicRCVAdapter;
import com.example.model.Category;
import com.example.model.Products;

import java.util.ArrayList;

public class ItemCategoryActivity extends AppCompatActivity {
    RecyclerView rcvCategory, rcvDynamic;
    GridView gvDynamic;

    // horizonal
    CategoryRCVAdapter categoryRCVAdapter;
    ArrayList<Category> list;

   // vertical
    ArrayList<Products> dynamic;
    DynamicRCVAdapter dynamicRCVAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_category);
        linkViews();

        initDataCategory();

        initDynamic(0);


    }

    private void linkViews() {
        rcvCategory = findViewById(R.id.rvcCategory1);
        rcvDynamic = findViewById(R.id.rcvCategory2);


    }

    public void initDynamic(int pos){
        dynamic = new ArrayList<>();
        switch (pos){
            case 0:

                dynamic.add(new Products(R.drawable.dochoi_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",3.5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",4.5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",4.5f,20.000,"đồ chơi",1));

                break;

            case 1:
                dynamic.add(new Products(R.drawable.dochoi_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",3.5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",4.5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",4.5f,20.000,"đồ chơi",1));

                break;
            case 2:
                dynamic.add(new Products(R.drawable.dochoi_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                break;
            case 3:
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",4.5f,20.000,"đồ chơi",1));
                break;
            case 4:
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",3.5f,20.000,"đồ chơi",1));
                break;
            case 5:
                dynamic.add(new Products(R.drawable.dochoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                break;
            case 6:
                dynamic.add(new Products(R.drawable.dochoi_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                break;

        }

            dynamicRCVAdapter = new DynamicRCVAdapter(ItemCategoryActivity.this,dynamic);

        rcvDynamic.setLayoutManager(new LinearLayoutManager(ItemCategoryActivity.this,RecyclerView.VERTICAL,false));

        rcvDynamic.setAdapter(dynamicRCVAdapter);
        dynamicRCVAdapter.notifyDataSetChanged();
    }




    private void initDataCategory() {
        list = new ArrayList<>();
        list.add(new Category(R.drawable.ic_doan,"Đồ ăn"));
        list.add(new Category(R.drawable.ic_thuoc,"Thuốc"));
        list.add(new Category(R.drawable.ic_tamgoi,"Tắm gội"));
        list.add(new Category(R.drawable.ic_dodung,"Đồ dùng"));
        list.add(new Category(R.drawable.ic_dochoi,"Đồ chơi"));
        list.add(new Category(R.drawable.ic_phukien,"Phụ kiện"));



        categoryRCVAdapter = new CategoryRCVAdapter(ItemCategoryActivity.this,list, new CategoryRCVAdapter.OnCategoryClick(){
            @Override
            public void onClick(int pos) {
                initDynamic(pos);
            }
        });
        rcvCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rcvCategory.setAdapter(categoryRCVAdapter);
        categoryRCVAdapter.notifyDataSetChanged();

    }

}