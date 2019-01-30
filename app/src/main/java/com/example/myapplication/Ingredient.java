package com.example.myapplication;

public class Ingredient {

    private String nom;
    private String quantite;

    public Ingredient(String nom, String quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public String getNom(){
        return nom;
    }

    public String getQuantite(){
        return quantite;
    }
}
