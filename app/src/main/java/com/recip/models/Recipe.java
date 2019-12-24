
package com.recip.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Recipe {

    @SerializedName("vegetarian")
    @Expose
    public boolean vegetarian;
    @SerializedName("vegan")
    @Expose
    public boolean vegan;
    @SerializedName("glutenFree")
    @Expose
    public boolean glutenFree;
    @SerializedName("dairyFree")
    @Expose
    public boolean dairyFree;
    @SerializedName("veryHealthy")
    @Expose
    public boolean veryHealthy;
    @SerializedName("cheap")
    @Expose
    public boolean cheap;
    @SerializedName("veryPopular")
    @Expose
    public boolean veryPopular;
    @SerializedName("sustainable")
    @Expose
    public boolean sustainable;
    @SerializedName("weightWatcherSmartPoints")
    @Expose
    public int weightWatcherSmartPoints;
    @SerializedName("gaps")
    @Expose
    public String gaps;
    @SerializedName("lowFodmap")
    @Expose
    public boolean lowFodmap;
    @SerializedName("ketogenic")
    @Expose
    public boolean ketogenic;
    @SerializedName("whole30")
    @Expose
    public boolean whole30;
    @SerializedName("preparationMinutes")
    @Expose
    public int preparationMinutes;
    @SerializedName("cookingMinutes")
    @Expose
    public int cookingMinutes;
    @SerializedName("sourceUrl")
    @Expose
    public String sourceUrl;
    @SerializedName("spoonacularSourceUrl")
    @Expose
    public String spoonacularSourceUrl;
    @SerializedName("aggregateLikes")
    @Expose
    public int aggregateLikes;
    @SerializedName("spoonacularScore")
    @Expose
    public double spoonacularScore;
    @SerializedName("healthScore")
    @Expose
    public double healthScore;
    @SerializedName("creditsText")
    @Expose
    public String creditsText;
    @SerializedName("sourceName")
    @Expose
    public String sourceName;
    @SerializedName("pricePerServing")
    @Expose
    public double pricePerServing;
    @SerializedName("extendedIngredients")
    @Expose
    public ArrayList<ExtendedIngredient> extendedIngredients = null;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("readyInMinutes")
    @Expose
    public int readyInMinutes;
    @SerializedName("servings")
    @Expose
    public int servings;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("imageType")
    @Expose
    public String imageType;
    @SerializedName("cuisines")
    @Expose
    public ArrayList<Object> cuisines = null;
    @SerializedName("dishTypes")
    @Expose
    public ArrayList<String> dishTypes = null;
    @SerializedName("diets")
    @Expose
    public ArrayList<String> diets = null;
    @SerializedName("occasions")
    @Expose
    public ArrayList<Object> occasions = null;
    @SerializedName("winePairing")
    @Expose
    public WinePairing winePairing;
    @SerializedName("instructions")
    @Expose
    public String instructions;
    @SerializedName("analyzedInstructions")
    @Expose
    public ArrayList<AnalyzedInstruction> analyzedInstructions = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipe() {
    }

    /**
     * 
     * @param instructions
     * @param sustainable
     * @param analyzedInstructions
     * @param glutenFree
     * @param veryPopular
     * @param healthScore
     * @param title
     * @param diets
     * @param aggregateLikes
     * @param sourceUrl
     * @param creditsText
     * @param readyInMinutes
     * @param dairyFree
     * @param servings
     * @param vegetarian
     * @param whole30
     * @param id
     * @param preparationMinutes
     * @param imageType
     * @param winePairing
     * @param cookingMinutes
     * @param image
     * @param veryHealthy
     * @param vegan
     * @param cheap
     * @param extendedIngredients
     * @param dishTypes
     * @param gaps
     * @param cuisines
     * @param lowFodmap
     * @param weightWatcherSmartPoints
     * @param occasions
     * @param spoonacularScore
     * @param pricePerServing
     * @param spoonacularSourceUrl
     * @param sourceName
     * @param ketogenic
     */
    public Recipe(boolean vegetarian, boolean vegan, boolean glutenFree, boolean dairyFree,
                  boolean veryHealthy, boolean cheap, boolean veryPopular, boolean sustainable,
                  int weightWatcherSmartPoints, String gaps, boolean lowFodmap, boolean ketogenic,
                  boolean whole30, int preparationMinutes, int cookingMinutes, String sourceUrl,
                  String spoonacularSourceUrl, int aggregateLikes, double spoonacularScore,
                  double healthScore, String creditsText, String sourceName,
                  double pricePerServing, ArrayList<ExtendedIngredient> extendedIngredients,
                  int id, String title, int readyInMinutes, int servings, String image,
                  String imageType, ArrayList<Object> cuisines, ArrayList<String> dishTypes,
                  ArrayList<String> diets, ArrayList<Object> occasions, WinePairing winePairing,
                  String instructions, ArrayList<AnalyzedInstruction> analyzedInstructions) {
        super();
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
        this.veryHealthy = veryHealthy;
        this.cheap = cheap;
        this.veryPopular = veryPopular;
        this.sustainable = sustainable;
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
        this.gaps = gaps;
        this.lowFodmap = lowFodmap;
        this.ketogenic = ketogenic;
        this.whole30 = whole30;
        this.preparationMinutes = preparationMinutes;
        this.cookingMinutes = cookingMinutes;
        this.sourceUrl = sourceUrl;
        this.spoonacularSourceUrl = spoonacularSourceUrl;
        this.aggregateLikes = aggregateLikes;
        this.spoonacularScore = spoonacularScore;
        this.healthScore = healthScore;
        this.creditsText = creditsText;
        this.sourceName = sourceName;
        this.pricePerServing = pricePerServing;
        this.extendedIngredients = extendedIngredients;
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.image = image;
        this.imageType = imageType;
        this.cuisines = cuisines;
        this.dishTypes = dishTypes;
        this.diets = diets;
        this.occasions = occasions;
        this.winePairing = winePairing;
        this.instructions = instructions;
        this.analyzedInstructions = analyzedInstructions;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public boolean isVeryHealthy() {
        return veryHealthy;
    }

    public void setVeryHealthy(boolean veryHealthy) {
        this.veryHealthy = veryHealthy;
    }

    public boolean isCheap() {
        return cheap;
    }

    public void setCheap(boolean cheap) {
        this.cheap = cheap;
    }

    public boolean isVeryPopular() {
        return veryPopular;
    }

    public void setVeryPopular(boolean veryPopular) {
        this.veryPopular = veryPopular;
    }

    public boolean isSustainable() {
        return sustainable;
    }

    public void setSustainable(boolean sustainable) {
        this.sustainable = sustainable;
    }

    public int getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }

    public void setWeightWatcherSmartPoints(int weightWatcherSmartPoints) {
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
    }

    public String getGaps() {
        return gaps;
    }

    public void setGaps(String gaps) {
        this.gaps = gaps;
    }

    public boolean isLowFodmap() {
        return lowFodmap;
    }

    public void setLowFodmap(boolean lowFodmap) {
        this.lowFodmap = lowFodmap;
    }

    public boolean isKetogenic() {
        return ketogenic;
    }

    public void setKetogenic(boolean ketogenic) {
        this.ketogenic = ketogenic;
    }

    public boolean isWhole30() {
        return whole30;
    }

    public void setWhole30(boolean whole30) {
        this.whole30 = whole30;
    }

    public int getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(int preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(int cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }

    public void setSpoonacularSourceUrl(String spoonacularSourceUrl) {
        this.spoonacularSourceUrl = spoonacularSourceUrl;
    }

    public int getAggregateLikes() {
        return aggregateLikes;
    }

    public void setAggregateLikes(int aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
    }

    public double getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(double spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public double getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(double healthScore) {
        this.healthScore = healthScore;
    }

    public String getCreditsText() {
        return creditsText;
    }

    public void setCreditsText(String creditsText) {
        this.creditsText = creditsText;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public ArrayList<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(ArrayList<ExtendedIngredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public List<Object> getCuisines() {
        return cuisines;
    }

    public void setCuisines(ArrayList<Object> cuisines) {
        this.cuisines = cuisines;
    }

    public List<String> getDishTypes() {
        return dishTypes;
    }

    public void setDishTypes(ArrayList<String> dishTypes) {
        this.dishTypes = dishTypes;
    }

    public List<String> getDiets() {
        return diets;
    }

    public void setDiets(ArrayList<String> diets) {
        this.diets = diets;
    }

    public List<Object> getOccasions() {
        return occasions;
    }

    public void setOccasions(ArrayList<Object> occasions) {
        this.occasions = occasions;
    }

    public WinePairing getWinePairing() {
        return winePairing;
    }

    public void setWinePairing(WinePairing winePairing) {
        this.winePairing = winePairing;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<AnalyzedInstruction> getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    public void setAnalyzedInstructions(ArrayList<AnalyzedInstruction> analyzedInstructions) {
        this.analyzedInstructions = analyzedInstructions;
    }

}
