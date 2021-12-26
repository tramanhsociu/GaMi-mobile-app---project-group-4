package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.Adapter.PayMethodAdapter;
import com.example.model.PayMethod;
import com.example.model.Section;

import java.util.ArrayList;

public class SettingPaymentActivity extends AppCompatActivity {
    ListView lvPaySetting;
    ArrayList<PayMethod> payMethods;
    PayMethodAdapter adapter;
    ImageView imvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_payment);
        linkViews();
        initData();
        initAdapter();
        addEvents();
    }

    private void linkViews() {
        lvPaySetting = findViewById(R.id.lvPaySetting);
        imvBack = findViewById(R.id.imvBack);
    }

    private void initData() {
        payMethods=new ArrayList<PayMethod>();
        payMethods.add(new PayMethod(R.drawable.creditcard, "E-banking", R.drawable.ic_baseline_arrow_forward_ios_24));
        payMethods.add(new PayMethod(R.drawable.momo, "MoMo", R.drawable.ic_baseline_arrow_forward_ios_24));
        payMethods.add(new PayMethod(R.drawable.ship, "Ship COD", R.drawable.ic_baseline_arrow_forward_ios_24));
    }

    private void initAdapter() {
        adapter = new PayMethodAdapter(SettingPaymentActivity.this, R.layout.item_pay_method, payMethods);
        lvPaySetting.setAdapter(adapter);
    }

    private void addEvents() {
        lvPaySetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){

                }
                else if(i==1){

                }
                else{

                }
            }
        });
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingPaymentActivity.this, SettingActivity.class));
            }
        });
    }
}