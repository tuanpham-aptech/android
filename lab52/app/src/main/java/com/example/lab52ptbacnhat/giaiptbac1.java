package com.example.lab52ptbacnhat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class giaiptbac1 extends AppCompatActivity {
    EditText nhapa, nhapb;
    Button btngiai;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaiptbac1);
        nhapa = (EditText) findViewById(R.id.nhapa);
        nhapb = (EditText) findViewById(R.id.nhapb);
        kq = (TextView) findViewById(R.id.textView);
        btngiai = (Button) findViewById(R.id.btngiai);
        nhapa.setText(AppUnti.mnhapa);
        nhapb.setText(AppUnti.mnhapb);
        btngiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float a=Float.parseFloat(nhapa.getText().toString());
                    float b =Float.parseFloat(nhapb.getText().toString());
                    float c = -b/a;
                    if(a==0){
                        if(b==0)
                            kq.setText("phương trình vô số nghiệm");
                        else kq.setText("phương trình vô nghiệm");
                    } else kq.setText(String.valueOf(c));

                }catch (NumberFormatException e){
                    kq.setText("dữ liệu không đúng");
                }
                backactivity();
            }

            private void backactivity() {
                String trnhapaUpdate=nhapa.getText().toString().trim();
                AppUnti.mnhapa=trnhapaUpdate;
                finish();
                String trnhapbUpdate=nhapb.getText().toString().trim();
                AppUnti.mnhapb=trnhapbUpdate;
                finish();
                String trkaUpdate=kq.getText().toString().trim();
                AppUnti.mkq=trkaUpdate;
                finish();
            }
        });
    }
}