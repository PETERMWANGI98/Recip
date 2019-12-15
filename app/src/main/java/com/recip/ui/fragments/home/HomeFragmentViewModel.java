package com.recip.ui.fragments.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.recip.models.Menu;

import java.util.ArrayList;

public class HomeFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<Menu>> listMutableLiveData;
    ArrayList<Menu> menuArrayList = new ArrayList<>();

    public HomeFragmentViewModel() {
        listMutableLiveData = new MutableLiveData<>();
        init();
    }

    private void init() {
        populateList();
        listMutableLiveData.setValue(menuArrayList);
    }

    private void populateList() {
        Menu menuOne = new Menu("https://inspiredentertainment.com/media/Crispy-Chocolate-Peanut-Butter-Balls_16x9_Healthy-Meal-Plans.jpg", "Salad");
        Menu menuTwo = new Menu("https://aahaaramonline.com/wp-content/uploads/2019/06/lasooni_palak-880x600.jpg", "Healthy");
        Menu menuThree = new Menu("https://i.ytimg.com/vi/ljfywL0g9fI/maxresdefault.jpg", "Desserts");
        Menu menuFour = new Menu("https://aahaaramonline.com/wp-content/uploads/2019/06/lasooni_palak-880x600.jpg", "Breakfast");
        Menu menuFive = new Menu("https://aahaaramonline.com/wp-content/uploads/2019/06/lasooni_palak-880x600.jpg", "Appetizer");


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
