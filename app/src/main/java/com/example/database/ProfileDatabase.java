package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class ProfileDatabase extends SQLiteOpenHelper {

    private static final int DB_VERSION =1;
    private static final String DB_NAME ="customers.sqlite";

    private static final String TBL_NAME = "Profile";

    private static final String COL_P_ID ="P_Id";
    private static final String COL_P_NAME ="P_Name";
    private static final String COL_P_GENDER ="P_Gender";
    private static final String COL_P_PHONE ="P_Phone";
    private static final String COL_P_ADDRESS ="P_Address";
    private static final String COL_P_PHOTO ="P_Photo";


    public ProfileDatabase(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_P_NAME + " VARCHAR(100), " +
                COL_P_GENDER +  " VARCHAR(10), " + COL_P_PHONE + " VARCHAR(10), " + COL_P_ADDRESS + " VARCHAR(100), " + COL_P_PHOTO + " BLOB)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TBL_NAME);
        onCreate(sqLiteDatabase);

    }
    public void queryExec(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db =getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public boolean insertData(String name, String gender, String phone, String address, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO "+ TBL_NAME + " VALUES(NULL, ?, ?, ?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, name);
            statement.bindString(2, gender);
            statement.bindString(3, phone);
            statement.bindString(4,address);
            statement.bindBlob(5, photo);
            statement.executeInsert();
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
