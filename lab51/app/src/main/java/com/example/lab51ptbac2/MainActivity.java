package com.example.lab51ptbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nhapa,nhapb,nhapc;
    Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nhapa=(EditText) findViewById(R.id.soa);
        nhapb=(EditText) findViewById(R.id.sob);
        nhapc=(EditText) findViewById(R.id.soc);
        btnsend=(Button)findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sonhapa = nhapa.getText().toString().trim();
                AppUnti.mnhapa = sonhapa;
                String sonhapb = nhapb.getText().toString().trim();
                AppUnti.mnhapb = sonhapb;
                String sonhapc = nhapc.getText().toString().trim();
                AppUnti.mnhapc = sonhapc;
                Intent intent =new Intent(MainActivity.this,giaiptbac2.class);
                startActivity(intent);
            }

        });
    }
}