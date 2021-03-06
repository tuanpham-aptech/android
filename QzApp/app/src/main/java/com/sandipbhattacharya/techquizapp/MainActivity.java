package com.sandipbhattacharya.techquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        // Trong phương thức startGame (), tạo Ý định để khởi chạy Hoạt động StartGame
        Intent intent = new Intent(MainActivity.this, StartGame.class);
        startActivity(intent);
        // Finish MainActivity
        finish();
    }
}