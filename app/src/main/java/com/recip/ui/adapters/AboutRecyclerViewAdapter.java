package com.recip.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.models.About;
import com.recip.ui.activities.about.AboutUsActivity;
import com.recip.ui.viewholders.AboutViewHolder;

import java.util.ArrayList;

public class AboutRecyclerViewAdapter extends RecyclerView.Adapter<AboutViewHolder> {
    private AboutUsActivity context;
    private ArrayList<About> aboutArrayList;

    public AboutRecyclerViewAdapter(AboutUsActivity context, ArrayList<About> aboutArrayList) {
        this.context = context;
        this.aboutArrayList = aboutArrayList;
    }

    @NonNull
    @Override
    public AboutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.about_us_item, parent, false);
        return new AboutViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutViewHolder holder, int position) {
        About about = aboutArrayList.get(position);


        holder.iVAboutIcon.setImageResource(about.getIcon());
        holder.tVAboutTitle.setText(about.getTitle());
        holder.tVAboutDescription.setText(about.getDescription());

    }

    @Override
    public int getItemCount() {
        return aboutArrayList.size();
    }
}
