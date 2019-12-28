package com.recip.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.recip.Constants;
import com.recip.R;
import com.recip.models.Recipe;
import com.recip.ui.activities.MainActivity;
import com.recip.ui.fragments.details.DetailsFragment;
import com.recip.ui.viewholders.RecommendedViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedViewHolder> {

    private Context mContext;
    private ArrayList<Recipe> recipeRandomResponses;
    private FragmentManager fragmentManager;

    public RecommendedAdapter(Context mContext, ArrayList<Recipe> recipeRandomResponses, FragmentManager fragmentManager) {
        this.mContext = mContext;
        this.recipeRandomResponses = recipeRandomResponses;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.recommended_item, parent, false);
        return new RecommendedViewHolder(rootView);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull RecommendedViewHolder holder, int position) {
        Recipe recipe = recipeRandomResponses.get(position);
        final boolean[] isAddedToFavourites = {false};
        Picasso.get()
                .load(recipe.getImage())
                .into(holder.recommendedImageView);
        if (recipe.getDishTypes().size() != 0) {
            holder.recommendedType.setText(recipe.getDishTypes().get(0).toUpperCase());
        } else {
            holder.recommendedType.setText("Uncategorized");

        }
        holder.recommendedDuration.setText(String.format("%d Minutes .", recipe.getCookingMinutes()));
        holder.recommendedTitle.setText(recipe.getTitle());

        holder.recommendedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("recipe", Parcels.wrap(recipe));
                intent.setAction(Constants.MORE_TO_HOME_INTENT_IDENTIFIER);
                mContext.startActivity(intent);

            }
        });

        holder.iVAddToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAddedToFavourites[0]) {
                    holder.iVAddToFavourites.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Snackbar snackbar = Snackbar.make(v, recipe.getTitle() + " Added to favourites", Snackbar.LENGTH_LONG);
                    snackbar.setAction("UNDO", view -> {

                    });
                    snackbar.setActionTextColor(mContext.getResources().getColor(R.color.colorPrimary));
                    snackbar.show();

                    isAddedToFavourites[0] = true;

                } else {
                    holder.iVAddToFavourites.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Snackbar snackbar = Snackbar.make(v, recipe.getTitle() + " Removed from favourites", Snackbar.LENGTH_LONG);
                    snackbar.setAction("UNDO", view -> {

                    });
                    snackbar.setActionTextColor(mContext.getResources().getColor(R.color.colorPrimary));
                    snackbar.show();
                    isAddedToFavourites[0] = false;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeRandomResponses.size();
    }
}
