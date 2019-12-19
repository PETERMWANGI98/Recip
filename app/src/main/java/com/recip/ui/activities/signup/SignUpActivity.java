
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;
import com.recip.ui.activities.LoginActivity;
import com.recip.ui.fragments.SignUpOne;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutSignUp,new SignUpOne());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tVtoLoginButton:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
    }


}
