package com.recip.ui.activities.about;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recip.R;
import com.recip.models.About;
import com.recip.ui.adapters.AboutRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AboutUsActivity extends AppCompatActivity implements LifecycleOwner {

    Unbinder unbinder;

    @BindView(R.id.rVAboutUs)
    RecyclerView recyclerView;

    AboutUsActivity context;
    AboutUsViewModel aboutUsViewModel;
    AboutRecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        unbinder= ButterKnife.bind(this);
        context = AboutUsActivity.this;
        aboutUsViewModel = ViewModelProviders.of(context).get(AboutUsViewModel.class);
        aboutUsViewModel.getListMutableLiveData().observe(context, aboutUsListUpdateObserver);

    }

    Observer<ArrayList<About>> aboutUsListUpdateObserver =
            new Observer<ArrayList<About>>() {
                @Override
                public void onChanged(ArrayList<About> abouts) {
                    recyclerViewAdapter = new AboutRecyclerViewAdapter(context, abouts);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            };

}
