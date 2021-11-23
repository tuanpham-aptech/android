package com.example.app_ecomerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BrandEdit extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_edit);
        ed1 = findViewById(R.id.brandid);
        ed2 = findViewById(R.id.brand);
        ed3 = findViewById(R.id.branddesc);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        // nhận dữ liệu từ màn CategoryView truyền sang
        Intent i = getIntent();
        String id = i.getStringExtra("id").toString();
        String brand = i.getStringExtra("brand").toString();
        String des = i.getStringExtra("branddes").toString();
        // Hiển thị
        ed1.setText(id);
        ed2.setText(brand);
        ed3.setText(des);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Delete();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit();
            }
        });
    }
    public void Edit(){
        try{
            String brandid = ed1.getText().toString();
            String brandname = ed2.getText().toString();
            String branddescriptionn = ed3.getText().toString();
            // tạo csdl là superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

            // tạo câu truy vấn
            String sql = "update brand set brand = ?, branddes = ? where id = ?";
            // truy vấn
            SQLiteStatement statement = db.compileStatement(sql);
            // chuẩn bị
            statement.bindString(3,brandid);
            statement.bindString(1,brandname);
            statement.bindString(2,branddescriptionn);

            // lưu vào database
            statement.execute();
            //Hiển thị kết quả thành công k
            Toast.makeText(this,"Cập nhật thành công thương hiệu ",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),Main.class);
            startActivity(i);
        }catch(Exception ex){
            Toast.makeText(this,"Thêm thương hiệu thất bại  ",Toast.LENGTH_LONG).show();
        }
    }
    public void Delete(){
        try{
            String brandid = ed1.getText().toString();
            // tạo csdl là superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
            // tạo câu truy vấn
            String sql = "delete from brand where id = ?";
            // truy vấn
            SQLiteStatement statement = db.compileStatement(sql);
            // chuẩn bị
            statement.bindString(1,brandid);
            // lưu vào database
            statement.execute();
            //Hiển thị kết quả thành công k
            Toast.makeText(this,"Xoá thành công thương hiệu ",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),Main.class);
            startActivity(i);
        }catch(Exception ex){
            Toast.makeText(this,"Xoá thương hiệu  thất bại  ",Toast.LENGTH_LONG).show();
        }
    }
}