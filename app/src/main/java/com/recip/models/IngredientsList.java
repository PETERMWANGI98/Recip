package com.recip.models;

import java.util.Objects;

public class IngredientsList {
    private String mIngredientTitle;

    public IngredientsList(String mIngredientTitle) {
        this.mIngredientTitle = mIngredientTitle;
    }

    public String getmIngredientTitle() {
        return mIngredientTitle;
    }

    public void setmIngredientTitle(String mIngredientTitle) {
        this.mIngredientTitle = mIngredientTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientsList that = (IngredientsList) o;
        return Objects.equals(mIngredientTitle, that.mIngredientTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIngredientTitle);
    }
}
