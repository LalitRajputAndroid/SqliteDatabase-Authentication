package com.example.showdatalist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
    private static final String databasename = "mydatabase";
    private static final int version = 1;

    public Databasehelper(Context context) {
        super(context, databasename, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String quary = "create table userdata (id integer primary key autoincrement, user_name text, user_email text, userpassword text)";
        db.execSQL(quary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists userdata");
            onCreate(db);
    }
    public boolean insertdata(String name,String email,String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_name",name);
        values.put("user_email",email);
        values.put("userpassword",password);

        long in = database.insert("userdata",null,values);
        if (in==-1)
            return false;
        else
            return true;
    }
    public Cursor getdata(){
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        Cursor cursor = liteDatabase.rawQuery("select * from userdata ",null);
        return cursor;

    }
    public  boolean CheckEmailPassword(String email,String password)
    {
        SQLiteDatabase db= getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from userdata where user_email=? and userpassword=?",new String[]{email,password});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
