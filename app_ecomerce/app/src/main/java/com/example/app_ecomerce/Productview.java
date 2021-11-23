package com.example.app_ecomerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Productview extends AppCompatActivity {
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        lst1 = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from product",null);
        int id = c.getColumnIndex("id");
        int product = c.getColumnIndex("product");
        int productdes = c.getColumnIndex("productdes");
        int category = c.getColumnIndex("category");
        int brand = c.getColumnIndex("brand");
        int qty = c.getColumnIndex("qty");
        int price = c.getColumnIndex("price");

        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final ArrayList<prod> produ = new ArrayList<prod>();
        if(c.moveToFirst()){
            do{
                prod pr = new prod();
                pr.id = c.getString(id);
                pr.product = c.getString(product);
                pr.productdes = c.getString(productdes);
                pr.category = c.getString(category);
                pr.brand = c.getString(brand);
                pr.qty = c.getString(qty);
                pr.price = c.getString(price);

                produ.add(pr);
                titles.add(c.getString(id) + "\t" + c.getString(product) + "\t"  +c.getString(productdes)+ "\t"  + c.getString(category) +"\t"+ c.getString(brand) + "\t" + c.getString(qty) +"\t"+ c.getString(price));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }
    }
}