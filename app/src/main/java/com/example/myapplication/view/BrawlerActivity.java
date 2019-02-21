package com.example.myapplication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

public class BrawlerActivity extends AppCompatActivity {

    private static final String TAG = "BrawlerActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brawler);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("brawler_description")){

            String brawlerName = getIntent().getStringExtra("brawler_description");

            setBrawlerName(brawlerName);
        }
    }

    private void setBrawlerName(String brawlerName){
        TextView name = findViewById(R.id.brawler_description);
        name.setText(brawlerName);
    }
}