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

public class Brandview extends AppCompatActivity {
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brandview);
        lst1 = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from brand",null);
        int id = c.getColumnIndex("id");
        int brand = c.getColumnIndex("brand");
        int branddes = c.getColumnIndex("branddes");
        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final ArrayList<bran> brann = new ArrayList<bran>();
        if(c.moveToFirst()){
            do{
                bran bra = new bran();
                bra.id = c.getString(id);
                bra.brand = c.getString(brand);
                bra.des = c.getString(branddes);

                brann.add(bra);
                titles.add(c.getString(id) + "\t" + c.getString(brand) + "\t" + c.getString(branddes));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }
        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String bbb =titles.get(position).toString();
                bran ba = brann.get(position);
                Intent i = new Intent(getApplicationContext(),BrandEdit.class);
                // truyền dữ liệu qua mànn CategoryView
                i.putExtra("id",ba.id);// CÁC TRƯỜNG TRONG DATABASE id category catdes
                i.putExtra("brand",ba.brand);
                i.putExtra("branddes",ba.des);
                startActivity(i);
            }
        });
    }
}