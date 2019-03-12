package com.example.myapplication.controller;

import android.util.Log;

import com.example.myapplication.RestBrawlstarsApi;
import com.example.myapplication.model.Brawlers;
import com.example.myapplication.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {   // Architecture MVC -> Contrôlleur (contient la logique concernant les actions effectuées par l'utilisateur)

    private MainActivity activity;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){
        // appel serveur API (action utilisateur quand il lance l'application)
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://bridge.buddyweb.fr/api/brawlstars/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        RestBrawlstarsApi restBrawlstarsApi = retrofit.create(RestBrawlstarsApi.class);

        Call<List<Brawlers>> call = restBrawlstarsApi.getListBrawlers();
        call.enqueue(new Callback<List<Brawlers>>() {
            @Override
            public void onResponse(Call<List<Brawlers>> call, Response<List<Brawlers>> response) {
                List<Brawlers> listBrawlers = response.body();
                activity.showList(listBrawlers);
            }

            @Override
            public void onFailure(Call<List<Brawlers>> call, Throwable t) {
                Log.d("ERROR","Api Error");
            }
        });

    }

}
