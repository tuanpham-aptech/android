package com.example.lab52ptbacnhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nhapa,nhapb;
    Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nhapa=(EditText) findViewById(R.id.nhapa);
        nhapb=(EditText) findViewById(R.id.nhapb);
        btnsend=(Button)findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
            private void nextActivity() {
                String strnhapa=nhapa.getText().toString().trim();
                AppUnti.mnhapa=strnhapa;
                String strnhapb=nhapb.getText().toString().trim();
                AppUnti.mnhapb=strnhapb;
                Intent intent=new Intent(MainActivity.this,giaiptbac1.class);
                startActivity(intent);
            }
        });
    }
}