package com.example.lab5hcn_hv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Xulyhinhvuong extends AppCompatActivity {
    private Button chuvi, dientich;
    private int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xulyhinhvuong);
        final TextView textView= findViewById(R.id.textView);
        // Lấy intent của Activity này
        Intent intent = getIntent();
        // lấy Bundle với tên giao dịch là "GoiTin"
        Bundle bundle = intent.getBundleExtra("GoiTin");
        // lấy giá trị kiểu nguyên với tên giao dịch là Canh
        a = bundle.getInt("Canh");
        textView.setText("Đã nhận được dữ liệu " + a );
        chuvi = (Button) findViewById(R.id.btChuVi);
        dientich = (Button) findViewById(R.id.btDienTich);
        dientich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == dientich) {
                    sendToMain((a * a), Hinhvuong.DIENTICH);
                }
            }
            public void sendToMain(int value, int resultcode) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("KetQua", value);
                intent.putExtra("TapTin", bundle);
                setResult(resultcode, intent); // phương thức này sẽ trả kết quả cho HVActivity
                finish(); // Đóng Activity hiện tại
            }

        });
        chuvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == chuvi) {
                    sendToMain(4 * a, Hinhvuong.CHUVI);
                }
            }
            public void sendToMain(int value, int resultcode) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("KetQua", value);
                intent.putExtra("TapTin", bundle);
                setResult(resultcode, intent); // phương thức này sẽ trả kết quả cho HVActivity
                finish(); // Đóng Activity hiện tại
            }

        });

    }
}