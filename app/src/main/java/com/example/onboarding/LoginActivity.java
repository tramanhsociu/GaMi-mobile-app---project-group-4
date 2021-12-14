package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.ExtractEditText;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.AccountDB;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    //nút FB
    private LoginButton btnFb;
    private CallbackManager callbackManager;
    //nút GG
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;

    ImageView imvBack;
    TextView txtForgotPass;
    FrameLayout btnLogin,FB,GG;
    AccountDB DB;
    TextInputEditText edtEmail, edtPass;
    CheckBox chkRemember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imvBack = findViewById(R.id.imvBack);
        txtForgotPass = findViewById(R.id.txtForgotPass);
        btnLogin = findViewById(R.id.btnLogin);
        chkRemember = findViewById(R.id.chkRemember);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnFb = findViewById(R.id.btnFb);
        DB = new AccountDB(this);
        FB = findViewById(R.id.FB);
        GG = findViewById(R.id.GG);
        //Đăng nhập bằng Facebook
        callbackManager = CallbackManager.Factory.create();
        btnFb.setReadPermissions("email");
        // Callback registration
        FB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == FB) {
                    btnFb.performClick();
                }
            }
        });
        btnFb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("GaMi","Đăng nhập thành công!" );
            }

            @Override
            public void onCancel() {
                Log.d("GaMi","Hủy" );
            }

            @Override
            public void onError(FacebookException exception) {
                Log.d("GaMi","Đăng nhập không thành công" );
            }
        });
        LoginManager.getInstance().logOut();
        //Đăng nhập bằng Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);
        GG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == GG) {
                    signInButton.performClick();
                    signIn();
                }
            }
        });

        //remember me
        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if (checkbox.equals("true")){

//            FragmentManager manager = getSupportFragmentManager();
//            FragmentTransaction transaction = manager.beginTransaction();
//            transaction.replace(R.id.Login, new HomeFragment());
//            transaction.commit();

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }else if(checkbox.equals("false")){
            Toast.makeText(LoginActivity.this, "Hãy đăng nhập", Toast.LENGTH_SHORT).show();
        }

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
                            //nhúng fragment home
                            FragmentManager manager = getSupportFragmentManager();
                            FragmentTransaction transaction = manager.beginTransaction();
                            transaction.replace(R.id.Login, new HomeFragment());
                            transaction.commit();

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        chkRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                }else if(!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
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

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

            }
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);

            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("message", e.toString());
        }
    }


    AccessTokenTracker t = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if(currentAccessToken == null) {
                Toast.makeText(LoginActivity.this, "Bạn đã đăng xuất", Toast.LENGTH_SHORT).show();
            }else{
                loaduserProfile(currentAccessToken);
            }

            if (t != null) {//<- IMPORTANT
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();//<- IMPORTANT
            }
        }
    };

    private void loaduserProfile(AccessToken newAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, ((object, response) -> {
            if(object!=null){
                try{
                    String email = object.getString("email");
                    String id = object.getString("id");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }));
        Bundle parameters = new Bundle();
        parameters.putString("fields", "email,name,id");
        request.setParameters(parameters);
        request.executeAsync();
    }

}