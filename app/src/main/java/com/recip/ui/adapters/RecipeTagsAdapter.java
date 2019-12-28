package com.recip.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.recip.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeTagsAdapter extends RecyclerView.Adapter<RecipeTagsAdapter.RecipeTagsViewHolder> {
    Context mContext;
    ArrayList<String> stringArrayList;

    public RecipeTagsAdapter(Context mContext, ArrayList<String> stringArrayList) {
        this.mContext = mContext;
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public RecipeTagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tags_item, parent, false);
        return new RecipeTagsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeTagsViewHolder holder, int position) {
        String tagTitle = stringArrayList.get(position);
        holder.mChip.setText(tagTitle);
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    class RecipeTagsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.chipTag)
        Chip mChip;

        public RecipeTagsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
