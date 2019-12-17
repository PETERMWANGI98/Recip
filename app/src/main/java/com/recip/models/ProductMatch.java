
package com.recip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductMatch {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("averageRating")
    @Expose
    private double averageRating;
    @SerializedName("ratingCount")
    @Expose
    private double ratingCount;
    @SerializedName("score")
    @Expose
    private double score;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductMatch() {
    }

    /**
     * 
     * @param score
     * @param price
     * @param imageUrl
     * @param averageRating
     * @param link
     * @param description
     * @param id
     * @param title
     * @param ratingCount
     */
    public ProductMatch(int id, String title, String description, String price, String imageUrl, double averageRating, double ratingCount, double score, String link) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
        this.score = score;
        this.link = link;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(double ratingCount) {
        this.ratingCount = ratingCount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
