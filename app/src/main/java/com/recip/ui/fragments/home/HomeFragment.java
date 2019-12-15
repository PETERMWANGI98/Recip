package com.recip.ui.fragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;
import com.recip.models.Recent;
import com.recip.ui.activities.MainActivity;
import com.recip.ui.activities.about.AboutUsViewModel;
import com.recip.ui.adapters.AboutRecyclerViewAdapter;
import com.recip.ui.adapters.RecentRecyclerViewAdapter;
import com.recip.ui.fragments.LoginActivity;
import com.recip.ui.activities.ProfileActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements LifecycleOwner, View.OnClickListener {

    private Unbinder unbinder;
    @BindView(R.id.rvRecent)
    RecyclerView rvRecent;

    @BindView(R.id.tvSearch)
    ConstraintLayout constraintLayout;

    @BindView(R.id.barsIcon)
    ImageView barsIcon;


    @BindView(R.id.tVSearchhint)
    TextView tVSearchhint;

    private HomeFragmentViewModel homeFragmentViewModel;
    private RecentRecyclerViewAdapter recentRecyclerViewAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, root);

        rvRecent.setOnClickListener(this);
        barsIcon.setOnClickListener(this);
        tVSearchhint.setOnClickListener(this);

        homeFragmentViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        homeFragmentViewModel.getListMutableLiveData().observe(this, recentListUpdateObserver);
        return root;
    }

    private Observer<? super ArrayList<Recent>> recentListUpdateObserver =
            new Observer<ArrayList<Recent>>() {
                @Override
                public void onChanged(ArrayList<Recent> recents) {
                    recentRecyclerViewAdapter = new RecentRecyclerViewAdapter(getContext(), recents);
                    rvRecent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    rvRecent.setAdapter(recentRecyclerViewAdapter);

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
        }
    }


}
