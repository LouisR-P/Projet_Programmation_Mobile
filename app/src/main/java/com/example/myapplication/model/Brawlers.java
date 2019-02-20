package com.example.myapplication.model;

import android.media.Image;

public class Brawlers {

    private String nom;
    private String rarete;
    private String pointsDeVie;
    private String degats_attaque_primaire;
    private String degats_attaque_super;
    private String vitesse;
    private String description;
    private Image image;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRarete() {
        return rarete;
    }

    public void setRarete(String rarete) {
        this.rarete = rarete;
    }

    public String getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(String pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public String getDegats_attaque_primaire() {
        return degats_attaque_primaire;
    }

    public void setDegats_attaque_primaire(String degats_attaque_primaire) {
        this.degats_attaque_primaire = degats_attaque_primaire;
    }

    public String getDegats_attaque_super() {
        return degats_attaque_super;
    }

    public void setDegats_attaque_super(String degats_attaque_super) {
        this.degats_attaque_super = degats_attaque_super;
    }

    public String getVitesse() {
        return vitesse;
    }

    public void setVitesse(String vitesse) {
        this.vitesse = vitesse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
