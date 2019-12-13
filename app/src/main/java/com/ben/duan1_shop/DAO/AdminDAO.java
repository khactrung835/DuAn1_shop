package com.ben.duan1_shop.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ben.duan1_shop.Database.DatabaseHelper;


public class AdminDAO {

    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "Admin";
    public static final String TAG = "AdminDAO";

    public AdminDAO (Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public boolean checkadmin (String username, String password){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Admin where username=? and password=?",new String[]{username,password});
        Log.d("admin", "" + cursor.getCount());
        if (cursor.getCount()>0) return true;
        else return false;
    }
}
