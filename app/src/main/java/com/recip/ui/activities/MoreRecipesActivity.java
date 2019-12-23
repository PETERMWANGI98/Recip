package com.recip.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.recip.R;

public class MoreRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_recipes);

        if (getIntent() != null) {
            String title = getIntent().getStringExtra("title");
            getSupportActionBar().setTitle(title);
        }

    }
}
