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

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.GridView;

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

import me.relex.circleindicator.CircleIndicator3;

public class HomeActivity extends AppCompatActivity{

    FragmentManager manager;
    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.menu_navigation);



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

    }





}