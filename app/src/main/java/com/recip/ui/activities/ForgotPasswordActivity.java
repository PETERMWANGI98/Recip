package com.recip.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.constraintForgotUser)
    ConstraintLayout constraintForgotUser;

    @BindView(R.id.etResetEmail)
    EditText etResetEmail;

    @BindView(R.id.btnResetPassword)
    Button btnResetPassword;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
    }

    public void initResetPassword() {
        final String emailAddress = etResetEmail.getText().toString().trim();

        mAuth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Snackbar.make(constraintForgotUser, "Password reset link sent to"
                        .concat(emailAddress), Snackbar.LENGTH_LONG)
                        .show();
                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
            } else {
                Timber.e(task.getException());
                Snackbar.make(constraintForgotUser, task.getException().getMessage()
                        , Snackbar.LENGTH_LONG)
                        .show();
            }

        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnResetPassword) {
            initResetPassword();
        }
    }
}
