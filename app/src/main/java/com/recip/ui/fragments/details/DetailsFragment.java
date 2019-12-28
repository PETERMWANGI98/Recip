
package com.recip.ui.fragments.details;

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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.models.IngredientsList;
import com.recip.models.Recipe;
import com.recip.models.Summary;
import com.recip.ui.adapters.DirectionsAdapter;
import com.recip.ui.adapters.IngredientListAdapter;
import com.recip.ui.fragments.home.HomeFragment;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public class DetailsFragment extends Fragment implements View.OnClickListener {

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

    @BindView(R.id.rVDirections)
    RecyclerView rVDirections;

    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;

    @BindView(R.id.recipeSummary)
    TextView recipeSummary;

    private IngredientListAdapter ingredientListAdapter;

    ArrayList<IngredientsList> ingredientsLists = new ArrayList<>();

    private DirectionsAdapter directionsAdapter;
    ArrayList<String> stringArrayList = new ArrayList<>();

    private DetailsViewModel mDetailsViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        rVIngredients.setAdapter(ingredientListAdapter);
        updateIngredients();

        directionsAdapter = new DirectionsAdapter(getActivity(), stringArrayList);
        rVDirections.setLayoutManager(new LinearLayoutManager(getActivity()));
        rVDirections.setAdapter(directionsAdapter);
        updateDirections();

        mDetailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        mDetailsViewModel.getmSummaryMutableLiveData().observe(this,summaryUpdateObserver);

        imageViewBack.setOnClickListener(this);

        return view;
    }

    private Observer<Summary> summaryUpdateObserver =
            summary -> {
                Timber.i(summary.getSummary());
                String summaryText=summary.getSummary();
                recipeSummary.setText(summaryText);
            };

    private void updateDirections() {
        for (int i = 0; i < mRecipe.analyzedInstructions.get(0).steps.size(); i++) {
            String string = mRecipe.analyzedInstructions.get(0).steps.get(i).step;
            stringArrayList.add(string);
        }
    }

    private void updateIngredients() {
        for (int i = 0; i < mRecipe.extendedIngredients.size(); i++) {
            int amount = (int) mRecipe.extendedIngredients.get(i).amount;
            String unit = mRecipe.extendedIngredients.get(i).unit;
            String name = mRecipe.extendedIngredients.get(i).name;
            String ingredientsString = String.format(Locale.ENGLISH, "%d %s %s .", amount, unit, name);

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

    @Override
    public void onClick(View v) {
        if (v == imageViewBack) {
            FragmentTransaction mTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            HomeFragment mHomeFragment = new HomeFragment();
            Bundle mBundle = new Bundle();
            mBundle.putString("name", " ");
            mHomeFragment.setArguments(mBundle);
            mTransaction.replace(R.id.nav_host_fragment, mHomeFragment);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
        }
    }
}
