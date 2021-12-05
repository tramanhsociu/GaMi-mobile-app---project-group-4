package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragment.SettingFragment;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    ImageView imvBack;
    TextView txtForgotPass;
    FrameLayout btnLogin;

//    TextInputLayout edtEmail, edtMk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imvBack = findViewById(R.id.imvBack);
        txtForgotPass = findViewById(R.id.txtForgotPass);
        btnLogin = findViewById(R.id.btnLogin);


//    edtEmail=findViewById(R.id.edtEmail);
//    edtMk=findViewById(R.id.edtMk);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                replaceFragment(new HomeFragment());
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, onboardingFragment2.class);
                startActivity(intent);
            }
        });
        txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgotPassDialog(Gravity.BOTTOM);
            }
        });

    }

//    private void replaceFragment(HomeFragment homeFragment) {
//        //nhúng fragment home
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.home, new HomeFragment());
//        transaction.commit();
//    }


    private void openForgotPassDialog(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_forgotpass);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);

        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);

        }
        dialog.show();


        FrameLayout btnContinue = dialog.findViewById(R.id.btnContinue);

        //mở dialog 2

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVerifyDialog(Gravity.BOTTOM);
                dialog.dismiss();
            }
        });
    }

    private void openVerifyDialog(int gravity) {
        final Dialog dialog1 = new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.layout_dialog_verify);

        Window window = dialog1.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);

        if (Gravity.BOTTOM == gravity) {
            dialog1.setCancelable(true);
        } else {
            dialog1.setCancelable(false);
        }
        dialog1.show();

        //mở dialog 3 - start reset
        FrameLayout btnContinueReset = dialog1.findViewById(R.id.btnContinueReset);
        btnContinueReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResetPassDialog(Gravity.BOTTOM);
                dialog1.dismiss();
            }
        });
    }

    private void openResetPassDialog(int gravity) {
        final Dialog dialog2 = new Dialog(this);
        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog2.setContentView(R.layout.layout_dialog_resetpass);

        Window window = dialog2.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);

        if (Gravity.BOTTOM == gravity) {
            dialog2.setCancelable(true);
        } else {
            dialog2.setCancelable(false);
        }
        dialog2.show();

    }

}