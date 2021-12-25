package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
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

public class CartActivity extends AppCompatActivity implements PaymentResultListener {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCard managementCard;
    private ScrollView scrollView;

    TextView txtCheckOut,txtTotalFee,txtTotalPayment,txtDeliveryFee,txtEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        managementCard = new ManagementCard(this);
        linkViews();
        addEvents();
        initList();
        calculateCart();

        Checkout.preload(CartActivity.this);
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


    }

    private void addEvents() {
        txtCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment(Integer.parseInt(txtTotalPayment.getText().toString()));
            }
        });
    }
    public void startPayment(int Amount) {
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

            checkout.open(CartActivity.this, retryObj);

        }catch (Exception e){
            Toast.makeText(CartActivity.this, "Có gì đó không ổn", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(CartActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(CartActivity.this, "Error: "+ s, Toast.LENGTH_SHORT).show();
    }
}