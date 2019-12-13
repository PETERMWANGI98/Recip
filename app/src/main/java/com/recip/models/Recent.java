package com.recip.models;

import java.util.Objects;

public class Recent {
    private String imageUrl;
    private String title;
    private String description;

    public Recent(String imageUrl, String title, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recent recent = (Recent) o;
        return Objects.equals(imageUrl, recent.imageUrl) &&
                Objects.equals(title, recent.title) &&
                Objects.equals(description, recent.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl, title, description);
    }


}
