package com.recip.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.recip.R;
import com.recip.models.Recipe;

import org.parceler.Parcels;

public class RecipeDetailsActivity extends AppCompatActivity {
    Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        if (getIntent()!=null) {
            mRecipe= Parcels.unwrap(getIntent().getParcelableExtra("recipe"));
            Toast.makeText(this, mRecipe.getTitle(), Toast.LENGTH_SHORT).show();
        }

    }
}
