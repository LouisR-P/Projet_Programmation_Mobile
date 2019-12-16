package com.example.myapplication.view;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.example.myapplication.controller.MainController;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        // Ici on créé les objets nécessaire et on les set ensuite.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Permet d'afficher le design défini par le fichier main_activity.xml (chaque activité a besoin d'un design)
        controller = new MainController(this);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new BrawlersFragment()).commit();
        controller.onStart();

        //Bottom navigation bar
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //Permet de désactiver les couleurs par défaut de la bottom navigation bar et ainsi appliquer nos couleurs perso avec les selector (drawable)
        bottomNav.setItemIconTintList(null);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.brawlers_list:
                    selectedFragment = new BrawlersFragment();
                    break;
                case R.id.ranking_list:
                    selectedFragment = new FastFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;
        }
    };

}