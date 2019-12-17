package com.recip.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Inputs cannot be empty ...", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tVEmailLogin.setError("Invalid Email ...");
            return false;
        }
        else {

            return true;
        }
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Timber.i("signInWithEmail:success");
                            //save info to realm db and let user in
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Timber.i(task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
    }
}
