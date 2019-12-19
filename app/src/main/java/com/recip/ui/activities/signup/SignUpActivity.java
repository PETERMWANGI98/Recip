
package com.recip.ui.activities.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;
import com.recip.realm.models.Recipe;
import com.recip.ui.activities.LoginActivity;
import com.recip.ui.fragments.SignUpOne;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.sentry.Sentry;
import timber.log.Timber;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignUpActivity";


    @BindView(R.id.tVtoLoginButton)
    TextView tVtoLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);


        loadSignUpOneFragment();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    private void loadSignUpOneFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutSignUp, new SignUpOne());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tVtoLoginButton:
                startActivity(new Intent(this, LoginActivity.class));
//                addToRealm();
                break;
        }

    }

    private void addToRealm() {

        //get a realm instance for this thread
        Realm realm = Realm.getDefaultInstance();
        final com.recip.realm.models.Recipe recipe = new com.recip.realm.models.Recipe();
        recipe.setId(12332323);
        recipe.setTitle("Mariana Rice");
        recipe.setDishType("Dessert");
        recipe.setReadyInMinutes(45);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(recipe);
                Snackbar.make(tVtoLoginButton, "Saved to realm", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Recipe recipe1 = realm.where(Recipe.class).equalTo("id", 12332323).findFirst();
                Snackbar.make(tVtoLoginButton, "Retrieved".concat(recipe1.getTitle()), Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


}
