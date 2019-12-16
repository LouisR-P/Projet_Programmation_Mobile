package com.example.myapplication.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.myapplication.RestBrawlstarsApi;
import com.example.myapplication.model.Brawler;
import com.example.myapplication.view.FastFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Rappel Architecture MVC -> dossier Controller = contient la logique concernant les actions effectuées par l'utilisateur.

public class FastController {

    private FastFragment activity;
    private SharedPreferences sharedPreferences;

    public FastController(FastFragment rankingFragment) {
        this.activity = rankingFragment;
        this.sharedPreferences = activity.getContext().getSharedPreferences("1", Context.MODE_PRIVATE);
    }

    public void onStart() {
        // appel serveur API (action utilisateur quand il lance l'application)
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://bridge.buddyweb.fr/api/brawlstars/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        RestBrawlstarsApi restBrawlstarsApi = retrofit.create(RestBrawlstarsApi.class);
        if (!sharedPreferences.contains("1")) {
            Call<List<Brawler>> call = restBrawlstarsApi.getListBrawlers();
            call.enqueue(new Callback<List<Brawler>>() {
                @Override
                public void onResponse(Call<List<Brawler>> call, Response<List<Brawler>> response) {
                    List<Brawler> listBrawlers = response.body();
                    activity.showList(listBrawlers);
                    storeData(listBrawlers);
                }

                @Override
                public void onFailure(Call<List<Brawler>> call, Throwable t) {
                    Log.d("ERROR", "Api Error");
                }
            });

        } else {
            String str = sharedPreferences.getString("1", "null");
            Type listT = new TypeToken<List<Brawler>>(){}.getType();
            List<Brawler> brawlers = gson.fromJson(str, listT);
            activity.showList(brawlers);
        }
    }

    // Stockage en cache
    private void storeData(List<Brawler> listBrawlers) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listBrawlers);
        editor.putString("1", json);
        editor.apply();
    }

}
