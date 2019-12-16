package com.recip.ui.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.mImageView)
    public ImageView mImageView;

    @BindView(R.id.mTitle)
    public TextView mTitle;


    public MenuViewHolder(@NonNull  View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
