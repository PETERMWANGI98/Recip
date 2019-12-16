package com.recip.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private ArrayList<RecipeRandomResponse> recipeRandomResponses;

    public RecommendedAdapter(Context mContext, ArrayList<RecipeRandomResponse> recipeRandomResponses) {
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
        RecipeRandomResponse recipeRandomResponse = recipeRandomResponses.get(position);
        for (int i = 0; i < recipeRandomResponse.getRecipes().size(); i++) {
            Recipe recipe = recipeRandomResponse.getRecipes().get(i);
            Picasso.get()
                    .load(recipe.getImage())
                    .into(holder.recommendedImageView);
            holder.recommendedType.setText(String.format("%d Minutes .",recipe.getCookingMinutes()));
            holder.recommendedTitle.setText(recipe.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return recipeRandomResponses.size();
    }
}
