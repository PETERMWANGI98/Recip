package com.recip.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.models.Recipe;
import com.recip.models.RecipeRandomResponse;
import com.recip.ui.viewholders.RecommendedViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedViewHolder> {

    private Context mContext;
    private ArrayList<Recipe> recipeRandomResponses;

    public RecommendedAdapter(Context mContext, ArrayList<Recipe> recipeRandomResponses) {
        this.mContext = mContext;
        this.recipeRandomResponses = recipeRandomResponses;
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
        Picasso.get()
                .load(recipe.getImage())
                .into(holder.recommendedImageView);
        if (recipe.getDishTypes().size()!=0) {
            holder.recommendedType.setText(recipe.getDishTypes().get(0).toUpperCase());
        }
        else {
            holder.recommendedType.setText("Uncategorized");

        }
        holder.recommendedDuration.setText(String.format("%d Minutes .", recipe.getCookingMinutes()));
        holder.recommendedTitle.setText(recipe.getTitle());
    }

    @Override
    public int getItemCount() {
        return recipeRandomResponses.size();
    }
}
