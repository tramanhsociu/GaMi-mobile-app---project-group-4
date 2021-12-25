package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Adapter.CartListAdapter;
import com.example.helper.ManagementCard;
import com.example.interfaces.ChangeNumberItemListener;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCard managementCard;
    private ScrollView scrollView;
    ImageButton btnChat;

    TextView txtCheckOut,txtTotalFee,txtTotalPayment,txtDeliveryFee,txtEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        managementCard = new ManagementCard(this);
        linkViews();

        initList();
        calculateCart();


    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new CartListAdapter(this, managementCard.getListCard(), new ChangeNumberItemListener(){
            @Override
            public void changed() {
                calculateCart();

            }
        });
        recyclerViewList.setLayoutManager(linearLayoutManager);
        recyclerViewList.setAdapter(adapter);
        if (managementCard.getListCard().isEmpty()) {
            txtEmpty.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            if (managementCard.getListCard().isEmpty()) {
                txtEmpty.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
            }
        }
    }
    private void calculateCart (){
        double delivery = 10;
        double total = Math.round(managementCard.getTotalFee()+ delivery);
        txtTotalFee.setText(managementCard.getTotalFee() + "VND");
        txtDeliveryFee.setText(delivery + "VND");
        txtTotalPayment.setText(total+ "VND");
    }

    private void linkViews() {
        recyclerViewList = findViewById(R.id.rcvCartItem);
        txtTotalFee = findViewById(R.id.txtTotalFee);
        txtTotalPayment = findViewById(R.id.txtTotalPayment);
        txtDeliveryFee = findViewById(R.id.txtDeliveryFee);
        txtCheckOut=findViewById(R.id.btnCheckOut);
        txtEmpty = findViewById(R.id.txtEmpty);
        scrollView = findViewById(R.id.srvCart);
        btnChat = findViewById(R.id.btnChat);
        Crisp.configure(getApplicationContext(), "1b4d03b2-db60-4da9-b658-bcf6eceac6f1");
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crispIntent = new Intent(CartActivity.this, ChatActivity.class);
                startActivity(crispIntent);
            }
        });

        txtCheckOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });


    }


}