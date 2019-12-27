package com.recip.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.models.IngredientsList;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientListAdapter extends RecyclerView.Adapter<IngredientListAdapter.IngredientListViewHolder> {
    private Context mContext;
    private ArrayList<IngredientsList> stringArrayList;

    public IngredientListAdapter(Context mContext, ArrayList<IngredientsList> stringArrayList) {
        this.mContext = mContext;
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public IngredientListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ingredients_list_item, parent, false);
        return new IngredientListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientListViewHolder holder, int position) {
        IngredientsList ingredientsList = stringArrayList.get(position);
        holder.ingredientsTitle.setText(ingredientsList.getmIngredientTitle());
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    class IngredientListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ingredientsTitle)
        TextView ingredientsTitle;

        IngredientListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
