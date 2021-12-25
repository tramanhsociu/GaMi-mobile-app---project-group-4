package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.onboarding.R;

public class BlogDatabase extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="blog_db.sqlite";

    private static final String TBL_NAME="Blog";
    private static final String COL_B_ID="Blog_Id";
    private static final String COL_B_CONTENT="Blog_Content";
    private static final String COL_B_IMAGE="Blog_Image";



    public BlogDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS "+TBL_NAME+"("+COL_B_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_B_CONTENT+" VARCHAR(500), "+COL_B_IMAGE+" INTEGER)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TBL_NAME);
        onCreate(sqLiteDatabase);

    }

    public void execSql(String sql){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }

    public Cursor getData(String sql){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    private int getCount(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+TBL_NAME,null);
        int count =c.getCount();
        c.close();
        return count;
    }

    public void createDefaultSomeBlog(){
        int count= this.getCount();
        if(count==0){
            this.execSql("INSERT INTO "+TBL_NAME+" VALUES(null, 'Chi tiết bài băng 1', 'R.drawable.product1')");
        }
    }

    public boolean insertData(String content, int image){
        try{
            SQLiteDatabase db=getWritableDatabase();
            String sql="INSERT INTO "+TBL_NAME+" VALUES(null, ?, ?)";
            SQLiteStatement statement=db.compileStatement(sql);
            statement.bindString(1,content);
            statement.bindDouble(3,image);
            statement.executeInsert();
            return true;
        }catch(Exception e){
            return false;
        }

    }
}
