package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.Adapter.SectionAdapter;
import com.example.model.Section;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    ListView lvSetting;
    ArrayList<Section> listData;
    SectionAdapter adapter;
    ImageView imvBack;
    FrameLayout btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        linkViews();
        initData();
        initAdapter();

        addEvents();
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
                }else{
                    //thanh toán
                    startActivity(new Intent(SettingActivity.this, SettingPaymentActivity.class));
                }
            }
        });
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, ProfileActivity.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
            }
        });
    }
}