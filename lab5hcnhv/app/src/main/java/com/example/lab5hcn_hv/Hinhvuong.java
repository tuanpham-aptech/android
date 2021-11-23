package com.example.lab5hcn_hv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hinhvuong extends AppCompatActivity {
    public static final int CHUVI = 1;
    public static final int DIENTICH = 2;
    public static final int HINHVUONG = 1;
    private EditText etA;
    private TextView tvResult;
    private Button btnhv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinhvuong);
        etA = (EditText) findViewById(R.id.etcanhA);
        tvResult = (TextView) findViewById(R.id.tvResult1);
        btnhv = findViewById(R.id.btnhvuong);
        btnhv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // nạp Class XulyHVactivity vào intent.
                // Đối thứ nhất là context của Activity hiện tại, đối thứ hai là tên Class chứa Activity sẽ được gọi
                Intent intent = new Intent(Hinhvuong.this,Xulyhinhvuong.class);
                int a = Integer.valueOf(etA.getText().toString());
                // Truyền dữ liệu giữa hai Activity ta sử dụng đối tượng Bundle để chứa các dữ liệu.
                Bundle bundle = new Bundle();
                bundle.putInt("Canh", a); // Canh là tên giao dịch
                intent.putExtra("GoiTin", bundle);
// hàm gọi này sẽ có kết quả trả về do đó ta phải @OVerride phương thức onActivityResult
// gọi activity đồng thời truyền dữ liệu với định danh là DIENTICH
                startActivityForResult(intent, HINHVUONG);
// Có thể ta sẽ gọi nhiều Activity nên bắt buộc phải có định danh riêng cho mỗi Activity
// Phương thức này được gọi khi Activity con trả về kết quả
            }
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                if(data == null){
                    return;
                }
// Nếu định danh lúc gửi là HINHVUONG
                if (requestCode == HINHVUONG) {
                    // lấy giá trị kết quả
                    Bundle bundle = data.getBundleExtra("TapTin");
                    int kq = bundle.getInt("KetQua");
                    // nếu dữ liệu trả về có định danh là CHUVI
                    if(resultCode == CHUVI){
                        tvResult.setText("Chu vi hình vuông là: " + kq );
                    }
                    if(resultCode == DIENTICH){
                        tvResult.setText("Diện tích hình vuông là: " + kq );
                    }
                }
            }
        });

    }
}