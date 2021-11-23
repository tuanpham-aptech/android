package com.example.lab10_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductModify {
    public static final String SQL_CREATE_TABLE = "create table products (\n"+
            "id iteger primary key autoincrement,\n"+
            "title varchar(200),\n"+"thumnail varchar(200),\n"+"des text,\n"+");";
    public static void insert(Products pro){
        // ghi vào
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",pro.getTitle());
        contentValues.put("des",pro.getDes());
        sqLiteDatabase.insert("products",null,contentValues);
    }
    public static List<Products> getProductList(){
        List<Products> productsList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        String sql = "select *from products";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        while(cursor.moveToNext()){
            @SuppressLint("Range") Products products = new Products(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("title")),
                    cursor.getString(cursor.getColumnIndex("des")),
                    cursor.getString(cursor.getColumnIndex("thumnail")));
            productsList.add(products);
        }
        return productsList;
    }
    public static void delete(int id){
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("products","id="+id,null);
    }

}
