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
