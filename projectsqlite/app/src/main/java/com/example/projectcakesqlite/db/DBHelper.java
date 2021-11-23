package com.example.projectcakesqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "team3";
    private static final int DB_VERSION =1;
    private static DBHelper instance = null;
    public synchronized static DBHelper getInstance(Context context){
        if(instance == null){
            instance = new DBHelper(context);
        }
        return instance;
    }
    private DBHelper(Context context) {

        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // trường hợp gọi đến hàm này được cài đặt lần đầu tiên

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // trường hợp gọi đến hàm này
    }
}
