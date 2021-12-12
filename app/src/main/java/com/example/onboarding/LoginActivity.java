package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.AccountDB;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    ImageView imvBack;
    TextView txtForgotPass;
    FrameLayout btnLogin;
    AccountDB DB;
    TextInputEditText edtEmail, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imvBack = findViewById(R.id.imvBack);
        txtForgotPass = findViewById(R.id.txtForgotPass);
        btnLogin = findViewById(R.id.btnLogin);

        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);

        DB = new AccountDB(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=edtEmail.getText().toString();
                String pass=edtPass.getText().toString();

                if(email.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Bạn hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                else{
                    boolean checkemailpass = DB.checkemailpassword(email, pass);
                    if(checkemailpass==true){
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                }

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
        TextInputEditText edtEmailVerify=dialog.findViewById(R.id.edtEmailVerify);

        //mở dialog thứ 2

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = edtEmailVerify.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("mail", mail);

                boolean checkemail=DB.checkemail(mail);
                if(checkemail==true){
                    //truyền email mới nhập đi
                    openResetPassDialog(Gravity.BOTTOM, bundle);
                    dialog.dismiss();
                }else{
                    Toast.makeText(LoginActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

//    private void openVerifyDialog(int gravity) {
//        final Dialog dialog1 = new Dialog(this);
//        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog1.setContentView(R.layout.layout_dialog_verify);
//
//        Window window = dialog1.getWindow();
//        if (window == null) {
//            return;
//        }
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        WindowManager.LayoutParams windowAttribute = window.getAttributes();
//        windowAttribute.gravity = gravity;
//        window.setAttributes(windowAttribute);
//
//        if (Gravity.BOTTOM == gravity) {
//            dialog1.setCancelable(true);
//        } else {
//            dialog1.setCancelable(false);
//        }
//        dialog1.show();

        //mở dialog 3 - start reset
//        FrameLayout btnContinueReset = dialog1.findViewById(R.id.btnContinueReset);
//        btnContinueReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openResetPassDialog(Gravity.BOTTOM);
//                dialog1.dismiss();
//            }
//        });
//    }

    private void openResetPassDialog(int gravity, Bundle bundle) {
        final Dialog dialog1 = new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.layout_dialog_resetpass);

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

        FrameLayout btnReset = dialog1.findViewById(R.id.btnReset);
        TextInputEditText edtMk = dialog1.findViewById(R.id.edtMk);
        TextInputEditText edtReMk = dialog1.findViewById(R.id.edtReMk);

       


        //reset lại mật khẩu
        btnReset.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //cần đưa email về
                String mail = bundle.getString("mail");
                String newpass = edtMk.getText().toString();
                String newrepass=edtReMk.getText().toString();
                if(newpass.equals(newrepass)){

                boolean checkpasswordupdate = DB.updatepassword(mail, newpass);
                if(checkpasswordupdate==true){
                    dialog1.dismiss();
                    Toast.makeText(LoginActivity.this, "Thay đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Thay đổi mật khẩu không thành công!", Toast.LENGTH_SHORT).show();
                }

                }else{
                    Toast.makeText(LoginActivity.this, "Mật khẩu nhập không khớp", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}