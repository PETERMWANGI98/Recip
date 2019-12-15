package com.recip.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.models.Menu;
import com.recip.ui.viewholders.MenuViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private static final String TAG = "MenuAdapter";
    Context context;
    ArrayList<Menu> menuArrayList;

    public MenuAdapter(Context context, ArrayList<Menu> menuArrayList) {
        this.context = context;
        this.menuArrayList = menuArrayList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.top_menu_item, parent, false);
        context = parent.getContext();
        return new MenuViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = menuArrayList.get(position);
        Picasso.get()
                .load(menu.getImageUrl())
                .into(holder.mImageView);
        holder.mTitle.setText(menu.getTitle());

    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }
}
