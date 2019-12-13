package com.recip.models;

import com.recip.R;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AboutTest {

    @Test
    public void newAbout() {
        assertTrue(setUpNewAbout() instanceof About);
    }

    @Test
    public void equals() {
        About aboutOne = setUpNewAbout();
        About secondAbout = setUpNewAbout();
        assertEquals(aboutOne, secondAbout);
    }

    @Test
    public void getIcon() {
        About about = setUpNewAbout();
        assertEquals(R.drawable.ic_email_black_24dp, about.getIcon());
    }

    @Test
    public void setIcon() {
        About about = setUpNewAbout();
        about.setIcon(R.drawable.ic_local_phone_black_24dp);
        assertNotEquals(R.drawable.ic_email_black_24dp, about.getIcon());
    }

    @Test
    public void getTitle() {
        About about = setUpNewAbout();
        assertEquals("Email", about.getTitle());
    }

    @Test
    public void setTitle() {
        About about = setUpNewAbout();
        about.setTitle("Phone");
        assertNotEquals(about.getTitle(), "Email");
    }

    @Test
    public void getDescription() {
        About about = setUpNewAbout();
        assertEquals(about.getDescription(), "recipe@gmail.com");
    }


    @Test
    public void setDescription() {
        About about = setUpNewAbout();
        about.setDescription("+1 784 475 47387");
        assertNotEquals(about.getDescription(), "recipe@gmail.com");
    }

    private About setUpNewAbout() {
        return new About(R.drawable.ic_email_black_24dp, "Email", "recipe@gmail.com");
    }
}