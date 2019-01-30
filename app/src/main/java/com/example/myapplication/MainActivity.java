package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private IngredientAdapter ingredientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On initialise notre liste de données
        List<Ingredient> listeCourse = new ArrayList<>();
        listeCourse.add(new Ingredient("Orange","4"));
        listeCourse.add(new Ingredient("Tomate","2"));
        listeCourse.add(new Ingredient("Raisin","Une grappe"));
        listeCourse.add(new Ingredient("Pain","1/2"));
        listeCourse.add(new Ingredient("Banane","2 ou 3"));
        listeCourse.add(new Ingredient("Kiwi","2 ou 3"));
        listeCourse.add(new Ingredient("Pates","500g"));
        listeCourse.add(new Ingredient("Raviolis","Une boîte"));
        listeCourse.add(new Ingredient("Fraises","500g"));
        listeCourse.add(new Ingredient("Glace","1L"));
        listeCourse.add(new Ingredient("Pizza","1"));
        listeCourse.add(new Ingredient("Yaourts","6"));
        listeCourse.add(new Ingredient("Riz","1kg"));
        listeCourse.add(new Ingredient("Haricots","500g"));
        listeCourse.add(new Ingredient("Nuggets","15"));
        listeCourse.add(new Ingredient("Frites","1kg"));
        listeCourse.add(new Ingredient("Eau","5L"));

        // On récupère notre RecyclerView via son id
        recyclerView=findViewById(R.id.ingredient_recyclerview);

        // On veut un RecyclerView qui utilise un LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // On donne notre adapter à notre RecyclerView
        ingredientAdapter = new IngredientAdapter(listeCourse);
        recyclerView.setAdapter(ingredientAdapter);

        // On sépare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
