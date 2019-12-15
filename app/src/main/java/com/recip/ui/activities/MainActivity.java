package com.recip.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private static final String TAG = "MainActivity";
    private AppBarConfiguration mAppBarConfiguration;
    public DrawerLayout drawer;
    NavController navController;
    NavigationView navigationView;
    View headerView;
    TextView userNameTextView;

    String byPassName;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpNavigation();

        mAuth = FirebaseAuth.getInstance();

        Menu menu = navigationView.getMenu();
        MenuItem menuItem = menu.findItem(R.id.nav_logout);

        if (mAuth.getCurrentUser() == null) {
            menuItem.setTitle("Login");

            Intent intent = getIntent();
            byPassName = intent.getStringExtra("name");
            Toast.makeText(this, byPassName, Toast.LENGTH_SHORT).show();
            userNameTextView = (TextView) headerView.findViewById(R.id.userNameTextView);
            userNameTextView.setText(byPassName
                    .substring(0, 1).toUpperCase()
                    .concat(byPassName.substring(1).toLowerCase()));

        } else {
            menuItem.setTitle("Logout");
        }

    }

    private void setUpNavigation() {

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_favourites, R.id.nav_profile, R.id.nav_settings, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        Bundle args=new Bundle();
        args.putString("name",byPassName);

        navController.setGraph(R.navigation.mobile_navigation,args);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_icon:
                onSearchRequested();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);

        drawer.closeDrawers();

        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_home:
                Bundle bundle=new Bundle();
                if(userNameTextView !=null) {
                    Timber.e("onNavigationItemSelected: ".concat(userNameTextView.getText().toString()));
                    bundle.putString("name", userNameTextView.getText().toString());
                }
                navController.navigate(R.id.nav_home,bundle);
                break;
            case R.id.nav_favourites:
                navController.navigate(R.id.nav_favourites);
                break;
            case R.id.nav_profile:
                navController.navigate(R.id.nav_profile);
                break;
            case R.id.nav_settings:
                navController.navigate(R.id.nav_settings);
                break;
            case R.id.nav_logout:
                if (menuItem.getTitle().equals("Logout")) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));

                }
                break;
        }

        return false;
    }

    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested();
    }

    @Override
    public void onClick(View v) {

    }
}
