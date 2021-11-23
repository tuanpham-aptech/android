package com.example.lab51ptbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class giaiptbac2 extends AppCompatActivity {
    EditText nhapa, nhapb, nhapc;
    Button btngiai;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaiptbac2);
        nhapa = (EditText) findViewById(R.id.nhapa);
        nhapb = (EditText) findViewById(R.id.nhapb);
        nhapc = (EditText) findViewById(R.id.nhapc);
        kq = (TextView) findViewById(R.id.textView);
        btngiai = (Button) findViewById(R.id.btngiai);
        nhapa.setText(AppUnti.mnhapa);
        nhapb.setText(AppUnti.mnhapb);
        nhapc.setText(AppUnti.mnhapc);
        btngiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try

                {

                    float a=Float.parseFloat(nhapa.getText().toString());
                    float b =Float.parseFloat(nhapb.getText().toString());
                    float c =Float.parseFloat(nhapc.getText().toString());
                    float d=(-c/b);
                    float delta = (b*b-4*a*c);
                    if (a == 0)

                    {

                        kq.setText("Phương trình bậc I:");

                        if (b == 0)

                        {

                            if (c == 0)

                                kq.setText(kq.getText() + "Phương trình có vô số nghiệm");

                            else

                                kq.setText(kq.getText() + "Phương trình vô nghiệm");

                        }

                        else

                        {

                            kq.setText(kq.getText() + "x = " + (-c/b));

                        }

                    }

                    else

                    {




                        if (delta < 0.0)

                        {

                            kq.setText("Phương trình vô nghiệm\n");

                        }

                        else

                        if (delta == 0)

                        {

                            kq.setText(String.valueOf(d));

                        }

                        else

                        {

                            float delta_sqrt = (float) Math.sqrt(delta);

                            kq.setText("x1 = " + ((b*b + delta_sqrt)/(2*a)) + "\n" + "x2 = " + ((b*b - delta_sqrt)/(2*a)) );

                        }
                    }
                }catch (Exception ex){
                    kq.setText(ex.toString());
                }
            }
        });
    }
}