package com.recip.ui.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.recip.R;
import com.recip.models.Recipe;
import com.recip.models.SearchResponse;
import com.recip.network.RecipClient;
import com.recip.network.RecipeApi;
import com.recip.ui.adapters.RecommendedAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.mSearchRecyclerView)
    RecyclerView mSearchRecyclerView;
    @BindView(R.id.search_shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;

    private ArrayList<Integer> mIdsArrayList = new ArrayList<>();
    private ArrayList<Recipe> mRecipesArrayList = new ArrayList<>();
    RecommendedAdapter mRecommendedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            getRecipeFromQuery(query);

        }
    }


    private void getRecipeFromQuery(String query) {
        RecipeApi recipeApi = RecipClient.getClient();
        Call<SearchResponse> call = recipeApi.getRecipeFromSearch(query, 4);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().getResults().size(); i++) {
                        mIdsArrayList.add(response.body().getResults().get(i).getId());
                    }
                    getRecipesInformation();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });
    }

    private void getRecipesInformation() {
        String string = TextUtils.join(",", mIdsArrayList);
        Timber.i(string);

        RecipeApi recipeApi = RecipClient.getClient();
        Call<List<Recipe>> call = recipeApi.getRecipeInformation(string);
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if (response.isSuccessful()) {
                    mRecipesArrayList.addAll(response.body());

                    mRecommendedAdapter = new RecommendedAdapter(SearchActivity.this, mRecipesArrayList, getSupportFragmentManager());
                    mSearchRecyclerView.setAdapter(mRecommendedAdapter);
                    mSearchRecyclerView.setLayoutManager(new GridLayoutManager(SearchActivity.this, 2));
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

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
