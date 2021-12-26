package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.AccountDB;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    TextView txtLogin;
//    ImageView imvBack;
    FrameLayout btnRegis;
    TextInputEditText edtName,edtEmail,edtPass,edtPassAgain;

    AccountDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    txtLogin=findViewById(R.id.txtLogin);
//    imvBack=findViewById(R.id.imvBack);
    btnRegis=findViewById(R.id.btnRegis);
    edtName=findViewById(R.id.edtName);
    edtEmail=findViewById(R.id.edtEmail);
    edtPass=findViewById(R.id.edtPass);
    edtPassAgain=findViewById(R.id.edtPassAgain);
    DB=new AccountDB(this);

    txtLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    });
//    imvBack.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent =new Intent(RegisterActivity.this, onboardingFragment2.class);
//            startActivity(intent);
//        }
//    });
    btnRegis.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name=edtName.getText().toString();
            String email=edtEmail.getText().toString();
            String pass=edtPass.getText().toString();
            String repass=edtPassAgain.getText().toString();

            if(name.equals("")||email.equals("")||pass.equals("")||repass.equals("")){
                Toast.makeText(RegisterActivity.this, "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }else{
                if(pass.equals(repass)){
                    boolean checkemail = DB.checkemail(email);
                    if(checkemail==false){
                       boolean insertData = DB.insertData(name,email,pass);
                       if(insertData==true){
                           Intent in = new Intent(RegisterActivity.this, RegisSucessActivity.class);
                           in.putExtra("email",email);
                           startActivity(in);
                       }else{
                           Toast.makeText(RegisterActivity.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                       }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Tài khoản đã tồn tại, hãy đăng nhập đi bạn ui", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Nhập lại mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }

            }


        }
    });
    }
}