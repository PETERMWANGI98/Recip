
package com.recip.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("step")
    @Expose
    private String step;
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = null;
    @SerializedName("equipment")
    @Expose
    private List<Equipment> equipment = null;
    @SerializedName("length")
    @Expose
    private Length length;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Step() {
    }

    /**
     * 
     * @param number
     * @param length
     * @param ingredients
     * @param equipment
     * @param step
     */
    public Step(int number, String step, List<Ingredient> ingredients, List<Equipment> equipment, Length length) {
        super();
        this.number = number;
        this.step = step;
        this.ingredients = ingredients;
        this.equipment = equipment;
        this.length = length;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

}
