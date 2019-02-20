package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.myapplication.model.Brawlers;
import com.example.myapplication.model.RestBrawlstarsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        // Ici on créé les objets nécessaire et on les set ensuite.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                 // Permet d'afficher le design défini par le fichier main_activity.xml (chaque activité a besoin d'un design)
        recyclerView = findViewById(R.id.my_recycler_view);     // On instancie le notre recyclerView
        // use this setting to                                  // findViewById permet de retourner la vue associer à l'id donner en paramètre
        // improve performance if you know that changes         // L'id donnée est ici notre recyclerView défini dans notre fichier activity_main.xml
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);

        controller = new MainController(this);
        controller.onStart();

    }


    public void showList(List<Brawlers> input){
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);  // On défini notre layoutManager (qui permet d'organiser notre écran) (linéaire ici car notre liste est linéaire, on peut aussi par exemple utiliser GridLayoutManager pour organiser notre écran sous forme de tableau).
        recyclerView.setLayoutManager(layoutManager);          // On set notre layoutManager précédemment défini.
        // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

}