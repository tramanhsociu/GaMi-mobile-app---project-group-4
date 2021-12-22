package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.Adapter.CategoryRCVAdapter;
import com.example.Adapter.DynamicRCVAdapter;
import com.example.model.Category;
import com.example.model.Products;

import java.util.ArrayList;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class ItemCategoryActivity extends AppCompatActivity {
    RecyclerView rcvCategory, rcvDynamic;

    // horizonal
    CategoryRCVAdapter categoryRCVAdapter;
    ArrayList<Category> list;

   // vertical
    ArrayList<Products> dynamic;
    DynamicRCVAdapter dynamicRCVAdapter;

    ImageView btnChat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_category);
        linkViews();

        initDataCategory();

        initDynamic(0);


        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crispIntent = new Intent(ItemCategoryActivity.this, ChatActivity.class);
                startActivity(crispIntent);
            }
        });


    }

    private void linkViews() {
        rcvCategory = findViewById(R.id.rvcCategory1);
        rcvDynamic = findViewById(R.id.rcvCategory2);
        btnChat = findViewById(R.id.btnChat);
        //chat
        Crisp.configure(getApplicationContext(), "1b4d03b2-db60-4da9-b658-bcf6eceac6f1");


    }

    public void initDynamic(int pos){
        dynamic = new ArrayList<>();
        switch (pos){
            case 0:
                dynamic.add(new Products(R.drawable.doan_1,"Food Natural","Đồ ăn dành cho chó và mèo ",3.5f,20.000,"đồ ăn",1));
                dynamic.add(new Products(R.drawable.doan_2,"Food Natural","Đồ chơi dành cho chó và mèo ",4.5f,40.000,"đồ ăn",1));
                dynamic.add(new Products(R.drawable.doan_3,"Food Natural","Đồ chơi dành cho chó và mèo ",5f,70.000,"đồ ăn",1));
                dynamic.add(new Products(R.drawable.doan_4,"Food Natural","Đồ chơi dành cho chó và mèo ",4.5f,90.000,"đồ ăn",1));
                dynamic.add(new Products(R.drawable.doan_6,"Food Natural","Đồ ăn dành cho chó và mèo ",5f,20.000,"đồ ăn",1));
                dynamic.add(new Products(R.drawable.doan_9,"Food Natural","Đồ chơi dành cho chó và mèo ",5f,70.000,"đồ ăn",1));
                dynamic.add(new Products(R.drawable.doan_10,"Food Natural","Đồ chơi dành cho chó và mèo ",5f,90.000,"đồ ăn",1));

                break;
            case 1:
                dynamic.add(new Products(R.drawable.thuoc_6,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_5,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_6,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_5,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));
                dynamic.add(new Products(R.drawable.thuoc_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"thuốc",1));

                break;
            case 2:
                dynamic.add(new Products(R.drawable.tamgoi_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_5,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));
                dynamic.add(new Products(R.drawable.tamgoi_5,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"tắm gội",1));

                break;
            case 3:
                dynamic.add(new Products(R.drawable.dodung_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_5,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));
                dynamic.add(new Products(R.drawable.dodung_5,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ dùng",1));


                break;

            case 4:
                dynamic.add(new Products(R.drawable.dochoi_6,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_7,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_8,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_9,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_10,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_6,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_7,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_8,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_9,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));
                dynamic.add(new Products(R.drawable.dochoi_10,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"đồ chơi",1));

                break;
            case 5:
                dynamic.add(new Products(R.drawable.phukien_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
                dynamic.add(new Products(R.drawable.phukien_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
                dynamic.add(new Products(R.drawable.phukien_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
                dynamic.add(new Products(R.drawable.phukien_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
                dynamic.add(new Products(R.drawable.phukien_1,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
                dynamic.add(new Products(R.drawable.phukien_2,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
                dynamic.add(new Products(R.drawable.phukien_3,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
                dynamic.add(new Products(R.drawable.phukien_4,"name","Đồ chơi dành cho chó và mèo ",5f,20.000,"phụ kiện",1));
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