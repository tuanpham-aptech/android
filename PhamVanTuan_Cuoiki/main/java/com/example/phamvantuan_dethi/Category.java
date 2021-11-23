package com.example.phamvantuan_dethi;

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

public class Category extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ed1 = findViewById(R.id.category);
        ed2 = findViewById(R.id.quantity);
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
                Intent i = new Intent(Category.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void insert(){
        try{
            String category = ed1.getText().toString();
            String qtyy = ed2.getText().toString();
            // tạo csdl là superpos
            SQLiteDatabase db = openOrCreateDatabase("superposs", Context.MODE_PRIVATE,null);
            //
            db.execSQL("CREATE TABLE IF NOT EXISTS category(id INTEGER PRIMARY KEY AUTOINCREMENT,category VARCHAR, qty VARCHAR)");

            // tạo câu truy vấn
            String sql = "insert into category (category,qty) values(?,?)";
            // truy vấn
            SQLiteStatement statement = db.compileStatement(sql);
            // chuẩn bị
            statement.bindString(1,category);
            statement.bindString(2,qtyy);
            // lưu vào database
            statement.execute();
            //Hiển thị kết quả thành công k
            Toast.makeText(this,"Thêm thành công danh mục ",Toast.LENGTH_LONG).show();
            // sau đó huỷ dữ liệu về rỗng
            ed1.setText("");
            ed2.setText("");
            ed1.requestFocus();
        }catch(Exception ex){
            Toast.makeText(this,"Thêm danh mục thất bại  ",Toast.LENGTH_LONG).show();
        }
    }
}