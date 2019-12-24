package com.recip.ui.activities.more;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.recip.R;
import com.recip.models.Recipe;
import com.recip.ui.adapters.RecommendedAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreRecipesActivity extends AppCompatActivity {

    MoreRecipesViewModel moreRecipesViewModel;
   RecommendedAdapter mRecommendedAdapter;

   @BindView(R.id.mMoreRecyclerView)
   RecyclerView mMoreRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_recipes);
        ButterKnife.bind(this);

        moreRecipesViewModel= ViewModelProviders.of(this)
                .get(MoreRecipesViewModel.class);
        moreRecipesViewModel.getRecipeMutableLiveData().observe(this,moreRecipesObserver);

        if (getIntent() != null) {
            String title = getIntent().getStringExtra("title");
            getSupportActionBar().setTitle(title);
        }

    }

    private Observer<ArrayList<Recipe>> moreRecipesObserver=
            new Observer<ArrayList<Recipe>>() {
                @Override
                public void onChanged(ArrayList<Recipe> recipes) {
                    Context mContext=MoreRecipesActivity.this;
                    mRecommendedAdapter = new RecommendedAdapter(mContext, recipes, getSupportFragmentManager());
                    mMoreRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
                    mMoreRecyclerView.setAdapter(mRecommendedAdapter);
                }
            };
}
