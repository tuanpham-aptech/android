package com.mk.tholuan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = findViewById(R.id.button1);
        a = findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b ="May nhu tao ";
                a.setText(b);
//                View someView = findViewById(R.id.edit);
//                View root = someView.getRootView();
//                root.setBackgroundColor(color.red);

            }
        });

    }
}