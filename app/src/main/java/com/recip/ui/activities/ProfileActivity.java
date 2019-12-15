package com.recip.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.recip.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.etProfileEmail)
    EditText etProfileEmail;

    @BindView(R.id.etProfilePassword)
    EditText etProfilePassword;

    @BindView(R.id.btnUpdateUser)
    Button btnUpdateUser;

    String email;
    String password;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);

        etProfileEmail.setText(Objects.requireNonNull(mAuth.getCurrentUser()).getEmail(), TextView.BufferType.EDITABLE);
        etProfilePassword.setText("Password",TextView.BufferType.EDITABLE);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUpdateUser) {
            //update user in firebase
            final FirebaseUser firebaseUser = mAuth.getCurrentUser();
            String email = etProfileEmail.getText().toString().trim();
            final String password = etProfilePassword.getText().toString().trim();
            Timber.i(email);
            assert firebaseUser != null;
            firebaseUser.updateEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                              //update password
                                if (!password.isEmpty()) {
                                    firebaseUser.updatePassword(password)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(ProfileActivity.this, "Details Updated", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(ProfileActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                                    }
                                                }
                                            });
                                }

                                Toast.makeText(ProfileActivity.this, "Details Updated", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(ProfileActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mUser = mAuth.getCurrentUser();
        if (mUser == null) {
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
        } else {
            email = mUser.getEmail();
        }
    }
}
