package com.recip.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.recip.R;
import com.recip.models.Recent;
import com.recip.ui.fragments.home.HomeFragment;
import com.recip.ui.viewholders.RecentViewHolder;

import java.util.ArrayList;

public class RecentRecyclerViewAdapter extends RecyclerView.Adapter<RecentViewHolder> {
    Context context;
    ArrayList<Recent> recentArrayList;

    public RecentRecyclerViewAdapter(Context context, ArrayList<Recent> recentArrayList) {
        this.context = context;
        this.recentArrayList = recentArrayList;
    }

    @NonNull
    @Override
    public RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.recent_item, parent, false);
        context = parent.getContext();
        return new RecentViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentViewHolder holder, int position) {
        Recent recent = recentArrayList.get(position);
        Glide.with(context)
                .load(recent.getImageUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.iVRecent);
        holder.tVRecentTitle.setText(recent.getTitle());
        holder.tVRecentDescription.setText(recent.getDescription());

    }

    @Override
    public int getItemCount() {
        return recentArrayList.size();
    }
}
