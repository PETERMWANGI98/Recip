
package com.recip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Measures {

    @SerializedName("us")
    @Expose
    public Us us;
    @SerializedName("metric")
    @Expose
    public Metric metric;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Measures() {
    }

    /**
     * 
     * @param metric
     * @param us
     */
    public Measures(Us us, Metric metric) {
        super();
        this.us = us;
        this.metric = metric;
    }

    public Us getUs() {
        return us;
    }

    public void setUs(Us us) {
        this.us = us;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

}
