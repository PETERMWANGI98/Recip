package com.recip.ui.fragments.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseUser;
import com.recip.R;
import com.recip.models.Menu;
import com.recip.models.Recipe;
import com.recip.models.RecipeRandomResponse;
import com.recip.ui.activities.WebViewActivity;
import com.recip.ui.adapters.MenuAdapter;
import com.recip.ui.adapters.RecipeTagsAdapter;
import com.recip.ui.adapters.RecommendedAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements LifecycleOwner, View.OnClickListener {

    private Unbinder unbinder;
    @BindView(R.id.rvRecent)
    RecyclerView rvRecent;

    @BindView(R.id.recommendedRecyclerView)
    RecyclerView recommendedRecyclerView;

    @BindView(R.id.tvSearch)
    ConstraintLayout constraintLayout;

    @BindView(R.id.barsIcon)
    ImageView barsIcon;


    @BindView(R.id.tVSearchhint)
    TextView tVSearchhint;

    @BindView(R.id.tVUserWelcome)
    TextView tVUserWelcome;

    @BindView(R.id.btnNewsWebView)
    MaterialButton btnNewsWebView;

    @BindView(R.id.shimmer_container)
    ShimmerFrameLayout mShimmerFrameLayout;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, root);

        if (getArguments() != null & getArguments().getString("name") != null) {
            tVUserWelcome.setText(getString(R.string.find_label).concat(getArguments().getString("name").concat("?")));

        } else {
            tVUserWelcome.setText(getString(R.string.find_label).concat("?"));

        }


        rvRecent.setOnClickListener(this);
        barsIcon.setOnClickListener(this);
        tVSearchhint.setOnClickListener(this);
        btnNewsWebView.setOnClickListener(this);

        HomeFragmentViewModel homeFragmentViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        homeFragmentViewModel.getListMutableLiveData().observe(this, recentListUpdateObserver);
        homeFragmentViewModel.getRandomRecipeLiveData().observe(this, randomListUpdateObserver);

        return root;
    }


    private Observer<ArrayList<Recipe>> randomListUpdateObserver =
            new Observer<ArrayList<Recipe>>() {
                @Override
                public void onChanged(ArrayList<Recipe> recipes) {
                    RecommendedAdapter recommendedAdapter = new RecommendedAdapter(getContext(), recipes, getFragmentManager());
                    recommendedRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    recommendedRecyclerView.setAdapter(recommendedAdapter);
                    recommendedRecyclerView.setNestedScrollingEnabled(false);
                    mShimmerFrameLayout.stopShimmerAnimation();
                    mShimmerFrameLayout.setVisibility(View.INVISIBLE);

                }
            };

    private Observer<? super ArrayList<Menu>> recentListUpdateObserver =
            new Observer<ArrayList<Menu>>() {
                @Override
                public void onChanged(ArrayList<Menu> menus) {
                    MenuAdapter menuAdapter = new MenuAdapter(getContext(), menus);
                    rvRecent.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    rvRecent.setAdapter(menuAdapter);

                }
            };

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.barsIcon:
                Toast.makeText(getContext(), "Home ...", Toast.LENGTH_SHORT).show();
                DrawerLayout drawerLayout = getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.tVSearchhint:
                getActivity().onSearchRequested();
                break;
            case R.id.btnNewsWebView:
                startActivity(new Intent(getActivity(), WebViewActivity.class));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerFrameLayout.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerFrameLayout.stopShimmerAnimation();
        super.onPause();
    }
}
