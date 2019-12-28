package com.recip.providers;

import android.content.SearchRecentSuggestionsProvider;

public class RecipeSuggestionProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = "com.recip.providers.RecipeSuggestionProvider";
    public static final int MODE = DATABASE_MODE_QUERIES;

    public RecipeSuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
