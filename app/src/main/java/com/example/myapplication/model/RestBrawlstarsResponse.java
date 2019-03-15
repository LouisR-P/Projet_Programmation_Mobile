package com.example.myapplication.model;

import java.util.List;

public class RestBrawlstarsResponse {   // La réponse de l'API est la liste des brawlers avec leurs caractéristiques

    private List<Brawler> brawlers;

    public List<Brawler> getBrawlers() {
        return brawlers;
    }

    public void setBrawlers(List<Brawler> brawlers) {
        this.brawlers = brawlers;
    }
}
