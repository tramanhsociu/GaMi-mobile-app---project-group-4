package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helper.ManagementCard;
import com.example.model.Products;

public class ShowDetailActivity extends AppCompatActivity{
    TextView txtNumOrder, txtName,txtPrice,txtDescription,btnAddtoCard;
    ImageView imvPlus, imvMinus,imvThumb;
    RatingBar ratingBar;
    Products products;
    int numberOrder = 1;

    private ManagementCard managementCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCard = new ManagementCard(this);
        linkView();
        getBundle();
    }

    private void getBundle() {
        products = (Products) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(String.valueOf(products.getThumb()),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(imvThumb);
        txtName.setText(products.getName());
        txtPrice.setText(products.getPrice()+ " VND");
        txtDescription.setText(products.getDescription());
        txtNumOrder.setText(String.valueOf(numberOrder));

        imvPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder + 1;
                txtNumOrder.setText(String.valueOf(numberOrder));
            }
        });
        imvMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }

            }
        });
        btnAddtoCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                products.setNumberInCard(numberOrder);
                managementCard.insertProduct(products);

            }
        });



    }

    private void linkView() {
        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        txtDescription = findViewById(R.id.txtDes);
        txtNumOrder = findViewById(R.id.txtNumOder);
        btnAddtoCard = findViewById(R.id.btnAddCart);
        imvMinus = findViewById(R.id.imvMinus);
        imvPlus = findViewById(R.id.imvPlus);
        imvThumb = findViewById(R.id.imvThumb);
        ratingBar = findViewById(R.id.ratingBar);

    }
}