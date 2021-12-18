package com.example.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.Adapter.SaleAdapter;
import com.example.interfaces.NotiInterface;
import com.example.model.Sale;

import java.util.ArrayList;


public class SaleFragment extends Fragment{

    ListView lvSale;
    ArrayList<Sale> sales;
    SaleAdapter adapter;
    ImageButton btnBack;
    TextView txtSale;

    NotiInterface notiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_sale, container, false);
         lvSale = view.findViewById(R.id.lvItemSale);
         btnBack = view.findViewById(R.id.btnBacknoti);
         txtSale = view.findViewById(R.id.txtKhuyenmai);

         adapter = new SaleAdapter(getContext(), R.layout.item_sale,initData());
         lvSale.setAdapter(adapter);

//         lvSale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//             @Override
//             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                notiInterface = (NotiInterface) getActivity();
//                if(notiInterface!=null){
//                    notiInterface.dataFlow(sales.get(i));
//                }
//             }
//         });
         addEvents();
        return view;
    }


    private ArrayList<Sale> initData() {
        sales = new ArrayList<>();
        sales.add(new Sale(R.drawable.blackfriday,"Black Friday","Hàng hiệu giảm giá lên đến 50% \n" +
                "Mua 1 được  \n" +
                "Freeship dù bạn ở bất cứ đâu \n" +
                "Mua ngay!"));
        sales.add(new Sale(R.drawable.supersale,"Săn sale cho “Boss” nào ","Sale tưng bừng mừng ngày xuống phố\n" +
                "Săn mỗi 0H, 9H, 12H, 21H\n" +
                "Rẻ bất ngờ - Đặt hẹn ngay"));
        sales.add(new Sale(R.drawable.finalsale,"Sale sale khoái khoái","GaMi dành riêng cho bạn đó\n" +
                "Mua hông mua thì mua\n" +
                "Hàng loạt sản phẩm giá tốt\n" +
                "Lẹ tay chốt đơn!"));
        return sales;
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment( new NotiFragment());
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_sale, fragment);
        fragmentTransaction.commit();
        lvSale.setVisibility(View.GONE);
        txtSale.setVisibility(View.GONE);
        btnBack.setVisibility(View.GONE);
    }


}