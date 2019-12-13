package com.ben.duan1_shop.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ben.duan1_shop.Database.DatabaseHelper;


public class UserDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "User";
   // public static final String SQL_User = "Create table User(username text primary key, password text, fullname text)";
    public static final String TAG = "UserDAO";

    public UserDAO (Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public  boolean insert (String username, String password){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        //long ins = db.insert("User",null,contentValues);
        if (db.insert(TABLE_NAME,null,contentValues)==-1) return false;
        else return true;
    }

    public boolean checkuser (String username){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from User where username=?",new String[]{username});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public boolean checklogin (String username, String password){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from User where username=? and password=?",new String[]{username,password});
        if (cursor.getCount()>0) return true;
        else return false;
    }
}
