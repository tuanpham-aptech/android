package com.example.lab10_sqlite;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    // đổ dữ liệu lên
    Activity activity;
    List<Products> dataList;

    public ProductAdapter(ProductActivity productActivity, List<Products> dataList) {
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //load item lên listview
       view =  activity.getLayoutInflater().inflate(R.layout.item_product,null);
       Products pro = dataList.get(position);
        ImageView imageView = view.findViewById(R.id.in_thumnail);
        TextView title = view.findViewById(R.id.in_title);
        TextView des = view.findViewById(R.id.in_des);
        title.setText(pro.getTitle());
        des.setText(pro.getDes());
        return view;
    }


}
