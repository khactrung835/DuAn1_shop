package com.ben.duan1_shop.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbShop";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) { super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Admin(username text not null primary key , password text not null, fullname text)");
        db.execSQL("Insert into Admin(username, password,fullname) values ('Trung','trung','Nguyễn Khắc Trung')");
        db.execSQL("Insert into Admin(username, password,fullname) values ('Duy','duy','Khương Duy')");
        db.execSQL("Insert into Admin(username, password,fullname) values ('Vu','vu','Trần Anh Vũ')");
        db.execSQL("Create table User(username text not null primary key, password text not null, fullname text)");
        db.execSQL("Create table HoaDon(mahd integer primary key autoincrement, ngayxuathd date not null, tien integer )");
        db.execSQL("Create table HoaDonChiTiet(mahdct integer primary key autoincrement,soluong integer,mahd integer, foreign key (mahd) references HoaDon (mahd) )");
        db.execSQL("Create table TheLoai(maloai integer not null primary key, ten text not null)");
        db.execSQL("create table SanPham (masp integer not null primary key, tensp text not null, gia integer, soluongton integer not null, maloai integer, foreign key (maloai) references TheLoai(maloai))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists Admin");
        db.execSQL("Drop table if exists User");
        db.execSQL("Drop table if exists HoaDon");
        db.execSQL("Drop table if exists HoaDonChiTiet");
        db.execSQL("Drop table if exists TheLoai");
        db.execSQL("Drop table if exists SanPham");


    }
}
