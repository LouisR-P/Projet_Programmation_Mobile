package com.example.myapplication.model;

import java.util.List;

public class RestBrawlstarsResponse {   // La réponse de l'API est la liste des brawlers avec leurs caractéristiques

    private List<Brawlers> brawlers;

    public List<Brawlers> getBrawlers() {
        return brawlers;
    }

    public void setBrawlers(List<Brawlers> brawlers) {
        this.brawlers = brawlers;
    }
}
