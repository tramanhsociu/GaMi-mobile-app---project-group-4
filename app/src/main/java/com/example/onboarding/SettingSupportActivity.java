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
import com.example.fragment.SettingFragment3;
import com.example.fragment.SettingFragment4;
import com.example.fragment.SettingFragment5;
import com.example.model.SupportPost;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class SettingSupportActivity extends AppCompatActivity {
    ImageView imvBack;
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
        searchView=findViewById(R.id.searchView);
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
                    replaceFragment(new SettingFragment3());
                }else if(i==3){
                    replaceFragment(new SettingFragment4());
                }else{
                    replaceFragment(new SettingFragment5());
                }
            }
        });

    }

    private void initData() {
        posts = new ArrayList<SupportPost>();
        posts.add(new SupportPost("L??m sao ????? mua h??ng/ ?????t h??ng tr??n ???ng d???ng GaMi?"));
        posts.add(new SupportPost("Quy tr??nh tr??? h??ng ho??n ti???n c???a GaMi"));
        posts.add(new SupportPost("C??ch theo d??i t??nh tr???ng v???n chuy???n c???a ????n h??ng"));
        posts.add(new SupportPost("T??i c?? th??? h???y ????n h??ng kh??ng?"));
        posts.add(new SupportPost("T???i sao t??i kho???n GaMi c???a t??i b??? kh??a/ b??? gi???i h???n?"));
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