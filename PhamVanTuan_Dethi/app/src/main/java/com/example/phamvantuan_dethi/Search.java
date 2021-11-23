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

public class Search extends AppCompatActivity {
    EditText ed1;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1 = findViewById(R.id.search);
        b1 = findViewById(R.id.btn);
        b2 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void search(){
        String cats = ed1.getText().toString();
        // tạo csdl là superpos
        SQLiteDatabase db = openOrCreateDatabase("superposs", Context.MODE_PRIVATE,null);
        // tạo câu truy vấn
        String sql = "select *from category where category = ?";
        // truy vấn
        SQLiteStatement statement = db.compileStatement(sql);
        statement.execute();
        if(statement !=null) {
            Toast.makeText(this, "Có tên danh mục " + cats + "", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Không Có tên danh mục " + cats + "", Toast.LENGTH_LONG).show();
        }
    }

}