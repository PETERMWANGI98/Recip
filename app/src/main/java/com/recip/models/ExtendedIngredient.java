
package com.recip.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ExtendedIngredient {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("aisle")
    @Expose
    public String aisle;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("consitency")
    @Expose
    public String consitency;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("original")
    @Expose
    public String original;
    @SerializedName("originalString")
    @Expose
    public String originalString;
    @SerializedName("originalName")
    @Expose
    public String originalName;
    @SerializedName("amount")
    @Expose
    public double amount;
    @SerializedName("unit")
    @Expose
    public String unit;
    @SerializedName("meta")
    @Expose
    public List<String> meta = null;
    @SerializedName("metaInformation")
    @Expose
    public List<String> metaInformation = null;
    @SerializedName("measures")
    @Expose
    public Measures measures;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExtendedIngredient() {
    }

    /**
     * 
     * @param image
     * @param amount
     * @param original
     * @param consitency
     * @param aisle
     * @param originalName
     * @param unit
     * @param measures
     * @param meta
     * @param name
     * @param originalString
     * @param id
     * @param metaInformation
     */
    public ExtendedIngredient(int id, String aisle, String image, String consitency, String name, String original, String originalString, String originalName, double amount, String unit, List<String> meta, List<String> metaInformation, Measures measures) {
        super();
        this.id = id;
        this.aisle = aisle;
        this.image = image;
        this.consitency = consitency;
        this.name = name;
        this.original = original;
        this.originalString = originalString;
        this.originalName = originalName;
        this.amount = amount;
        this.unit = unit;
        this.meta = meta;
        this.metaInformation = metaInformation;
        this.measures = measures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getConsitency() {
        return consitency;
    }

    public void setConsitency(String consitency) {
        this.consitency = consitency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<String> getMeta() {
        return meta;
    }

    public void setMeta(List<String> meta) {
        this.meta = meta;
    }

    public List<String> getMetaInformation() {
        return metaInformation;
    }

    public void setMetaInformation(List<String> metaInformation) {
        this.metaInformation = metaInformation;
    }

    public Measures getMeasures() {
        return measures;
    }

    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

}
