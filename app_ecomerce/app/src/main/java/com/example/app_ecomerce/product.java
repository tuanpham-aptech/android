package com.example.app_ecomerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class product extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;
    Spinner sprinner,sprinner1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> titles1 = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    ArrayAdapter arrayAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ed1 = findViewById(R.id.product);
        ed2 = findViewById(R.id.productdesc);
        ed3 = findViewById(R.id.price);
        ed4 = findViewById(R.id.qty);
        sprinner = findViewById(R.id.catid);
        sprinner1 = findViewById(R.id.brandid);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(product.this,Main.class);
                startActivity(i);
            }
        });

        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from category",null);

        int category = c.getColumnIndex("category");
        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        sprinner.setAdapter(arrayAdapter);

        final ArrayList<cate> catee = new ArrayList<cate>();
        if(c.moveToFirst()){
            do{
                cate ca = new cate();
                ca.category = c.getString(category);
                catee.add(ca);
                titles.add(c.getString(category));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
        }

        final Cursor b = db.rawQuery("select * from brand",null);
        int brand = b.getColumnIndex("brand");
        titles1.clear();
        arrayAdapter1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles1);
        sprinner1.setAdapter(arrayAdapter1);
        final ArrayList<bran> brann = new ArrayList<bran>();
        if(b.moveToFirst()){
            do{
                bran ba = new bran();
                ba.brand = b.getString(brand);
                brann.add(ba);
                titles1.add(b.getString(brand));

            }while(b.moveToNext());

            arrayAdapter1.notifyDataSetChanged();
        }
    }

    public void insert(){
        try{
            String product = ed1.getText().toString();
            String productdescription = ed2.getText().toString();
            String category = sprinner.getSelectedItem().toString();
            String brand = sprinner1.getSelectedItem().toString();
            String qty = ed3.getText().toString();
            String price = ed4.getText().toString();

            // tạo csdl là superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
            //
            db.execSQL("CREATE TABLE IF NOT EXISTS product(id INTEGER PRIMARY KEY AUTOINCREMENT,product VARCHAR, productdes VARCHAR,category VARCHAR, brand VARCHAR,qty VARCHAR, price VARCHAR)");

            // tạo câu truy vấn
            String sql = "insert into product (product,productdes,category,brand,qty,price) values(?,?,?,?,?,?)";
            // truy vấn
            SQLiteStatement statement = db.compileStatement(sql);
            // chuẩn bị
            statement.bindString(1,product);
            statement.bindString(2,productdescription);
            statement.bindString(3,category);
            statement.bindString(4,brand);
            statement.bindString(5,qty);
            statement.bindString(6,price);
            // lưu vào database
            statement.execute();
            //Hiển thị kết quả thành công k
            Toast.makeText(this,"Thêm thành công sản phẩm  ",Toast.LENGTH_LONG).show();
            // sau đó huỷ dữ liệu về rỗng
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");

            ed1.requestFocus();
        }catch(Exception ex){
            Toast.makeText(this,"Sản phẩm chưa thêm vào database   ",Toast.LENGTH_LONG).show();
        }
    }
}