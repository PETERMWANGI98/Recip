
package com.recip.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.models.IngredientsList;
import com.recip.models.Recipe;
import com.recip.ui.adapters.IngredientListAdapter;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DetailsFragment extends Fragment {

    private DetailsViewModel mViewModel;
    Recipe mRecipe;
    Unbinder unbinder;

    @BindView(R.id.recipeImage)
    ImageView recipeImageView;

    @BindView(R.id.toolbar_description)
    Toolbar mToolbar;

    @BindView(R.id.tVRecipeTitle)
    TextView tVRecipeTitle;

    @BindView(R.id.tVRecipeDuration)
    TextView tVRecipeDuration;


    @BindView(R.id.rVIngredients)
    RecyclerView rVIngredients;

    private IngredientListAdapter ingredientListAdapter;

    ArrayList<IngredientsList> ingredientsLists = new ArrayList<>();


    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Toast.makeText(getActivity(), mRecipe.getTitle(), Toast.LENGTH_SHORT).show();

        //bind data to views
        mToolbar.setTitle(mRecipe.title);

        Picasso.get()
                .load(mRecipe.getImage())
                .into(recipeImageView);
        tVRecipeTitle.setText(mRecipe.getTitle());
        tVRecipeDuration.setText(String.format(Locale.ENGLISH, "%d mins.", mRecipe.getCookingMinutes()));


        ingredientListAdapter = new IngredientListAdapter(getActivity(), ingredientsLists);
        rVIngredients.setLayoutManager(new LinearLayoutManager(getActivity()));
//        ingredientsTitle.setText(String.format(Locale.ENGLISH,"%d %s %s",amount,unit,name ));
        rVIngredients.setAdapter(ingredientListAdapter);
        updateRecipes();
        return view;
    }

    private void updateRecipes() {
        for (int i = 0; i < mRecipe.extendedIngredients.size(); i++) {
            int amount = (int) mRecipe.extendedIngredients.get(i).amount;
            String unit = mRecipe.extendedIngredients.get(i).unit;
            String name = mRecipe.extendedIngredients.get(i).name;
            String ingredientsString = String.format(Locale.ENGLISH, "%d %s %s", amount, unit, name);

            IngredientsList ingredientsList = new IngredientsList(ingredientsString);
            ingredientsLists.add(ingredientsList);
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }
}
