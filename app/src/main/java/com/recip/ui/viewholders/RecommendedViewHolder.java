package com.recip.ui.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.recip.R;
import com.recip.ui.activities.MainActivity;
import com.recip.ui.fragments.DetailsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendedViewHolder extends RecyclerView.ViewHolder{

    private Context mContext;

    @BindView(R.id.recommendedImageView)
    public ImageView recommendedImageView;

    @BindView(R.id.recommendedType)
    public TextView recommendedType;

    @BindView(R.id.recommendedTitle)
    public TextView recommendedTitle;

    @BindView(R.id.recommendedDuration)
    public TextView recommendedDuration;

    @BindView(R.id.iVAddToFavourites)
    public ImageView iVAddToFavourites;

    public RecommendedViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();

    }

}
