package com.recip.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
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
        mAuth=FirebaseAuth.getInstance();
    }

    public void initResetPassword() {
        final String emailAddress = etResetEmail.getText().toString().trim();

        mAuth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Password reset link sent to".concat(emailAddress), Toast.LENGTH_LONG)
                            .show();
                } else {
                    Timber.e(task.getException());
                    Toast.makeText(ForgotPasswordActivity.this,
                            "Failed ".concat(Objects.requireNonNull(Objects.requireNonNull(task.getException())
                                    .getLocalizedMessage())), Toast.LENGTH_SHORT).show();
                }

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
