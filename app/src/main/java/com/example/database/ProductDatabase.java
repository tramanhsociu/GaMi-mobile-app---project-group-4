package com.example.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductDatabase extends SQLiteOpenHelper{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME= "products.sqlite";
    public static final String TBL_NAME = "Products";
    private static final String COL_W_ID= "W_Id";
    private static final String COL_W_NAME= "W_Name";
    private static final String COL_W_DES= "W_Des";
    private static final String COL_W_PHOTO= "W_Photo";

    public ProductDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_W_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_W_NAME + " VARCHAR(200), " + COL_W_DES + " VARCHAR(200), " + COL_W_PHOTO + " BLOB)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
