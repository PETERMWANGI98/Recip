package com.recip.realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Recipe extends RealmObject {
    @PrimaryKey
    private int id;
    private String title;
    private int readyInMinutes;
    private String dishType;

    public Recipe(int id, String title, int readyInMinutes, String dishType) {
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.dishType = dishType;
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

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }
}
