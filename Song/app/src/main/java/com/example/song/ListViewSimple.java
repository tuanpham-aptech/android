package com.example.song;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.song.databinding.ActivityListViewSimpleBinding;

import java.util.ArrayList;

public class ListViewSimple extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<>();// add tên bài hát
    ListView listView;
    MediaPlayer mp;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       data.add("nhac");
       data.add("bai1");
       listView = findViewById(R.id.lvsimple);
       arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch((int) id){
                   case 0:

               }
           }
       });
       public boolean onContextItemSelect(MenuItem item){
           int id = item.getItem
        }
    }
}