package com.recip.models;

import java.util.Objects;

public class About {
    private int icon;
    private String title;
    private String description;

    public About(int icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
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
        About about = (About) o;
        return icon == about.icon &&
                Objects.equals(title, about.title) &&
                Objects.equals(description, about.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(icon, title, description);
    }
}
