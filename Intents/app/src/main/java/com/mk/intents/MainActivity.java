package com.mk.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button calling,callist,viewcontact,viewList,view,search,massage,googlemap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        calling = findViewById(R.id.dial);
        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0379679502"));
                startActivity(i);
            }
        });
        callist =findViewById(R.id.view);
        callist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_EDIT,Uri.parse("content://contacts/people/2"));
                startActivity(i);
            }
        });
        viewcontact =findViewById(R.id.view1);
        viewcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/2"));
                startActivity(i);
            }
        });
        viewList =findViewById(R.id.view2);
        viewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/2"));
                startActivity(i);
            }
        });
        view =findViewById(R.id.view3);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/2"));
                startActivity(i);
            }
        });
        view =findViewById(R.id.view3);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/2"));
                startActivity(i);
            }
        });
        search =(Button)findViewById(R.id.view4);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                i.putExtra(SearchManager.QUERY,"anh hung pham");
                startActivity(i);
            }
        });
        massage =(Button)findViewById(R.id.view5);
       massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:0379679501 "));
                i.putExtra("sms_body","GUI EM ");
                startActivity(i);
            }
        });
        googlemap =(Button)findViewById(R.id.view6);
        String geocode = "geo:41.5020952,-81.6789717";
        googlemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEARCH,Uri.parse(geocode));
                startActivity(i);
            }
        });


    }
}