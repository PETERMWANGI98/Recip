
package com.recip.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;
import com.recip.ui.fragments.LoginActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.sentry.Sentry;
import io.sentry.event.Breadcrumb;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;
import timber.log.Timber;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignUpActivity";
    @BindView(R.id.etSignUpName)
    EditText etSignUpName;

    @BindView(R.id.etSignUpEmail)
    EditText etSignUpEmail;

    @BindView(R.id.etSignUpPassword)
    EditText etSignUpPassword;

    @BindView(R.id.etSignUpPhone)
    EditText etSignUpPhone;

    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    @BindView(R.id.tVtoLoginButton)
    TextView tVtoLoginButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tVtoLoginButton:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btnSignUp:
                fetchData();
                break;
        }

    }

    private void fetchData() {
        String signUpEmail = etSignUpEmail.getText().toString().trim();
        String signUpPassword = etSignUpPassword.getText().toString().trim();
        signUpUser(signUpEmail, signUpPassword);
    }



    private void signUpUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Timber.i("createUserWithEmail:success");
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Timber.w("createUserWithEmail:failure %s", Objects.requireNonNull(task.getException()).getMessage());
                            Toast.makeText(SignUpActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            Sentry.capture(task.getException());
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            Intent intent = new Intent(this, MainActivityDummy.class);
//            startActivity(intent);
//        }
    }
}
