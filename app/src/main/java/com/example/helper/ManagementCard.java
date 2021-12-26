package com.example.helper;

import android.content.Context;
import android.os.Parcelable;
import android.widget.Toast;

import com.example.interfaces.ChangeNumberItemListener;
import com.example.model.Products;

import java.util.ArrayList;

public class ManagementCard{
    private Context context;
    private CartDB cartDB;

    public ManagementCard(Context context) {
        this.context = context;
        this.cartDB =  new CartDB(context);
    }
    public void insertProduct(Products item){
        ArrayList<Products> listProduct = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0 ; i < listProduct.size(); i++){
            if (listProduct.get(i).getName().equals(item.getName())){
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready){
            listProduct.get(n).setNumberInCard(item.getNumberInCard());
        }else {
            listProduct.add(item);
        }
        cartDB.putListObject("CardList",listProduct);
        Toast.makeText(context, "Wow! thêm vào giỏ rồi nè", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Products> getListCard () {
        return cartDB.getListObject("CardList");
    }


    public  void plusNumberProduct(ArrayList<Products> listProduct, int position, ChangeNumberItemListener changeNumberItemListener){
        listProduct.get(position).setNumberInCard(listProduct.get(position).getNumberInCard() + 1);
        cartDB.putListObject("CardList",listProduct);
        changeNumberItemListener.changed();
    }
    public void MinusNumberProduct(ArrayList<Products> listProduct, int position, ChangeNumberItemListener changeNumberItemListener){
        if(listProduct.get(position).getNumberInCard()==1){
            listProduct.remove(position);
        }else {
            listProduct.get(position).setNumberInCard(listProduct.get(position).getNumberInCard() - 1);

        }
        cartDB.putListObject("CardList",listProduct);
        changeNumberItemListener.changed();

    }
    public Double getTotalFee(){
        ArrayList<Products> listProduct2 = getListCard();
        double fee = 0;
        for(int i = 0;i<listProduct2.size();i++){
            fee = fee + (listProduct2.get(i).getPrice() * listProduct2.get(i).getNumberInCard());
        }
        return fee;
    }
}
