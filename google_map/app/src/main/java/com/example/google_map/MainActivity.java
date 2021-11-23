package com.example.google_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button btn;
    private TextView newSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        btn = findViewById(R.id.button);
        newSignin = findViewById(R.id.newSignin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(email.getText().toString(),pass.getText().toString());
            }
        });
    }
    private void check(String username, String password){
        if(username.equals("Admin") && password.equals("1111")){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(MainActivity.this,ThreeActivity.class);
            startActivity(intent);
        }
    }
}