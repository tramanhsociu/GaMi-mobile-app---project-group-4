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
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.Adapter.BannerAdapter;
import com.example.Adapter.CategoryAdapter;
import com.example.Adapter.PopularAdapter;
import com.example.helper.ManagementCard;
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
    ImageButton btnChat;
    ImageView btnCart;
    TextView txtBadge;
    private ManagementCard managementCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        managementCard = new ManagementCard(this);
        navigationView = findViewById(R.id.menu_navigation);
        btnChat = findViewById(R.id.btnChat);
        btnCart = findViewById(R.id.btnCart);
        txtBadge = findViewById(R.id.txtBadgeCart);
        txtBadge.setText(String.valueOf(managementCard.getCount()));


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
       //n??t chat
       btnChat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent crispIntent = new Intent(HomeActivity.this, ChatActivity.class);
               startActivity(crispIntent);
           }
       });
       //n??t gi???
       btnCart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent( HomeActivity.this, CartActivity.class);
               startActivity(intent);
           }
       });

        //showcase for once
        SharedPreferences prefs=getSharedPreferences("prefs",MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);

        if(firstStart){
            tapTartget();
        }

    }
        private void tapTartget (){
            new TapTargetSequence(this).targets(
                    TapTarget.forView(findViewById(R.id.menu_trangchu),"Trang ch???","B???n mua s???m ??? ????y n??")
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
                    TapTarget.forView(findViewById(R.id.menu_blog),"B??i vi???t","N??i GaMi ????ng t???i c??c b??i vi???t b??? ??ch cho b???n")
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
                    TapTarget.forView(findViewById(R.id.menu_noti),"Th??ng b??o","Ch??ng m??nh c???p nh???t s???m nh???t cho b???n")
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
                    TapTarget.forView(findViewById(R.id.menu_toi),"T??i","N??i l??u gi??? th??ng tin c???a b???n h?? h??")
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
                    TapTarget.forView(btnCart,"Gi??? h??ng", "B??? v??o ????y m??n ????? b???n mu???n mua")
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
                    TapTarget.forView(btnChat,"Tr?? chuy???n v???i GaMi", "Tr?? chuy???n tr???c ti???p c??ng ?????i ng?? si??u cute")
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
                    Toast.makeText(HomeActivity.this, "H?????ng d???n ho??n t???t", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                }

                @Override
                public void onSequenceCanceled(TapTarget lastTarget) {

                }
            }).start();
            SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart",false);
            editor.apply();
        }




}