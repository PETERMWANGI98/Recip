
package com.recip.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WinePairing {

    @SerializedName("pairedWines")
    @Expose
    private List<String> pairedWines = null;
    @SerializedName("pairingText")
    @Expose
    private String pairingText;
    @SerializedName("productMatches")
    @Expose
    private List<ProductMatch> productMatches = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WinePairing() {
    }

    /**
     * 
     * @param productMatches
     * @param pairingText
     * @param pairedWines
     */
    public WinePairing(List<String> pairedWines, String pairingText, List<ProductMatch> productMatches) {
        super();
        this.pairedWines = pairedWines;
        this.pairingText = pairingText;
        this.productMatches = productMatches;
    }

    public List<String> getPairedWines() {
        return pairedWines;
    }

    public void setPairedWines(List<String> pairedWines) {
        this.pairedWines = pairedWines;
    }

    public String getPairingText() {
        return pairingText;
    }

    public void setPairingText(String pairingText) {
        this.pairingText = pairingText;
    }

    public List<ProductMatch> getProductMatches() {
        return productMatches;
    }

    public void setProductMatches(List<ProductMatch> productMatches) {
        this.productMatches = productMatches;
    }

}
