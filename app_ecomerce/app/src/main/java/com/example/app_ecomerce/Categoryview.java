package com.example.app_ecomerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Categoryview extends AppCompatActivity {
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryview);
        lst1 = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from category",null);
        int id = c.getColumnIndex("id");
        int category = c.getColumnIndex("category");
        int catdes = c.getColumnIndex("catdes");
        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final ArrayList<cate> catee = new ArrayList<cate>();
        if(c.moveToFirst()){
            do{
                cate ca = new cate();
                ca.id = c.getString(id);
                ca.category = c.getString(category);
                ca.des = c.getString(catdes);

                catee.add(ca);
                titles.add(c.getString(id) + "\t" + c.getString(category) + "\t" + c.getString(catdes));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }
        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String aaa =titles.get(position).toString();
                cate ca = catee.get(position);
                Intent i = new Intent(getApplicationContext(),CategoryEdit.class);
                // truyền dữ liệu qua mànn CategoryView
                i.putExtra("id",ca.id);// CÁC TRƯỜNG TRONG DATABASE id category catdes
                i.putExtra("category",ca.category);
                i.putExtra("catdes",ca.des);
                startActivity(i);

            }
        });
    }
}