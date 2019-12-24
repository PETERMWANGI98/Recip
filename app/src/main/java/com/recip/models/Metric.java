
package com.recip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Metric {

    @SerializedName("amount")
    @Expose
    public double amount;
    @SerializedName("unitShort")
    @Expose
    public String unitShort;
    @SerializedName("unitLong")
    @Expose
    public String unitLong;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metric() {
    }

    /**
     * 
     * @param amount
     * @param unitShort
     * @param unitLong
     */
    public Metric(double amount, String unitShort, String unitLong) {
        super();
        this.amount = amount;
        this.unitShort = unitShort;
        this.unitLong = unitLong;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

}
