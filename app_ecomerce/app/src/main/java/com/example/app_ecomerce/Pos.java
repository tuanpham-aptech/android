package com.example.app_ecomerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Pos extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b1,b2;
    ListView lst1;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos);

        ed1 = findViewById(R.id.pid);
        ed2 = findViewById(R.id.pname);
        ed3 = findViewById(R.id.proqty);
        ed4 = findViewById(R.id.proprice);
        ed5 = findViewById(R.id.total);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int pqty = Integer.parseInt(ed3.getText().toString());
                int price = Integer.parseInt(ed4.getText().toString());
                int tot = pqty * price;
                ed5.setText(String.valueOf(tot));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
    }
    public void insert(){
        try{
            String proid = ed1.getText().toString();
            String proname = ed2.getText().toString();
            int qty1 = Integer.parseInt(ed3.getText().toString().trim());
            String price = ed4.getText().toString();
            String totall = ed5.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("pos",Context.MODE_PRIVATE,null);
            String id = ed1.getText().toString();
            final Cursor c = db.rawQuery("select * from product where id ='"+id+"'",null);
            int qty = c.getColumnIndex("qty");
            final ArrayList<Productview1> product1 = new ArrayList<Productview1>();
            if(c.moveToFirst()){
                do{
                    Productview1 stu = new Productview1();
                    stu.qty = c.getString(qty);
                    product1.add(stu);
                    int oldqty = Integer.parseInt(c.getString(qty));
                }while(c.moveToNext());

                arrayAdapter.notifyDataSetChanged();
            }

        }catch (Exception ex){

        }
    }

    public void search(){
        SQLiteDatabase db = openOrCreateDatabase("pos", Context.MODE_PRIVATE,null);
        String id = ed1.getText().toString();
        final Cursor c = db.rawQuery("select *from product where id = '"+id+"'",null);
        int proname = c.getColumnIndex("proname");
        int qty = c.getColumnIndex("qty");
        int price = c.getColumnIndex("price");
        titles.clear();
        final ArrayList<Productview1> product1 = new ArrayList<Productview1>();
        if(c.moveToFirst()){
            do{
                Productview1 stu  = new Productview1();
//                stu.product = stu.getString(proname);
//                stu.qty = stu.getString(qty);
//                stu.price = stu.getString(price);
                product1.add(stu);
                ed2.setText(c.getString(proname));
                ed4.setText(c.getString(price));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
        }
    }

}