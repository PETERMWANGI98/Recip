package com.recip.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void newRecent() {
        assertTrue(setUpRecent() instanceof Menu);
    }

    @Test
    public void getImageUrl() {
        Menu menu = setUpRecent();
        assertEquals("https://pizza.png", menu.getImageUrl());
    }

    @Test
    public void setImageUrl() {
        Menu menu = setUpRecent();
        menu.setImageUrl("https://chocolate.jpg");
        assertNotEquals(menu.getImageUrl(), "https://pizza.png");
    }

    @Test
    public void getTitle() {
        Menu menu = setUpRecent();
        assertEquals("Pizza", menu.getTitle());
    }

    @Test
    public void setTitle() {
        Menu menu = setUpRecent();
        menu.setTitle("Chocolate");
        assertNotEquals(menu.getTitle(), "Pizza");
    }



    @Test
    public void equals1() {
        Menu menuOne = setUpRecent();
        Menu menuTwo = setUpRecent();
        assertEquals(menuOne, menuTwo);
    }

    private Menu setUpRecent() {
        return new Menu("https://pizza.png", "Pizza");
    }


}