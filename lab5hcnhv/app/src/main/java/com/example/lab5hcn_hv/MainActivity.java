package com.example.lab5hcn_hv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHCN,btnHV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHCN = (Button) findViewById(R.id.btnhcn);
        btnHV = (Button) findViewById(R.id.btnhv);
        btnHCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hcn = new Intent(MainActivity.this,Hinhchunhat.class);
                startActivity(hcn);
            }
        });
        btnHV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hv = new Intent(MainActivity.this,Hinhvuong.class);
                startActivity(hv);
            }
        });
    }
}