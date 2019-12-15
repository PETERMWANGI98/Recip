package com.recip.ui.adapters;

import android.content.Context;
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

import timber.log.Timber;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private static final String TAG = "MenuAdapter";
    ArrayList<Menu> menuArrayList;
    Context context;
    View rootView;

    public MenuAdapter(Context context, ArrayList<Menu> menuArrayList) {
        this.menuArrayList = menuArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        rootView = LayoutInflater.from(context).inflate(R.layout.top_menu_item, parent, false);
        return new MenuViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder=new MenuViewHolder(rootView);
        Menu menu = menuArrayList.get(position);
        Timber.e("onBindViewHolder: ".concat(menu.getTitle()));
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
