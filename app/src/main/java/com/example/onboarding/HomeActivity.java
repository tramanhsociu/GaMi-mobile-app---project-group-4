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
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Adapter.BannerAdapter;
import com.example.Adapter.CategoryAdapter;
import com.example.Adapter.PopularAdapter;
import com.example.model.Banner;
import com.example.model.Category;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;
import me.relex.circleindicator.CircleIndicator3;

public class HomeActivity extends AppCompatActivity{

    FragmentManager manager;
    BottomNavigationView navigationView;
    ImageButton btnChat, btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.menu_navigation);
        btnChat = findViewById(R.id.btnChat);
        btnCart = findViewById(R.id.btnCart);

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
       //nút giỏ
       btnCart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent( HomeActivity.this, CartActivity.class);
               startActivity(intent);
           }
       });

        //showcase

        new TapTargetSequence(this).targets(
                TapTarget.forView(findViewById(R.id.menu_trangchu),"Trang chủ","Bạn mua sắm ở đây nè")
                        .outerCircleColor(R.color.gami2)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(18)
                        .titleTextColor(R.color.white)
                        .descriptionTextColor(R.color.white)
                        .descriptionTextSize(16)
                        .textColor(R.color.white)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60),
                TapTarget.forView(findViewById(R.id.menu_blog),"Bài viết","Nơi GaMi đăng tải các bài viết bổ ích cho bạn")
                        .outerCircleColor(R.color.gami2)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(18)
                        .titleTextColor(R.color.white)
                        .descriptionTextColor(R.color.white)
                        .descriptionTextSize(16)
                        .textColor(R.color.white)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60),
                TapTarget.forView(findViewById(R.id.menu_noti),"Thông báo","Chúng mình cập nhật sớm nhất cho bạn")
                        .outerCircleColor(R.color.gami2)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(18)
                        .titleTextColor(R.color.white)
                        .descriptionTextColor(R.color.white)
                        .descriptionTextSize(16)
                        .textColor(R.color.white)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60),
                TapTarget.forView(findViewById(R.id.menu_toi),"Tôi","Nơi lưu giữ thông tin của bạn hê hê")
                        .outerCircleColor(R.color.gami2)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(18)
                        .titleTextColor(R.color.white)
                        .descriptionTextColor(R.color.white)
                        .descriptionTextSize(16)
                        .textColor(R.color.white)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60),
                TapTarget.forView(btnCart,"Giỏ hàng", "Bỏ vào đây món đồ bạn muốn mua")
                        .outerCircleColor(R.color.gami2)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(18)
                        .titleTextColor(R.color.white)
                        .descriptionTextColor(R.color.white)
                        .descriptionTextSize(16)
                        .textColor(R.color.white)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60),
                TapTarget.forView(btnChat,"Trò chuyện với GaMi", "Trò chuyện trực tiếp cùng đội ngũ siêu cute")
                        .outerCircleColor(R.color.gami2)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(18)
                        .titleTextColor(R.color.white)
                        .descriptionTextColor(R.color.white)
                        .descriptionTextSize(16)
                        .textColor(R.color.white)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60)).listener(new TapTargetSequence.Listener() {
            @Override
            public void onSequenceFinish() {
                Toast.makeText(HomeActivity.this, "Hướng dẫn hoàn tất", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
                Toast.makeText(HomeActivity.this, "Tuyệt!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSequenceCanceled(TapTarget lastTarget) {

            }
        }).start();


    }





}