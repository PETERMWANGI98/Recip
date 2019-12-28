package com.recip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("title")
    @Expose
    private String title;


    /**
     * No args constructor for use in serialization
     */
    public Summary() {
    }

    /**
     * @param summary
     * @param id
     * @param title
     */
    public Summary(Integer id, String summary, String title) {
        this.id = id;
        this.summary = summary;
        this.title = title;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

