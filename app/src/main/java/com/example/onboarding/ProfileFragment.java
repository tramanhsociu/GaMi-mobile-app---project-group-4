package com.example.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class ProfileFragment extends Fragment{

    ImageButton imbSetting, imbSettingProfile, imbGoSettingProfile;
    TextView txtSettingProfile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        imbSetting=view.findViewById(R.id.imbSetting);
        imbSettingProfile=view.findViewById(R.id.imbSettingProfile);
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
        imbSettingProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), activity_profile_setting.class);
                getActivity().startActivity(intent);
            }
        });
    }


}