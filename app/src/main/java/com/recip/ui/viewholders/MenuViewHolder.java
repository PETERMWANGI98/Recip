package com.recip.ui.viewholders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.ui.activities.MoreRecipesActivity;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.mImageView)
    public ImageView mImageView;

    @BindView(R.id.mTitle)
    public TextView mTitle;


    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //catch the title and load MoreRecipesActivity
        Context mContext=v.getContext();
        Intent intent=new Intent(mContext, MoreRecipesActivity.class);
        intent.putExtra("title",mTitle.getText().toString().trim());
        mContext.startActivity(intent);

    }
}
