
package com.recip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Length {

    @SerializedName("number")
    @Expose
    public int number;
    @SerializedName("unit")
    @Expose
    public String unit;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Length() {
    }

    /**
     * 
     * @param number
     * @param unit
     */
    public Length(int number, String unit) {
        super();
        this.number = number;
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
