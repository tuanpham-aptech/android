package com.example.cuoiki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtuser,edtpassword;
Button btndangky,btndangnhap,btnthoat;
String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
       ControlButton();
    }
    private void ControlButton(){
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //xu ly nut dang ky tao hop thoai
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hôp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dangky);//taoj hop thoaij xu ly dangky
                EditText edttk =(EditText)dialog.findViewById(R.id.edttk);
                EditText edtmk =(EditText)dialog.findViewById(R.id.edtmk);
                Button btnhuy =(Button)dialog.findViewById(R.id.buttonhuy);
                Button btndongy =(Button)dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     ten=edttk.getText().toString().trim();
                     mk=edtmk.getText().toString().trim();
                     edtuser.setText(ten);
                     edtpassword.setText(mk);
                     dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtuser.getText().length() !=0 && edtpassword.getText().length() !=0){
                    if(edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else if(edtuser.getText().toString().equals("phat") && edtpassword.getText().toString().equals("123")){
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thất bại ",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Mời bạn nhập lại thông tin ",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void Anhxa(){
        edtuser =(EditText)findViewById(R.id.edittextuser);
        edtpassword=(EditText)findViewById(R.id.editpassword);
        btndangnhap=(Button)findViewById(R.id.buttondangnhap);
        btndangky=(Button)findViewById(R.id.buttondangky);
        btnthoat= (Button)findViewById(R.id.thoat);
    }
}