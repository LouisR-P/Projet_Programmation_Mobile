package com.example.myapplication;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.model.Brawlers;
import com.example.myapplication.view.BrawlerActivity;
import com.example.myapplication.view.MainActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Brawlers> listValues;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        //Constructeur
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }

    public void add(int position, Brawlers item) {
        listValues.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        listValues.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Brawlers> listValues,Context context) {
        this.listValues = listValues;
        this.context = context;
    }

    //viewHolder correspond à une cellule.
    // Create new views (invoked vy the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {    //instanciation du ViewHolder à partir de la vue xml de l'index (la ligne) en question et retourne le ViewHolder en variable de retour
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {   //binding entre les données récupérées et le contenu des TextViews (et de l'image bientôt) dans le ViewHolder
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Brawlers currentBrawler = listValues.get(position);

        final String nom = currentBrawler.getNom();
        holder.txtHeader.setText(nom);

        final String rarete = currentBrawler.getRarete();
        holder.txtFooter.setText(rarete);

        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, BrawlerActivity.class);
                intent.putExtra("brawler_description",nom + rarete);
                context.startActivity(intent);
            }
        });
    }

    // Retourne la taille de notre API (le nombre de brawlers différents ici)
    @Override
    public int getItemCount() {
        return listValues.size();
    }

}
