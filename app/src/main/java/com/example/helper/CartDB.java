/*
 * Copyright 2014 KC Ochibili
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 *  The "‚‗‚" character is not a comma, it is the SINGLE LOW-9 QUOTATION MARK unicode 201A
 *  and unicode 2017 that are used for separating the items in a list.
 */

package com.example.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;


import com.example.model.Products;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.Arrays;



public class CartDB{

    private SharedPreferences preferences;

    public CartDB(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }





//            * Nhận ArrayList of String được phân tích cú pháp từ SharedPreferences tại 'key'
//            * Khóa @param Khóa SharedPreferences


    public ArrayList<String> getListString(String key) {
        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }



    public ArrayList<Products> getListObject(String key){
        Gson gson = new Gson();

        ArrayList<String> objStrings = getListString(key);
        ArrayList<Products> playerList =  new ArrayList<Products>();

        for(String jObjString : objStrings){
           Products player  = gson.fromJson(jObjString,  Products.class);
            playerList.add(player);
        }
        return playerList;
    }






//           * Đặt giá trị Chuỗi vào SharedPreferences bằng 'key' và lưu
//      * Khóa @param Khóa SharedPreferences


    public void putString(String key, String value) {
        checkForNullKey(key); checkForNullValue(value);
        preferences.edit().putString(key, value).apply();
    }

//
//          * Đặt ArrayList of String vào SharedPreferences bằng 'key' và lưu
//      * @param stringList Array Danh sách chuỗi sẽ được thêm vào
//
    public void putListString(String key, ArrayList<String> stringList) {
        checkForNullKey(key);
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }



//
//          * Đặt ObJect bất kỳ loại nào vào SharedPrefrences bằng 'key' và lưu
//      * @param obj là Đối tượng bạn muốn đặt
//
    public void putObject(String key, Object obj){
    	checkForNullKey(key);
    	Gson gson = new Gson();
    	putString(key, gson.toJson(obj));
    }

    public void putListObject(String key, ArrayList<Products> playerList){
        checkForNullKey(key);
        Gson gson = new Gson();
        ArrayList<String> objStrings = new ArrayList<String>();
        for(Products player: playerList){
            objStrings.add(gson.toJson(player));
        }
        putListString(key, objStrings);
    }

    public void remove(String key) {
        preferences.edit().remove(key).apply();
    }







//            * null key sẽ làm hỏng tệp pref được chia sẻ và khiến chúng không thể đọc được, đây là một biện pháp phòng ngừa

    private void checkForNullKey(String key){
        if (key == null){
            throw new NullPointerException();
        }
    }

    private void checkForNullValue(String value){
        if (value == null){
            throw new NullPointerException();
        }
    }
}