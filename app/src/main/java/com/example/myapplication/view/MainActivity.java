package com.example.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.example.myapplication.controller.MainController;
import com.example.myapplication.controller.MyAdapter;
import com.example.myapplication.model.Brawler;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter mAdapter;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        // Ici on créé les objets nécessaire et on les set ensuite.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                 // Permet d'afficher le design défini par le fichier main_activity.xml (chaque activité a besoin d'un design)

      //  ImageView brawlstarsImage = (ImageView) findViewById(R.id.imageBrawlStars) ;        // image brawlstars header
        int imageResource = getResources().getIdentifier("@drawable/brawlstars",null,this.getPackageName());
        //brawlstarsImage.setImageResource(imageResource);

        recyclerView = findViewById(R.id.my_recycler_view);     // On instancie le notre recyclerView
        // use this setting to                                  // findViewById permet de retourner la vue associer à l'id donner en paramètre
        // improve performance if you know that changes         // L'id donnée est ici notre recyclerView défini dans notre fichier activity_main.xml
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Brawlers");

        toolbar.inflateMenu(R.menu.menu_main);

        controller = new MainController(this);
        controller.onStart();

    }


    public void showList(List<Brawler> input){
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);  // On défini notre layoutManager (qui permet d'organiser notre écran) (linéaire ici car notre liste est linéaire, on peut aussi par exemple utiliser GridLayoutManager pour organiser notre écran sous forme de tableau).
        recyclerView.setLayoutManager(layoutManager);          // On set notre layoutManager précédemment défini.
        // define an adapter
        mAdapter = new MyAdapter(input, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mAdapter.getFilter().filter(s);
                return true;
            }
        });
    }
}