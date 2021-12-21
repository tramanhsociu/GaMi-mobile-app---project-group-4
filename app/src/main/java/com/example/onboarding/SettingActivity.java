package com.example.onboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Adapter.SectionAdapter;
import com.example.model.Section;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    ListView lvSetting;
    ArrayList<Section> listData;
    SectionAdapter adapter;
    ImageView imvBack;
    FrameLayout btnLogout;

    GoogleSignInClient mGoogleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        linkViews();
        initData();
        initAdapter();
        addEvents();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void linkViews() {
        lvSetting=findViewById(R.id.lvSetting);
        imvBack=findViewById(R.id.imvBack);
        btnLogout=findViewById(R.id.btnLogout);
    }

    private void initData() {
        listData = new ArrayList<Section>();
        listData.add(new Section("Thông báo", R.drawable.ic_baseline_arrow_forward_ios_24));
        listData.add(new Section("Hỗ trợ", R.drawable.ic_baseline_arrow_forward_ios_24));
        listData.add(new Section("Thanh toán", R.drawable.ic_baseline_arrow_forward_ios_24));
        listData.add(new Section("Đánh giá", R.drawable.ic_baseline_arrow_forward_ios_24));
    }

    private void initAdapter() {
        adapter = new SectionAdapter(SettingActivity.this, R.layout.setting_layout, listData);
        lvSetting.setAdapter(adapter);
    }

    private void addEvents() {
        lvSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    //thông báo
                    startActivity(new Intent(SettingActivity.this, SettingNotificationActivity.class));
                }else if(position == 1){
                    //hỗ trợ
                    startActivity(new Intent(SettingActivity.this, SettingSupportActivity.class));
                }else if(position == 2){
                    //thanh toán
                    startActivity(new Intent(SettingActivity.this, SettingPaymentActivity.class));
                }else{
                    //đánh giá ứng dụng
                    startActivity(new Intent(SettingActivity.this, SettingFeedbackActivity.class));

                }
            }
        });
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             replaceFragment(new ProfileFragment());
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //đăng xuất Google account
                signOut();

                //không còn remember me
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();

                finish();
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
            }
        });

        }
    //đăng xuất
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                        finish();
                    }
                });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Setting, fragment);
        fragmentTransaction.commit();
    }


}