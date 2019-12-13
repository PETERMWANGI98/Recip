package com.recip.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecentTest {

    @Test
    public void newRecent() {
        assertTrue(setUpRecent() instanceof Recent);
    }

    @Test
    public void getImageUrl() {
        Recent recent = setUpRecent();
        assertEquals("https://pizza.png", recent.getImageUrl());
    }

    @Test
    public void setImageUrl() {
        Recent recent = setUpRecent();
        recent.setImageUrl("https://chocolate.jpg");
        assertNotEquals(recent.getImageUrl(), "https://pizza.png");
    }

    @Test
    public void getTitle() {
        Recent recent = setUpRecent();
        assertEquals("Pizza", recent.getTitle());
    }

    @Test
    public void setTitle() {
        Recent recent = setUpRecent();
        recent.setTitle("Chocolate");
        assertNotEquals(recent.getTitle(), "Pizza");
    }

    @Test
    public void getDescription() {
        Recent recent = setUpRecent();
        assertEquals(recent.getDescription(), "Pizza Crust");
    }

    @Test
    public void setDescription() {
        Recent recent = setUpRecent();
        recent.setDescription("Chocolate balls");
        assertNotEquals(recent.getDescription(), "PizzaCrust");
    }

    @Test
    public void equals1() {
        Recent recentOne = setUpRecent();
        Recent recentTwo = setUpRecent();
        assertEquals(recentOne, recentTwo);
    }

    private Recent setUpRecent() {
        return new Recent("https://pizza.png", "Pizza", "Pizza Crust");
    }


}