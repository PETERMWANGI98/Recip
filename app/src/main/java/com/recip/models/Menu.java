package com.recip.models;

import java.util.Objects;

public class Menu {
    private String imageUrl;
    private String title;

    public Menu(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(imageUrl, menu.imageUrl) &&
                Objects.equals(title, menu.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl, title);
    }
}
