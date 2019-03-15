package com.example.myapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Brawler;
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
            Brawler brawler = gson.fromJson(json, Brawler.class);

            setBrawlerInfo(brawler.getImage3d(), brawler.getNom(), brawler.getRarete(), brawler.getPointsDeVie(), brawler.getDegats_attaque_primaire(), brawler.getDegats_attaque_super(), brawler.getVitesse(), brawler.getDescription());

        }

    private void setBrawlerInfo(String brawlerImage3D, String brawlerNom, String brawlerRarete, String brawlerPointsDeVie, String brawlerDegatsAttaquePrimaire, String brawlerDegatsAttaqueSuper, String brawlerVitesse, String brawlerDescription) {

        // Image 3D du brawler
        ImageView image = findViewById(R.id.brawler_image3d);
        Glide.with(this).asBitmap().load(brawlerImage3D).into(image);

        // Nom du brawler
        TextView nom = findViewById(R.id.brawler_nom);
        nom.setText(brawlerNom);

        // Rareté du brawler
        TextView rarete = findViewById(R.id.brawler_rarete);
        rarete.setText(brawlerRarete);

        ImageView background = findViewById(R.id.background);   // Assignation du background de bonne couleur en fonction de la rareté du brawler.
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

        // Points de vie du brawler
        TextView points_de_vie = findViewById(R.id.brawler_points_de_vie);
        points_de_vie.setText("Points de vie  :     " + brawlerPointsDeVie);

        // Dégâts attaque primaire du brawler
        TextView degats_attaque_primaire = findViewById(R.id.brawler_degats_attaque_primaire);
        degats_attaque_primaire.setText("Dégâts attaque primaire  :     " + brawlerDegatsAttaquePrimaire);

        // Dégâts attaque super du brawler
        TextView degats_attaque_super = findViewById(R.id.brawler_degats_attaque_super);
        degats_attaque_super.setText("Dégâts attaque super  :       " + brawlerDegatsAttaqueSuper);

        // Vitesse du brawler
        TextView vitesse = findViewById(R.id.brawler_vitesse);
        vitesse.setText("Vitesse  :     " + brawlerVitesse);

        // Description du brawler
        TextView description = findViewById(R.id.brawler_description);
        description.setText("Description  :     " + brawlerDescription);

    }
}