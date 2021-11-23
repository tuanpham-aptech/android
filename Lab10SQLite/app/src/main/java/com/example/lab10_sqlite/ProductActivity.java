package com.example.lab10_sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    ListView listView;
    List<Products> dataList = new ArrayList<>();
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        DBHelper.getInstance(this);
        listView = findViewById(R.id.listView);
        // tạo dữ liệu
        dataList = ProductModify.getProductList();
        productAdapter = new ProductAdapter(this,dataList);
        listView.setAdapter(productAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_product_app,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mna_add_pro:
                showProductDialog();
                break;
            case R.id.mna_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showProductDialog() {
        View v = LayoutInflater.from(this).inflate(R.layout.dialog_product,null);
        EditText tieude  = v.findViewById(R.id.ed_title);
        EditText mota  = v.findViewById(R.id.ed_des);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(v);
        builder.setPositiveButton("Lưu lại ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ProductActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                String title = tieude.getText().toString();
                String des = mota.getText().toString();
                Products pro = new Products(title,des);
                dataList.add(pro);
                productAdapter.notifyDataSetChanged();
                ProductModify.insert(pro);
            }
        }).setNegativeButton("Diss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ProductActivity.this,"Exit",Toast.LENGTH_LONG).show();
            }
        }).show();
    }
}