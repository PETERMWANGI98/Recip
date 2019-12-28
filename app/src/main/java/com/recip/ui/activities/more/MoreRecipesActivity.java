package com.recip.ui.activities.more;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.recip.R;
import com.recip.models.Recipe;
import com.recip.models.RecipeRandomResponse;
import com.recip.network.RecipClient;
import com.recip.network.RecipeApi;
import com.recip.ui.adapters.RecommendedAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MoreRecipesActivity extends AppCompatActivity {

    RecommendedAdapter mRecommendedAdapter;

    @BindView(R.id.mMoreRecyclerView)
    RecyclerView mMoreRecyclerView;

    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;

    String title;

    ArrayList<Recipe> recipeArrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_recipes);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            title = getIntent().getStringExtra("title");
            getSupportActionBar().setTitle(title);
            Timber.i(title);

        } else {
            title = "African";
        }
        populateRecipes();

    }

    private void populateRecipes() {
        RecipeApi recipClient = RecipClient.getClient();
        String recipeTitle = title.toLowerCase();

        Timber.i(recipeTitle);
        Call<RecipeRandomResponse> randomRecipeCall = recipClient.getMoreRecipes(10, recipeTitle);
        randomRecipeCall.enqueue(new Callback<RecipeRandomResponse>() {
            @Override
            public void onResponse(Call<RecipeRandomResponse> call, Response<RecipeRandomResponse> response) {
                if (response.isSuccessful()) {
                    Timber.i("Successfull %d", response.code());
                    assert response.body() != null;
                    recipeArrayList.addAll(response.body().getRecipes());
                    Timber.i(Integer.toString(recipeArrayList.size()));

                    Context mContext = MoreRecipesActivity.this;
                    mRecommendedAdapter = new RecommendedAdapter(mContext, recipeArrayList, getSupportFragmentManager());
                    mMoreRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
                    mMoreRecyclerView.setAdapter(mRecommendedAdapter);
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<RecipeRandomResponse> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }
}
