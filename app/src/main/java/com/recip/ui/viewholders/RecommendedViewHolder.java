package com.recip.ui.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendedViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.recommendedImageView)
    public ImageView recommendedImageView;

    @BindView(R.id.recommendedType)
    public TextView recommendedType;

    @BindView(R.id.recommendedTitle)
    public TextView recommendedTitle;

    @BindView(R.id.recommendedDuration)
    public TextView recommendedDuration;

    public RecommendedViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
