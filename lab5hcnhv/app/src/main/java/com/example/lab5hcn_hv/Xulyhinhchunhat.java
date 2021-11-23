package com.example.lab5hcn_hv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Xulyhinhchunhat extends AppCompatActivity {
    private Button chuvi, dientich;
    private int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xulyhinhchunhat);
        final TextView textView =findViewById(R.id.textView);
        // Lấy intent của Activity này
        Intent intent = getIntent();
        // Lấy Bundle với tên giao dịch là "GoiTin"
        Bundle bundle = intent.getBundleExtra("GoiTin");
        // lấy giá trị kiểu nguyên với tên giao dịch là CanhDai
        a = bundle.getInt("CanhDai");
        // lấy giá trị kiểu nguyên với tên giao dịch là CanhRong
        b = bundle.getInt("CanhRong");
        textView.setText("Đã nhận được dữ liệu " + a + " và " + b);
        chuvi = (Button) findViewById(R.id.btChuVi);
        dientich = (Button) findViewById(R.id.btDienTich);
        chuvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gọi hàm gửi dữ liệu về Hinhchunhat
                if(view == chuvi) {
                    sendToMain(2 * (a + b), Hinhchunhat.CHUVI);
                }

            }
            // Hàm gửi dữ liệu về Hinhchunhat
            public void sendToMain(int value, int resultcode) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("KetQua", value);
                intent.putExtra("TapTin", bundle);
                // phương thức này sẽ trả kết quả cho Hinhchunhat
                setResult(resultcode, intent);
                finish(); // Đóng Activity hiện tại
            }

        });
        dientich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == dientich) {
                    sendToMain((a * b), Hinhchunhat.DIENTICH);
                }
            }
            public void sendToMain(int value, int resultcode) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("KetQua", value);
                intent.putExtra("TapTin", bundle);
                // phương thức này sẽ trả kết quả cho Hinhchunhat
                setResult(resultcode, intent);
                finish(); // Đóng Activity hiện tại
            }

        });

    }
}