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
import com.recip.models.Menu;
import com.recip.ui.viewholders.MenuViewHolder;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    Context context;
    ArrayList<Menu> menuArrayList;

    public MenuAdapter(Context context, ArrayList<Menu> menuArrayList) {
        this.context = context;
        this.menuArrayList = menuArrayList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.recent_item, parent, false);
        context = parent.getContext();
        return new MenuViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = menuArrayList.get(position);
        Glide.with(context)
                .load(menu.getImageUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.iVRecent);
        holder.tVRecentTitle.setText(menu.getTitle());

    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }
}
