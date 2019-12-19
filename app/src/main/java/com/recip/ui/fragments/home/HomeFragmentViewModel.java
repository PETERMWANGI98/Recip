package com.recip.ui.fragments.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.recip.models.Menu;
import com.recip.models.Recipe;
import com.recip.models.RecipeRandomResponse;
import com.recip.network.RecipClient;
import com.recip.network.RecipeApi;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class HomeFragmentViewModel extends ViewModel {
    private static final String TAG = "HomeFragmentViewModel";
    MutableLiveData<ArrayList<Menu>> listMutableLiveData;
    ArrayList<Menu> menuArrayList = new ArrayList<>();

    ArrayList<Recipe> recipeRandomResponses = new ArrayList<>();
    MutableLiveData<ArrayList<Recipe>> randomRecipeLiveData;

    public HomeFragmentViewModel() {
        listMutableLiveData = new MutableLiveData<>();
        randomRecipeLiveData = new MutableLiveData<>();
        init();
    }

    private void init() {
        populateList();
        populateRecommended();
        listMutableLiveData.setValue(menuArrayList);


    }

    public MutableLiveData<ArrayList<Recipe>> getRandomRecipeLiveData() {
        return randomRecipeLiveData;
    }

    private void populateRecommended() {
        RecipeApi recipClient = RecipClient.getClient();
        Call<RecipeRandomResponse> randomRecipeCall = recipClient.getRecommendedRecipes();
        randomRecipeCall.enqueue(new Callback<RecipeRandomResponse>() {
            @Override
            public void onResponse(Call<RecipeRandomResponse> call, Response<RecipeRandomResponse> response) {
                if (response.isSuccessful()) {
                    Timber.i("Successfull %d", response.code());
                    assert response.body() != null;
                    recipeRandomResponses.addAll(response.body().getRecipes());

                    Timber.i(Integer.toString(recipeRandomResponses.size()));
                    randomRecipeLiveData.setValue(recipeRandomResponses);

                }
            }

            @Override
            public void onFailure(Call<RecipeRandomResponse> call, Throwable t) {
                Timber.e(t);
            }
        });
    }


    private void populateList() {
        Menu menuOne = new Menu("https://ak9.picdn.net/shutterstock/videos/720259/thumb/1.jpg", "Salad");
        Menu menuTwo = new Menu("https://wallpaperaccess.com/full/138469.jpg", "Dinner");
        Menu menuThree = new Menu("https://hdwallpaperim.com/wp-content/uploads/2017/08/27/144689-chocolate-cakes-desserts-748x468.jpg", "Desserts");
        Menu menuFour = new Menu("https://freedesignfile.com/upload/2017/07/sumptuous-breakfast-HD-picture.jpg", "Breakfast");
        Menu menuFive = new Menu("https://abigailkirsch.com/wp-content/uploads/2015/02/hd-crab-and-grapefuit-glam.jpg", "Appetizer");


        menuArrayList.add(menuOne);
        menuArrayList.add(menuTwo);
        menuArrayList.add(menuThree);
        menuArrayList.add(menuFour);
        menuArrayList.add(menuFive);
    }

    public MutableLiveData<ArrayList<Menu>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
