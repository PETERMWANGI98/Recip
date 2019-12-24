
package com.recip.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class RecipeRandomResponse {

    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RecipeRandomResponse() {
    }

    /**
     * 
     * @param recipes
     */
    public RecipeRandomResponse(List<Recipe> recipes) {
        super();
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}
