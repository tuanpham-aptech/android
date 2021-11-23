package com.example.lab6vd1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        final String arr[]={"Teo","Ty","Bin","Bo"};
        //2. Lấy đối tượng Listview dựa vào id
        ListView lv=(ListView) findViewById(R.id.list);
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Đưa Data source vào ListView
        lv.setAdapter(adapter);
        final TextView txt=(TextView) findViewById(R.id.txtselection);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //đối số arg2 là vị trí phần tử trong Data Source (arr)
                txt.setText("position :"+i+" ; value ="+arr[i]);
            }
        });
    }
}