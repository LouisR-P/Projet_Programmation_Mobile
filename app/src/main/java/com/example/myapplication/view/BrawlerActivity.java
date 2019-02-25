package com.example.myapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class BrawlerActivity extends AppCompatActivity {

    private static final String TAG = "BrawlerActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brawler);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("brawler_nom") && getIntent().hasExtra("brawler_rarete") && getIntent().hasExtra("brawler_image3d")) {
            String brawlerNom = getIntent().getStringExtra("brawler_nom");
            String brawlerRarete = getIntent().getStringExtra("brawler_rarete");
            String brawlerImage3D = getIntent().getStringExtra("brawler_image3d");
            setBrawlerInfo(brawlerNom, brawlerRarete, brawlerImage3D);

        }
    }

    private void setBrawlerInfo(String brawlerNom, String brawlerRarete, String brawlerImage3D) {

        TextView nom = findViewById(R.id.brawler_nom);
        nom.setText(brawlerNom);

        TextView rarete = findViewById(R.id.brawler_rarete);
        rarete.setText(brawlerRarete);

        ImageView image = findViewById(R.id.brawler_image3d);
        Glide.with(this).asBitmap().load(brawlerImage3D).into(image);
    }
}