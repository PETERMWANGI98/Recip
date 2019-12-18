package com.recip.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.recip.R;
import com.recip.ui.activities.signup.SignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.tVForgotPassword)
    TextView tVForgotPassword;

    @BindView(R.id.constraintLogin)
    ConstraintLayout constraintLogin;

    @BindView(R.id.tVEmailLogin)
    EditText tVEmailLogin;

    @BindView(R.id.tVPasswordLogin)
    EditText tVPasswordLogin;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.buttonSkip)
    Button buttonSkip;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tVForgotPassword:
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.tVtoSignUp:
                Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
                break;
            case R.id.btnLogin:
                fetchData();
                break;
            case R.id.buttonSkip:
                Intent skipIntent = new Intent(LoginActivity.this, NameActivity.class);
                startActivity(skipIntent);
                break;
        }
    }

    private void fetchData() {
        String email = tVEmailLogin.getText().toString().trim();
        String password = tVPasswordLogin.getText().toString().trim();
        if (validateLoginInfo(email, password)) {
            loginUser(email, password);
        }
    }

    private boolean validateLoginInfo(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Snackbar.make(constraintLogin, "Inputs cannot be empty ...", Snackbar.LENGTH_LONG)
                    .show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Snackbar.make(constraintLogin, "Please enter a valid email ...", Snackbar.LENGTH_LONG)
                    .show();
            return false;
        } else {

            return true;
        }
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Timber.i("signInWithEmail:success");

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Timber.i(task.getException());
                        Snackbar.make(constraintLogin, task.getException().getMessage(), Snackbar.LENGTH_LONG)
                                .show();
                    }
                });
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }
}
