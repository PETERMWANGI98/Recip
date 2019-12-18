package com.recip.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.recip.R;
import com.recip.ui.activities.signup.SignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.toLoginButton)
    Button toLoginButton;

    @BindView(R.id.toSignUpButton)
    Button toSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        toLoginButton.setOnClickListener(this);
        toSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(toLoginButton)) {
            startActivity(new Intent(LauncherActivity.this, LoginActivity.class));
        } else if (v.equals(toSignUpButton)) {
            startActivity(new Intent(LauncherActivity.this, SignUpActivity.class));

        }

    }
}
