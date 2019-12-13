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

public class RecentViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iVRecent)
    public ImageView iVRecent;
    @BindView(R.id.tVRecentTitle)
    public TextView tVRecentTitle;
    @BindView(R.id.tVRecentDescription)
    public TextView tVRecentDescription;

    public RecentViewHolder(@NonNull final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //run scale animation andd make it bigger
                    Animation animation= AnimationUtils.loadAnimation(v.getContext(),R.anim.anim_scale_in_tv);
                    itemView.startAnimation(animation);
                    animation.setFillAfter(true);
                }
                else {
                    //run scale animation to make it smaller
                    Animation animation= AnimationUtils.loadAnimation(v.getContext(),R.anim.anim_scale_out_tv);
                    itemView.startAnimation(animation);
                    animation.setFillAfter(true);
                }
            }
        });
    }
}
