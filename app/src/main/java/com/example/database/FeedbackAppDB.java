package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FeedbackAppDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "FeedbackApp.db";
    public static final int DB_VERSION = 1;

    public FeedbackAppDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table feedbacks(email TEXT primary key,feedback TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists feedbacks");

    }
    public boolean insertData(String email, String feedback)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("feedback",feedback);
        long result = sqLiteDatabase.insert("feedbacks", null, contentValues);
        if(result==-1){
            return false;}
        else{
            return true;}
    }


}
