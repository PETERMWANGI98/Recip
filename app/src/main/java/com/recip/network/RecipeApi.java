package com.recip.network;

import com.recip.models.RecipeRandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeApi {

    @GET("/random?number=1&tags=vegetarian,dessert")
    Call<RecipeRandomResponse> getRecommendedRecipes();

}
