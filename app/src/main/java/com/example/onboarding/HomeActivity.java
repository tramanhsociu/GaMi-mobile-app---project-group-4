package com.example.onboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.Adapter.BannerAdapter;
import com.example.Adapter.CategoryAdapter;
import com.example.Adapter.PopularAdapter;
import com.example.model.Banner;
import com.example.model.Category;
import com.example.model.Popular;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;
import me.relex.circleindicator.CircleIndicator3;

public class HomeActivity extends AppCompatActivity{

    FragmentManager manager;
    BottomNavigationView navigationView;
    ImageView btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.menu_navigation);
        btnChat = findViewById(R.id.btnChat);
        //chat
        Crisp.configure(getApplicationContext(), "e4983e6a-06f0-42ca-b683-b7723850abc0");

       getSupportFragmentManager().beginTransaction()
        .replace(R.id.layout_container,new HomeFragment()).commit();
       navigationView.setSelectedItemId(R.id.menu_trangchu);
       navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment fragment = null;
               switch (item.getItemId()){
                   case R.id.menu_trangchu:
                       fragment = new HomeFragment();
                       break;
                   case R.id.menu_blog:
                       fragment = new BlogFragment();
                       break;
                   case R.id.menu_toi:
                       fragment = new ProfileFragment();
                       break;
                   case R.id.menu_noti:
                       fragment = new NotiFragment();
                       break;


               }
               getSupportFragmentManager().beginTransaction().replace(R.id.layout_container,fragment).commit();
               return true;
           }
       });
       //nút chat
       btnChat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent crispIntent = new Intent(HomeActivity.this, ChatActivity.class);
               startActivity(crispIntent);
           }
       });

    }





}