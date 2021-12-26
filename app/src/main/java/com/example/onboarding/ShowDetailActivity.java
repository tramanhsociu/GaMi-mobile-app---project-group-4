package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helper.ManagementCard;
import com.example.model.Products;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class ShowDetailActivity extends AppCompatActivity{
    TextView txtNumOrder, txtName,txtPrice,txtDescription,btnAddtoCard,txtBadge;
    ImageView imvPlus, imvMinus,imvThumb,btnCart;
    ImageButton btnChat;
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
        txtBadge.setText(String.valueOf(managementCard.getCount()));




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




                // animation


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
        btnCart = findViewById(R.id.btnCart);
        btnChat = findViewById(R.id.btnChat);
        txtBadge = findViewById(R.id.txtBadgeCart);
        Crisp.configure(getApplicationContext(), "e4983e6a-06f0-42ca-b683-b7723850abc0");

        btnChat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent crispIntent = new Intent(ShowDetailActivity.this, ChatActivity.class);
                startActivity(crispIntent);

            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ShowDetailActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });


    }



}