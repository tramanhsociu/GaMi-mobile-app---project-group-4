package com.example.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.Adapter.InfoOrderAdapter;
import com.example.model.InfoOrder;

import java.util.ArrayList;

public class InfoOrderFragment extends Fragment {

    ListView lvInfoOrder;
    ArrayList<InfoOrder> infoOrders;
    InfoOrderAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_order, container, false);
        lvInfoOrder= view.findViewById(R.id.lvInfoOrder);

        adapter = new InfoOrderAdapter(getContext(),R.layout.item_info_order,initData());
        lvInfoOrder.setAdapter(adapter);
        return view;
    }

    private ArrayList<InfoOrder> initData() {
        infoOrders = new ArrayList<>();

        infoOrders.add(new InfoOrder(R.drawable.product1,"GaMi đã giao hàng thành công","Đơn hàng GM001 của “Sen” đã được giao thành công\n" +
                "Mã đơn hàng 001.","15:59 13/10/2021",R.drawable.muiten));

        infoOrders.add(new InfoOrder(R.drawable.product2,"Bạn đã hủy đơn hàng","Đơn hàng GM002 của “Sen” đã được hủy\n" +
                "Mã đơn hàng 002.","15:59 13/10/2021",R.drawable.muiten));

        infoOrders.add(new InfoOrder(R.drawable.product3,"GaMi đang giao hàng cho bạn ","Đơn hàng GM003 của “Sen” đang được vận chuyển\n" +
                "Mã đơn hàng 003.","10:09 12/10/2021",R.drawable.muiten));

        infoOrders.add(new InfoOrder(R.drawable.product3,"GaMi đang giao hàng cho bạn ","Đơn hàng GM003 của “Sen” đang được vận chuyển\n" +
                "Mã đơn hàng 003.","10:09 12/10/2021",R.drawable.muiten));

        infoOrders.add(new InfoOrder(R.drawable.product3,"GaMi đang giao hàng cho bạn ","Đơn hàng GM003 của “Sen” đang được vận chuyển\n" +
                "Mã đơn hàng 003.","10:09 12/10/2021",R.drawable.muiten));

        infoOrders.add(new InfoOrder(R.drawable.product3,"GaMi đang giao hàng cho bạn ","Đơn hàng GM003 của “Sen” đang được vận chuyển\n" +
                "Mã đơn hàng 003.","10:09 12/10/2021",R.drawable.muiten));

        return infoOrders;
    }
}
