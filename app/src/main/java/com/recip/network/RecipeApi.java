package com.recip.network;

import com.recip.models.Recipe;
import com.recip.models.RecipeRandomResponse;
import com.recip.models.SearchResponse;
import com.recip.models.Summary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecipeApi {

    @GET("random")
    Call<RecipeRandomResponse> getMoreRecipes(
            @Query("number") int number,
            @Query("tags") String tags
    );

    @GET("random")
    Call<RecipeRandomResponse> getRecommendedRecipes(
            @Query("number") int number

    );

    @GET("{id}/summary")
    Call<Summary> getRecipeSummary(
            @Path("id") Integer recipeId
    );

    @GET("complexSearch")
    Call<SearchResponse> getRecipeFromSearch(
            @Query("query") String queryString,
            @Query("number") int resultsCount
    );

    @GET("informationBulk")
    Call<List<Recipe>> getRecipeInformation(
            @Query("ids") String idsToSearch
    );

}
