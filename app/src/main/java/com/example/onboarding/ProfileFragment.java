package com.example.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ProfileFragment extends Fragment{

    ImageButton imbSetting, imbSettingProfile, imbGoSettingProfile;
    TextView txtSettingProfile;
    LinearLayout LayoutTLTK;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        imbSetting=view.findViewById(R.id.imbSetting);
        LayoutTLTK=view.findViewById(R.id.LayoutTLTK);
        addEvents();
        return view;
    }

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
    }


}