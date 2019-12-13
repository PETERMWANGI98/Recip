package com.recip.ui.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iVAboutIcon)
    public ImageView iVAboutIcon;

    @BindView(R.id.tVAboutTitle)
    public TextView tVAboutTitle;

    @BindView(R.id.tVAboutDescription)
    public TextView tVAboutDescription;


    public AboutViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
