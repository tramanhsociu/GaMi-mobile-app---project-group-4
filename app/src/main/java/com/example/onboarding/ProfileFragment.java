package com.example.onboarding;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.database.ProfileDatabase;
import com.example.model.Customer;


public class ProfileFragment extends Fragment{

    ImageButton imbSetting, imbSettingProfile, imbGoSettingProfile;
    TextView txtSettingProfile, txtName;
    ImageView imvAvatar;
    LinearLayout LayoutTLTK, LayoutPolicy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        imbSetting=view.findViewById(R.id.imbSetting);
        LayoutTLTK=view.findViewById(R.id.LayoutTLTK);
        LayoutPolicy=view.findViewById(R.id.LayoutPolicy);
        txtName= view.findViewById(R.id.txtName);
        imvAvatar= view.findViewById(R.id.imvAvatar);
        addEvents();
      //  loadData();
        return view;

    }

//    private void loadData() {
//        Cursor cursor = db.getData("SELECT * FROM " + ProfileDatabase.TBL_NAME);
//        while (cursor.moveToNext()){
//           txtName.setText(cursor.getString(1));
//        }
//        cursor.close();
//    }

    private void addEvents() {
        imbSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ProfileFragment, SettingActivity.class));
                Intent intent = new Intent(getActivity(),SettingActivity.class);
                getActivity().startActivity(intent);
            }
        });
        LayoutTLTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileSettingActivity.class);
                startActivity(intent);
            }
        });
        LayoutPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PolicyActivity.class);
                startActivity(intent);
            }
        });
    }


}