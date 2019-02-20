package com.example.myapplication;

import com.example.myapplication.model.Brawlers;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestBrawlstarsApi {

    @GET("brawlers")
    Call<List<Brawlers>> getListBrawlers();

}

