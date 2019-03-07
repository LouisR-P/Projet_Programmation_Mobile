package com.example.myapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Brawlers;
import com.google.gson.Gson;

public class BrawlerActivity extends AppCompatActivity {

    private static final String TAG = "BrawlerActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brawler);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
            String json = getIntent().getStringExtra("brawler_json");

            Gson gson = new Gson();
            Brawlers brawlers = gson.fromJson(json, Brawlers.class);

            setBrawlerInfo(brawlers.getNom(), brawlers.getRarete(), brawlers.getImage3d());

        }

    private void setBrawlerInfo(String brawlerNom, String brawlerRarete, String brawlerImage3D) {

        TextView nom = findViewById(R.id.brawler_nom);
        nom.setText(brawlerNom);

        TextView rarete = findViewById(R.id.brawler_rarete);

        ImageView background = findViewById(R.id.background);

        if (brawlerRarete.equals("Commun")){
            background.setImageResource(R.drawable.commun);
        }
        else if (brawlerRarete.equals("Rare")){
            background.setImageResource(R.drawable.rare);
        }
        else if (brawlerRarete.equals("Super rare")){
            background.setImageResource(R.drawable.superrare);
        }
        else if (brawlerRarete.equals("Épique")){
            background.setImageResource(R.drawable.epique);
        }
        else if (brawlerRarete.equals("Mythique")){
            background.setImageResource(R.drawable.mythique);
        }
        else if (brawlerRarete.equals("Légendaire")){
            background.setImageResource(R.drawable.legendaire);
        }

        rarete.setText(brawlerRarete);

        ImageView image = findViewById(R.id.brawler_image3d);
        Glide.with(this).asBitmap().load(brawlerImage3D).into(image);

    }
}