package com.recip.ui.fragments.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.recip.models.Categories;
import com.recip.models.Recent;

import java.util.ArrayList;

public class HomeFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<Recent>> listMutableLiveData;
    ArrayList<Recent> recentArrayList = new ArrayList<>();

    MutableLiveData<ArrayList<Categories>> categoriesMutableLiveData;
    ArrayList<Categories> categoriesArrayList = new ArrayList<>();

    public HomeFragmentViewModel() {
        listMutableLiveData = new MutableLiveData<>();
        init();
    }

    private void init() {
        populateList();
        listMutableLiveData.setValue(recentArrayList);
    }

    private void populateList() {
        Recent recentOne = new Recent("https://inspiredentertainment.com/media/Crispy-Chocolate-Peanut-Butter-Balls_16x9_Healthy-Meal-Plans.jpg", "Salad", "Lauhsuni Palak");
        Recent recentTwo = new Recent("https://aahaaramonline.com/wp-content/uploads/2019/06/lasooni_palak-880x600.jpg", "Healthy", "   Breakfast");
        Recent recentThree = new Recent("https://i.ytimg.com/vi/ljfywL0g9fI/maxresdefault.jpg", "Desserts", "DESSERTS");
        Recent recentFour = new Recent("https://aahaaramonline.com/wp-content/uploads/2019/06/lasooni_palak-880x600.jpg", "Breakfast", "Lauhsuni Palak");
        Recent recentFive = new Recent("https://aahaaramonline.com/wp-content/uploads/2019/06/lasooni_palak-880x600.jpg", "Appetizer", "Lauhsuni Palak");


        recentArrayList.add(recentOne);
        recentArrayList.add(recentTwo);
        recentArrayList.add(recentThree);
        recentArrayList.add(recentFour);
        recentArrayList.add(recentFive);
    }

    public MutableLiveData<ArrayList<Recent>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
