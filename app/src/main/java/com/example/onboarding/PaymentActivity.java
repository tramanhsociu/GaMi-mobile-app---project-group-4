package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener{
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCard managementCard;
    RadioButton radOther, radCod;
    RadioGroup radPaymentMethod;
    TextView txtBuy,txtTotalFee,txtTotalPayment,txtDeliveryFee;
    ImageButton btnChat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        managementCard = new ManagementCard(this);
        linkViews();
        addEvents();
        initList();
        calculateCart ();


        Checkout.preload(PaymentActivity.this);

    }

    private void addEvents() {
        radPaymentMethod.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radCod:
                        break;
                    case R.id.radOthers:
                        startPayment(txtTotalPayment.getText().toString());
                        break;
                }

            }
        });
        radPaymentMethod.check(R.id.radCod);

    }

    private void linkViews() {
        recyclerViewList = findViewById(R.id.rcvCartItem);
        txtTotalFee = findViewById(R.id.txtTotalFee);
        txtTotalPayment = findViewById(R.id.txtTotalPayment);
        txtDeliveryFee = findViewById(R.id.txtDeliveryFee);
        txtBuy=findViewById(R.id.txtBuy);
        radCod = findViewById(R.id.radCod);
        radOther = findViewById(R.id.radOthers);
        radPaymentMethod = findViewById(R.id.radPaymentMethod);
        btnChat = findViewById(R.id.btnChat);
        Crisp.configure(getApplicationContext(), "1b4d03b2-db60-4da9-b658-bcf6eceac6f1");
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crispIntent = new Intent(PaymentActivity.this, ChatActivity.class);
                startActivity(crispIntent);
            }
        });
        txtBuy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, PaymentSuccessActivity.class);
                startActivity(intent);
            }
        });



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

    }
    private void calculateCart (){
        double delivery = 10;
        double total = Math.round(managementCard.getTotalFee()+ delivery);
        txtTotalFee.setText(managementCard.getTotalFee() + "VND");
        txtDeliveryFee.setText(delivery + "VND");
        txtTotalPayment.setText(total+ "VND");
    }
    public void startPayment(String Amount) {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_MyDwhAOJr8uZqe");
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "GaMi");
            jsonObject.put("description", "Giao dịch nhanh chóng với RazorPay");
            //   jsonObject.put("image", "");
            jsonObject.put("theme.color", "#FF8A75");
            jsonObject.put("currency", "VND");
            jsonObject.put("amount", Amount);

            JSONObject retryObj=new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count",4);

            jsonObject.put("retry", retryObj);

            checkout.open(PaymentActivity.this, retryObj);

        }catch (Exception e){
            Toast.makeText(PaymentActivity.this, "Có gì đó không ổn", Toast.LENGTH_SHORT).show();
        }

    }


    public void onPaymentSuccess(String s) {
        Toast.makeText(PaymentActivity.this, s, Toast.LENGTH_SHORT).show();
    }


    public void onPaymentError(int i, String s) {
        Toast.makeText(PaymentActivity.this, "Error: "+ s, Toast.LENGTH_SHORT).show();
    }

}