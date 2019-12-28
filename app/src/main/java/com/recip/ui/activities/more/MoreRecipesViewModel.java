package com.recip.ui.activities.more;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.recip.models.Recipe;
import com.recip.models.RecipeRandomResponse;
import com.recip.models.Result;
import com.recip.models.SearchResponse;
import com.recip.network.RecipClient;
import com.recip.network.RecipeApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class MoreRecipesViewModel extends ViewModel {
    ArrayList<Recipe> recipeArrayList = new ArrayList<>();
    MutableLiveData<ArrayList<Recipe>> recipeMutableLiveData;

    MutableLiveData<String> recipeTitle;
    String title;


    public MoreRecipesViewModel() {
        recipeMutableLiveData = new MutableLiveData<>();
        recipeTitle = new MutableLiveData<>();
        init();
    }

    private void init() {
        populateRecipes();
        recipeMutableLiveData.setValue(recipeArrayList);


    }

    private void populateRecipes() {
        RecipeApi recipClient = RecipClient.getClient();
        String recipeTitle = getRecipeTitle().getValue();

        Timber.i(recipeTitle);
        Call<RecipeRandomResponse> randomRecipeCall = recipClient.getMoreRecipes(10, recipeTitle);
        randomRecipeCall.enqueue(new Callback<RecipeRandomResponse>() {
            @Override
            public void onResponse(Call<RecipeRandomResponse> call, Response<RecipeRandomResponse> response) {
                if (response.isSuccessful()) {
                    Timber.i("Successfull %d", response.code());
                    assert response.body() != null;
                    recipeArrayList.addAll(response.body().getRecipes());

//                    Timber.i(response.body());

                    Timber.i(Integer.toString(recipeArrayList.size()));
                    recipeMutableLiveData.setValue(recipeArrayList);

                }
            }

            @Override
            public void onFailure(Call<RecipeRandomResponse> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<ArrayList<Recipe>> getRecipeMutableLiveData() {
        return recipeMutableLiveData;
    }

    public MutableLiveData<String> getRecipeTitle() {
        return recipeTitle;
    }

}
