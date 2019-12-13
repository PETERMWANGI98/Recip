package com.recip.ui.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.cIvCategoryMenu)
    CircleImageView cIvCategoryMenu;

    @BindView(R.id.tVCategoryMenu)
    TextView tVCategoryMenu;

    public CategoriesViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
