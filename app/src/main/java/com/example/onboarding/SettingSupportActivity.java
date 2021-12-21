package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.Adapter.SupportPostAdapter;
import com.example.fragment.SettingFragment;
import com.example.fragment.SettingFragment2;
import com.example.model.SupportPost;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class SettingSupportActivity extends AppCompatActivity {
    ImageView imvBack;
//    AutoCompleteTextView actSearch;
//    TextInputEditText edtSearch;
    SearchView searchView;
    ListView lvSettingsupport;
    ArrayList<SupportPost> posts;
    SupportPostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_support);
        linkViews();
        addEvents();
        initData();
        initAdapter();

    }

    private void linkViews() {
        imvBack=findViewById(R.id.imvBack);
        lvSettingsupport=findViewById(R.id.lvSettingsuport);
//        edtSearch = findViewById(R.id.edtSearch);
        searchView=findViewById(R.id.searchView);
//        actSearch = findViewById(R.id.actSearch);
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingSupportActivity.this, SettingActivity.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SettingSupportActivity.this.adapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        lvSettingsupport.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    replaceFragment(new SettingFragment());
                }else if(i==1){
                    replaceFragment(new SettingFragment2());
                }else if(i==2){

                }else if(i==3){

                }else if(i==4){

                }else if(i==5){

                }
            }
        });

    }

    private void initData() {
        posts = new ArrayList<SupportPost>();
        posts.add(new SupportPost("Làm sao để mua hàng/ Đặt hàng trên ứng dụng GaMi?"));
        posts.add(new SupportPost("Quy trình trả hàng hoàn tiền của GaMi"));
        posts.add(new SupportPost("Cách theo dõi tình trạng vận chuyển của đơn hàng"));
        posts.add(new SupportPost("Hướng dẫn sử dụng mã miễn phí vận chuyển"));
        posts.add(new SupportPost("Tôi có thể hủy đơn hàng không?"));
        posts.add(new SupportPost("Tại sao tài khoản GaMi của tôi bị khóa/ bị giới hạn?"));
    }

    private void initAdapter() {
        adapter = new SupportPostAdapter(SettingSupportActivity.this, R.layout.custom_list_setting_support,posts);
        lvSettingsupport.setAdapter(adapter);

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.post_support, fragment);
        fragmentTransaction.commit();
    }
}