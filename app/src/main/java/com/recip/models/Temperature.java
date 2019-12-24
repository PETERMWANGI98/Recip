
package com.recip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Temperature {

    @SerializedName("number")
    @Expose
    public double number;
    @SerializedName("unit")
    @Expose
    public String unit;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Temperature() {
    }

    /**
     * 
     * @param number
     * @param unit
     */
    public Temperature(double number, String unit) {
        super();
        this.number = number;
        this.unit = unit;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
