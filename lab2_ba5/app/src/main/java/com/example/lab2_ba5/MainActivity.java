package com.example.lab2_ba5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvHinhAnh;
    ArrayList<hinhAnh> arrayImage;
    HinhAnhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new HinhAnhAdapter(this,R.layout.hinhanh)
    }

    private void AnhXa() {
        gvHinhAnh = (GridView)  findViewById(R.id.gridviewHinhAnh);
        arrayImage = new ArrayList<>();
        arrayImage.add(new hinhAnh("Hinh1",R.drawable.ip1));
        arrayImage.add(new hinhAnh("Hinh2",R.drawable.ip2));
        arrayImage.add(new hinhAnh("Hinh3",R.drawable.ip3));
        arrayImage.add(new hinhAnh("Hinh4",R.drawable.ip4));
        arrayImage.add(new hinhAnh("Hinh5",R.drawable.ip5));
        arrayImage.add(new hinhAnh("Hinh6",R.drawable.ip6));
        arrayImage.add(new hinhAnh("Hinh7",R.drawable.ip7));

    }
}