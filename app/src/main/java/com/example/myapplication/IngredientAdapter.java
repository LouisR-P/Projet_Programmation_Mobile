package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    List<Ingredient> listeIngredient;

    public static class IngredientViewHolder extends RecyclerView.ViewHolder {

        TextView nom;
        TextView quantite;

        public IngredientViewHolder(View itemView) {    //ItemView est le LinearLayout complet (pas juste la ligne)
            super(itemView);
            nom = itemView.findViewById(R.id.nom);
            quantite = itemView.findViewById(R.id.quantite);
        }
    }

    public IngredientAdapter(List<Ingredient> listeIngredient) {
        this.listeIngredient = listeIngredient;
    }

    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ingredient, parent, false);
        IngredientViewHolder ingredientViewHolder = new IngredientViewHolder(view);
        return ingredientViewHolder;
    }

    @Override
    public void onBindViewHolder(IngredientViewHolder holder, int position) {   //Lien entre la data et le RecyclerView
        Ingredient ingredient = listeIngredient.get(position);
        holder.nom.setText(ingredient.getNom());                                //Ajoute le nom de l'ingrédient dont la position a été récupérée en argument dans la vue d'un item de la liste (IngredientViewHolder)
        holder.quantite.setText(ingredient.getQuantite());                      //Ajoute la quantité de l'ingrédient dont la position a été récupérée en argument dans la vue d'un item de la liste (IngredientViewHolder)
    }

    @Override
    public int getItemCount() {
        return listeIngredient.size();
    }

}
