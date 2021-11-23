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

public class CategoryEdit extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryedit);
        ed1 = findViewById(R.id.catid);
        ed2 = findViewById(R.id.category);
        ed3 = findViewById(R.id.categorydesc);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        // nhận dữ liệu từ màn CategoryView truyền sang
        Intent i = getIntent();
        String id = i.getStringExtra("id").toString();
        String category = i.getStringExtra("category").toString();
        String des = i.getStringExtra("catdes").toString();
        // Hiển thị
        ed1.setText(id);
        ed2.setText(category);
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
            String catid = ed1.getText().toString();
            String categoryname = ed2.getText().toString();
            String categorydescriptionn = ed3.getText().toString();
            // tạo csdl là superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

            // tạo câu truy vấn
            String sql = "update category set category = ?, catdes = ? where id = ?";
            // truy vấn
            SQLiteStatement statement = db.compileStatement(sql);
            // chuẩn bị
            statement.bindString(1,categoryname);
            statement.bindString(2,categorydescriptionn);
            statement.bindString(3,catid);
            // lưu vào database
            statement.execute();
            //Hiển thị kết quả thành công k
            Toast.makeText(this,"Cập nhật thành công danh mục ",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),Main.class);
            startActivity(i);
        }catch(Exception ex){
            Toast.makeText(this,"Thêm danh mục thất bại  ",Toast.LENGTH_LONG).show();
        }
    }
    public void Delete(){
        try{
            String catid = ed1.getText().toString();
            // tạo csdl là superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
            // tạo câu truy vấn
            String sql = "delete from category where id = ?";
            // truy vấn
            SQLiteStatement statement = db.compileStatement(sql);
            // chuẩn bị
            statement.bindString(1,catid);
            // lưu vào database
            statement.execute();
            //Hiển thị kết quả thành công k
            Toast.makeText(this,"Xoá thành công danh mục ",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),Main.class);
            startActivity(i);
        }catch(Exception ex){
            Toast.makeText(this,"Xoá mục thất bại  ",Toast.LENGTH_LONG).show();
        }
    }
}