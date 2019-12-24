
package com.recip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Equipment {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("temperature")
    @Expose
    public Temperature temperature;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Equipment() {
    }

    /**
     * 
     * @param image
     * @param name
     * @param temperature
     * @param id
     */
    public Equipment(int id, String name, String image, Temperature temperature) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

}
