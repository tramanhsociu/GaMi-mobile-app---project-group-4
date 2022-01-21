package com.example.onboarding;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.ProfileDatabase;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;



public class ProfileSettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //private Spinner spinnerGioiTinh;
    ImageView imvAvatar;
    Button btnEditAvatar;
    EditText edtName, edtNumberPhone, edtAddress;
    Spinner spiner_gioitinh;

    TextView txtCamera, txtGallery, btnDone;

    BottomSheetDialog sheetDialog;

    ActivityResultLauncher<Intent> activityResultLauncher;

    boolean IsCamera;

    public static ProfileDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting2);

        linkViews();
        addEvents();
        createBottomSheet();


        db= new ProfileDatabase(this);


        Spinner spinner =findViewById(R.id.spiner_gioitinh);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.gioitinh, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                //Result get.Data()
                if(result.getResultCode()==RESULT_OK && result.getData() !=null){
                    if(IsCamera){
                        Bitmap bitmap =(Bitmap) result.getData().getExtras().get("data");
                        imvAvatar.setImageBitmap(bitmap);
                    }else {
                        Uri uri =result.getData().getData();
                        if(uri !=null){
                            try {
                                InputStream inputStream=getContentResolver().openInputStream(uri);
                                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                                imvAvatar.setImageBitmap(bitmap);
                            }catch (FileNotFoundException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
    }

    private void createBottomSheet(){
        if(sheetDialog == null){
            View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet, null);
            txtCamera= view.findViewById(R.id.txtCamera);
            txtCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Open camera
                    IsCamera=true;
                    Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            txtGallery= view.findViewById(R.id.txtGallery);
            txtGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Open Gallery
                    IsCamera=false;
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            sheetDialog = new BottomSheetDialog(this);
            sheetDialog.setContentView(view);
        }
    }

    private void addEvents() {
        btnEditAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // Open bottom sheet
            sheetDialog.show();
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert data
                String name, gender, address, phone;
                phone = edtNumberPhone.getText().toString();
                name = edtName.getText().toString();
                gender= spiner_gioitinh.getSelectedItem().toString();
                address =edtAddress.getText().toString();
                if(!name.equals("") && !gender.equals("") && !address.equals("") && !phone.equals("") ){
                   boolean flag =db.insertData(name, gender, phone, address, convertPhoto());
                   if(flag){

                       Toast.makeText(ProfileSettingActivity.this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                       //Intent intent= new Intent(ProfileSettingActivity.this, ProfileFragment.class);
                       //startActivity(intent);
                   }else {
                       Toast.makeText(ProfileSettingActivity.this, "Fail!", Toast.LENGTH_SHORT).show();

                   }
                }else {
                    Toast.makeText(ProfileSettingActivity.this, "Bạn cần nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private byte[] convertPhoto() {
        BitmapDrawable drawable = (BitmapDrawable) imvAvatar.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
//        test
    }

    private void linkViews() {
        btnEditAvatar= findViewById(R.id.btnEditAvatar);
        imvAvatar= findViewById(R.id.imvAvatar);
        btnDone= findViewById(R.id.btnDone);
        edtName= findViewById(R.id.edtName);
        edtAddress= findViewById(R.id.edtAddress);
        edtNumberPhone= findViewById(R.id.edtNumberPhone);
        spiner_gioitinh = findViewById(R.id.spiner_gioitinh);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent .getContext(), text, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}