package com.example.lab5hcn_hv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hinhchunhat extends AppCompatActivity {
    public static final int CHUVI = 1;
    public static final int DIENTICH = 2;
    public static final int HINHCHUNHAT = 1;
     private EditText etA, etB;
     private TextView tvResult;
     private Button hinhchunhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinhchunhat);
        etA = (EditText) findViewById(R.id.etA);
        etB = (EditText) findViewById(R.id.etB);
        tvResult = (TextView) findViewById(R.id.tvResult);
        hinhchunhat = (Button) findViewById(R.id.btChuNhat);
        hinhchunhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hinhchunhat.this, Xulyhinhchunhat.class);
                int a = Integer.valueOf(etA.getText().toString());
                int b = Integer.valueOf(etB.getText().toString());
                // Truyền dữ liệu giữa hai Activity ta sử dụng đối tượng Bundle để chứa, đưa các dữ liệu vào Bundle
                Bundle bundle = new Bundle();
                bundle.putInt("CanhDai", a);
                bundle.putInt("CanhRong", b);
                intent.putExtra("GoiTin", bundle);
                startActivityForResult(intent, HINHCHUNHAT);
                // Có thể ta sẽ gọi nhiều Activity nên bắt buộc phải có định danh riêng cho mỗi Activity
            }
            // Phương thức này được gọi khi Activity con trả về kết quả @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                // requestCode là định danh khi gửi
                // resultCode là định danh của Activity khác gửi cho
                if(data == null){
                    return;
                }
                // Nếu định danh lúc gửi là HINHCHUNHAT
                if (requestCode == HINHCHUNHAT) {
                    // lấy giá trị kết quả
                    Bundle bundle = data.getBundleExtra("TapTin");
                    int kq = bundle.getInt("KetQua");
                    // nếu dữ liệu trả về có định danh là CHUVI
                    if(resultCode == CHUVI){
                        tvResult.setText("Chu vi hình Chữ nhật là: " + kq);
                    }
                    if(resultCode == DIENTICH){
                        tvResult.setText("Diện tích hình Chữ nhật là: " + kq );
                    }
                }
            }

        });
    }
}