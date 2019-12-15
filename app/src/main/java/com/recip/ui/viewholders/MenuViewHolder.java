package com.recip.ui.viewholders;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iVRecent)
    public ImageView iVRecent;
    @BindView(R.id.tVRecentTitle)
    public TextView tVRecentTitle;
    public TextView tVRecentDescription;

    public MenuViewHolder(@NonNull final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
