package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.Adapter.SaleAdapter;
import com.example.model.Khuyenmai;

import java.util.ArrayList;

public class ItemSale extends AppCompatActivity {

    ListView lvSale;
    ArrayList<Khuyenmai> sales;
    SaleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_sale);

        linkViews();
        initData();
        initAdapter();
    }

    private void linkViews() {
        lvSale= findViewById(R.id.lvItemSale);
    }

    private void initData() {
        sales = new ArrayList<Khuyenmai>();
        sales.add(new Khuyenmai(R.drawable.blackfriday,"Black Friday","Hàng hiệu giảm giá lên đến 50% \n" +
                "Mua 1 được  \n" +
                "Freeship dù bạn ở bất cứ đâu \n" +
                "Mua ngay!"));
        sales.add(new Khuyenmai(R.drawable.supersale,"Săn sale cho “Boss” nào ","Sale tưng bừng mừng ngày xuống phố\n" +
                "Săn mỗi 0H, 9H, 12H, 21H\n" +
                "Rẻ bất ngờ - Đặt hẹn ngay"));
        sales.add(new Khuyenmai(R.drawable.finalsale,"Sale sale khoái khoái","GaMi dành riêng cho bạn đó\n" +
                "Mua hông mua thì mua\n" +
                "Hàng loạt sản phẩm giá tốt\n" +
                "Lẹ tay chốt đơn!"));
    }

    private void initAdapter() {
        adapter= new SaleAdapter(ItemSale.this,R.layout.item_khuyenmai,sales);
        lvSale.setAdapter(adapter);
    }
}