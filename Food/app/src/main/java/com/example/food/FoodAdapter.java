package com.example.food;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    Activity activity;
    List<Food> foodList;

    public FoodAdapter(Activity activity, List<Food> foodList) {
        this.activity = activity;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View View, ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        View=layoutInflater.inflate(R.layout.item_food,null);
        ImageView image=View.findViewById(R.id.thump);
        TextView tieude=View.findViewById(R.id.name);
        TextView noidung=View.findViewById(R.id.info);
        TextView gia=View.findViewById(R.id.price);
        Food food = foodList.get(position);
        image.setImageResource(food.getId());
        tieude.setText(food.getTitle());
        noidung.setText(food.getContent());
        gia.setText(String.valueOf(food.getPrice()));
        return View;
    }
}
