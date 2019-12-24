package com.recip.network;

import com.recip.models.RecipeRandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {

    @GET("random?number=16&tags=vegetarian,dessert")
    Call<RecipeRandomResponse> getRecommendedRecipes();

    @GET("search?query=cheese&number=2")
    Call<RecipeRandomResponse> getRecipeFromTitle(

    );

}
